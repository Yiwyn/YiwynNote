## <font color='red'>帮助命令</font>



```shell
docker version    #docker 的版本信息
docker info 	  #docker 的系统信息，包括镜像和容器的数量
docker 命令 --help #帮助命令
```

- ##### 官网帮助命令

  - [Use the Docker command line | Docker Documentation](https://docs.docker.com/engine/reference/commandline/cli/) 



> ##### docker 命令本身对参数顺序是敏感的 
>
> ##### 	例如 -p 映射端口的命令如果放在最后可能会被docker 理解为 启动镜像来处理的参数 
>
> ##### 	so  -p 参数应该在 -v 映射文件 -e 环境配置 之前





## <font color='red'>镜像命令</font>



##### docker iamges  查看镜像

```shell
#查询镜像
su docker images 

REPOSITORY    TAG       IMAGE ID       CREATED       SIZE
hello-world   latest    feb5d9fea6a5   4 weeks ago   13.3kB

#解释 
REPOSITORY 镜像的仓库源
TAG		   镜像的标签
IMAGE ID   镜像的ID
CREATED    镜像的创建时间
SIZE 	   镜像的大小

#可选项
-a --all   #列出所有镜像
-q --quiet #只显示镜像ID
```



##### docker search {xxx}  搜索镜像

```shell
#镜像查询
[root@localhost ~]# docker search mysql
NAME                              DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
mysql                             MySQL is a widely used, open-source relation…   11603     [OK]
mariadb                           MariaDB Server is a high performing open sou…   4414      [OK]
mysql/mysql-server                Optimized MySQL Server Docker images. Create…   857                  [OK]

#可选项
-f   #通过收藏来过滤

-f=STARS=3000  #搜索出的镜像的Stars的收藏是大于3000的

[root@localhost ~]# docker search mysql -f=STARS=3000
NAME      DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
mysql     MySQL is a widely used, open-source relation…   11603     [OK]
mariadb   MariaDB Server is a high performing open sou…   4414      [OK]

```



##### docker pull 下载镜像

```shell
#下载镜像 docker pull 镜像名[:tag]

[root@localhost ~]# docker pull mysql
Using default tag: latest    #不标识tag 默认最新版本
latest: Pulling from library/mysql
b380bbd43752: Pull complete   #分层下载，docker image 的核心 ，联合文件系统
f23cbf2ecc5d: Pull complete
30cfc6c29c0a: Pull complete
b38609286cbe: Pull complete
8211d9e66cd6: Pull complete
2313f9eeca4a: Pull complete
7eb487d00da0: Pull complete
4d7421c8152e: Pull complete
77f3d8811a28: Pull complete
cce755338cba: Pull complete
69b753046b9f: Pull complete
b2e64b0ab53c: Pull complete
Digest: sha256:6d7d4524463fe6e2b893ffc2b89543c81dec7ef82fb2020a1b27606666464d87
Status: Downloaded newer image for mysql:latest
docker.io/library/mysql:latest


#指定版本下载
[root@localhost ~]# docker pull mysql:5.7
5.7: Pulling from library/mysql
b380bbd43752: Already exists
f23cbf2ecc5d: Already exists
30cfc6c29c0a: Already exists
b38609286cbe: Already exists
8211d9e66cd6: Already exists
2313f9eeca4a: Already exists
7eb487d00da0: Already exists
a71aacf913e7: Pull complete
393153c555df: Pull complete
06628e2290d7: Pull complete
ff2ab8dac9ac: Pull complete
Digest: sha256:2db8bfd2656b51ded5d938abcded8d32ec6181a9eae8dfc7ddf87a656ef97e97
Status: Downloaded newer image for mysql:5.7
docker.io/library/mysql:5.7

#联合文件下载，共用的文件不再重新下载
```



##### docker rmi  删除镜像  rmi=<font color='red'>r</font>e<font color='red'>m</font>ove <font color='red'>i</font>mage

```shell
[root@localhost ~]# docker images

REPOSITORY    TAG       IMAGE ID       CREATED       SIZE
mysql         5.7       938b57d64674   9 days ago    448MB
mysql         latest    ecac195d15af   9 days ago    516MB
hello-world   latest    feb5d9fea6a5   4 weeks ago   13.3kB

#删除指定的ID
[root@localhost ~]# docker rmi -f  938b57d64674
Untagged: mysql:5.7
Untagged: mysql@sha256:2db8bfd2656b51ded5d938abcded8d32ec6181a9eae8dfc7ddf87a656ef97e97
Deleted: sha256:938b57d64674c4a123bf8bed384e5e057be77db934303b3023d9be331398b761
Deleted: sha256:d81fc74bcfc422d67d8507aa0688160bc4ca6515e0a1c8edcdb54f89a0376ff1
Deleted: sha256:a6a530ba6d8591630a1325b53ef2404b8ab593a0775441b716ac4175c14463e6
Deleted: sha256:2a503984330e2cec317bc2ef793f5d4d7b3fd8d50009a4f673026c3195460200
Deleted: sha256:e2a4585c625da1cf4909cdf89b8433dd89ed5c90ebdb3a979d068b161513de90

#删除多个容器
[root@localhost ~]# docker rmi -f 镜像ID 镜像ID ..

#删除全部镜像的思路
[root@localhost ~]# docker rmi -f $(docker images -aq)    #通过查询所有的ID进行删除
```





</br><hr></br>





## <font color='red'>容器命令</font>



##### 说明：有个镜像才可以创建容器

```shell
[root@localhost ~]# docker pull centos
```

##### 新建容器并启动

```shell
docker run [可选参数] image

#参数说明
--name="Name"  #容器名字
-d  		   #后台方式启动
-it			   #使用交互方式进行，进入容器查看内容
-p 			   #指定容器的端口 -p 
-P			   #随机指定端口


#测试
[root@localhost ~]# docker run -it centos /bin/bash   #启动并进入容器
[root@985b72e441e6 /]#

#退出容器
exit  #容器中退回主机
```

##### 追加启动参数

```shell
docker container update <containerId> ...

docker container myNginx --restart=always  //docker重启容器自动重启
```





##### docker ps 列出所有运行中的容器

```shell
[root@localhost ~]# docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

#列出历世运行的容器
[root@localhost ~]# docker ps -a
CONTAINER ID   IMAGE          COMMAND       CREATED          STATUS                          PORTS     NAMES
985b72e441e6   centos         "/bin/bash"   3 minutes ago    Exited (0) About a minute ago             hungry_pascal
4fcccfce001d   feb5d9fea6a5   "/hello"      59 minutes ago   Exited (0) 59 minutes ago                 stoic_ellis

#命令 
-a    #列出当前正在运行的容器
-n=?  #显示最近创建的容器
-q    #只显示容器的编号

```



##### 退出容器

```shell
exit	  #直接停止容器并退出
ctrl+p+q  #保留后台运行退出
```



##### 删除容器

```shell
docker rm 容器id               #删除指定容器
docker rm -f $(docker ps -aq) #删除全部容器
docker ps -aq | xargs docker rm #删除全部容器
```



##### 启动和停止容器操作

```shell
docker start 容器id
docker restart 容器id
docker stop 容器id
docker kill 容器id
```





</br><hr></br>





## <font color='red'>常用的其他命令</font>



##### 后台启动

```shell
docker run -d 镜像名  

#这种启动在 docker ps中发现停止了
#docker 容器使用后台运行，就必须要有一个前台进程，docker发现没有应用，就会自动停止。可以使用 -itd 启动
```



##### 查看日志

```shell
docker logs -tf 容器id
```



##### 查看容器中进程信息 ps

```shell
su docker top 容器id
[root@localhost ~]#  docker ps -aq
32df19c0efc1
9d85a1425724
267b0e1abce7
[root@localhost ~]# docker top 32df19c0efc1
UID                 PID                 PPID                C                   STIME               TTY                 TIME                CMD
root                13756               13738               0                   23:17               pts/0               00:00:00            /bin/bash

```



##### 查看镜像的元数据

```shell
[root@localhost ~]# docker inspect 32df19c0efc1
```



##### 进入当前正在运行的容器

```shell
#我们的容器通常是使用后台方式运行的，需要进入容器，修改一些配置。

#命令1
docker exec -it 容器id bashShell

#进入挂载后台的centos
docker exec -it b0da3388f723 /bin/bash	

#命令2
docker attach 容器id


#区别
#docker exec   #进入容器后开启一个新的终端，可以在里面操作
#docker attach #进入容器正在执行的终端，不会启动新的进程
```



##### 从容器内拷贝文件到本机上

```shell
docker cp 容器id:容器内路径 目标的主机路径
[root@localhost ~]# docker cp b0da3388f723:/home/test.java /home

```

