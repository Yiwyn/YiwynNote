```xml
   <groupId>fun.lifepoem</groupId>
    <artifactId>what-to-do-today</artifactId>
    <version>2022-7-11</version>
    <name>what-to-do-today</name>
    <description>what-to-do-today</description>
    <packaging>pom</packaging>  <-->本章的重点</-->
```

- #### pom

  - **打出来的可以作为其他项目的maven依赖，在工程A中添加工程B的pom，A就可以使用B中的类。用在父级工程或聚合工程中。用来做jar包的版本控制。**

  - ##### pom项目中没有代码，同时也不执行代码，<font color='red'>只是为了聚合工程和传递依赖用的</font>

- #### jar

  - ##### 内部调用或者作为服务使用

- #### war

  - ##### 需要部署的项目