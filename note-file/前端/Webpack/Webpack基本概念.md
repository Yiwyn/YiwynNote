## <font color='red'>webpack </font>





- ### 定义

  - #### webpack是一种前端资源构建工具，一个<font color='red'>静态模块打包器</font>(module bundle)

  - ####  webpack会将css js 等文件打包 <font color='red'>chunk 代码块</font> 根据不同类型打包生成对应的静态资源<font color='red'>bundle</font> 



- ### 五个核心概念

  - #### Entry

    - ##### 入口指示Webpack以哪个文件为入口起点开始进行打包，分析内部依赖图
    
  - #### Output
  
    - ##### 输出指示打包后的资源bundles输出到哪里，已经如何命名
  
  - #### Loader
  
    - ##### Loader让Webpack能够处理那些非JavaScript文件（<font color='red'>webpack本身只理解JavaScripts</font>）
  
  - #### Plugins
  
    - ##### 插件可以用于执行范围更广的任务。插件的范围包括，从打包优化和压缩，一直到重新定义环境中的变量等。
  
  - #### Mode
  
    - ##### development 能让代码本地调试运行的环境
  
    - ##### production  能让代码优化上线运行的环境





