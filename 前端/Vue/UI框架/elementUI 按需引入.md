## <font color='red'>element-UI  按需引入 </font>





- #### 官方的快速上手存在一些错误，这里补充完整的步骤。



## <font color='red'>快速开始</font>



- #### 不需要引入 elementUI的css样式表，系统会根据自己导入的模块自动引入样式表。

- #### 引入<font color='cornflowerblue'>babel-plugin-component</font>

  ```shell
  npm install babel-plugin-component -D
  ```

- #### 修改目录下的<font color='fuchsia'>babel.config.js</font>

  ```js
  module.exports = {
    presets: [
      '@vue/cli-plugin-babel/preset',
      ["@babel/preset-env", { "modules": false }]				//官方写法中这个
    ],
    plugins: [
      [
        "component",
        {
          "libraryName": "element-ui",
          "styleLibraryName": "theme-chalk"
        }
      ]
    ]
  }
  ```

- #### 运行中出现缺少模块直接按需安装即可