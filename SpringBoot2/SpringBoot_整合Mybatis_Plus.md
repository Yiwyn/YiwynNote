# 使用指南



> ​		[MyBatis-Plus (baomidou.com)](https://mp.baomidou.com/) 官方网站

​	

- ## 安装mybatisX插件

  - ##### 方便在配置文件和代码之间跳转

- ## 导入坐标

  - ```xml
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.1.2</version>
    </dependency>
    ```

- ## 自动配置分析

  - #### mapper文件映射文件<font color='cornflowerblue'>mapperLocations =  classpath*:/mapper/**/*.xml</font>

  - ###### 可以不用写配置文件(<font color='red'>注</font>)

    

- ## 扫描包

  - ```java
    @MapperScan("com.yiwyn.mapper")           //扫描包注解
    @SpringBootApplication
    public class SpringbootDataApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringbootDataApplication.class, args);
        }
    
    }
    ```

- ## 创建mapper接口

  - ```java
    public interface UserMapper extends BaseMapper<User> {
        //不用自己写,父类中包含基础方法
    }
    ```

  - ##### <font color='fuchsia'>BaseMapper</font>接口已经包含了常用的sql方法



- ## 表名

  - ### 通过上面代码我们发现,使用mp的过程中,没有具体到查询哪张表,是因为查询表的名是默认按照<font color='red'>domain类</font>的名字来决定的

  - ### 例如:在extends BaseMapper<User>  之后,将默认查询<font color='red'>User</font>表

  - ```java
    @TableName("user_list")
    public class User {
        int id;
        String username;
        String password;
        ....
    }
    ```

  - ### 可以通过这种方式将<font color='cornflowerblue'>实体类名</font>和<font color='cornflowerblue'>表名</font>联系起来







- ## 整合mvc框架

  - #### 创建UserService接口

    - ```java
      public interface UserService extends IService<User> {
      
      }
      ```

    - #### 继承<font color='cornflowerblue'>IService</font>接口,该接口包含curd的大量方法

  - #### 创建UserServiceImpl类

    - ##### 当类实现了接口<font color='cornflowerblue'>UserService</font>后,需要实现大量的方法,可以继承<font color='cornflowerblue'>ServiceImpl</font>类来实现

    - ```java
      @Service
      public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
      
      }
      ```

    - ##### <font color='cornflowerblue'>ServiceImpl</font>类会将<font color='cornflowerblue'>xxxMapper</font>接口

  - #### 这样我们的<font color='cornflowerblue'> UserServiceImpl</font> 就包含了大量方法,并且没有多余的代码

  - #### 使用方式

    - ```java
      @Autowired
      UserService userService;
      
      @Test
      void contextLoads() {
          User byId = userService.getById(1);
          System.out.println(byId);
      }
      ```

    - ##### 和springMVC中一样,仅仅是对接口和实现类的创建进行了改变















## 

