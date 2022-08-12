### <font color='red'>Jenkins 配置Maven + Git 自动构建jar包</font>



- #### Jenkins安装Maven插件

  - ##### Manager Jenkins => Manager Plugin 

- #### 新建Item

  - ##### 首页 => 新建Item => 构建一个maven项目 => 源码管理 √Git

  - ##### 进行到上一步，在输入仓库地址后会出现错误，需要安装git来解决

    ```shell
    sudo yum install git
    ```

  - ##### Build 这一步需要配置Maven环境，根据提示点击。通常选择系统下的maven（取消install automatically），获取maven根目录

  - ##### 根据项目解构选择pom.xml文件的root路径

  - ##### 此时就行保存，早dashboard进行运行

    - ##### 若出现**<font color='red'>[ERROR] No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?</font>**

      ```shell
      sudo yum install -y java-devel
      #安装jdk
      ```

  - ##### 再次构建 成功