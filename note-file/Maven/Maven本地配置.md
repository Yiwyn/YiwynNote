#### 配置路径: conf/setting.xml

```xml
  <mirrors>
    <mirror>
      <id>aliyunmaven</id>
      <mirrorOf>*</mirrorOf>
      <name>aliyun maven</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
  </mirrors>


<profiles>
	<profile>
      <id>jdk-1.8</id>
      <activation>
        <activeByDefault>true</activeByDefault>
        <jdk>1.8</jdk>
      </activation>
      <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
      </properties>
	</profile>
</profiles>
```



##### 要配置14，包括7、8、9、10都一样，1.8什么的时JDK以前编号方式，不用管他，cmd命令查询java-version 查到多少版本号就是多少，但是要注意的是你的环境变量JAVA_HOME的路径名称要是带有你版本号的文件名称，比如你查到的版本号是14.0.1而JDK存放文件夹名字是JDK14，你的JAVA_HOME就要对应，在Maven中就要写14,就不能写14.0.1，不然提示非法版本还不通过，一切以环境变量为准，所以在文件夹命名时以版本号命名是十分必要的，总之来说，JDK文件对应Java环境变量，Java环境变量对应Maven配置版本
