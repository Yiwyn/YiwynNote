# SpringBoot整合Druid数据源



###### SpringBoot原生的数据源是<font color='red'>HikariPool</font> 当时有些时候我们需要自己配置数据源



### <font color='red'>步骤</font>

- ##### 导图druid的坐标

  - ```xml
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.10</version>
    </dependency>
    ```

- ##### 创建自己的数据源配置类

  - ```yaml
    @Configuration
    public class MyDataSourceConfig {
    
        //自己定义了dataSource之后，springboot提供的数据源就不再工作了
        @ConfigurationProperties(prefix = "spring.datasource")  //调用了application.yaml中已经写好的的属性
        @Bean
        public DataSource dataSource() {
    
            DruidDataSource dataSource = new DruidDataSource();
            return dataSource;
        }
    }
    ```

  - ##### 这样,数据源就替换为了<font color='red'>Druid</font> 





### <font color='red'>Druid官方也推出了Starter的整合方式</font>

- ##### 导入坐标

  - ```xml
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.1.24</version>
    </dependency>
    ```

  - ##### 开启druid监视功能

  - ```yaml
    spring:
      datasource:
        username: root
        password: root
        url: jdbc:mysql://localhost:3306/test
        driver-class-name: com.mysql.cj.jdbc.Driver
        //这里开始druid操作
        druid:
          stat-view-servlet:
            enabled: true
    ```

- ###### 详细细节参考<font color='cornflowerblue'>druid</font>开源地址 

  - [druid/README.md at master · alibaba/druid (github.com)](https://github.com/alibaba/druid/blob/master/druid-spring-boot-starter/README.md)

