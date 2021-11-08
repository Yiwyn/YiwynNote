## <font color='red'>Hystrix重要概念</font>





- ### <font color='cornflowerblue'>服务降级 fallabck</font>

  - #### 像调用方返回一个符合预期的、可预处理的备选相应。

  - #### 什么情况下会降级

    - #### 程序运行异常

    - #### 超时

    - #### 服务熔断触发服务降级

    - #### 线程池/信号量打满也会导致服务降级

- ### <font color='cornflowerblue'>服务熔断 break</font>

  - #### 服务器达到最大访问量之后，直接拒绝访问，然后再调用服务降级的方法并返回友好提示

  - #### 服务降级--》服务熔断--》恢复调用链路

- ### <font color='cornflowerblue'>服务限流 flowlimit</font>

  - #### 秒杀高并发等操作，限制流量





</br><hr></br>







## <font color='red'>快速开始</font>





- #### 导入pom坐标

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
          </dependency>
  ```

- #### 针对一些接口，使用Hystrix提供的注解进行问题解决

  - ##### Service层

    ```java
        @HystrixCommand(fallbackMethod = "handle")  //Hystrix 注解
        public String errorMethod() {
            int a = 10 / 0;
            return "";
        }
    
        public String handle() {
            return "出现问题了";
        }
    ```

  - ##### 主启动类

    ```java
    @SpringBootApplication
    @EnableEurekaClient
    @EnableCircuitBreaker              //Hystrix需要开启的服务
    public class PaymentHytrixApplication8083 {
    
        public static void main(String[] args) {
            SpringApplication.run(PaymentHytrixApplication8083.class, args);
        }
    }
    ```

- #### 这个时候服务消费调用可能会出现问题的服务提供者就会调用<font color='red'>fallback</font>方法返回



