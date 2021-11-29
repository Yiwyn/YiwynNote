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

