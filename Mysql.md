字符集编码问题

查看编码设置

show variables like 'character_set_%';

![image-20220330234432522](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220330234432522.png)

修改编码设置

set character_set_client=gbk;

set character_set_results=gbk;

#  逼格

CRUD--------增删改查



# 概念

Mysql -------关系型数据库

关系：几张表中通过主键外键构成了关系

行：一条数据 实体

列：一个字段 属性



# 区别

| DDL(data definition language)     | 数据库定义语言 | create alter drop show            | 用于创建或删除数据库对象的语句     |
| --------------------------------- | -------------- | --------------------------------- | ---------------------------------- |
| DML(data manipulation language)   | 数据库操纵语言 | insert update delete select       | 用于添加、修改、删除数据的语句     |
| DQL(Data Query Language)          | 数据查询语言   | select                            | 用于查询                           |
| DCL（Data Control Language）      | 数据控制语言   | grant deny revoke                 | 用于对数据对象访问权进行控制的语句 |
| TPL(Transaction Process Language) | 事务处理语言   | BEGIN TRANSACTION/COMMIT/ROLLBACK | 用于数据库内部事务处理的语句       |



# 数据库基本操作命令

| -u                                | 输入用户名                                              |
| :-------------------------------- | ------------------------------------------------------- |
| -p                                | 输入密码                                                |
| -u root - p                       | 以管理员身份运行mysql                                   |
| show databases                    | 显示数据库                                              |
| create database xxx               | 创建名为xxx的仓库                                       |
| create database if not exists xxx | 如果xxx不存在，则创建名为xxx的仓库                      |
| drop database xxx                 | 删除                                                    |
| drop database if exists xxx       | 如果存在则删除                                          |
| show create database xxx          | show当初是如何创建xxx的                                 |
| charset=utf-8                     | 设置编码                                                |
| alter database .....              | 修改数据库的一些设置（例如alter database charset=utf8） |
| # xxxxxx                          | 单行注释                                                |
| /*         */                     | 多行注释                                                |
|                                   |                                                         |
|                                   |                                                         |
|                                   |                                                         |

# 表的基本命令

数据库中，由各种表组成。数据储存在表中

## show/create/use/drop

| use 'database'                               | 指定某一个库             |
| -------------------------------------------- | ------------------------ |
| show tables                                  | show该库的表             |
| create table 'database'( )                   | 创建一个表               |
| create table  if not exists 'database'( )    |                          |
| show create table 'database'                 | show当初怎么创建的table  |
| drop table if exists 'database1','database2' | 删除多个表，可用逗号隔开 |

```mysql
create table table_1(
    //输入表中的字段
    id int,
    name varchar(30), 
    //数据库中字符类型是varchar,设置name最长为30个字符
    age int
);
```



## 快速创建一张表

```mysql
create table t1 as select * from t2;
//将t2表的查询结果作为新表创建
```



## auto_increment自动增长

```mysql
create table table_1(
    id int auto_increment primary key comment'主键id'
 	//auto_increment 自动增长
    //表示让int型的id自动增长编号
    
);
```

字段：table中的各个元素,如上文中的id,name

如果是auto_increment，必须是primary key,且默认不为null

如果是primary key，不一定要是auto_increment



## primary key主键

只有一个（可以设多个字段为主键，但是在表里只当作一个主键（复合主键）），不能为null，默认不为null



标记某个字段为主键

```mysql
create table table_1(
    id int auto_increment primary key comment'主键id'
 	name varchar(30)
);
```

主键用于区分各个数据，如上面，表中的每个元素的id都不一样，name可能重复，所以将id设为主键



主键值建议使用int ,bigint,char，一般是数字，定长的，不建议用varchar



![image-20220624204228784](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624204228784.png)

## 复合主键

即设置多个字段为主键

alter table xxx add primary key (id,name);

```mysql
alter table xxx add primary key (id,name);
```

```mysql
create table t1(
id int(5),
name varchar(10),
primary key(id,name)  //创建复合主键
);
```

实际开发中不建议使用

## unique键 唯一键

如其名，是表示某个字段是唯一的，保证没有重复的数据字段，可以为空

一个表里可以有多个唯一键

```mysql
create table table_1(
phonenumber varchar(20) unique,
age int,
id int,
)
alter table table_10 add unique(age,id);
```

unique和primary的区别 个人理解：

primary key-------数据的特性，不但可以用于区分表里的各个数据，当这个数据在其他表里时，也能够区分，就像是身份证号，在班级名单和医保名单里，都能够区分身份。

unique------表的特性，只表示这个数据在这个表里是唯一的，只在这个表里起到区分作用。就像是班级名单里的学号，学号放到其他表里就没用了





## 删除键

删除原本primary key或者unique

```mysql
alter table xxx drop index yyy;
```





## 外键

设置表字段的时候，让两张表的两个属性相关联（使用别的表的属性）

注意！设置的时候一定是和另一个表的**主键**字段相绑定，否则报错。

```mysql
create table student(
studentID int primary key
);

create table school(
    stuID int,
    foreign key (stuID) references student(studentID)
);
```

#### 删除

删除外键时，要show create table xxx看一下外键的名字（系统会默认给一个名字）

![image-20220614220310023](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220614220310023.png)

```mysql
alter table student drop forgign key student_ibfk_1;
```

#### 置空操作

当另一张表的外键关联数据删除后，对本张表的对应数据置空

删除时，一般使用置空

在创建表时，就标定其有置空、级联的功能 

#### 级联操作

当另一张表的外键关联数据变化后，对本张表的对应数据一并变化



```mysql

create table record(
no int primary key,
money int,
id int,
foreign key(id) references stu(id) on delete set null on update cascade
    
    //on delete 在删除的时候 set null置空
    //on update 在更新的时候 cascade 级联操作
);
```





#### 删除顺序

创建：先父后子

删除：先子后父

## comment 注释

给字段加注释

```mysql
create table table_1(
 	name varchar(30) comment '名字'
);
```



## not null 不能为空

```mysql
create table table_1(
 	name varchar(30) not null
);
```



## default xxx 设xxx为默认值

```mysql
create table table_1(
 	name varchar(30) default '张三' //名字默认为张三
);
```



## 设置存储引擎和字符

将数据库引擎设为innodb

```mysql
create table table_1(
 	name varchar(30) default '张三' 
)engine=innodb default charset=utf8;
```







##  desc 'table' 显示table信息



## alter table xxx 

对某一个表进行更改

增加字段：

alter table xxx add name varchar(10);

把字段增加到指定位置:
alter table xxx add name varchar(10) after id;

把字段放到最前面:

alter table xxx add name varchar(10) first;

删除某个字段：

alter table xxx drop name;

改变某个字段的类型和名字

change:（改名字和类型）

alter table aaa change name firstname varchar(20);

modify:（只能改类型）

alter table aaa modify name int;

改表的名字：

alter table xxx rename to yyy;

 设置主键：

alter table xxx add primary key (id)





# ⭐数据操作

## Insert into

```mysql
insert into xxx (id,name,xxxx) values(1,'Saitama',xxxxxx)
```

```mysql
insert into xxx values(1,'Saitama',xxxxxx)//前面没有写(id,name,xxxx)，那必须按照表字段顺序来
```



插入多条数据： 加逗号就行

```mysql
insert into xxx (id,name,xxxx) values(1,'Saitama',xxxxxx)，（xxxxxx），（xxxxxxx）；
```



插入查询结果

```mysql
insert into t1 select * from t2;
```



## Select

```mysql
select
...
from
...
where
...
order by
```

执行顺序：

1 from  2 where 3 select 4 order by



简单查询：select 字段名 from 表名;

### 查找所有数据

用 *** 代表所有字段**，但是这个语句性能有缺陷

```mysql
select * from xxx
```

### 查询特定数据

```mysql
select 字段1,字段2.... from 表；
```

### 列起别名

用as关键字，可省略

```mysql
select 字段 as 别名 from 表;
select 字段 别名 from 表;  //不要加逗号
select 字段 '别名' from 表;  //加上引号，防止别名中有空格
```

### 数学运算

```mysql
select 字段*12 from 表;

//例： select salary*12  as yearSalary from 表; 工资*12 起别名为年薪

```

### 条件查询

```mysql
select 字段 from 表名 where 条件;
```

### select + 字面量/字面值

```mysql
select 1000 from t1 ;
//原有表有10行，那么结果会显示10行1000
select 'abc' from t1 ;
//原有表有10行，那么结果会显示10行abc
select abc from t1 ;
//会报错，把abc当作字段而非字面量，找不到名为abc的字段
```



## 排序 order by

默认为升序

```mysql
select 字段 from 表名 order by 字段;
```

指定降序

```mysql
select 字段 from 表名 order by 字段 desc;
```

指定升序，没什么用

```mysql
select 字段 from 表名 order by 字段 asc;
```

按多个字段排序，例如先按照薪资排序，薪资相同按照名字排序

```mysql
select 字段1,字段2 from 表名 order by 字段1 asc,字段2 asc;
```

按照字段位置（第几列）排序

不建议这么写，不健壮，字段位置容易改变

```mysql
select 字段1 from 表名 order by 2;  //按照第二列来排序
```





## WHERE

| =                   |                                                         |
| ------------------- | ------------------------------------------------------- |
| != , <>             | 不等于,       <>a表示小于a且大于a，小于大于组成的不等号 |
| <= ,>= ,<,>         |                                                         |
| between ...and .... | a<=x<=b       两侧闭合                                  |
| is null             | 查询是否为空                                            |
| and                 | and优先级比or高                                         |
| or                  |                                                         |
| in                  | 包含，相当于多个or,  in(里面是具体的值，**不是区间**)   |
| not                 | 取非，主要用于is和in中 ，is not null, not in            |
| like                | 模糊查询,%匹配任意多字符，_匹配任一个字符               |
|                     |                                                         |
|                     |                                                         |
|                     |                                                         |
|                     |                                                         |
|                     |                                                         |

(not)in, or

```mysql
select * from t1 where name='a' or name='b'
select * from t1 where name in('a','b')
```

between a and b      

```mysql
select * from t1 where num>=15 and num<=20;
select * from t1 where num between 15 and 20;
```

is null

```mysql
select * from t1 where name is null;
```

  and优先级比or高，要让or优先，加小括号

```mysql
select * from t1 where  name is null and num>=15 or num<=10;
//name is null为条件1
//num>=15 or num<=10为条件2

select * from t1 where  'name is null and num>=15'  or num<=10;
//name is null and num>=15为条件1
//num<=10为条件2
```

like 

```mysql
select * from t1 where name like '%e';  //找出以e结尾的名字
select * from t1 where name like 'e%';  //找出以e开头的名字
select * from t1 where name like '%e%';  //找出中间有e的名字
select * from t1 where name like '_e_r%';  //找出第二个为e，第四个为r的名字
select * from t1 where name like '%\_%';  //找出带有下划线的名字
```



## 数据处理函数 / 单行处理函数

单行处理函数的特点：一个输入对应一个输出

与之相对的是：多行处理函数



| lower                                    | 转小写                                             |
| ---------------------------------------- | -------------------------------------------------- |
| upper                                    | 转大写                                             |
| substr                                   | 取子串 substr(字段,起始下标，截取长度),起始下标为1 |
| length                                   | 取长度                                             |
| trim                                     | 去字符串中的空格                                   |
| str_to_date                              | 字符串转为日期                                     |
| date_format                              | 格式化                                             |
| format                                   | 设置千分位                                         |
| round                                    | 四舍五入 round(数字,n) n代表保留几位小数           |
| rand                                     | 生成0-1的随机数                                    |
| ifnull                                   | 将null转为以一个具体值   ifnull(数据，被当作的值)  |
| concat                                   | 字符串拼接  concat(字段1，字段2)                   |
| case..when..then..when..then..else...end |                                                    |

```mysql
select lower(name) from t1;
select upper(name) from t1;
```

```mysql
select substr(name,1,2) from t1;
//从名字的第一个字符开始，截取长度为2的字符字串
```

```mysql
select round(12.12,0) from t1;
//结果输出n行12
select round(12.12,-1) from t1;
//结果输出n行10
```

```mysql
//只要null参与了运算，那结果一定是null，为了避免，需要使用ifnull()
select name,salary+ifnull(bonus,0) from t1; 
```

```mysql
select name,
	(case job 
	when 'Manager' then salary*2
	when 'Salesman' then salary*1.5
	else salary)as newSalary
from 
	t1;
```

```mysql
insert into t1 values(str_to_date('日期字符串','日期格式'))
insert into t1 values(str_to_date('01-02-22','%d-&m-%Y'))
```

```mysql
insert into t1 values(date_format('日期数据','日期格式'))
insert into t1 values(date_format(date,'%d-&m-%Y'))
```



## 聚合函数 / 分组函数 / 多行处理函数

特点：输入多行，最终输出一行

分组函数**在使用时必须分组**，默认为整个表

| count | 计数     |
| ----- | -------- |
| sum   | 求和     |
| avg   | 求平均   |
| max   | 求最大值 |
| min   | 求最小值 |

1、分组函数会自动忽略null，如求和时不会计入null的数据

2、count(*) 与count(具体字段)的区别：

count(具体字段)：表示统计该字段下的所有不为null的元素总数

count(*)：统计表中的总行数，**表示所有字段，表中的每一行，不可能所有字段都是null

3、分组函数不能出现在where子句中

where执行的时候还没有group by 

分组函数之后group by之后才能使用，默认为整张表（不分组）

```mysql
select name from t1 where salary > min(salary);
//错误的
```

4、所有的分组函数可以组合起来一起使用

```mysql
select sum(money),min(money),max(money) from t1;
```



## ⭐分组查询

```mysql
select
	...
from
	...
group by 
	...
```

例如计算每个职位（职工、经理、组长）的平均薪资

```mysql
select
	job,avg(salary)
from
	t1
group by 
	job
```

如果有group by，那么select后面只能跟上参与分组的字段，以及分组函数

```mysql
select
	name,job,avg(salary)
from
	t1
group by 
	job
//可以执行但没有意义
```



### **联合分组：**

```mysql
select
	department,job,sum(salary)
from
	t1
group by 
	department,job
//查询每个部门的不同职位的工资总和
```



### having

having和group by配套使用

having对分组之后的组进行过滤

```mysql
select
	job,max(salary)
from 
	t1
group by 
	job
having 
```

where和having，优先选择where，效率更高

**HAVING 子句总是包含聚合函数。**（严格说来，你可以写不使用聚集的 HAVING 子句， 但这样做只是白费劲。同样的条件可以更有效地用于 WHERE 阶段。）

***WHERE子句不能包含聚合函数*。**

## 关键字执行顺序

顺序不能颠倒

```mysql
select
...
from 
...
where
...
group by
... 
having
...
order by
...
limit
;
```

执行顺序：

 1.from 从某张表里查

2.where 通过条件过滤

3.group by 分组 having过滤

4.select 查询

5.order by 排序输出

6.limit

## Distinct

查询结果**去除重复记录**

distinct只能出现在字段最前方

distinct出现在多个字段之前，表示多个字段联合起来去重

```mysql
select distinct job from emp;
```

```mysql
select name,distinct job from emp;
//错误的
```

```mysql
select distinct name,job from t1;
//name,job都相同的数据，去重
```





## ⭐连接查询

多张表联合起来查询数据，跨表查询

重点学习SQL99

![img](https://img-blog.csdnimg.cn/img_convert/fc903e34d0b953f2b9ab1a44d6b83ba5.png)

### 笛卡尔积现象

select * from t1,t2  显示结果为两表的笛卡尔积



![](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220619163156290.png)

避免笛卡尔积：加限制条件

```mysql
select 表名1.字段，表名2.字段
from 表名1，表名2
where 表名1.字段 = 表名2.字段;
```

表起别名：

```mysql
select e.name,d.name
from emp e,dept d
where e.deptno = d.deptno;
```



### 内连接

连接两张表，无主次关系

#### 等值连接

案例：有员工表和部门表，查询员工名和对应的部门

```mysql
//SQL92 表连接的条件放在where中，通过and连接单表内的条件
select 
	e.name,d.name
from
	emp e,dept d
where 
	e.deptno = d.deptno;
```

```mysql
//SQL99 表连接的条件单独写，where中存放进一步筛选的条件
select 
	e.name,d.name
from
	emp e
join
	dept d
on 
	e.deptno = d.deptno;
```

SQL99语法：

```mysql
select
	...
from
	a
(innner可省略)join 
	b
on
	a和b的连接条件
where
	筛选条件
```

#### 非等值连接

有员工表和工资等级表

工资等级表：

![image-20220623164718298](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220623164718298.png)

查每个员工的工资和工资等级

```mysql
select 
	e.name,e.sal,s.grade
from
	emp e
join
	salgrade s
on 
	e.sal between s.losal and s.hisal;
```

条件不是一个等量关系，称为非等值连接

#### 自连接

同一张表，内部进行连接

案例：员工表，显示员工编号与老板编号，现在查找每个员工的老板

![image-20220623165354032](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220623165354032.png)



```mysql
select
	a.name as '员工名',b.name as '员工名'
from 
	emp a
join
	emp b
on 
	a.mgr = b.empno
```



### 外连接

连接两张表，有主次关系

#### 右外连接/右连接

把right join前的那张表（dept)当作主表，显示所有数据，并拼接上另一张表能拼接上的数据。

```mysql
select 
	e.name,d.name
from
	emp e
right (outer) join
	dept d
on 
	e.deptno = d.deptno;
```



#### 左外连接/左连接

把左表(emp)当作主表

```mysql
select 
	e.name,d.name
from
	emp e
left (outer) join
	dept d
on 
	e.deptno = d.deptno;
```

**外连接查询结果条数 >= 内连接查询结果条数**



### 全连接不讲

### 多张表连接

```mysql
select 
	name,no
from	
	a
join 
	b
on
 	xxx
join 
	c
on
 	xxx	
right join 
	d
on
	xxx
```





## 子查询

select语句中嵌套select语句，被嵌套的select语句被称为子查询

```mysql
select (select)
from (select)
where (select)
```

### where中子查询

找出比最低工资多的员工及其工资

```mysql
select ename,sal
from emp
where sal>(select min(sal) from emp)

```

### from子查询

将子查询的查询结果当作一张临时表

案例：找出每个岗位的平均工资的薪资等级

```mysql
select t.*,grade
from 
(select job,avg(sal) as avgsal
from emp
group by job
 ) t
left join salgrade s
on t.avgsal between s.losal and s.hisal;
	
```



### select子查询（了解即可

子查询语句**只能返回一条结果**，否则报错。例子中只返回了dname

```mysql
select
	e.name,e.deptno,(select dname from dept where e.deptno = d.deptno) as dname
from 
 emp e;
```



## Union合并查询结果集

要求两个结果集的列数相同（必须），列的数据类型也要一致（mysql不会报错）

```mysql
select name,job from emp where job='manager'
union
select name,job from emp where job='salesman';
//等同于
select name,job
from emp
where job in ('manager','salesman');

```

union效率更高

对于表连接来说，通过union把笛卡尔积的复杂，转换为加法（表相加）

a/b/c都有10条记录，a连接b连接c，匹配次数为1000（笛卡尔积）

使用union，a连接b union a连接c  匹配次数为200



## limit

将查询结果的一部分取出来，让用户可以一页一页翻着看，提高用户的体验

```mysql
limit startIndex(默认为0，可省略),length;
```

limit 在order by之后执行

```mysql
select name,sal
from emp
ordre by sal desc
limit 5;
//显示薪资前5高的
```



分页查询

```mysql
limit (pageNo-1)*pageSize,pageSize;
```







## DUAL

dual是一个伪表（默认）

```mysql
select 2*2 as num;
select 2*2 as num from dual;
//两句相同
```



## Delete

```mysql
delete from xxx where 条件;
```

```mysql
delete from table1 where id=1;
delete from table1 where id>10;

```

一般根据唯一的东西删除，例如主键，id。

否则可能重复删除很多相同的数据，例如删了很多名字一样的人



## 清空表

delete from table;       不行！！很慢，需要遍历判断



```mysql
truncate table xxx;
```





## 更新数据

```mysql
update xxx set 字段=yyy where 条件
```

例如：

```mysql
update studengt set name='李四' where id=10;
update studengt set age=20,name='李四' where id>10 or id<5;
```











# 数据类型

提前声明： int /... unsigned 无符号类型



![image-20220331215844520](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220331215844520.png)

## 整型

int（）括号中指数据的最大宽度，如tinyint(3)，表示最多三个数

最多11位 int(11)

## 浮点

```mysql
float(3,1) //宽度最多3位，小数点后1位
```

如果输入的小数超越了小数点的界限，会四舍五入。



浮点会丢失精度：

```mysql
create table table_1(
number float(20,19)
);
insert into table_1 values(9.1111111111111111111111111111111)

//会输出9.1111106872558600000，丢失了精度
```



## 定点数

不会丢失精度



## 字符串

![image-20220331222226067](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220331222226067.png)

char(20) 的长度是定死的

varchar(20)的长度会变，如果输入的字符串长度<20，则后面长度回收

但是char的效率大于varchar

text,mediumtext,longtext用于长文本，很多文字储存 



char和varchar最长255



## 枚举类型

```mysql
create table t_1(
gender enum('male','female','?','none')
);
insert into t_1 values('?');
insert into t_1 values(3);
```

输入数据的时候只能输入枚举里面的一个东西

enum('male','female','?','none')实际上存的是编号，male对应1，female对应2......

所以存的时候也可以通过编号来存。

速度快！



## set类型/集合类型

```mysql
create table t_5(
hobby set('apple','orange','banana','shit')
);
insert into t_5 values('apple,shit');
```

输入的时候能够输入set里面多个数据





## 时间日期类

业务中，每张表都应该有时间日期类型

![image-20220331224358314](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220331224358314.png)

​	输入DATE时直接输入纯数字，否则会报错

insert into time values(2,'b',20220614); 

#### mysql日期格式:

%Y 年

%m %d %d %h  %i %s 月日时分秒

#### 获取当前时间：now()



## clob/blob

### clob：Character Large Object

字符大对象，最多可以储存4G的字符串

超过255个字符都要采用clob

Character Large Object



blob:Binary Large Object

专门储存图片、声音、视频等流媒体数据。

往BLOB类型的字段上插入数据时，要使用IO流



# 存储引擎

查看支持的引擎：show engines;

当前版本共9种

![image-20220624205239832](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624205239832.png)

常用：

MyISAM

![image-20220624205625651](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624205625651.png)

InnoDB

![image-20220624205640952](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624205640952.png)

MEMORY

![image-20220624205718945](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624205718945.png)



# ⭐事务

## 什么是事务?

一个事务其实就是一个完整的业务逻辑。是一个最小的工作单元。不可再分。
	什么是一个完整的业务逻辑?
	假设转账，从A账户向B账户中转账10000.
	将A账户的钱减去10000 ( update语句)
	将B账户的钱加上10000 ( update语句)
	这就是一个完整的业务逻辑。

以上的操作是一个最小的工作单元，要么同时成功，要么同时失败，不可再分。
这两个update语句要求必须同时成功或者同时失败，这样才能保证钱是正确的。



只有DML语句才会有事务这一说，其它语句和事务无关! ! !
insert
delete
update
只有以上的三个语句和事务有关系，其它都没有关系。
因为只有以上的三个语句是数据库表中数据进行增、删、改的。
只要你的操作一旦涉及到数据的增、删、改，那么就一-定要考虑安全问题。
数据安全第1位! ! !



## 事务的本质

假设所有的业务，只要--条DML语句就能完成，还有必要存在事务机制吗?
正是因为做某件事的时候，需要多条DML语句共同联合起来才能完成，
所以需要事务的存在。如果任何一-件复杂的事儿都能一-条DM语句搞定,
那么事务则没有存在的价值了。
到底什么是事务呢?
说到底，说到本质上，一个事务其实就是多条DML语句同时成功，或者同时失败!



## 事务的实现

9.4、事务是怎么做到多条DML语句同时成功和同时失败的呢?

InnoDB存储引擎:提供--组用来记录事务性活动的日志文件

事务开启了:
insert
insert
insert
delete
update
update
update
事务结束了!|



在事务的执行过程中，每一条DML的操作都会记录到事务性活动的日志文件"中。
在事务的执行过程中，我们可以提交事务，也可以回滚事务。

提交事务：清空事务性活动的日志文件，将数据全部彻底持久化到数据库表中。提交事务标志着，事务的结束。并且是一种全部成功的结束。

回滚事务：将之前所有的DML操作全部撤销，并且清空事务性活动的日志文件回滚事务标志着，事务的结束。并且是一-种全部失败的结束。



## 提交与回滚事务

怎么提交事务，怎么回滚事务?

提交事务:commit;语句

回滚事务:rollback;语句(回滚永远都是只能回滚到上一次的提交点!)

事务对应的英语单词是: transaction。mysql默认情况下是支持自动提交事务的。( 自动提交) 每执行一 条DM语句，则提交一次!



怎么将mysql的自动提交机制关闭掉呢?

先执行这个命令: start transaction

然后使用commit和rollback语句



## 事务的特性

A:原子性    说明事务是最小的工作单元。不可再分。

C:一致性    所有事务要求，在同一个事务当中，所有操作必须同时成功，或者同时失败,以保证数据的一致性.

I:隔离性      A事务和B事务之间具有一定的隔离。教室A和教室B之间有一道墙，这道墙就是隔离性。

D:持久性     事务最终结束的一一个保障。事务提交，就相当于将没有保存到硬盘上的数据保存到硬盘上



## 事务隔离级别

### 读未提交:read uncommitted(最低的隔离级别)

事务A可以读取到事务B未提交的数据。

这种隔离级别存在的问题就是:脏读现象! (Dirty Read)。我们称读到了脏数据。

这种隔离级别一般都是理论上的，大多数的数据库隔离级别都是二档起步!



### 读已提交: read commi tted

事务A只能读取到事务B提交之后的数据。

解决了脏读的现象。

这种隔离级别存在什么问题?--------不可重复读取数据。

什么是不可重复读取数据呢?：

在事务开启之后，第一次读到的数据是3条，当前事务还没有
结束，可能第二次再读取的时候，读到的数据是4条，3不等于4
称为不可重复读取。（第一次读的时候没提交，第二次读的时候提交了，两次读到的东西不一样）

这种隔离级别是比较真实的数据，每一次读到的数据是绝对的真实。
oracle数据库默认的隔离级别是: read committed



### 可重复读 : repeatable read《提交之后也读不到，永远读取的都是刚开启事务时的数据》

事务A开启之后，不管是多久，每一次在事务A中读取到的数据
都是一致的。即使事务B将数据已经修改，并且提交了，事务A
读取到的数据还是没有发生改变，这就是可重复读。

可重复读解决了什么问题?--------解决了不可重复读取数据。

可重复读存在的问题是什么?----------可以会出现幻影读。
每一次读取到的数据都是幻象。不够真实!



### 序列化/串行化:serializable(最高的隔离级别)

这是最高隔离级别，效率最低。解决了所有的问题。

这种隔离级别表示事务排队，不能并发!

synchronized,线程同步( 事务同步)

每一次读取到的数据都是最真实的，并且效率是最低的。



## 设置隔离语句

```mysql
set global transaction isolation level read uncommitted;
set global transaction isolation level read committed;
set global transaction isolation level repeatable read;
set global transaction isolation level serializable;
```





# 索引

索引是在数据库表的字段上添加的，是为了提高查询效率存在的一种机制。索引相当于一本书的目录，是为了缩小扫描范围而存在的一种机制。

**一张表的一个字段可以添加一个索引**，当然，多个字段联合起来也可以添加索引。



**在任何数据库当中主键上都会自动添加索引对象**

**一个字段上如果有unique约束的话，也会自动创建索引对象。**

![image-20220624215721746](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624215721746.png)

## 索引需要排序！

​	在mysql数据库当中索引也是需要排序的，并且这个所以的排序和TreeSet
数据结构相同。TreeSet ( TreeMap)底层是一一个自平衡的二叉树!在mysql
当中索引是一个B树。

​	遵循左小右大原则存放。采用中序遍历方式遍历取数据。



## 什么时候添加索引

![QQ截图20220624215918](D:\OneDrive\桌面\QQ截图20220624215918.png)



## 语法

创建：

```mysql
creat index 索引名 on 表名(字段名)
```

删除：

```mysql
drop index 索引名 on 表名;
```

查看一个SQL语句是否使用索引进行检索：

```mysql
explain SQL语句
```



## 索引失效

![image-20220624220501249](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624220501249.png)

![image-20220624220519261](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624220519261.png)

![image-20220624220611666](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624220611666.png)

![image-20220624220655261](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624220655261.png)

![image-20220624220725245](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624220725245.png)

等等等等情况



## 索引分类

![image-20220624220838879](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624220838879.png)





# 视图

## 语法

创建：

```mysql
create view 视图名 as select * from t1;
//as后面必须是DQL语句（查询语句
```

删除：

```
drop view 视图名；
```



## 作用

![image-20220624221758767](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624221758767.png)

![image-20220624221719040](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624221719040.png)

![image-20220624221829948](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624221829948.png)





# 设计范式

![image-20220624222136737](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222136737.png)

## 第一范式

![image-20220624222237371](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222237371.png)

## 第二范式

![image-20220624222507489](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222507489.png)

![image-20220624222527308](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222527308.png)



![image-20220624222546001](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222546001.png)

## 第三范式

![image-20220624222745037](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222745037.png)

![image-20220624222817835](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222817835.png)

![](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624222836209.png)





## 设计

![image-20220624223012165](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624223012165.png)

![image-20220624223046016](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624223046016.png)

![image-20220624223129840](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220624223129840.png)
