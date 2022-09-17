## <font color='red'>SpringCloud 快速开始</font>



- #### IDEA中创建空项目。空项目下创建各个服务（每个服务为单独的<font color='cornflowerblue'>SpringBoot</font>项目）

- #### 服务拆分之后每个服务是独立的，所以，不同的服务之间通信依靠<font color='orange'>controller</font>暴露出的接口

  - ##### 要求controller 按照RESTful风格书写请求

- #### spring中提供了<font color='red'>RestTempkate</font>模板发送http请求

  ```java
      @Bean
      public RestTemplate restTemplate() {
          return new RestTemplate();
      }
  ```

  - ##### 在配置类中注册 restTemplate 的bean 

- #### 在案例中使用restTemplate

  ```java
  @Service
  public class OrdersService {
      @Autowired
      OrderMapper orderMapper;
  
      @Autowired
      RestTemplate restTemplate;
  
      public Orders getOrderById(int id) {
          Orders orders = orderMapper.selectById(id);
          String url = "http://localhost:8081/user/" + orders.getUserId();
          User user = restTemplate.getForObject(url, User.class);
          orders.setUser(user);
          return orders;
      }
  }
  ```

### <font color='red'>注</font>：

##### 	当我们的实体类中的参数在mybatisplus中不参与select查询时，可以使用注解 进行约束

```java
    @TableField(select = false)
    private User user;
```

