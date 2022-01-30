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
sudo docker run -d -v /usr/local/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -p 3306:3306  mysql:tag --name costomName
```

- ##### -e 设置环境变量，这里设置密码

- ##### -p 设置端口映射

- ##### -v 文件映射，这样在容器外部可以查看容器内的数据

