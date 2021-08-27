## <font color='red'>Node.js 简介</font>



- #### Node.js是一个能够在服务器端运行JavaScript的开放源代码、跨平台JavaScript运行环境。

- #### Node.js是一个<font color='red'>单线程</font>的服务器，但是在其后台有一个I/O线程池（传统的服务器是多线程的）







## <font color='red'>Node的用途</font>



- #### Web服务API，比如REST

- #### 实时多人游戏

- #### 后端的web服务，例如跨域、服务器的请求

- #### 基于web的应用

- #### 多客户端的通信，如即时通讯







## <font color='red'>Node.js安装</font>



- ##### 创建 node ⽂件夹并进⼊ 

- ##### 将 Node 的安装包解压

```shell
[root@localhost node]# tar -xJvf node-v12.16.3-linux-x64.tar.xz
```

- ##### 解压完之后， /usr/local/node ⽬录中会出现⼀个 ==node-v12.16.3-linux-x64== 的⽬录

##### 

- #### <font color='red'>配置环境变量</font>

  - ##### 编辑 <font color='cornflowerblue'>~/.bash_profile</font> ⽂件，在⽂件末尾追加如下信息：

    ```properties
    # Nodejs
    export PATH=/usr/local/node/node-v12.16.3-linux-x64/bin:$PATH
    ```

- ##### 刷新环境变量

  ```shell
  source ~/.bash_profile
  ```

- ##### 检测安装结果

  - ##### node -v 

  - ##### npm version 

  - ##### npx -v







