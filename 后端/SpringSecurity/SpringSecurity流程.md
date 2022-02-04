## <font color='red'>流程</font>





<img src="SpringSecurity%E6%B5%81%E7%A8%8B.assets/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIyMTcyMTMz,size_16,color_FFFFFF,t_70.jpeg" alt="img" style="zoom:120%;" />













![img](SpringSecurity%E6%B5%81%E7%A8%8B.assets/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIyMTcyMTMz,size_16,color_FFFFFF,t_70-16438945215062.jpeg)













<img src="SpringSecurity%E6%B5%81%E7%A8%8B.assets/image-20220203212734676.png" alt="image-20220203212734676" style="zoom:150%;" />





### <font color='red'>使用流程</font>

- #### 自定义登录接口

```java
//在配置中需要先重写AuthenticationManager

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//在登录接口中调用该Bean对象的 authenticate 方法

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new 		UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
		 
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);



//authenticate接口方法会调用到UserDetailsService（我们会重写这个类）
```

- #### 从authenticationManager 到 自己定义的UserDetailsService

  - ##### <font color='orange'>authenticationManager#authenticate</font> 方法找到实现类 <font color='cornflowerblue'>ProviderManager</font>   

  - ##### 在ProviderManager中可以发现 <font color='cornflowerblue'>AuthenticationProvider</font> 类也会实现<font color='orange'>authenticate</font> 方法，找到定义<font color='cornflowerblue'>AbstractUserDetailsAuthenticationProvider#authenticate</font>

  - ##### <font color='red'>retrieveUser</font>找到实现类

    ```java
    protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
            this.prepareTimingAttackProtection();
    
            try {
                //定位到loadUserByUsername
                UserDetails loadedUser = this.getUserDetailsService().loadUserByUsername(username);
                if (loadedUser == null) {
                    throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
                } else {
                    return loadedUser;
                }
            } catch (UsernameNotFoundException var4) {
                this.mitigateAgainstTimingAttack(authentication);
                throw var4;
            } catch (InternalAuthenticationServiceException var5) {
                throw var5;
            } catch (Exception var6) {
                throw new InternalAuthenticationServiceException(var6.getMessage(), var6);
            }
        }
    ```

  - ##### 可以看到<font color='cornflowerblue'>this.getUserDetailsService().loadUserByUsername(username);</font> 调用到这个方法

  - ##### 自己定义的UserDetailsService

    ```java
    @Service
    public class UserDetailServiceImpl implements UserDetailsService {
        
        @Resource
        UserMapper userMapper;
    
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
            User user = userMapper.selectByUsername(username);
            if (ObjectUtils.isEmpty(user)) {
                throw new RuntimeException("用户不存在");
            }
            return new LoginUserDetails(user);
        }
    }
    ```

    
