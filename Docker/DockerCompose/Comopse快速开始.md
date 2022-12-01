#### Docker Compose



> ##### Docker Compose是什么
>
> ###### 	Compose 是用于定义和运行多容器 Docker 应用程序的工具。通过 Compose，您可以使用 YML 文件来配置应用程序需要的所有服务。然后，使用一个命令，就可以从 YML 文件配置中创建并启动所有服务。





- ##### 下载

  ```shell
  # 使用国内镜像源，速度较快
  $ sudo curl -L "https://get.daocloud.io/docker/compose/releases/download/1.27.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
  ```

- ##### 添加权限

  ```shell
  $ sudo chmod +x /usr/local/bin/docker-compose
  ```

- ##### 查看版本

  ```shell
  $ sudo docker-compose --version
  ```

  