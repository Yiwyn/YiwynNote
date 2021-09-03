- #### 首先<font color='cornflowerblue'>webpack</font>只能识别<font color='red'>js</font>、<font color='red'>json</font>所以其他类型的资源需要使用loader来处理





## 样式资源打包（css、less）



- #### 入口文件导入样式表

  ```js
  import "./index.css"
  ```

- #### <font color='red'>webpack.config.js</font>中 module/rules中配置

  ```js
    rules: [
              {
                  test: /\.css/,  //正则表达式
                  use: [
                      //使用哪些loader
                      "style-loader",
                      "css-loader"，
  					"less-loader"  //使用less样式表时添加
                  ]
              }
          ]
  ```

- #### 安装loader

  ```shell
  npm i style-loader css-loader -D
  ```

- #### webpack命令打包



<hr>





## html资源打包



- #### 使用plugin处理html资源文件



- #### 安装 <font color='red'>html-webpack-plugin</font>

  ```shell
  npm i html-webpack-plugin
  ```

- #### 配置 webpack.config.js 文件的<font color='cornflowerblue'>plugins</font>

  ```js
  const HtmlWebpackPlugin = require("html-webpack-plugin") //导入插件
  
  ....
  
  plugins: [
      new HtmlWebpackPlugin({
          template: "./src/index.html"   //作为模板文件，打包完成自动引入打包输出的所有资源（js/css）
      })
  ],
  ```

- #### 剩下同上





<hr>





## 图片资源打包



- #### 图片嵌入样式表

  ```css
  #imgTest{
      width: 100px;
      height: 100px;
      background-image:url("./SunRec.jpg");
  }
  ```

- #### webpack.config.js配置

  ```js
          rules: [
              {
                  test: /\.css/,  //正则表达式
                  use: [
                      //使用哪些loader
                      "style-loader",
                      "css-loader"
                  ]
              },
              {
                  test: /\.(png|jpg|gif)$/,
                  loader: "url-loader",  
                  options: {
                      //小于8kb，就会被base64处理
                      limit: 8 * 1024,
                      name:"[hash:10].[ext]",  //改修命名为10位
                      esModule:false    		 //关闭es6模块化
                  }
              }
          ]
  ```

- #### 安装loader 

  ```js
  npm i url-loader file-loader -D
  ```

  - ##### 这里需要安装两个loader url-loader 需要file-loader

- #### webpack 打包

- #### <font color='red'>默认处理不了html中的图片</font> （img标签）

  - ##### 添加html-laoder可以解决

- #### Code

  ```js
   rules: [
          {
          	test: /\.css/,  //正则表达式
              use: [
                  //使用哪些loader
                  "style-loader",
                  "css-loader"
                ]
              },
              {
                test: /\.(png|jpg|gif) $/,
                loader: "url-loader",
                options: {
                //小于8kb，就会被base64处理
                	limit: 8 * 1024,
                 }
              },
              {
                 test: /\.html$/,
                 loader: "html-loader"
              }
          ]
  ```

  



<hr>





## 其他资源打包



- #### 打包其他类型的资源（除了htnl/css/js）以外的资源

  ```js
              {
                  exclude: /\.(css|js|html)$/,
                  loader: "file-loader",
                                options: {
                      name: "[hash:10].[ext]"
                  }
              }
  ```

- #### 方式同上

- ##### 这里options中的<font color='red'>name</font>可以将打包后的文件名进行处理， 这里的的意思是保持原有扩展名，名字变成前10位

