## <font color='red'>安全认证</font>



#### MongoDB的用户和角色权限简介



> ##### [[MongoDB\]如何管理用户和权限 - shiramashiro - 博客园 (cnblogs.com)](https://www.cnblogs.com/shiramashiro/p/14815278.html)



- #### 开启用户访问控制

  - ##### 在启动MongoDB的时候 添加 -auth 选项 或者指定启动文件中添加 auth=true 



### <font color='cornflowerblue'>认证相关基础念</font>



- #### 启用访问控制：

  - ##### MongoDB使用的是基于角色的访问控制（Role-Based Access Control,RBAC）来管理用户对实例的访问。通过对用户授予一个或者多个角色来用户访问数据库资源的权限和数据库操作的权限，在对用户分配角色之前，用户无法访问实例。

- #### 角色

  - ##### 在MongoDB中通过角色对用户授予相应数据库资源的操作权限，每个角色是当中的权限可以显式指定，也可以通过继承其他角色的权限，或者两者都存在的权限。

- #### 权限

  - ##### 权限由指定的数据库资源（resource）以及允许在指定资源上进行操作（action）组成

  - ##### 资源（resource）包括：数据库，集合，部分集合和集群

  - ##### 操作（action）包括：对资源进行增删改查操作



```mysql
db.createUser(
{
    user:"cortana",
    pwd:"root",
    roles:[
    {
    role:"read",
    db:"testdb"
    }
    ]
})
//在testdb中创建只读用户
```

```tex
user：用户名

pwd：密码

db：指定该用户的数据库，admin是用于权限控制的数据库，如果没有需要新建一个

roles：指定用户的角色，可以用一个空数组给新用户设定空角色；在roles字段,可以指定内置角色和用户定义的角色。role里的角色可以选：

Built-In Roles（内置角色）：
    1. 数据库用户角色：read、readWrite;
    2. 数据库管理角色：dbAdmin、dbOwner、userAdmin；
    3. 集群管理角色：clusterAdmin、clusterManager、clusterMonitor、hostManager；
    4. 备份恢复角色：backup、restore；
    5. 所有数据库角色：readAnyDatabase、readWriteAnyDatabase、userAdminAnyDatabase、dbAdminAnyDatabase
    6. 超级用户角色：root  
    // 这里还有几个角色间接或直接提供了系统超级用户的访问（dbOwner 、userAdmin、userAdminAnyDatabase）
    7. 内部角色：__system

具体角色的功能： 
Read：允许用户读取指定数据库
readWrite：允许用户读写指定数据库
dbAdmin：允许用户在指定数据库中执行管理函数，如索引创建、删除，查看统计或访问system.profile
userAdmin：允许用户向system.users集合写入，可以找指定数据库里创建、删除和管理用户
clusterAdmin：只在admin数据库中可用，赋予用户所有分片和复制集相关函数的管理权限。
readAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读权限
readWriteAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读写权限
userAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的userAdmin权限
dbAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的dbAdmin权限。
root：只在admin数据库中可用。超级账号，超级权限
```

