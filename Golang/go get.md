### <font color='red'>go get 出现访问超时或者异常</font>



> ##### Go默认使用<font color='cornflowerblue'>proxy.golang.org</font>，国内无法访问。



##### 解决方案：

- ##### 创建项目执行国内能访问的代理地址：https://goproxy.cn 

- ##### 执行命令:

  - ```shell
    go env -w GOPROXY=https://goproxy.cn
    ```

    