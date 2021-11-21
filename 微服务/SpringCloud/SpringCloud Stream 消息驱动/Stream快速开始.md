## <font color='red'>Stream快速开始</font>



### <font color='orange'>服务提供者创建</font>



- #### Pom文件

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
          </dependency>
  ```

- #### yml文件配置

  ```yaml
  spring: 
    cloud: 
    	stream:
        binders: # 在此处配置要绑定的rabbitmq的服务信息；
          defaultRabbit: # 表示定义的名称，用于于binding整合
            type: rabbit # 消息组件类型
            environment: # 设置rabbitmq的相关的环境配置
              spring:
                rabbitmq:
                  host: localhost
                  port: 5672
                  username: guest
                  password: guest
        bindings: # 服务的整合处理
          output: # 这个名字是一个通道的名称
            destination: studyExchange # 表示要使用的Exchange名称定义
            content-type: application/json # 设置消息类型，本次为json，文本则设置“text/plain”
            binder: defaultRabbit # 设置要绑定的消息服务的具体设置
  ```

- #### 创建消息提供者接口

  ```java
  public interface IMessageProvider {
      public String send();
  }
  ```

- #### 实现类

  ```java
  import org.springframework.cloud.stream.annotation.EnableBinding;
  import org.springframework.cloud.stream.messaging.Source;
  import org.springframework.integration.support.MessageBuilder;
  import org.springframework.messaging.MessageChannel;
  import javax.annotation.Resource;
  import java.util.UUID;
  
  @EnableBinding(Source.class)   //定义消息的推送管道
  @Component
  public class MessageProviderImpl implements IMessageProvider {
  
      @Resource
      MessageChannel output;  //消息发送管道
  
      @Override
      public String send() {
          String message = UUID.randomUUID().toString();
          output.send(MessageBuilder.withPayload(message).build());
          System.out.println("消息发送:" + message);
          return message;
      }
  }
  
  ```

- #### Controller

  ```java
    @Resource
    MessageProviderImpl messageProvider;
    
   	@GetMapping("/send")
      public String send() {
          return messageProvider.send();
      }
  ```





</br><hr></br>





### <font color='orange'>服务消费者创建</font>



- #### pom文件

  ```xml
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
          </dependency>
  ```

- #### Controller

  ```java
  @RestController
  @EnableBinding(Sink.class)
  public class ConfigController {
  
      @StreamListener(Sink.INPUT)
      public void inut(Message<String> message) {
          System.out.println("获取到的消息：" + message.getPayload());
      }
  }
  
  ```

- #### yml文件

  ```yaml
  spring:
    cloud:
      stream:
        binders:
          defaultRabbit: # 表示定义的名称，用于于binding整合
            type: rabbit # 消息组件类型
            environment: # 设置rabbitmq的相关的环境配置
              spring:
                rabbitmq:
                  host: localhost
                  port: 5672
                  username: guest
                  password: guest
        bindings: # 服务的整合处理
          input: # 这个名字是一个通道的名称
            destination: studyExchange # 表示要使用的Exchange名称定义
            content-type: application/json # 设置消息类型，本次为对象json，如果是文本则设置“text/plain”
            binder: defaultRabbit # 设置要绑定的消息服务的具体设置
  ```

  - ##### 这里和服务提供者的区别在于<font color='cornflowerblue'>bindings</font> 下通道位input



</br><hr></br>



#### <font color='orange'>配置完成</font>



- #### 当服务提供者发送消息时，服务消费者会自动获取到发送的值

- #### 来自<font color='cornflowerblue'>destination: studyExchange</font> 定义的交互组件