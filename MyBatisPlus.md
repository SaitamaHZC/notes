## MyBatisPlus



# 引入

1. 创建springboot工程，引入maven依赖

```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!--	  mybatis	-->
		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus-boot-starter</artifactId>
			<version>3.5.1</version>
		</dependency>
		<!--		lombok-->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<!--		mysql驱动-->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
			<version>8.0.27</version>
		</dependency>
	</dependencies>
```



2. 配置application

```yml
spring: 	
  datasource:			
    type: com.zaxxer.hikari.HikariDataSource			#datasource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false
    username: root
    password: z59941093

mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl	#开启显示sql语句
```



3. 在Spring Boot启动类（@SpringBootApplication）   中添加@MapperScan注解，扫描mapper包  

```java
@SpringBootApplication
@MapperScan("com.mbp.mapper")
public class MbpApplication {
	public static void main(String[] args) {
		SpringApplication.run(MbpApplication.class, args);
	}
}
```







# Mapper

MBP提供模板mapper ------ BaseMapper接口 ，封装好了基本的CRUD方法

![image-20230207133550708](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230207133550708.png)



使用时，创建一个自己的mapper接口继承BaseMapper接口，注意添加@Repository注解放入容器

```java
@Repository
public interface UserMapper extends BaseMapper<User> {
}

```





## CRUD测试

```java
@SpringBootTest
public class mbptest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(10);
        user.setEmail("aasdasd@qq.com");
        user.setName("张三");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testDelete(){
        //通过直接输入id删除，id太长，需要在最后加一个L表示long
        int i = userMapper.deleteById(1622543155985465346L);
        System.out.println(i);
        //通过map删除,map<字段名,value>
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","10");
        int i1 = userMapper.deleteByMap(map);
        System.out.println(i1);
        //通过多个id实现批量删除
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        int i2 = userMapper.deleteBatchIds(longs);
        System.out.println(i2);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setAge(100);
        System.out.println(userMapper.updateById(user));
    }


    @Test
    public void testSelect(){
//        //单个id查询
//        User user = userMapper.selectById(4L);
//        System.out.println(user);

//        //多个id查询
//        List<Long> longs = Arrays.asList(4L, 5L);
//        List<User> users = userMapper.selectBatchIds(longs);
//        System.out.println(users);

//        //根据map集合，作为条件进行查询
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","Sandy");
//        map.put("age",100L);
//        List<User> users1 = userMapper.selectByMap(map);

//        //list查询
//        List<User> users = userMapper.selectList(null);
//        System.out.println(users);


        //自定义查询
        Map<String, Object> map = (Map<String, Object>) userMapper.selectMapById(4L);
        System.out.println(map);
    }
}

```



## 自定义查询

同mybatis，首先需要创建与mapper同名的xml配置文件

![image-20230207134039144](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230207134039144.png)

配置查询语句

```xml
<mapper namespace="com.mbp.mapper.UserMapper">
    <select id="selectMapById" resultType="map">
        select id,name,age,email from user where id = #{id}
    </select>
</mapper>
```

通过mapper接口使用

```java

  @Test
    public void testSelect(){
        //自定义查询
        Map<String, Object> map = (Map<String, Object>) userMapper.selectMapById(4L);
        System.out.println(map);
    }
```





# Service

MBP提供了通用Service------ IService接口，以及该接口的实现类ServiceImpl  



提供的方法：

![image-20230207135026406](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230207135026406.png)





使用：

1. 创建service接口继承IService

```java
public interface UserService extends IService<User> {
}
```

2. 创建该接口的实现类，并继承ServiceImpl

```java
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
```



3. 测试

```java
@SpringBootTest
public class mbpServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println(count);
    }
    //批量添加
    @Test
    public void testInsertMore(){
        List<User> userList = new ArrayList<>();
        for(int i =0 ;i<10;i++){
            User user = new User();
            user.setName("aaa" + i);
            user.setAge(20+i);
            userList.add(user);
        }
        userService.saveBatch(userList);
    }
}
```







# 常用注解

## @TableName

MyBatis-Plus在确定操作的表时，由BaseMapper的泛型决定，即实体类型决定，且默认操作的表名和实体类型的类名一致。

当实体类类名与表名不一致时，**在实体类上添加**该注解设置表名

```java
@Data
@TableName("user") //设置实体类对应的表名
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```



## 全局设置表名

当所有表都遵循相同命名规则时，可在配置文件中使用全局设置，不用单个使用@TableName一个一个配置

```yml
mybatis-plus:
  global-config:
    db-config:
      table-prefix: t_   #设置前缀
```







## @TableId

MyBatis-Plus在实现CRUD时，会默认将名为id的字段作为主键列，并在插入数据时，默认基于雪花算法的策略生成id 。**若实体类和表中表示主键的不是id，而是其他字段，此时mbp无法识别主键**



@TableId 将指定实体类的属性作为表的主键

```java
@Data
@TableName("user") //设置实体类对应的表名
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```



**value属性：**

@TableId (value = xxx) 当实体类属性名和字段名不一致，用**value**属性设置 

![image-20230207141034224](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230207141034224.png)

```java
   @TableId(value = "uid")
    private Long id;
```



**type属性：**

定义主键策略

![image-20230207141331350](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230207141331350.png)

| IdType.ASSIGN_ID（默 认） | 基于雪花算法的策略生成数据id，与数据库id是否设置自增无关     |
| ------------------------- | ------------------------------------------------------------ |
| IdType.AUTO               | 使用数据库的自增策略，注意，该类型请确保数据库设置了id自增， 否则无效 |





## 全局设置主键策略

```yml
mybatis-plus:
  global-config:
    db-config:
      id-type: auto
```





## @TableField

当实体类中的属性名和字段名不一致  ：

1. 实体类使用驼峰命名法，字段名使用下划线命名法，**mbp会自动转换**
2. 不满足情况1，需要用到@TableField设置对应字段名



```java
@Data
@TableName("user") //设置实体类对应的表名
public class User {
    @TableId(value = "uid")			
    private Long id;   //id对应字段uid
    private String userName;
    private Integer age;
    private String email;
}
```





## @TableLogic

物理删除：真实删除，将对应数据从数据库中删除，之后查询不到此条被删除的数据

逻辑删除：假删除，将对应数据中代表是否被删除字段的状态修改为“被删除状态”，之后在数据库中仍旧能看到此条数据记录

使用场景：可以进行数据恢复  



实现逻辑删除：

1. 数据库中创建逻辑删除状态字段，设置默认值为0  

   ![image-20230207144233375](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230207144233375.png)

   

2. 实体类中添加逻辑删除属性  

```java
@Data
@TableName("user") 
public class User {

    @TableId(value = "uid")
    private Long id;
    private String userName;
    private Integer age;
    private String email;

    @TableLogic
    private Integer isDeleted;		//逻辑删除属性


}
```



3. 如上设置以后，使用mapper的delete功能，实际执行的会是update，将is_deleted改为1

```sql
测试删除功能，真正执行的是修改
UPDATE t_user SET is_deleted=1 WHERE id=? AND is_deleted=0
测试查询功能，被逻辑删除的数据默认不会被查询
SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0  
```









# Wrapper



lambda表达式：https://baomidou.com/pages/10c804/#abstractwrapper





## CRUD函数中wrapper的使用

**select：**

```java
//用到wrapper的select函数：


// 根据 entity 条件，查询一条记录
T selectOne(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
// 查询（根据ID 批量查询）
List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
// 根据 entity 条件，查询全部记录
List<T> selectList(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
// 根据 Wrapper 条件，查询全部记录
List<Map<String, Object>> selectMaps(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
// 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
List<Object> selectObjs(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
// 根据 entity 条件，查询全部记录（并翻页）
IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
// 根据 Wrapper 条件，查询全部记录（并翻页）
IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
// 根据 Wrapper 条件，查询总记录数
Integer selectCount(@Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
```





```java
 @Test
    public void testWapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                .between("age",20,30);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testWapper02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }
```







**update:**

```java

// 根据 UpdateWrapper 条件，更新记录 需要设置sqlset
boolean update(Wrapper<T> updateWrapper);
// 根据 whereWrapper 条件，更新记录
boolean update(T updateEntity, Wrapper<T> whereWrapper);

```

```java
 @Test
    public void testWapper03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

```



**delete:**

```java
// 根据 entity 条件，删除记录
int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
```

```java
@Test
    public void testWapper04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email")
                .or()
                .like("user_name","a");
        User user = new User();
        user.setEmail("aaa@xxx.com");

        int update = userMapper.update(user,queryWrapper);
        System.out.println(update);
    }
```





**and()使用方法：**

lambda表达式内的逻辑优先运算

```java

//将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
//UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND (age > ? OR email IS NULL))
//lambda表达式内的逻辑优先运算
    
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
queryWrapper
    .like("username", "a")
	.and(i -> i.gt("age", 20).or().isNull("email"));
User user = new User();
user.setAge(18);
user.setEmail("user@atguigu.com");
int result = userMapper.update(user, queryWrapper);
System.out.println("受影响的行数：" + result);
```



**设置查询字段 .select()：**

```java
QueryWrapper<User> queryWrapper = new QueryWrapper<>();
queryWrapper.select("user_name","age","email");

List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
maps.forEach(System.out::println);
```





 **子查询 .insql()：**

```java
//inSql(R column, String inValue)
//inSql(boolean condition, R column, String inValue)

例子：
inSql("age", "1,2,3,4,5,6")--->age in (1,2,3,4,5,6)
inSql("id", "select id from table where id < 3")--->id in (select id from table where id < 3)
```









## 组装条件condition

 不同情况下可能需要组装不同的条件，如下：

```java
if(xxx){
	querywrapper.gt("xxx",100)
}else if(xxx){
	querywrapper.lt("xxx",1000)
}

```



mbp提供了condition参数，如：

```java
eq(boolean condition, R column, Object val)
gt(boolean condition, R column, Object val)
```



例：

```java
@Test
    public void testWapper07(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Integer ageMin = 0;
        Integer ageMax = 100;
        queryWrapper.lt(ageMin != null,"age",100)
                .gt(ageMax != null,"age",0);

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

```







## LambdaQueryWrapper/UpdateWrapper



LambdaQueryWrapper：

![image-20230209083845335](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230209083845335.png)

格式：对象::getXXX

```java
  queryWrapper.lt(ageMin != null,User::getAge,100)
                .gt(ageMax != null,User::getAge,0);
```



LambdaUpdateWrapper:

```java
lambdaUpdateWrapper.set(User::getUserName,"某某")
        .set(User::getAge,10)
        .lt(ageMin != null,User::getAge,100)
        .or(i-> i.gt(ageMax != null,User::getAge,0));
```







# 插件





## 分页插件



1. 配置(springboot)

   创建配置类

   ```java
    	@Configuration
   @MapperScan("com.mbp.mapper")
   public class mbpConfig {
   
       @Bean
       public MybatisPlusInterceptor mybatisPlusInterceptor(){
           MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
           mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
           return mybatisPlusInterceptor;
       }
       
   }
   ```



2. 使用：

   ```java
    @Test
       public void testPage(){
           Page<User> page = new Page<User>(1, 5);		//查看第一页，一页五条
           //current为要查看的页数，size为一页的数据数
           userMapper.selectPage(page,null);
           List<User> list = page.getRecords();
   
           list.forEach(System.out::println);
   
           System.out.println("当前页："+page.getCurrent());
           System.out.println("每页显示的条数："+page.getSize());
           System.out.println("总记录数："+page.getTotal());
           System.out.println("总页数："+page.getPages());
           System.out.println("是否有上一页："+page.hasPrevious());
           System.out.println("是否有下一页："+page.hasNext());
       }
   ```

   

自定义分页：

1. 在mapper中自定义函数

   ```java
    Page<User> selectPageByAge(@Param("page") Page page,@Param("age") Integer age);
   ```

2. mapper.xml中设置

```xml
<!--Page<User> selectPageByAge(@Param("page") Page page,@Param("age") Integer age); -->
    <select id="selectPageByAge" resultType="User"> <!-- 这里的User是别名，不是全称，需要设置别名-->
        select * from user where age > #{age}
    </select>
```



3. 顺便设置别名

```yml
mybatis-plus:
  type-aliases-package: com.mbp.pojo
```



4. 测试

```java
  @Test
    public void testPageVo(){
        Page<User> page = new Page<User>(1, 5);
        userMapper.selectPageByAge(page,10);

        List<User> list = page.getRecords();

        list.forEach(System.out::println);

        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }
```







## 乐观锁



1. 配置（springboot）

```java
 @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));   //加入分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());//加入乐观锁插件
        return mybatisPlusInterceptor;

    }
```



2. 在实体类的版本字段上添加version注释

```java
@Data
@TableName("t_product")
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}

```



![image-20230209182450203](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20230209182450203.png)





# 通用枚举



1. @EnumValue声明通用枚举属性

```java
@Getter
public enum SexEnum {
    MALE(1,"男"),FEMALE(2,"女");


    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}

```



2. mbp3.5.2后无需全局配置





测试：

```java
  @Test
    public void testEnum(){
        User user = new User();
        user.setUserName("test");
        user.setAge(8);
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
```







# 代码生成器

1. 安装依赖

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>最新版本</version>
</dependency>

<!-- 还需要引入mbp包-->
```



2. 快速生成模板

```java
package com.mbp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false",
                        "root", "z59941093")
                .globalConfig(builder -> {
                    builder.author("saitama") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("mbp") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

```







# 多数据源



1. 引入依赖

```xml
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
  <version>${version}</version>
</dependency>
```





2. 全局配置

```yml
spring:
  datasource:
#    type: com.zaxxer.hikari.HikariDataSource
#    driver-class-name: com.mysql.cj.jdbc.Driver
#    url: jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false
#    username: root
#    password: z59941093

#以下是多数据源配置,这里配置了同一个数据库的不同database
    dynamic:
      primary: master #设置默认的数据源或者数据源组,默认值即为master
      strict: false #严格匹配数据源,默认false. true未匹配到指定数据源时抛异常,false使用默认数据源
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false
          username: root
          password: z59941093
          driver-class-name: com.mysql.cj.jdbc.Driver # 3.2.0开始支持SPI可省略此配置
        slave_1:
          url: jdbc:mysql://localhost:3306/mybatis_plus_1?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false
          username: root
          password: z59941093
          driver-class-name: com.mysql.cj.jdbc.Driver

```





3. 使用@DS切换数据源

**@DS** 可以注解在方法上或类上，**同时存在就近原则 方法上注解 优先于 类上注解**。

没有@DS，就使用默认数据源



```java
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
```

```java
@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
```

```java
@SpringBootTest
public class DynamicDataSourceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));
    }
}

```







# MybatisX

https://baomidou.com/pages/ba5b24/#%E5%8A%9F%E8%83%BD

https://www.bilibili.com/video/BV12R4y157Be?p=55&vd_source=68d1b9041a3bd1847a9d38d6b7ff86f2
