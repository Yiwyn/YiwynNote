# SQL

- ## 数据源的配置

  - ### 导入坐标

    - ```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jdbc</artifactId>
      </dependency>
      ```

  - #### 导图数据连接驱动

    - ##### springboot提供了数据源，当时不知道用户使用什么数据库，所以数据库连接驱动需要自己导入

    - ```xml
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
      </dependency>
      ```

    - ##### <font color='red'>这个时候导入mysql驱动的包是由jdbc决定的，因为使用我们自己设备的原因，差距太多的版本会出现问题，所以我们需要自己修改mysql驱动包的版本</font>

      - ##### 解决方案一：直接在导入坐标的时候插入版本

        - ```xml
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
                <version>5.1.32</version>
          </dependency>
          ```

      - ##### 解决方案二：在<font color='cornflowerblue'>pom.xml</font> 文件的<font color='orange'>properties</font>标签内加上版本属性(maven的属性优先原则)

        - ```xml
          <properties>
              <java.version>11</java.version>
              <mysql.version>5.1.32</mysql.version>
          </properties>
          ```

  - #### 配置文件

    - ```yaml
      //在aplicaiton.yaml中配置
      
      spring:
        datasource:
          username: root
          password: root
          url: jdbc:mysql://localhost:3306/test
          driver-class-name: com.mysql.cj.jdbc.Driver
      ```

    

    

  - #### 使用

    - ```java
      @Autowired
      JdbcTemplate jdbcTemplate;
      ```

  

  

  

  

  

  

