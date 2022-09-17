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

- ##### 为Feign客户端定义的接口添加一个服务降级处理的实现类

- ##### 因为调用服务都是通过<font color='red'>Feign</font>进行的，所以可以使用Feign集成的Hystrix来处理服务降级

- ##### 通过实现<font color='orange'>@FeignClient</font>注解标记的接口

  ```java
  @Component
  public class SchoolHystrixService implements SchoolService {
      @Override
      public Student getStudent(long id) {
          return new Student();
      }
      @Override
      public String getError(int value) {
          return "出现错误";
      }
  }
  
  //SchoolService 接口如下
  
  @Component
  @FeignClient(value = "STUDENT-SERVICE", fallback = SchoolHystrixService.class)
  public interface SchoolService {
  
      @GetMapping("/student/user/{id}")
      public Student getStudent(@PathVariable("id") long id);
  
      @GetMapping("/student/error/{value}")
      public String getError(@PathVariable("value") int value);
  }
  
  ```

- ##### 通过完善<font color='orange'>@FeignClient</font>注解的参数，把service实现对象引入，这样可以对远程调用的服务方法都进行降级处理

- ### <font color='red'>注</font>：这里service接口不可以直接在接口上使用<font color='orange'>@RequestMapping</font> 如：

  ```java
  @Component
  @FeignClient(value = "STUDENT-SERVICE", fallback = SchoolHystrixService.class)
  @RequestMapping("/test")             //这样是不可行的，会报错
  public interface SchoolService {
   //....
  }
  ```

- ##### <font color='cornflowerblue'>application</font>文件

  ```yaml
  feign:
    hystrix:
      enabled: true
  ```

  - ##### <font color='red'>打开feign的hystrix功能</font>

- #### 此时，访问服务消费者调用的其他服务的接口都会有服务降级

