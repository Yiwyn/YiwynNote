## <font color='red'>容器数据卷</font>





> #### 什么是容器数据卷



##### 我们的应用部署在容器中，但是我们的数据不可以在容器，否则容器删除数据就会丢失。

##### <font color='red'>需求 ： 数据可以持久化</font>



##### 容器之间数据共享，docker 容器产生的数据，同步到本地，这就是卷技术。

- ##### 将容器内的目录，挂载到我们的机器上。

- ##### 容器之间，数据共享





### <font color='orange'>使用数据卷</font>



> ##### 方式一：使用命令来挂载 -v

```shell
docker -run -it -v 主机目录:容器目录
```



- ##### 可以使用命令查看是否挂载成功

  ```shell
  docker inspect 33fa0e854f4c（docker容器id）
  
  //返回信息 找到 Mounts
  ```

- ##### 挂载完成之后，两个目录是相互映射的





### docker 运行出错 Error response from daemon: error creating overlay mount to /var/lib/docker/overlay2/007

```tex
这个问题的是由于selinux造成的，CentOS的selinux是关闭的，而docker上的selinux却是开启的，因此docker运行时会产生如上错误。
解决方案无非是要么都关闭，要么都开启。参看https://github.com/coreos/bugs/issues/2340，推荐修改CentOS下的/etc/selinux/config 将SELINUX=disabled 改成 SELINUX=permissive
```

