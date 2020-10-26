# 关于多线程相关的练习

## 一、多线程的实现
多线程的实现目前有3种方式，如下
- 继承Thread类，重写run()方法
- 实现Runnable接口，实现run()方法
- 实现Callable<T>接口，实现 T call()方法

在演示过程中加入了文件操作，于是需要引入以下的工具包
```java
<dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.8.0</version>
        </dependency>
```

### 1、继承Thread方法下载网络图片
````java
//具体实现查看此类，主要是演示如何实现及运行多线程
NetPicDownTests.java
````

### 2、实现Runnable接口下载网络图片
````java
//具体实现查看此类，主要是演示如何实现及运行多线程
NetPicDownTests.java
````

### 3、实现Callable<T>接口运行多线程
````java
//具体实现查看此类，主要是演示如何实现及运行多线程
TestCallable.java
````

### 4、龟兔赛跑demo
```java
//共用成员变量需要声明为static静态的
TortoiseHare.java
```

### 5、多线程的静态代理
````java
//静态代理案例，叙述静态代理的实例
StaticProxy.java
````

