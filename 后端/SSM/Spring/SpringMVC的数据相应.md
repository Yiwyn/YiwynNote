# 回写数据

<hr>

- #### 直接返回字符串

  - 添加注解<font color='orange'>@ResponseBody</font> 这时候方法会自动识别为回写方法
  
    - ```java
      @RequestMapping("/test6")
      @ResponseBody
      public String test6() {
          return "返回的数据";
      }
      ```
  
- 返回对象或者集合


  - springMVC已经提供了相关的注解,只需要注解使用即可


    - spring-mvc.xml	配置mvc注解驱动


      - ```xml
        <mvc:annotation-driven/>
        ```


        - ```xml
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
          ```

      - 如果返回json类型,需要导包


        - jackson-core
        - jackson-annotaions
        - jackson-databind

      - 直接返回需类型则转换为json类型

