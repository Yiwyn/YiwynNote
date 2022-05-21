## <font color='red'>DockerFile基础</font>



> ##### DockerFile 是用来构建docker镜像的文件，命令参数脚本
>
> ###### [Dockerfile - 林林星 - 博客园 (cnblogs.com)](https://www.cnblogs.com/lxlhelloworld/p/14286490.html)
>
> ###### [Docker-DockerFile指令详解_奔跑的豆子的专栏-CSDN博客_dockerfile 命令](https://blog.csdn.net/y472360651/article/details/81289141)



- ##### 构建步骤：

  - ##### 编写 DockerFile 文件

  - ##### docker build 构建成为一个镜像

  - ##### docker run 运行镜像

  - ##### docker push 发布镜像





##### 基础知识

- ##### 每个保留关键字（命令）都必须是大写字母

- ##### 执行从上到下顺序执行

- ##### #  表示注释

- ##### 每一个指令都会创建提交一个新的镜像层，并提交







## <font color='red'>Docker命令</font>





##### 基础命令

```shell
FROM 			#基础镜像
MAINTAINER    	#镜像作者 
RUN 			#镜像构建的时候需要运行的命令
COPY			#将我们的文件拷贝到镜像中
ADD				#本质和COPY一样，可以指定源路径为url，docker会下载到目标目录上
WORKDIR			#镜像的工作目录
VOLUME			#设置容器卷，挂载的目录 可以使用 -v 来映射
EXPOST			#暴露端口  可以使用 -p 来映射
CMD 			#docker不是虚拟级是进程，启动的时候指定这个容器启动的时候要运行的命令 	
ENTRYPOINT		#设置容器的入口程序，当指定了该项目的时候，CMD指令的内容将会以参数的形式传递给ENTRYPOINT 
ONBUILD			#当构建一个被继承 DockerFile 这个时候会运行ONBUILD 的指定，触发指令
ENV				#构建的时候设置环境变量
```



##### 实战案例



- ##### 编写DockerFile

  ```shell
  FROM centos
  MAINTAINER YIWYN<5597104@QQ.COM>
  
  ENV MYPATH /usr/local
  WORKDIR $MYPATH
  
  RUN yum -y install vim
  RUN yum -y install net-tools
  EXPOSE 80
  
  CMD echo $MYPATH
  CMD echo "====end===="
  CMD /bin/bash
  ```

  

- ##### docker build 构建

  - ```shell
     docker build [OPTIONS] PATH | URL | -
     
     #docker build -t custom-name -f DockerFile .
     
     #-t 指定tag 标签名字
     #-f 指定DockerFile 源文件
    ```

- ##### 构建成功

  - ```shell
    docker run ...   #运行自己构建的镜像
    ```





- ##### 可以使用docker  history 查看 镜像构建的过程



















<img src="DockerFile.assets/QQ%E6%88%AA%E5%9B%BE20210109111041.png" alt="dockerfile指令" style="zoom: 80%;" />



