

### <font color='red'>高级用法参考官方</font>[高级用法 | Apache Dubbo](https://dubbo.apache.org/zh/docs/advanced/)



<hr>



## <font color='red'>序列化</font>

- ##### 两个服务直接传输数据(<font color='cornflowerblue'>封装好的类</font>),需要先把数据通过<font color='red'>序列化</font>转换为<font color='cornflowerblue'>流</font>的形式

- ##### 即使两个服务中都导入了封装好的类(数据),还是需要实现接口<font color='cornflowerblue'>Serializable</font>来序列化这个类

- ##### 序列化之后的类才可以通过 提供者发出 消费者 接收并使用



<hr>



## <font color='red'>地址缓存</font>

- ##### 注册中心服务挂了,服务仍然可以继续进行正常使用.

- ##### dubbo服务在消费者进行第一次调用时,会将服务提供者地址缓存到本地,以后调用的时候不会再访问注册中心.

- ##### 当服务提供者地址发生变化时,注册中心会通知服务消费者



<hr>



## <font color='red'>超时与重试</font>

- ##### 服务消费者在调用服务提供者的时候发生了<font color='red'>阻塞</font>,<font color='red'>等待</font>的情形.服务消费者会一直<font color='red'>等待</font>下去.

- ##### 在某个峰值时刻,大量的请求同时请求服务消费者,会造成线程的大量堆积,势必造成崩溃

- ##### dubbo 利用超时机制来解决这个问题,设置一个超时时间,在这个时间段内,无法完成服务访问,则自动断开连接.

- ##### 可以在使用注解的时候添加参数 <font color='cornflowerblue'>timeout</font> 

  - ```java
    //dubbo服务提供者注解 超时示例
    @Service(timeout = 3000) //超时时间3s
    public class UserServiceImpl implements UserService {
    }
    ```

  - ##### 服务提供者<font color='orange'>(@Service</font>)和服务消费者(<font color='orange'>@Reference</font>)都可以设置<font color='cornflowerblue'>timeout</font>参数,将来建议设置在<font color='red'>服务提供方</font>.

- ##### 出现网络波动,则这一次的请求就会失败.Dubbo提供重试机制来避免类似的问题发生.

- ##### 通过<font color='cornflowerblue'>retries</font>参数来设置重试次数.默认为2次

  - ```java
    //dubbo服务提供者注解 超时 和 重试次数 示例 
    @Service(timeout = 3000,retries = 3)
    public class UserServiceImpl implements UserService {
    }
    ```

    



<hr>



## <font color='red'>多版本</font>

- ##### 服务提供者在注解时可以添加<font color='cornflowerblue'>version</font>参数来设置版本

  - ```java
    //服务提供者设定version参数
    @Service(version = "1.1")
    public class UserServiceImpl implements UserService {
    }
    ```

- ##### 服务消费者在调用是可以根据<font color='cornflowerblue'>version</font>获取对应的服务提供者

  - ```java
    //服务消费者调用版本为1.1 的服务提供者
    @Reference(version = "1.1")
       UserService userService;
    ```





<hr>



## <font color='red'>负载均衡</font>

- ##### 服务提供者权重设置参数<font color='cornflowerblue'>weight</font> 

  - ```java
    @Service(weight = 100)
    public class UserServiceImpl implements UserService {
    }
    ```

- ##### 服务消费者加载策略参数<font color='cornflowerblue'>loadbalance</font> 

  - ```java
        @Reference(loadbalance = "random")  //这里的参数为负载均衡策略
        UserService userService;
    ```

    

- ##### 负载均衡策略

  - ###### <font color='red'>random</font>:按权重随机.
  
  - ###### <font color='red'>roundrobin</font>:按权重轮询 Round Robin
  
  - ###### <font color='red'>leastactive</font>:最少活跃调用数,相同活跃数随机 Least Active
  
  - ###### <font color='red'>consistenthash</font>:一致的Hash,相同参数的请求总是发到同一提供者 Consistent Hash





<hr>



## <font color='red'>集群容错</font>

- ##### 为了避免服务消费者调用集群中的某一个服务提供者出错

- ##### 设置集群容错的在<font color='orange'>@Reference </font>中设置参数 <font color='cornflowerblue'>cluster</font> 

  - ```java
     @Reference(cluster = "failover")
        UserService userService;
    ```

    

- ##### 集群容错的模式

  - ###### <font color='red'>failover Cluster</font>:失败重试,默认值.出现失败,重试其他的服务器,默认两次,使用参数<font color='cornflowerblue'>retries</font>配置,一般用于<font color='fuchsia'>读</font>操作

  - ###### <font color='red'>failfast Cluster</font>:快速失败,只发起一次调用,失败立即报错,通常适用于<font color='fuchsia'>写</font>操作

  - ###### <font color='red'>failsafe Cluster</font>:失败安全,出现异常时,直接忽略,返回一个空结果.

  - ###### <font color='red'>failback Cluster</font>:失败自动恢复,后台记录失败请求,定时重发.

  - ###### <font color='red'>forking Cluster</font>:并行调用多个服务器,只要一个成功就返回.

  - ###### <font color='red'>broadcast Cluster</font>:广播所有的服务提供者,逐个调用,任意出现一台报错则报错.





<hr>



