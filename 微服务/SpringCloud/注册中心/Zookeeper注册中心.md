## <font color='red'>Zookeeper 相关配置</font>



- ##### 相关下载配置见 <font color='cornflowerblue'>微服务/Zookeeper</font>





</br><hr></br>







## <font color='red'>服务提供者项目于引入Zookeeper</font>



- #### 因为代替eureka，所以pom文件中无需再导入eureka相关的包，引入cloud中zookeeper的依赖

  ```xml
  <dependency>
  	<groupId>org.springframework.cloud</groupId>
  	<artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
  </dependency>
  ```



- #### jar包版本冲突处理方法

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
              <exclusions>
                  <exclusion>
                      <groupId>org.apache.zookeeper</groupId>
                      <artifactId>zookeeper</artifactId>
                  </exclusion>
              </exclusions>
          </dependency>
  
          <dependency>
              <groupId>org.apach.zookeeper</groupId>
              <artifactId>zookeeper</artifactId>
              <version>xxxx</version>
          </dependency>
  ```

  



- #### 在配置文件中配置Zookeeper

  ```yaml
  spring:
    application:
      name: payment-serve
    cloud:
      zookeeper:
        connect-string: 192.168.3.214:2181
  ```



- #### 启动类添加注解 <font color='orange'>@EnableDiscoveryClient</font> 







</br><hr></br>





## <font color='red'>服务消费者注册进zookeeper</font>



- #### 导入坐标

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
          </dependency>
  ```

- #### 配置application.yml

  ```yaml
  spring:
    application:
      name: order-serve
    cloud:
      zookeeper:
        connect-string: 192.168.3.214:2181
  ```





- #### 使用

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

  - ##### 一样使用 节点名，restTemplate需要注解<font color='orange'>@LoadBalanced</font> 
