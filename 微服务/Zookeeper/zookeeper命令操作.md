## <font color='red'>Zookeeper 数据模型</font>



- #### Zookeeper 时一个树形目录服务,其数据模型和unix的文件系统目录树很类似,拥有一个层次化结构.

- #### 每一个节点都被称为: <font color='cornflowerblue'>ZNode</font> ,每个节点上都会保存自己的<font color='fuchsia'>数据</font>和<font color='fuchsia'>节点信息</font>.

- #### 节点可以拥有子节点,同时允许少量(<font color='cornflowerblue'>1MB</font>)数据存储在该节点下.

- #### 节点可以分为四大类

  - ##### PERSISTENT  持久化节点

  - ##### EPHEMERAL 临时节点  : <font color='fuchsia'>-e</font>

  - ##### PERSISTENT_SEQUENTIAL 持久化顺序节点 : <font color='fuchsia'>-s</font>

  - ##### EPHEMERAL_SEQUENTIAL  临时顺序节点: <font color='fuchsia'>-es</font>

  

  

  

## <font color='red'>Zookeeper 客户端常用命令</font>



- #### 启动zookeeper目录下<font color='cornflowerblue'>bin</font>文件夹中的 <font color='red'>zkCli.sh</font> 文件

  - ##### ./zkCli.sh -server localhost:2181    <font color='cornflowerblue'>//客户端连接到服务端</font>

  - ##### 如果时连接本机的zkServer服务,可以直接 执行 <font color='red'>./zkCli.sh</font> 

- #### 常用命令

  - ##### <font color='red'>quit</font>	 退出 

  - ##### <font color='red'>ls </font>        查看目录下节点 

  - ##### <font color='red'>create NodePath [NodeData] </font>  创建节点,并且可以选择添加数据

    - ```shell
      create /app1 yiwyn
      ```

  - ##### <font color='red'>get NodePath</font> 获取节点数据

    - ```shell
      get /app1   ---///返回yiwyn
      ```

  - ##### <font color='red'>set NodePath NodeData</font>  设置节点数据

  - ##### <font color='red'>delete NodePath</font> 删除节点(只能删除空节点)

  - ##### <font color='red'>deleteall NodePath</font> 删除节点(包含子节点)

- #### 创建不同之类的节点

  - ##### 创建节点的时候添加参数

    - ###### <font color='red'>create -e NodePath</font> 创建一个临时节点

    - ###### <font color='red'>create -s NodePath</font> 创建一个顺序节点,创建完成系统会自动附带序号命名. 

