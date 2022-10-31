#### 核心概念

- ##### 一文件

  - ##### docker-compose.yml

- ##### 二要素

  - ##### 服务(service)

    - ##### 一个个应用容器实例，如mysql、redis

  - ##### 工程(project)

    - ##### 由一组关联的应用容器组成的一个<font color='red'>完整的业务单元</font>，在docker-compose.yml中定义。



##### 实例：

##### 该docker-compose.yml文件将会根据指定文件夹下的Dockerfile文件生成镜像，同时根据设置的参数启动；并且需要等待mysql服务启动之后才会启动。

```yaml
services:
  lp-demo:
    build: ./
    #需要将自己的dockerfile文件放在指定目录下
    
    image: lp_demo:latest
    #dockerfile生成的镜像名字
    
    container_name: lp-demo-server
    #docker启动的容器名字
    
    ports:
      - "8080:8080"
    #端口映射
    
    volumes:
      - "/usr/local/docker-demo/app:/app"
    #文件映射
    
    command: ["java","-jar","app.jar","--server.port=8080"]
    #启动命令
    
    depends_on:
      - mysql
    #需要依赖的容器，在容器运行完成后才会运行当前（lp-demo）容器
      
  mysql:
    image: mysql
    container_name: blog-sql
    ports:
      - "3306:3306"
    environment:
      - MYSQL_ROOT_PASSWORD=123456
      
```

