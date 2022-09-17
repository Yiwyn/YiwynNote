#### 线程中interrupt的前世今生



- ##### isInterrupted

  - ##### 判断当前线程是否存在interrupted标志

- ##### interrupted 静:

  - ##### 判断当前线程是否存在interrupted标志，存在则清除此标志

- ##### interrupt:

  - ##### 给调用方法的线程一个中断标志，当前线程依旧可以继续执行。

  - ##### 若当前线程实例被标记为interrupted，则在调用wait、join、sleep相关方法，并且正在阻塞状态中时，此中断状态会被清除，并触发InterruptedException。

  - ##### 只要当前的interrupted标志为ture，无论在阻塞时，还是阻塞前变了ture，都会抛出异常，并且重置interrupted为false