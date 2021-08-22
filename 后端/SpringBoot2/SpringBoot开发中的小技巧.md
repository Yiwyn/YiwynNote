- ### 巧妙设置首页

  - ```java
    
    //在Controller中
    @GetMapping(value = {"/", "xxx"})
    ```

  - ##### value是String类型数组 所以可以存放多个路径, 而<font color='fuchsia'> /</font> 表示根目录,设置为它则代表了首页





- ### 登录请求之后的刷新

  - ##### 登录请求的网页返回要重定向,不能请求转发,因为请求转发不改变url,会提示重复提交表单

  - ##### 使用重定向  <font color='fuchsia'>"redirect:/xxx.xxx" </font> 注意这里的xxx.xxx 是需要全部名称的,springboot中视图解析器自动配置的开头和结尾是请求转发用的.

  - ##### 同时,在第二条设置之后,我们处于/xxx.xxxx下,这个时候我们可以使用请求转发到自己这个页面

    - ```java
      // main页面刷新
      @GetMapping("/main.html")
      public String mainPage() {
      
          return "main";
      }
      ```





