- #### 文件上传需要先配置<font color='cornflowerblue'>application.yml</font>文件

- ```yaml
  spring:
    servlet:
      multipart:
        max-file-size: 10MB
        max-request-size: 10MB
        enabled: true
  ```

- #### 编写前端代码

- ```html
  <form action="/upload" method="post" enctype="multipart/form-data">
      <p>选择文件: <input type="file" name="file"/></p>
      <p><input type="submit" value="提交"/></p>
  </form>
  ```

- #### 后端代码

- ```java
   @RequestMapping("/upload")
      public String upLoad(MultipartFile file) throws IOException {
  
          String userPath = System.getProperties().getProperty("user.home") + "/fileDirection/";
          userPath += file.getOriginalFilename();
          file.transferTo(new File(userPath));
          return null;
      }
  ```



<hr>



### <font color='red'>小知识</font>

```java
System.getProperties().getProperty("user.home")
```

##### 可以读取到当前系统的home文件夹路径