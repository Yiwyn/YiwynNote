## <font color='red'>Docker 文件挂载</font>



- #### 匿名挂载

  - ```properties
    -v   容器内路径　　　　　　　　　　# 匿名挂载
    
    -v   卷名：容器内路径　　　　　　　# 具名挂载
    
    -v   / 宿主机目录：容器内目录　　 # 指定路径挂载
    ```



- #### mysql实例演示

  - ##### 匿名挂载

    ```shell
    sudo docker run -d -P --name niming -v /var/lib/mysql mysql
    ```

  - ##### 具名挂载

    ```shell
    sudo docker run -d -P --name juming -v juming:/var/lib/mysql mysql
    ```

  - ##### 指定路径挂载

    ```shell
    sudo docker run -d -P --name zhiding -v /usr/local/mysql:/var/lib/mysql mysql
    ```



- #### 可以通过<font color='orange'>docker volume </font> 查看挂载的卷的信息

  ```shell
  [root@localhost ~]# docker volume
  
  Usage:  docker volume COMMAND
  
  Manage volumes
  
  Commands:
    create      Create a volume
    inspect     Display detailed information on one or more volumes
    ls          List volumes
    prune       Remove all unused local volumes
    rm          Remove one or more volumes
  
  Run 'docker volume COMMAND --help' for more information on a command.
  
  ```

  



#### <font color='red'>挂载出现问题</font> 

##### docker 运行出错 Error response from daemon: error creating overlay mount to /var/lib/docker/overlay2/007

```tex
这个问题的是由于selinux造成的，CentOS的selinux是关闭的，而docker上的selinux却是开启的，因此docker运行时会产生如上错误。
解决方案无非是要么都关闭，要么都开启。参看https://github.com/coreos/bugs/issues/2340，推荐修改CentOS下的/etc/selinux/config 将SELINUX=disabled 改成 SELINUX=permissive
```





