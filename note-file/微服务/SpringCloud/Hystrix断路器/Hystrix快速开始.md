## <font color='red'>Hystrix重要概念</font>





- ### <font color='cornflowerblue'>服务降级 fallabck</font>

  - #### 像调用方返回一个符合预期的、可预处理的备选相应。

  - #### 什么情况下会降级

    - #### 程序运行异常

    - #### 超时

    - #### 服务熔断触发服务降级

    - #### 线程池/信号量打满也会导致服务降级

- ### <font color='cornflowerblue'>服务熔断 break</font>

  - #### 服务器达到最大访问量之后，直接拒绝访问，然后再调用服务降级的方法并返回友好提示

  - #### 服务降级--》服务熔断--》恢复调用链路

- ### <font color='cornflowerblue'>服务限流 flowlimit</font>

  - #### 秒杀高并发等操作，限制流量











