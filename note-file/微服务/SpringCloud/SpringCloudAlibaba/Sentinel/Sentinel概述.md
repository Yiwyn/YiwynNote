## <font color='red'>Sentinel概述</font>



> #### [introduction (sentinelguard.io)](https://sentinelguard.io/zh-cn/docs/introduction.html)



- #### Sentinel是面向分布式服务架构的流量控制组件，主要以流量为切入点，从流量控制、熔断降级、系统自适应保护等多个维度保障微服务稳定性。

  

  

### <font color='orange'>Sentinel 基本概念</font>

- #### <font color='cornflowerblue'>资源</font>：资源是Sentinel的关键概念。它可以是java应用程序中的任意内容，例如，由应用程序提供的服务，或由应用程序d调用的其他应用提供的服务，甚至可能是一段代码。   只要通过Sentinel API定义的代码，就是资源，能够被Sentinel保护起来。

- #### <font color='cornflowerblue'>规则</font>：围绕资源的实时状态设定的规则，可以包括流量控制规则、熔断降级规则以及系统保护规则。所有的规则可以动态实时调整。









​			

