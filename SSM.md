# SSM

## Mybatis

### 搭建mybatis

1.  maven构建项目，pom.xml中设置如下：

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <parent>
        <artifactId>SSM_learning</artifactId>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>mybatis_start</artifactId>
    <name>Archetype - mybatis_start</name>
    <url>http://maven.apache.org</url>
    <packaging>jar</packaging>

    <dependencies>
        <!-- Mybatis核心 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.11</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
        <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
            <!-- MySQL驱动 -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.30</version>
            </dependency>
        <!-- log4j日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
    </dependencies>

</project>

```

2. 创建mybatis-config.xml配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "https://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
       <!--设置连接数据库的环境-->
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://localhost:3306/ssm?
   serverTimezone=UTC"/>
                   <property name="username" value="root"/>
                   <property name="password" value="Beta59941093"/>
               </dataSource>
           </environment>
   
       </environments>
       <!--引入映射文件-->
       <mappers>
           <mapper resource="mappers/UserMapper.xml"/>
       </mappers>
   </configuration>
   ```

   3. 创建类和对应mapper接口

      ![image-20221024212340492](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221024212340492.png)

​	UserMapper: 写相应sql操作函数，只需接口就可，不需要实现类

```java
package com.ssm.mybatis.mapper;
public interface UserMapper {
    int insertUser();
}

```

4. 创建映射文件

   

   注意：

   mapper接口的全类名和映射文件的命名空间（namespace）保持一致

   mapper接口中方法的方法名和映射文件中编写SQL的标签的id属性保持一致

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.ssm.mybatis.mapper.UserMapper">
       <!--int insertUser();-->
       <insert id="insertUser">
           insert into user values(null,'aaa','123456',23,'男','aaa@qq.com')
       </insert>
   </mapper>
   ```



### CRUD

**创建SqlSessionUtil:**

1. 从mybatis-config.xml配置文件中获得输入流

2. 创建SqlSessionFactoryBuilder

3. 创建SqlSessionFactory

4. 创建SqlSession

5. 创建mapper接口，使用对应函数  sqlSession.getMapper(xxx.Class)

   或

   使用sqlSession中的函数sqlSession.insert("namespace.sqlID"); (namespace和sqlID都是mapper配置文件中的属性)

```java
package com.ssm.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try {
            //获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
             //获取SqlSessionFactory
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
            //获取sql会话对象sqlSession,是mybatis提供的操作数据库的对象
            sqlSession = factory.openSession(true);
        } catch (IOException e) {
           e.printStackTrace();
        }
        return sqlSession;
    }
}

```

```java
//如何使用sqlSession

//方法1：创建mapper接口，调用其函数
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        int result = mapper.insertUser();

//方法2：
int result = sqlSession.insert("com.ssm.mybatis.mapper.UserMapper.insertUser");
System.out.println("结果： " + result);
//提交事务
//sqlSession.commit();
sqlSession.close();
    

```



**在Mapper接口中实现相应函数，并在mapper配置文件中设置：**

```java
  public interface UserMapper {
        int insertUser();
        int updateUser();
        int deleteUser();
        User getUserById();
    }
```

注意：查询语句select需要设置额外的属性resultType或resultMap

resultType：自动映射，用于类的属性和表中字段名一致的情况。填写相应的类名即可

resultMap：自定义映射，用于一对多或多对一或字段名和属性名不一致的情况

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.ssm.mybatis.mapper.UserMapper">
    <!--int insertUser();-->
    <insert id="insertUser">
        insert into user values(null,'aaa','123456',23,'男','aaa@qq.com')
    </insert>
    <update id="updateUser">
        update user set username='root',password='123' where id=1
    </update>
    <delete id="deleteUser">
        delete from user where id=4
    </delete>
    <!-- 注意resultType或resultMap的设置-->
    <select id="getUserById" resultType="com.ssm.mybatis.pojo.User">
        select * from user where id=1
    </select>

</mapper>

```



### 核心配置文件

核心配置文件中的标签必须按照固定的顺序： properties、settings、typeAliases、typeHandlers、objectFactory、objectWrapperFactory、reflectorFactory、plugins、environments、databaseIdProvider、mappers



#### properties

引入properties文件

```
<!--引入properties文件-->
<properties resource="文件名" />
```



#### 环境environments

注意：样例中的${jdbc.driver}，是通过导入的properties来获取，properties文件中有如下设置：

```properties
jdbc.driver=xxxxx
jdbc.url=xxxx
jdbc.username=xxx
jdbc.password=xxx
...
```



```xml

<!--
    environments：配置多个连接数据库的环境
    属性：
    default：设置默认使用的环境的id
-->
<environments default="development">	
    <!--
        environment：配置某个具体的环境
        属性：
        id：表示连接数据库的环境的唯一标识，不能重复
    -->
    <environment id="development">
        <!--
            transactionManager：设置事务管理方式
            属性：
            type="JDBC|MANAGED"
            JDBC：表示当前环境中，执行SQL时，使用的是JDBC中原生的事务管理方式，事
            务的提交或回滚需要手动处理
            MANAGED：被管理，例如Spring
        -->
        <transactionManager type="JDBC"/>
        <!--
            dataSource：配置数据源
            属性：
            type：设置数据源的类型
            type="POOLED|UNPOOLED|JNDI"
            POOLED：表示使用数据库连接池缓存数据库连接
            UNPOOLED：表示不使用数据库连接池
            JNDI：表示使用上下文中的数据源
        -->
        <dataSource type="POOLED">
            <!--设置连接数据库的驱动-->
            <property name="driver" value="${jdbc.driver}"/>  
            <!--设置连接数据库的连接地址-->
            <property name="url" value="${jdbc.url}"/>
            <!--设置连接数据库的用户名-->
            <property name="username" value="${jdbc.username}"/>
            <!--设置连接数据库的密码-->
            <property name="password" value="${jdbc.password}"/>
        </dataSource>
    </environment>
    <environment id="test">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="url"
            value="jdbc:mysql://localhost:3306/ssmserverTimezone=UTC"/>
            <property name="username" value="root"/>
            <property name="password" value="123456"/>
        </dataSource>
    </environment>
</environments>

```



#### typeAliases设置别名

设置别名后，例如mapper配置文件中select.resultType可设置为此别名  

```
<select id="getUserById" resultType="User">
    select * from user where id=1
</select>
```



```xml
<!--设置类型别名-->
<typeAliases>
    <!--
        typeAlias：设置某个类型的别名
        属性：
        type：设置需要设置别名的类型
        alias：设置某个类型的别名，若不设置该属性，那么该类型拥有默认的别名，即类名
        且不区分大小写
    -->
    <typeAlias type="com.ssm.mybatis.pojo.User" alias="User"></typeAlias>
    <!--以包为单位，将包下所有的类型设置默认的类型别名，即类名且不区分大小写-->
    或 <package name="com.ssm.mybatis.pojo"/>
</typeAliases>
```

重点：

```xml
<typeAlias type="com.ssm.mybatis.pojo.User" alias="User">  <!--别名设置为User -->
<typeAlias type="com.ssm.mybatis.pojo.User"> <!--别名默认设置为类名User -->
<!--以包为单位，将包下所有的类型设置默认的类型别名，即类名且不区分大小写-->
<package name="com.atguigu.mybatis.pojo"/>
```



#### mappers

可通过mapper属性单独引入，也可通过package属性以包为单位引入

```xml
<!--引入映射文件-->
<mappers>
    <!--<mapper resource="mappers/UserMapper.xml"/>-->
        <!--
        以包为单位引入映射文件
        要求：
        1、mapper接口所在的包要和映射文件所在的包一致
        2、mapper接口要和映射文件的名字一致
    -->
<package name="com.atguigu.mybatis.mapper"/>
</mappers>
```

所在包一致，UserMapper名字一致：

![image-20221024233550073](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221024233550073.png)

tips:resources目录下，创建包的时候要这样写，不能写com.ssm.mybatis.mapper，否则创建的不是目录，而是一个单独的文件夹：

![image-20221024233722541](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221024233722541.png)





#### IDEA设置配置文件模板

![image-20221024234345115](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221024234345115.png)