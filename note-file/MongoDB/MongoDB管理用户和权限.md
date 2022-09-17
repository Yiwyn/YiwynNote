# [[MongoDB\]如何管理用户和权限](https://www.cnblogs.com/shiramashiro/p/14815278.html)





# 管理用户的创建及使用[#](https://www.cnblogs.com/shiramashiro/p/14815278.html#管理用户的创建及使用)

创建用户的函数是`db.createUser({...})`，创建用户时通常需要为该用户添加权限，如read、readWrite权限。

可添加的权限以及说明：

| 权限                 | 作用                                                         |
| -------------------- | ------------------------------------------------------------ |
| read                 | 允许用户读取指定数据库。                                     |
| readWrite            | 允许用户读写指定数据库。                                     |
| dbAdmin              | 允许用户在指定数据库中执行管理函数，如索引创建、删除，查看统计或访问system.profile。 |
| userAdmin            | 允许用户向system.users集合写入，可以在指定数据库里创建、删除和管理用户。 |
| clusterAdmin         | 只在admin数据库中可用，赋予用户所有分片和复制集相关函数的管理权限。 |
| readAnyDatabase      | 只在admin数据库中可用，赋予用户所有数据库的读权限。          |
| readWriteAnyDatabase | 只在admin数据库中可用，赋予用户所有数据库的读写权限。        |
| userAdminAnyDatabase | 只在admin数据库中可用，赋予用户所有数据库的userAdmin权限。   |
| dbAdminAnyDatabase   | 只在admin数据库中可用，赋予用户所有数据库的dbAdmin权限。     |
| root                 | 只在admin数据库中可用。超级账号，超级权限。                  |

进入到MongoDB命令行，并切换到admin数据库：

```shell
> use admin
switched to db admin
```

为某用户添加userAdminAnyDatabase权限：

```shell
db.createUser({"user": "[username]", "pwd": "[password]", "roles": [{"role": "userAdminAnyDatabase", "db": "admin"}]})
```

提示Successfully字样的信息，即创建用户成功：

```shell
Successfully added user: {
    ......
}
```

在重启MongoDB服务之前，需在配置文件末尾处添加`auth = true`，之后必须先进行用户权限认证才可操作数据库：

```shell
# 权限认证
auth = true
```

进入到MongoDB命令行（会话）中，切换admin数据库，并进行权限认证：

```shell
> use admin
switched to db admin
> db.auth("[username]", "[password]")
1
```

1代表用户权限认证成功，0代表用户权限认证失败。

# 普通用户的创建及使用[#](https://www.cnblogs.com/shiramashiro/p/14815278.html#普通用户的创建及使用)

普通用户除了无法使用clusterAdmin、readAnyDatabase、readWriteAnyDatabase等权限外，其他权限都可使用。

每一个数据库都有自己的用户组，用户组中有多个用户，每一个用户的权限可以拥有多个。

```shell
[root@VM-0-6-centos mongodb-4.4.6]# ./bin/mongo
......
> db.auth("[username]", "[password]")
Error: Authentication failed.
0
```

如果没有切换指定的数据库，直接进行用户权限认证，会提示认证失败的消息。只有admin数据库的用户才有权限添加普通用户。

```shell
> use admin
switched to db admin
> db.auth("[username]", "[password]")
1
```

为training数据库添加一个普通用户training：

```shell
> use training
switched to db training
> db.createUser( { user: "training", pwd: "training", roles: [ { role: "readWrite", db: "training" } ] } )
Successfully added user: {
	......
}
```

> 提示：如果当前会话中已经认证了A数据库的用户，再切换到B数据库进行权限认证后，可能会提示“logical sessions can't have multiple authenticated users”错误。因为一次会话不能认证多个用户。

# 更新用户权限[#](https://www.cnblogs.com/shiramashiro/p/14815278.html#更新用户权限)

`db.updateUser("[username]", {...})`函数可以修改用户的权限以及其他信息。

更新权限之前，需要切换到被更新用户所在的数据库，更新操作需要当前会话中认证过的用户具有`userAdmin`或`userAdminAnyDatabase`或`root`角色的用户执行。

切换到admin数据库，修改其中一个用户的用户权限：

```shell
db.updateUser(
    "[username]", 
    {
        "roles": [
            {
                "role": "userAdminAnyDatabase",
                "db": "admin"
            },
            {
                "role": "readWriteAnyDatabase",
                "db": "admin"
            },
            {
                "role": "dbAdminAnyDatabase",
                "db": "admin"
            }
        ]
    }
)
```

修改成功之后，显示所有用户，查看是否更改成功：

```shell
> show users
{
	"user" : "[username]",
	"db" : "admin",
	"roles" : [
		{
			"role" : "userAdminAnyDatabase",
			"db" : "admin"
		},
		{
			"role" : "readWriteAnyDatabase",
			"db" : "admin"
		},
		{
			"role" : "dbAdminAnyDatabase",
			"db" : "admin"
		}
	]
}
```

# 更改用户密码[#](https://www.cnblogs.com/shiramashiro/p/14815278.html#更改用户密码)

`db.updateUser("[username]", {"pwd": "[password]"})`或`db.changeUserPassword("[username]", "[password]")`可以更改用户的密码。

更新密码之前，需要切换到被更新用户所在的数据库，更新操作需要当前会话中认证过的用户具有`userAdmin`或`userAdminAnyDatabase`或`root`角色的用户执行。

# 删除用户[#](https://www.cnblogs.com/shiramashiro/p/14815278.html#删除用户)

`db.dropUser("[username]")`可以删除用户。

删除用户之前，需要切换到被删除用户所在的数据库，更新操作需要当前会话中认证过的用户具有`userAdmin`或`userAdminAnyDatabase`或`root`角色的用户执行。