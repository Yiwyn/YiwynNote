## <font color='orange'>@Conditional</font> 条件注解



- #### <font color='orange'>@ConditionalOnBean</font>

- ```java
  @Bean("user")
  public User user() {
      return new User();
  }
  
  @Bean
  @ConditionalOnBean(name = "user")
  public Score score() {
      return new Score();
  }
  ```

- ##### 当user 这个bean不存在时,系统不允许创建score这个bean对象



- #### <font color='orange'>@ConditionalOnMissingBean</font>

  - ###### 当系统中不存在这个Bean时,才可以创建



- #### <font color='orange'>Conditional</font> 提供很多子注解,使用大同小异

