### <font color='red'>传统的Synchronized</font>



- ##### 本质：队列，锁









### <font color='red'>Lock接口</font>



- 





> #### Synchronized 和 Lock 的区别

- ##### Synchronized 内置的java关键字。Lock是一个类

- ##### Synchronized 无法判断锁的状态，Lock 可以判断是否获取到了锁

- ##### Synchronized 会自动释放锁，lock必须要手动释放锁，否则可能会死锁

- ##### Synchronized 线程A（获得锁|阻塞）线程B（等等|继续等待；Lock锁不一定会一直等待下去）

- ##### Synchronized 可重入锁，不可以中断的，非公平； Lock 可重入锁，可以判断锁，可以设置是否公平

- ##### Synchronized 适合锁少量的同步代码，Lock 适合锁大量的同步代码