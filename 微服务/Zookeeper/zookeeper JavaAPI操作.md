## <font color='red'>Curator 介绍</font>

- #### Curtor是Apache Zookeeper 的 Java 客户端

- #### 常见的Zookeeper Java API

  - ##### 原生java API

  - ##### ZkClent

  - ##### Curator

- #### Curator 项目的目标是简化Zookeeper 客户端的使用.

  - ##### 官网 [Apache Curator –](http://curator.apache.org/) 

  - ##### Curator 版本向下兼容

  

  

  

  <hr>

  

## <font color='red'>Curator API 常用操作</font>

- #### 建立连接

  - ```java
    //创建客户端对象
    //参数
    //客户端地址:端口
    //Session超时时间
    //连接超时时间
    //重试策略
    CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.3.115:2181", 60 * 1000, 15 * 1000, new 			RetryForever(1000));
    
    //开始连接
    client.start();
    ```

  - ```java
    //第二种创建方法
    CuratorFramework client = CuratorFrameworkFactory.builder().connectString("192.168.3.115:2181").
                    sessionTimeoutMs(15 * 1000).
                    connectionTimeoutMs(15 * 1000).
                    retryPolicy(new RetryForever(1000))
                    .namespace("yiwyn").build(); 		//操作会在yiwyn节点下进行.
            client.start();
    ```

    

  - ##### <font color='cornflowerblue'>CuratorFrameworkFactory.builder()</font> 创建方式是一个链式的创建方式,设置参数.最后使用<font color='cornflowerblue'>build()</font>方法创建连接对象,返回值如上相同.

    - ###### 使用<font color='cornflowerblue'>builder()</font>创建可以指定一个<font color='red'>namespace</font> ,这样后续操作会在namespace指定的节点下进行.

- #### 添加节点

  - ```java
    String s = client.create().forPath("/app1",[nodeData]);  //结合上下文↑ 是在yiwyn节点下,创建app1节点  当 nodeData为空时,系统默认设置为连接机器的ip地址
    ```

  - ```java
    //创建不同类型的节点 CreateMode 为枚举 
    client.create().withMode(CreateMode.EPHEMERAL).forPath("/app2", "Hello".getBytes(StandardCharsets.UTF_8));
    ```

  - ##### 添加连续节点  <font color='cornflowerblue'>creatingParentsIfNeeded()</font> 父节点不存在,则创建父节点.

- #### 查询节点

  - ##### 查询节点数据

    ```java
     byte[] bytes = client.getData().forPath("/app1");   	//查询节点app1的数据
    ```

  - ##### 查询子节点

    ```java
     List<String> strings = client.getChildren().forPath("/app1");   //联系上下文 查询yiwyn/app1下的子节点
    ```

  - ##### 查询节点状态

    ```java
     		stat = new Stat();							//系统封装的状态Bean
            byte[] bytes = client.getData().storingStatIn(stat).forPath("/app1");  
            System.out.println(new String(bytes));
            System.out.println(stat.getDataLength());    		//stat包含了大多数的数据信息
    ```

- #### 修改节点

  - ##### 直接修改

    ```java
     client.setData().forPath("/app1", "yiwyn".getBytes(StandardCharsets.UTF_8));
    ```

  - ##### 根据版本修改

    ```java
      stat = new Stat();
            byte[] bytes = client.getData().storingStatIn(stat).forPath("/app1");
            int version = stat.getVersion();
            client.setData().withVersion(version).forPath("/app1", "yiwyn".getBytes(StandardCharsets.UTF_8));
    ```

    - ###### 只有进行操作版本(<font color='red'>version</font>)才会更改,防止操作被更改

- #### 删除节点

  - ##### 删除节点,节点为空

    ```java
      client.delete().forPath("/app1");
    ```

  - ##### 删除节点,节点不为空

    ```java
    client.delete().deletingChildrenIfNeeded().forPath("/app1"); //删除指定节点,并且删除其子节点
    ```

  - ##### 必然成功的删除

    ```java
    client.delete().guaranteed().forPath("/app1");			//必然成功的删除,防止网络抖动
    ```

    



