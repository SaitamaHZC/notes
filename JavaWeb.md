HTML/CSS/JS

页面成分：

内容（结构）：页面中可以看到的数据

表现：内容在页面上的展示形式

行为：页面中元素与输入设备交互的响应



## HTML

### 基础：

**HTML格式规范：**

```html
<html> <!-- html标签表示html的开始，lang表示语言,html标签分为head和body -->
	<head> <!-- 表示头部信息,一般包含三部分内容, title标签,css样式,js代码-->
		<title>标题</title>
	</head>
	<body>
		内容
	</body>
</html>
```

**注释：**

```html
<!--内容 -->
```

**HTML元素的格式:**

```html
<标签名>封装的数据</标签名>    
```

1. 标签名大小写不敏感。

2. 标签拥有自己的属性,**属性值必须加引号**。

```
i.分为基本属性: bgcolor= "red"可以修改简单的样式效果
ii.事件属性: onclick="alert('你好! ');" 可以直接设置事件响应后的代码。|
```

3. 标签又分为，单标签和双标签。

   ```
   i.单标签格式:  <标签名/>
   ii.双标签格式: <标签名> ...封装的数据... </标签名>
   ```

4. ```
   <br/> 换行
   <hr/> 水平线
   ```

5. 注释不能嵌套



### 字符实体/特殊字符

类似于转义字符

![image-20220812230834359](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220812230834359.png)



### 文本格式化

对文本进行处理的标签

![image-20220812235408952](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220812235408952.png)



### 常用标签

#### font 字体

属性：

color ：颜色

face ：字体

size ：大小

```html
 <font color="aqua" face="宋体" size="7">  密麻麻石蜡</font>
```



#### h1 --- h6 标题大小

属性：

align : 标题位置

```html
<h1 align="center"> nmsl </h1>
align : left/center/right
```



#### a 超链接

属性：

href:需要链接的地址

target : 点开的链接显示在何处

```html
<a href="www.baidu.com" target="_blank"> 点这里 </a>
target : _self / _blank 当前窗口/新页面
```



#### ul / ol 列表

ul ： 无序列表

ol：有序列表

li ：小圆点

属性：

type ：可以修改列表项前的符号（小圆点）

```
    <ul>
        <li>一</li>
        <li>二</li>
        <li>三</li>
    </ul>
```

显示如下：

![image-20220812233151968](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220812233151968.png)



#### img 图片

![image-20220812234418752](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220812234418752.png)

src : 路径

width: 宽

height : 高

border : 边框大小

alt : 当指定路径找不到图片时，用来代替显示的文本内容

```html
<img src="./abc.jpg">
```



#### table 表格

tr : 行

td : 列

th : 可替代td，自动居中加粗

border  ： 边框大小

width height ： 不做解释

```html
<table border="1">
        <tr>
            <td> a </td>
            <td> b </td>
        </tr>
        <tr>
            <td> c </td>
            <td> d </td>
        </tr>
</table>
```



跨行跨列表格：

 属性:

colspan = "n" 跨n列

rowspan = "n" 跨n行



#### iframe 框架

在页面上开一个小区域，显示单独页面

```html
  <iframe src="test.html" width="500" height="500" name="nmsl"> </iframe>
```

iframe与a标签联合：

在a标签的target值上设置iframe的name值

```html
<a href="www.baidu.com" target="nmsl">
```



#### 表单 form

```html
input type=text     是文件输入框  value设置默认显示内容
input type=password 是密码输入框  value设置默认显示内容
input type=radio    是单选框    name属性可以对其进行分组   checked="checked"表示默认选中 value表示其个体值
<input type=radio name=sex value=male>表示它是单选框，name类的male选项

input type=checkbox 是复选框   checked="checked"表示默认选中
input type=reset    是重置按钮      value属性修改按钮上的文本
input type=submit   是提交按钮      value属性修改按钮上的文本
input type=button   是按钮          value属性修改按钮上的文本
input type=file     是文件上传域
input type=hidden   是隐藏域    当我们要发送某些信息，而这些信息，不需要用户参与，就可以使用隐藏域（提交的时候同时发送给服务器）

select 标签是下拉列表框
option 标签是下拉列表框中的选项 selected="selected"设置默认选中

textarea 表示多行文本输入框 （起始标签和结束标签中的内容是默认值）
    rows 属性设置可以显示几行的高度
    cols 属性设置每行可以显示几个字符宽度
```

```html
<form>
        文本：
        <input type="text" value="hi" name="name"> <br>
        密码：
        <input type="password" value="abc" name="password"> <br>
        单选框：
        <input type="radio" name="sex" checked="checked"> 男
        <input type="radio" name="sex"> 女
        <br>
        复选框：
        <input type="checkbox" name="character"> 蠢
        <input type="checkbox" name="character"> 傻逼
        <br>
        选择：
        <select>
            <option> 请选择 </option>
            <option selected="selected"> China </option>
            <option> America </option>
            <option> Japan </option>
        </select>
        <br>
        多行文本输入框：
        <textarea rows="10" cols="50" >默认值写在里面</textarea>
        <br>
        重置：
        <input  type="reset" value="重置键"> <br>
        提交：
        <input  type="submit" value="提交键"> <br>
        按钮：
        <input  type="button" value="什么什么键"> <br>
        文件：
        <input  type="file" value="提交文件"> <br>
        隐藏区域：
        <input  type="hidden" > <br>
    </form>
```

表单格式化：form中使用table align="center"，用表格的行列来格式化

form属性：
action：设置提交的服务器地址

method：设置提交的方式 （get或post）

```html
<form action="http://localhost:8080" method="post" ></form>
```



```

        表单提交的时候，数据没有发送给服务器的三种情况：
            1、表单项没有name属性值
            2、单选、复选（下拉列表中的option标签）都需要添加value属性，以便发送给服务器
            3、表单项不在提交的form标签中

        GET请求的特点是：
            1、浏览器地址栏中的地址是：action属性[+?+请求参数]
                请求参数的格式是：name=value&name=value
            2、不安全
            3、它有数据长度的限制

        POST请求的特点是：
            1、浏览器地址栏中只有action属性值
            2、相对于GET请求要安全
            3、理论上没有数据长度的限制
```



#### div/ span / p

```
div标签       默认独占一行
span标签      它的长度是封装数据的长度
p段落标签     默认会在段落的上方或下方各空出一行来（如果已有就不再空）
```



#### base

设置相对路径的参照路径

```
<head>
<base herf="http://localhost:8080/xxx">
</head>
```



## CSS

### 语法规则：

```
p{  //p为选择器
color:red; //属性：值，形成了一个声明，声明结尾加分号
font-size:30px; 
}
```



### CSS与HTML的结合

CSS可以修改HTML中标签的样式

改HTML标签样式：

第一种：在标签的 style 属性上设置”key:value value;”，修改标签样式。

```html
 <h1 style="border: 1px solid red" align="center"> NMSL </h1>
```

代码量大、可读性查，没有复用性



第二种：在head标签中，使用**style标签**来定义CSS样式

```html
<head>
    <meta charset="UTF-8">
    <title>NMSL</title>
    <style type-="text/css">
        div{
            border: 1px solid red;
        }
    </style>
</head>
```

只能在一个页面里用，不能在多个页面中复用，维护起来不方便



第三种：把 css 样式写成一个单独的 css 文件，再通过 link 标签引入即可复用。 

使用 html的**link标签**导入css样 式文件

```html
<head>
<link rel="stylesheet" type="text/css" href="theme.css" />
</head>
```

link属性：

![image-20220813121817510](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220813121817510.png)



### 选择器

**标签名选择器**：对一个标签进行样式设计

```css
div{
    border: 1px solid red;
    color: aqua;
    font-size: 50px;
}
```



**id选择器**：对同一个标签的不同id进行设计。同一标签不同id，样式不同

格式（CSS中）：

```
#id{
}
```

在HTML中，设置id属性，来使用相应的样式

```html

例如：
CSS:
#id001{
    border: 1px solid red;
    color: aqua;
    font-size: 50px;
}
#id002{
    border: 1px dashed red;
    color: greenyellow;
    font-size: 30px;
}
HTML：
<body>
    <div id="id001"> nmsl </div>
    <div id="id002"> nmsl </div>
</body>
```



**class类型选择器**

与id选择器差不多

格式：

```
.class属性值{
}
```

在HTML中，设置class属性，来使用相应的样式

```HTML
CSS:
.class001{
    border: 1px solid red;
    color: aqua;
    font-size: 50px;
}
.class002{
    border: 1px dashed red;
    color: greenyellow;
    font-size: 30px;
}
HTML：
<body>
    <div class="class001"> nmsl </div>
    <div class="class002"> nmsl </div>
</body>
```



**组合选择器**

让多个选择器共用一个样式

格式：

```
选择器1,选择器2,..选择器n{

}
```



### 常用样式

1. 颜色 color

可写rgb值、十六进制值、颜色名

```
color:blue
color:rgb(255,0,0)
color:#00FFFF
```



![image-20220813124547108](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220813124547108.png)



![image-20220813124604191](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220813124604191.png)





## JavaScript

JS是弱类型，变量属性可变。JAVA是强类型

JS运行在客户端，需要运行浏览器来解析执行 JavaScript 代码。



### JS结合HTML

**script 标签可以用来定义 js 代码，也可以用来引入 js 文件 ,但只能二选一**

1. 在head标签中使用script标签写代码

```html
<head>
    <meta charset="UTF-8">
    <title>NMSL</title>
    <script type="text/javascript">
        alert("NMSL!!!!!!");
    </script>
</head>
```

2. script标签引入

   **src 属性专门用来引入 js 文件路径**

   ```html
   <head>
       <meta charset="UTF-8">
       <title>NMSL</title>
       <script type="text/javascript" src="2.js"></script>
   </head>
   ```
   
   

### 变量

| 数值       | number   |
| ---------- | -------- |
| 字符串类型 | string   |
| 对象       | object   |
| 布尔       | boolean  |
| 函数       | function |



JS里特殊的值

| undefined | 未定义，所有变量未赋初值的时候都是undefined |
| --------- | ------------------------------------------- |
| null      | 空值                                        |
| NAN       | not a  number 非数字                        |



定义变量格式

```javascript
var 变量；
var 变量 = 值；
```





### 运算

特殊的关系运算：

```javascript
全等于 ===      //除了做字面值的比较之外，还会比较两个变量的数据类型
```

特殊的逻辑运算：

**0 、null、 undefined、””(空串) 都认为是 false**

&& 且运算有两种情况： 

第一种：当表达式全为真的时候。返回**最后一个表达式**的值。 

第二种：当表达式中，有一个为假的时候。返回**第一个为假**的表达式的值 

|| 或运算 

第一种情况：当表达式全为假时，返回**最后一个表达式**的值 

第二种情况：只要有一个表达式为真。就会把回**第一个为真**的表达式的值 

并且 && 与运算 和 ||或运算 有短路。 

短路就是说，当这个&&或||运算有结果了之后 。后面的表达式不再执行 



### ⭐数组

格式：

```javascript
var 数组名 = [];      //创建空数组
var 数组名 = [true,'b',1];
```

数组会**自动扩容**



### ⭐函数

格式1：

```javascript
function 函数名(形参列表){
}
```

格式2：

```javascript
var 函数名 = function(形参列表){
}
```

**形参列表不用写形参类型**

**JS中函数重载会覆盖掉上一次的定义，不允许重载！**



#### 隐形参数 arguments

在 function 函数中不需要定义，但却可以直接用来获取所有参数的变量。

像 java 基础的可变长参数一样。

```
例如：求和
function sum(){
    var sum = 0;
    for(var i=0;i<arguments.length;i++){
        sum+=arguments[i];
    }
    return sum;
}
alert(sum(1,2,3,4,5,6,7,8,9,10));
```



### 常用方法



```java
confirm(内容) 
//confirm是JavaScript 语言提供的一个确认提示框函数。你给它传什么，它就提示什么
//当用户点击了确定，就返回true. 当用户点击了取消，就返回false

```



```javascript
console.log("xxxx")   //控制台打印函数
```



### 对象

对象的定义1： 

```javascript
var 变量名 = new Object();      // 对象实例（空对象） 
变量名.属性名 = 值;              // 定义一个属性 
变量名.函数名 = function(){	   // 定义一个函数 

} 	   
```

定义2：

```javascript
var 对象名 = {
	属性名：值,			//每个结尾加逗号
	函数名：function(){

	}
	
}
```

对象的访问： 

```javascript
变量名.属性 / 函数名(); 
```



#### 控制台对象

console

```javascript
console.log("xxxx")   //打印函数
```



### 事件

事件是电脑输入设备与页面进行**交互的响应**。



**常用的事件：** 

|                           |                                                  |
| ------------------------- | ------------------------------------------------ |
| onload 加载完成事件       | 页面加载完成之后，常用于做页面 js 代码初始化操作 |
| onclick 单击事件          | 常用于按钮的点击响应操作                         |
| onblur 失去焦点事件       | 常用用于输入框失去焦点后验证其输入内容是否合法   |
| onchange 内容发生改变事件 | 常用于下拉列表和输入框内容发生改变后操作         |
| onsubmit 表单提交事件     | 常用于表单提交前，验证所有表单项是否合法         |





**静态注册事件**：通过 html 标签的事件属性直接赋于事件响应后的代码，这种方式我们叫静态注册。 

```html

   <script type="text/javascript">
        function show(){
            alert("hi!!");
        }
    </script>
...
<body onload="show()">

```

**动态注册事件**：是指先通过 js 代码得到标签的 dom 对象，然后再通过 dom 对象.事件名 = function(){} 这种形式赋于事件 响应后的代码，叫动态注册。 

动态注册基本步骤： 

在script区域中写一段

```javascript
window.onload = function(){
	1、获取标签对象 
	2、标签对象.事件名 = fucntion(){} 
}
```



静态注册：在html标签中，添加事件属性

动态注册：在script中，window.onloadwindow.onload = function(){}函数块中写好各个标签所要用到的函数





#### onclick

动态注册：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NMSL</title>
<!--    <script type="text/javascript" src="JS/1.js"></script>-->
    <script type="text/javascript">
        function show(){
            alert("hi!!");
        }
        window.onload = function (){
            var bt01 = document.getElementById("bt1");
            bt01.onclick = function () {
                alert("hi!!!");
            }
        }

    </script>
</head>
<body>
    <button id="bt1"> 按钮 </button>
</body>
</html>
```



#### onblur

例如当光标离开了表单所填的区域，就是失去焦点

同样

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NMSL</title>
<!--    <script type="text/javascript" src="JS/1.js"></script>-->
    <script type="text/javascript">
        function show(){
            alert("hi!!");
        }
        window.onload = function (){
            var bt01 = document.getElementById("bt1");
            bt01.onclick = function () {
                alert("hi!!!");
            }
            var password1 = document.getElementById("psd");
            password1.onblur = function () {
                console.log("动态注册失去焦点！");
            }
        }

    </script>
</head>
<body>
    <button id="bt1"> 按钮 </button><br>
    用户名：
    <input type="text" id="name" onblur="show()">     <!--  静态注册onblur-->
    <br>
    密码：
    <input type="password" id="psd">                 <!-- 动态注册onblur-->

</body>
</html>
```



#### onchange

内容发生改变事件 

**常用于下拉列表和输入框内容发生改变后操作**

```html
 <select id="id003" onchange="show()">        //静态注册
        <option> 选项1 </option>
        <option> 选项2 </option>
        <option> 选项3 </option>
    </select>
```



#### onsubmit

```html
<!--动态注册 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NMSL</title>
    <script type="text/javascript">
        window.onload = function (){
            var ss = document.getElementById("id002");
            ss.onsubmit = function () {
                alert("no!!!!");
                return false
            }
        }
    </script>
</head>
<body>
    <form action="http://localhost:8080" method="post" >
        <input type="submit" id="id002">
    </form>
</body>
</html>
```





### DOM

DOM 全称是 Document Object Model 文档对象模型 

就是把文档中的标签，属性，文本，转换成为对象来管理



![image-20220813200326664](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220813200326664.png)

**Document** **对象的理解：** 

**第一点：Document 它管理了所有的 HTML 文档内容。** 

**第二点：Document 它是一种树结构的文档。有层级关系。** 

**第三点：它让我们把所有的标签 都 对象化** （树节点对象）

**第四点：我们可以通过** **document** **访问所有的标签对象。** 



```java
模拟对象化：Document有以下属性：
class Dom{ private String id; // id 属性 
private String tagName; //表示标签名 
private Dom parentNode; //父亲
private List<Dom> children; // 孩子结点 
private String innerHTML; // 起始标签和结束标签中间的内容
}
```



#### 方法

```javascript

//三种查询方式
document.getElementById(id)
document.getElementsByName(name)
document.getElementsByTagName(tagName)
⭐优先根据id > name > tagName

//自己创建标签
document.createElement(tagName)

```

1. **创建标签时，您必须向一个已有的元素追加这个新元素，用appendChild函数**

2. HTML按代码先后顺序执行，**要注意script区的代码涉及到未执行的部分，出现错误**。可以放到 window.onload = function (){}内来避免这一错误，**因为onload函数在全部加载完之后才执行**。

```html
//通过创建文本节点来

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nmsl</title>
    <script type="text/javascript">
        window.onload = function (){
            var divObj = document.createElement("div");
            var textNodeObj = document.createTextNode("密麻麻石蜡");  //创建文本节点
            divObj.appendChild(textNodeObj);
            /*divObj.innerText = "密麻麻石蜡";*/
            document.body.appendChild(divObj);
        }
    </script>

</head>
<body>

</body>
</html>
```

```html
//通过修改标签对象的innerText属性
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nmsl</title>
    <script type="text/javascript">
        window.onload = function (){
            var divObj = document.createElement("div");
            divObj.innerText = "密麻麻石蜡";
            document.body.appendChild(divObj);
        }
    </script>

</head>
<body>

</body>
</html>
```



####  节点常用属性和方法

节点就是标签对象

方法：

```java
通过具体的元素节点调用  
getElementsByTagName() 方法
获取当前节点的指定标签名 **孩子节点**   //document.getElementsByTagName()即获取整个DOM下的指定标签节点，一样的

appendChild( oChildNode )
可以添加一个子节点，oChildNode 是要添加的孩子节点
```

属性：

```
childNodes 
获取当前节点的所有子节点

firstChild 
获取当前节点的第一个子节点

lastChild 
获取当前节点的最后一个子节点

parentNode 
获取当前节点的父节点 

nextSibling 
获取当前节点的下一个节点

previousSibling 
获取当前节点的上一个节点 

className 
用于获取或设置标签的 class 属性值 

innerHTML 属性，表示获取/设置起始标签和结束标签中的内容

innerText 属性，表示获取/设置起始标签和结束标签中的文本
```



## jQuery



jQuery：就是 JavaScript 和查询（Query），它就是辅助 JavaScript 开发的 js 类库



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="Demo/script/jquery-1.7.2.js"></script>  <!--使用jQuery需要引入这个库-->
    <script type="text/javascript">
        /*传统设置onclick事件*/
       window.onload = function (){
            var id = document.getElementById("bt01");
            id.onclick =function () {
                alert("hi!!");
                alert($);
            }
        }
       /* JQuery:*/
        $(function () {    //$(function(){})相当于 window.onload = function (){}
            var $bt01 = $("#bt01");    //相当于根据id查询 var id = document.getElementById("bt01"); id前和创建的对象名要加#
            $bt01.click(function (){   //设置onclick事件
                alert("hi!!!!!");
            });
        })
    </script>
</head>
<body>
    <button id="bt01"> 按钮 </button>
</body>
</html>
```



```javascript
$ = jQuery 是一个函数
在源码中：
// Expose jQuery to the global object
window.jQuery = window.$ = jQuery;

$(function(){}) = (    window.onload = function(){}   ) = $(document).ready(function(){}
$("#ID") = document.getElementById()
```



### $ ( ) 函数

1、传入参数为 [ 函数 ] 时： 

表示页面加载完成之后。相当于 window.onload = function(){} 

2、传入参数为 [ HTML 字符串 ] 时： 

会对我们创建这个 html 标签对象 

```html
 $("<div> abcd </div>\n" + "<div> abcd </div>").appendTo("body");
//相当于：
<body>
    <div> abcd </div>
    <div> abcd </div
</body>
```

3、传入参数为 [ 选择器字符串 ] 时： 

```
$("#id属性值"); 
```

id 选择器，根据 id 查询标签对象 

```
$("标签名"); 
```

标签名选择器，根据指定的标签名查询标签对象 

```
$(".class属性值")
```

;类型选择器，可以根据 class 属性查询标签对象 

4、传入参数为 [ DOM 对象 ] 时： 

会把这个 dom 对象转换为 jQuery 对象 

```html
 var bt01 = document.getElementById("bt01");
alert($(bt01));
alert(bt01);
```

![image-20220815140701687](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815140701687.png)



### jQuery对象

#### **本质：**

jQuery 对象是 **dom 对象**的**数组** + jQuery 提供的一系列功能函数。 

jQuery 和dom对象的函数不一样



#### 与dom对象的转换

1. dom转jQuery

   ```
   $(dom对象)
   ```

2. jQuery转dom

   通过下标提取

   ```
   var domObj = jQueryObj[下标]
   ```



#### 方法



遍历元素

在遍历的function函数中，有一个this对象，可遍历到当前dom对象

```javascript
$jQueryObj.each(function(){
	
})

$jQueryObj.each(function(){
	alert(this.value);	
})
```







#### 选择器

##### 基本选择器

![image-20220815143312234](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815143312234.png)



```html
id:
	$("#id")
dom标签：
	$("dom标签名")
class:
	$(".class名")
多重：
	$("div,span,p.myclass") //选择div,span和class为myclass的p标签
```





##### 层级选择器

```
$("ancestor descendant") //ancestor为父辈，找父辈下所有descednant的后代（子、孙、...）标签
$("parent > child")     //找parent下所有child（一辈的子代）
$("prev + next")		//匹配所有紧接(下一行)在 prev 元素后的 next 元素
$("prev ~ siblings")  	匹配 prev 元素之后的所有 siblings 元素


```



##### 基本过滤选择器

![image-20220815145802848](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815145802848.png)

![image-20220815155025593](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815155025593.png)

##### 内容过滤选择器

![image-20220815150011792](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815150011792.png)

```
$("div:contians("text")")
$("div:empty")
$("div:has(span)")
```

![image-20220815155035448](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815155035448.png)



##### 属性过滤选择器

过滤有xxx**属性**的元素

![image-20220815150236725](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815150236725.png)

```
$("div[id]")
```

![image-20220815154944289](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815154944289.png)



##### 表单多滤器

![image-20220815150723925](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815150723925.png)



![image-20220815150845703](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815150845703.png)



#### 元素筛选

通过标签选择器获取对应元素（数组）后，就可以使用元素筛选函数进一步筛选

![image-20220815154926067](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815154926067.png)





![image-20220815154858257](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815154858257.png)

![image-20220815154904333](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815154904333.png)





#### 属性方法

![image-20220815155951402](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815155951402.png)

html()  它可以设置和获取起始标签和结束标签中的内容。 跟 dom 属性 innerHTML 一样。 val为传参，设置标签内容

text()   它可以设置和获取起始标签和结束标签中的文本。  跟 dom 属性 innerText 一样。val为传参，设置标签内容

val()    它可以设置和获取**!表单项!**的 value 属性值。            跟 dom 属性 value 一样

```java
val()          //获取值
val("string")  //对value属性更改，设置为string内容
val(["value"]) //对value为value的元素更改，设置为选中，用于check和select能选中的标签

设置表单项的选中状态：
 $(":radio").val(["radio1"]) 中括号括起来，填入对应的value属性值
 
 多个选中：
$("#multiple,#single,:radio,:checkbox").val(["radio2","checkbox1","checkbox3","mul1","mul4","sin3"] );
```



![image-20220815160951574](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220815160951574.png)

attr()  prop()

```java
attr("属性")  //获取
attr("属性"，"值")  //设置
//可以设置和获取属性的值，不推荐操作 checked、readOnly、selected、disabled 等等
//attr 方法还可以操作非标准的属性。比如自定义属性：abc,bbj

    
prop("属性")  //获取
prop("属性"，"值")  //设置
//可以设置和获取属性的值,只推荐操作 checked、readOnly、selected、disabled 等等
```







#### 增删改

内部插入：

```java
appendTo()             jQObj_A.appendTo(jQObj_B) 
//把 a 插入到 b 子元素末尾，成为最后一个子元素
prependTo()
//把 a 插到 b 所有子元素前面，成为第一个子元素
```



```html
<script type="text/javascript">
        $(function () {    //$(function(){})相当于 window.onload = function (){}
            $("<h1>hi </h1>").appendTo($("#id003"));
        })
</script>
</head>
<body>
   <div id="id003"> abcd</div>
</body>


效果：
	<div id="id003">
        abcd
        <h1>hi </h1>       //内部插入
	</div>

```

外部插入：

```java
insertAfter 		jQObj_A.insertAfter(jQObj_B)   插后面
insertBefore		jQObj_A.insertBefore(jQObj_B)  插前面
```



```html
<script type="text/javascript">
        $(function () {    //$(function(){})相当于 window.onload = function (){}
            $("<h1>hi </h1>").appendTo($("#id003"));
        })
</script>
</head>
<body>
   <div id="id003"> abcd</div>
</body>


效果：
	<div id="id003">
        abcd
	</div>
	<h1>hi </h1>       			//外部插入	

```



替换：

```
replaceWith()       	a.replaceWith(b)		用*一个*b替换掉a
//如果有多个重复的a，那么最后之后剩一个b
replaceAll()			a.replaceAll(b)			用a替换掉*所有的*b
//如果有多个重复的a，那么最后就会有多少个b
```





```html
 $("div").replaceWith($("<h1>hi </h1>"));
 
<body>
   <div> abcd</div>
   <div> abcd</div>
   <div> abcd</div>
   <div> abcd</div>
</body>

结果：
<body>
	<h1>hi </h1>
</body>
```



```html
 $("<h1>hi </h1>").replaceAll("div");
 
<body>
   <div> abcd</div>
   <div> abcd</div>
   <div> abcd</div>
   <div> abcd</div>
</body>

结果：
<body>
	<h1>hi </h1>
	<h1>hi </h1>
	<h1>hi </h1>
	<h1>hi </h1>
</body>
```



删除：

```java
remove()        a.remove()     //删除整个标签
empty()         a.empty() 	   //清空标签里的内容，标签还在
```









#### CSS样式

```java
jQueryObj.
    addClass() 		//添加样式 ,括号内填相应的样式名
    removeClass() 	//删除样式 ,括号内填相应的样式名就删除对应样式，不填就全部删除
    toggleClass() 	//有就删除，没有就添加样式。 
    offset() 		//获取和设置元素的坐标。 不填为获取，填为设置
```



#### 动画

```java
基本动画:
show() 将隐藏的元素显示 
hide() 将可见的元素隐藏。 
toggle() 可见就隐藏，不可见就显示。

//以上动画方法都可以添加参数。 
    1、第一个参数是动画 执行的时长，以毫秒为单位
    2、第二个参数是动画的回调函数 (动画完成后自动调用的函数) 

淡入淡出动画:
fadeIn() 淡入（慢慢可见）
fadeOut() 淡出（慢慢消失）
fadeTo() 在指定时长内慢慢的将透明度修改到指定的值。0 透明，1 完成可见，0.5 半透明 
fadeToggle() 淡入/淡出 切换
```







### jQuery事件操作

```
$( function(){} );
```

**和**

```
window.onload = function(){}
```

**的区别？** 



他们分别是在什么时候触发？ 

1、jQuery 的页面加载完成之后是浏览器的内核解析完页面的标签创建好 DOM 对象之后就会马上执行。 

2、原生 js 的页面加载完成之后，除了要等浏览器内核解析完标签创建好 DOM 对象，还要等标签显示时需要的内容加载完成（读取本地数据（加载图片）、访问网页等）。



触发的顺序？ 

1、jQuery 页面加载完成之后先执行 

2、原生 js 的页面加载完成之后 



他们执行的次数？ 

1、原生 js 的页面加载完成之后，只会执行最后一次的赋值函数。 （只会执行最后一次window.onload = function(){} )

2、jQuery 的页面加载完成之后是全部把注册的 function 函数，依次顺序全部执行。(把所有的 $( function(){} ); 都顺序执行)





### 事件处理

常用：

```java

click()  //它可以绑定单击事件，以及触发单击事件
    	//传function为绑定，不传为触发
mouseover() //鼠标移入jQuery对象时触发事件 
mouseout()  //鼠标移出事件
bind() 可以给元素一次性绑定一个或多个事件。 
    		//jQueryObj.bind("事件1 事件2 空格隔开",function())
one() 使用上跟 bind 一样。但是 one 方法绑定的事件只会响应一次。 
unbind() 跟 bind 方法相反的操作，解除事件的绑定 
    		//jQueryObj.unbind("事件1 事件2 空格隔开")
live() 也是用来绑定事件。它可以用来绑定选择器匹配的所有元素的事件。哪怕这个元素是后面动态创建出来的也有效
    		//live("事件",function)
```

```javascript
关于live()的动态创建：

 $("h1").click(function () {
       alert("hi!!!!");
});
$("<h1> 标题 </h1>").appendTo("body");

//原先所有的h1标签绑定了click事件。之后新创建的h1标签就没有绑定。
//解决方法是新建了标签后，手动绑定一次
//但直接使用live()函数就不存在这个问题
```





### 事件冒泡传递

事件的冒泡是指:

父子元素同时监听同一个事件。当触发子元素的事件的时候，同一个事件也被传递到了父元素的事件里去 响应。 

例如：

```javascript
$("span").click(function(){
   alert("我是span的单击响应函数");
   // return false;
});

//给id为content的div绑定一个单击响应函数
$("#content").click(function(){
   alert("我是div的单击响应函数");
   // return false;
});

<div id="content">
    外层div元素
	<span>内层span元素</span>
	外层div元素
</div>

//此时点击span，会先显示"我是span的单击响应函数"，后显示"我是div的单击响应函数"，形成冒泡传递
//在子事件中添加return false就能解决
```



**如何阻止事件冒泡：**

在子元素事件函数体内，**return false**; 可以阻止事件的冒泡传递。



### 事件对象

事件对象，是封装有触发的事件信息的一个 javascript 对象。



在给元素绑定事件的时候，在事件的 function( event ) 参数列表中添加一个参数，这个参数名，我们习惯取名为 event。 这个 event 就是 javascript 传递参事件处理函数的事件对象

![image-20220816001359101](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220816001359101.png)





# xml

![image-20220816180833719](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220816180833719.png)



**XML 被设计用来传输和存储数据。**

**HTML 被设计用来显示数据。**

 XML 不会做任何事情。XML 被设计用来结构化、存储以及传输信息

XML 没什么特别的。它仅仅是纯文本而已。有能力处理纯文本的软件都可以处理 XML。

描述（个人理解）、存储、传输数据



## 语法

命名规则：

1. 名称可以含字母、数字以及其他的字符
2. 名称不能以数字或者标点符号开始
3. 名称不能包含空格

单/双标签

```xml
单标签格式： <标签名 属性="值" 属性="值" ...... /> 
双标签格式：< 标签名 属性="值" 属性="值" ......> 文本数据或子标签</标签名>
```



属性

xml 的标签属性和 html 的标签属性是非常类似的，**属性可以提供元素的额外信息**

尽量避免使用属性，把属性写到子标签里去

1. 属性必须使用引号引起来，不引会报错示例代码



语法规则：

1. **所有** **XML** **元素都须有关闭标签（也就是闭合）**

2. **XML** **标签对大小写敏感**

3. **XML** **必须正确地嵌套**

4. **XML** **文档必须有根元素**

5. **XML** **的属性值须加引号**

6. **XML** **中的特殊字符**

7. **文本区域（****CDATA** **区）** 

   ​	

   ```xml
   CDATA 里的文本内容，只是纯文本，不需要 xml 语法解析 
   
   CDATA 格式： <![CDATA[]]>
   <![CDATA[ 这里可以把你输入的字符原样显示，不会解析 xml ]]>
   ```





## 解析技术

解析xml代码的技术

![image-20220816192720432](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220816192720432.png)

 **Dom4j 它是第三方的解析技术**。我们需要使用第三方给我们提供好的类库才可以解析 xml 文件



### Dom4j读取与解析

1.读取xml创建一个document对象

```java
// 要创建一个 Document 对象，需要我们先创建一个SAXReader对象
// 这个对象用于读取 xml 文件，然后返回一个 Document。 
SAXReader saxReader = new SAXReader();
Document dom = saxReader.read("xml816/src/816.xml");
```



2. 通过docunment对象，获得各个元素(变量类型为Element)

   ```java
    SAXReader saxReader = new SAXReader();
           Document dom = saxReader.read("xml816/src/816.xml");
           Element rootElement = dom.getRootElement();
           List<Element> elements = rootElement.elements("book");
           for (Element ele: elements) {
               /*System.out.println(ele.asXML());*/
               Element name = ele.element("name");
               Element author = ele.element("author");
               Element time = ele.element("time");
               Element price = ele.element("price");
               System.out.println("name:" + name.getText() + "author:" + author.getText() +
                       "time:" + time.getText() + "price:"  + price.getText());
           }
   ```

   ```java
   //各个函数：
   document.getRootElement()    //获取document的根元素,返回类型为Element
   rootElement.elements()       //获取根元素的各个子元素，返回类型为List<Element>
   eleFather.eleChild(String string)//获取eleFather的指定子元素
   element.getText()			//获取起始标签和结束标签之间的文本内容
   
   element.asXML()				//将当前element元素转换成String对象
   ```

   



# 

# JavaWeb开始！！！！！！！

## 概念

J所有通过 Java 语言编写可以通过浏览器访问的程序的总称，叫 JavaWeb。 

JavaWeb 是基于请求和响应来开发的



请求是指客户端给服务器发送数据，叫请求 Request。 

响应是指服务器给客户端回传数据，叫响应 Response。

请求和响应是成对出现的，有请求就有响应。



## web资源分类

web 资源按实现的技术和呈现的效果的不同，又分为静态资源和动态资源两种。 

静态资源： html、css、js、txt、mp4 视频 , jpg 图片 

动态资源： jsp 页面、Servlet 程序、



## **常用的** **Web** **服务器** 

![image-20220817152231553](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220817152231553.png)



# Tomcat

![image-20220817152549188](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220817152549188.png)





创建动态web工程

1. 新建模块或项目

   ![image-20220817223329391](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220817223329391.png)

2. 模块添加框架支持

   ![image-20220817223353404](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220817223353404.png)

3. 勾选web application![image-20220817224045195](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220817224045195.png)

其余的看PDF



# Servlet



1、Servlet 是 JavaEE 规范之一。规范就是接口 

2、Servlet 就 JavaWeb 三大组件之一。三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器。 

3、Servlet 是运行在服务器上的一个 java 小程序，它可以接收客户端发送过来的请求，并响应数据给客户端。



## 创建servlet项目

1. new project / mouble

2. add framework support ----- web application

   如果没有web application则

   ![image-20220820141929744](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820141929744.png)

   ![image-20220820141952124](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820141952124.png)

   在这两项中删除相关web关联

   

3. 在src目录中编写java源码，创建类来实现Servlet接口或者继承httpServlet类

   　

   ```
   HttpServlet 指能够处理 HTTP 请求的 servlet，它在原有 Servlet 接口上添加了一些与 HTTP 协议处理方法，它比 Servlet 接口的功能更为强大。因此开发人员在编写Servlet时，通常**应继承这个类，而避免直接去实现Servlet接口。
   ```

   

4. 在web.xml中进行配置

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0">
       
       
       <servlet>       
           <!--servlet-name 标签 Servlet 程序起一个别名（一般是类名） -->
           <servlet-name>hello</servlet-name>
           <!--servlet-class 是 Servlet 程序的全类名-->
           <servlet-class>com.hello.helloworld</servlet-class>
       </servlet>
       <!--servlet-mapping 标签给 servlet 程序配置访问地址-->
       <servlet-mapping>
          <!--servlet-name 标签的作用是告诉服务器，我当前配置的地址给哪个 Servlet 程序使用-->
           <servlet-name>hello</servlet-name>
           <!--url-pattern 标签配置访问地址 <br/> / 斜杠在服务器解析的时候，表示地址为：http://ip:port/工程路径 <br/> /hello 表示地址为：http://ip:port/工程路径/hello <br/> 工程路径在Tomcat Server处可设置-->
           <url-pattern>/hello</url-pattern>    
       </servlet-mapping>
       
       
   </web-app>
   ```



5. 可直接新建Servlet程序，自动生成

   ![image-20220820151438307](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820151438307.png)



## **输入的地址如何定位到Servlet程序**

![image-20220820143217796](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820143217796.png)

输入的地址

http://表示使用的协议 

localhost表示服务器ip

：8080为端口号，不同软件使用端口号不同，Tomcat使用的端口号为8080，就可以通过8080来定位Tomcat程序

/工程路径/资源路径 ：

​		web.xml中：

```xml
 <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.hello.helloworld</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>hello</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```

url-pattern追溯到servlet-name，看这个资源路径关联的是哪个servlet程序

servlet-name 追溯到 servlet-class ，执行该目录下，类实现的service函数





## Servlet的生命周期

```java
public class helloworld extends HttpServlet {
    public helloworld() {
        System.out.println("1.构造");;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3. service函数");
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2. 初始化");
    }
}
```

1、执行 Servlet 构造器方法 

2、执行 init 初始化方法 

第1、2步，是在第一次访问，的时候创建 Servlet 程序会调用。 

3、执行 service 方法 

第3步，每次访问都会调用。 

4、执行 destroy 销毁方法 

第4步，在 web 工程停止的时候调用





## Get和Post分发请求

对于两种不同请求，希望在service方法中有不同的处理方式

```html
<input type="submit" method="GET">GET
<input type="submit" method="POST">POST
```

对于实现Servlet接口：

```java
 @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String method = req.getMethod();
        if("GET".equals(method)){
        }else if("POST".equals(method)){
        }
    }
    public void doGet(){
    }

    public void doPost(){
    }
```



对于继承HttpServlet类： 

直接在doGet doPost方法写

service方法会自动执行

```java
  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
```







## 继承关系

![image-20220820152900774](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820152900774.png)

![image-20220820153228098](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820153228098.png)

HttpServlet源码中的doPost/doGet函数，只会判断异常

```java
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_get_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }

    }
```

我们继承HttpServlet实现的类，重写这一方法即可





## ServletConfig

Servlet 程序的配置信息类，最上级是个接口。 

Servlet 程序和 ServletConfig 对象都是由 Tomcat 负责创建，我们负责使用。 

Servlet 程序默认是第一次访问的时候创建，ServletConfig 是每个 Servlet 程序创建时，就创建一个对应的 ServletConfig 对象。



三大作用：

1、获取 Servlet 程序的别名 servlet-name 的值 

2、获取初始化参数 init-param 

3、获取 ServletContext 对象 

```java
package javax.servlet;
import java.util.Enumeration;

public interface ServletConfig {
    String getServletName();      //获取 Servlet 程序的别名 servlet-name 的值 
    ServletContext getServletContext(); //获取 ServletContext 对象 
    String getInitParameter(String var1); //获取初始化参数 init-param 
    Enumeration<String> getInitParameterNames();
}
```



init-parm

```xml
 <servlet>
        <servlet-name>hello</servlet-name>
        <servlet-class>com.hello.helloworld</servlet-class>
     //初始化参数
        <init-param>
            <param-name>name</param-name>  	//参数名
            <param-value>abcd</param-value>	//参数值
        </init-param>
</servlet>
```



​		备注：可使用getServletConfig方法获得这一对象。init方法形参中有ServletConfig，重写init方法一定要加上父辈的init方法

```java
@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);					//不能忘
        System.out.println("2. 初始化"); 	
    }
```

​			因为GenericServlet的源码里，init会保存config，成为自身的属性。不调用 super.init(config)的话会丢失

```java
public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.init();
    }
```



ServletConfig的方法：

![image-20220820210916296](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820210916296.png)



## ServletContext

1、ServletContext 是一个接口，它表示 Servlet 上下文对象 

2、一个 web 工程，只有一个 ServletContext 对象实例。 

3、ServletContext 对象是一个域对象。 

4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。 

![image-20220820214320497](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820214320497.png)





**四个作用**：

1、获取 web.xml 中配置的上下文参数 **context-param** 

2、获取当前的工程路径，格式: /工程路径 

3、获取工程部署后在服务器硬盘上的绝对路径 

4、像 Map 一样存取数据 （设置键值对）



方法：

```java
getInitParameter(String name);
getContextPath()
context.getRealPath(String path)      //输入project目录的路径，获得对应的部署目录路径。         编写代码的目录和实际输出部署的目录是两个不同的目录
setAttribute(String key,Object value);  //设置键值对
getAttribute(String key);

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        String contextName = context.getInitParameter("contextName");
        System.out.println(contextName);
        System.out.println(context.getContextPath());
        System.out.println(context.getRealPath("/"));
	
        context.setAttribute("key",100);
        System.out.println(context.getAttribute("key"));
    }
```





**context-param:**

与init-param不同，要写在外面。

```xml
<context-param>
    <param-name>contextName</param-name>
    <param-value>contextValue</param-value>
</context-param>

<servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.hello.helloworld</servlet-class>
    <init-param>
        <param-name>name</param-name>
        <param-value>abcd</param-value>
    </init-param>
</servlet>
```





## HTTP

 HTTP 协议指客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫 HTTP 协议。 

HTTP 协议中的数据又叫报文。



​		**客户端给服务器发送数据叫请求。 服务器给客户端回传数据叫响应。**



### 请求

#### GET请求

组成：

![image-20220820220510967](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820220510967.png)

![image-20220820220445537](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820220445537.png)



#### POST请求

组成：

![image-20220820220527999](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820220527999.png)

![image-20220820220655285](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820220655285.png)



#### 常用请求头

Accept: 表示客户端可以接收的数据类型 

Accpet-Languege: 表示客户端可以接收的语言类型 

User-Agent: 表示客户端浏览器的信息 

Host： 表示请求时的服务器 ip 和端口号



#### GET/POST使用情况

![image-20220820220909442](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820220909442.png)

所以**使用doGet / doPost函数处理对应标签**





### 响应

格式：

![image-20220820221232374](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820221232374.png)



![image-20220820221343797](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820221343797.png)



常见响应码

![image-20220820221439628](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820221439628.png)



CHORME查看请求和相应：网络，然后点击对应文件

![image-20220820230015411](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820230015411.png)





### MIME类型

MIME 是 HTTP 协议中**数据类型**。 

MIME 的英文全称是"Multipurpose Internet Mail Extensions" 多功能 Internet 邮件扩充服务。MIME 类型的格式是“大类型/小类型”，并与某一种文件的扩展名相对应

![image-20220820221834068](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820221834068.png)

![image-20220820221840972](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820221840972.png)





## HttpServletRequest

获取请求：

​		每次只要有请求进入 Tomcat 服务器，Tomcat 服务器就会把请求过来的 HTTP 协议信息解析好封装到 Request 对象中。 然后传递到 service 方法（doGet 和 doPost）中给我们使用。我们可以通过 HttpServletRequest 对象，获取到所有请求的信息。 



方法：

得到的是**客户端相关信息**

```java

getRequestURI()   获取请求的资源路径
getRequestURL()   获取请求的统一资源定位符（绝对路径）
getRemoteHost()   获取客户端的 ip 地址 
getHeader(String name) 	  获取请求头 
getMethod()       获取请求的方式 GET 或 POST   
    
getParameter(String name)    获取请求的参数 
getParameterValues() 获取请求的参数（多个值的时候使用） 
 
setAttribute(key, value); 设置域数据 
getAttribute(key); 获取域数据 
getRequestDispatcher() 获取请求转发对象

setCharacterEncoding("UTF-8")  //设置字符集 可解决乱码	需要在所有getParameter()前使用
```



代码举例：

getParameter()

![image-20220820231518029](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820231518029.png)



```java
System.out.println(req.getRequestURI());
System.out.println(req.getRequestURL());

outcome:
/820Servlet/hello
http://localhost:8080/820Servlet/hello
```







## 请求转发

![image-20220820232829567](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820232829567.png)

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");//转发至servlet2程序
        requestDispatcher.forward(req,resp);

        RequestDispatcher requestDispatcher2 = req.getRequestDispatcher("/WEB-INF/test2.html");//跳转到另一个html网页
        requestDispatcher2.forward(req,resp);
    }
```



如上述代码所示，**设置跳转时经常会使用相对路径，相对路径的参照路径是现在的路径**，可能会出错。因此跳转时常会用到base标签：

设置相对路径的参照路径

```
<head>
<base herf="http://localhost:8080/xxx">
</head>   
```



## / 的意义

![image-20220820234947490](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220820234947490.png)



## HttpServletResponse

​		HttpServletResponse 类和 HttpServletRequest 类一样。每次请求进来，**Tomcat 服务器都会创建一个 Response 对象传 递给 Servlet 程序去使用**。**HttpServletRequest 表示请求过来的信息，HttpServletResponse 表示所有响应的信息**。

​		我们如果需要设置返回给客户端的信息，都可以通过 HttpServletResponse 对象来进行设置



### 两个输出流

字节流 	getOutputStream()	常用于下载（传递二进制数据） 

字符流 	getWriter() 				常用于回传字符串（常用）

​															**两者不能同时使用**



### 方法

```java
setCharacterEncoding();		//设置字符集
getCharacterEncoding();		//得到字符集

setCharacterEncoding("UTF-8"); 
setHeader("Content-Type", "text/html; charset=UTF-8");  // 通过响应头，设置浏览器也使用 UTF-8 字符集 

// 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头 
// 此方法一定要在获取流对象之前调用才有效 
setContentType("text/html; charset=UTF-8");
```

设置字符集，防止乱码方法：

```java
//1.
setCharacterEncoding("UTF-8"); 
setHeader("Content-Type", "text/html; charset=UTF-8");  // 通过响应头，设置浏览器也使用 UTF-8 字符集 

//2.
// 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头 
// 此方法一定要在获取流对象之前调用才有效 
setContentType("text/html; charset=UTF-8");
```



## 请求重定向



![image-20220822145654330](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822145654330.png)



与请求转发的区别：

1. 浏览器地址发生变化
2. 实际上是两次请求，浏览器接受响应后，向新的servlet程序发出新请求
3. 两个servlet程序不相关，各自独立



实现方法：

```java
//1.
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      resp.setStatus(302); 								// 设置响应状态码 302 ，表示重定向
      resp.setHeader("Location", "http://localhost:8080"); // 设置响应头，说明 新的地址在哪里 
    }


//2.
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     resp.sendRedirect("http://localhost:8080");
    }
```









# JavaEE三层架构

![image-20220822154812688](C:\Users\Saitama\AppData\Roaming\Typora\typora-user-images\image-20220822154812688.png)





# 

# JSP(图片出错)

Java Server Pages(java服务器页面)

jsp 的主要作用是**代替 Servlet 程序回传 html 页面的数据**。 

因为 Servlet 程序回传 html 页面数据是一件非常繁锁的事情。开发成本和维护成本都极高

(比如我希望注册成功后页面上增加一个什么什么，在servlet的doPost/doGet函数中实现麻烦，而使用foraward跳转到另一个页面，和需求不符)

servlet回传html数据需要以下操作：

```java
 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8\"");
        PrintWriter writer = resp.getWriter();
        writer.print("HTML页面代码");
        writer.print("HTML页面代码");
        writer.print("HTML页面代码");
        writer.print("HTML页面代码");
    }
```



JSP只需要在web路径下创建一个jsp文件



![image-20220908184114763](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908190936992.png)

访问时，只需要输入地址：        http://ip:port/工程路径/xxx.jsp 



## JSP实质

jsp 页面本质上是一个 Servlet 程序。 

当我们第一次访问 jsp 页面的时候。Tomcat 服务器会帮我们把 jsp 页面翻译成为一个 **java 源文件**。并且对它进行编译成 为.class 字节码程序。



![image-20220908185131580](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908191542061.png)

存放路径在第一行：

![image-20220908185157668](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220822145654330.png)

图中jsp_005xxxx类 继承了**HttpJspBase 类**。HttpJspBase 类继承了 **HttpServlet 类**。也就是说。**jsp 翻译出来的 java 类，它间接了继 承了 HttpServlet 类**。也就是说，翻译出来的是一个 **Servlet 程序** 

**底层也是通过输出流write出来的**



## JSP三种语法



```jsp
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
        ...
%>

language 属性 表示 jsp 翻译后是什么语言文件。暂时只支持 java。
contentType 属性 表示 jsp 返回的数据类型是什么。也是源码中 response.setContentType()参数值
pageEncoding 属性 表示当前 jsp 页面文件本身的字符集。
import 属性 跟 java 源代码中一样。用于导包，导类。

autoFlush 属性 设置当write输出流缓冲区满了之后，是否自动刷新冲级区。默认值是 true。
buffer 属性 设置write缓冲区的大小。默认是 8kb

errorPage 属性 设置当 jsp 页面运行时出错，自动跳转去的错误页面路径。
isErrorPage 属性 设置当前 jsp 页面是否是错误信息页面。默认是 false。如果是 true 可以 获取异常信息。
session 属性 设置访问当前 jsp 页面，是否会创建 HttpSession 对象。默认是 true。
extends 属性 设置 jsp 翻译出来的 java 类默认继承谁。
```



## 脚本

1. 声明脚本 会自动在jsp类中创建该属性/代码块/函数   **不常用**

![image-20220908190936992](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220822154812688.png)

![image-20220908190949967](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908192252502.png)

2. 表达式脚本（常用)

![image-20220908191542061](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908192652901.png)

可输出字符串、整型、...以及在**声明脚本中定义的变量**

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%= "泥嚎"%>
<%= "12"%>
<%= "12"%>
<html>

<head>
    <title>ABCD</title>
</head>
<body>
     HI
</body>
</html>
```







3. 代码脚本

![image-20220908191816626](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908191816626.png)



## 注释

1. html注释

html 注释会被翻译到 java 源代码中。在_jspService 方法里，以 **out.writer 输出到客户端**

![image-20220908192252502](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908190949967.png)

2. java注释

java 注释会被翻译到 java 源代码中。但需要放在代码脚本里

```jsp
     <%
         /*java注释*/
     %>
```

![image-20220908192652901](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908200845180.png)

3. jsp注释

jsp 注释可以注掉，jsp 页面中所有代码。

```jsp
 <%
         /*java注释*/
     %>

     <%-- 这是 jsp 注释 --%>

     <%--
      <%
         /*java注释*/
     %>
     --%>
```



## JSP九大内置对象

jsp文件源码中的属性

```java
final javax.servlet.jsp.PageContext pageContext;
javax.servlet.http.HttpSession session = null;
final javax.servlet.ServletContext application;
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
javax.servlet.jsp.JspWriter _jspx_out = null;
javax.servlet.jsp.PageContext _jspx_page_context = null;
```





request	请求对象
response	响应对象
pageContext	jsp的上下文对象
session	会话对象
application	ServletContext对象
config	ServletConfig对象
out	jsp输出流对象
page	指向当前jsp的对象
except ion	异常对象



### 四个域对象





![image-20220908195303882](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908195244479.png)





## out 输出和 response.getWriter 输出的区别



![image-20220908200646105](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908204430909.png)

![image-20220908200845180](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908195244479.png)



## 常用标签

jsp中的html内容，**如果一个网页由多部分组成**，就可以使用包含功能，将不同部分包含在一个jsp文件中

### 静态包含

```jsp
<%= "泥嚎"%>
<%@include file="filepath"%>
```



file 属性指定你要包含的 jsp 页面的路径

*地址中第一个斜杠* */* *表示为* *http://ip:port/**工程路径**/* *映射到代码的* *web* *目录* 



*静态包含的特点：* 

*1、静态包含不会翻译被包含的* *jsp* *页面。* 

*2、静态包含其实是把被包含的* *jsp* *页面的代码拷贝到包含的位置执行输出。*



### 动态包含

语法：

```jsp
<jsp:include page="index.jsp"></jsp:include>
```



对源码的影响：

```java
out.print( "泥嚎");
out.write('\r');
out.write('\n');
org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "index.jsp", out, false);
```



动态包含的特点：
1、动态包含会把包含的 jsp 页面也翻译成为 java 代码 
2、动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。 JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false); 
3、动态包含，还可以传递参数



底层原理：

将resq,resp,out对象传到另一个jsp文件中使用，在另一个文件中out输出。而并非在原来的jsp文件中增加对应代码

![image-20220908203008690](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908214118385.png)



### 转发

```jsp
 <jsp:forward page=""></jsp:forward> 
```

请求转发标签，它的功能就是请求转发 page 属性设置请求转发的路径



我们可以将从数据库查到的一些数据，放到resq域中保存，然后将resq请求转发给jsp进行进一步处理



![image-20220908204430909](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908214706396.png)



## 监听器

1、Listener 监听器它是 JavaWeb 的三大组件之一。JavaWeb 的三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监 

听器。

2、Listener 它是 JavaEE 的规范，就是接口 

3、监听器的作用是，监听某种事物的变化。然后通过回调函数，反馈给客户（程序）去做一些相应的处理。



## ServletContextListener监听器

可以监听 ServletContext 对象的创建和销毁。 

ServletContext 对象在 web 工程启动的时候创建，在 web 工程停止的时候销毁。 

监听到创建和销毁之后都会分别调用 ServletContextListener 监听器的方法反馈。



有两个方法：

```java
public interface ServletContextListener extends EventListener {

/* 在 ServletContext 对象创建之后马上调用，做初始化 */ 
public void contextInitialized(ServletContextEvent sce); 

/* 在 ServletContext 对象销毁之后调用 */
public void contextDestroyed(ServletContextEvent sce); }
```



使用ServletContextListener,只需要：

1. 创建ServletContextListener对象实例，实现初始化/销毁的方法
2. 在web.xml中配置

```java
package com.jsp.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListener_ipl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁");
    }
}
```



```xml
    <listener>
        <listener-class>com.jsp.test.ServletContextListener_ipl</listener-class>
    </listener>
```







# EL表达式(图片出错)



EL （Expression Language） 表达式语言



EL 表达式主要是**代替 jsp 页面中的表达式脚本**在 jsp 页面中进行**数据的输出**。 因为 EL 表达式在输出数据的时候，要比 jsp 的表达式脚本要简洁很多。 



**格式：${表达式}** 



同样的输出数据：

```jsp
<%
	request.setAttribute("key",123);
%>

<%=request.getAttribute("key")%>  //表达式输出

${key}	//EL表达式输出
```

EL 表达式在输出 null 值的时候，输出的是空串。jsp 表达式脚本输出 null 值的时候，输出的是 null 字符串。



## 输出顺序

jsp中四个域对象有输出顺序之分



![image-20220908195244479](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908214702214.png)

当一个key对应不同value时，按照四个域从小到大的顺序去搜索，找到了就输出





## 输出各种对象属性

![image-20220908214118385](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908203008690.png)

```
Person p = new Person()
输出对象： ${p}
输出对象值： ${p.name}
数组：${p.phones[i]}
List:${p.citites[i]}
Map:${p.map}
Map里的某个key的值： ${p.map.key1}

```



## 运算

![image-20220908214702214](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908200646105.png)

![image-20220908214706396](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908214712541.png)

![image-20220908214712541](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220820220655285.png)



![image-20220908214702214](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908214740526.png)

![image-20220908214712541](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908214831751.png)



![image-20220908214740526](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/image-20220908215059968.png)

```
${empty xxx}  //不是函数，不用加括号
```





# JSTL标签库(图片出错)

JSTL（JSP Standard Tag Library）JSP 标准标签库。是一个不断完善的开放源代码的 JSP 标签库。

​	EL 表达式主要是为了替换 jsp 中的表达式脚本，而标签库则是为了替换代码脚本。这样使得整个 jsp 页面 

变得更佳简洁。 





```jsp
  CORE 标签库 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  XML 标签库 <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
  FMT 标签库 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
  SQL 标签库 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> 
  FUNCTIONS 标签库 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
```





## 使用步骤

1. 导入jstl标签库两个jar包

   taglibs-standard-impl-1.2.1.jar 

   taglibs-standard-spec-1.2.1.jar

2. 使用 taglib 指令引入标签库



## core核心库

看pdf吧



# 

# 



# 文件上传下载

## 基本

1、要有一个 form 标签，method=post 请求 

2、form 标签的 encType 属性值必须为 multipart/form-data 值 

3、在 form 标签中使用 input type=file 添加上传的文件 

4、编写服务器代码（Servlet 程序）接收，处理上传的数据。 



encType=multipart/form-data 表示提交的数据，以多段（每一个表单项一个数据段）的形式进行拼接，然后以二进制流的形式发送给服务器

```
<form method="post" enctype="multipart/form-data">
  文件上传<input type="file">
</form>
```



## 文件上传的HTTP协议

看pdf





# MVC

![image-20220913193859483](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913193859483-16630771943511.png)



![image-20220913194117298](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913194117298-16630771943522.png)





# Cookie

![image-20220913194756364](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913194756364-16630771943523.png)



![image-20220913195641862](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913195641862-16630771943524.png)









## 创建

通过response.addCookie返回响应

```java
protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1", "value1");
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie_:cookies) {
            System.out.println(cookie_.getName() + cookie_.getValue());
        }
    }
```



## 服务器获取cookie

通过req.getCookies获取

```java
protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Cookie[] cookies = req.getCookies();
        for (Cookie cookie_:cookies) {
            System.out.println(cookie_.getName() + cookie_.getValue());
        }
}
```



## 修改

1. 新建一个同名cookie再addCookie
2. 使用cookie的setValue方法

```java
 Cookie cookie = new Cookie("key1", "value1");
resp.addCookie(cookie);


方案一： 
// 1、先创建一个要修改的同名的 Cookie 对象 
//  2、在构造器，同时赋于新的 Cookie 值。
Cookie cookie = new Cookie("key1","newValue1"); 
// 3、调用 response.addCookie( Cookie ); 通知 客户端 保存修改 
resp.addCookie(cookie);


方案二： 
// 1、先查找到需要修改的 Cookie 对象 
Cookie cookie = CookieUtils.findCookie("key2", req.getCookies()); 
if (cookie != null) { 
    // 2、调用 setValue()方法赋于新的 Cookie 值。
    cookie.setValue("newValue2"); 
    // 3、调用 response.addCookie()通知客户端保存修改 
resp.addCookie(cookie); }
```



## 浏览器查看cookie

![image-20220913200553062](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913200553062-16630771943525.png)





## Cookie生命控制

管理 Cookie 什么时候被销毁（删除） 



```java
setMaxAge() 
//正数，表示在指定的秒数后过期 
//负数，表示浏览器一关，Cookie 就会被删除（默认值是-1） 
//零，表示马上删除 Cookie 
```

```java
cookie.setMaxAge(60 * 60); // 设置 Cookie 一小时之后被删除
resp.addCookie(cookie);
```





## Path

通过设置path属性，来设置哪些cookie发送给服务器哪些不发



现有两个cookie：

```
CookieA 	path=/工程路径 
CookieB 	path=/工程路径/abc 
```

cookieA会给/工程路径下的**所有子路径（包括本身**）发送

cookieB会给/工程路径/abc 下的**所有子路径（包括本身**）发送

因此：

```
http://ip:port/工程路径/a.html 
CookieA 发送 
CookieB 不发送 

http://ip:port/工程路径/abc/a.html
CookieA 发送 
CookieB 发送
```





## cookie传输流程

![image-20220913201800897](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913201800897-16630771943526.png)







# Session

![image-20220913202025292](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913202025292-16630771943527.png)



1、Session 就一个接口（HttpSession）。 

2、Session 就是会话。它是用来**维护一个客户端和服务器之间关联**的一种技术。 

3、每个客户端都有自己的一个 Session 会话。 

4、Session 会话中，我们经常用来**保存用户登录之后的信息**。



## Session超时

session的超时指的是，

**客户端两次请求的最大间隔时长**。





## 创建和获取

getSession

```java
request.getSession() 
//第一次调用是：创建 Session 会话 
//之后调用都是：获取前面创建好的 Session 会话对象。
HttpSession session = req.getSession();

```



isNew

判断到底是不是刚创建出来的（新的） 

true 表示刚创建 ,false 表示获取之前创建 

```java
boolean aNew = session.isNew();
```





getId

得到 Session 的会话 id 值。 

**每个会话都有一个身份证号。也就是 ID 值。而且这个 ID 是唯一的。** 

```java
 String id = session.getId();
```



## 存取数据

通过setAttribute和getAttribute

```
req.getSession().setAttribute("key1", "value1"); 
resp.getWriter().write("已经往 Session 中保存了数据");

Object attribute = req.getSession().getAttribute("key1");
resp.getWriter().write("从 Session 中获取出 key1 的数据是：" + attribute);
```



## 生命周期控制

```java
public void setMaxInactiveInterval(int interval) 
```

设置 Session 的超时时间（以秒为单位），超过指定的时长，Session就会被销毁。



```java
public int getMaxInactiveInterval()

```

获取 Session 的超时时间 



```java
public void invalidate() 
```

让当前 Session 会话马上超时无效。



![image-20220913203235620](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913203235620-16630771943528.png)

![image-20220913203702318](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913203702318-16630771943529.png)



## Cookie与Session

Session 技术，底层其实是基于 Cookie 技术来实现的

浏览器通过cookie发送session信息，服务器再通过cookie中保存的sessionID找到对应的session会话





#  Filter

1、Filter 过滤器它是 JavaWeb 的三大组件之一。三大组件分别是：Servlet 程序、Listener 监听器、Filter 过滤器 

2、Filter 过滤器它是 JavaEE 的规范。也就是接口 

3、Filter 过滤器它的作用是：**拦截请求**，过滤响应。



拦截请求常见的应用场景有： 

1、权限检查 

2、日记操作 

3、事务管理 

……等等



## Filter类实例

```java
public class filiter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        //通过session查看是否登录
        Object user = session.getAttribute("user");
        // 如果等于 null，说明还没有登录
        if (user == null) {           
        servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse); 		
        return;
        }
        else {
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

```



xml配置：

```xml
<filter>
        <filter-name>AdminFilter</filter-name>
        <filter-class>filiter</filter-class>
</filter>
<filter-mapping>
    <filter-name>AdminFilter</filter-name>
    <!--url-pattern 配置拦截路径
        / 表示请求地址为：http://ip:port/工程路径/
        映射到 IDEA 的 web 目录
        /admin/* 表示请求地址为：http://ip:port/工程路径/admin/*
         -->
    <url-pattern>/dir</url-pattern>
</filter-mapping>
```



Filter 过滤器的使用步骤： 

1、编写一个类去实现 Filter 接口 

2、实现过滤方法 doFilter() 

3、到 web.xml 中去配置 Filter 的拦截路径





## Filter生命周期

Filter 的生命周期包含几个方法 

1、构造器方法 

2、init 初始化方法 

第 1，2 步，在 web 工程启动的时候执行（Filter 已经创建） 

3、doFilter 过滤方法 

第 3 步，每次拦截到请求，就会执行 

4、destroy 销毁 

第 4 步，停止 web 工程的时候，就会执行（停止 web 工程，也会销毁 Filter 过滤器）





## FilterConfig

FilterConfig 类见名知义，它是 Filter 过滤器的配置文件类。 

Tomcat 每次创建 Filter 的时候，也会同时创建一个 FilterConfig 类，这里包含了 Filter 配置文件的配置信息。 



FilterConfig 类的作用是获取 filter 过滤器的配置内容 

1、获取 Filter 的名称 filter-name 的内容 

2、获取在 Filter 中配置的 init-param 初始化参数 

3、获取 ServletContext 对象 



```java
 @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("username"));
        System.out.println(filterConfig.getInitParameter("url"));
    }
```

xml:

```xml
<filter>
    <filter-name>AdminFilter</filter-name>
    <filter-class>filiter</filter-class>

    <init-param>
        <param-name>username</param-name>
        <param-value>root</param-value>
    </init-param>

    <init-param>
        <param-name>url</param-name>
        <param-value>jdbc:mysql://localhost3306/test</param-value>
    </init-param>
</filter>
```





## FilterChain

![image-20220913212437149](D:\OneDrive\Documents\tencent files\1517086270\filerecv\mobilefile\javaweb.assets\image-20220913212437149-166307719435210.png)



## Filter拦截路径

```xml
精确匹配：

<url-pattern>/target.jsp</url-pattern> 

以上配置的路径，表示请求地址必须为：http://ip:port/工程路径/target.jsp 


目录匹配：

<url-pattern>/admin/*</url-pattern> 

以上配置的路径，表示请求地址必须为：http://ip:port/工程路径/admin/* 


后缀名匹配:

<url-pattern>*.html</url-pattern> 

以上配置的路径，表示请求地址必须以.html 结尾才会拦截到 

<url-pattern>*.do</url-pattern> 

以上配置的路径，表示请求地址必须以.do 结尾才会拦截到 

<url-pattern>*.action</url-pattern> 

以上配置的路径，表示请求地址必须以.action 结尾才会拦截到 

```



Filter 过滤器它只关心请求的地址是否匹配，不关心请求的资源是否存在！！！







# ThreadLocal

ThreadLocal 的作用，它可以解决多线程的数据安全问题。 

ThreadLocal 它可以给当前线程关联一个数据（可以是普通变量，可以是对象，也可以是数组，集合）

 

ThreadLocal 的特点： 

1、ThreadLocal 可以为当前线程**关联一个数据**。（它可以像 Map 一样存取数据，key 为当前线程） 

2、每一个 ThreadLocal 对象，**只能**为当前线程关联**一个**数据，如果要为当前线程关联多个数据，就需要使用多个 

ThreadLocal 对象实例。 

3、每个 ThreadLocal 对象实例定义的时候，一般都是 static 类型 

4、ThreadLocal 中保存数据，在线程销毁后。会由 JVM 虚拟自动释放

























JSON

AJAX

i18n



- Tomcat(简单过一下)
- XML/注解(简单过一下)
- Servlet(**重点理解**)
- HTTP协议(**重点理解**)
- Filter[过滤器](https://www.zhihu.com/search?q=过滤器&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A"816117691"})(**重点理解**)
- Listener监听器(简单过一下)
- JSP(简单过一下)
- AJAX、JSON(简单过一下)