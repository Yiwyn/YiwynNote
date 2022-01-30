## <font color='red'>CountDownLatch</font>



- #### 减少计数 CountDownLatch <font color='cornflowerblue'>[lætʃ] </font>

  - ##### 构造函数 <font color='cornflowerblue'>CountDownLatch</font>(initVaue)

  - ##### 减少1  countDown()

  - ##### 等待 await





#### 示例

```java
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "，离开了教室");
                //计数器-1
                countDownLatch.countDown();
            }, i + "同学").start();
        }

        //等待
        countDownLatch.await();
        System.out.println("教室关灯了");

    }
```

- ##### 在计数器未到0之前。线程阻塞











## <font color='red'>Cyclic Barrier 循环栅栏</font>



#### <font color='cornflowerblue'>[ˈsaɪklɪk] </font> <font color='cornflowerblue'>[ˈbæriə(r)] </font> 



- #### CyclicBarrier会让自定义线程在等待完成后继续进行下一步操作。



- #### 构造函数 

  - ##### CyclicBarrier(x,fun:action)

    - ##### 第一个参数为需要等待多少线程，第二个参数表示等待线程全部到了await之后执行什么方法

  - ##### 线程调用 await 表示已经到达了栅栏



#### 示例

```java
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("7个数据都输出");
        });

        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
```











## <font color='red'>Semaphore 信号灯</font>



#### <font color='cornflowerblue'>[ˈseməfɔː(r)]</font>



- #### Semaphore 一个计数信息量，从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个<font color='cornflowerblue'>acquire()</font> ，然后再获取该许可。每个<font color='cornflowerblue'>release()</font>添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不适用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取响应的行动。

- #### Semaphore 通常用于限制可以访问某些资源(<font color='red'>物理或逻辑</font>)的线程数目。





- #### 方法

  - ##### Semaphore(int)    初始化可以同时访问资源的线程个数

  - ##### acquire()   从信号量获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断

  - ##### release()   释放一个信号，将其返回给信号量



#### 示例

```java
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "占用了一个位置");

                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("------------" + Thread.currentThread().getName() + "离开了位置");
                }

            }, String.valueOf(i)).start();
        }
    }
}
```

