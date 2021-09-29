### <font color='red'>Spring的IOC和AOP机制</font>



- #### IOC 控制反转

  - ##### 创建对象的控制权的转移。过去创建对象的主动权和时机都是自己把控的，而现在这种权力转移到了Spring容器中，并由容器根据配置文件去创建实例和管理各个实例之间的依赖关系，对象与对象之间松散耦合，也利于功能的复用。

  - ##### 最直观的表现是对象的创建不用去new了，可以由spring根据我们提供的配置文件自动生产，我们需要对象的时候，直接从spring容器中获取即可。

  - #### <font color='red'>DI 依赖注入</font>

    - ##### 和<font color='orange'>控制反转</font>时同一个概念的不同角度的描述，即应用程序在运行时依赖IOC容器来动态注入对象需要的外部资源。

- #### AOP 面向切片编程

  - ##### 作为面向对象的一种补充，用于将那些与业务无关，但却对多个对象产生影响的公共行为和逻辑，抽取并封装为一个可重用的模块，这个模块命名为 切面（Aspect）。 SpringAOP使用的动态代理，所谓的动态代理就是说AOP框架不会去修改字节码，而是每次运行时在内存中临时为方法生成一个AOP对象，这个AOP对象包含了目标对象的全部方法，并且在特点的点做了增强处理，并回调回对象的方法。





<hr>



### <font color='red'>Spring的生命周期</font>



- #### 实例化一个Bean对象

- #### 按照Spring上下文对实例化的Bean进行配置，也就是IOC注入

- #### 根据Bean实现或者关联的一些接口，调用一些方法

- #### 以上工作完成就可以使用这个Bean了，这个Bean是一个single的。

- #### 当Bean不再需要时，会进行清理阶段，如果bean实现了DisposableBean接口，会调用其实现的destory方法。





<hr>



### <font color='red'>框架中使用了什么设计模式</font>



- #### 工厂模式：BeanFactory就是工厂模式的体现，用来创建对象的实例

- #### 单例模式：对象默认为单例模式

- #### 代理模式：AOP会用到JDK的动态代理和CGLIB字节码生成技术

- #### 模板方法：用来解决代码重复的问题。例如xxxTemplate

- #### 观察者模式：Listener 的实现。





<hr>





### <font color='red'>Spring事务的实现方式和实现原理</font>



- #### Spring事务的本质其实就是数据库对事务的支持，没有数据库的事务支持，spring是无法提供事务功能的，真实的数据库层的事务提交和回滚是通过binlog 或者 redo log实现的。

- #### <font color='red'>实现事务的两种方法</font>

  - #### 编程式：beginTransaction(),commit(),rollback()等事务管理相关的方法

  - #### 声明式：利用注解 Transactional 或者aop配置





<hr>



### <font color='red'>Spring的对象默认式单例吗？单例Bean存不存在线程安全问题</font>



- #### Spring中的对象默认式单例模式

- #### 单例Bean对象对应的类存在柯柏年的成员变量并且七张存在改变这个变量的线程时，多线程操作该Bean对象时会出现线程安全问题。

- #### <font color='red'>解决方案</font>

  - #### 在bean中避免可变成员变量

  - #### 在bean中定义一个ThreadLocal成员变量，将需要可变成员变量保存在ThreadLocakl中

    - #### ThreadLocal类时jdk提供的，如果创建了一个Threadlocal类型的变量，那么访问这个变量的每个线程都会由这个变量的一个副本，在实际多线程操作中，操作的是自己本地内存中的变量。





<hr>





### <font color='red'>SpringMVC 主要组件</font>



- #### 前端控制器 DispatcherServlet ： 接收请求、相应结果、相当于转发器。

- #### 处理器映射器 HandleMapping ： 根据请求的URL来查找Handle

- #### 处理器映射器 handleAdapter   ： 负责执行Handle

- #### 视图解析器 viewResover ： 进行视图的解析，根据视图逻辑名将ModelAndView 解析成为真正的视图 view

- #### 视图 View ：支持不同的视图类型 jsp 等 