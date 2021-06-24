#### 在springBoot的启动程序中<font color='orange'>@SpringBootApplication</font> 默认的检测包是其包含其类路径下的包,不在它包含的目中,系统无法加载到bean对象



#### 想要加载其他包下的对象

- ##### 使用<font color='orange'>@ComponentScan</font>

  - ```java
    @SpringBootApplication
    @ComponentScan("xx.xx.xx")
    public class MyApplication {
    
    }
    ```

- ##### 使用<font color='orange'>@import</font> 注解

- ##### 自己包装<font color='orange'>@import</font>注解

  - ```java
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Import(UserConfig.class)
    public @interface EnableUser {
    
    }
    ```

    ##### 由于是对import的包装,所以import中的注解也要复制到自己封装的import注解中.

