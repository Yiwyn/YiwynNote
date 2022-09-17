#### SpringBoot项目开发完成后,支持两种方式部署到服务器

- ##### jar包(官方推荐)

- ##### war包



#### <font color='red'>jar包</font>

- ##### 使用maven <font color='cornflowerblue'>package</font>命令

- ##### 控制台输出jar包位置

- ##### 使用shell语句 java -jar 包路径 (<font color='cornflowerblue'>windows下shift+鼠标右键开发命令行</font>)



#### <font color='red'>war包</font>

- ##### 修改pom文件

  - ```xml
    <packaging>war</packaging>
    ```

- ##### 修改启动类

  - ##### 继承<font color='red'>SpringBootServletInitializer</font>类

  - ##### 重写方法<font color='cornflowerblue'>configure</font>

    - ```java
      @SpringBootApplication
      @Import(UserController.class)
      public class SpringBootDeployJarApplication extends SpringBootServletInitializer {
      
          public static void main(String[] args) {
      
              SpringApplication.run(SpringBootDeployJarApplication.class, args);
          }
      
          @Override
          protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
              return builder.sources(SpringBootApplication.class); //构建器.加入入口类
          }
      }
      ```

- ##### 重新打包为war包



#### <font color='red'>添加</font>

打包的报名在pom.xml文件中build下可以修改

```xml
<build>
    <finalName>packageName</finalName>
    ....
</build>
```

