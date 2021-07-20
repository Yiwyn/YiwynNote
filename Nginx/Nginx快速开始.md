## Nginx快速开始

- #### 优点

  - ##### 反向代理

  - ##### 负载均衡

  - ##### 动静分离

- #### 官网	[nginx: download](http://nginx.org/en/download.html) 

- #### 启动方式

  - ##### 双击(会一闪而过)

  - ##### <font color='red'>cmd</font>在控制台中使用 

- #### 访问 <font color='cornflowerblue'>localhost </font>跳转nginx的欢迎页面,说明打开成功





#### 访问端口号可以在 <font color='fuchsia'>../nginx-1.20.1/conf/nginx.conf</font> 中修改









#### Linux安装 

- ##### 官网下载Linux下使用的包.

- ##### 在linux解压并进入文件夹

- ##### 首先执行 <font color='red'>configure </font>程序自动配置文件

  - ```shell
    checking for C compiler … not found
    
    ./configure: error: C compiler cc is not found
    //程序报错
    ```

  - ##### 处理方案,缺少环境变量,需要安装<font color='fuchsia'>gcc</font> 和 <font color='fuchsia'>gcc-c++</font> 

    - ```shell
      yum -y install gcc
      yum -y install gcc-c++
      ```

  

  

  - ```shell
    ./configure: error: the HTTP rewrite module requires the PCRE library.
    You can either disable the module by using --without-http_rewrite_module
    option, or install the PCRE library into the system, or build the PCRE library
    statically from the source with nginx by using --with-pcre= option.
    //出现如下错误,缺少openssl-devel
    ```

  - ##### 处理方案,安装openssl-devel

    - ```shell
      yum -y install openssl openssl-devel
      ```



- ##### 执行<font color='red'>make</font>命令

- ##### 执行<font color='red'>make install</font>手动安装

- ##### 使用命令 <font color='red'>whereis nginx</font> 查询安装位置

- ##### 前往安装位置运行程序

  - ##### 执行文件位于 <font color='cornflowerblue'>sbin</font>文件夹下

  - ##### 执行<font color='cornflowerblue'>sbin</font> 文件夹下的<font color='red'>nginx</font> 

  - ##### 没有报错 则代表访问成功



- ##### 常用命令

  - ```shell
    ps -ef|grep nginx //查到进程号
    ```

  - ```shell
    kill -9 nginx进程号  //杀死进程
    ```

  - ```shell
    //在文件夹中
    ./nginx -s stop //强制退出
    ./nginx -s quit //安全退出
    
    ./nginx -s reload //重新加载配置文件  //常用命令
    
    ```

    

