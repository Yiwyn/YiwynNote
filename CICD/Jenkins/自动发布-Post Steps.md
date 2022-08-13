### 自动打包并发布到测试服务器



- ##### 安装 <font color='cornflowerblue'>Publish over SSH</font> 

  - ##### Manager Jenkins => Manager Plugin 
  
- ##### 配置 <font color='cornflowerblue'>Publish over SSH</font>

  - ##### Manager Jenkins => Configure System

  - ##### 找到 publish over ssh 配置项 添加需要部署的服务器

- ##### 配置Item中 <font color='red'>Post Steps</font>

  - ##### 添加 <font color='cornflowerblue'>Send files or execute commands over SSH</font> 

  - <img src="%E8%87%AA%E5%8A%A8%E5%8F%91%E5%B8%83.assets/image-20220813180004232.png" alt="image-20220813180004232" style="zoom:67%;" />

  - ##### Source files

    - ##### 要传送到目标服务器的文件

  - ##### Remove prefix

    - ##### 需要引出的前缀，传送的文件可能会将上层的文件夹一起传送到目标服务器，这个时候就可以移除上层文件夹

  - ##### Remote directory

    - ##### 要传送到的远程目标服务器的目录，这里的根目录对应着 第二步<font color='cornflowerblue'>Publish over SSH</font>中配置的远程地址（该地址仅上传文件），若没设置则默认为/root
    
  - ##### Exec command
  
    - ##### 文件传输完成后执行的命令
  
      ```shell
      #参考
      nohup java -jar *.jar &> app.log &
      ```
  
      