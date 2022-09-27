JAVA基础

## CH.1 一些基本细节

### 开发细节

1.一个源文件中最多有一个public类，其他类个数不限

2.若源文件包含一个public类,则该文件名必须按照类名命名

### API文档

![image-20220120152015961](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120152015961.png)

www.matools.com

### 标识符规则

![image-20220120161235870](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120161235870.png)

### 键盘输入语句

```java
import java.util.Scanner;  //把java.util下的Scanner类导入

public class Input{

	public static void main(String[] args) {
		//创建Scanner对象
		Scanner myScanner = new Scanner(System.in);
		System.out.println("输入名字：");
		String name = myScanner.next();
		System.out.println("输入年龄：");
		int age = myScanner.nextInt();
		System.out.println("输入薪水：");
		double money = myScanner.nextDouble();
		System.out.println("名字="+name+"年龄="+age+"薪水"+money);
	}
}
```

### 包

#### 包的命名：

只能包含数字、字母、下划线、小圆点。不能用数字开头，不能是关键字或者保留字。

命名规范：

小写字母+小圆点

com.公司名.项目名.业务模块名

#### 常用的包

java.lang  默认已经引入

java.util  工具包

java.net   网络包

java.awt  GUI，java界面开发

#### 引入包

1.引入包中的某个类

import java.util.Scanner;

2.引入整个包

import java.util.*;

### 快捷键

##### ALT+INSERT ---------Generate

 getter and setter 可自动生成get/set函数



### 断点调试

![image-20220128223147553](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128223147553.png)



### JUnit

使用步骤：

在方法前
@Test

即可单独对某个方法进行测试

```java
import org.junit.jupiter.api.Test;

public class System__ {
    public static void main(String[] args) {

    }

    @Test
    public void A(int a) {
        System.out.println(a);
    }

    public void B(int b) {
        System.out.println(b);
    }
}

```





### IDEA快捷键

ctrl+Y 删除行

ctrl+D 复制该行

ctrl+alt+\ 格式化

## CH.2

### 转义字符

\t   一个制表位，实现对齐的功能

\n  换行符

\\\  

\\"

\\'

\r  回车

### +号的使用

1.加号两边都为数值时，做加法运算

2.两边有一方为字符串，做拼接运算

例：

System.out.println(100+3+"hello");------------------103hello

System.out.println("100"+98);-------------------------10098 

### 数据类型

![image-20220120144306135](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120144306135.png)

共8种，背下来！（【1/2/4/8】表示占用字节大小）

数值型： 整型{byte,short,int,long}   浮点型{float,double}

字符型char

布尔型boolean

#### 1.整型细节

**Java的整型常量默认为int型，声明long型常量须后加'l'或者'L'**

123---------默认为int 

123l

123L--------为long

int a=123L  会报错，因为把123这个long型赋值给了int型的a，内存占用字节不同，可能会丢失数据。

#### 2.浮点型细节

1.浮点数=符号位+指数位+尾数位

2.**Java的浮点型常量默认为double型，声明float型常量须后加'f'或者'F'**

3.浮点数表示形式：

第一种：5.12  0.512  .512

第二种：5.12e2  5.12e-2

**4.对运算结果是小数的结果进行判断，要小心！！应该以两个数的差值的绝对值，在某个精度范围判断。**

例如：8.1/3 ,理论上是2.7，而计算机得出2.6999999999999997

![image-20220120151753163](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120151753163.png)

#### 3.字符型细节

![image-20220120153239287](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120153239287.png)

重点：

**java中,char的本质是一个整数，可以直接给char赋值一个整数，然后输出时按照unicode字符输出。**



![image-20220120153520174](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120153520174.png)

#### 4.布尔类型boolean，与C++ bool写法不同

#### 5.基本数据类型转换

![image-20220120153900923](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120153900923.png)

精度由低到高自动转换

![image-20220120154409446](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120154409446.png)

#### 6.强制数据类型转换

![image-20220120154528737](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120154528737.png)

强制转换符(),将容量大的数据类型转换为容量小的数据类型



![image-20220120155051908](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120155051908.png)

#### 7.String和基本类型转换

1.基本数据类型转为String

数据+" "

```java
int a=1;
String b=a + " ";
```

2.String转为基本数据类型

调用parseXX函数

![image-20220120155631076](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220120155631076.png)

### 运算符

#### 1.关系运算符

c++里没有的：

| instanceof | 检查是否是类的对象 |
| :--------: | :----------------: |

#### 2.逻辑运算符

| a&b （逻辑与） | 若a为false，第二个条件也会判断，**效率低**   |
| :------------: | -------------------------------------------- |
|  a&&b 短路与   | 若a为false，则第二个条件不会判断，**效率高** |
|  a\|b 逻辑或   | 若a为true，第二个条件也会判断，**效率低**    |
| a\|\|b 短路或  | 若a为true，则第二个条件不会判断，**效率高**  |
|    !a 取反     |                                              |
|  a^b 逻辑异或  |                                              |

#### 3.三元运算符

条件表达式？表达式1：表达式2；

**要当作一个整体！！**

**true?new Integer(1):new Double(2)**

**输出为1.0，因为double精度搞，整个整体的数据类型提升为double**

### 数组

#### 初始化：

**动态初始化：**

1.数据量 数组名[] = new 数据类型[size]

```java
double array[] =new double[5];
```

2.先声明数组，再创建数组

``` java
double[] array;
//或者
double array[];
array=new int[5];
```

**静态初始化：**

数据类型 数组名[] = {x1,x2,x3.....}

```java
double array[] = {1.2.3.4.5};
```

#### 内存相关：

1.数组在默认情况下是引用传递，赋的值是地址

```java
int a[]={1,2,3};
int b[]=a; //将a的地址赋给b,b变化a也会变化
```

2.数组拷贝

想要创建数组b，使其等于a

```java
int a[]={1,2,3};
int b[] = new int[a.length];
```

3.数组扩容

数组已满，但添加一个新元素至数组尾部（需创建新数组）

```java
int a[] = {1,2,3};
int b[] = new int[a.length + 1];
for(int i=0;i<a.length;i++)
{
    b[i]=a[i];
}
b[b.length-1]=4;
a=b;       //把b的地址赋给a
```

#### 二维数组：

初始化:

```java
int[][] a={{1,2,3},{1,2,3}};

int a[][] = new int[2][3]; //动态初始化

 
```

 ![image-20220122122953511](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220122122953511.png)

### foreach循环

for-each循环是通过应该与数组内元素类型相同的变量进行遍历，直接得到数组内从下标为0的位置至最后一个位置的元素的元素值，便于数组内元素的查找。

```java
//for循环与for-each循环：
int [] a = new int [10];

//for循环遍历
for ( int i=0 ; i<10 ; i++ )
    a[i];

//for-each循环遍历
 
for ( int k : a);
```

**for-each循环基本语句：**

```
for ( 变量类型  变量名 : 数组名 ) {
    
    需要执行的循环语句;
 
}
```

### 

## CH.3 java

### 面向对象中级

#### 基本概念

##### ①属性及方法

：即成员变量及成员函数

属性的定义语法：访问修饰符 属性类型 属性名

```java
public/protected/默认/private int age;
```

![image-20220123214002490](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220123214002490.png)



方法的定义语法：

```java
public 返回数据类型 方法名 （形参列表）{
    .........
        return 
}
```



##### ②对象内存布局

![image-20220123213544025](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220123213544025.png)

特殊：字符串储存在方法区的常量池中，堆中存的是字符串首个字符的地址

##### ③对象创建过程

![image-20220123214629921](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220123214629921.png)

![image-20220123214644290](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220123214644290.png)

**加载类信息在方法区中**

##### ④方法调用机制

详情看P204

![image-20220123215409730](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220123215409730.png)



##### ⑤方法传参机制

当参数为引用性参数（储存在堆内）时，方法直接对改引用地址内所储存的数据进行修改。

**即传参时传的是地址**

但是！！！

传参传给的还是形参

例如：

```java
class Cat{
    public int age;
   
}
class tools{
     public void SetAge(Cat obj){
         obj=new Cat();
        obj.age=100;
    }
}
Cat a = new Cat();
a.age=10;
tools b = new ABC();
b.SetAge(a);

此时a.age任然为10

    ！！！！因为obj形参指向的是a的地址的内容，改变obj的指向，不会对原有的a造成任何影响。
    

```



#### 创建

```java
class Cat{
    int age;
    String color;
}
//1.先声明后创建
Cat cat1;
cat1 = new Cat();
//2.直接创建
Cat cat1 = new Cat();
```



#### 重载

1) 方法名必须相同
2) **形参列表必须不同**
3) 返回类型无要求

```java
int Set(int a, int b)
double Set(int c, int d)
//不构成重载，两者形参列表相同
```



#### 可变参数

定义：同一个类中，多个同名同功能但参数个数不同的方法，封装成一个方法，既可以通过可变参数实现。

##### 基本语法：

**访问修饰符 返回类型 方法名(数据类型... 形参名)**{}

```java
public int Sum(int... numbers)
{
    //将numbers当作数组
    int sum=0;
    for(int i=0;i<numbers.length;i++)
    {
        sum+=numbers[i];
    }
    return sum;
}
```

##### **细节：**

**1.可变参数的实参也可以是数组**

```
int arr[]={1,2,3};
Sum(arr);
//同样可编译通过,结果为6，与Sum(1,2,3)结果相同
```

2.可变参数实质就是数组

**3.可变参数可以和普通类型参数同时出现在形参列表，但是必须放在最后**

```java
public int Sum(char a,double b,int... numbers)
```

**4.一个形参列表中只能出现一个可变参数**



#### 作用域

![image-20220124223712761](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220124223712761.png)

**重点：4、全局变量有默认值，局部变量没有默认值**

##### 细节：![image-20220124223853463](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220124223853463.png)

![image-20220124224354164](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220124224354164.png)



#### 构造器constructor

说明：

1) 相当于c++构造函数
2) 修饰符可以默认，也可以是其他

##### 语法：

修饰符 方法名(形参列表){方法体}

##### 细节：

（大部分和c++一样）

![image-20220124224944623](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220124224944623.png)

![image-20220124225005749](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220124225005749.png)



####  this关键字

this储存在堆区，指向所在类的地址

![image-20220125201110603](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125201110603.png)

##### 细节：

![image-20220125201435268](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125201435268.png)

访问构造器：

```java
class T
{
    public T()
    {
        //访问另一个构造器,且，必须放在第一条语句！！！！
        this("小黄",10);
        xxxxx
        xxxxx
    }
    
    public T(string name,int age)
    {
        System.out.println(name+age);
    }
}
```

#### 访问修饰符

public:对外公开

protected:对子类和同一个包中的类公开

默认：没有修饰符号，向同一个包中的类公开

private:只有类本身可以访问

![image-20220125203721530](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125203721530.png)



#### 封装

##### 快捷键

alt+insert -----------generate------------getter and setter

##### 封装与构造器

在构造器中使用Set函数，使得在构造过程中，使用SET函数中的条件判断等（例子中没有），合理构造。

```java
public class person {
    private int age;
    private String name;
    public person() {
        setAge(age);
        setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

#### 继承

##### 基本语法：

class 子类 extends 父类{}

```java
//父类 基类 超类
class student{}
//子类 派生类
class pupil extends student{}
```

##### 细节：

1.

**私有属性不能在子类里直接访问，**可以通过公共方法访问。

非私有属性可直接访问。

2.

子类必须调用父类的构造器，完成父类的初始化

（先调用父类的构造器，在调用子类的）

3.

![image-20220125224849390](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125224849390.png)

4.5.6.7.8.9.10

![image-20220125222226157](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125222226157.png)

![image-20220125222627361](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125222627361.png)

8.即层层追溯，从顶级开始调用构造器

![image-20220125222827537](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125222827537.png)

9.思考：让B/C继承C/B

 

##### 内存：

![image-20220125224412569](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125224412569.png)

一个属性多次储存，读取的时候读哪个呢？是子类还是父类的？答案如下：

![image-20220125224441820](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125224441820.png)

注：如果该类有这个属性，但是是private，此时不会再追溯到他的父类，而是报错（需添加公共方法获取属性）

#### super关键字

##### 基本：

![image-20220125225437288](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125225437288.png)

像是this，只不过指向该类的上级（父类、父类的父类.....直到找到为止）

##### 细节：

![image-20220125230537530](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125230537530.png)

![image-20220125230628349](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125230628349.png)

![image-20220125230729587](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220125230729587.png)



#### 方法重写/覆盖 override

##### 概念：

![image-20220128181234196](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128181234196.png)

（子类和父类不一定是一层的关系）

##### 细节：

![image-20220128181556106](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128181556106.png)

参数、方法名一定要一样。

返回类型一样或者是父类返回类型的子类  例如 父类返回类型：object 子类：String

**属性不存在重写**



#### 多态

##### 方法的多态：

重写和重载体现多态

重载：同一个类中，方法具有多种形态

重写：继承关系的类中，相同的方法根据继承关系呈现不同形态

##### **对象的多态：**（核心）

![image-20220128183836809](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128183836809.png)

运行类型可以变化，体现了多态（多种形态）

```java
public class main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.cry();
        animal = new Cat();
        animal.cry();

    }
}

class Animal {
    public void cry()
    {
        System.out.println("animal cry()");
    }
}
class Dog extends Animal{
    public void cry()
    {
        System.out.println("Dog cry() 汪汪");
    }
}
class Cat extends Animal{
    public void cry()
    {
        System.out.println("Cat cry() 喵喵");
    }
}

//运行结果为：
//Dog cry() 汪汪
//Cat cry() 喵喵
//animal编译类型为Animal,运行类型可变化，
```

##### 向上转型：

![image-20220128185408601](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128185408601.png)

**在编译阶段不能调用子类特有成员！：**

因为：在编译阶段，能调用哪些成员，是由编译类型来决定

编译类型为父类，无法调用子类特有成员



**在运行阶段：**

按照运行类型，运行对应方法。



##### **向下转型：**

![image-20220128190956323](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128190956323.png)

```java
Animal animal = new Dog();
Dog dog =(Dog) animal;//正确的
//Cat cat =(Cat) animal 错误的，因为aniaml本来指向的不是Dog
//向下转型必须指向所要转型的类型的对象！！（运行类型要与所转型类型一直）

```

**那如果编译类型是父类，如何调用子类特有成员呢？**----------------使用向下转型

```
Animal animal = new Dog();
//假设Dog类有特有方法Bark()
(Dog) animal.Bark();  //直接使用向下转型即可
```



##### 属性：

**属性的值看编译类型！！**

**属性不存在重写**

```java
class Animal {
    public int age = 10;
}
class Dog extends Animal{
    public int age = 20;
}
class Cat extends Animal{
     public int age = 30;
}
Animal animal = new Dog();//向上转型
System.out.println(animal.age);

//输出为10，属性的值看编译类型animal
```

![image-20220128192109744](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128192109744.png)

```java
Animal animal = new Dog();
Dog dog =(Dog) animal;
(animal instanceOf Animal)//值为true
(animal instanceOf Dog)  //值为true
```



##### **（非常重要）动态绑定机制：

![image-20220128193635174](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128193635174.png)

详见P315 0314



#### Object类

![image-20220128220040964](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128220040964.png)

##### ==和equals对比

![image-20220128220303586](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128220303586.png)

![image-20220128221240167](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128221240167.png)

**5、若不重写，则默认判断地址是否相等**



##### hashcode

![image-20220128222050760](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128222050760.png)



##### toString

![image-20220128222521968](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128222521968.png)



##### finalize

![image-20220128222957604](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220128222957604.png)





### 面向对象高级

#### static变量/类变量/静态变量

##### 存储区域：

JDK版本不同，存储区域不同。

1）存储在堆中

2）存储在方法区的静态域中

![image-20220130152020893](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130152020893.png)



##### 共识：

1) 同一个类所有对象共享

2) **static变量在类加载的时候就生成了** （也就是说只要类加载了，即使没创建对象，也能使用static变量）

   

##### 语法：

访问修饰符 static 数据类型 变量名；

static 访问修饰符 数据类型 变量名；



##### 如何访问：

类名.类变量名 （推荐）

对象名.类变量名



##### 细节：

![image-20220130152740772](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130152740772.png)



#### static方法/类方法/静态方法

##### 基本：

语法：访问修饰符 static 数据返回类型 方法名{} （推荐）

static 访问修饰符 数据返回类型 方法名{}



调用：

类名.类方法名

对象名.类方法名



##### 细节：

![image-20220130153732815](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130153732815.png)



![image-20220130153845448](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130153845448.png)

![image-20220130153942015](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130153942015.png)



**静态方法只能访问静态成员，不能使用this super**



#### main方法

![image-20220130154407729](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130154407729.png)

main方法由谁调用-----------JVM-----------需要public权限

不创建对象即可使用main方法---------------static

args数组的参数什么时候传进去的？----------执行程序时，参数1、参数2.........传入args

![image-20220130154821362](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130154821362.png)

用IDEA传参：

![image-20220130155530133](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130155530133.png)

![image-20220130155546573](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130155546573.png)

![image-20220130155735858](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130155735858.png)

填入参数即可，空格间隔



##### 细节：

![image-20220130155034302](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130155034302.png)

```java
package oop;

public class Static_learn {
    public int age;
    public static  String name;
    public static void show()
    {
        System.out.println(name);
    }
    public static void main(String[] args) {
        //System.out.println(age);  //不可以访问非静态成员age
        System.out.println(name); //可以访问静态成员name
        show();                   //可以访问静态方法，反之不行
    }
}
```





#### 代码块

##### 基本：

语法：

![image-20220130160357106](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130160357106.png)

```java
修饰符{
    代码
}；

    //修饰符只能为static，或者无修饰符
    //；可加可不加
```



##### 细节：

![image-20220130160504596](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130160504596.png)



![image-20220130161136928](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130161136928.png)

**static代码块是类加载时执行，只执行一次**

**普通代码块是对象创建时执行，创建一次执行一次**



![image-20220130161835910](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130161835910.png)



**static-----与类最相关**

**普通 ------与对象相关**

**所以创建对象时，先处理static,再处理普通**

**步骤：**

**1.按照代码顺序，初始化静态代码块和静态属性**

**2.按照代码顺序，初始化普通代码块和普通属性**

**3.调用构造方法**



![image-20220130162340589](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130162340589.png)



![image-20220130162457843](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130162457843.png)



加入继承关系后，创建对象时的调用步骤：

父类静态》》子类静态》》父类普通+构造器》》子类普通+构造器



步骤：

**1.静态代码块和属性初始化**

按照代码顺序，初始化父类静态代码块和静态属性，然后

按照代码顺序，初始化子类静态代码块和静态属性



**2.初始化父类普通+构造器**

按照代码顺序，初始化父类普通代码块和普通属性，然后

调用父类构造方法



**3.初始化子类普通+构造器**

按照代码顺序，初始化子类普通代码块和普通属性，然后

调用子类构造方法



#### 单例模式（待补充）

#### final关键字

##### 用于：

1. 不希望类被继承

   ```java
   final class Animal{
       
   }
   
   class Dog extends Animal{}//错误，不能被继承，因为关键字 final
   ```

   

2.不希望父类的某个方法被子类重写override

访问修饰符 final 返回类型 方法名

```java
class Animal{
	public final void cry(){};
    
}

class Dog extends Animal{
	public void cry(){
}		System.out.println("呜呜");
	}

```



3.不希望类的某个属性被修改

访问修饰符 final 类型 变量名



4.不希望某个局部变量被修改

局部变量：方法中定义的变量



##### 细节：

几个重要的：

**1.final修饰的属性又叫常量，一般用XX_XX_XX来命名**

**2.final修饰的属性在初始化时（定义时、构造器中、代码块中）必须赋初值，并且不能再修改**

**3.若修饰的属性是静态的，则只能在（定义时、代码块中）赋初值，不能在构造器中**

4.final类虽然不能继承，但是可以实例化（可以被创建，被new）

5.如果类不是final类，但是有final方法，则类可以被继承，但方法不能被重写

6.如果是final类，就不用final方法了

**7.final不能修饰构造器**

8.final和static一起用，效率更高，不会导致类加载

```java
public class Static_learn {
    public static void main(String[] args) {
        System.out.println(A.age);
    }
}

class A{
    public static final int age = 10;   //加了final,不会加载类，不会加载代码块
    static{
        System.out.println("代码块被加载");
    }
}
//输出结果: 10

//若不加final 输出结果：
//代码块被加载
//10
```

9.包装类String、Integer、Double.......类都是final类

![image-20220130205156833](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130205156833.png)

![image-20220130210230626](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130210230626.png)



#### 抽象类

当父类某些方法需要声明但不知道如何实现时，将其声明为抽象方法，这个类就是抽象类。

**访问修饰符 abstract 返回类型 方法名** 

但是

**1.存在抽象方法时，类要声明为抽象类 abstract class xxx{}**

**2.抽象方法不能有方法体，即不能有{}**

##### 细节：

![image-20220130210914266](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130210914266.png)

![image-20220130211127924](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130211127924.png)

![image-20220130211535929](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220130211535929.png)





#### 接口

##### 基本：

概念：给出一些没有实现的方法，封装到一起，到某个类要使用的时候，再根据具体情况写出来。

语法：

```java
修饰符 interface 接口名{  //修饰符只能是public和默认

//属性

//方法

}

class 类名 implements 接口{
    自己属性;
    自己方法;
    实现接口的方法;
}
```



##### 细节：



1、在接口中，抽象方法可以省略abstract关键字

2、目前(JDK8)，接口里可以有静态方法（需要实现）、默认方法（要加修饰符default）和抽象方法（没有方法体）

![image-20220201202159967](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201202159967.png)

![image-20220201202137762](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201202137762.png)

![image-20220201202833328](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201202833328.png)



**实现接口是对单继承机制的一种补充！**

个人理解：

接口为一个类带来 **特性**

继承为一个类带来 与**父类类似的共性**



![image-20220201203540361](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201203540361.png)



##### 接口的多态：

![image-20220201204630965](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201204630965.png)

```java
package oop.interface_;

public class equipment {
    public static void main(String[] args) {
        usb[] usbs = new usb[2];
        usbs[0] = new phone();
        usbs[1] = new computer();
        for(int i =0 ;i< usbs.length;i++)
        {
            usbs[i].start();
            if(usbs[i] instanceof phone)
            {
                ((phone)usbs[i]).call();
            }
        }
    }
}

class phone implements usb{

    @Override
    public void start() {
        System.out.println("手机开机.......");
    }

    public void call(){
        System.out.println(" 手机响了........");
    }
}

class computer implements  usb{

    @Override
    public void start() {
        System.out.println("电脑开机.......");
    }
}

public interface usb {
    public void start();
}

```

多态传递：

```java
public class extends_ {
    public static void main(String[] args) {
        //可直接用接口，创建对象，或者访问属性
        B b = new hi();
        A a = new hi();
    }
}

interface A{
    void hi();
}
interface B extends A{}
class hi implements  B{

    @Override
    public void hi() {
        System.out.println("hi.....");
    }
}
```



#### 内部类

##### 基本：

![image-20220201210033291](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201210033291.png)

![image-20220201210009456](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201210009456.png)



##### 局部内部类：

![image-20220201211424679](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201211424679.png)

![image-20220201212018807](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201212018807.png)



##### **匿名内部类！！！：**

**1.本质是一个类**

**2.同时是一个对象**(所以可以直接访问函数、属性)

3.没有名字

4.是一个内部类 



语法：

```
new 类或接口(参数列表){
	类体
};
```

基于接口的匿名内部类：

```java
package oop.innerclass;
//匿名内部类
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.test();
    }
}

class Animal{
    public void test(){
        //一般的实现老虎叫，写一个tiger类，再创建一个对象tiger，调用函数，但是这样做很浪费
//        tiger temp = new tiger();
//        temp.cry();

        //匿名内部类,简化开发：
        //实际上，系统自动创建了一个类,XXXX系统命名为Animal$1
        //tiger的编译类型为A，运行类型为Animal$1  !!!
//            class XXXX implements A{
//       		  @Override
//                public void cry() {
//                System.out.println("老虎叫..........");
            }
//            }
        A tiger = new A(){
            @Override
            public void cry() {
                System.out.println("老虎叫..........");
            }
        };
        tiger.cry();
        System.out.println(tiger.getClass());
    }

}

/*class tiger implements A{

    @Override
    public void cry() {
        System.out.println("老虎叫.......");
    }
}*/

interface A{
    public void cry();
}
```

![image-20220201215000694](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201215000694.png)

![image-20220201215011838](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201215011838.png)



基于类的匿名内部类：

```Java
class people{
    public void test(){
        //基于类的匿名内部类
        //括号中形参会传给构造器
        //系统自动创建名为people$1的类
//        class people$1 extends father{
//        }
        //编译类型为father,运行类型为people$1
        father p1 = new father("王刚"){ //new father..可视为创建了一个对象，也是创建了一个类
            public void show(){
                System.out.println("匿名内部类.......");
            }
        };
        p1.show();
        System.out.println(p1.getClass());
    }

}

class father{
    private String name;

    public father(String name) {
        this.name = name;
    }

    public void show(){};
}
```

![image-20220201221432817](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201221432817.png)

![image-20220201221447164](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201221447164.png)

![image-20220201221505779](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201221505779.png)



##### 成员内部类：

![image-20220201222236768](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201222236768.png)

![image-20220201222706769](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201222706769.png)

![image-20220201222752298](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201222752298.png)





##### 静态内部类：

![image-20220201222836964](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201222836964.png)

![image-20220201222924685](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201222924685.png)

![image-20220201222944293](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201222944293.png)

![image-20220201223031129](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220201223031129.png)



### 枚举和注解

#### 枚举

##### 自定义枚举类

![image-20220202212312728](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202212312728.png)

![image-20220202212253906](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202212253906.png)

```java
class Season{
    private String name;
    private String description;

    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public final static Season SPRING = new Season("春天","温暖");
    public final static Season SUMMER = new Season("夏天","炎热");
    public final static Season AUTUMN = new Season("秋天","凉爽");
    public final static Season WINTER = new Season("冬天","寒冷");

}
```

##### enum枚举类

###### 基础：

![image-20220202213605422](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202213605422.png)

1.枚举类默认继承Enum类

2.枚举对象放在代码的首部

```java
enum Season2{
    SPRING("春天","温暖"),SUMMER("夏天","炎热")
    ,AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷"); //枚举对象放在代码的首部
    private String name;
    private String description;

    private Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String toString() {
        return "Season" + name + "desc" + description;
    }
}
```

###### enum类的成员方法

![image-20220202214012359](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202214012359.png)

![image-20220202214130502](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202214130502.png)





###### 细节：

![image-20220202214828041](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202214828041.png)







#### 注解

![image-20220202214957074](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202214957074.png)

![image-20220202215014689](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202215014689.png)

##### @Override

![image-20220202215152776](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202215152776.png)

![image-20220202215300965](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202215300965.png)



##### @Deprecated

![image-20220202215521501](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202215521501.png)

过时，但可以用





##### @SuppressWarnings

例：

```java
@SuppressWarnings({unchecked,rawtypes})
```

![image-20220202215855822](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202215855822.png)



##### 元注解

![image-20220202220027356](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202220027356.png)









### 异常

快捷键ctrl + alt + t

![image-20220202221933858](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202221933858.png)

**下图重要！！**

![image-20220202222445442](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202222445442.png)

![image-20220202222730654](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202222730654.png)

![image-20220202222805824](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202222805824.png)



#### try-catch-finally

![image-20220202223031373](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202223031373.png)

![image-20220202223545605](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202223545605.png)

![image-20220202223604428](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202223604428.png)

![image-20220202223650419](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202223650419.png)

#### throws

![image-20220202223237021](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202223237021.png)



![image-20220202223941549](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202223941549.png)

![image-20220202224452216](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202224452216.png)



**假如try-catch-finally中，没有对异常进行处理，会自动throw**

**若 throw的是运行异常，则程序员可以不处理，因为有默认处理机制**



#### 自定义异常

![image-20220202224753653](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202224753653.png)



#### throw和throws

![image-20220202224959813](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202224959813.png)







### 常用类

#### 包装类Wrapper

![image-20220202225532034](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202225532034.png)

继承和接口关系图：

Boolean和Character都实现了Serializable和Comparable，继承了Object类

剩下六个：

![image-20220202225724618](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202225724618.png)





##### 装箱和拆箱

![image-20220202230451272](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202230451272.png)

手动装箱拆箱：

```java
int i =10;
        //装箱
        Integer i1 = new Integer(i);
        Integer i2 = Integer.valueOf(i);
        //拆箱
        Integer j = new Integer(99);
        int j1 = j.intValue();
```

自动装箱拆箱：

**底层调用的是valueOf方法！！返回的是该值对应类的地址**

```java
int i =10;
//装箱
Integer i1 = i;
Integer i2 = new Integer(99);
//拆箱
int j = i1;
```



##### 包装类方法

![image-20220202232148327](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202232148327.png)

![image-20220202232216623](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202232216623.png)



#### 字符串类

##### String类

###### 基本

![image-20220202233105994](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202233105994.png)

![image-20220202233423937](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202233423937.png)



###### 存储

![image-20220202233956006](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202233956006.png)



![image-20220202234005277](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220202234005277.png)



##### StringBuffer

StringBuffer是一个容器类，可对字符串进行增删...

![image-20220204183001985](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204183001985.png)

![image-20220204174840450](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204174840450.png)



![image-20220204174603688](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204174603688.png)



**String类，字符串实际存放在方法区的常量池中。**

**StringBuffer类，字符串实际存放在堆中。**



构造器

![image-20220204175416137](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204175416137.png)

**注：StringBuffer(String str)构造器，初始容量为：str长度+16**



###### 转换

![image-20220204180233500](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204180233500.png)



###### 方法

![image-20220204180709300](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204180709300.png)

start,end均为索引

**注：**

```java
append("str");
//在字符串尾追加
delete(start,end); 
//从索引为start开始，一直删到end，但不包含end
insert(8,"str");
//在索引为8的地方插入str其余后移

```



append函数

```java
String str= null;
StringBuffer sb = new StringBuffer();
sb.append(str);
System.out.println(sb.length());
//输出为4
System.out.println(sb);
//输出为null
```

![image-20220204181834047](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204181834047.png)

若append的是null,则直接会将null四个字母输入字符串，因此长度为4





##### StringBuilder

![image-20220204182334661](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204182334661.png)

![image-20220204182403929](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204182403929.png)

![image-20220204182705325](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204182705325.png)



**大部分和StringBuffer一样，除了线程方面的问题**



##### 三者比较

![image-20220204183108963](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204183108963.png)



String的内容存在常量池中，进行增删改只是在常量池中新建内容，再重新指向，因此效率低，大量操作可能会导致内存占用多又效率低



![image-20220204183452310](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204183452310.png)







#### Math类

![image-20220204184325082](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204184325082.png)

![image-20220204185018850](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204185018850.png)

```java
int a=9,b=3;
        (int)(b+Math.random()*(a-b))     //3<= x <9
        (int)(b+Math.random()*(a-b+1))   //3<= x <10，因为取整，所以相当于3<= x <=9
```





#### Arrays类



![image-20220204192113912](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192113912.png)

![image-20220204192322731](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192322731.png)

1.toString

将数组转成字符串输出

```java
Integer[] integers = {1,2,3};
System.out.println(Arrays.toString(integers));
```



3.binarySearch

![image-20220204192227714](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192227714.png)



4.copyOf

![image-20220204192501189](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192501189.png)



5.fill

![image-20220204192541804](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192541804.png)

将num里的数值全部替换成 99



6.equals

![image-20220204192631525](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192631525.png)



7.asList

![image-20220204192945849](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204192945849.png)





#### System类

exit

![image-20220204202852397](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204202852397.png)

araycopy

![image-20220204203144630](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204203144630.png)



currentTimeMillis 

![image-20220204203251291](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204203251291.png)



gc

![image-20220204203348079](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204203348079.png)





#### 大数处理方案

当需要处理很大的数， long不够用，用BigInteger类

```java
BigInteger bigInteger = new BigInteger("99999999999999999999999999999999");
System.out.println(bigInteger);
```

但加减乘除需要调用方法，不能使用常规符号

需要新建两个BigInteger类进行操作

![image-20220204204356960](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204204356960.png)





当需要处理精度很高的数时， double不够用，用BigInteger类

```java
BigDecimal bigDecimal = new BigDecimal("99.999999999999999999999999999999");
System.out.println(bigDecimal);
```

方法同上

注意：当使用divide时，如果结果是无限循环小数，会报错，需要指定精度,添加参数ROUND_CEILING(精度与被除数相同)

```
BigDecimal bigDecimal1 = new BigDecimal("99.999999999999999999999999999999");
BigDecimal bigDecimal2 = new BigDecimal("1.9");
System.out.println(bigDecimal1.divide(bigDecimal2,BigDecimal.ROUND_CEILING));
```





#### 日期类

##### 第一代日期类

![image-20220204205748460](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204205748460.png)



1.创建并输出当前时间

![image-20220204210817701](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204210817701.png)



2.输入输出日期

![image-20220204210453221](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204210453221.png)



3.转换日期

![image-20220204211601286](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204211601286.png)





##### Calendar

![image-20220204211703478](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204211703478.png)



构建Calendar，不能new，因为是抽象类

![image-20220204211958968](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204211958968.png)

![image-20220204212024336](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204212024336.png)



##### 第三代日期类

![image-20220204212144686](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204212144686.png)

![image-20220204212203504](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204212203504.png)



![image-20220204212356617](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204212356617.png)

![image-20220204212528749](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204212528749.png)





### 集合Collection

#### 概念与分类

![image-20220204214354157](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204214354157.png)

![image-20220204214405116](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204214405116.png)

**实现的类有很多，不止图中的类**

![image-20220204215756170](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204215756170.png)



#### collection接口方法

![image-20220204223132209](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204223132209.png)



#### 迭代器遍历

##### Iterator

![image-20220204221738275](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204221738275.png)

![image-20220204221825636](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204221825636.png)

![image-20220204221849821](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204221849821.png)



tips:

1.快捷键  itit

2.如果需要再次遍历，则重置迭代器

```java
 Collection col = new Collection();
        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {  //快捷键itit
            Object next =  iterator.next();
            
        }
        iterator = col.iterator();//重置
```





##### 增强for循环

![image-20220204222514627](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204222514627.png)

1.和foreach差不多

2.底层还是迭代器，只是简化了而已

3.快捷键 I （大写）

```java
for (Object obj:col) {
            
        }
```







#### List

##### list接口

![image-20220204223845954](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204223845954.png)

补充：8）实际范围为前闭后开





##### ArrayList

###### 注意事项：

![image-20220204224407026](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204224407026.png)



###### 扩容机制：

![image-20220204224652005](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204224652005.png)

transient 表示瞬间、短暂的，表示该属性不会被序列号



源码分析部分看0510 0511



##### Vector

###### 基本

![image-20220204232002698](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204232002698.png)



###### 对比

![image-20220204232418909](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220204232418909.png)





##### Linkedlist

![image-20220205205529782](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205205529782.png)

![image-20220205205546041](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205205546041.png)



###### 对比

![image-20220205210125282](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205210125282.png)





#### Set（待学）

##### Set接口

![image-20220205210257811](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205210257811.png)



![image-20220205210419568](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205210419568.png)



















### 泛型

#### 基本

![image-20220205211737086](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205211737086.png)

![image-20220205212435179](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205212435179.png)



泛型的声明：

```
interface 接口名<T>{}
class 类名<k,v>{}           //泛型可以是多个
```



#### 细节

**1.泛型只能是引用类型，基本数据类型如int,double不可以**

2.指定泛型后，可传入该类型本身，以及他的子类

```java
class A{}
class B extends A{}

  ArrayList<A> example = new ArrayList<A>();
  ArrayList<B> example = new ArrayList<B>();
```

3.泛型定义有两种

```java
ArrayList<A> example = new ArrayList<A>();
ArrayList<B> example = new ArrayList<>();   //后面可简写，推荐
```

4.不指定泛型，会默认为Object (针对于代码中实现泛型的类)

```java
ArrayList example = new ArrayList();
ArrayList<Object> example = new ArrayList<>();
```



![image-20220205214226039](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205214226039.png)

![image-20220205214534746](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205214534746.png)



**泛型方法需要注意！！，和C++的T Show(){    }之类的有区别**

![image-20220205214933673](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205214933673.png)

4.泛型方法，可以使用自己的泛型，也可以使用泛型类中的泛型

```
class Dog<T,K>{
            public <T,S> void Show(T t,S s){  
            //泛型方法，使用了泛型T、S，当使用方法传参时，t和s的类型编译器会自动确定
                System.out.println(t);
                System.out.println(s);
            }
        }
```



泛型继承与通配

1.**泛型没有继承性！！**

```java
 ArrayList<Object> example = new ArrayList<String>();
//错误的
```

2.<?>          <? extends A>                <? super A>   

其作用是限制能传进去的数据类型种类

![image-20220205220118020](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220205220118020.png)









### 多线程

线程：单个程序中多个任务运行

进程：多个程序运行



并发：同一时刻多个任务交替运行，造成“貌似同时”的错觉。单核CPU实现的任务就是并发。

并行： 同一时刻，多个任务同时运行。多核CPU可以并行



#### Thread

![image-20220720211745494](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220720211745494.png)

（Thread类实现了Runnable接口）

当一个类继承了Thread类，那么这个类可以当作一个线程使用。

重写run方法，来写上自己的业务代码。



创建一个类继承Thread:

```java
package xiancheng;

public class threadxx {
    public static void main(String[] args) {
        cat cat = new cat();
        cat.start(); //运行cat线程
        
        while(true){ //运行主线程
            System.out.println("i'm a dog. Wang~"  + "线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class cat extends Thread{
    int time = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("i'm a cat. Miao~" + "第" + time + "次" + "线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time ++;

        }

    }
}
//继承了Thread类，创建了cat子类

```

**当主线程结束后，cat线程并不结束，两者独立运行。当所有线程结束后，整个进程结束。**

为什么要用start，而不是run?

------因为如果调用run方法，还是会在同一个进程中运行该方法，**而不是创建一个新进程**。在上述代码中，也就是再main进程中运行

------start方法会调用start0方法，start0函数是一个底层函数，JVM调用，由c++实现，根据操作系统不同，实现方法不同。



用接口创建类：

```java
package xiancheng;

public class threadxy {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Thread thread = new Thread(cat);  //创建一个Thread对象，把cat放进去,再调用thread的start,这里是“代理模式”的设计模式
        thread.start();
        Thread thread1 = new Thread(dog);
        thread1.start();
    }
}

class Cat implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        while(count<=20){
            try {
                System.out.println("hi" + count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
        }
    }
}
```

![image-20220720223906722](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220720223906722.png)

Runnable接口方式，创建一个对象，可以放到多个Thread中，创建出多个进程



#### 线程终止

两种情况：

1、线程执行任务完成后自动退出

2、使用一个变量，来人为控制停止线程，即通知方式



手动设置变量：

```java
package xiancheng;

public class stop {
    public static void main(String[] args) {
        ABCD abcd = new ABCD();
        Thread thread = new Thread(abcd);
        thread.start();

        //过十秒再停止线程
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        abcd.setLoop(false);
    }
}

class ABCD implements Runnable{
    private int count =0;
    private boolean loop = true ;

    @Override
    public void run() {
        while(loop){        //当LOOP为FALSE，线程终止
            try {
                Thread.sleep(1000);
                System.out.println("hi~~~~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {    //手动控制
        this.loop = loop;
    }
}
```



#### 线程常用方法

```java
1. setName //设置线程名称，使之与参数name相同
2. getName //返回该线程的名称
3. start //使该线程开始执行; Java虚拟机底层调用该线程的start0方法
4. run //调用线程对象 run方法;
5. setPriority //更改线程的优先级 
    void setPriority(int newPriority);
	MIN_PRIORITY
    NORM_PRIORITY
    MAX_PRIORITY
6. getPriority //获取线程的优先级
7. sleep //在指定的毫秒数内让当前正在执行的线程休眠(暂停执行)
8. interrupt //中断线程，每个线程有个boolean标志来表示中断了与否，可使用Thread.currentThread().isInterrupted()查看
    

```

注意事项和细节： 

1. start底层会创建新的线程，调用run, run就是一个简单的方法调用，不会启动新线程
2. 线程优先级的范围
3. interrupt,中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程
4. sleep:线程的静态方法，使当前线程休眠

```java
9. yield  //线程的礼让。让出cpu,让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
10. join  //线程的插队。插队的线程一旦插队成功， 则肯定先执行完插入的线程所有的任务

```

join:

```java
package xiancheng;

public class stop {
    public static void main(String[] args) {
        ABCD abcd = new ABCD();
        Thread thread = new Thread(abcd);
        thread.start();

        try {
            for(int i=0;i<=20;i++){
                System.out.println("主线程" + i);
                if(i>=5) thread.join();    //主线程输出5次后让子线程运行完
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ABCD implements Runnable{
    private int count =0;
    @Override
    public void run() {
        while(count<=20){     
            try {
                Thread.sleep(1000);
                System.out.println("子线程"+ count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}
```



#### 守护线程

用户线程和守护线程
1.用户线程:也叫工作线程，当线程的任务执行完或通知方式结束
2.守护线程:**唯一用途是为工作线程服务的**，所以当所有的用户线程结束，守护线程自动结束
3.常见的守护线程:垃圾回收机制



设置为守护线程： 

```java
t.setDaemon(true)

//函数定义 
    void setDaemon(bboolean isDaemon)
    
    
//需要先设置为守护线程，再启动该线程
//t.setDaemon(true);
//t.start();
```



#### 线程状态



![image-20220721224751550](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220721224751550.png)

![Java线程的6种状态及切换(透彻讲解)_潘建南的博客-CSDN博客_线程的5种状态](https://img-blog.csdnimg.cn/20181120173640764.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3BhbmdlMTk5MQ==,size_16,color_FFFFFF,t_70)

共七种状态，runnable包含running和ready



获取状态：

```java
t.getState()
```





#### 同步

JAVA核心卷1 P563



多个线程访问同一数据，造成破坏，称为**竞态条件**。为了避免该情况，使用同步数据存取。



##### Synchronized关键字：

在介绍关键字之前，要先学习一下锁和条件对象。

互斥锁：(ReentrantLock类，手动创建一个锁)

```java
  ReentrantLock lock = new ReentrantLock();
    lock.lock();
    try {
        ...
    }
    finally {       //使用try ... finally来完成锁的释放，因为如果有异常，这个锁必须释放，否则会停止整个进程
        lock.unlock();
    }

```

```
void lock() //锁住
void unlock（） //释放这个锁
```



条件对象：

当被同步的线程，某个数据需要满足一定条件才能继续运行，需要别的进程先运行，来满足这个运行条件，这时候用到条件对象 .

 使用 ReentrantLock里的newCondition方法获得一个新条件对象

```java
ReentrantLock lock = new ReentrantLock(); //创建一个锁
    private Condition con = lock.newCondition();;                    //创建一个条件对象
    lock.lock();
    try {
        ...
        //如果需要用到条件对象
        con.await();  //让该线程进入等待集，从runnable到Blocked
        
        //满足条件了之后,shifang
        con.signalAll();  //从等待集中释放该线程,从Blocked到runnable
        
    }
    finally {
        lock.unlock();
    }
```



Synchronized关键字:

java1.0后，每个对象有个内部锁。每个线程会去争夺这把锁，谁得到这把锁就运行，其余的被阻塞。

对代码块/方法加了一把锁，说明只能由一个线程来运行这个代码块/方法。

```
互斥锁
基本介绍
1. Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性。
2.每个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一-时刻， 只
能有一个线程访问该对象。
3.关键字synchronized来与对象的互斥锁联系。当某个对象用synchronized修饰时，
表明该对象在任- -时刻只能由一个线程访问
4.同步的局限性:导致程序的执行效率要降低
5.同步方法(非静态的)的锁可以是this, 也可以是其他对象(要求是同一个对象)
6.同步方法(静态的)的锁为当前类本身。

●注意事项和细节
1.同步方法如果没有使用static修饰:默认锁对象为this
2.如果方法使用static修饰，默认锁对象:当前类.class  

public static void method(){
	synchronized (当前类.class) {
        //需要被同步的代码
}
}


3.实现的落地步骤:
需要先分析上锁的代码
选择同步代码块或同步方法
要求多个线程的锁对象为同一个即可!


```

加了Synchronized关键字，别的线程想要调用这个方法，需要获得内部锁。

```java
// 同步方法

public synchronized void method(){
        ...
    }
    
//相当于
public void method(){
        lock.lock();
    try {
            ...
        }
    finally {
            lock.unlock();
        }
 }


//可以使用wait()   notifyall() 来实现加入等待集/释放
//与await() signall()等价
```



同步块：

```java
格式：
synchronized (obj) {
        //需要被同步的代码
}

//对一个obj对象上锁
```





#### 死锁

多个线程同时占用了对方的锁资源，导致了死锁。（线程A在使用锁A，接着需要用锁B，而线程B在使用锁B，接着需要锁A，造成死锁）



**线程释放锁的条件**：

1、线程任务结束

2、线程中遇到break或return

3、出现异常

4、调用wait()函数，线程暂停并释放该锁

**不会释放锁的情况**：

1、Thread.sleep() 、Thread.yield()方法只会暂停当前线程，不会释放锁 

2、线程执行同步代码块时，其他线程调用了该线程的suspend(方法将该线程挂起，该线程不会释放锁。
提示:应尽量避免使用suspend()和resume()来控制线程，方法不再推荐使用





### IO流

#### 概念

![image-20220810220224236](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220810220224236.png)

#### File

创建File对象

```java

File构造器：
File(String pathname)
File(File parent,String child)
File(String parent,String child)


public void create(){
        String pathname = "E:\\810.txt";
        File file = new File(pathname);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create2()  {
        File parentFile = new File("E:\\");
        String filename = "8100.txt";
        File file = new File(parentFile, filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 
    public void create3(){
        String parentPath = "e:\\";
        String filename = "8101.txt";
        File file = new File(parentPath, filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

获取文件相关信息：

```java
获取属性：
public String getAbsolutePath() ：返回此File的绝对路径名字符串。
public String getPath() ：将此File转换为路径名字符串。
public String getName() ：返回由此File表示的文件或目录的名称。
public long length() ：返回由此File表示的文件的字节长度。

判断功能：
public boolean exists() ：此File表示的文件或目录是否实际存在。
public boolean isDirectory() ：此File表示的是否为目录。
public boolean isFile() ：此File表示的是否为文件。
    
创建删除：
public boolean createNewFile() ：文件不存在，创建一个新的空文件并返回true，文件存在，不创建文件并返回false。
public boolean delete() ：删除由此File表示的文件或目录。
public boolean mkdir() ：创建由此File表示的目录。
public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
其中，mkdirs()和mkdir()方法类似，但mkdir()，只能创建一级目录，mkdirs()可以创建多级目录比如//a//b//c，所以开发中一般用mkdirs();
    
目录遍历：
public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。 //指定的目录必须存在，且指定的必须是目录。
    

```



#### 字节流

##### 字节输出流（OutputStream）

`java.io.OutputStream`抽象类是表示**字节输出流**的所有类的**超类**（父类）

包含以下子类：

FileOutputStream、



OutputStream通用方法：

```java
public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
public void write(byte[] b)：将 b.length个字节从指定的字节数组写入此输出流。
public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。 也就是说从off个字节数开始读取一直到len个字节结束
public abstract void write(int b) ：将指定的字节输出流。
```



###### FileOutputStream

```java
构造：
public FileOutputStream(File file)：根据File对象为参数创建对象。
public FileOutputStream(String name)： 根据名称字符串为参数创建对象。 //开发常用
//系统会自动去对应位置创建对应文件,如果有这个文件，会清空这个文件的数据 
//（如果目录没有，会报错！！要确保目录存在）
public FileOutputStream(File file, boolean append)    
public FileOutputStream(String name, boolean append)
 //append表示是否允许追加写入，false的话，创建了输出流对象便会清空，反之true不清空   
    
写出字节：
public void write(int b)  //ASCII码
public void write(byte[] b)
public void write(byte[] b,int off,int len)  //从`off`索引开始，`len`个字节

    
```



##### 字节输入流（InputStream）

`java.io.InputStream`抽象类是表示**字节输入流**的所有类的**超类**（父类），可以读取字节信息到内存中。它定义了字节输入流的基本共性功能方法。

共性方法：

```java
public void close() ：关闭此输入流并释放与此流相关联的任何系统资源。
public abstract int read()： 从输入流读取数据的下一个字节。
public int read(byte[] b)： 该方法返回的int值代表的是读取了多少个字节，读到几个返回几个，读取不到返回-1
```



###### FileInputStream

```java
构造方法：
FileInputStream(File file)： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
FileInputStream(String name)： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名name命名。  //推荐
//若路径下无该文件，不会创建，会报错
    
读：
public int read() //返回ASCII码数，读取到文件末尾，返回-1
public int read(byte[] b) //每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1 

在开发中一般强烈推荐使用数组读取文件，代码如下：
FileInputStream inputStream = null;
try {
    inputStream = new FileInputStream("a.txt");
    int len = 0 ;
    byte[] bys = new byte[1024];
    while ((len = inputStream.read(bys)) != -1) {
        System.out.println(new String(bys,0,len));
    }
} catch (IOException e) {
    e.printStackTrace();
}finally {
    try {
        inputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```



#### 字符流

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191015171311217.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0NTQzNTA4,size_16,color_FFFFFF,t_70)

字符流的由来：因为数据编码的不同，因而有了对字符进行高效操作的流对象，字符流本质其实就是基于字节流读取时，去查了指定的码表，而字节流直接读取数据会有乱码的问题（读中文会乱码，一个中文字符占用多个字节存储）



##### 字符输入流（Reader）

`java.io.Reader`抽象类是**字符输入流**的所有类的**超类**（父类），可以读取字符信息到内存中。它定义了字符输入流的基本共性功能方法。

共性方法：

```java
public void close() ：关闭此流并释放与此流相关联的任何系统资源。
public int read()： 从输入流读取一个字符。
public int read(char[] cbuf)： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中
```

##### FileReader

```java
构造：
FileReader(File file)： 创建一个新的 FileReader ，给定要读取的File对象。
FileReader(String fileName)： 创建一个新的 FileReader ，给定要读取的文件的字符串名称。
    
读：
public int read() 每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回-1
public int read(char[] cbuf, int off, int len)
    //与FileInputStream读取一样
```



##### 字符输出流（Writer）

`java.io.Writer`抽象类是**字符输出流**的所有类的**超类**（父类），将指定的字符信息写出到目的地。

共性方法：

```java
void write(int c) 写入单个字符。
void write(char[] cbuf)写入字符数组。
abstract void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
void write(String str)写入字符串。
void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
void flush()刷新该流的缓冲。
void close() 关闭此流，但要先刷新它。
```



##### FileWriter

```java
构造方法：
FileWriter(File file)： 创建一个新的 FileWriter，给定要读取的File对象。
FileWriter(String fileName)： 创建一个新的 FileWriter，给定要读取的文件的名称。
    
写：
void write(int c)  
void write(char[] cbuf,int off,int len)
```



#### close / flush

使用输出时，输出的内容存放于**内置缓冲区**，**关闭输出流后才讲内容写入文件中**（从内存写入硬盘）.

`flush` ：刷新缓冲区，流对象可以继续使用。
`close`：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。



#### 缓冲流

缓冲流,也叫高效流。

**缓冲流的基本原理**：

> 1、使用了底层流对象从具体设备上获取数据，并将数据存储到缓冲区的数组内。
> 2、通过缓冲区的read()方法从缓冲区获取具体的字符数据，这样就提高了效率。
> 3、如果用read方法读取字符数据，并存储到另一个容器中，直到读取到了换行符时，将另一个容器临时存储的数据转成字符串返回，就形成了readLine()功能。

也就是说在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

缓冲书写格式为`BufferedXxx`，按照数据类型分类：

- **字节缓冲流**：`BufferedInputStream`，`BufferedOutputStream`
- **字符缓冲流**：`BufferedReader`，`BufferedWriter`



##### 字节缓冲流 BufferedxxputStream

```java
构造：
public BufferedInputStream(InputStream in) ：创建一个新的缓冲输入流，注意参数类型为InputStream。
public BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流，注意参数类型为OutputStream。
//需要通过字节输入输出流来构造
//例：BufferedInputStream bInput = new BufferedInputStream(new FileInputStream("e:\\CCCCSSSS\\8200.txt"));

// read和write，与字节输入输出流一致

```



##### 字符缓冲流 Bufferedxxx

```java
构造：
public BufferedReader(Reader in) ：创建一个新的缓冲输入流，注意参数类型为Reader。
public BufferedWriter(Writer out)： 创建一个新的缓冲输出流，注意参数类型为Writer。
// read和write，与字节输入输出流一致
    
特有方法：
BufferedReader：public String readLine(): 读一行数据。 读取到最后返回null
BufferedWriter：public void newLine(): 换行,由系统属性定义符号。
```





#### 转换流

编码:字符(能看懂的)--字节(看不懂的)

解码:字节(看不懂的)-->字符(能看懂的)

默认UTF-8编码，在解码别的编码时会出错，这是需要使用转换流



#####  InputStreamReader类

转换流`java.io.InputStreamReader`，是`Reader`的子类，**将字节流转换为字符流**

```java 
构造：
InputStreamReader(InputStream in): 创建一个使用默认字符集的字符流。
InputStreamReader(InputStream in, String charsetName): 创建一个指定字符集的字符流。
```

**为了达到最高效率，可以考虑在 `BufferedReader` 内包装 `InputStreamReader**（将字节流转换为字符流后通过缓冲区加速）



##### OutputStreamWriter类

(字符流到字节流的桥梁)

转换流`java.io.OutputStreamWriter` ，是Writer的子类，将**字符**流转换为**字节**流！！

```java
构造：
OutputStreamWriter(OutputStream in): 创建一个使用默认字符集的字符流。
OutputStreamWriter(OutputStream in, String charsetName): 创建一个指定字符集的字符流。
```



####  对象处理流 / 序列化流

对象序列化：（保存数据的值和数据类型）

用一个字节序列可以表示一个对象，该字节序列包含该**对象的数据**`、`**对象的类型**`和`**对象中存储的属性**`等信息。字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息。

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行**反序列化**。**对象的数据**`、`**对象的类型**`和`**对象中存储的数据**信息，都可以用来在内存中创建对象。



##### ObjectOutputStream类

`java.io.ObjectOutputStream` 类，将Java对象的原始数据类型**写出**到文件,实现对象的持久存储。

```Java
构造：
public ObjectOutputStream(OutputStream out)

写出对象方法：
public final void writeObject (Object obj) : 将指定的对象写出。
```



##### 序列化操作：

1. 一个对象要想序列化，必须满足两个条件:

**该类必须实现`java.io.Serializable` 接口**，`Serializable` 是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出`NotSerializableException` 。

**该类的所有属性必须是可序列化的**。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用**transient 关键字**修饰。

```Java
public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
      	System.out.println("Address  check : " + name + " -- " + address);
    }
}
```



2. 使用ObjectOutputStream的**writeObject**方法



##### ObjectInputStream类

ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。

```java
构造方法:
public ObjectInputStream(InputStream in)： 创建一个指定InputStream的ObjectInputStream。

读取：
    public final Object readObject () : 读取一个对象,返回该对象。
  
```

```java
Employee e = null;
ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
e = (Employee) in.readObject();
```



##### 注意事项：

![image-20220811215900557](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220811215900557.png)

当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么反序列化操作也会失败，抛出一个`InvalidClassException`异常。发生这个异常的原因如下：

> 1、该类的序列版本号与从流中读取的类描述符的版本号不匹配
> 2、该类包含未知数据类型
> 2、该类没有可访问的无参数构造方法

`Serializable` 接口给需要序列化的类，提供了一个序列版本号。**serialVersionUID** 该版本号的目的在于验证序列化的对象和对应类是否版本匹配。

```
public class Employee implements java.io.Serializable {
     // 加入序列版本号
     private static final long serialVersionUID = 1L;
     public String name;
     public String address;
     // 添加新的属性 ,重新编译, 可以反序列化,该属性赋为默认值.
     public int eid; 

     public void addressCheck() {
         System.out.println("Address  check : " + name + " -- " + address);
     }
}
```





#### Properties

传统方法读配置文件：

```java
//假设有文件名为mysql.properties的配置文件
//内容为：
ip=1111
name="hzc"
age=12
```

```java
public class file_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("e:\\mysql.properties"));
        String ss = null;
        while((ss = bf.readLine()) != null){
            String split[] = ss.split("=");
            System.out.println(split[0] + "是" + split[1]);
        }
    }
}
```



`java.util.Properties` 继承于`Hashtable` ，来表示一个持久的属性集。它使用键值结构存储数据，每个键及其对应值都是一个字符串

```java
构造：
public Properties() :创建一个空的属性列表。

方法：
public Object setProperty(String key, String value) ： 保存一对属性。
public String getProperty(String key) ：使用此属性列表中指定的键搜索属性值。
public Set<String> stringPropertyNames() ：所有键的名称的集合。
    
**与流相关方法：
public void load(InputStream inStream)： 从字节输入流中读取键值对。
```

使用Properties后：

```java
public class file_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("e:\\mysql.properties"));
        /*String ss = null;
        while((ss = bf.readLine()) != null){
            String split[] = ss.split("=");
            System.out.println(split[0] + "是" + split[1]);
        }*/
        Properties pp = new Properties();
        pp.load(bf);
        Set<String> ss = pp.stringPropertyNames();
        for(String key : ss){
            System.out.println(key + "-----" + pp.getProperty(key));
        }
    }
}
```



#### 打印流

**字节打印流PrintStream**是OutputStream的子类，**字符打印流PrintWriter**是Writer的子类

```java
构造：
public PrintStream/PrintWriter(File file)：根据File对象为参数创建对象。
public PrintStream/PrintWriter(String name)： 根据名称字符串为参数创建对象。

打印方法：
print方法和println
```



#### 标准输入输出流 

|            | 运行类型            | 编译类型    |
| ---------- | ------------------- | ----------- |
| System.in  | BufferedInputStream | InputStream |
| System.out | PrintStream         | PrintStream |



### 反射

```
一个需求引出反射
●
请看下面的问题
1.根据配置文件re.properties指定信息，创建Cat对象并调用方法hi
classfullpath= com.hspedu.Cat
method=hi
老韩思考:使用现有技术，你能做的吗?
2.这样的需求在学习框架时特别多，即通过外部文件配置，在不修改源码情
况下，来控制程序，也符合设计模式的ocp原则(开闭原则:不修改源码，
扩容功能)

```

关键词：根据配置信息  不修改源码





1.反射机制允许程序在执行期借助 Reflection API取得任何类的内部信息(比如成员变量，构造器，成员方法等等)，并能操作对象的属性及方法。反射在设计模式和框架底层都会用到
2**.加载完类之后，在堆中就产生了一个Class类型的对象(- 一个类只有一个Class对象) ,这个对象包含了类的完整结构信息。通过这个对象得到类的结构。这个Class对象就像一面镜子，透过这个镜子看到类的结构，所以，形象的称之**
**为:反射**

反射，能告诉你类的信息。



![image-20220728164540333](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728164540333.png)

代码编译过后，编译的文件里存放着类的信息，根据这些信息加载类，便体现反射机制



●Java反射机制可以完成
1.在运行时判断任意-个对象所属的类
2.在运行时构造任意个类的对象
3.在运行时得到任意一个类所具有的成员变量和方法
4.在运行时调用任意一个对象的成员变量和方法
5.生成动态代理



●反射相关的主要类:
1. java.lang.Class:代表一个类， Class对象表示某个类加载后在堆中的对象

2. java.lang.reflect.Method:代表类的方法

3. java.lang.reflect.Field:代表类的成员变量

4. java.lang.reflect.Constructor:代表类的构造方法
    这些类在java.lang.reflection

  

#### Class类

![image-20220728180427684](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728180427684.png)



1. Class也是类，因此也继承Object类
2. Class类对象不是new出来的，而是系统创建的
3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
4. 每个类的实例都会记得自己是由哪个Class实例所生成
5. 通过Class对象可以完整地得到一个类的完整结构，通过一系列API
6. Class对象是存放在堆的
7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括方法代码,变量名，方法名，访问权限等等) https://www.zhihu.com/question/38496907



#### 常用方法

##### 获取Class对象的方法

共**六种**

![image-20220728190957393](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728190957393.png)

1. 三个函数对应三个不同阶段获得class对象

2. 类加载器也能获得Class对象 （代码运行时自动获得）

   

   

   一、**forName**：通过指定的字符串路径获取 
   多用于配置文件，从配置文件中读取类路径，用forName加载类

```java
Class cls = Class.forName(pathName);
//Class cls = Class.forName("xiancheng.threadxx");


```



二、通过类名的属性class获取

多用于传参

```java
 Class cls = 类名.class;
// Class cls = ArrayList.class;
```



三、通过对象的getClass()方法获取

即获得对象的运行类型，多用于有对象实例时

```java
对象.getClass()
//Cat cat = new cat();
//Class cls = cat.class;
```



四、通过类加载器获得类的Class对象

```java
 ClassLoader classLoader = Cat.getClass().getClassLoader();
 Class aClass = classLoader.loadClass("oop.Cat");
```



五、基本数据类型获得Class对象

数据类型.class

```java
 Class<Integer> integerClass = int.class;
```



六、基本数据类型对应的包装类

包装类.TYPE  (注意大写)

```
Class<Integer.type> typeClass = Integer.type.class;
```

int 和 Integer 的Class类是同一个，以此类推..



如下类型有Class对象

1. 外部类，成员内部类，静态内部类，局部内部类，匿名内部类

2. interface :接口

3. 数组

4. enum :枚举

4. annotation :注解

5. 基本数据类型

6. void

   

##### 获取属性/为属性赋值

```java
//aClass 为class对象名称

//  获取构造方法、成员方法、成员变量(public）
Constructor<?>[] constructors = aClass.getConstructors();
Method[] methods = aClass.getMethods();
Field[] fields = aClass.getFields();

//  获取所有构造方法、成员方法、成员变量 （public + private）
Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();  //可在括号内填写string.class/int.class/....来匹配对应的构造器
Method[] declaredMethods = aClass.getDeclaredMethods()
Field[] declaredFields = aClass.getDeclaredFields();

//可以在括号中输入对应的变量名字，得到对应的单一变量
Field field = aClass.getFields("age");

//为obj对象的属性赋值
field.set(obj,"abcd")
//field.set(people,"10")    
//System.out.println(field.get(people));  //假设有people类，会输出field对应属性的值
```

```java
//获取类的完整名称
String name = aClass.getName();
String simpleName = aClass.getSimpleName();
String typeName = aClass.getTypeName();

//获得所在包的名字
String packageName = cls.getPackage.getName()

//直接输出 System.out.println(cls); 会输出Class + 类名（是哪个类的Class对象）
```

##### **创建实例**：

```java
//创建实例
Object newInstance = aClass.newInstance();
//Cat c1 = aClass.newInstance();
```

##### 调用method方法invoke：

```java
  Method m = aClass.getDeclaredMethod();
  m.invoke(Object obj,Object args[]);//obj是对象名，args是传入method方法的参数
```



##### 获取类结构信息

```java
第一组: java.lang.Class类

1. getName:获取全类名
2. getSimpleName:获取简单类名
3. getFields:获取所有public修饰的属性，包含本类以及父类的
4. getDeclaredFields:获取本类中所有属性
5. getMethods:获取所有public修饰的方法，包含本类以及父类的
6. getDeclaredMethods:获取本类中所有方法
7. getConstructors:获取所有public修饰的构造器，包含本类
8. getDeclaredConstructors:获取本类中所有构造器
9. getPackage:以Package形式返回包信息
10.getSuperClass:以Class形式返回父类信息
11.getInterfaces:以Class[]形式返回接口信息
12.getAnnotations:以Annotation]形式返回注解信息

```



```java
以下均为对属性、方法、构造器的方法

第二组: java.lang.reflect.Field类
    
1. getModifiers:以int形式返回修饰符
[说明:默认修饰符是0，public 是1，private是2，protected是4，static是8，final 是16, 不同修饰符值可以相加]
2. getType:以Class形式返回类型
3. getName:返回属性名

第三组: java.lang.reflect.Method类
    
1. getModifiers:以int形式返回修饰符
[说明:默认修饰符是0 ,public 是1 , private 是2 , protected 是4, static是8，final 是16，不同修饰符值可以相加]
2. getReturnType:以Class形式获取返回类型
3. getName:返回方法名
4. getParameterTypes:以Class[]返回参数类型数组
    

第四组: java.lang.reflect.Constructor类
1. getModifiers:以int形式返回修饰符
2. getName:返回构造器名(全类名)
3. getParameterTypes:以Class[]返回参数类型数组

```

https://blog.csdn.net/lydms/article/details/106458544



#### **加载类的过程**

1. 代码编译为字节码文件
2. 字节码文件通过类加载器ClassLoader中的loadClass()函数，进行加载![image-20220728181805947](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728181805947.png)

 3. 在**方法区**加载该类的字节码二进制数据/元数据，在**堆**中生成一个java.lang.Class类对象，作为方法区类数据的访问入口。

    ![image-20220728182110333](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728182110333.png)

 4. 这样就完成了类的加载

	3. 如果要创建一个对象实例，就会根据这个Class对象来创建



##### 静态加载与动态加载

反射机制是java实现动态语言的关键，也就是通过反射实现类动态加载。
1.静态加载:编译时加载相关的类，如果没有则报错，依赖性太强。

```java
if(abc > 10){
    Cat cat = new Cat();     //静态加载
}else{
    Class aClass = Class.forName("Cat");  //使用了反射，动态加载    
    Object o = aClass.newInstance();      //创建实例
}
System.out.println("hi");
//Cat可能不会被用到，静态加载：编译时就把他加载进去 动态加载：运行到它的时候再加载
```

2.动态加载:运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性



因此，类加载时机又增加了一个

1、new创建对象实例时 

2、子类被加载时

3、调用类的静态成员时	

4、通过反射

![image-20220728230159362](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728230159362.png)



![image-20220728230430286](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728230430286.png)



![image-20220728230636225](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728230636225.png)

![image-20220728230824447](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728230824447.png)

![image-20220728230900382](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728230900382.png)

![image-20220728231139059](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728231139059.png)

符号引用：https://www.cnblogs.com/qlky/p/7643524.html



![image-20220728231653198](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728231653198.png)



#### 反射调用优化

![image-20220728175956711](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728175956711.png)

![image-20220728180010884](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220728180010884.png)

访问安全检查会影响执行时间，关闭后可提高效率





#### 暴破

##### 暴破创建对象

Class类方法

```java
1. class.newInstance()      //直接使用类的新建实例函数创建对象
    
2. //获得构造器后创建对象，只能获得public构造器
 Constructor constructor = Class.getConstructor(); //可在括号内填写string.class/int.class/....来匹配对应的构造器
 Object o1 = constructor.newInstance();

3. //获得构造器后创建对象，获得所有构造器
 Constructor constructor = Class.getDeclaredConstructor(); 
 // Object o1 = constructor.newInstance(); 会报错，因为无法直接使用私有构造器 
====> 于是使用暴破
```



Constructor类方法

暴破 -- 暴力破解

constructor.setAccessible(true)

```java
 Constructor constructor = class.getDeclaredConstructor(); 

** constructor.setAccessible(true);  //暴破

 Object o1 = constructor.newInstance();
```



##### 暴破访问类成员

field.setAccessible(true);

```java
Field f = aClass.getDeclaredField(属性名); //如果访问了一个私有成员属性，本来是不可访问的，要使用到暴破
f.setAccessible(true);
f.set(object对象,值);  //如果访问的属性为静态属性，那么object处填null
```



##### 暴破操作方法



```java
Class aClass = Class.forName("Cat");
Object o = aClass.newInstance();
Method m = aClass.getDeclaredMethod();
m.setAccessible(true);      //暴破使用private方法
m.invoke(o,所要向m方法传的参数) //如果访问的方法为静态，那么object处填null
```





### JDBC

![image-20220822220620641](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822220620641.png)

java接口-----数据库驱动----各数据库



JDBC程序编写步骤：

1. 注册驱动-**加载Driver类**
2. 获取连接-得到**Connection**
3. 执行增删改查-发送SQL给mysq|执行
4. 释放资源-关闭相关连接
   



```java
package JDBC822;

import com.mysql.cj.jdbc.Driver; //注意导入这个包
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC1 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.得到连接
        //(1) jdbc:mysqL:       // 规定好表示协议，通过jdbc的方式连接mysqL
        //(2) localhost主机，可以是ip地址
        //(3) 3306 表示mysqL监听的端口
        //(4) book 连接到mysqL dbms 的哪个数据库
        //(5) mysql的连接本质是socket连接

        String url = "jdbc:mysql://localhost:3306/book";
        //把用户名和密码放进properties中
        Properties pp = new Properties();
        pp.setProperty("user", "root");
        pp.setProperty("password", "z59941093");
        //连接函数,创建connect对象
        Connection connect = driver.connect(url, pp);

        //3.执行sql
        String sql = "insert into t_user values(5,'d','123456','ddd@qq.com')";
        //statement用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); //返回结果为影响的行数
        System.out.println(rows == 1 ? "yes" : "no");

        //4.关闭连接资源
        statement.close();
        connect.close();
    }
}
```

​	



#### 连接数据库方式（5种）

1. 获取Driver实现类对象

   ```java
   
   Driver driver = new Driver();
   Connection connect = driver.connect(url, pp);
   
   ```

   **静态加载，灵活性差**（要改代码）



2. 使用反射

   动态加载	

```java
Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
Driver dd = (Driver) aClass.newInstance();
//下面一样
```



3. 使用DriverManager 代替Driver进行管理

```java
Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
Driver dd = (Driver) aClass.newInstance();

String url = "jdbc:mysql://localhost:3306/book";
String user = "root";
String password = "z59941093";
Properties pp = new Properties();
pp.setProperty("user", "root");
pp.setProperty("password", "z59941093");

DriverManager.registerDriver(dd);
Connection connection = DriverManager.getConnection(url, pp);
 //或者DriverManager.getConnection(url,user,password);
```



4. **推荐**               使用Class.forname自动完成注册驱动，简化代码 



```java
Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver"); //加载Driver类时，已经自动完成了注册

String url = "jdbc:mysql://localhost:3306/book";
Properties pp = new Properties();
pp.setProperty("user", "root");
pp.setProperty("password", "z59941093");

Connection connection = DriverManager.getConnection(url, pp);
```



Driver源码：

![image-20220822232955814](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822232955814.png)

![image-20220822233426794](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822233426794.png)



5.  将url ,user,password写入properties配置文件中。   4的优化。

![image-20220822233732718](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822233732718.png)





#### ResultSet结果集

![image-20220822234441484](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822234441484.png)

结果集中，存的就是一个表

```java
String sql2 =  "SELECT username,passerword from t_user;";
ResultSet resultSet = statement.executeQuery(sql2);
while(resultSet.next()){  //next光标移到下一行，直到空会返回null
    String name = resultSet.getString(1);
    String pwd = resultSet.getString(2);
    System.out.println(name + pwd);
}
```

**ResultSet的数据存在一个arraylist中：**

![image-20220823000249597](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220823000249597.png)



#### Statement

实际开发中不会使用Statement，因为存在sql注入风险

![image-20220825140506051](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825140506051.png)

使用PreparedStatement能规避风险



##### PreparedStatement预处理

![image-20220825142256500](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825142256500.png)

方法：

![image-20220825143948967](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825143948967.png)

executeQuery用于DQL查询语句，executeUpdate用于DML修改数据

setxxx用于设置参数索引（第几个问号对应什么参数）

```java
//1. 创建
//需要先写sql语句（用？代替参数），再根据sql语句创建
String sql = "SELECT * from t_user WHERE username=?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);

//2. 设置参数索引（第n个问号对应哪个参数）
preparedStatement.setString(1,user_name);

//3. 查询
ResultSet resultSet = preparedStatement.executeQuery();  //这里括号内不要再传入sql对象


String user_name;
Scanner scanner = new Scanner(System.in);
System.out.println("请输出查询的用户名：");
user_name = scanner.next();

String sql = "SELECT * from t_user WHERE username=?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1,user_name);
ResultSet resultSet = preparedStatement.executeQuery();
```



预处理好处：

1. 不再使用+拼接sq|语句，减少语法错误
2. 有效的解决了sq|注入问题!
3. 大大减少了编译次数，效率较高
   





#### JDBC API小结

![image-20220825144924961](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825144924961.png)

![image-20220825145111364](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825145111364.png)





#### JDBC UTILS 开发

1. 注册驱动-**加载Driver类**
2. 获取连接-得到**Connection**
3. 执行增删改查-发送SQL给mysq|执行
4. 释放资源-关闭相关连接

可以实现一个工具类，封装连接与释放（1、2、4）的程序

```java
package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCutils {
    private static String username;
    private static String password;
    private static String url;
    private static String driver;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("E:\\CCCCSSSS\\mysql.properties"));
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver= properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中， 我们可以这样处理
            //1. 将编译异常转成运行异常
            //2.这是调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便。
            throw new RuntimeException(e);
        }

    }

    //连接函数
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭释放函数
    public static void close(Statement statement, Connection connection, ResultSet resultSet){

        try {
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();
            if(resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

```





#### JDBC中的事务

基本介绍
1. JDBC程序中当一 个Connection对象创建时，**默认情况（执行一条sql）下是自动提交事务**：每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚。
2. JDBC程序中为了让多个SQL语句作为一个整体执行，需要使用事务
3. **调用Connection的setAutoCommit(false)可以取消自动提交**
4. 在所有的SQL语句都成功执行后，调用Connection的commit();方法提交事务
5. 在其中某个操作失败或出现异常时，调用Connection的rollback();方法回滚事务



使用案例：

```java
package Utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils_use {

    @Test
    public void test() throws SQLException {
        //1.连接
        Connection cc = JDBCutils.getConnection();
        PreparedStatement pp = null;
        //2. 写sql
        String sql = "INSERT into t_user VALUES(null,?,?,'666@qq.com')";
        String sql2 = "UPDATE t_user set username='haiderackerman' WHERE username=?";
        try {
            //这里使用两条sql语句构成一个事务
            //首先要取消自动commit
            cc.setAutoCommit(false);
            //执行第一条sql
            pp = cc.prepareStatement(sql);
            pp.setString(1,"e");
            pp.setString(2,"eeee");
            pp.executeUpdate();  //提交了第一条
            //执行第二条
            pp = cc.prepareStatement(sql2);
            pp.setString(1,"e");
            pp.executeUpdate();  //提交了第二条

            //最后再提交
            cc.commit();

        } catch (SQLException e) {
            //如果异常了，那就捕获,并且回滚
            e.printStackTrace();
            cc.rollback();
        } finally {
            JDBCutils.close(pp,cc,null);
        }
    }
}

```



#### 批处理

​		当需要成批插入或者更新记录时。 可以采用Java的批量更新机制，这一机制允许多条语句一次性提交给数据库批量处理。通常情况下比单独提交处理更有效率。

方法：

```java
Statement.addBatch()		//添加需要批量处理的SQL语句或参数
Statement.executeBatch()	//执行批量处理语句;
Statement.clearBatch()		//清空批处理包的语句
```



**如果要使用批处理功能，url中加参数?rewriteBatchedStatements =true**

```
url=jdbc:mysql://localhost:3306/book?rewriteBatchedStatements=true
```



批处理往往和PreparedStatement起搭配使用，可以既减少编译次数，又减少运行次数，效率大大提高



案例：

```java
@Test
    public void test() throws SQLException {
        //1.连接
        Connection cc = JDBCutils.getConnection();
        PreparedStatement pp = null;
        //2. 写sql
        String sql = "INSERT into t_user VALUES(null,?,'abc','666@qq.com')";
        pp = cc.prepareStatement(sql);
        for (int i=0 ;i<5000;i++){
            pp.setString(1,"aaa"+i);
            pp.addBatch();          //添加到批处理包里
            if((i+1)%1000 == 0){    //满一千条才执行
                pp.executeBatch();  //执行包里所有sql语句
                pp.clearBatch();    //清空包
            }
        }
    }
```



源码：

先检查sql语句，再放入arraylist中

![image-20220825164428989](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825164428989.png)



#### 连接池

传统获取Connection问题分析：

1. 传统的JDBC数据库连接使用DriverManager来获取，每次向数据库建立连接的时候都要将Connection加载到内存中，再验证IP地址，用户名和密码(0.05s ~ 1s时间)。需要数据库连接的时候，就向数据库要求一个，频繁的进行数据库连接操作将占用很多的系统资源，容易造成服务器崩溃。

2. 每一次数据库连接，使用完后都得断开，如果程序出现异常而未能关闭，将导致数据库内存泄漏，最终将导致重启数据库。

3. 传统获取连接的方式，不能控制创建的连接数量，如连接过多，也可能导致内存泄漏，MySQL崩溃。

解决传统开发中的数据库连接问题，可以采用**数据库连接池技术**(connection pool)



**数据库连接池：**

1. 
   预先在缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去。

2. 
   数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是重新建立一个。

3. 
   当应用程序向连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列中

![image-20220825195537220](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825195537220.png)

连接池中存放着一些已经建立好的数据库连接，应用程序需要使用的话，只是**引用**他们



连接池种类：

![image-20220825195926975](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825195926975.png)

连接池会实现DataSource接口

![image-20220825201414020](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825201414020.png)





##### C3P0

**与使用DriverManager相比，建立连接更快**



首先导入相关包：

![image-20220825202512014](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825202512014.png)

**代码配置**连接池，建立连接：

```java
package com.C3P0_;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class C3P0_ {
    public void test02() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //读取配置信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver= properties.getProperty("driver");

        //给数据源 ComboPooledDataSource 设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(username);

        //初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数，超过就进入等待队列
        comboPooledDataSource.setMaxPoolSize(50);

        //得到连接
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
    }
}

```



2. 通过xml配置文件

   c3p0-config.xml:

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <c3p0-config>
       <named-config name="saitama">  
           <property name="jdbcUrl">jdbc:mysql://localhost:3306/book?rewriteBatchedStatements=true</property>
           <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
           <property name="user">root</property>
           <property name="password">z59941093</property>
           <property name="acquireIncrement">5</property> <!-- 每次增长的连接数 -->
           <property name="initialPoolSize">5</property>
           <property name="maxPoolSize">10</property>
           <property name="maxIdleTime">1000</property>
           <property name="maxStatements">10</property>
           <property name="maxStatementsPerConnection">4</property>
       </named-config>
   </c3p0-config>
   ```

   代码：

   ```java
   public void test03() throws SQLException {
           ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("saitama");
           Connection connection = comboPooledDataSource.getConnection();
           connection.close();
           System.out.println("连接成功");
       }
   ```

   



##### Druid

druid.properties:

```properties
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/book?rewriteBatchedStatements=true
username=root
password=z59941093
# 初始化连接数
initialSize=5
# 最小连接数
minIdle=5
# 最大连接数
maxActive=10
# 超时时间
maxWait=3000
```



```java
public void test04() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end-start));

    }
```





#### ApDBUtils



resultSet的几个问题：

1. 要使用resultSet，不能关闭connection
2. 不关闭Connection,可能会造成队列拥堵
3. resultSet的getString(）等等方法，不能直观地得到信息。getString("name")才能获得name，而不是getName()



于是：

1. 创建一个类，用以表示查询出来的对象，resultSet查询出来的结果就可以用很多该类的对象表示 （JavaBean / Pojo / Domian）
2. 将该类对象封装到ArrayList中去

![image-20220825215013149](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825215013149.png)





基本介绍：

commons-dbutils是Apache组织提供的一个开源JDBC工具类库，它是对JDBC的封装，使用dbutils能极大简化jdbc编码的工作量。



DbUtils类有：

1. QueryRunner类: 该类封装了SQL的执行，是线程安全的。可以实现增、删、改、查、批处理

2. 使用QueryRunner类实现查询

3. ResultSetHandler接口:该接口用于处理java.sql.ResultSet,将数据按要求转换为另一种形式

  ```java
  // ResultSetHandler接口包含：
  
  ArrayHandler 		//把结果集中的第一行数据转成对象数组。
  ArrayListHandler	//把结果集中的每一行数据都转成一个数组， 再存放到List中。
  BeanHandler			//将结果集中的第一行数据封装到一个对应的JavaBean实例中。
  BeanListHandler		//将结果集中的每一行数据都封装到个对应的JavaBean实例中，存放到List里。
  ColumnListHandler	//将结果集中某一列的数据存放到List中。
  KeyedHandler(name)	//将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key。
  MapHandler			//将结果集中的第一-行数据封装到一 个Map里，key是列名， value就是对应的值。
  MapListHandler		//将结果集中的每一行数据都封装到-个Map里，然后再存放到List
  ```

  

#####  DQL

使用案例：

首先创建一个对象类：

必须有无参构造（供反射）

有get 和 set函数，供ResultSetHandler调用

```java
package com.DBUtils_;

public class user {
    private int id;
    private String username;
    private String password;
    private String email;

    public user() {
    }

    public user(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

```



```java
 @Test
    public void test05() throws SQLException {
        //1.  使用druid得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 使用DBUtils工具类，先导包commons-dbutils-1.7.jar
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * from t_user WHERE passerword='abc'";

        //queryRunner.query()方法，执行sql语句，将resultSet结果，放入多个user对象中，并把这些对象封装到list中
        //如果sql语句中有?参数，那么在形参列表末尾中加上对应值
        //public <T> T query(conn,sql,ResultSetHandler,Object... params)
        // Object... params为可变参数
        // 如： queryRunner.query(connection, sql, new BeanListHandler<>(user.class),value1,value2,.....)
        List<user> query = queryRunner.query(connection, sql, new BeanListHandler<>(user.class),1);
        for (user u: query) {
            System.out.println(u);
        }
```



源码：

```java

            PreparedStatement stmt = null;	//预处理
            ResultSet rs = null;			//结果集
            Object result = null;			//存放最后的arraylist

            try {
                stmt = this.prepareStatement(conn, sql);		//先预处理得到结果集
                this.fillStatement(stmt, params);				//预处理设置参数索引
                rs = this.wrap(stmt.executeQuery());			//执行sql，返回resultSet
                result = rsh.handle(rs);					
                //把查询的结果按照传的参数（new BeanListHandler<>(user.class)）封装
            } catch (SQLException var33) {
                this.rethrow(var33, sql, params);
            } finally {
                try {
                    this.close(rs);
                } finally {
                    this.close(stmt);			//释放结果集，返回result的arratlist
                    if (closeConn) {
                        this.close(conn);
                    }

                }
            }

            return result;
```



##### DML

```java
 @Test
    public void test06() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "DELETE from t_user WHERE passerword='abc'";
        int affectedRows = queryRunner.update(connection, sql);  //返回影响的行数
        System.out.println("删除了" + affectedRows + "行");

        JDBCUtilsByDruid.close(null,null,connection);

    }
```



##### javaBean和数据库表的数据类型映射关系：

int double varchar  char 等都对应java中的包装类 Integer String ...



##### 

#### BasicDAO

ApDBUtils + Druid 还有些不足：

1. SQL语句是固定，不能通过参数传入，通用性不好，需要进行改进，更方便执行增删改查 （查不同的数据，不可能在代码里写好各种sql语句）

2. 对于select 操作，如果有返回值，返回类型不能固定，需要使用泛型 （ 如果方法要返回List<user>， 返回类型被定死，这个方法就有局限）

3. 将来的表很多，业务需求复杂，不可能只靠一个Java类完成

  

**DAO ： Data Access Object    数据访问对象**

![image-20220825231410030](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825231410030.png)

​		这样的通用类， 称为**BasicDao**，是专门和数据库交互的，即**完成对数据库(表)的crud操作。**
​		在BaiscDao 的基础上，实现一张表对应一个Dao ,更好的完成功能，比如Customer表---Customerjava类(javabean)---CustomerDao.java



##### 实现：

![image-20220825231818146](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220825231818146.png)

一个DAO的设计

utils---------工具类

domain-------javaBean

dao----------存放xxxDAO和BasicDAO

test---------测试类

![image-20220829122454988](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220829122454988.png)

BasicDAO实现：

```java
package com.dao_.dao;


//其他DAO的父类

import com.Druid_.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> { //使用泛型，指定具体类型
    private QueryRunner qr = new QueryRunner();


    public int update(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int rows = qr.update(connection,sql,parameters);
            return rows;
        } catch (SQLException e) {
            throw new RuntimeException(e);      //编译异常转为运行异常
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    public List<T> query(String sql,Class<T> tClass,Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanListHandler<>(tClass),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);      //编译异常转为运行异常
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

}

```



userDAO继承BasicDAO,可后续添加更多函数

```java
package com.dao_.dao;

public class userDAO extends BasicDAO<com.dao_.domain.user>{
}

```

