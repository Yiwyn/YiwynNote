## <font color='red'>GateWay常用的Predicate</font>





- #### The After Route Predicate Factory

  - ##### 设置时间之后才能访问

- #### The Before Route Predicate Factory

  - ##### 设置时间之前才能访问

- #### The Between Route Predicate Factory

  - ##### 设置时间之内才能访问

    ```yaml
    spring:
      cloud:
        gateway:
          routes:
          - id: between_route
            uri: https://example.org
            # 两个时间点之间
            predicates:
            - Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]
    ```

- #### The Cookie Route Predicate Factory

  - ##### 携带Cookie

    ```yaml
    spring:
      cloud:
        gateway:
          routes:
          - id: cookie_route
            uri: https://example.org
            predicates:
            - Cookie=chocolate, ch.p
    ```

  - ##### 需要两个参数 Cookie名字 key和 值的正则表达式  -cookie "key=value"

- #### The Header Route Predicate Factory

  - ```yaml
    spring:
      cloud:
        gateway:
          routes:
          - id: header_route
            uri: https://example.org
            predicates:
            - Header=X-Request-Id, \d+
    ```

  - ##### 带有请求头  两个参数 key,value  -H "key:value"

- #### The Host Route Predicate Factory

- #### The Method Route Predicate Factory

- #### The Path Route Predicate Factory

- #### The Query Route Predicate Factory

- #### The RemoteAddr Route Predicate Factory

- #### The weight Route Predicate Factory





<hr>



### <font color='red'>使用方法</font>

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: after_route
        uri: https://example.org
        predicates:
        # 这个时间后才能起效
        - After=2017-01-20T17:42:47.789-07:00[America/Denver]
```

- ##### 添加断言匹配全部为true才能访问



<hr>



## <font color='red'>注</font>



#### 获取时间方法

```java
public class GetTime {
    public static void main(String[] args) {
        
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        //2021-11-14T16:21:02.903+08:00[GMT+08:00]
    }
}
```

