### SpringBoot实现邮件服务



- #### 导入依赖

  ```xml
          <dependency>
              //mail服务
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-mail</artifactId>
          </dependency>
  			
          <dependency>
              //模板服务
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-thymeleaf</artifactId>
          </dependency>
  ```



- #### 基本邮箱发送

  ```java
      @Autowired
      private JavaMailSender javaMailSender;
  
      public void SendEmail() {
          SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
          simpleMailMessage.setFrom("13361135909@163.com");
          simpleMailMessage.setTo("5597104@qq.com");
          simpleMailMessage.setSubject("Java技术栈投稿");
          simpleMailMessage.setText("技术分享");
          javaMailSender.send(simpleMailMessage);
      }
  
  ```





- #### 模板邮箱发送

  ##### html模板

  ##### <font color='cornflowerblue'>src/main/resources/templates/email.html</font> 

  ```html
  <html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
      <meta charset="UTF-8">
      <title>邮件</title>
  </head>
  <body>
  <div>邮箱激活</div>
  <div>您的注册信息是：
      <table border="1">
          <tr>
              <td>用户名</td>
              <td th:text="${username}"></td>
          </tr>
      </table>
  </div>
  </body>
  </html>
  ```

  

  ##### code

  ```java
      @Autowired
      private JavaMailSender javaMailSender;
  
      @Autowired
      private TemplateEngine templateEngine; 
  
  public void SendTemaplateEmail() throws MessagingException {
  		
          MimeMessage mimeMessage = javaMailSender.createMimeMessage();
          MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
  
          mimeMessageHelper.setFrom("13361135909@163.com");
          mimeMessageHelper.setTo("5597104@qq.com");
          mimeMessageHelper.setSubject("Java技术栈投稿");
  			
          //设置模板参数
          Context context = new Context();
          context.setVariable("username", "yiwyn");
  
          String content = templateEngine.process("email.html", context);
          mimeMessageHelper.setText(content, true);
          javaMailSender.send(mimeMessage);
      }
  ```

  