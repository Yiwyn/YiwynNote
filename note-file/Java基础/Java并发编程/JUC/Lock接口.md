## <font color='red'>Lock接口</font>



- #### Lock 是一个接口，而synchronized是java中的关键字，是语言的内置实现。

- #### synchronized 在发生异常时，会自动释放占有的锁，因此不会出现死锁现象；而<font color='red'>Lock</font>在发生异常时，如果没有主动的通过<font color='cornflowerblue'>unlock()</font>去释放锁，则很有可能造成死锁现象，因此使用lock时需要在finally块中释放锁。

- #### Lock可以让等待锁的线程相应中断，而synchronized却不行，使用synchronized时，等待线程会一直等待下去，不能够相应中断。

  

