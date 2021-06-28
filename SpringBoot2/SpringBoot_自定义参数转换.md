#### 表达提交自定义类型对象时,不一定需要每项单独列出来,可以自定义转换器将一个字符串抓换为需要的类型.

### 如 :







- #### 自定义POJO

  - ```java
    public class User {
        String name;
        int age;
      ....省略 getter setter
          
    }
    ```

- #### 自定义类型转换

  - ##### 类型转换需要我们自己自定义Converter

  - ##### 编写一个Config的配置类来配置<font color='fuchsia'>WebMvcConfigurer</font>

    - ```java
      @Configuration
      public class MyConfig {
      
          @Bean
          public WebMvcConfigurer webMvcConfigurer() {
              return new WebMvcConfigurer() {
                  @Override
                  public void addFormatters(FormatterRegistry registry) {
                      registry.addConverter(new Converter<String, User>() {
                          @Override
                          public User convert(String s) {
                              if (!StringUtils.isEmpty(s)) {
                                  User user = new User();
                                  String[] split = s.split(",");
                                  user.setName(split[0]);
                                  user.setAge(Integer.parseInt(split[1]));
                                  return user;
                              }
                              return null;
                          }
                      });
                  }
              };
          }
      }
      ```

    - #### springboot内置的Configurer不包含自定义,我们通过返回自定义<font color='cornflowerblue'>WebMvcConfigurer</font>的bean对象的形式重写<font color='cornflowerblue'>addFormatters</font>方法并使用regisy参数调用<font color='cornflowerblue'>addConverter</font>方法添加我们需要的转换器,通过重写<font color='cornflowerblue'>convert</font>方法返回我们需要的对象.







