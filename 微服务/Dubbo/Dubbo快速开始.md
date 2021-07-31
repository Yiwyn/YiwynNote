## <font color='red'>快速开始</font>





- #### <font color='cornflowerblue'>Zookeeper安装</font>

  - ##### zookeeper 是 Apache Hadoop的子项目,是一个树形的目录服务.... 适合作为Dubbo的<font color='red'>注册中心</font>

  - ##### zookeeper的安卓使用详细在<font color='fuchsia'>Note</font>中的<font color='red'>Zookeeper</font>专栏,此处不多做赘述

<hr>


- #### 分离创建两个<font color='cornflowerblue'>modul </font>创建service 和 web 分离实现springmvc功能模拟环境

  - ##### 使用SSM部分的知识点.可在<font color='fuchsia'>SSM</font>文件夹查看详细知识点



<hr>

- #### <font color='cornflowerblue'>pom</font>文件导入 <font color='cornflowerblue'>dubbo </font><font color='cornflowerblue'>zookeeper </font>包坐标

  - ```xml
     		<dependency>
                <groupId>org.apache.dubbo</groupId>
                <artifactId>dubbo</artifactId>
                <version>2.7.4.1</version>
            </dependency>
    
            <dependency>
                <groupId>org.apache.curator</groupId>
                <artifactId>curator-framework</artifactId>
                <version>4.0.0</version>
            </dependency>
    
            <dependency>
                <groupId>org.apache.curator</groupId>
                <artifactId>curator-recipes</artifactId>
                <version>4.0.0</version>
            </dependency>
    ```



<hr>

- #### 使用<font color='cornflowerblue'>Dubbo</font>技术改造项目 ----service

  - ##### 原本项目的<font color='cornflowerblue'>spring</font>的<font color='orange'>@Service</font> 替换成为 <font color='cornflowerblue'>dubbo</font> 的<font color='orange'>@Service</font> 把这个类提供的服务(方法)对外发布.

  - ##### 将访问的ip,端口,路径 注册到 <font color='cornflowerblue'>注册中心</font> 



<hr>

- #### 配置Dubbo ----service

  - ##### 在spring配置文件<font color='cornflowerblue'>applicationContext.xml</font>中配置Dubbo

  - ```xml
      <!--dubbo配置-->
        <!--    1.配置项目的名称,名字唯一,一般和项目名一样-->
        <dubbo:application name="dubbo-service"/>
        <!--    2.配置注册中心的地址-->
        <dubbo:registry address="zookeeper://192.168.3.115:2181"/>
        <!--    3.配置bubbo的包扫描-->
        <dubbo:annotation package="com.yiwyn.service"/>
    ```

  - ##### 其中,第2步配置注册中心,在windows或者linux中启动zookeeper后,<font color='red'>linux</font>要开放<font color='red'>2181端口</font>,否则连接失败

- ### <font color='red'>这里的本质是将service作为一个dubbo中的服务者,下一步让web作为消费者</font>



<hr>



- ### 配置dubbo ---web  <font color='cornflowerblue'>(用web来模拟一个消费者使用服务者提供的服务)</font>

  - ##### 去除<font color='cornflowerblue'>pom</font>文件中对本地文件的引用

    - ###### 去除本地引用后IDE 会报错这个时候可以

  - ##### 添加dubbo的依赖,同上<font color='red'>service</font>部分

  - ##### 原本的本地注解<font color='orange'>@Autowired</font> 取消,因为使用了dubbo,本地注解无效

  - ##### 使用远程注入注释<font color='orange'>@Reference</font> 

    - ```java
      //    @Autowired
          @Reference
          UserService userService;
      ```

    - ##### Reference的作用

      - ###### 从zookeeper注册中心获取userService的访问url

      - ###### 进行远程调用<font color='red'>RPC</font>

      - ###### 将结果封装为一个代理对象.给变量赋值

  - ##### 项目启动,系统将自动调用dubbo来协同工作





