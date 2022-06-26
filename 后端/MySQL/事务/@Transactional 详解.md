## @Transactional 详解



- #### 添加位置

  - ##### 接口<font color='red'>实现类</font>或接口<font color='red'>实现方法</font>上。

  - ##### 访问权限，<font color='red'>public</font>才会起作用。 @Transcational 注解只能被应用到public方法上，这是由AOP性质决定的。

- #### 错误使用

  - ##### 接口中A、B两个方法，A无@Transcational注解，B有 ，通过A间接调用B,事务不生效

  - ##### 接口中异常被捕获而没有被抛出

    - ##### 默认情况下，<font color='orange'>@Transcation</font>注解会回滚 <font color='red'>RuntimeException</font>和<font color='red'>error</font> ，若出现了非运行时报错则不会进行回滚。

    - <img src="@Transactional%20%E8%AF%A6%E8%A7%A3.assets/1416523-20180716145710583-1342649521.png" alt="img" style="zoom: 67%;" />

  - ##### 多线程下事务因为线程不属于spring托管，故线程的方法不被事务控制。





- #### 事务的传播行为

  - ##### TranscationDefinition.PROPAGATION_REQUIRED;

    - ###### 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个事务。这是默认值。

  - ##### TranscationDefinition.PROPAGATION_REQUIRED_NEW;

    - ###### 创建一个新的事务，如果当前存在事务，则把当前事务挂起。

  - ##### TranscationDefinition.PROPAGATION_SUPPORTS;

    - ###### 如果当前存在事务，则加入该事务，如果当前没有事务，则以非事务的方式继续进行。

  - ##### TranscationDefinition.PROPAGATION_NOT_SUPPORTED;

    - ###### 以非事务方式运行，如果当前存在事务，则把当前事务挂起。

  - ##### TranscationDefinition.PROPAGATION_NEVER;

    - ###### 以非事务方式运行，如果当前存在事务，则抛出异常

  - ##### TranscationDefinition.PROPAGATION_MANDATORY;

    - ###### 如果当前存在事务，则加入该事务，如果当前不存在事务，则抛出异常。

  - ##### TranscationDefinition.PROPAGATION_NESTED;

    - ###### 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行

    - ###### 如果当前没有事务，则该取值等价于TranscationDefinition.PROPAGATION_REQUIRED