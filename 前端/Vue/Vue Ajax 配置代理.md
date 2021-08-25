## <font color='red'>ajax</font>



- ##### <font color='red'>xhr </font>  new XMLHttpRequest() 	xhr.open()	xhr.send()

- ##### <font color='red'>jQuery</font>  $.get $.post

- ##### <font color='red'>axios</font>    推荐使用

- ##### <font color='red'>fetch</font>    ie兼容性较差       



<hr>





# <font color='red'>axios</font>插件使用



- ### npm 安装 axios

- ### 导入 axios 对象

- #### 使用get或者post方法进行访问，并设置回调

  - ```js
          axios.get("http://localhost:5000/text/test.txt").then(
            (response) => {
              console.log(response.data); 	 //访问成功的回调
            },
            (error) => {
              console.log(error.message);    //访问失败的回调
            }
          );
    ```

- ### 这时候会出现<font color='red'>跨域</font>问题

  - ##### 出现跨域问题会访问失败，但是需要注意的是

    - ##### <font color='red'>此时的访问会发送到服务端</font>

    - ##### <font color='red'>服务端的响应也会发送给浏览器</font>

    - ##### <font color='red'>浏览器不会把接收到的响应交给用户</font>

- ### 解决跨域问题

  - ##### <font color='red'>cors</font>  返回响应的时候携带一些特殊的响应头告诉客户端需要使用

  - ##### <font color='red'>jsonp</font> 原理 使用 <font color='cornflowerblue'>script </font>标签 src 属性引入外部资源的时候不受同源策略限制的特点。 真是开发使用极少 只能解决get

  - ##### 配置代理服务器

    - ##### Nginx

    - ##### vue-cli

  - ##### 这里使用vue-cli来解决问题

    - ##### 官方文档 [配置参考 | Vue CLI (vuejs.org)](https://cli.vuejs.org/zh/config/#devserver-proxy)

    - ##### 项目目录下添加文件 <font color='fuchsia'>vue.config.js</font> 

    - #### <font color='red'>方式一</font>

      - ```js
        module.exports = {
            devServer: {
                proxy: 'http://localhost:5000'
            }
        }
        ```

      - ##### 这种方式请求只能转发给一个服务器，只能配置一个

    - #### <font color='red'>方式二</font>

      - ```js
          devServer: {
                proxy: {
                    '/test': {
                        target: 'http://localhost:5000',
                        pathRewrite: { '^/api': '' },  //见下 注
                        ws: true,
                        changeOrigin: true
                    }
                }
            }
        ```

      - ##### 这种访问请求参数需要添加前缀 <font color='cornflowerblue'>/api</font> 

      - ##### 请求处代码

        ```js
         axios.get("http://localhost:8080/api/xxx/xxx").then(....)
        ```

      - ### <font color='red'>注</font>

        - #### 使用方式二访问的时候存在一个问题，前缀会跟随着url一起到目标服务器，如果目标服务器没有相应路径则会404错误

        - #### <font color='fuchsia'>解决方案</font>

          - ##### 使用<font color='cornflowerblue'>pathRewrite</font> 利用表达式将前缀重写为空，这样可保持url和之前一致

          - ##### 在后端中<font color='cornflowerblue'>controller</font>（不一定非要这个）中设置好前缀，对应proxy中也设置相应 前缀。

          - ##### 例

            - ```js
              //后端中
              @RequestMapping("/user")
              
              //vue-cli
              proxy: {
              	'/user': {
                  target: 'http://localhost:5000'
                  }
              }
              ```

            

