## 实现步骤

- #### 创建maven项目

- #### 导入SpringBoot起步依赖

  - ```xml
    <!--    继承父工程-->
    <parent>
        <artifactId>spring-boot-starter-parent</artifactId>
        <groupId>org.springframework.boot</groupId>
        <version>2.5.0</version>
    </parent>
    
    
    
    <dependencies>
        <!--        导入依赖-->
          <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
        
         <!--        Web项目需要的依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    ```

- #### 定义Controller

  - ##### 这部分和SpringMVC类似

  - ```java
    @RestController
    public class MyController {
    
        @RequestMapping("hello")
        public String hello() {
            return "Hello Spring";
        }
    }
    ```

- #### 编写引导类

  - ```java
    @SpringBootApplication
    public class HelloApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(HelloApplication.class, args);
        }
    }
    ```

  - ##### 引导类规范: Application结尾,作为SpringBoot程序的入口

  - #### <font color='red'>springbootApplication引导类要置语逻辑代码的上层,不然不起作用</font>

- #### 启动测试

  - ###### springBoot自带了Tomcat组件

  - ![image-20210613160226647](C:\Users\55971\AppData\Roaming\Typora\typora-user-images\image-20210613160226647.png)







# <font color='red'>注</font>

- ##### 使用SpringBoot创建项目时,使用jar的打包方式

- ##### SpringBoot的引导类,是项目入口,运行main方法就可以启动项目

- ##### 使用SpringBoot和Spring构建的项目,业余代码编写的方式完全一样



## <font color='red'>@RestController 和 @Controller 的区别</font>

#### 	RestController注解相当于ResponseBody+Controller 合在一起作用的



#### 只使用RestController注解Controller ,则Controller中的方法是无法返回jsp/html 页面的,配置视图解析器InternalResourceViewResolver不起作用,返回的内容就是Return中的内容吗,但是可以不加@ResponseBody注解返回json等数据.



#### 如果需要返回到指定页面,则需要Controller配合视图解析器InternalResourceViewResolve才行.

#### 如果需要返回json,xml或者自定义的mediaType到页面上,则需要对应的方法上加上<font color='orange'>@ResponseBody</font>注解

