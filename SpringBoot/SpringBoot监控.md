### SpringBoot监控概述

##### SpringBoot自带监控功能的<font color='red'>Actuator</font> ,可以帮助实现对程序内部运行情况监控,比如<font color='cornflowerblue'>监控状况,bean加载情况,配置属性,日志信息等</font>



### <font color='red'>使用步骤</font>

- ##### 导入依赖坐标

  - ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    ```

- ##### 访问http://localhost:8080/actuator

- ##### 获取上一条访问获得的json数据,解析发现几处url,分别可以查看SpringBoot的状态信息

- ##### 查看详细信息,在<font color='red'>application.properties</font>中配置

  - ```properties
    #开启健康检查的完整信息
    management.endpoint.health.show-details=always
    ```

  - ##### 配置后进入/actuator/healthy可以查看项目的健康情况

- ##### 将所有的<font color='red'>监控endpoint</font>暴露出来

  - ```properties
    #将所有的监控暴露出来
    management.endpoints.web.exposure.include=*
    ```



#### <font color='red'>常用监控endpoint说明</font>

-  **"beans"**:{
        **"href"**:**"http://localhost:8080/actuator/beans"**,
        **"templated"**:**false**
      }

  - ##### 可以查看项目创建的bean的描述

-   **"mappings"**:{
        **"href"**:**"http://localhost:8080/actuator/mappings"**,
        **"templated"**:**false**
      }

  - ##### 可以查看暴露出的url映射地址





### Spring Boot Admin

- ##### 开源项目,用于管理和监控SpringBoot应用程序

- ##### 两个角色,客户端(Client)和服务端(Server)

- ##### 应用程序作为Spring Boot Admin Client 向为 Spring Boot Admin Server 注册

- ##### Spring Boot Admin Server 的UI界面展示Actuator Endpoint的监控信息









