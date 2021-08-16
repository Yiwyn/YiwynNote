## <font color='red'>脚手架创建步骤</font>



### 官方中文引导 [介绍 | Vue CLI (vuejs.org)](https://cli.vuejs.org/zh/guide/)





- #### 第一次执行：全局安装@vue/cli

  ```shell
  npm install -g @vue/cli
  ```



- #### <font color='red'>切换到项目路径</font>，使用命令创建项目

  ```shell
  vue create hello-world
  ```



- #### 选择一个模板完成创建

- ##### 在项目中运行当前vue项目

  - ```shell
    npm run serve
    ```

    









## <font color='red'>脚手架项目文件解析</font>



### <font color='orange'>src</font>

- #### main.js   整个项目的入口文件

  - ##### 引入vue组件

  - ##### 创建vue实例对象
  
- #### App.vue 管理管理所有的组件



#### <font color='orange'>public</font>

- #### favicon.io  网站图标

- #### xxx.html  html文件











## <font color='red'>render函数</font>



#### 在脚手架中创建vue实例的时候，使用了<font color='cornflowerblue'>render</font>函数将组件放入容器中

#### 脚手架的<font color='red'>main.js</font>中导入的vue是残缺版的vue，不能解析<font color='cornflowerblue'>template</font>模板



- #### render方法有一个参数，该参数是一个方法。

- #### render:funcName => funcName(param:组件名)









## <font color='red'>脚手架的默认配置</font>



##### <font color='orange'>vue可以修改的配置参考</font>[配置参考 | Vue CLI (vuejs.org)](https://cli.vuejs.org/zh/config/)



- ##### 在项目下创建文件<font color='fuchsia'>vue.config.js</font> 

- ##### 编辑文件，编辑内容在上述链接中查看



#### 常用：

- ##### lintOnSave   语法检查关闭。

  - ###### 在脚手架中默认情况下不允许存在未使用变量，出现则报错。这里可以设定false来关闭语法检查报错。



