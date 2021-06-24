#### 在SpringBoot中系统在导入<font color='red'>spring-boot-starter-web</font>坐标后,会自动启用tomcat服务器.



#### 切换内置web服务器

- ##### 需要先排除Tomcat的依赖

  - ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    ```

- ##### 导入需要打开的服务器坐标

  - ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jetty</artifactId>
    </dependency>
    ```

- ##### 启动spring-boot, 服务器已经切换为Jetty

​	

