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

  







