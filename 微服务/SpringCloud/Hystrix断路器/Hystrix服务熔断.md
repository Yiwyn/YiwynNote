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

