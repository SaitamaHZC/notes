# 常用命令

```shell
rabbitmqctl stop-app		#关闭应用
rabbitmqctl start-app		#启动应用
rabbitmqctl reset			#清除

```





# 简单队列

**简单队列模式**：最简单的工作队列，其中一个消息生产者，一个消息消费者，一个队列。也称为点对点模式

1. maven依赖

   ```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
     <modelVersion>4.0.0</modelVersion>
     <groupId>com.rabbitMQ</groupId>
     <artifactId>rabbitMQ-start</artifactId>
     <version>1.0-SNAPSHOT</version>
     <name>Archetype - rabbitMQ-start</name>
     <url>http://maven.apache.org</url>
   
     <build>
       <plugins>
         <plugin>
           <groupId>org.apache.maven.plugins</groupId>
           <artifactId>maven-compiler-plugin</artifactId>
           <configuration>
             <source>8</source>
             <target>8</target>
           </configuration>
         </plugin>
       </plugins>
     </build>
   
     <dependencies>
       <!--rabbitmq 依赖客户端-->
       <dependency>
         <groupId>com.rabbitmq</groupId>
         <artifactId>amqp-client</artifactId>
         <version>5.8.0</version>
       </dependency>
       <!--操作文件流的一个依赖-->
       <dependency>
         <groupId>commons-io</groupId>
         <artifactId>commons-io</artifactId>
         <version>2.6</version>
       </dependency>
     </dependencies>
   
   </project>
   
   ```

   

2. 生产者流程

   1. 创建连接工厂，设置host,username,password
   2. 创建连接
   3. 创建channel
   4. 使用queueDeclare声明队列
   5. 使用basicPublish发送消息

   ```java
   package com.rabbitMQ.start;
   
   import com.rabbitmq.client.Channel;
   import com.rabbitmq.client.Connection;
   import com.rabbitmq.client.ConnectionFactory;
   
   import java.io.IOException;
   import java.util.concurrent.TimeoutException;
   
   public class Producer {
   
       private static final String QUEUE_NAME = "hello";
   
       public static void main(String[] args) {
           ConnectionFactory factory = new ConnectionFactory();
           factory.setHost("192.168.153.129");
           factory.setUsername("saitama");
           factory.setPassword("z59941093");
   
           try {
               Connection connection = factory.newConnection();
               Channel channel = connection.createChannel();
              n.createChannel()) {
    /**
    *  channel.queueDeclare生成一个队列,第n个参数解释如下：
    * 1.队列名称
    * 2.队列里面的消息是否持久化 默认消息存储在内存中
    * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
    * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
    * 5.其他参数
    */
    channel.queueDeclare(QUEUE_NAME,false,false,false,null);
               String message = "hello mq";
    /**
    * channel.basicPublish发送一个消息，第n个参数解释如下：
    * 1.发送到那个交换机
    * 2.路由的 key 是哪个
    * 3.其他的参数信息
    * 4.发送消息的消息体
    */ channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
               System.out.println("已发送");
   
           } catch (IOException e) {
               throw new RuntimeException(e);
           } catch (TimeoutException e) {
               throw new RuntimeException(e);
           }
   
       }
   }
   ```



3. 消费者流程

   1. 创建连接工厂，设置host,username,password
   2. 创建连接
   3. 创建channel
   4. 使用basicConsume接收消息

   

   ```java
   package com.rabbitMQ.start;
   
   import com.rabbitmq.client.*;
   
   import java.io.IOException;
   import java.util.concurrent.TimeoutException;
   
   public class Consumer {
       private static final String QUEUE_NAME = "hello";
   
       public static void main(String[] args) {
           ConnectionFactory factory = new ConnectionFactory();
           factory.setHost("192.168.153.129");
           factory.setUsername("saitama");
           factory.setPassword("z59941093");
           try {
               Connection connection = factory.newConnection();
               Channel channel = connection.createChannel();
               //使用lambda表达式
               DeliverCallback deliverCallback = (consumerTag,message) -> {
                   System.out.println(new String(message.getBody()));
               };
               CancelCallback cancelCallback = (consumerTag) -> {
                   System.out.println("消费消息中断");
               };
               /**
    * channel.basicConsume消费者消费消息
    * 1.消费哪个队列
    * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
    * 3.消费者未成功消费的回调
    */
   			channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
   
           } catch (IOException e) {
               throw new RuntimeException(e);
           } catch (TimeoutException e) {
               throw new RuntimeException(e);
           }
       }
   }
   
   ```



# 工作队列

工作队列：用来将耗时的任务分发给多个消费者（工作者）

主要解决问题：处理资源密集型任务，并且还要等他完成。有了工作队列，我们就可以将具体的工作放到后面去做，将工作封装为一个消息，发送到队列中，一个工作进程就可以取出消息并完成工作。如果启动了多个工作进程，那么工作就可以在多个进程间共享



![image-20230516201726686](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230516201726686.png)





## 轮训分发消息

创建一个生产者，发送十条消息

创建两个消费者（worker），会**轮训接收**消息



![image-20230516204752414](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230516204752414.png)

![image-20230516204801149](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230516204801149.png)