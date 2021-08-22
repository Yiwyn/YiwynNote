### <font color='orange'>@ImportResource</font> 

- #### SpringBoot项目,有些是从spring项目迁移的,而spring中sping,xml配置文件修改为注解的形式过于麻烦,所以出现了该注解

- #### 示例

  - ##### bean.xml

    - ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
      
          <bean id="user01" class="com.yiwyn.domain.User"/>
      
      </beans>
      ```

  - ##### SpringBoot启动类

    - ```java
      @ImportResource("classpath:bean.xml")
      public class SpringbootConfigurationApplication {
          main(){
      	ConfigurableApplicationContext run = 		SpringApplication.run(SpringbootConfigurationApplication.class, args);
      	run.getBean("user01");
          }
      }
      ```

  - ##### 使用<font color='orange'>@ImportResource</font>注解,将配置文件导入springboot的容器中

