##### 用一个类来代替Spring注解开发的核心配置

```java
//标志该类为Spring的核心配置类
@Configuration
@ComponentScan("com.yiwyn")
//<context:property-placeholder location="classpath:druid.properties"/>
@PropertySource("classpath:druid.properties")

public class SpringConfiguration {
    
}
```

###### @configuration  <font color='orange'>//标志了该类是Spring的核心配置类</font>



###### @componentScan("path")  <font color='orange'>//配置扫描组件 效果替代</font>

```xml
<context:component-scan base-package="path(com.yiwyn)"/>
```



###### @propertySource("classpath:xxx.properties")  <font color='orange'>//加载properties文件,使他可以在类文件中使用,不使用代码,使用配置的方式加载</font>

###### 效果等同于

```xml
<context:property-placeholder location="classpath:druid.properties"/>
```



###### 		在使用了propretySource之后,资源相当于已经加载到了类中,但是我们不能直接使用他们,java认识字符串会直接识别所以${xx}的形式直接在代码中会出现问题.



```java
@Value("${druid.driverClassName}")
private String driver;

@Value("${druid.url}")
private String url;

@Value("${druid.username}")
private String username;

@Value("${druid.password}")
private String password;

@Bean("dataSource")
public DataSource getDataSource() throws Exception {

    DruidDataSource ds = new DruidDataSource();
    ds.setDriverClassName(driver);
    ds.setUrl(url);
    ds.setUsername(username);
    ds.setPassword(password);
    return ds;
}
```

###### @Value  <font color='orange'>//@Value注解的参数可以读取注解中加载的properties文件中的key/value,通过此注解来给属性赋值,达到取值的作用,方便在java代码中使用</font>





## <font color='red'>注:</font>

<hr>

#### <font color='orange'>@bean</font> 和<font color='orange'>@component</font>的区别



Spring帮助我们管理Bean分为两个部分，一个是注册Bean，一个装配Bean。
完成这两个动作有三种方式，一种是使用自动配置的方式、一种是使用JavaConfig的方式，一种就是使用XML配置的方式。

@Compent 作用就相当于 XML配置

```java
@Component

public class Student {

    private String name = "lkm";
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
```


@Bean 需要在配置类中使用，即类上需要加上@Configuration注解

```java
@Configuration
public class WebSocketConfig {
    @Bean
    public Student student(){
        return new Student();
    }
```


两者都可以通过@Autowired装配

```
@Autowired
Student student;
```



#### <font color='cornflowerblue'>那为什么有了@Compent,还需要@Bean呢？</font>

##### 

#### <font color='red'>如果你想要将第三方库中的组件装配到你的应用中，在这种情况下，是没有办法在它的类上添加@Component注解的，因此就不能使用自动化装配的方案了，但是我们可以使用@Bean,当然也可以使用XML配置。</font>

