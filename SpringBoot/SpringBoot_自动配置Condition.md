## Condition

#### <font color='red'>定义:</font>	Condition是在Spring4.0中增加的条件判断功能,通过这个功能可以选择性的创建Bean的操作



### <font color='red'>注</font>:

##### 在SpringBoot的启动应用中,返回的是IOC容器

```java
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
            //启动springBoot的应用 返回IOC容器
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
            //获取eban
//     context.getBean("beanName");

    }
}
```





#### 举例说明:

- ##### 创建User类作为测试对象	<font color='red'>*</font>

  - ```java
    public class User {
        
    }
    ```

- ##### 创建UserConfig类,创建Bean对象   <font color='red'>*</font>

  - ```java
    @Configuration
    public class UserConfig {
    
        @Bean
        public User user() {
            return new User();
        }
    }
    ```

  - ###### 这样配置之后,可以直接通过<font color='red'>**context**(上文代码中启动应用时候的返回值)</font>对象

- ##### 添加注解<font color='orange'>@Conditional</font>

  - ###### 该注解含有参数为 接口类型Condition的对象

  - ###### 实现唯一方法 matches

  - ```java
    public class ClassCondition implements Condition {
    
        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            return false;
        }
    }
    ```

- ##### 添加注解后的UserConfig类<font color='red'>*</font>

  - ```java
    @Configuration
    public class UserConfig {
    
        @Bean
        @Conditional(ClassCondition.class)
        public User user() {
            return new User();
        }
    }
    ```

  - ###### 这个时候因为<font color='red'>matches</font>方法中返回值为false,因此不会自动创建bean对象,这个时候springbootApplication中context将获取不到bean对象.于是我们可以对ClassCondition类中的matches方法进行操作.
  
- ##### 将ClassCondition配置为自动的

