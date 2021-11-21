## <font color='red'>SpringCloud Stream</font>



### 消息驱动解决的问题



#### MQ(消息中间件)

- #### ActiveMQ

- #### RabbitMQ

- #### RocketMQ

- #### Kafka



#### 一个系统存在多个MQ，需要一种新的技术，让开发者不需要关注MQ的细节，只需要一种适配绑定的方式，自动的给我们在各种MQ内切换。  



</br><hr></br>





## <font color='red'>消息驱动概述</font>



- #### 屏蔽底层消息中间件的差异，降低切换成本，统一消息的编程模式

- #### Binder 实现 （绑定器实现）





</br><hr></br>



## <font color='red'>什么是SpringCloudStream</font>



#### 官方定义SpringCloudStream是一个构建消息驱动微服务的架构



#### 应用程序通过<font color='cornflowerblue'>inputs </font>或者 <font color='cornflowerblue'>outputs </font>来与Spring Cloud Stream 中<font color='cornflowerblue'>binder</font>对象交互

#### 通过配置binding(绑定),而SpringCloudStream的binder对象负责详细中间件交互。



#### <font color='red'>目前仅支持 RabbitMQ、kafka</font>



