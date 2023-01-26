#### <font color='red'>go env</font>



##### 在golang开发中，在run、build等命令中，对env中操作系统有着要求，着决定着项目打包的文件类型（二进制、exe）

```shell
//获取系统变量
go env

//修改为linux环境
go env -w GOOS=linux

//修改为windows环境
go env -w GOOS=windows
```

