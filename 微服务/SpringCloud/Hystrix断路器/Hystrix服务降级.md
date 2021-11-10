## <font color='red'>快速开始</font>





- ### <font color = "Origan">在服务提供者中使用 </font>

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





<hr>





- ### <font color="Origan">在消费者中使用</font>

- #### 导入pom坐标

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
          </dependency>
  ```

- #### 在启动类上添加注释

  ```java
  @SpringBootApplication
  @EnableFeignClients
  @EnableHystrix  //关键注释
  public class SchoolFeignHystrixApplication {
      public static void main(String[] args) {
          SpringApplication.run(SchoolFeignHystrixApplication.class, args);
      }
  }
  ```

- #### 在application中配置

  ```yaml
  feign:
    hystrix:
      enabled: true
  ```

- #### 可以直接在controller层进行服务处理（controller方便写处理方法）

  - ##### 和在服务提供者中使用一致

  ```java
  //和在服务提供者中使用类似
      @GetMapping("/error")
      @HystrixCommand(defaultFallback = "errorHandle")
      public String getError() {
          return service.getError();
      }
  ```

- #### 这样服务在使用的时候当出现错误的时候，服务降级会在消费者处进行处理



<br>

<hr>

<br>





- ### <font color="origan">全局服务降级</font>

- #### 问题：为每一个方法提供一个降级的方法，代码膨胀

- #### 解决方法：除了个别的重要核心业务有专属的降级服务方法，其它普通的可以通过@DefaultProperties(defaultFallback = “”)进行统一的处理。

- #### 在controller层配置

  ```java
  @DefaultProperties(defaultFallback = "errorHandle")
  public class SchoolController {
   	
   	//.....
   
      @GetMapping("/error")
      @HystrixCommand
      public String getError() {
          return service.getError();
      }
      
      public String errorHandle() {
          return "消费者 Handle，出现了问题";
      }
  }
  ```

  - ##### 这样error方法在使用 @HystrixCommand 注解后，无需指定fallback方法，将自动使用默认属性注解的方法进行降级

- #### 主启动类和yml配置同上



<br>

<hr>

<br>





- ### <font color="origan">全局服务降级</font>

- #### 为Feign客户端定义的接口添加一个服务降级处理的实现类

- //这里存在问题