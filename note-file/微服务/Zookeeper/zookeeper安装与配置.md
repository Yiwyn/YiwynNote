### Zookeeper官网 [Apache ZooKeeper](http://zookeeper.apache.org/)



<hr>



- ### <font color='red'>安装</font>

  - ##### 官网下载压缩包并解压就完成了安装



- ### <font color='red'>配置</font>

  - ##### 解压缩的文件夹中<font color='cornflowerblue'>conf</font>文件夹包含配置文件需要先配置

  - ##### 其中<font color='red'>zoo_sample.cfg</font>为配置模板,需要复制一个命名<font color='red'>zoo.cfg</font>文件,zoo.cfg 才是真正的配置文件

  - ##### 编辑(vim) zoo.cfg文件.可以设置默认配置.

    - ##### <font color='fuchsia'>dataDir </font>需要配置本地文件夹,可以自己创建文件夹.<font color='cornflowerblue'>(linux获取文件夹地址**pwd**)</font> 

- #### <font color='red'>启动和停止</font>(<font color='cornflowerblue'>linux</font>)

  - ##### 启动

    - ###### zookeeper 文件夹<font color='cornflowerblue'>bin</font>目录下 <font color='red'>zkServer.sh </font>文件

    - ###### ./zkServer.sh start       //开始命令

  - ##### 查看状态

    - ######  ./zkServer.sh status      //获取zookeeper 状态

  - ##### 停止

    - ###### ./zkServer.sh stop			//停止命令

