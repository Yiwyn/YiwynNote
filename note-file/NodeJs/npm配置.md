## <font color='red'>自定义cnpm （中国淘宝的npm镜像）</font>





- #### 命令行执行

  - ##### 安装cnpm

    - ```shell
      npm install -g cnpm --registry=https://registry.npm.taobao.org
      ```

  - ##### 卸载cnpm

    - ```shell
      npm uninstall -g cnpm
      ```

- #### 安装后执行 <font color='cornflowerblue'>cnpm -v</font> 来查看版本

- #### 错误处理

  - ##### 出现如下错误 <font color='red'>无法加载文件 C:\Users\hp\AppData\Roaming\npm\cnpm.ps1，因为在此系统上禁止运行脚本…</font>

  - #####  解决方式：

    ```shell
    	1、在系统中搜索框 输入 Windos PowerShell
    	
    	2、点击“管理员身份运行”
    	
    	3、输入“ set-ExecutionPolicy RemoteSigned”回车
    	
    	4、根据提示，输入A，回车
    	
    	5、再次回到cnpm -v执行成功。
    ```

- #### 区别

  - ##### cnpm 为了区分npm，使用cnpm安装的包会在前面添加<font color='red'>下划线_</font>







## <font color='red'>require包搜索流程</font>



- #### node按名字引入模块时，他会从当前模块<font color='red'>向上</font>级不断查找是否含有需要的模块。知道找到为止，当到达根目录依然没有的时候，报错