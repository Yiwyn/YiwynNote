### <font color='red'>SpringBoot中读取配置文件中的内容</font>



##### 方案一：

- ##### 使用<font color='cornflowerblue'>configuration-processor</font>

  ```xml
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-configuration-processor</artifactId>
          </dependency>
  ```

  

- ##### 将需要加载的配置封装成为实体类

  ```java
  @Data
  @Component
  @ConfigurationProperties(prefix = "cust") //prefix对应配置文件中的第一节点
  public class CustConfig {
  	
      private List<String> ids; //配置文件中的名字对应，可驼峰映射
      
      private List<String> routerLink; 
  }
  ```

- ##### 配置文件

  ```yaml
  cust: 
    ids:  #list的第一种写法
      - a
      - b
      - c
      - d
    router-link: a.com, b.com, c.com #驼峰下list的第二种写法
  ```



##### 方案二：

- ##### 使用<font color='cornflowerblue'>@Value</font>注解

  ```yaml
  #若使用@Value注解，则加载list只能使用上述第二种写法。
  ignore:
    list: a, b, c
  ```

- ##### 使用

  ```java
      @Value("${ignore.list}")
      private List<String> ignoreList;
  ```

  



