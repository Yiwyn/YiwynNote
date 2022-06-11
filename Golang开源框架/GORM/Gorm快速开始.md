## <font color='red'>Gorm快速开始</font>



> ##### [GORM - The fantastic ORM library for Golang, aims to be developer friendly.](https://gorm.io/zh_CN/)



###### Gorm是golang下的数据库持久层框架



#### 特性：

- ##### 全功能ORM

- ##### 关联（Has One ,Has Many, Belongs To,Many to Many,多态，单表继承）

- ##### Create , Save , Update , Find 中钩子方法（Hook）

- ##### 支持 ==Preload==， ==Joins== 的预加载

- ##### 事务，嵌套事务，Save Point，Rollback To Saved Point

- ##### Context、预编译模式、DryRun模式

- ##### 批量插入、FindInBatches、Find/Create with Map，使用SQL表达式、Context Valuer 进行CURD

- ##### SQL构造器，Upset、数据库锁、命名查询、子查询

- 





#### 安装：

```shell
go get -u gorm.io/gorm
go get -u gorm.io/driver/sqlite
```



#### 连接数据库

```go
dsn := "username:password@tcp(127.0.0.1:3306)/gorm_test?charset=utf8&parseTime=True&loc=Local"
db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})
```

