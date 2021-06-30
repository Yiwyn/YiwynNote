- ### 基本语法

  - | 表达式名称 | 语法    | 用途                                                       |
    | ---------- | ------- | ---------------------------------------------------------- |
    | 变量取值   | ${...}  | 获取请求域,session,对象等的信息                            |
    | 选择变量   | *{....} | 获取上下文对象                                             |
    | 消息       | #{....} | 获取国际化等值                                             |
    | 连接       | @{....} | 生成链接                                                   |
    | 片段表达式 | ~{....} | 类似<font color='red'>jsp:include</font> 作用,引入公共页面 |

    

- #### 示例

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

    

