## <font color='red'>服务熔断理论</font>





- #### 熔断机制概述

  - ##### 熔断机制是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个微服务出错不可用或者相应时间太长，会进行服务降级，进而熔断该节点微服务的调用，快速返回错误的相应信息。当检测到该节点微服务调用相应正常后，恢复调用链路



![img](https://img-blog.csdnimg.cn/img_convert/84d60234d01c4b7e9cae515066eb711b.png)

- ##### 在SpringCloud框架中，熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的状况，当失败的调用次数到一定阈值，缺省是5秒内20次调用失败，就会启动熔断机制。熔断机制的注解是<font color='orange'>@HystrixCommand</font> 







## <font color='red'>快速开始</font>



- #### 在服务提供者端使用熔断注解

- #### 启动类添加<font color='orange'>@EnableHystrix</font> 注解

  ```java
  @SpringBootApplication
  @EnableEurekaClient
  @MapperScan("com.yiwyn.mapper")
  @EnableHystrix
  public class StudentServiceApplication {
      public static void main(String[] args) {
          SpringApplication.run(StudentServiceApplication.class, args);
      }
  }
  ```

- #### 对service添加服务熔断案列

  ```java
  @Service
  public class StudentService {
  
  	//......
      
      @HystrixCommand(fallbackMethod = "handle", commandProperties = {
         @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
         @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
         @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
         @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
      })
      public String getError(int value) {
          int a = 10 / value;
          return a + "";
      }
  
      private String handle(int value) {
          return "handle---handle ";
      }
  }
  ```

  - #### <font color='red'>注</font>

    - ##### 这里<font color='cornflowerblue'>fallbackMethod</font>参数的需要的函数，一定要和被绑定方法的<font color='red'>返回值和参数一致</font> 

- #### 测试

  - ##### 不停的输入错误的信息 value = 0 当到一定次数的时候，即使输入正确的数字也不能正常访问，等待一段时间之后会可以重新访问



<hr>



- #### 熔断类型

  - ##### 熔断打开：请求不再调用当前服务，内部设置时钟一般为<font color='red'>MTTR(平均故障处理时间)</font>，当打开时长达到所设始终则进入半熔断状态

  - ##### 熔断关闭：熔断关闭不会对服务进行熔断

  - ##### 熔断半开：部分请求根据规则调用当前服务，如果请求成功且符合规则则认为当前服务恢复正常，关闭熔断。



- #### 涉及到断路器的三个重要参数

  - ##### <font color='red'>快照时间窗</font>：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近10s。

  - ##### <font color='red'>请求总数阈值</font>：在快照时间窗内，必须满足请求总数阈值才有资格熔断，默认为20，意味着在10秒内，如果该hystrix命令的调用次数不足20次，即使所有的请求都失败或者其他原因失败，段落器都不会打开。

  - ##### <font color='red'>错误百分比阈值</font>：当请求总数在快照时间窗内超过了阈值，比如发生了30次调用，有15次异常，也就是超过了50%的错误百分比，在默认50%阈值情况下，这时候会将断路器打开。



<hr>



- #### 断路器打开之后

  - ##### 再有请求调用的时候，将不会调用主逻辑，而是直接调用降级fallback。通过断路器，实现了自动地发现错误并将降级逻辑切换为主逻辑，减少相应延迟的效果。



<hr>



- #### 主逻辑如何恢复

  - ##### 当断路器打开，对主逻辑进行熔断之后，hystrix会启动一个<font color='red'>休眠时间窗</font>，这个时间窗内，降级逻辑是临时的成为主逻辑，当休眠时间窗口到期，断路器将会进入半开状态，释放一次请求到原来的主逻辑上，如果此次请求正常返回，那么断路器将持续闭合，主逻辑恢复，如果此次请求依然有问题，断路器继续进入打开状态，休眠时间窗重新计时。



<hr>





- ### 所有配置

  - ```java
    @HystrixCommand(fallbackMethod = "fallbackMethod", 
                    groupKey = "strGroupCommand", 
                    commandKey = "strCommand", 
                    threadPoolKey = "strThreadPool",
                    
                    commandProperties = {
                        // 设置隔离策略，THREAD 表示线程池 SEMAPHORE：信号池隔离
                        @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                        // 当隔离策略选择信号池隔离的时候，用来设置信号池的大小（最大并发数）
                        @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "10"),
                        // 配置命令执行的超时时间
                        @HystrixProperty(name = "execution.isolation.thread.timeoutinMilliseconds", value = "10"),
                        // 是否启用超时时间
                        @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
                        // 执行超时的时候是否中断
                        @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
                        
                        // 执行被取消的时候是否中断
                        @HystrixProperty(name = "execution.isolation.thread.interruptOnCancel", value = "true"),
                        // 允许回调方法执行的最大并发数
                        @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "10"),
                        // 服务降级是否启用，是否执行回调函数
                        @HystrixProperty(name = "fallback.enabled", value = "true"),
                        // 是否启用断路器
                        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                        // 该属性用来设置在滚动时间窗中，断路器熔断的最小请求数。例如，默认该值为 20 的时候，如果滚动时间窗（默认10秒）内仅收到了19个请求， 即使这19个请求都失败了，断路器也不会打开。
                        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
                        
                        // 该属性用来设置在滚动时间窗中，表示在滚动时间窗中，在请求数量超过 circuitBreaker.requestVolumeThreshold 的情况下，如果错误请求数的百分比超过50, 就把断路器设置为 "打开" 状态，否则就设置为 "关闭" 状态。
                        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                        // 该属性用来设置当断路器打开之后的休眠时间窗。 休眠时间窗结束之后，会将断路器置为 "半开" 状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为 "打开" 状态，如果成功就设置为 "关闭" 状态。
                        @HystrixProperty(name = "circuitBreaker.sleepWindowinMilliseconds", value = "5000"),
                        // 断路器强制打开
                        @HystrixProperty(name = "circuitBreaker.forceOpen", value = "false"),
                        // 断路器强制关闭
                        @HystrixProperty(name = "circuitBreaker.forceClosed", value = "false"),
                        // 滚动时间窗设置，该时间用于断路器判断健康度时需要收集信息的持续时间
                        @HystrixProperty(name = "metrics.rollingStats.timeinMilliseconds", value = "10000"),
                        
                        // 该属性用来设置滚动时间窗统计指标信息时划分"桶"的数量，断路器在收集指标信息的时候会根据设置的时间窗长度拆分成多个 "桶" 来累计各度量值，每个"桶"记录了一段时间内的采集指标。
                        // 比如 10 秒内拆分成 10 个"桶"收集这样，所以 timeinMilliseconds 必须能被 numBuckets 整除。否则会抛异常
                        @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10"),
                        // 该属性用来设置对命令执行的延迟是否使用百分位数来跟踪和计算。如果设置为 false, 那么所有的概要统计都将返回 -1。
                        @HystrixProperty(name = "metrics.rollingPercentile.enabled", value = "false"),
                        // 该属性用来设置百分位统计的滚动窗口的持续时间，单位为毫秒。
                        @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "60000"),
                        // 该属性用来设置百分位统计滚动窗口中使用 “ 桶 ”的数量。
                        @HystrixProperty(name = "metrics.rollingPercentile.numBuckets", value = "60000"),
                        // 该属性用来设置在执行过程中每个 “桶” 中保留的最大执行次数。如果在滚动时间窗内发生超过该设定值的执行次数，
                        // 就从最初的位置开始重写。例如，将该值设置为100, 滚动窗口为10秒，若在10秒内一个 “桶 ”中发生了500次执行，
                        // 那么该 “桶” 中只保留 最后的100次执行的统计。另外，增加该值的大小将会增加内存量的消耗，并增加排序百分位数所需的计算时间。
                        @HystrixProperty(name = "metrics.rollingPercentile.bucketSize", value = "100"),
                        
                        // 该属性用来设置采集影响断路器状态的健康快照（请求的成功、 错误百分比）的间隔等待时间。
                        @HystrixProperty(name = "metrics.healthSnapshot.intervalinMilliseconds", value = "500"),
                        // 是否开启请求缓存
                        @HystrixProperty(name = "requestCache.enabled", value = "true"),
                        // HystrixCommand的执行和事件是否打印日志到 HystrixRequestLog 中
                        @HystrixProperty(name = "requestLog.enabled", value = "true"),
    
                    },
                    threadPoolProperties = {
                        // 该参数用来设置执行命令线程池的核心线程数，该值也就是命令执行的最大并发量
                        @HystrixProperty(name = "coreSize", value = "10"),
                        // 该参数用来设置线程池的最大队列大小。当设置为 -1 时，线程池将使用 SynchronousQueue 实现的队列，否则将使用 LinkedBlockingQueue 实现的队列。
                        @HystrixProperty(name = "maxQueueSize", value = "-1"),
                        // 该参数用来为队列设置拒绝阈值。 通过该参数， 即使队列没有达到最大值也能拒绝请求。
                        // 该参数主要是对 LinkedBlockingQueue 队列的补充,因为 LinkedBlockingQueue 队列不能动态修改它的对象大小，而通过该属性就可以调整拒绝请求的队列大小了。
                        @HystrixProperty(name = "queueSizeRejectionThreshold", value = "5"),
                    }
                   )
    public String doSomething() {
    	...
    }
    ```

    

