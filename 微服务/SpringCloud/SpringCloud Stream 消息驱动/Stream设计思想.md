## <font color='red'>设计思想</font>





- ### 标准MQ

  - #### 生产者/消费者直接靠<font color='red'>消息</font>媒介传递消息内容  --》 Message

  - #### 消息必须走特定的<font color='red'>通道</font>  --》  MessageChannel

  - #### 消息通道里的消息如何被消费呢，谁负责收发<font color='red'>处理</font>  -- 》消息通道MessageChannel，由MessageHandle消息处理器所订阅

- ### SpringCloudStream中消息通信方式遵循了发布-订阅模式

  - #### Topic主题进行广播

    - ##### 在RabbitMQ就是Exchange

    - ##### 在kafka中就是Topic

