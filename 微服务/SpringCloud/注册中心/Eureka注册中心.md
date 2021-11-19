## <font color='red'>Eureka 注册中心</font>



- ### 服务调用出现的问题

  - #### 服务消费者如何获取服务提供者的地址信息

  - #### 多个服务提供者，消费者如何选择

  - #### 消费者怎样获取服务者的健康状态







- ### Eureka 的作用步骤

  - #### eureka-serve 注册中心将会记录服务提供者的信息。

  - #### 服务消费者在eureka-serve中获取需要的服务提供者信息。

  - #### 服务消费者得到服务提供者的信息发送请求

    - ##### 服务提供者每隔30秒向Eureka-serve发送一次心跳，确认自己的状态，若心跳停止，则eureka-serve将会把心跳停止的服务移出注册中心。<font color='red'>这样确保了服务消费者得到的服务提供者是有效的</font>







- ### 搭建Eureka注册中心

  - #### eureka需要单独一个Springboot服务

  - #### 引入 eureka-server 依赖 

    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    ```
    
  - #### 需要在启动类添加注解 <font color='red'>@EnableEurekaServer</font> 
  
  - #### 配置文件application.yum
  
  ```yaml
    server:
      port: 5597
    spring:
      application:
        name: eurekaserver  #eureka 的服务名称
    eureka:
      client:
        service-url:		#eureka的地址信息
          defaultZone: http://127.0.0.1:5597/eureka
    
  ```
  
  
  
  - #### 因为eureka本身也是微服务，所以需要开始的时候要把自己注册进去





- ### 服务提供者改造

  - #### 引入 eureka-client 依赖

    ```xml
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
    ```

  - #### 配置application.xml

    ```yaml
    spring:
      application:
        name: payment-serve
    
    
    eureka:
      client:
      //注册进入eureka
        register-with-eureka: true
        fetch-registry: true
        service-url:
          defaultZone: http://localhost:7001/eureka
    ```

  - #### 指定application.name 很重要，这个是注册进入eureka之后的名字

  - #### 启动类添加注解<font color='red'>@EnableEurekaClient</font> 







</br><hr></br>





## <font color='red'>集群Eureka搭建</font>





- #### ？ 微服务RPC远程服务调用最核心的是什么
  - ##### 		<font color='red'>高可用</font>

  - ##### 解决方案：

    - ##### 搭建Eureka注册中心集群，实现负载均衡+故障容错

    - ##### 互相注册，相互守望

- #### 配置application.yml

  ```yaml
  server:
    port: 7001
  eureka:
    instance:
      hostname: xxxx
    client:
      register-with-eureka: false
      service-url:
        defaultZone: http://xxx.xxx.xxx.xxx:7002/eureka/
  
  ```

  - ##### 相互注册，所以 7001注册到端口7002的eureka







</br><hr></br>







## <font color='red'>Eureka服务的使用</font>





- #### 使用restTemplate不能将地址写死，这里直接注入 eureka中注册的服务提供者

  ```java
  //使用服务
  private static final String PAYMENT_URL = "http://PAYMENT-SERVE";
  
  //restTemplate访问请求
  restTemplate.getForObject(PAYMENT_URL, xxxx.class);
  
  ```

- #### 开启负载均衡

  - ##### 在配置restTemplate的时候添加注解<font color='red'>@LoadBalanced</font>

    ```java
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    ```

- #### 访问成功





</br><hr></br>





## <font color='red'>actuator微服务信完善</font>





- #### 配置eureka中服务的名称和显示ip

  - #### 修改服务的application.yml

    ```yaml
    eureka:
      client:
    	....
      instance:
        instance-id: payment8081
        prefer-ip-address: true
    ```

    



</br><hr></br>





## <font color='red'>使用DiscoveryClient</font>



- ```java
  import org.springframework.cloud.client.discovery.DiscoveryClient; //导入对象
  
  @Resource
  private DiscoveryClient discoveryClient;  //引入bean对象
  
  
  //使用
  
  //获取当前eureka中的服务列表
  List<String> services = discoveryClient.getServices();   
  
  //获取某个服务里面的所有实例对象
   List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVE");
  
  ```

- ##### 后期使用较多





</br><hr></br>







## <font color='red'>Eureka自我保护</font>





#### ？当我们进入Eureka后台看到红色的

#### <font color='red'>EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE</font> <font color='red'>LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.</font>

#### 则表示进入了保护模式





- ####  为什么会产生自我保护机制

  - ##### 为了防止EurekaClient可以正常运行，但是与EurekaServer网络不同情况下，EurekaServer<font color='red'>不会立刻</font>将EurekaClient服务剔除

- #### 什么是自我保护模式

  - ##### 默认情况下，如果EurekaServer在一定时间没有接收到某个服务实例的心跳，EurekaServer将会注销该实例（90s），但是当网络分区发生故障时（延时、卡顿、拥挤）时，微服务与EurekaServer之间无法正常通信，以上行为可能变得非常危险，因为微服务本身是健康的，这个时候不应该剔除该服务。Eureka通过“自我保护模式”来解决这个问题。

  - ##### 当EurekaServer节点在短时间内丢失过多客户端时，那么这个节点就会进入自我保护模式



- #### 关闭自我保护

  - ##### eurekaServer服务的application.yaml修改

    ```yaml
    eureka:
      server:
    #    关闭自我保护
        enable-self-preservation: false
    #    等待时间
        eviction-interval-timer-in-ms: 2000
    ```

    
