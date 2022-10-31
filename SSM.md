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

   mapper接口的全类名和映射文件的命名 空间（namespace）保持一致

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





### 设置sql参数

MyBatis获取参数值的两种方式：${}和#{}

${}的本质就是字符串拼接，#{}的本质就是占位符赋值

**${}**若为**字符串类型或日期类型**的字段进行赋值时，需要**手动加单引号**

1. 设置单个参数

   Mapper:

   ```
    User getUserByUserName(String name);
   ```

   ```xml
   <select id="getUserByUserName" resultType="User">
       <!--User getUserByUserName(String name);-->
           select * from user where username=#{username}
   </select>
   ```

   

2. 设置多个参数

   以arg0,arg1...为键，以参数为值

   或以 param1,param2...为键

   ```
   User checkLogin(String username,String password);
   ```

   ```xml
   <select id="checkLogin" resultType="User">
           <!--void checkLogin(String username,String password);-->
           select * from user where username=#{arg0} and password=#{arg1}
       </select>
   ```

3. map类型参数

   手动创建map传参，并设置对应键

   ```java
    User checkLoginByMap(Map<String,Object> map);
   ```

   ```xml
    <select id="checkLoginByMap" resultType="User">
           <!--User checkLoginByMap(Map<String,Object> map);-->
           select * from user where username=#{键1} and password=#{键2}
       </select>
   ```

4. 实体类类型参数

   使用#{属性名}  ${属性名}访问实体对象的属性名

   ```java
   void insertUser(User user);
   ```

```xml
 <insert id="insertUser">
<!--         void insertUser(User user);-->
        insert into user values(null,#{username},#{password},#{age},#{gender},#{email})
    </insert>
```



5. **@Param注解设置key（常用）**

   手动设置注解，即可免去手动创建map类、设置键

   ```java
   User checkLoginByParam(@Param("username") String username, @Param("password") String password);
   
   格式： (@Param("key")) value
   ```

   ```xml
   <select id="checkLoginByParam" resultType="User">
           <!-- User checkLoginByParam(String username,String password);-->
           select * from user where username=#{username} and password=#{password}
       </select>
   ```

   

### 查询

1. 查询单体对象

   返回值设置为该对象。

   mapper配置中，reultType为该对象。

   

2. 查询对象集合

   返回值设置为该对象的List。

   mapper配置中，reultType为该对象。

   

3. 查询单个数据

   返回值设置为该数据类型。

   mapper配置中，reultType为该数据类型Alias别称。

   ![image-20221026112157936](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221026112157936.png)

   ![image-20221026112206614](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221026112206614.png)

   

4. 查询一条数据，形成map

   返回值设置为Map<>(Map<String,Object>)

   mapper配置中，reultType为map。

   

5. 查询多条数据，形成map集合

   返回值设置为List<Map<>>

   **或使用注解@MapKey(" ")**

   ```java
   //一条数据一个map，最终把所有map放入更大的map中，@MapKey(" ")括号中设置的是更大map的key 
   @MapKey("id")
    Map<String,Object> getAllUserByIdToMap();
   ```

   mapper配置中，reultType为map。





### 特殊sql

#### 模糊查询

不能直接使用#{}。#{}为占位符赋值符号？

```sql
 select * from user where username like "%#{mohu}%"
 会被解析成
  select * from user where username like "%？%"
 而?处于字符串中，不会被识别为待传参的对象
 报错：Parameter index out of range (1 > number of parameters, which is 0).
```

解决方法：

1. 使用${}，字符串拼接传参

2. concat字符串拼接

   ```sql
   select * from user where username like concat('%',#{mohu},'%')
   ```

3. **常用：**  

   ```sql
   select * from user where username like "%"#{mohu}"%"
   ```






#### 批量删除

#{}占位符赋值会在形成的sql语句中自动加单引号‘’

因此需要用${}传参

```sql
delete from table where id in(....)

delete from user where id in (${ids})
 
//传参： int num = mapper.deleteUsers("5,6");
//sql： delete from user where id in (5,6)
```



#### 动态设置表名

#{}占位符赋值会在形成的sql语句中自动加单引号‘’

因此需要用${}传参

```sql
方法：List<User> getAllUser(@Param("tableName") String tableName);
```

```xml
配置：
<select id="getAllUser" resultType="User">
	select * from ${tableName}
</select>

```





#### 获取自增主键

两个属性：

```xml
useGeneratedKeys：设置使用自增的主键 
keyProperty：设置将自增主键放入哪个对象属性中。
（因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参数user对象的某个属性中。）
```

```xml
<insert id="insertUser" useGeneratedKeys="true" keyProperty="id">
<!--        int insertUser(User user);-->
        insert into user values(null,#{username},#{password},#{age},#{gender},#{email})
    </insert>
```





### 自定义映射ResultMap

当**sql字段名**和**对象属性名**不同时：

1. 在sql语句中，为字段起别名，别名与对象属性名字一致

   ```sql
   select emp_id,emp_name empId,empName from emp where emp_id=#{id}
   ```

2. 在MyBatis的核心配置文件中设置一个全局配置信息mapUnderscoreToCamelCase，可 以在查询表中数据时，自动将_类型的字段名转换为驼峰

   ```xml
    <settings>
           <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
   
   ```

3. resultMapper设置自定义映射

   属性type：映射的对象名

   子标签id：设置主键的映射关系

   ​           result：设置普通字段的映射关系

   coloum：字段名

   properties：对象属性名

   ```xml
   <resultMap id="EmpResultMap" type="Emp">
           <id column="emp_id" property="empId"></id>
           <result column="emp_name" property="empName"></result>
   </resultMap>
   
    <select id="getEmpById" resultMap="EmpResultMap">
   <!--        getEmpById-->
           select emp_id,emp_name,age,gender from emp where emp_id=#{id}
    </select>
   ```

   

### 多对一映射

多个员工（员工集合）对应一个部门

对一-------------对对象

对多-------------对集合



现有部门表：

![image-20221027003832745](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221027003832745.png)

员工表：

![image-20221027003851333](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221027003851333.png)

要根据emp_id查一名员工的所有信息+部门名（dept_name）：

#### 1.级联处理

```xml
<resultMap id="EmpResultMapOne" type="Emp">
        <id column="emp_id" property="empId"></id>
        <result column="emp_name" property="empName"></result>
        <result column="age" property="age"></result>
        <result column="gender" property="gender"></result>
        <result column="dept_id" property="dept.deptId"></result>
        <result column="dept_name" property="dept.deptName"></result>
</resultMap>

 <select id="getEmpAndDeptById" resultMap="EmpResultMapOne">
        <!--        getEmpAndDeptById-->
        select
        t_emp.*,t_dept.*
        from t_emp
        left join t_dept
        on t_emp.dept_id = t_dept.dept_id
        where t_emp.emp_id = #{id}
    </select>
```



#### 2.association

association处理多对一的映射关系，处理实体类属性

```xml
<resultMap id="EmpResultMapTwo" type="Emp">
        <id column="emp_id" property="empId"></id>
        <result column="emp_name" property="empName"></result>
        <result column="age" property="age"></result>
        <result column="gender" property="gender"></result>
        <!--        <result column="dept_id" property="dept.deptId"></result>-->
        <!--        <result column="dept_name" property="dept.deptName"></result>-->
        <association property="dept" javaType="Dept">
            <id column="dept_id" property="deptId"></id>
            <result column="dept_name" property="deptName"></result>
        </association>
</resultMap>

<select id="getEmpAndDeptById" resultMap="EmpResultMapTwo">
    <!--        getEmpAndDeptById-->
    select
    t_emp.*,t_dept.*
    from t_emp
    left join t_dept
    on t_emp.dept_id = t_dept.dept_id
    where t_emp.emp_id = #{id}
</select>
```

```xml
详解：
 <association property="dept" javaType="Dept">
     property中的dept:Emp对象中的dept属性
	javaType中的Dept:Dept类
     <id column="dept_id" property="deptId"></id>
     property中的deptId：Dept对象的属性
     column中的dept_id:数据库表的字段名
     <result column="dept_name" property="deptName"></result>
</association>

```

和级联处理的差异：

级联处理：直接通过dept.xxx 与字段进行映射

association: （像封装了一下？）先将对象的属性（dept）与对应类（Dept）联系起来，再将类的属性和字段名进行映射



#### 3.分步查询

通过association中设置属性值select实现。

```xml
<resultMap id="empDeptStepMap" type="Emp">
    <id column="eid" property="eid"></id>
    <result column="ename" property="ename"></result>
    <result column="age" property="age"></result>
    <result column="sex" property="sex"></result>
    <!--
    select：设置分步查询，查询某个属性的值的sql的标识（namespace.sqlId）
    column：将sql以及查询结果中的某个字段设置为分步查询的条件
    -->
    <association property="dept"
    select="com.atguigu.MyBatis.mapper.DeptMapper.getEmpDeptByStep" column="did">
    </association>
</resultMap>
<!--Emp getEmpByStep(@Param("eid") int eid);-->
<select id="getEmpByStep" resultMap="empDeptStepMap">
    select * from t_emp where eid = #{eid}
</select>	
```

简单概括实现过程：

```
先执行 select * from t_emp where eid = #{eid}，查员工表

根据查出来的员工表的某个字段作为条件（传参），查部门表   // column：将sql以及查询结果中的某个字段设置为分步查询的条件

这里是把查出来的员工的部门did作为参数，拿去查对应部门信息
```

分步查询的优点：可以实现延迟加载 



**延迟加载：在真正使用数据的时候才发起查询，不用的时候不查询。也就是按需加载（[懒加载](https://so.csdn.net/so/search?q=懒加载&spm=1001.2101.3001.7020)），主要是针对于一对多，多对多关系**

**立即加载：不管用不用该数据，只要方法被调用，马上发起查询。主要是针对于一对一，多对一关系**



**全局设置延迟加载：**在核心配置文件中设置全局配置信息：

```xml
 <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <setting name="lazyLoadingEnabled" value="true"/>
        <setting name="aggressiveLazyLoading" value="false"/>
    </settings>
```

lazyLoadingEnabled：延迟加载的全局开关。当开启时，所有关联对象都会延迟加载 

aggressiveLazyLoading：当开启时，任何方法的调用都会加载该对象的所有属性。否则，每个属 性会按需加载 

**所以，延迟加载时，lazyLoadingEnabled=true，aggressiveLazyLoading=false**



**单独设置延迟加载**：通过association和 collection中的fetchType属性设置当前的分步查询是否使用延迟加载， fetchType="lazy(延迟加 载)|eager(立即加载)"

```xml
 <association property="dept" javaType="Dept" fetchType="lazy">
        
</association>
```



### 一对多映射

一个部门对应多个员工



#### 1.collection

```
ofType：
因为是一对多，查员工查出来的是一个集合（List、...），javaType没有意义
ofType表示集合中的对象类型
```

```xml
<resultMap id="getDeptAndEmpByIdMap" type="Dept">
        <id column="dept_id" property="deptId"></id>
        <result column="dept_name" property="deptName"></result>
        <collection property="emps" ofType="Emp">
            <id column="emp_id" property="empId"></id>
            <result column="emp_name" property="empName"></result>
            <result column="age" property="age"></result>
            <result column="gender" property="gender"></result>
        </collection>
    </resultMap>

    <select id="getDeptAndEmpById" resultMap="getDeptAndEmpByIdMap" >
        select *
        from t_dept
        left join t_emp
        on t_dept.dept_id = t_emp.dept_id
        where t_dept.dept_id = #{id}
    </select>
```



#### 2.分布查询

与多对一相同

```xml
<resultMap id="getDeptAndEmpByStepMap" type="Dept">
    <id column="dept_id" property="deptId"></id>
    <result column="dept_name" property="deptName"></result>
    <collection property="emps" select="com.ssm.mybatis.mapper.EmpMapper.getEmpByDeptId" column="dept_id">
    </collection>
</resultMap>

<select id="getDeptAndEmpByStep" resultMap="getDeptAndEmpByStepMap">
    select * from t_dept where t_dept.dept_id = #{id}
</select>
```



### 动态sql

除了能动态传参，还需要能对sql的结构进行动态修改。用到以下几个标签

#### if

if标签可通过test属性的表达式进行判断，若表达式的结果为true，则标签中的内容会执行；反之 标签中的内容不会执行

```xml
 <select id="getEmpByCondition" resultType="Emp">
        select * from t_emp where
        <if test="empName != null and empName != ''">
            emp_name = #{empName}
        </if>

        <if test="age != null and age != ''">
            and age = #{age}
        </if>

        <if test="gender != null and gender != ''">
            and gender = #{gender}
        </if>

    </select>
```



#### where

```
where和if一般结合使用：
 a>若where标签中的if条件都不满足，则where标签没有任何功能，即不会添加where关键字
 b>若where标签中的if条件满足，则where标签会自动添加where关键字，并将条件最前方多余的 and去掉 
 注意：where标签不能去掉条件最后多余的and
```

```xml
<select id="getEmpListByMoreTJ2" resultType="Emp">
    select * from t_emp
    <where>
        <if test="ename != '' and ename != null">
            ename = #{ename}
        </if>
        <if test="age != '' and age != null">
            and age = #{age}
        </if>
        <if test="sex != '' and sex != null">
            and sex = #{sex}
        </if>
    </where>
</select>
```



#### trim

```
trim用于去掉或添加标签中的内容
常用属性：
prefix：在trim标签中的内容的前面添加某些内容
prefixOverrides：在trim标签中的内容的前面去掉某些内容
suffix：在trim标签中的内容的后面添加某些内容
suffixOverrides：在trim标签中的内容的后面去掉某些内容
```

```xml
<select id="getEmpListByMoreTJ" resultType="Emp">
    select * from t_emp
    <trim prefix="where" suffixOverrides="and">
        <if test="ename != '' and ename != null">
            ename = #{ename} and
        </if>
        <if test="age != '' and age != null">
            age = #{age} and
        </if>
        <if test="sex != '' and sex != null">
            sex = #{sex}
        </if>
    </trim>
</select>
```



#### choose / when / otherwise

```xml
<!--List<Emp> getEmpListByChoose(Emp emp);-->
<select id="getEmpListByChoose" resultType="Emp">
    select <include refid="empColumns"></include> from t_emp
    <where>
        <choose>
        	<when test="ename != '' and ename != null">
       			 ename = #{ename}
        	</when>
        	<when test="age != '' and age != null">
            	age = #{age}
            </when>
            <when test="sex != '' and sex != null">
          		sex = #{sex}
            </when>
            <when test="email != '' and email != null">
            	email = #{email}
            </when>
        </choose>
    </where>
</select>
```



#### foreach

```
属性：
collection:设置要循环的数组或集合
item:用一个字符串表示数组或集合中的每一个数据
separator:设置每次循环的数据之间的分隔符
open:循环的所有内容以什么开始
close:循环的所有内容以什么结束
```

```xml
<!--    void insertEmps(@Param("emps") List<Emp> emps);-->
    <insert id="insertEmps">
        insert into t_emp values
        <foreach collection="emps" item="emp" separator=",">
            (null,#{emp.empName},#{emp.age},#{emp.gender},null)
        </foreach>
    </insert>

```



### 缓存

#### 一级缓存（默认开启）

一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问 

使一级缓存失效的四种情况：

1) 不同的SqlSession对应不同的一级缓存 

2) 同一个SqlSession但是查询条件不同

3) 同一个SqlSession两次查询期间执行了任何一次增删改操作 

4) 同一个SqlSession两次查询期间手动清空了缓存 

   ```java
    sqlSession.clearCache();
   ```



#### 二级缓存

```
二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取

二级缓存开启的条件：
a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
b>在映射文件中设置标签<cache/>
c>二级缓存必须在SqlSession关闭或提交之后有效
(SqlSession若没有关闭提交，结果会存放在一级缓存中)
d>查询的数据所转换的实体类类型必须实现序列化的接口
public class Emp implements Serializable {}

使二级缓存失效的情况：
两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
```

相关配置：

```
在mapper配置文件中添加的cache标签可以设置一些属性：

①eviction属性：缓存回收策略，默认的是 LRU。
LRU（Least Recently Used） – 最近最少使用的：移除最长时间不被使用的对象。
FIFO（First in First out） – 先进先出：按对象进入缓存的顺序来移除它们。
SOFT – 软引用：移除基于垃圾回收器状态和软引用规则的对象。
WEAK – 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。

②flushInterval属性：刷新间隔，单位毫秒
默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新

③size属性：引用数目，正整数
代表缓存最多可以存储多少个对象，太大容易导致内存溢出

④readOnly属性：只读， true/false
true：只读缓存；会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了 很重要的性能优势。
false：读写缓存；会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是
false。
```



#### 缓存查询顺序

二级缓存中存放的数据多、广 

二级 >> 一级 >>数据库



#### 整合第三方EHcache

略



### 逆向工程

1. pol.xml添加依赖

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
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter</artifactId>
               <version>5.8.1</version>
               <scope>test</scope>
           </dependency>
           <dependency>
               <groupId>org.junit.jupiter</groupId>
               <artifactId>junit-jupiter</artifactId>
               <version>5.8.1</version>
               <scope>test</scope>
           </dependency>
   
       </dependencies>
   
       <!-- 控制Maven在构建过程中相关配置 -->
       <build>
           <!-- 构建过程中用到的插件 -->
           <plugins>
               <!-- 具体插件，逆向工程的操作是以构建过程中插件形式出现的 -->
               <plugin>
                   <groupId>org.mybatis.generator</groupId>
                   <artifactId>mybatis-generator-maven-plugin</artifactId>
                   <version>1.3.0</version>
                   <!-- 插件的依赖 -->
                   <dependencies>
                       <!-- 逆向工程的核心依赖 -->
                       <dependency>
                           <groupId>org.mybatis.generator</groupId>
                           <artifactId>mybatis-generator-core</artifactId>
                           <version>1.3.2</version>
                       </dependency>
                       <!-- MySQL驱动 -->
                       <dependency>
                           <groupId>mysql</groupId>
                           <artifactId>mysql-connector-java</artifactId>
                           <version>8.0.30</version>
                       </dependency>
                   </dependencies>
               </plugin>
           </plugins>
       </build>
   </project>
   
   ```

2. 创建mybatis-config核心配置文件

3. 创建generator-config配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE generatorConfiguration
           PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
           "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
   <generatorConfiguration>
       <!--
       targetRuntime: 执行生成的逆向工程的版本
       MyBatis3Simple: 生成基本的CRUD（清新简洁版）
       MyBatis3: 生成带条件的CRUD（奢华尊享版）
       -->
       <context id="DB2Tables" targetRuntime="MyBatis3">
           <!-- 数据库的连接信息 -->
           <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                           connectionURL="jdbc:mysql://localhost:3306/ssm?
   serverTimezone=UTC"
                           userId="root"
                           password="Beta59941093">
           </jdbcConnection>
           <!-- javaBean的生成策略-->
           <javaModelGenerator targetPackage="com.ssm.mybatis.pojo"
                               targetProject=".\src\main\java">
           <!-- 是否可以使用子包（一层一层的目录）-->
               <property name="enableSubPackages" value="true" />
           <!--前后空格去掉 -->
               <property name="trimStrings" value="true" />
           </javaModelGenerator>
           <!-- SQL映射文件的生成策略 -->
           <sqlMapGenerator targetPackage="com.ssm.mybatis.mapper"
                            targetProject=".\src\main\resources">
               <property name="enableSubPackages" value="true" />
           </sqlMapGenerator>
           <!-- Mapper接口的生成策略 -->
           <javaClientGenerator type="XMLMAPPER"
                                targetPackage="com.ssm.mybatis.mapper" targetProject=".\src\main\java">
               <property name="enableSubPackages" value="true" />
           </javaClientGenerator>
           <!-- 逆向分析的表 -->
           <!-- tableName设置为*号，可以对应所有表，此时不写domainObjectName -->
           <!-- domainObjectName属性指定生成出来的实体类的类名 -->
           <table tableName="t_emp" domainObjectName="Emp"/>
           <table tableName="t_dept" domainObjectName="Dept"/>
       </context>
   </generatorConfiguration>
   ```

4. 执行mbg插件的generate目标

   ![image-20221029215207276](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221029215207276.png)

5. 查询操作

   ```java
   @Test
   public void testMBG(){
   	try {
           InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
           SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
           SqlSession sqlSession = sqlSessionFactory.openSession(true);
           EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
           //查询所有数据
           /*List<Emp> list = mapper.selectByExample(null);
           list.forEach(emp -> System.out.println(emp));*/
           //根据条件查询
           /*EmpExample example = new EmpExample();
           example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
           example.or().andDidIsNotNull();
           List<Emp> list = mapper.selectByExample(example);
           list.forEach(emp -> System.out.println(emp));*/
           mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"456@qq.com",3));
        	} 
       	catch (IOException e) {
           e.printStackTrace();
           }
   }
   
   ```

   

   ```
   example表示条件，example=null即没有条件，查全部
   
   example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
   example.or().andDidIsNotNull();
   or表示添加or条件
   select ... from... where EmpName="张三" and Age>20  or Did is not null
   
   
   ```

   



### 分页插件

```
limit index,pageSize
pageSize：每页显示的条数
pageNum：当前页的页码
index：当前页的起始索引，index=(pageNum-1)*pageSize
count：总记录数
totalPage：总页数
totalPage = count / pageSize;
if(count % pageSize != 0){
totalPage += 1;
}
pageSize=4，pageNum=1，index=0 limit 0,4
pageSize=4，pageNum=3，index=8 limit 8,4
pageSize=4，pageNum=6，index=20 limit 8,4
```

1. 添加依赖

   ```xml
   <dependency>
       <groupId>com.github.pagehelper</groupId>
       <artifactId>pagehelper</artifactId>
       <version>5.2.0</version>
   </dependency>
   ```

2. mybatis核心配置文件中配置插件

   ```xml
   <plugins>
       <!--设置分页插件-->
       <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
   </plugins>
   ```

3. 使用

   ```
   a>在查询功能之前使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能
   pageNum：当前页的页码
   pageSize：每页显示的条数
   
   b>在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, int
   navigatePages)获取分页相关数据
   list：分页之后的数据
   navigatePages：导航分页的页码数
   
   c>分页相关数据
   PageInfo{
       pageNum=8, pageSize=4, size=2, startRow=29, endRow=30, total=30, pages=8,
       list=Page{count=true, pageNum=8, pageSize=4, startRow=28, endRow=32, total=30,
       pages=8, reasonable=false, pageSizeZero=false},
       prePage=7, nextPage=0, isFirstPage=false, isLastPage=true, hasPreviousPage=true,
       hasNextPage=false, navigatePages=5, navigateFirstPage4, navigateLastPage8,
       navigatepageNums=[4, 5, 6, 7, 8]
   }
   pageNum：当前页的页码
   pageSize：每页显示的条数
   size：当前页显示的真实条数
   total：总记录数
   pages：总页数
   prePage：上一页的页码
   nextPage：下一页的页码
   isFirstPage/isLastPage：是否为第一页/最后一页
   hasPreviousPage/hasNextPage：是否存在上一页/下一页
   navigatePages：导航分页的页码数
   navigatepageNums：导航分页的页码，[1,2,3,4,5]
   ```




## Spring

### IOC

IOC 容器中管理的组件也叫做 bean。

在创建 bean 之前，首先需要创建 IOC 容器。Spring 提供了 IOC 容器的两种实现方式：

 ①BeanFactory 这是 IOC 容器的基本实现，是 Spring 内部使用的接口。面向 Spring 本身，不提供给开发人员使用。 

②ApplicationContext BeanFactory 的子接口，提供了更多高级特性。面向 Spring 的使用者，几乎所有场合都使用 ApplicationContext 而不是底层的 BeanFactory。

![image-20221031193543437](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221031193543437.png)





#### 创建

1. 引入依赖

   ```xml
   <dependencies>
       <!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-context</artifactId>
               <version>5.3.1</version>
           </dependency>
           <!-- junit测试 -->
           <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
               <version>4.12</version>
               <scope>test</scope>
           </dependency>
       </dependencies>
   
   ```

2. 创建类以及spring配置文件，配置bean

   ```xml
   <bean id="helloworld" class="com.ssm.spring.pojo.helloworld"></bean>
   ```

3. 创建容器，通过容器创建类对象实例

   ```java
   ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
   helloworld helloworld = (helloworld) ioc.getBean("helloworld");
   helloworld.show();
   ```

   ![image-20221031203525364](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221031203525364.png)



#### 获取bean

```xml
<bean id="student" class="com.ssm.spring.pojo.Student"></bean>
```

id定位到bean的id标签

class定位到具体类

1. 根据id获取

   ```java
   Student student1 =(Student) ioc.getBean("student");
   ```

   

2. 根据类型

   ```java
   Student student2 = ioc.getBean(Student.class);
   ```

   

3. 根据id和类型

   ```java
   Student student3 = ioc.getBean("student", Student.class);
   ```

   

**一般根据类型**，因为可以设置属性scope ="prototype " ，使一个bean对应类的多个实例





#### 依赖注入DI

DI：Dependency Injection，翻译过来是依赖注入。

DI 是 IOC 的另一种表述方式：即组件以一些预先定义好的方式（例如：setter 方法）接受来自于容器 的资源注入。（原先new的时候赋值，现在在bean设置好，创建的时候直接注入）

所以结论是：IOC 就是一种反转控制的思想， 而 DI 是对 IOC 的一种具体实现。



##### setter注入

name对应类中的getXXX，setXXX方法中的XXX

```xml
<bean id="studentOne" class="com.atguigu.spring.bean.Student">
    <!-- property标签：通过组件类的setXxx()方法给组件对象设置属性 -->
    <!-- name属性：指定属性名（这个属性名是getXxx()、setXxx()方法定义的，和成员变量无关）
    -->
    <!-- value属性：指定属性值 -->
    <property name="id" value="1001"></property>
    <property name="name" value="张三"></property>
    <property name="age" value="23"></property>
    <property name="sex" value="男"></property>
</bean>
```



##### 构造器注入

```xml
 <!--        如果没有name,index属性，必须按构造器顺序-->
<constructor-arg value="111"></constructor-arg>
<constructor-arg value="张三" ></constructor-arg>
<constructor-arg  value="16"></constructor-arg>
<constructor-arg value="女"></constructor-arg>
```

```
注意：
constructor-arg标签还有两个属性可以进一步描述构造器参数：
index属性：指定参数所在位置的索引（从0开始）
name属性：指定参数名
```



##### 特殊值处理

```xml
<property name="sex" value="男"></property>
```

value赋值是字面量赋值，value等于什么，值就是什么。

当需要赋值null / < /等特殊字符，需要特殊处理



**null:**

```xml
<property name="name">
	<null />
</property>
```

直接value = "null"，赋的值是字符串null



**xml实体:**

```
小于号<:  &lt;     注意结尾有分号;
大于号<:  &gt;
```

```xml
<property name="id" value="1 &lt; &gt;"></property>
```



**CDATA节:**可解决所有问题，想写什么写什么



```xml
<property name="expression">
<!-- 解决方案二：使用CDATA节 -->
<!-- CDATA中的C代表Character，是文本、字符的含义，CDATA就表示纯文本数据 -->
<!-- XML解析器看到CDATA节就知道这里是纯文本，就不会当作XML标签或属性来解析 -->
<!-- 所以CDATA节中写什么符号都随意 -->
<value><![CDATA[a < b]]></value>
</property>
```





##### 为类赋值

1. 引用外部的bean

   ```xml
   <bean id="clazzOne" class="com.atguigu.spring.bean.Clazz">
       <property name="clazzId" value="1111"></property>
       <property name="clazzName" value="财源滚滚班"></property>
   </bean>
   
   <bean id="studentFour" class="com.atguigu.spring.bean.Student">
       <property name="id" value="1004"></property>
       <property name="name" value="赵六"></property>
       <property name="age" value="26"></property>
       <property name="sex" value="女"></property>
       <!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
       <property name="clazz" ref="clazzOne"></property>
   </bean>
   ```

   

2. 内部创建一个bean

   ```xml
   <bean id="studentFour" class="com.atguigu.spring.bean.Student">
       <property name="id" value="1004"></property>
       <property name="name" value="赵六"></property>
       <property name="age" value="26"></property>
       <property name="sex" value="女"></property>
       <property name="clazz">
       <!-- 在一个bean中再声明一个bean就是内部bean -->
       <!-- 内部bean只能用于给属性赋值，不能在外部通过IOC容器获取，因此可以省略id属性 -->
           <bean id="clazzInner" class="com.atguigu.spring.bean.Clazz">
               <property name="clazzId" value="2222"></property>
               <property name="clazzName" value="远大前程班"></property>
           </bean>
       </property>
   </bean>
   	
   ```

   

3. 级联

   相当与**先引用外部bean，再对其值进行更改**

   ```xml
   <bean id="clazzOne" class="com.atguigu.spring.bean.Clazz">
       <property name="clazzId" value="1111"></property>
       <property name="clazzName" value="财源滚滚班"></property>
   </bean>
   
   <bean id="studentFour" class="com.atguigu.spring.bean.Student">
       <property name="id" value="1004"></property>
       <property name="name" value="赵六"></property>
       <property name="age" value="26"></property>
       <property name="sex" value="女"></property>
       <!-- 一定先引用某个bean为属性赋值，才可以使用级联方式更新属性 -->
       <property name="clazz" ref="clazzOne"></property>
       <property name="clazz.clazzId" value="3333"></property>
       <property name="clazz.clazzName" value="最强王者班"></property>
   </bean>	
   ```

   

##### 为数组 / 集合赋值



**赋的值为字面量，用value属性**

**赋的值为类，用ref属性**



**数组 ：**

String hobbies[ ]

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
    <property name="hobbies">
        <array>
            <value>抽烟</value>
            <value>喝酒</value>
            <value>烫头</value>
        </array>
    </property>
</bean>
```



**List集合：**

1. 

```
private List<Student> students;
```

```xml
<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">
    <property name="clazzId" value="4444"></property>
    <property name="clazzName" value="Javaee0222"></property>
    <property name="students">
        <list>
            <ref bean="studentOne"></ref>
            <ref bean="studentTwo"></ref>
            <ref bean="studentThree"></ref>
        </list>
    </property>
</bean>
```



2. 创建集合类型的bean

```xml
<util:list id="studentId">
    <ref bean="student1"></ref>
    <ref bean="student2"></ref>
    <ref bean="student3"></ref>
</util:list>
```

```xml
<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">
    <property name="clazzId" value="4444"></property>
    <property name="clazzName" value="Javaee0222"></property>
    <property name="students" ref="studentId"> </property>
</bean>
```



**Map集合：**

```
private Map<String, Teacher> teacherMap;
```

```xml
<property name="XXXmap">
    <map>
       <entry key="key" value="value"></entry>
       <entry key-ref="key" value-ref="value"></entry>
    </map>
</property>

或
 <util:map id="map">
        <entry key="" value=""></entry>
        <entry key="" value=""></entry>
        <entry key="" value=""></entry>
</util:map>
<property name="XXXmap" ref="map"></property>
```





##### P命名空间

相当于冒号语法为属性赋值

p:属性  /    p:属性-ref  

```xml
 <bean id="studentP" class="com.ssm.spring.pojo.Student"
          p:id="123" p:age="12" p:clazz-ref="clazz" p:name="李四" p:sex="男"></bean>
```





##### 引入外部属性文件

引入properties文件等

```xml
<context:property-placeholder location="jdbc.properties"></context:property-placeholder>

<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="${jdbc.driver}"></property>
    <property name="username" value="${jdbc.username}"></property>
    <property name="password" value="${jdbc.password}"></property>
    <property name="url" value="${jdbc.url}"></property>
</bean>
```





#### bean的作用域

**bean默认为单例设计，从 bean获得的多个实例都指向容器中同一位置**

![image-20221031224301141](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20221031224301141.png)

```xml
<bean id="student" class="com.ssm.spring.pojo.Student" scope="prototype">
</bean>
```

```java
 @Test
    public void testStudent(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student2 = ioc.getBean(Student.class);
        Student student3 = ioc.getBean("student", Student.class);
        System.out.println(student3 == student2);
    }

//多例模式下，输出为false
//若为单例，scope="singeleton",输出为true

```



#### bean生命周期

```
具体的生命周期过程：

bean对象创建（调用无参构造器）
给bean对象设置属性
bean对象初始化之前操作（由bean的后置处理器负责）
bean对象初始化（需在配置bean时指定初始化方法）
bean对象初始化之后操作（由bean的后置处理器负责）
bean对象就绪可以使用
bean对象销毁（需在配置bean时指定销毁方法）
IOC容器关闭
```



1. 无参构造
2. 调用类中的set方法赋初值
3. 调用bean后置处理器  postProcessBeforeInitialization
4. 调用bean的init-method
5. 调用bean后置处理器  postProcessAfterInitialization
6. 使用
7. 调用bean的destroy-method 并销毁
8. ioc关闭



**后置处理器：**

```java
package com.ssm.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization-----------------------");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization------------------------");
        return bean;
    }
}

```

```xml
 <bean id="mybeanPostProcessor" class="com.ssm.spring.process.MyBeanPostProcessor"></bean>
```

**配置一个bean后置处理器，对所有ioc容器中的bean都会执行**





**init-method / destroy-method:**

```xml
<!-- 使用init-method属性指定初始化方法 -->
<!-- 使用destroy-method属性指定销毁方法 -->
<bean class="com.atguigu.bean.User" scope="prototype" init-method="initMethod"
destroy-method="destroyMethod">
    <property name="id" value="1001"></property>
    <property name="username" value="admin"></property>
    <property name="password" value="123456"></property>
    <property name="age" value="23"></property>
</bean>
```

类中实现方法：

```java
public class User {
	......
	
    public void initMethod(){
    System.out.println("生命周期：3、初始化");
    }
    public void destroyMethod(){
    System.out.println("生命周期：5、销毁");
    }
}	

```





#### FactoryBean

接口源码：

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.springframework.beans.factory;

import org.springframework.lang.Nullable;

public interface FactoryBean<T> {
    String OBJECT_TYPE_ATTRIBUTE = "factoryBeanObjectType";

    @Nullable
    T getObject() throws Exception;

    @Nullable
    Class<?> getObjectType();

    default boolean isSingleton() {
        return true;
    }
}

//共有三个方法
//getObject   
//getObjectType
//isSingleton 是否单例，默认为true
```



FactoryBean是Spring提供的一种整合第三方框架的常用机制。

和普通的bean不同，配置一个 FactoryBean类型的bean，在获取bean的时候得到的并不是class属性中配置的这个类的对象，**而是 getObject()方法的返回值**。

通过这种机制，Spring可以帮我们把复杂组件创建的详细过程和繁琐细节都 屏蔽起来，只把最简洁的使用界面展示给我们。 将来我们整合Mybatis时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory对象的。



```java
package com.ssm.spring.factory;

import com.ssm.spring.pojo.Student;
import org.springframework.beans.factory.FactoryBean;

class StuFactoryBean implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
```

```xml
 <bean id="myBeanPostProcessor" class="com.ssm.spring.factory.StuFactoryBean"></bean>
```

getObject方法返回的是Student 对象，因此容器中管理的是Student对象，从容器中获得的也是Student实例

```java
 @Test
    public void testFactoryBean()  {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("factoryBean.xml");
        Student stu = (Student)ioc.getBean("myBeanPostProcessor");
        System.out.println(stu);
    }
```











































