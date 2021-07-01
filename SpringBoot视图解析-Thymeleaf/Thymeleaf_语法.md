- ### 基本语法

  - | 表达式名称 | 语法    | 用途                                                       |
    | ---------- | ------- | ---------------------------------------------------------- |
    | 变量取值   | ${...}  | 获取请求域,session,对象等的信息                            |
    | 选择变量   | *{....} | 获取上下文对象                                             |
    | 消息       | #{....} | 获取国际化等值                                             |
    | 连接       | @{....} | 生成链接                                                   |
    | 片段表达式 | ~{....} | 类似<font color='red'>jsp:include</font> 作用,引入公共页面 |

    

- #### 基本功能示例

  - ###### 表单action

    - ```html
      <form class="form-signin"
            th:action="@{/login}" method="post">
      ```

  - ###### 变量值

    - ```html
      <label style="color: #ff0000" th:text="${message}"> 占位文字 </label>
      ```

    - ##### 和jsp的区别在于,是直接的体现,在值的位置${...} 而 Thymeleaf不同,他是在属性取值覆盖占位文字

  - ###### 行内数据

    - ##### 有时候有些文字不是在标签里面的,这个时候需要使用[[th:xxx = "xxx"]]来表达

    - ```http
      [[${session.user.userName}]]
      ```

    - ##### 行内获取userName的值

  - ###### 超链接
  
    - ```html
      <link href="css/style.css" th:href="@{/css/style.css}" rel="stylesheet">
      ```
  
    
  
    
  
- #### 链接html文件需要在html标签中添加属性:

  - ```html
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    ```




<hr>



- #### 遍历可迭代对象

  - ##### controller代码

    - ```html
      @GetMapping("/show")
      public String show(Model model) {
          String[] users = {"one", "two", "three"};
          model.addAttribute("users", users);
          return "showPage";
      }
      ```

  - ##### showPage.html代码

    - ```html
      <table>
          <tr th:each="user : ${users}">
              <td th:text="${user}"></td>
          </tr>
      </table>
      ```

  - ##### 遍历状态获取

    - ```html
      <table>
          <tr th:each="user,userState : ${users}">
              <td th:text="${user}"></td>
              <td th:text="${userState.index}"></td>
          </tr>
      </table>
      ```

    - ##### 有代码可见，在遍历可迭代对象时候，可以用"<font color='cornflowerblue'>,</font>"的形式创建一个变量<font color='red'>xxState</font>(State表状态,方便记忆),其中xxState的成员字段包含

      - ###### index  --> 索引值

      - ###### count  --> 个数

      - ###### odd      --> 是否偶数(<font color='fuchsia'>boolean</font>)



<hr>



- #### 布尔值

  - ###### html示例

    - ```html
      <td th:text="${userState.odd}?'odd':'even'"></td>
      //当user是否为偶数时显示的内容
      ```

    - ###### 可以由此构成<font color='red'>三目运算符的形式</font> ,同时也可以

    - ```html
      <td th:text="${userState.odd}?'odd'"></td>
      //当user是偶数时显示的内容
      ```

    - ###### 可以时单独跟一个参数,当前置条件为<font color='red'>true</font>时触发







