## <font color='red'>GatewayFilter </font>



- #### 路由过滤器可以用于修改进入的HTTP请求和返回的HTTP相应，路由过滤器只能指定路由进行使用

- #### Spring Cloud Gateway 内置了多种路由过滤器，他们都由GatewayFilter的工厂类来产生






## <font color='red'>Gateway种类</font>



- ### GatewayFilter

  - ##### [Spring Cloud Gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#gatewayfilter-factories) 官方文档，使用可以参考Predicate

- ### GlobalFilter

  - #### 两个主要接口

    - #### GlobalFilter

    - #### Ordered

    - #### <font color='red'>Code</font>

      ```java
      @Component
      public class MyGatewayFilter implements GlobalFilter, Ordered {
      
      
          @Override
          public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
              String uname = exchange.getRequest().getQueryParams().getFirst("uname");
              if (uname == null) {
                  System.out.println("用户名为null");
                  exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
                  return exchange.getResponse().setComplete();
              }
              return chain.filter(exchange);
          }
      
          //    优先级的顺序，数字越小 优先级越高
          @Override
          public int getOrder() {
              return 0;
          }
      }
      ```

      - ##### 这里直接访问会出现错误

      - ```http
        http://localhost:9527/student/user/1?uname=nihao
        ```

        - ##### 	携带uname参数则不会出错

        

  - #### 同一网关权鉴

