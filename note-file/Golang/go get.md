### <font color='red'>go get 出现访问超时或者异常</font>



> ##### Go默认使用<font color='cornflowerblue'>proxy.golang.org</font>，国内无法访问。



##### 解决方案：

- ##### 创建项目执行国内能访问的代理地址：https://goproxy.cn 

  - ##### https://mirrors.aliyun.com/goproxy/ 阿里云

- ##### 执行命令:

  - ```shell
    go env -w GOPROXY=https://goproxy.cn
    ```

    

##### 参数介绍：

- | 参数 | 介绍                                                         |
  | ---- | ------------------------------------------------------------ |
  | -d   | 只下载不安装                                                 |
  | -f   | 只有在包含了-u参数的时候才有效，不让-u去验证import中的每一个包都已经获取。 |
  | -fix | 在获取源码之后先运行fix，然后再去做其他的事情                |
  | -t   | 同时也下载运行测试所需要的包                                 |
  | -u   | 强制使用网络去更新包和他的依赖                               |
  | -v   | 显示执行的命令                                               |

  

