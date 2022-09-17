## <font color='red'>commit  提交镜像</font>





```shell
[root@localhost ~]# docker ps
CONTAINER ID   IMAGE     COMMAND             CREATED         STATUS         PORTS                                       NAMES
6aa7b4af31e0   tomcat    "catalina.sh run"   7 minutes ago   Up 7 minutes   0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   sharp_wilson
[root@localhost ~]# docker commit -a="yiwyn" -m"add config" 6aa7b4af31e0 tomcat_yiwyn
sha256:f3cdd662495b8f0dfc8018ab5d124d159ad4df26e7835e6effc20200ea6aa1bc

```



- ##### docker commit -a="yiwyn" -m"add config" ==6aa7b4af31e0==（容器id） <font color='red'>tomcat_yiwyn</font>（新镜像名字）

  - ##### -a  作者  

  - ##### -m 提交日志





#### 修改后的镜像

```shell
[root@localhost ~]# docker images
REPOSITORY     TAG       IMAGE ID       CREATED         SIZE
tomcat_yiwyn   latest    f3cdd662495b   4 minutes ago   684MB
```





#### 再次使用

```shell
docker run -itd -p 8080:8080 tomcat_yiwyn
```



