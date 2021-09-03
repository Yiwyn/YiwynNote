## devServer 



- ### 作用

  - #### 用来自动化（自动编译，自动打开浏览器，自动刷新网页），在<font color='cornflowerblue'>webpack.config.js</font>中配置



- ### 特点

  - #### 只会在内存中编译打包，不会有任何输出

  - #### 启动devServer指令为<font color='red'>webpack-dev-server</font> 



- ### 安装webpack-dev-server

  ```shell
  npm i webpack-dev-server -D
  ```



- #### 配置

  ##### webpack.config.js

  ```js
  ...module.export = {
  ....
  ..
  
   devServer: {
          static: {
              directory: resolve(__dirname, "build")
          },
          compress: true,
          port: 8081
      }
  }
  ```

  