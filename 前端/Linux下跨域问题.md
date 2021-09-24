#### 在windows下和在linux下跨域是不一样的。在linux需要额外添加header属性





- ### Code

  nginx 的配置文件如下。

```javascript
http {
    include       mime.types;
    default_type  application/octet-stream;

    server {
        listen       80;
        server_name  localhost;

        # 允许跨域请求的域，*代表所有
        add_header 'Access-Control-Allow-Origin' *;
        # 允许带上cookie请求
        add_header 'Access-Control-Allow-Credentials' 'true';
        # 允许请求的方法，比如 GET/POST/PUT/DELETE
        add_header 'Access-Control-Allow-Method' *;
        # 允许请求的header
        add_header 'Access-Control-Allow-Headers' *;



         location /api/ {
            rewrite  ^/api/(.*)$ /$1 break;
            proxy_pass http://localhost:8081;
        }

        location /hitokoto/ {
            rewrite  ^/hitokoto/(.*)$ /$1 break;
            proxy_pass https://sslapi.hitokoto.cn;
        }

        location / {
            root   html/dist;
            index  index.html index.htm;
            
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
           
        }      
    }
}

```





- ### 前端使用

  - #### 前端访问后台接口的时候使用监听的接口