##### 我们在多个服务器运行项目 这个时候需要访问一个url请求自动分配请求到多个服务器之间的内容.

##### 我们可以修改nginx配置文件来完成





##### 修改配置文件 <font color='cornflowerblue'>../nginx/conf/nginx.conf</font> 文件





##### <font color='red'>配置文件解析</font>

```
http {
    include       mime.types;
    default_type  application/octet-stream;

    sendfile        on;
  
    keepalive_timeout  65;

    upstream test{								//代理的url
        server 127.0.0.1:8081 weight=1;
        server 127.0.0.1:8082 weight=1;
    }


    server {
        listen       80;						//拦截的端口
        server_name  localhost;					//服务名字

        location / {
            root   html;
            index  index.html index.htm;
             proxy_pass http://test;  			//自定义的代理pass
        }
        
        //可以有多个server

    }
```







<hr>



- ##### <font color='cornflowerblue'>http</font> 标签 

  - ###### 存放请求端口

  - ###### 可以包含多个<font color='cornflowerblue'>server</font>标签

- ##### <font color='cornflowerblue'>server</font>标签

  - ###### <font color='cornflowerblue'>location</font> <font color='fuchsia'>path</font> : 代表访问路径,表示代理了<font color='fuchsia'>path</font>路径

- ##### 添加代理路径

  - ##### proxy_pass  (<font color='red'>这里的test来自外部定义</font>)

    ```conf
     location / {
                root   html;
                index  index.html index.htm;
                 proxy_pass http://test;  //这里的test
            }
    ```

  - ##### test定义 (<font color='red'>upstream</font>)

    - ```conf
        upstream test{
              server 127.0.0.1:8081 weight=1;   //分配url和权重
              server 127.0.0.1:8082 weight=1;
          }
      ```

    - #### <font color='red'>注</font>:这里的每个配置结尾一定有<font color='red'>;</font> 并且<font color='orange'>关键词和符号之间不存在空格</font> <font color='cornflowerblue'>xxx=xxx</font> 

- ##### 完成,这样访问loaclhost 可以访问到8081or8082端口的内容







