#### <font color='red'>查看对外开放的端口状态</font>

- ##### 查询已开放的端口 netstat  -ntulp | grep 端口号：可以具体查看某一个端口号

- ##### 查询指定端口是否已开 firewall-cmd --query-port=666/tcp

<hr>

#### <font color='red'>查看防火墙状态</font>

- ##### 查看防火墙状态 systemctl status firewalld

- ##### 开启防火墙 systemctl start firewalld  

- ##### 关闭防火墙 systemctl stop firewalld

- ##### 开启防火墙 service firewalld start 

- ##### 关闭防火墙 service firewalld stop

<hr>

#### <font color='red'>对外开发端口</font>

##### firewall-cmd --zone=public --add-port=xxxx/tcp --permanent

