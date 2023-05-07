## SpringCloud Gateway 

<br>

application.yml
```yml
spring:
  cloud:
    gateway:
      globalcors:
        cors-configurations:
          '[/**]':
            allowCredentials: true
            allowedOriginPatterns:
              - "*"
            allowedMethods: "*"
            allowedHeaders: "*"
        add-to-simple-url-handler-mapping: true

      default-filters:
        - DedupeResponseHeader=Vary Access-Control-Allow-Credentials Access-Control-Allow-Origin, RETAIN_UNIQUE
        - DedupeResponseHeader=Access-Control-Allow-Origin, RETAIN_FIRST

```

在gateway的跨域方案中，由于网关本身需要跨域，转发的服务也可能有跨域方案。这会导致response头 key重复。
添加 <b>default-filters</b>  DedupeResponseHeader 过滤器可以将重复的key删除 <br> 
详见：https://docs.spring.io/spring-cloud-gateway/docs/3.1.7-SNAPSHOT/reference/html/#the-deduperesponseheader-gatewayfilter-factory