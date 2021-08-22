### <font color='orange'>@PathVariable</font> 

- #### 作用 : 获取路径中的变量 路径中的变量用<font color='fuchsia'>{param}</font> 表示.

- #### 示例:

  - ```java
    @GetMapping("/car/{id}")
    public Map<String, Object> getCar(@PathVariable("id") int id) {
        return null;
    }
    ```

  - #### 这样请求到的id就映射到方法的参数id

  - #### 不携带参数,则可以用<font color='red'>map<String,String></font> 来接受全部路径变量



<hr>



### <font color='orange'>@Requestheader</font>

- #### 作用:方便获取到请求头中的数据

- #### 示例

  - ```java
    @GetMapping("/car/{id}")
    public Map<String, Object> getCar(@PathVariable("id") int id, @RequestHeader("User-Agent") String userAgent) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("user-agent", userAgent);
        return map;
    }
    ```

  - #### 这样就取到了请求头中的<font color='cornflowerblue'>User-Agent</font>的值

  - #### 不携带参数,则可以用<font color='red'>map<String,String></font> 来接受全部请求头参数



<hr>




### <font color='orange'>@RequestParam</font> 

- #### 作用

  - ##### 可以将请求参数和方法参数结合起来

  - ##### 限制参数是否必须存在

  - ##### 设置参数的默认值,在请求中不包含该参数时生效

  - ##### get请求和post请求都可以使用

- #### 示例

  - ##### 请求url: <font color='fuchsia'>localhost/xxx?age=3</font> 

  - ```java
     @GetMapping("/xxx")
        public Xxx getCar(@RequestParam("age") int age) {
        		....
        }
    ```

  - ##### 将url中的<font color='fuchsia'>?age=3 </font>和 参数列表中的<font color='fuchsia'>age</font>结合起来

  - ##### 不携带参数,则可以用<font color='red'>map<String,String></font> 来接受所有的请求参数



<hr>



### <font color='orange'>@CookieValue</font> 

- #### 获取Cookie的参数

- #### 使用方法同上






<hr>

### <font color='orange'>@RequestBody</font>

- #### 作用:请求体只在post请求中生效,所以用来获取<font color='fuchsia'>post</font>请求中的参数

- #### 示例

  - ##### html

  - ```html
    <form action="/getBody" method="post">
        <input type="text" name="name">
        <input type="submit" value="提交">
    </form>
    ```

  - ##### java

  - ```java
    @PostMapping("/getBody")
    public Map<String, Object> getPost(@RequestBody String name) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("body", name);
        return map1;
    }
    ```






<hr>





### <font color='orange'>@RequestAttribute</font> 

- #### 作用:请求转发中获取request中设置的属性

- #### 示例:

  - ```java
    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request) {
        
        request.setAttribute("age", 18);
        return "forward:/success";
    }
    
    @ResponseBody
    @GetMapping("/success")
    public String success(@RequestAttribute("age") int age) {
    
        return null;
    }
    ```

  - #### 需要在<font color='orange'>@Controller</font>注解标志的类下





<hr>















