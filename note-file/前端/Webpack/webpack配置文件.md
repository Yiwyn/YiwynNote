## <font color='red'>webpack.config.js</font>





- ### 作用

  - ##### 指示webpack做哪些工作，使用<font color='red'>webpack</font>命令的时候，会自动加载配置进行打包



- ##### 所有的项目都是基于<font color='cornflowerblue'>nodejs</font>平台运行的，模块化采用commonjs



- ### 基本结构

  ```js
  const { resolve } = require("path")
  
  module.exports = {
      //入口起点
      entry: "./src/index.js",
      //输出对象  __dirname是nodejs的变量，代表当前目录文件的绝对路径
      output: {
          filename: "built.js",
          path: resolve(__dirname, "build")
      },
      //loader的配置
      module: {
          rules: [
              {
                  //每一项单独一个对象
                  test: /\.css/,  //正则表达式
                  use:[
                          //使用哪些loader
                  ]
              }
          ]
      },
      //插件的配置
      plugins: [
  
      ],
      //模式 production development
      mode: "development"
  
  }
  ```
  
- ##### 在module中 <font color='red'>use</font>数组中，loader的读取顺序是从下到上/从右往左的

