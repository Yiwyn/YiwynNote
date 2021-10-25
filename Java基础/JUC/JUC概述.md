## <font color='red'>什么是JUC</font> 



- #### juc是java.util.concurrent工具包的简称。

- #### 这是一个处理线程的工具包，从jdk1.5之后出现





</br><hr></br>



## <font color='red'>进程和线程</font>



- #### <font color='red'>进程</font>是线程的容器，是系统进行资源分配和调度的基本单位

- #### <font color='red'>线程</font>是操作系统能进行运算调度的最小单元，是进程中的实际运作单位。一条线程指的是进程中一个单一顺序的控制流，一个进程中可以有多个线程，每条线程可以执行不同的任务。



</br><hr></br>



## <font color='red'>管程</font>



- #### Monitor 监视器

- #### 是一种同步机制，保证同一时间，只有一个线程访问被保护数据或者代码





</br><hr></br>





## <font color='red'>用户线程和守护线程</font>



- ### 用户线程

  - #### 平时自定义的线程

- ### 守护线程

  - #### 用在后台中的特殊线程，如垃圾回收

  - #### 当线程中只有守护线程，jvm会停止运行

  - #### 设置守护线程应该在线程start之前

    - #### thread.setDaemin(true);

  - 

