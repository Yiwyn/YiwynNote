### 页面跳转形式有两种

- ###### 返回字符串类型.这个字符串就是viewName

  - ```java
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller save running...");
        return "success";
    }
    ```

- ###### 返回ModelAndView对象,其中Model对象包含viewName等关键数据

  - ```java
    @RequestMapping("/quick1")
    public ModelAndView save1() {
        /**
         * model: 模型 封装数据
         * view :视图 展示数据
         */
    
        System.out.println("quick1开启成功");
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }
    ```
    
  - ###### ModelAndView对象的详细使用方法.
  
    - ```java
      @RequestMapping("/quick1")
      public ModelAndView save1() {
          /**
           * model: 模型 封装数据
           * view :视图 展示数据
           */
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("success");
          modelAndView.addObject("username", "yiwyn");
          modelAndView.addObject("password", "123456");
          return modelAndView;
      }
      ```
  
      #### <font color='red'>[注]</font> 这里的<font color='orange'>addObject()</font>方法 类似于<font color='orange'>request.setAttribute()</font>方法
  
    ## <font color='red'>扩展</font>
  
    #### 注入的思想
  
    - ```java
      @RequestMapping("/quick2")
      public ModelAndView save2(ModelAndView modelAndView) {
          modelAndView.setViewName("success");
          modelAndView.addObject("username", "yiwyn");
          modelAndView.addObject("password", "12345");
          return modelAndView;
      }
      ```
  
      ##### 与上方代码类似,但是不会在方法体中创建对象,而是在参数中加上了<font color='orange'>ModelAndView()</font>
  
      ##### spring会根据参数自己注入一个ModelAndView对象,方法体中直接使用
  
    - ## <font color='cornflowerblue'>注入的思想延伸</font>
  
      - #### 参数不仅仅局限于ModelAndView,还可以是Model,<del>HttpServletRequest</del>(不常用)等
  
        - ```java
          @RequestMapping("/quick3")
          public String save3(HttpServletRequest request) {
              request.setAttribute("username", "quick3");
              return "success";
          }
          ```
  
          



​			

