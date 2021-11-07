## Docker 安装



- #### 镜像（image）：模板文件，可以通过模板创建容器服务，可以通过镜像创建多个容器

- #### 容器（container）：独立运行一个或者一组应用，通过镜像创建。

  - ##### 基本命令

    - ##### 启动、停止、删除等基本命令

- #### 仓库（repositroy）：存放镜像的地方，仓库分为共有仓库和私有仓库

  - ##### Docker Hub

  - ##### 阿里云 等都有容器服务器







### <font color='red'>安装Docker</font>



#### ---Docker官方文档 [Get Docker | Docker Documentation](https://docs.docker.com/get-docker/)



- ##### 卸载旧版本（如果有）

  - ```shell
     sudo yum remove docker \
                      docker-client \
                      docker-client-latest \
                      docker-common \
                      docker-latest \
                      docker-latest-logrotate \
                      docker-logrotate \
                      docker-engine
    ```

    

- ```shell
  yum install -y yum-utils
  ```

- ##### 设置镜像仓库

  ```shell
  yum-config-manager \
      --add-repo \
      https://download.docker.com/linux/centos/docker-ce.repo  //国外docker
  ```

- ##### 阿里云镜像安装

  ```shell
  # step 1: 安装必要的一些系统工具
  sudo yum install -y yum-utils device-mapper-persistent-data lvm2
  # Step 2: 添加软件源信息
  sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
  # Step 3
  sudo sed -i 's+download.docker.com+mirrors.aliyun.com/docker-ce+' /etc/yum.repos.d/docker-ce.repo
  # Step 4: 更新并安装Docker-CE
  sudo yum makecache fast
  sudo yum -y install docker-ce
  # Step 4: 开启Docker服务
  sudo service docker start
  
  #阿里云是全套的安装 下面记录仅为保证完整性
  ```

- ##### 安装docker相关 docker-ce 社区版

  ```shell
  #安装之前可以先升级yum索引
  sudo yum makecache fast
  
  #安装
  sudo yum install docker-ce docker-ce-cli containerd.io
  ```

- ##### 开启docker服务

  ```shell
  sudo systemctl start docker
  
  #docker version 可以查看docker版本状态
  ```

- ##### 测试Hello world

  ```shell
  sudo docker run hello-world
  ```

- ##### 查看下载docker镜像

  ```shell
  sudo docker images
  ```



- ##### 阿里云镜像加速

  - [容器镜像服务 (aliyun.com)](https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors) 





### <font color='red'>卸载Docker</font>



- ##### 移除Docker

  ```shell
  sudo yum remove docker-ce docker-ce-cli containerd.io
  ```

- ##### 删除目录

  ```shell
  sudo rm -rf /var/lib/docker
  sudo rm -rf /var/lib/containerd
  ```

  