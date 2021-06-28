> ##### 在springMVC Restful风格参数获取 文档中详细讲解了什么是Rest映射



##### <font color='red'>问题分析:</font>

- ##### 表单提交只能提交get/post

- ##### Restful风格需要get post delete put 类型的提交请求



##### <font color='red'>解决方案:</font>

- ##### 在springboot中,我们使用put和delete请求时,只需要在表单(form)中,添加一个隐藏的input属性, <font color='cornflowerblue'>name= _method</font>   value = 请求名称

- ##### html文件

  - ```html
    <form method="post" action="/user">
        <input type="submit" value="提交">
    </form>
    
    <form method="get" action="/user">
        <input type="submit" value="提交">
    </form>
    
    <form method="post" action="/user">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="提交">
    </form>
    
    <form method="post" action="/user">
        <input type="hidden" name="_method" value="put"/>
        <input type="submit" value="提交">
    </form>
    ```

- ##### controller类

  - ```java
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public void get() {
        System.out.println("get");
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public void post() {
        System.out.println("post");
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete() {
        System.out.println("delete");
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public void put() {
        System.out.println("put");
    }
    ```

- ##### 同时要激活hidden的_menthod 特性 我们还需要手动开启

  - ##### 核心Filter:<font color='cornflowerblue'>HiddenHttpMethodFilter</font>

  - ```yaml
    spring:
      mvc:
        hiddenmethod:
          filter:
            enabled: true
    ```

- ##### 选择开启.前后端分离



##### <font color='red'>Restful原理:</font>

- ##### <font color='fuchsia'>源码</font>

  - ```java
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest requestToUse = request;
        if ("POST".equals(request.getMethod()) && request.getAttribute("javax.servlet.error.exception") == null) {
            String paramValue = request.getParameter(this.methodParam);
            if (StringUtils.hasLength(paramValue)) {
                String method = paramValue.toUpperCase(Locale.ENGLISH);
                if (ALLOWED_METHODS.contains(method)) {
                    requestToUse = new HiddenHttpMethodFilter.HttpMethodRequestWrapper(request, method);
                }
            }
        }
    
        filterChain.doFilter((ServletRequest)requestToUse, response);
    }
    ```

- ##### 表单请求来会带上_method = put/delete

- ##### 请求过来被 HiddenHttpMethodFilter 拦截

  - ###### 请求是否正常,并且请求为post方式

  - ###### 获取到_method的值







##### <font color='red'>SpringBoot中的进一步简化</font>

- ```java
  @GetMapping("/user")
  @PostMapping("/user")
  @DeleteMapping("/user")
  @PutMapping("/user")
  
  //这个注解是对 @RequestMapping 注解的进一步封装
  ```

- ##### 选择任意一个源码

  - ```java
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @RequestMapping(
        method = {RequestMethod.PUT}
    )
    public @interface PutMapping {
    	...
    }
    ```

  - ##### 如源码所示



