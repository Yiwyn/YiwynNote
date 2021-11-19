## <font color='red'>config动态刷新</font>



#### config客户端编写相关代码方便获取config服务端中的值

```java
    @Value("${version.info}")
    String value;


    @GetMapping("/value")
    public String getValue() {
        return value;
    }
```



#### 实现动态刷新

- ##### 添加pom坐标

  ```xml
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-actuator</artifactId>
          </dependency>
  ```

- ##### 修改yml暴露接口

  ```yaml
  #暴露监控端点
  management:
    endpoints:
      web:
        exposure:
          include: "*"
  ```

- ##### Controller添加注解<font color='orange'>@RefreshScope</font>

  ```java
  @RestController
  @RefreshScope
  @RequestMapping("/student")
  public class StudentController {
  }
  ```

- ##### 这时候启动项目修改文件会发现config客户端仍然没有自动更新，这需要开发人员<font color='cornflowerblue'>发送post请求</font>来让他更新

  ```shell
  Yiwyn> curl -X POST "http://localhost:8082/actuator/refresh"
  ["config.client.version","version.info"]
  ```

  - ##### 请求返回当前更新内容
