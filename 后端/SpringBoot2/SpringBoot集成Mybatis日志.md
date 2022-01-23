### 配置项目



```yml
mybatis:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

只需要重写 <font color='red'>log-impl </font>系统会匹配SpringBoot框架中包含的日志实例框架 SpringBoot默认为logback 

