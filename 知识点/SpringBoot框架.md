## <font color='red'>Starter执行原理</font>



- ### SpringBoot启动的时候会去扫描jar包中一个名为spring.factories 的文件

- ### 根据文件中的配置，配置文件格式未key = value ，value中配置了很多Spring加载的类

- ### Spring会加载这些自动配置类，Spring 读取后，就会创建这些类的对象，放到Spring 容器中，后期就会从Spring 容器中获取这些对象。





</br> <hr> </br>





## <font color='red'>SpringBoot运行原理分析</font>



- ### SpringApplication类的作用和run()方法作用

  - #### SpringApplication 这个类整个其他框架的启动类，只要运行这一个类，所有的整合都完成了。

  - #### 调用run函数，将当前启动类的字节码传入（主要目的是传入@SpringBootApplication 这个注解），以及main函数的args 参数。

  - #### 通过获取当前启动类的核心信息，创建IOC容器。



