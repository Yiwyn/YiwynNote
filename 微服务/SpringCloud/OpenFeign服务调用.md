## <font color='red'>OpenFeign</font>



</br><hr></br>



##### Feign对java Http客户端进行进一步封装，只需要创建一个接口并使用注解来配置他，即可完成服务的绑定。简化了Spring cloud Ribbon的使用。

##### <font color='cornflowerblue'>同时Feign集成了Ribbon</font>



- #### <font color='cornflowerblue'>pom</font>添加feign坐标

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
          </dependency>
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-openfeign</artifactId>
          </dependency>
  ```

- #### 配置application

  ```yaml
  server:
    port: 80
  
  eureka:
    client:
      register-with-eureka: false
      service-url:
        defaultZone: http://localhost:7001/eureka
  ```

  

- #### 主启动类注解激活

  ```java
  @EnableFeignClients
  ```

- #### 添加Service接口并添加<font color='red'>@FeignClient</font>注解调用服务提供者

  ```java
  @Component
  @FeignClient("PAYMENT-SERVE")
  ```

  - ##### 注解参数填写需要使用的服务提供者

- #### 编写service层调用服务提供者暴漏的接口

  ```java
  public interface PaymentService {
  
      @GetMapping("/payment/{id}")			//这里是服务提供者暴漏的接口
      public Payment getById(@PathVariable("id") long id);
  }
  ```

- #### 编写Controller 层创建消费者自己的接口并使用service

  ```java
  @RestController
  @RequestMapping("/order")
  public class OrderController {
      @Resource
      PaymentService paymentService;
  
      @GetMapping("/{id}")
      public Payment getById(@PathVariable("id") long id) {
          return paymentService.getById(id);
      }
  }
  ```

  









