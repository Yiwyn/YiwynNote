#### 在applicationContext.xml中，加载priperties文件需要以下步骤 



beans 标签添加属性：context

```xml
xmlns:context="http://www.springframework.org/schema/context"
```

```xml
http://www.springframework.org/schema/context  http://www.springframework.org/schema/context/spring-context.xsd"
```

源文件：context的导入方式可以是已经有的文件修改关键词。 beans --> context

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation=
               "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/context  http://www.springframework.org/schema/context/spring-context.xsd">
```



#### 导入文件

```xml
<context:property-placeholder location="classpath:druid.properties"/>
```



##### 导入properties文件后，applicationContext.xml文件中已经存在了相关的key值

##### 使用el表达式即可以取出对应的value

**一个简单的例子**

```xml
 <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${druid.driverClassName}"/>
        <property name="url" value="${druid.url}"/>
        <property name="username" value="${druid.username}"/>
        <property name="password" value="${druid.password}"/>
    </bean>
```





## 注

<hr>

properties文件有一定的格式要求。

**key**值必须为**xxx.xxx**的形式

###### 如下

```xml
druid.driverClassName=com.mysql.jdbc.Driver 
druid.url=jdbc:mysql://127.0.0.1:3306/goods
druid.username=root
druid.password=root
// 以上元素可以被识别

//以下元素不可以别设别，编译出现错误
initialSize=5
maxActive=10
maxWait=3000
```

