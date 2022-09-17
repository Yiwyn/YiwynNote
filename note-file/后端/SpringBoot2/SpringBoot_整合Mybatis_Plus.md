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
  
  - ##### <font color='fuchsia'>UserMapper</font>中包含的查询方法中使用条件查询
  
    ```java
    userMapper.selectOne(new QueryWrapper<>().eq("colName",Value))
    ```
  
    - ##### 使用<font color='red'>eq（equal）</font>可以对属性进行判断。相当于 where xxx =xxx ，eq方法可以<font color='red'>连续使用</font>



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





- ## 分页查询

  - #### 分页查询需要配置<font color='cornflowerblue'>bean</font>对象，所以在springboot中我们需要创建<font color='orange'>Configuration</font>类

    - ```java
      @Configuration
      public class MyDataSourceConfig {
      
      	//自定义的分页查询的bean
          @Bean
          public PaginationInterceptor paginationInterceptor() {
              PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
      
              paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize());
      
              return paginationInterceptor;
          }
      }
      ```

  - ### 在UserService配置完成之后，<font color='fuchsia'>userService</font>象包含<font color='cornflowerblue'>page</font>方法 

    - ##### 配置如下

    - ```java
      Page<User> userPage = new Page<>(1, 2);
      userService.page(userPage, null);
      ```

    - ##### 这样获取到的对象userPage对象，包含了当前记录，当前页数，总页数，全部记录数等信息。

    - ```java
      System.out.println(userPage.hasPrevious()); //是或有上一页
      System.out.println(userPage.getPages()); //获取全部页数
      System.out.println(userPage.getTotal()); // 获取全部数数据数
      System.out.println(userPage.getRecords());//查询到的数据列表
      ```

      

