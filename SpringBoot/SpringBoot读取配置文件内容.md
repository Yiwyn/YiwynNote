### Java中读取application参数方法

- #### 使用注解<font color='orange'>@value</font>

  - ###### 字段添加注解@value("${keyName}")

  - ```yaml
    name: lisi
    ```

  - ```java
    @Value("${name}")
    private String name;
    ```

  - ###### 对象输出使用<font color='orange'>对象名.属性</font>的格式

  - ```java
    @Value("${person.name}")
    private String name;
    ```

  - ###### 数组输出使用<font color='orange'>对象名[index]</font>的格式

  - ```yaml
    @Value("${array[0]}")
    private String name;
    ```

- #### 使用Environment对象

  - ```java
    @Autowired
    Environment environment;
    
    //使用方法
    environment.getProperty("keyName");
    ```

- #### 使用 <font color='orange'>@ConfigurationProperties</font> 方式 

  - ###### 使用bean的形式在bean类上添加该注解,自动识别配置中的属性.

  - ```java
    @ConfigurationProperties(prefix="person")
    @component
    class Person{}
    
    //使用
    @Autowired
    Person person;
    ```

  - ```yaml
    person:
      name: cortana
      age: 17
    ```

    

  - ###### 如果注解不添加前缀,则注入参数时系统会默认注入配置中属性和bean中存在属性一致的参数,只有参数标识了前缀,系统才会自动识别注入父标签匹配bean中的属性.

- #### 使用<font color='orange'>@EnableConfigurationProperties</font> 来激活配置属性

  - ```java
    @Import({UserConifg.class})
    @SpringBootApplication
    @EnableConfigurationProperties(User.class)
    public class SpringbootConfigurationApplication {
    
        public static void main(String[] args) {
    
            ConfigurableApplicationContext run = SpringApplication.run(SpringbootConfigurationApplication.class, args);
            User user = (User) run.getBean("user01");
            System.out.println(user.getName());
            System.out.println(user.getGender());
        }
    }
    ```

  

  

  - #### <font color='red'>注意</font>

    - #### 使用<font color='orange'>@ConfigurationProperties</font>时可以导入依赖

      - ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        ```

    - #### 这样我们自己的bean类在书写配置文件的时候也会出现提示,如果没有出现提示,可以在启动项目处选择build project(ctrl+F9 02)

    
