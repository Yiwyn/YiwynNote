### MySQL开启主从复制



> ##### 基本流程。在master数据库中创建一个供slave访问用的数据库用户，slave节点通过master数据库的binlog和binlog的position进行对master数据库的同步。在多个数据库中server_id必须不同



- #### master数据库创建用户

  - ##### 创建SLAVE用户，给予Replication Slave权限

  - ##### 获取master数据库的 master status

    ```mysql
    SHOW MASTER STATUS
    //获取File Position
    ```

- #### slave数据库绑定master

  - ##### 查询server_id、设置server_id

    ```mysql
    show variables like "server_id" //查询mysql的服务id
     
    SET GLOBAL server_id = 3  //设置服务id，需要不重复
    ```

  - ##### 设置同步

    ```mysql
    CHANGE MASTER TO MASTER_HOST='master数据库的ip', MASTER_USER='slave_username', MASTER_PASSWORD='slave_password', MASTER_LOG_FILE='binlog.000004',MASTER_LOG_POS=157 //这两个是从master数据库获取的
    ```

- #### 基本命令

  ```mysql
  START SLAVE  //开启主从
  STOP SLAVE   //停止主从
  
  SHOW SLAVE STATUS //查询主从状态
  ```

- #### 主动复制信息

  - ##### 在执行<font color='cornflowerblue'>SHOW SLAVE STATUS</font>之后，当<font color='orange'>Slave_IO_Running</font>、<font color='orange'>Slave_SQL_Running</font> 都为Yes表示主从复制成功。若其中之一为No，则可以在查询出的信息中找到错误信息。

  