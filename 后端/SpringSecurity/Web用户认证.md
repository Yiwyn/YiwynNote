## <font color='red'>Web权限方案</font>





- ### 设置登录的用户名和密码

  - #### 通过配置文件进行配置

    - ##### <font color='fuchsia'>sapplication.properties</font>文件

      ```properties
      spring.security.user.name=yiwyn
      spring.security.user.password=123456
      ```

  - #### 通过配置类

    - ##### 创建类并添加注解<font color='orange'>@Configuration</font>

    - ##### 继承<font color='cornflowerblue'>WebSecurityConfigurerAdapter</font>类

    - ##### 重写<font color='red'>configure</font>方法

      ```java
      @Configuration
      @EnableWebSecurity
      public class SecurityConfig extends WebSecurityConfigurerAdapter {
          @Override
          protected void configure(AuthenticationManagerBuilder auth) throws Exception {
              BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
              String password = passwordEncoder.encode("123456");
              auth.inMemoryAuthentication().withUser("yiwyn").password(password).roles("admin");
          }
      
          @Bean
          PasswordEncoder password() {
              return new BCryptPasswordEncoder();
          }
      }
      ```
      
    - ##### <font color='red'>BCryptPasswordEncoder</font> 这个类可以对密码进行加密。同时要在配置文件中创建Bean对象
  
  - #### 自定义编写实现类
  
    - ##### 创建配置类
    
      ```java
      @Configuration
      public class SecurityConfig extends WebSecurityConfigurerAdapter {
      
          @Autowired
          private UserDetailsService userDetailsService;
      
          @Override
          protected void configure(AuthenticationManagerBuilder auth) throws Exception {
              auth.userDetailsService(userDetailsService).passwordEncoder(password());
          }
      
          @Bean
          PasswordEncoder password() {
              return new BCryptPasswordEncoder();
          }
      }
      ```
    
    - ##### 编写实现类 实现接口<font color='cornflowerblue'>UserDetailsService</font> 
    
      ```java
      @Service("userDetailsService")
      public class MyUserDetailsService implements UserDetailsService {
          @Override
          public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
              List<GrantedAuthority> authos = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
              return new User("yiwyn", new BCryptPasswordEncoder().encode("123"), authos);
          }
      }
      ```
    
      - ##### 完善<font color='cornflowerblue'>UserDetailsService</font> bean对象
    
      - ##### 返回的User对象的三个参数不能为null