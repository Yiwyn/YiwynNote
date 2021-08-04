## <font color='red'>分布式锁</font>



- #### 进行单机应用开发时，涉及并发同步的时候，我们往往采用<font color='red'>synchronized</font> 或者<font color='red'>lock</font> 的方式来解决线程之间的代码同步问题，这时多线程的运行都是在一个JVM之下，没有任何问题。

- #### 在分布式的集群工作情况下，数据多JVM的工作环境，跨JVM之间已经无法通过多线程的锁来解决同步问题。

- #### 就需要一种更加高级的锁机制，处理<font color='cornflowerblue'>跨机器之间的数据同步问题</font>，即<font color='red'>分布式锁</font>





<hr>



## Zookeeper 分布式锁的原理



- ##### 核心思想：当客户端想要获取锁，则创建节点，使用完锁，则删除该节点

  - ##### 客户端获取锁时，在<font color='cornflowerblue'>lock</font>节点下创建<font color='red'>临时顺序</font>节点。

    - ###### 临时节点：即使当前客户端宕机了，锁节点依旧可以删除，防止锁不会被释放。

  - ##### 获取lock下面的所有子节点，当客户端获取所有的子节点之后，如果发现自己创建的子节点的序号的最小，那么就该客户端得到了锁。使用完锁后，将该节点删除。

  - ##### 如果发现自己创建的节点不是最小的，说明还没有获取到锁，此时客户端要找到比自己小的那个节点，同时对其注册事件监听器，监听删除事件。

  - ##### 如果发现比自己小的节点被删除，则客户端的Watcher会收到相应通知 ，此时再判断自己创建的节点是否是lock子节点中最小的，如果是则获取到锁，不是则重复上一步骤。





<hr>



## Zookeeper 分布式锁



#### java示例

```java
//创建锁
        InterProcessMutex interProcessMutex;
        //初始化锁
        interProcessMutex = new InterProcessMutex(client,"/lock")
        //获取锁
        interProcessMutex.acquire();
        //释放锁
        interProcessMutex.release();
```



##### 获取锁位置，那里操作数据哪里加锁。操作完成释放锁。