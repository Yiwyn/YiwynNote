## <font color='red'>服务提供者创建</font>



> ###### [Nacos Spring Cloud 快速开始](https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html) 





- #### <font color='cornflowerblue'>yml文件</font>

  ```yaml
  server:
    port: 8084
  spring:
    application:
      name: nacos-student-server		//服务名字
    cloud:
      nacos:
        discovery:
          server-addr: 192.168.200.41:8848  //服务注册地址
  ```

- #### <font color='cornflowerblue'>pom文件</font>

  ```xml
      <dependencies>
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
  
          <dependency>
              <groupId>com.alibaba.cloud</groupId>
              <artifactId>spring-cloud-alibaba-nacos-discovery</artifactId>
          </dependency>
      </dependencies>
  ```

- #### <font color='cornflowerblue'>启动类</font>

  ```java
  @SpringBootApplication
  @EnableDiscoveryClient
  public class NacosStudentApplication8084 {
      public static void main(String[] args) {
          SpringApplication.run(NacosStudentApplication8084.class, args);
      }
  }
  ```





<hr>







## <font color='red'>服务消费者创建</font>



- #### <font color='cornflowerblue'>yml文件</font>

  ```yaml
  server:
    port: 81
  
  spring:
    application:
      name: nacos-school-service
    cloud:
      nacos:
        discovery:
          server-addr: 192.168.200.41:8848
  
  
  service-url:
    nacos-student-service: http://nacos-student-server
  
  ```

- #### <font color='cornflowerblue'>pom文件</font>

  ```xml
          <dependency>
              <groupId>com.alibaba.cloud</groupId>
              <artifactId>spring-cloud-alibaba-nacos-discovery</artifactId>
          </dependency>
  ```

- #### <font color='cornflowerblue'>主启动类</font>

  ```java
  @SpringBootApplication
  public class NacosSchoolApplication81 {
      public static void main(String[] args) {
          SpringApplication.run(NacosSchoolApplication81.class, args);
      }
  
      @Bean
      @LoadBalanced					//http请求，负载均衡，之前文章已经详细写过该类
      RestTemplate restTemplate() {  							
          return new RestTemplate();
      }
  }
  ```

- #### <font color='cornflowerblue'>Controller</font>

  ```java
  @RestController
  @RequestMapping("/school")
  public class SchoolController {
  
      @Value("${service-url.nacos-student-service}")
      private String student_service;
  
      @Resource
      private RestTemplate restTemplate;
  
      @GetMapping("/{id}")
      public Student getStudent(@PathVariable("id") int id) {
          Student student = restTemplate.getForObject(student_service + "/student/" + id, Student.class);
          if (student == null) {
              return null;
          }
          return student;
      }
  }
  
  ```





<hr>



- ## <font color='red'>注</font>

  - #### 在不参与 <font color='orange'>-</font> 运算的地方分割符 使用 <font color='red'>-</font> ，在有四则运算的地方 分隔符使用 <font color='red'>_</font> 

  - #### RestTemplate不识别<font color='red'>_</font>分割的字段



