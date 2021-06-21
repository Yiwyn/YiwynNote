#### SpringMVC配置

- ##### 导入spingMVC坐标

- ##### 在web中配置SpringMVC核心控制器DispathcerServlet

  - ```xml
    	<servlet>
            <servlet-name>DispatcherServlet</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>classpath:spring-mvc.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
        </servlet>
    
        <servlet-mapping>
            <servlet-name>DispatcherServlet</servlet-name>
            <url-pattern>/</url-pattern>
        </servlet-mapping>
    
    
    //
    
     <!--    创建监听器需要初始话参数-->
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
        </context-param>
    
        <!--spring监听器-->
        <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
        </listener>
    
    ```
    
    ### <font color='red'>注</font>
    
    #####  其中 init-param 参数下参数名,代表了上下文配置路径.
    
    #### <font color='orange'>需要特别注意的是,文件中出现了连个springxxx.xml,系统默认处理一个,这个时候需要加载全局spring监听器,并且创建全局初始化参数,否则系统加载到spring配置文件之后不会加载剩下的配志文件</font>
    
    ###### 		spring-mvc.xml 作为配置文件主要为了扫描mvc相关的注解

- ##### 创建Controller类和视图页面

  - ```java
    @Controller
    @RequestMapping("/user")
    public class UserController {
    
        @RequestMapping("/quick")
        public String save() {
            System.out.println("Controller save running...");
            return "success.jsp";
        }
    
    
    }
    ```
    
    如图例:
    
    ​	使用注解配置了Controller类中业务方法的映射地址(RequestMapping)
    
    - ##### <font color='red'>注</font>
    
      - ###### 可以看到类和方法上面都添加了<font color='orange'>RequestMapping</font>注解,这里可以翻译为访问路径 <font color='cornflowerblue'>/user/quick</font>

- ##### 配置springMVC的核心文件spring-mvc.xml

  - ###### 见上<font color='red'>注</font>

  - ```xml
    <!--组件扫描-->
    <context:component-scan base-package="com.yiwyn.controller"/>
    ```

  - ###### 组件扫描只需要扫描Controller类即可

    
