## <font color='red'>Sentinel 快速开始</font>

> #### Sentinel 与SpringCloud的整合[Sentinel · alibaba/spring-cloud-alibaba Wiki · GitHub](https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel)

#### Sentinel 的使用可以分为两个部分

- ##### <font color='red'>核心库</font>（Java客户端）：不依赖任何框架/库，能狗运行java 8 及以上的版本的运行环境，同时对Dubbo/Spring Cloud 等框架也有较好的支持。

- ##### <font color='red'>控制台</font>（Dashboard）：Dashboard 主要负责管理推送规则、监控、管理机器信息等。





- #### <font color='cornflowerblue'>pom</font>文件

  ```xml
  	<!-- Sentinel 包 -->
  		<dependency>
              <groupId>com.alibaba.cloud</groupId>
              <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
          </dependency>
  
  	<!-- webflux 用于支持dashboard -->
          <dependency>
              <groupId>com.alibaba.cloud</groupId>
              <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
          </dependency>
  ```

- #### <font color='cornflowerblue'>yml</font>文件

  ```yaml
  spring:
    application:
      name: nacos-student-server
    cloud:
      sentinel:					
        transport:
          port: 8719
          dashboard: 192.168.201.36:8080  //启用dashboard的地址,这里的结尾一定不可以加上/
  ```

  ##### 这里 <font color='cornflowerblue'>spring.cloud.sentienl.transport.port</font> 端口配置会在应用对应的机器上启动一个Http Server规则，该Server 会与 Sentinel 控制台做交互。比如 Sentinel 控制台添加了一个限流规则，会把规则数据push给这个Http Server 接收，Http Server 再将规则注册到Sentinel 中

  ##### <font color='red'>dashboard </font> ：sentinel控制台

  > ##### 	控制台下载地址 [Releases · alibaba/Sentinel · GitHub](https://github.com/alibaba/Sentinel/releases)

  ##### 	启动控制台

  ```shell
  java -Dserver.port=8080 -jar sentinel-dashboard.jar
  ```

  ##### 默认为8080端口，如果8080端口冲突，可以自己定义端口进行设置



- #### <font color='cornflowerblue'>controller</font>文件

  ```java
      @SentinelResource(value = "errorTest", fallback = "errorHandle")
      @GetMapping("/error/{num}")
      public String getError(@PathVariable("num") int num) {
          return 10 / num + "";
      }
  
      public String errorHandle(int num) {
          return "出现了错误，不能除以" + num;
      }
  ```

  - ##### <font color='orange'>@SentinelResource</font> 注释用来标识资源是否被限流、降级。

    - ##### <font color='orange'>@SentinelResource</font> 提供了额外的属性 <font color='cornflowerblue'>blockHandle,blockHandlerClass,fallback</font>用来表示限流或降级的操作。若不配置 blockHandle、fallback 等函数，则被流控降级时方法会直接抛出对应的BlockException；若方法未定义throw BlockException 则会被 JVM 包装一层 UnderClaredthrowableException

    - ##### 注解详细使用[注解支持 · alibaba/Sentinel Wiki · GitHub](https://github.com/alibaba/Sentinel/wiki/注解支持)

      - ##### 回调函数需要签名一致

        - ##### 返回值类型和原函数返回值类型一致

        - ##### 方法参数列表和原函数一致，或者可以额外多一个 Throwable 类型的参数用于接收对应的异常

        - #### <font color='red'>具体使用看上述链接注解支持</font>





- #### 启动dashboard面板

  - ```url
    http://192.168.201.36:8080//
    ```

    - ##### 账号密码默认 <font color='cornflowerblue'>sentinel</font> 



