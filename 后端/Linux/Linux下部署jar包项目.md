### <font color='red'>springboot打包项目 jar 文件部署linux</font>



- #### 将打包好的文件放到 linux 文件夹中

- #### 使用 <font color='red'>nohup java -jar ./xxxxxx.jar & </font>运行jar包 开始项目

- #### 查看是否打开进程

  - ```shell
    ps -ef | grep xxxxx.jar 
    //将查询到 进程ID**  
    ```

- #### 结束进程

  - ```shell
    kill -9 **进程ID
    ```

    

