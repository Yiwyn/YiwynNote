官网链接  https://logback.qos.ch/manual/layouts.html#coloring


在文本输出中 使用语法 %xx(需要变色的内容) 来进行文字着色

如： %red(这是一个错误信息)

```xml
<configuration debug="true">
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <withJansi>true</withJansi>
    <encoder>
      <pattern>[%thread] %highlight(%-5level) %cyan(%logger{15}) -%kvp -%msg %n</pattern>
    </encoder>
  </appender>
  <root level="DEBUG">
    <appender-ref ref="STDOUT" />
  </root>
</configuration>
```
```xml
<!-- property可以作为kv形式定义呢内容，在使用的时候仅需${}即可 -->
<property name="log.pattern" value="%d{HH:mm:ss.SSS} [%highlight(%thread)] %highlight(%-5level) %logger{20} - [%blue(%method),%line] - %msg%n" />

<encoder>
	<pattern>${log.pattern}</pattern>
</encoder>

```

 

