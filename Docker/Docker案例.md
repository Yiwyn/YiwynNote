## <font color='red'>nginx</font>



```shell
docker search nginx
//建议去docker hub上搜索
docker pull  
//拉取镜像 
docker run -d --name nginx001 -p 3344:80 nginx
//后台启动nginx 并且给nginx命名，不命名则使用默认名 映射公网的3344访问docker的80端口

//外部访问 ip:3344 已经可以访问到docker中的80端口的nginx服务了
docker exec -it 容器id(名字) bin/bash
//进入容器
```





## <font color='red'>mysql</font>



```shell
//下载mysql镜像
sudo docker pull mysql

//启动mysql
sudo docker run -d --name costomName -p 3306:3306 -v /usr/local/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password   mysql:tag 
```

- ##### -e 设置环境变量，这里设置密码

- ##### -p 设置端口映射

- ##### -v 文件映射，这样在容器外部可以查看容器内的数据





## <font color='red'>redis</font>



> ##### [Redis configuration – Redis](https://redis.io/topics/config)
>
> ##### redis官网下载
>
> ##### 首先需要将redis配置文件放入宿主机映射文件夹下

```shell
sudo docker run -d -v /usr/local/yiwynfile/redis/conf/:/usr/local/etc/redis -p 6379:6379 --name myRedis redis redis-server /usr/local/etc/redis/redis.conf
```

##### 配置文件

```shell
bind 0.0.0.0  #允许远程访问
requirepass xxxx #设置连接密码
```

