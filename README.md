    <h1 align="center">Yiwyn Note Server</h1>





## 项目介绍

集成了gitee仓库和本地文件的笔记系统，只需要按照文件夹/笔记的形式，系统将自动更新笔记的标签，内容到用户设定的数据库。配套通用的接口对笔记进行快速的增删改查。同时可以在系统中设置定时pull拉取gitee/github中的代码可实现自动更新note系统的笔记

### 官方网站

[YiwynNote: Yiywn的笔记 - Gitee.com](https://gitee.com/yiwyn/YiwynNote/tree/note-server/)

### 背景

许多人使用云笔记都是使用的git相关的平台，如果有一个系统可以在提交笔记或者操作tag的时候进行自动化更新，那一样方便很多，蝓时这个系统就出现了

## 功能

- 定时对本地/git仓库的笔记进行拉取
- 提供邮箱提醒功能，通知到用户更新结果
- 提供完善的api接口

## 

## 快速入门

请使用以下代码：

```markdown
在note-server 中
1.使用 mvn install 进行安装maven依赖
2.运行LifepoemBlogApplication方法开始执行程序
```

需要进行的配置：

```html
spring:
  application:
    name: lifepoem-blog
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: xxxx
    password: xxxx
    url: jdbc:mysql://xxxx
    type: 

//使用本地文件
note:
  file-locations: F:\学习笔记\YiwynNote

//使用gitee文件（不推荐使用）
gitee:
  base-url: https://gitee.com/api/v5/repos/Yiwyn/YiwynNote/contents/
  base_download_url: https://gitee.com/yiwyn/YiwynNote/raw/master/
```

<details>
  <summary>点我 打开/关闭 维护者列表</summary>

- [Yiwyn (yiwyn) - Gitee.com](https://gitee.com/yiwyn)项目作者，全栈工程师。

</details>



## 
