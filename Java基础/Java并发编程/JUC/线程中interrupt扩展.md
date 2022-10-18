### 读懂isInterrupted、interrupted、interrupt



> ###### interrupt是什么：
>
> ##### 在Java中没法立即停止一个线程，为了取消一个耗时严重的线程，出现了一种协商机制-中断机制。
>
> ##### 中断机制是一种协商合作机制，当代码检测到interrupt为true时，表示要退出当前线程。



#### <font color='red'>三个方法</font>

- ##### isInterrupted ：

  - ##### 实例方法

  - ##### 返回当前线程中断标志状态(Boolean)

- ##### interrupted ：

  - ##### 静态方法

  - ##### 返回当前线程中断标志状态(Boolean)，同时将中断标志设置为false

- ##### interrupt ：

  - ##### 实例方法

  - ##### 将当前线程的中断标志设置为true，不会停止线程