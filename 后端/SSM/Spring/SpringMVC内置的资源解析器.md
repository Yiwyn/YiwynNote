#### SpringMVC内置的资源解析器 - InternalResourceViweResolver



#### 	配置方法:

###### 			在<font color='red'>**spring-mvc.xml**</font>中重写InternalResourceViewResolver

​			

```xml
 <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="suffix" value=".jsp"/>
        <property name="prefix" value="/"/>
    </bean>
```



##### 资源解析的时候,注解 RequestMapping的方法返回的<font color='red'>资源信息</font>自动添加<font color='cornflowerblue'>suffix</font>后缀 <font color='cornflowerblue'>prefix</font> 前缀

##### 

#### 这样我们的Controller类中的映射方法返回的信息会自动添加前缀和后缀

