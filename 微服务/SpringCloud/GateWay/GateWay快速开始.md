## <font color='red'>Gateway快速开始</font>





- ### <font color='red'>什么是Gateway</font>

  

  - #### Gateway是在Spring生态系统上构建的<font color='red'>API网关服务</font>，基于Spring 5，Spring Boot 2和 Project Reactor 等技术。

  - #### Gateway旨在提供一种简单有效的方式来对API进行路由，以及提供一些强大的<font color='red'>过滤器</font>功能，例如：<font color='red'>熔断</font>、<font color='red'>限流</font>、<font color='red'>重试</font>等。

  - #### Spring Cloud Gateway是基于<font color='cornflowerblue'>WebFlux</font>框架，而WebFlux框架底层使用了高性能的Reactor模式通信框架<font color='cornflowerblue'>Netty</font> 





- ### <font color='red'>作用</font>

  - #### 方向代理

  - #### 鉴权

  - #### 流量控制

  - #### 熔断

  - #### 日志监控



- ### <font color='red'>微服务框架中网关的位置</font>

  

![img](https://img-blog.csdnimg.cn/img_convert/5877d4b9035ead9cd2d037609dceb442.png)







- ### <font color='red'>Getway非阻塞异步模型，Gateway的优势</font>

  - #### 基于Spring Framework 5，Project Reactor和Spring Boot2.0 进行构建

  - #### <font color='red'>动态</font>路由：能后匹配任何请求属性

  - #### 可以对路由指定<font color='red'>Predicate</font>（断言）和<font color='red'>Filter</font>（过滤器）

  - #### 集成Hystrix的<font color='red'>断路器</font>功能

  - #### 集成Spring Cloud <font color='red'>服务发现</font>功能

  - #### <font color='red'>易于编写</font>的Predicate（断言）和Filter（过滤器）

  - #### 请求<font color='red'>限流</font>功能

  - #### 支持<font color='red'>路径重写</font> 









