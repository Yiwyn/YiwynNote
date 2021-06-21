## Junit

- ### 添加starter-test包坐标和junit坐标

- ### 创建测试类,在spring的test文件夹中

  - #### 通常目录为com.yiwyn.test.(功能)test

- #### 添加注解

  - #### 测试类添加注解<font color='orange'>@RunWith(SpringRunner.class)</font> 

  - #### 测试类添加注解<font color='orange'>@SpringBootTest(classes = applicaiton.class)</font> 

    - ##### 这里的application.class 指的是启动springboot的application类,并非类名如此





### <font color='red'>注</font>

#### 如果测试类所在文件夹目录名和main中文件夹名一致,则<font color='orange'>@SpringBootTest</font> 不需要添加参数.





<hr>



## Redis

- ### 添加坐标<font color='cornflowerblue'>spring-boot-starter-data-redis</font> 

- #### <font color='orange'>@Autowired</font>  获取 RedisTemplate 对象

- #### 启动Redis服务器

- #### 使用RedisTemplate操作数据







<hr>



## MyBatis

- ### 引入mybatis起步依赖,添加mysql驱动

  - #### <font color='cornflowerblue'>mybatis-spring-boot-starter</font> 

  - #### <font color='cornflowerblue'>mysql-connector-java</font> 

- ### 编写DataSource和MyBatis相关配置

  - #### 在springboot中<font color='red'>DataSource </font>可以在<font color='red'>application.yml</font>中配置 

  - ```yaml
    spring:
      datasource:
        url: jdbc:mysql:///test
        username: root
        password: root
        driver-class-name: com.mysql.jdbc.Driver
    ```

- ### 定义表和实体类

  - #### 与传统方式相同javabean

- ### 编写dao和mapper文件/纯注解开发

  - #### 接口注解<font color='orange'>@Mapper</font>

  - #### 方法注解<font color='orange'>@select</font> 等,与spring中不同的是不需要额外的配置,添加注解即可使用

    - ```java
      @Mapper
      @Repository
      public interface UserMapper {
      
          @Select("select * from user")
          public List<User> findAll();
      }
      ```

  - #### 使用方法与spring中相同

  

  #### 使用配置文件开发

  - ​	

    ```java
    @Mapper
    @Repository
    public interface UserXml {
    
        public List<User> findAll();
    
    }
    ```

  - #### 添加mapper文件

    - ```xml
      <?xml version="1.0" encoding="UTF-8" ?>
      <!DOCTYPE mapper
              PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
              "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
      <mapper namespace="com.yiwyn.mapper.UserXml">
          <select id="findAll" resultType="com.yiwyn.domain.User">
              select *
              from user;
          </select>
      </mapper>
      ```

    

    #### application.yml文件中添加配置文件

    - ​	

      ```yaml
      #mybatis配置
      mybatis:
        mapper-locations:classpath:mapper/*Mapper.xml
      ```

      #### 剩下使用与spring中相同

    

    

    

  







