## <font color='red'>启动配置管理</font>



- #### 添加依赖

  ```xml
          <dependency>
              <groupId>com.alibaba.cloud</groupId>
              <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
          </dependency>
  ```

- #### yml文件

  ```yaml
  server:
    port: 3344
  
  spring:
    application:
      name: nacos-config
  
    cloud:
      nacos:
        config:
          server-addr: 192.168.200.41:8848
          file-extension: yaml			//可指定文件类型 仅支持 properties 或 yaml
          group: DEV-GROUP				//可指定分组
        discovery:
          server-addr: 192.168.200.41:8848
  
    profiles:				//运行profiles 不可缺少
      active: dev
  ```



- #### Nacos中dataId字段

  - ##### spring.application.name 是必须要配置的，因为他是构成了Nacos配置管理 <font color='red'>dataId</font> 字段的一部分

  - ##### 完整的dataId字段如下

    ```shell
    ${prefix}-${spring.profiles.active}.${file-extension}
    ```

    - ##### <font color='red'>prefix </font>默认为 <font color='cornflowerblue'>spring.application.name </font>, 也可以通过配置项 <font color='cornflowerblue'>spring.cloud.nacos.config.prefix</font> 来配置

    - ##### <font color='red'>spring.profiles.active</font> 即当前环境对应的profile。当该项为空时，对应连接符 - 也将不存在，<font color='cornflowerblue'>dataId</font>的拼接格式变为 <font color='cornflowerblue'>${prefix}.${file-extension}</font> 

    - ##### <font color='red'>file-extension</font> 为配置文件的数据格式，可以通过配置项目 <font color='cornflowerblue'>spring.cloud.nacos.config.file-extension</font>来配置，目前只支持properties和yaml类型

    - ##### 通过Spring Cloud 原生注解 <font color='orange'>@RefreshScope</font> 来实现配置自动更新





<hr>



## <font color='red'>配置文件配置</font>



- #### 项目启动之前需要先创建配置文件

  - ##### 在nacos管理面板中，<font color='cornflowerblue'>配置管理-配置列表</font>  添加配置项 

  - ##### <font color='red'>DataId </font>：上述 ↑ 组合bootstrap.yml中的信息

  - ##### <font color='red'>Group</font>：上述 ↑ bootstrap.yml 配置文件中已注释

  - ##### <font color='red'>配置内容</font>：yaml文件 或者 properties 文件

- #### <font color='red'>例</font>



| Data Id               | Group     | 归属应用: | 操作                             |
| :-------------------- | :-------- | :-------- | -------------------------------- |
| nacos-config-dev.yaml | DEV-GROUP |           | 详情\|示例代码\|编辑\|删除\|更多 |



##### 此时启动项目，项目会自动获取配置文件，并且在文件中心编辑文件可发布配置信息。