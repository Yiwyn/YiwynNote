## <font color='red'>SpringBoot 集成 Redis</font>



- #### <font color='cornflowerblue'>pom文件</font>

  ```xml
          <!--     redis本体-->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-data-redis</artifactId>
          </dependency>
          <!--    redis 连接池-->
          <dependency>
              <groupId>org.apache.commons</groupId>
              <artifactId>commons-pool2</artifactId>
          </dependency>
  ```

- #### <font color='cornflowerblue'>Application</font>

  ```yaml
  spring:
    redis:
      host: localhost
      port: 6379
      #    超时时间
      timeout: 10000ms
      #    数据库
      database: 0
      lettuce:
        pool:
          # 最大连接数
          max-active: 1024
          # 最大连接阻塞时间 默认-1
          max-wait: 10000ms
          # 最大空闲连接
          max-idle: 200
          # 最小空闲连接
          min-idle: 5
  ```

- #### <font color='cornflowerblue'>Config</font>

  ```java
  //序列化操作
  
  @Configuration
  public class RedisConfig {
  
      @Bean
      public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
          RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
          //Stirng类型 key 序列器
          redisTemplate.setKeySerializer(new StringRedisSerializer());
          //String类型 value 序列器
          redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
  
          //Hash类型 key 序列器
          redisTemplate.setHashKeySerializer(new StringRedisSerializer());
          //Hash类型 Value序列器
          redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
          redisTemplate.setConnectionFactory(connectionFactory);
          return redisTemplate;
      }
  }
  ```
  
  - ##### <font color='red'>StringRedisSerializer</font> : key value 为字符串的场景，将数据字节序列编码为字符串
  
  - ##### <font color='red'>GenericJackson2JsonRedisSerializer</font> ：javaBean实例序列化为json格式保存





> #### 方法归纳
>
> [【深入浅出SpringBoot】RedisTemplate使用方法归纳 - 简书 (jianshu.com)](https://www.jianshu.com/p/0fa4c100e9a9)



