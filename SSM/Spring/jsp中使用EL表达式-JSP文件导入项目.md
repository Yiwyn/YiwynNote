## jsp中使用EL表达式的坑

##### 在项目中使用EL表达式,需要保证<font color='red'>**web.xml**</font>文件的版本在2.5以上,否则系统将默认<font color='orange'>isELIgnored</font> 属性为true,这样就忽略了EL表达式



### <font color='cornflowerblue'>解决方案</font>

###### 替换系统生成的web.xml文件中<web-app>中的属性

```xml
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         id="WebApp_ID" version="2.5">
         
</web-app>
```



如上所示即可