## SpringBoot中添加欢迎页和网站图标

### <font color='red'>欢迎页</font>

- ##### 静态资源路径下: index.html

  - ##### 静态资源可以是自己在yum中设置的

    - ```yaml
      spring:
        web:
          resources:
            static-locations: "classpath:static/"
      ```

    - ##### 这样访问到的index.html文件就是<font color='cornflowerblue'>static</font> 目录下的

- ##### controller能处理/index





### <font color='red'>网站图标</font> (favoicon)

- ##### 将网站图标以<font color='fuchsia'>favicon.ico</font>的名字放到资源路径下,系统将自动识别

