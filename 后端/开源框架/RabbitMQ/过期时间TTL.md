## <font color='red'>过期时间TTL</font>



- #### 概念

  - ##### 过期时间TTL表示可以对消息设置预期的时间，在这个时间内都可以被消费者接收获取，过了时间之后消息将自动被删除，RabbitMQ可以对 <font color='red'>消息和队列</font> 设置TTL。



- #### 设置TTL

  - ##### <font color='orange'>队列设置过期时间</font>

    - ##### web页面设置Message TTL

    - ##### Code

      ```java
          @Bean
          public Queue queue() {
              Map argment = new HashMap();
              argment.put("x-message-ttl", 6000);  //这里设置的时间为毫秒，且该值为int类型
              return new Queue("email-queue", false, false, false, argment);
          }
      ```

  - ##### <font color='orange'>消息设置过期时间</font>

    - ##### Code

      ```java
          public String sendMessage(String routingName) {
              Map data = new HashMap();
              data.put("uuid", UUID.randomUUID());
              data.put("data", "Hello I am Cortana");
              //实现消息处理接口
              MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
                  @Override
                  public Message postProcessMessage(Message message) throws AmqpException {
                      message.getMessageProperties().setExpiration("5000");
                      return message;
                  }
              };
              rabbitTemplate.convertAndSend("exchange", routingName, data, messagePostProcessor);
              return "success";
          }
      ```

      



