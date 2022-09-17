## <font color='red'>Docker镜像 分层</font>



> #### 所有的docker镜像都起始于一个基础镜像层，当进行修改或新增新的内容时，就会在当前镜像层之上，创建新的镜像



![由浅入深docker系列： (6)镜像分层](Docker%E9%95%9C%E5%83%8F%E5%88%86%E5%B1%82%E5%8E%9F%E7%90%86.assets/v2-b7279dd326f42b71327f9fb066ae5c6a_1440w.jpg)



#### 问题思考

- ##### 同一个镜像启动两个容器，会占用两倍磁盘空间吗

- ##### 容器内修改或者创建了某个文件，会修改原镜像吗

- ##### 基于镜像新创建一个镜像，需要将原镜像全部拷贝到新镜像中吗



#### 答案

- ##### 只需要将一个镜像文件加载到内存不同位置就行

- ##### 参考Linux内核管理内存的<font color='red'>Copy-On-Write</font> 策略，读时大家公用一份文件，如果需要修改则再复制一份进行修改，而大部分文件不会修改，节省空间，提升性能。

- ##### 镜像文件分为多个独立的层，新镜像文件只引用基础镜像文件就可以了，节省空间。







### <font color='red'>Docker的镜像分层</font>



##### 	当启动一个容器，Docker会在最顶部添加读写层，在容器内做的所有修改，都会被保存在读写层，一般称该层为容器层![img](Docker%E9%95%9C%E5%83%8F%E5%88%86%E5%B1%82%E5%8E%9F%E7%90%86.assets/v2-4b2318880b12c3220fa59a9d9992dc90_720w.jpg)



##### 容器（container）和镜像（image）最主要的区别就是容器加上了顶层的读写层。所有对容器的修改都发生在读写层，镜像不会修改，也就是<font color='red'>COW</font>（Copy-On-Write）技术。容器读取某个文件时，直接从底部只读层去读取，当修改某个文件时，将该文件拷贝到顶部读写层进行修改，只读层保持不变。



##### 每个容器都有自己的读写层，因此多个容器可以使用一个镜像，当容器被删除时，对应的读写层也会被删除



##### 执行命令 ==docker ps -s== 可以看到size，这个size就是读写层的大小，而virtual 则代表读写层和只读层所占的大小。因为只读层一般存在共享，所以一个容器的大小远远小于virtual

```shell
CONTAINER ID   IMAGE     COMMAND                  CREATED             STATUS             PORTS                                       NAMES     SIZE
20702c2ce333   redis     "docker-entrypoint.s…"   About an hour ago   Up About an hour   0.0.0.0:6379->6379/tcp, :::6379->6379/tcp   myredis   100B (virtual 113MB)

```

