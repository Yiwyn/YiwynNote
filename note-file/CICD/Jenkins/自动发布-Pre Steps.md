### 自动发布之前需要进行的操作



> ##### 在系的系统发布之前，需要先确保之前的旧程序已经被删除和结束任务。



- ##### 在Item中配置 <font color='red'>Pre Steps</font>

  - ##### 同样添加 <font color='cornflowerblue'>Send files or execute commands over SSH</font>

  - ##### 在先置条件中，不需要文件传输，仅需要shell命令，因为需要执行一系列操作，故需要在目标机器中提前写好shell脚本，在配置中运行脚本

  - <img src="%E8%87%AA%E5%8A%A8%E5%8F%91%E5%B8%83-Pre%20Steps.assets/image-20220814001014259.png" alt="image-20220814001014259" style="zoom:67%;" />

  - ##### 需要注意的是此时的<font color='cornflowerblue'>脚本位置</font>并非在配置 Publish over SSH 中配置的远程位置（该位置仅上传文件），脚本应该放置在/root文件夹下。

  - ##### 同时 <font color='cornflowerblue'>Send files or execute commands over SSH</font> 中，Source files 和 Exec command 是二选一的。<font color='red'>并非全部是必填项</font>

    

- ##### Shell脚本的编写

  - ```shell
    #!/bin/bash
    
    #清除打包文件
    rm -rf (打包文件的位置) 
    
    #清除正在执行中pid
    pid=`ps -ef | grep java | grep jenkins | awk '{printf $2}' `
    
    echo $pid
    
    kill -9 $pid
    
    ```

  - ##### <font color='red'>进阶使用</font> 传入参数

    ```shell
    #test.sh
    
    #!/bin/bash
    
    appName=$1
    
    pid=`ps -ef | grep java | grep $appName | awk '{printf $2}' `
    
    
    #逻辑判断
    if [ -z $appName ];
    # -z 用来判断是否为空 zero
    then
      echo "未输入变量appName"
    else
      echo $appName
    fi
    
    
    echo $pid
    echo $appName
    ```

    - ##### <font color='orange'>$1</font> 表示执行脚本后的第一个参数 $2 $3 同理

    - ##### = 两侧不能有空格

    - ##### 判断语句为固定写法 if fi 闭合

    ```shell
    #使用
    sudo ./test.sh appName
    ```

  - ##### 自定义输入的前提下可以让jenkins自动部署更加方便



