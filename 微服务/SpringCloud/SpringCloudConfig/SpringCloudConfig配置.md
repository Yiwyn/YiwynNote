## <font color='red'>配置Spring Cloud Config 服务端</font>



- ### <font color='cornflowerblue'>pom</font>文件

  ```xml
      <dependencies>
  
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-config-server</artifactId>
          </dependency>
  
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
          
      </dependencies>
  ```

- ### <font color='cornflowerblue'>application</font>文件

  ```yaml
  server:
    port: 3344
  eureka:
    client:
      service-url:
        defaultZone: http://localhost:7001/eureka
  
  
  spring:
    application:
      name: config-center
    cloud:
      config:
        server:
          git:
            uri: https://gitee.com/yiwyn/spring-cloud-config-test.git   //存储配置信息的git仓库
            search-paths:												  //这个仓库的路径
              - spring-cloud-config-test
  
        label: master													  //寻找仓库的标签
  ```

- #### 启动类

  ```java
  @EnableEurekaClient
  @SpringBootApplication
  @EnableConfigServer
  public class ConfigApplication {
      public static void main(String[] args) {
          SpringApplication.run(ConfigApplication.class, args);
      }
  }
  ```











## <font color='red'>git仓库文件的要求</font>



#### git仓库文件格式，默认读取规则

```tex
**格式一 
/{label}/{application}-{profile}.yml

http://localhost:3344/master/config-dev.yml
http://localhost:3344/dev/config-dev.yml

**格式二
/{application}-{profile}.yml
http://localhost:3344/config-dev.yml
默认读取spring-cloud-config中的application.yml配置的label

**格式三
/{application}-{profile}/{label}、

http://localhost:3344/config-dev/master
读取到的是json文件
```

- ##### label：分支(branch)

- ##### name：服务名

- ##### profile：环境(dev/test/prod)











## <font color='red'>配置Spring Cloud Config 客户端</font>



#### 新的配置文件 bootstrap.yml 

- #### application.yml属于用户级的资源配置项

- ####  bootstrap.yml是系统级的，<font color='red'>优先级</font>更高



### <font color='cornflowerblue'>pom</font>文件

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-client</artifactId>
        </dependency>
```

- ##### 给需要的微服务添加config-client



#### <font color='cornflowerblue'>bootstrap.yml</font>

```yaml
server:
  port: 8082
spring:
  application:
    name: student-service
  cloud:
    config:
      label: master					//连接配置中心的标签
      name: config					//配置中心（仓库）文件的名字
      profile: dev  				//配置中心（仓库）profile（dev/prod/test）
      uri: http://localhost:3344	//配置中心服务地址

eureka:
  client:
    service-url:
      defaultZone: http://localhost:7001/eureka

mybatis:
  mapper-locations: classpath:mapper/*.xml
```

- ##### git仓库文件示例 

  ```file
  config-dev.yml
  ```



<hr>



- ##### 当驱动服务的时候，系统会先配置bootstrap文件，<font color='red'>bootstrap</font>文件的配置信息来自 config-server中查找到的git仓库中的<font color='red'>mater </font>label <font color='red'>config</font>-<font color='red'>dev</font>文件

