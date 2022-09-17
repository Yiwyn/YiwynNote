#### <font color='orange'>@Configuration</font>

###### 当我们使用SpringBoot的时候,是没有applicationContext.xml的配置文件的,这个时候我们需要Bean对象,可以使用

###### <font color='orange'>@Configuration</font> 注解,通过给方法注解<font color='orange'>@Bean</font>的形式返回Bean对象

```java
@Configuration
public class UserConifg {

    @Bean
    public User user() {
        return new User();
    }
}
```



### Configuration 参数

#### 	<font color='cornflowerblue'>proxyBeanMethods</font>  :代理bean

- #### 	true : Bean 为单实例的

- ####     fasle : Bean 为多实例的



```java
@Configuration(proxyBeanMethods = true)
public class UserConifg {

    @Bean
    public User user() {
        return new User();
    }
}
```

```java
public static void main(String[] args) {

    ConfigurableApplicationContext run = SpringApplication.run(SpringbootConfigurationApplication.class, args);
    UserConifg bean = run.getBean(UserConifg.class); //由userConfig创建Bean对象
    User user = bean.user();
    User user1 = bean.user();
    System.out.println(user1 == user);
}
```

