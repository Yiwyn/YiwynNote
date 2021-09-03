## <font color='red'>Webpack初体验</font>



- #### npm初始化一个<font color='cornflowerblue'>package.json</font>文件

  ```shell
  npm init
  ```

- #### 安装包 <font color='red'>webpack </font>和 <font color='red'>webpack-cli</font>

  ```shell
  npm i webpack webpack-cli -g
  //这里使用全局安装 以后可以直接作为指令执行
  ```

- #### 添加webpack和webpack-cli到开发依赖

  ```shell
  npm i webpack webpack-cli -D
  ```

- #### 创建<font color='red'>src</font>项目文件夹和<font color='red'>build</font>文件夹

  - ##### 同时在src下创建<font color='red'>index.js</font>文件作为起点文件

- #### 创建测试代码 index.js

  ```js
  function add(x, y) {
      return x + y;
  }
  console.log(add(1, 2));
  ```

- #### 运行指令

  - ##### 开发环境：webpack ./src/index.js -o ./build/built.js --mode=development

    - ###### webpack会以./src/index.js为入口文件开始打包，打包后输出到 ./build/built.js 整体打包环境时<font color='red'>开发环境</font>
    
  - ##### 生产环境：webpack ./src/index.js -o ./build/build.js --mode=production
  
    - ###### webpack会以./src/index.js为入口文件开始打包，打包后输出到 ./build/built.js 整体打包环境时<font color='red'>生产环境</font>
  
- #### 测试

  - ##### 打包完成之后
  
  - ##### 在<font color='cornflowerblue'>build</font>中创建html文件引入观察效果

