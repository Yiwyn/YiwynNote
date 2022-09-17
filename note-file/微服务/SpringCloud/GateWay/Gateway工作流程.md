## <font color='red'>Gateway工作流程</font>



- ### 三大核心概念

  - ##### <font color='red'>Route</font>(路由)：路由是构建网关的基本模块，他由<font color='orange'>ID</font>，<font color='orange'>目标URI</font>，一系列的<font color='orange'>断言和过滤器</font>组成，如断言为true则匹配该路由

  - ##### <font color='red'>Predicate</font>(断言)：参考的是java 8 中的java.util.function.Predicate，开发人员可以匹配HTTP请求中的所有内容（例如请求头或者请求参数），如果请求与断言相匹配则进行路由
  
  - ##### <font color='red'>Filter</font>(过滤)：指的是Spring框架中GatewayFilter的实例，使用过滤器，可以在请求被路由前或者之后对请求进行修改





<br>



<hr>





## <font color='red'>创建一个网关服务</font>



- #### POM

  ```xml
  <dependencies>
          <!--gateway-->
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-gateway</artifactId>
          </dependency>
          <!--eureka-client-->
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
          </dependency>
     
      	<!-- ...省略其他jar包-->
  </dependencies>
  ```

- ### <font color='cornflowerblue'>application</font>文件

  ```yaml
  server:
    port: 9527
  
  eureka:
    client:
      service-url:
        register-with-eureka: true
        fetch-registry: true
        defaultZone: http://localhost:7001/eureka
    instance:
      hostname: cloud-gateway-service
  
  spring:
    application:
      name: gateway-server
  ```

- #### 主启动类

  ```java
  @SpringBootApplication
  @EnableEurekaClient
  public class GatewayApplication {
      public static void main(String[] args) {
          SpringApplication.run(GatewayApplication.class, args);
      }
  }
  ```









