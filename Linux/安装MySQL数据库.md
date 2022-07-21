### <font color='red'>安装MySQL数据库</font>



1. ##### 执行以下命令，下载并安装MySQL官方的Yum Repository。

```
wget http://dev.mysql.com/get/mysql57-community-release-el7-10.noarch.rpm
yum -y install mysql57-community-release-el7-10.noarch.rpm
yum -y install mysql-community-server
```

![img](https://img.alicdn.com/tfs/TB1ka91h_M11u4jSZPxXXahcXXa-958-431.png)

2. ##### 执行以下命令，启动 MySQL 数据库。

```
systemctl start mysqld.service
```

3. ##### 执行以下命令，查看MySQL初始密码。

```
grep "password" /var/log/mysqld.log
```

![img](https://img.alicdn.com/tfs/TB1HCX6RQY2gK0jSZFgXXc5OFXa-834-36.png)

4. ##### 执行以下命令，登录数据库。

```
mysql -uroot -p
```

5. ##### 执行以下命令，修改MySQL默认密码。

```
set global validate_password_policy=0;  #修改密码安全策略为低（只校验密码长度，至少8位）。
ALTER USER 'root'@'localhost' IDENTIFIED BY '12345678';
```

6. ##### 执行以下命令，授予root用户远程管理权限。

```
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '12345678';
```



7. ##### 输入exit退出数据库。