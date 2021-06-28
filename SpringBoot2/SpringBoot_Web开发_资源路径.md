## SpringBoot Web开发

- ### 导入web开发坐标

  - ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```

- ### 在默认情况下,springboot服务的静态资源来自文件夹<font color='red'>Resources</font>下

  - #### /static  <font color='fuchsia'>(一般静态资源默认放在这个位置)</font>

  - #### /public

  - #### /resources

  - ####  /META-INF/resources

  - #### 顺序：相同文件名被访问的优先级，<font color='red'>META-INF>resources>static>public</font>

- ### 在默认情况下,资源的访问路径映射前缀<font color='fuchsia'>/**</font> ,可以使用<font color='cornflowerblue'>application</font>文件修改

  - #### Properties

    - ```properties
      spring.mvc.static-path-pattern=/resources/**
      ```

  - #### yaml

    - ```yaml
      spring:
      	mvc: 
            static-path-pattern: "/resources/**"
      ```

  - #### 这样访问请求的时候需要在静态资源之前加上<font color='fuchsia'>/resources</font> ,这里的<font color='fuchsia'>resources</font>不是指文件夹名称,仅代表前缀

  - #### 修改后的请求路径

    - ##### 当前项目 + static-path-patten + 静态资源名 = 静态资源文件夹下寻找

- ### 静态资源自定义位置

  - ```properties
    spring.web.resources.static-locations=classpath:/haha/
    ```

  - #### 这样静态资源的访问路径只有<font color='fuchsia'>haha</font>文件夹



- ### 请求原理

  - #### 请求先去寻找合适的Controller处理,如果找不到处理则交给静态资源处理器来处理

  - #### 所以在url中,controller地址和资源名字一样,优先寻找controller中mapping的对象







# <font color='red'>注</font>

#### 静态资源在IDEA中找不到的处理方法

#### 打开project Structure  ---> Modules ---->选择当前项目 ----> 展开选中Web --->设置Web Resource Directories --->  添加资源路径