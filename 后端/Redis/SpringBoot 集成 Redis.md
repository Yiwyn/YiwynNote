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
      @SuppressWarnings("all")
      public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
  
          RedisTemplate<String, Object> template = new RedisTemplate<>();
          template.setConnectionFactory(factory);
  
          Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = this.jackson2JsonRedisSerializer();
  
          //String序列化
          StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
          //key采用string的序列化方式
          template.setKeySerializer(stringRedisSerializer);
          //hash的key采用string的序列化方式
          template.setHashKeySerializer(stringRedisSerializer);
          //value序列化也采用jackson
          template.setValueSerializer(jackson2JsonRedisSerializer);
          //hash的value也采用jackson
          template.setHashValueSerializer(jackson2JsonRedisSerializer);
          template.afterPropertiesSet();
  
          return template;
      }
  
      /**
       * 自定义jackson2JsonRedisSerializer对象
       *
       * @return
       */
      private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
          Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
                  new Jackson2JsonRedisSerializer<>(Object.class);
  
          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
          objectMapper.configure(MapperFeature.USE_ANNOTATIONS, false);
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
          // 此项必须配置，否则会报java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to XXX
          objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL
                  , JsonTypeInfo.As.PROPERTY);
          objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
          jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
          return jackson2JsonRedisSerializer;
      }
  
  
  }
  
  ```
  
  - ##### <font color='red'>StringRedisSerializer</font> : key value 为字符串的场景，将数据字节序列编码为字符串
  
  - ##### <font color='red'>GenericJackson2JsonRedisSerializer</font> ：javaBean实例序列化为json格式保存







> #### 方法归纳
>
> [【深入浅出SpringBoot】RedisTemplate使用方法归纳 - 简书 (jianshu.com)](https://www.jianshu.com/p/0fa4c100e9a9)






- ### <font color='red'>注</font>

  - #### <font color='cornflowerblue'>redis</font> 保存的对象，字段需要<font color='orange'>get</font>、<font color='orange'>set</font>方法，同时需要一个<font color='orange'>无参的构造函数</font>。否则redis处理对象的时候无法解析
