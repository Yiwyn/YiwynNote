### <font color='red'>需求</font>

#### 		自定义redis-starter.  要求导入redis坐标时,springBoot自动创建Jedis的Bean

​		

### <font color='red'>实现步骤</font>

- #### 创建redis-spring-boot-autoconfigure 模块

- #### 创建redis-spring-boot-starter 模块,依赖redis-spring-boot-autoconfigure的模块

- #### 在redis-spring-boot-autofigurte模块中初始话Jedis的Bean.并定义META-INF/spring.factories文件

- #### 在测试模块中引入自定义的redis-starter依赖,测试获取Jedis的Bean,操作redis





### <font color='red'>实现</font>

- #### 创建两个模块文件,清除不需要的部分.  <font color='cornflowerblue'>pom.xml</font>文件中, 清除自动生成的类

- #### 在starter包中导入自己编写的autoconfigure包

  - ```xml
    <dependency>
        <groupId>com.yiwyn</groupId>
        <artifactId>redis-spring-boot-autoconfigure</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    ```

- #### 编写autoconfigure包完成自动配置任务

  - ```java
    @Configuration
    public class RedisAutoConfiguration {
        /**
         * 提供Jedis的bean
         */
         public Jedis jedis() {
            return new Jedis("localhost", 6379);
        }
    }
    ```

- #### 其中Jedis的参数不能写死,所以创建RedisProperties类来配置参数

  - ```java
    @ConfigurationProperties(prefix = "redis")
    public class RedisProperties {
    
        private String host = "localhost";
        private int port = 6379;
    
        public String getHost() {
            return host;
        }
    
        public void setHost(String host) {
            this.host = host;
        }
    
        public int getPort() {
            return port;
        }
    
        public void setPort(int port) {
            this.port = port;
        }
    }
    ```

  - ##### 需要注意的是<font color='orange'>ConfigurationProperties</font> 这里创建完成时报错的,因为没有使用在其他地方使用<font color='orange'>@EnableConfigurationProperties</font> 或者在该类上添加<font color='orange'>@Commpoent</font>注解

  - ```java
    @Configuration
    @EnableConfigurationProperties(RedisProperties.class) //添加注解 激活配置属性
    public class RedisAutoConfiguration {
    ....
        @Bean
         public Jedis jedis() {
            return new Jedis("localhost", 6379);
        }
    }
    ```
    
  - ##### 添加配置文件

  - ```java
    @Configuration
    @EnableConfigurationProperties(RedisProperties.class)
    public class RedisAutoConfiguration {
    ....
        @Bean
        public Jedis jedis(RedisProperties redisProperties) {
            return new Jedis(redisProperties.getHost(), redisProperties.getPort());
        }
    }
    ```

- #### 创建spring.factories文件

  - #### 获取路径

    - ##### <font color='orange'>@SpringBootApplication</font> -> <font color='orange'>@EnableAutoConfiguration</font> -> <font color='cornflowerblue'>AutoConfigurationImportSelector</font> -> <font color='cornflowerblue'>selectImports方法下 **getAutoConfigurationEntry** </font> -> <font color='cornflowerblue'>getCandidateConfigurations</font> ->  <font color='red'>found in META-INF/spring.factories.</font> 

  - ####  内容

    - ##### <font color='orange'>@EnableAutoConfiguration </font>注解的全包名  = 自己定义的<font color='orange'>@Configuration</font>全包名

    - ```properties
      org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.yiwyn.redis.config.RedisAutoConfiguration
      ```

- #### 创建完成,只需要在别的包里导入<font color='cornflowerblue'>redis-spring-boot-starter</font> 包即可使用<font color='red'>jedis</font>的bean对象

  - ```xml
    <dependency> //导入坐标
        <groupId>com.yiwyn</groupId>
        <artifactId>redis-spring-boot-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    ```

  - ```java
    //使用
    Jedis jedis = context.getBean(Jedis.class);
    System.out.println(jedis);
    ```
  
- #### 完善自动配置条件

  - ##### Jedis 包在的时候自动加载  <font color='orange'>@ConditionalOnClass(Jedis.class)</font>

  - ##### 如果已经存在jedis的bean对象,则不创建  <font color='orange'>@ConditionalOnMissingBean(name = "jedis")</font>

  - ```java
    @Configuration
    @EnableConfigurationProperties(RedisProperties.class)
    @ConditionalOnClass(Jedis.class) //自动创建条件
    public class RedisAutoConfiguration {
    	....
        @Bean
        @ConditionalOnMissingBean(name = "jedis")  //已经存在则不创建
        public Jedis jedis(RedisProperties redisProperties) {
            return new Jedis(redisProperties.getHost(), redisProperties.getPort());
        }
    }
    ```

    

