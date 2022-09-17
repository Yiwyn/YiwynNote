## <font color='red'>SpringSecurity 基本原理</font>



- ### SpringSecurity的本质

  - #### 本质上是一个<font color='red'>过滤器链</font>





#####  

- ### 两个重要的接口

  - #### <font color='cornflowerblue'>UserDetailService</font>接口

    - ##### 创建继承类<font color='cornflowerblue'>UsernamePasswordAuthenticationFilter</font>，重写三个方法。

    - ##### 创建类实现<font color='cornflowerblue'>UserDetailService</font>，编写查询数据过程，返回User对象，这个User对象是安全框架提供的对象

  - #### <font color='cornflowerblue'>PasswordEncoder</font>接口

    - ##### 数据加密的接口，用于返回User对象里面密码加密

