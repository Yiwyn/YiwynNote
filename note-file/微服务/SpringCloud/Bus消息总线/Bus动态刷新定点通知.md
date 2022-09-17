## <font color='red'>Bus动态刷新定点通知</font>



#### 在 <font color='fuchsia'>消息总线设计</font> 中已经实现了 post请求刷新config服务端来刷新全部客户端，现在需求需要指定某一个通知



- ### 公式：

  ```http
  http://localhost:配置中心端口号/actuator/bus-refresh/{destination}
  ```

  - #### config服务刷新请求不再发送到具体的服务实例上，而是发给config-server并通过destination参数类指定需要更新配置的服务或者实例

  ```shell
  curl -X POST "http://localhost:3344/actuator/bus-refresh/student-service:8081
  ```

  - ##### <font color='red'>destination</font>参数：

    - ##### 在eureka中注册的服务名字（本质上使用config客户端也是注册在eureka服务上的）

    - ##### 使用eureka服务名字并添加端口号（如上例）