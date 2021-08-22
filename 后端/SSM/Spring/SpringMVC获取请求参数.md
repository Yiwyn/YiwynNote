### 获取请求参数

- ##### 访问方法可以@ResponseBody 可以表示不跳转,方法作为响应方法.

- ##### 返回值void 表示相应为空,这意味着这是一个空的相应.

- ##### 接收参数设置为同名的形参就可以接受请求提供的数据

  - ```java
    @RequestMapping("/test7")
    @ResponseBody
    public void test7(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }
    ```

  - 访问url 

    ```web-idl
    localhost:8080/SpringMVC01/test7?username=yiwyn&age=18
    ```

- ##### 如果包装了javabean

  - ###### 例如 User 类 包含 name age

  - ###### 访问url携带参数 name 和 age  springMVC会自己包装为User

  - ```java
    @RequestMapping("/test8")
    @ResponseBody
    public void test8(User user) {
        System.out.println(user);
    }
    ```

    访问url:

    ```
    localhost:8080/SpringMVC01/test8?name=yiwyn&age=18
    ```

    ### <font color='red'>[注]</font>

    #### 如果传入参数不完整,则缺少的数据为默认值.





- ##### 获取数组类型参数

  示例代码

  ```java
  @RequestMapping("/test9")
  @ResponseBody
  public void test9(String[] arrs) {
      for (String arr : arrs) {
          System.out.println(arr);
      }
  }
  ```

  访问的url

  ```
  	/test9?arrs=111&arrs=222&arrs333
  ```









- #### 传值如果request(url)中的参数名和方法中的参数名字不统一,见最上方,同名参数可以接收数据

  - ```java
    @RequestMapping("/test10")
    @ResponseBody
    public void test10(@RequestParam("username") String user) {
        System.out.println(user);
    }
    ```

    ##### 可以是使用<font color='orange'>@RequestParam</font> 注解子自定义参数使参数值和方法参数对应起来

    

    - #### 同时<font color='orange'>:@RequestParam</font>有三个参数

      - ###### <font color='red'>value</font>:请求参数名称

      - ###### <font color='red'>required</font>:指定的请求参数是否存在,默认为true,提交时没有此参数报错.-->(<font color='red'>value</font>设置的参数)

      - ###### <font color='red'>defaultValue</font>:当没有指定参数时,则使用只当的默认值赋值

        ### 	例:

        如上代码中如果 @RequestParam("username")  不携带username 则访问出错.

        修改方法

        ```java
        @RequestMapping("/test10")
        @ResponseBody
        public void test10(@RequestParam(value = "username", required = false) String user) {
            System.out.println(user);
        }
        ```

        ###### 指定requried 为false则可以正常访问





