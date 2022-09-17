## <font color='red'>包 package</font>



- #### <font color='cornflowerblue'>CommonJS</font> 的包规范允许我们将一组相关的模块组合在一起，形成一组完整的工具。

- #### <font color='cornflowerblue'>CommonJs</font> 的包规范由<font color='red'>包规范</font>和<font color='red'>包描述文件</font>两个部分组成

- #### 包结构

  - ##### 用于组织包中的各种文件

  - ##### 必须包含文件

    - ##### <font color='red'>package.json</font>

- #### 包描述文件

  - ##### 描述包的相关信息，以供外部读取解析







## <font color='red'>NPM(Node Package Manager)</font>



- #### NPM帮助Node完成第三方模块的发布、安装、依赖





- ### <font color='red'>常用命令</font>

  - ##### npm -v                   -查询版本

  - ##### npm version             -查询详细的版本信息

  - ##### npm search packageName              -根据包名搜素，需要联网

  - ##### npm install 包名                 -在<font color='red'>当前目录</font>安装包

  - ##### npm install 包名 -g             -<font color='red'>全局模式</font>安装包

  - ##### npm remove 包名              -删除一个模块

  - ##### npm install 文件路径         -从本地安装

  - ##### npm install 包名 --save     -安装包并添加到依赖中

  - ##### <font color='red'>npm install                          -新项目需要进行这一步，他会根据配置文件自动安装需要的包</font>  





- ### <font color='red'>安装一个包</font>

  - ##### npm init    npm引导创建一个package.json

    - ##### npm名称不允许出现大写字符

    - ##### 根据引导默认则回车

  - ##### npm search xxx

    - ##### 这一步可<font color='red'>省略</font> 

  - ##### npm install xxx

  - ##### 使用 <font color='cornflowerblue'>var xxx= require("xxx");</font> 

    - ##### 非自定义模块可以不以<font color='red'>./ ../ </font>开头





