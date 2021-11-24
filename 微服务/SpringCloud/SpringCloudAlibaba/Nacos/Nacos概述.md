## <font color='red'>Nacos概述</font>



- #### 名字由来

  - ##### 前四个字母分别为<font color='cornflowerblue'>Naming</font>和<font color='cornflowerblue'>Configuration</font>的前两个字母，最后<font color='cornflowerblue'>s</font>为Service

  

- #### 是什么

  - ##### 一个更易于构建云原生应用的动态服务发现、配置管理、服务管理平台

  - ##### Nacos：Dynamic Naming and Configuration Service 

  - ##### Nacos就是注册中心+配置中心的组成 --》 <font color='red'>Nacos = Eureka + Config + Bus</font>



- #### 作用

  - ##### 替代Eureka做服务注册中心

  - ##### 替代Config做服务配置中心



- #### 下载安装

  - ##### 官网 [Spring Cloud Alibaba Reference Documentation (spring-cloud-alibaba-group.github.io)](https://spring-cloud-alibaba-group.github.io/github-pages/greenwich/spring-cloud-alibaba.html#_spring cloud alibaba nacos_discovery)

  - ##### 快速开始 [Nacos 快速开始](https://nacos.io/zh-cn/docs/quick-start.html) 

  - ##### 下载地址

    - [Releases · alibaba/nacos · GitHub](https://github.com/alibaba/nacos/releases) 



- #### <font color='red'>启动服务器</font>

  ##### Linux/Unix/Mac

  启动命令(standalone代表着单机模式运行，非集群模式):

  ```
  sh startup.sh -m standalone
  ```

  如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：

  ```
  bash startup.sh -m standalone
  ```

  ##### Windows

  启动命令(standalone代表着单机模式运行，非集群模式):

  ```
  startup.cmd -m standalone
  ```

