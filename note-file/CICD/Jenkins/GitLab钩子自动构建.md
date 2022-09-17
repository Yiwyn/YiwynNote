### <font color='red'>Jenkins 自动构建</font>





- ##### 配置<font color='cornflowerblue'>构建触发器</font>

  - ##### item => 配置 => 构建触发器

- ##### 触发远程构建

  - ##### 配置token value<img src="GitLab%E9%92%A9%E5%AD%90%E8%87%AA%E5%8A%A8%E6%9E%84%E5%BB%BA.assets/image-20220818224621109.png" alt="image-20220818224621109" style="zoom:67%;" />

  - ##### <font color='red'>例url:</font> [192.168.199.131:8080/job/jenkins-demo/build?token=tokenvalue](http://192.168.199.131:8080/job/jenkins-demo/build?token=tokenvalue)  这种是基于当前登录了jenkins的情况

  - ##### 直接访问url进行构建需要当前浏览器包含了对话才可以，这时需要jenkins的其他插件来解决问题了

- ##### 安装 <font color='cornflowerblue'>Build Authorization Token Root</font> 

  - ##### Manage Jenkins => Manage Plugins =>  可选插件

  - ##### 启动插件之后可以免登录通过token的形式构建项目

  - ##### <font color='red'>例url：</font>http://192.168.199.131:8080/buildByToken/build?job=jenkins-demo&token=tokenvalue



- ##### Gitlab 配置Webhooks

  - ##### 项目 => 设置 => Webhooks => 选择合适的回调事件触发网址

  - ##### 若出现了错误警告，优先执行下面的操作

- ##### 还需要开启gitlab的本地访问功能

  - ##### 菜单 => 管理员 => 设置 => 网络 => 出站请求



- ##### 此时，jenkins 就拥有了自动构建的能力
