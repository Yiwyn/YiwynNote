

> #### [MongoDB基本命令的使用 - 上校 - 博客园 (cnblogs.com)](https://www.cnblogs.com/zhuawang/p/3965272.html) 基本命令





- ### <font color='red'>数据库操作</font>

- ##### 查看有权限查看的所有数据库

  ```mysql
  show dbs
  or
  show databases 
  ```

- ##### 创建数据库

  ```mysql
  use databaseName
  
  //在使用use 之后，库会在内存中，并不会持久化到磁盘中。只有库中包含集合的时候库才会持久化到磁盘中
  ```

- ##### 删除数据库

  ```mysql
  db.dropDatabase()
  ```

  

> ###### 登录权限相关[errmsg" : "not authorized on test to execute command { listCollections: 1.0 }mo_chunda-CSDN博客](https://blog.csdn.net/seeol/article/details/45717999)





- ### <font color='red'>集合操作</font>

- ##### 显式创建集合

  ```mysql
  db.createCollection("mycollection")
  ```

- ##### 查询集合

  ```mysql
  show collections
  ```

- ##### 删除集合

  ```mysql
  db.collectionName.drop()
  ```

  



- ### <font color='red'>文档操作</font>

- ##### 文档新增

  - ##### 单文档插入

    ```mysql
    db.collectionName.insert() 
    or
    db.collectionName.save()
    //save可以进行创建和更新，这取决于 _id参数，若_id存在且可以查询到存在的文档则更新，反之则新建文档
    ```

  - ##### 多文档插入

    ```mysql
    db.mycollection.save(
    [
        {
        name:"yiwyn",
        age:"17"
        },
        {
        name:"cortana",
        age:"18"
        }
    ]
    )
    ```

  - ##### <font color='red'>这里collection可以不存在，直接插入文档会隐式创建集合</font>

  - ##### 多文档插入时，可以使用 try catch 捕捉异常

    ```mysql
    try{
    db.mycollection.insertMany([
    {_id:1},
    {_id:1}
    ])
    }catch(e){
    print(e)
    }
    
    //这时执行会报重复主键错误
    ```

    

- ##### 查询文档

  ```mysql
  db.collectionName.find() 
  
  db.collectionName.find({}) //条件查询
  
  db.collectionName.findOne([{}]) 可以扩展方法，只查询一个
  ```

  - ```mysql
    db.mycollection.save([
    {
        name:"yiwyn",
        age:"17"
        },
        {
        name:"cortana",
        age:"18"
        }]
    )
    ```

- ##### 投影查询

  ```mysql
  db.collectionName.find({filed:"value"},{filedName:"1",filedName:"0"})
  //这里第一个对象表示筛选条件，第二个对象表示 是否显示 1显示 0不显示
  ```

- ##### 更新文档

  ```mysql
  db.collection.update(query,update,options)
  
  ```

  - ##### 覆盖的修改

    ```mysql
    db.mycollection.update({name:"yiwyn"},{name:"Yiwyn"})
    ```

    - ##### 这种更新形式会将原数据覆盖，仅保留update的json

  - ##### 局部修改

    ```mysql
    db.mycollection.update({name:"Yiwyn"},{$set:{age:NumberInt(20)}})
    ```

    - ##### 这种修改格式为 <font color='orange'>{ $set:{ filed:value } } </font> 会保留原数据，仅对filed进行操作

  - ##### <font color='red'>注</font>

    - ##### mongodb的修改默认只修改第一条数据，需要options 来设置多次修改 options:<font color='cornflowerblue'>{ multi:true }</font> 即批量修改

      ```mysql
      db.mycollection.update({name:"Yiwyn"},{$set:{age:NumberInt(20)}},{multi:true})
      ```

  - ##### 列值增长的修改

    - ##### <font color='orange'>{$inc:{filed:NumberInt(1) }}</font> file字段增长1

      ```mysql
      db.mycollection.update({name:"cortana"},{$inc:{age:NumberInt(1)}})
      ```

    

- ##### 删除文档

  - ```mysql
    db.collection.remove({filed:value})
    //根据字段匹配删除文档
    
    db.collection.remove({}) 
    //清空集合
    ```

    

  

