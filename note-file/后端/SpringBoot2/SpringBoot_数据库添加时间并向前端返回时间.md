###### 在SpringBoot中,后端的数据发送到前端,系统默认会使用jackson转换为json.这时候后端的时间会被按时区处理.

###### 这个时候需要我们自行的设置时区,格式

#### 配置文件

```yaml
jackson:
    time-zone: GMT+8
    date-format: yyyy-MM-dd HH:mm:ss
```



#### 时间参数

```java
 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
```





