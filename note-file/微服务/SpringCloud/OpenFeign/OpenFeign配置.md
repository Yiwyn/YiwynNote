## <font color='red'>OpenFeign 超时控制</font>



#### 服务消费者调用服务接收者，默认Feign的客户端值等待<font color='red'>一秒钟</font>，但是服务端的处理可能超过一秒钟，导致了Feign客户端接受不到数据，直接返回报错。



### <font color='orange'>解决方案</font>

#### 	OpenFeign默认支持Ribbon，可以配置Ribbon相关配置进行处理

- #### 在客户端（服务消费者）yml中开启配置

  ```yaml
  ribbon:
    #  连接到服务器读取到可以资源所用的时间
    ReadTimeout: 5000
    #  建立连接所用的时间，适用于网络正常的情况下，两端连接所用的时间
    ConnectTimeout: 5000
  ```

  

</br><hr></br>





## <font color='red'>OpenFeign 日志打印功能</font>



#### <font color='cornflowerblue'>日志级别</font>

- ##### NONE：默认的，不显示任何日志

- ##### BASIC：仅记录请求方法、URL、响应码及执行时间

- ##### HEADERS：除了BASIC中定义的消息之外，还有请求和响应头的头信息

- ##### FULL：除了HEADERS中的信息之外，还有请求和相应的正文和元数据



#### <font color='cornflowerblue'>在客户端（服务消费者）中配置</font>

- ##### 配置日志Bean

  ```java
  package com.yiwyn.config;
  
  import feign.Logger;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  
  @Configuration
  public class FeignConfig {
      @Bean
      Logger.Level feignLoggerLevel() {
          return Logger.Level.FULL;
      }
  }
  ```

- ##### 在yml文件中开启日志

  ```yaml
  logging:
    level:
    	#feign日志以什么级别监控哪个接口
      com.yiwyn.Service.PaymentService: debug
  ```

  

