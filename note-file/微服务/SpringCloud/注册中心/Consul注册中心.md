## <font color='red'>什么是Consul</font>



####  -- Consul官网 [Consul by HashiCorp](https://www.consul.io/)



- #### 它是一套开源的分布式服务发现和配置管理系统，由go语言开发

- #### 提供了微服务系统中的服务治理、配置中心、控制总线等功能，这些功能中的每一个都可以根据需要单独使用，也可以一起使用来构建全方位的服务网络，consul提供了一种完整的服务网格解决方案。





</br> <hr> </br>





## <font color='red'>安装启动Consul</font>





- ### 在命令行下 开启使用  consul agent -dev

- ### 访问 http://localhost:8500/ 进入consul可视化面板





</br><hr></br>







## <font color='red'>SpringCloud服务提供者集成Consul</font>





- ### 添加依赖

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-consul-discovery</artifactId>
          </dependency>
  ```

- ### 配置application文件

  ```yaml
  spring:
    application:
      name: payment-serve
    cloud:
      consul:
        host: localhost
        port: 8500
  
  ```





</br><hr></br>





## <font color='red'>服务消费者集成Consul</font>



- ### 添加依赖

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-consul-discovery</artifactId>
          </dependency>
  ```

- ### 配置application文件

  ```yaml
  server:
    port: 80
  
  spring:
    application:
      name: order-serve
    cloud:
      consul:
        host: localhost
        port: 8500
        discovery:
          service-name: ${spring.application.name}
  ```

- ### 使用

  ```java
  	@Autowired
      RestTemplate restTemplate;
  
      private static final String PAYMENT_URL = "http://payment-serve";
  
  
      @GetMapping("/{id}")
      public Payment getPaymentById(@PathVariable("id") long id) {
          Payment payment = restTemplate.getForObject(PAYMENT_URL +xxxx, Payment.class);
          return payment;
      }
  ```
  
- ##### 这里和zookeeper使用是一样的





