# SpringMVC文件上传



- #### html\jsp 配置 表单

  - ###### method = "post"

  - ######  enctype="multipart/form-data" 

  - ###### type  = "file"

    - ###### 补充<font color='red'>EL表达式</font>   :  <font color='orange'> ${pageContext.request.contextPath} </font>获取路径

- #### 导入相关jar包

  - ###### commons-io

  - ###### commons-fileupload

- #### spring-mvc.xml配置文件

  - ```xml
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="5242800"/>
        <property name="maxUploadSizePerFile" value="5242800"/>
        <property name="defaultEncoding" value="utf-8"/>
    </bean>
    ```

    ###### 配置一个文件上传解析器

- #### 服务端代码

  - ```java
    /**
         * 文件上传
         */
        @RequestMapping("/test11")
        @ResponseBody
        public void test11(String username, MultipartFile file1) throws Exception {
            System.out.println(username);
            String filename = file1.getOriginalFilename();
            file1.transferTo(new File("D://uoloadtest/" + filename));
        }
    ```

    ###### <font color='red'>解析:</font>

    ###### 参数名字和网页端要一致,springMVC把文件打包成了<font color='red'>MultipartFile</font>类型的对象.

    ##### <font color='red'>transferTo(File file) </font>可以将上传的文件转移到<font color='red'>file</font>对象表示的文件对象