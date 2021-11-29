## <font color='red'>Nacos集群部署</font>





#### 集群部署架构



- ##### http://ip1:port/openAPI 直连模式，机器挂则需要修改ip才可以使用

- ##### http://SLB:port/openAPI 挂载SLB模式(内网SLB，不可暴露在公网，以免带来安全风险)，直连SLB即可，下面挂server真实ip，可读性不好。

- ##### http://nacos.com:port/openAPI 域名+SLB模式(内网SLB，不可暴露到公网，以免带来安全风险)，可读性好，而且换ip方便，<font color='red'>推荐使用</font>

  ![deployDnsVipMode.jpg](https://nacos.io/img/deployDnsVipMode.jpg)



## <font color='red'>部署</font>



- #### 在conf文件夹中修改创建文件

  - ##### 配置文件<font color='cornflowerblue'>cluster.conf</font> 

    ```conf
    # ip:port
    200.8.9.16:8848
    200.8.9.17:8848
    200.8.9.18:8848
    ```

    - ##### 这里配置集群的端口号 ，本地<font color='red'>不要</font>使用localhost或者127.0.0.1 会出现问题 节点会<font color='red'>down</font> 

  - ##### 配置文件<font color='cornflowerblue'>application.properties</font> 

    - ##### 解除注释并修改参数

    ```properties
    ### If use MySQL as datasource:
    spring.datasource.platform=mysql
    
    ### Count of DB:
    db.num=1
    
    ### Connect URL of DB:
    db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
    db.user.0=root
    db.password.0=root
    ```

- #### 单机模式启动一次，引入数据库

  ```shell
  ./startup.sh -m standlone
  ```

- #### 集群启动

  ```shell
  ./startup.sh
  ```



- #### 启动完成可以在控制面板中 <font color='cornflowerblue'>集群管理- 节点信息</font> 查看



