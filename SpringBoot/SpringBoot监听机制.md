#### 监听作为接口的形式实现



#### <font color='cornflowerblue'>ApplicationContextInitializer</font>

#### <font color='cornflowerblue'>SpringApplicationRunListener</font>

- #### 想要生效需要额外配置

  - ##### 和自动配置中<font color='orange'>Enable...</font>接口在<font color='red'>META-INF/spring.factories</font>中一样

  - ```properties
    org.springframework.context.ApplicationContextInitializer = com.yiwyn.springbootlistener.listener.MyApplicationContextInit
    org.springframework.boot.SpringApplicationRunListener = com.yiwyn.springbootlistener.listener.MySpringApplicationRunListener
    ```

  - ##### 其中,MySpringApplicationRunListener 需要配置构造函数,否则会报错.

    - 添加构造方法

    - ```java
      public class MySpringApplicationRunListener implements SpringApplicationRunListener {
      
          public MySpringApplicationRunListener(SpringApplication springApplication, String[] args) {
      			......
          }
      }
      ```

    - 





#### <font color='cornflowerblue'>CommandLineRunner</font>

#### <font color='cornflowerblue'>ApplicationRunner</font>

- ##### 以上两个方法,当项目启动后执行

- ##### 两个都一样,选择一个调用足以



​	



