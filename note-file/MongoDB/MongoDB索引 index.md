## <font color='red'>索引-index</font>



- ### 概述

  - ##### MongnDB可以使用该索引限制必须检查的文档数。

  - ##### 索引是特殊的数据结构，它以易于遍历的形式存储集合数据集的一部分。索引储存特定字段或一组字段的值，按字段值排序。索引项的排序支持有效的相等匹配和基于范围的查询操作。

  - ##### MongoDB索引使用B树数据结构（<font color='cornflowerblue'>MongoDB使用B-Tree，MySQL使用B+Tree</font>）



- ### 索引的类型

  - #### 单字段索引

    - ##### MongoDB支持在文档的单个字段上创建用户自定义的升序/降序索引，称为但字段索引<font color='orange'>（Single Field Index）</font>

    - ##### 对于单个字段的索引，索引键的排序顺序并不重要，因为MongoDB可以在任何方向上遍历索引

  - #### 复合索引

    - ##### 多个字段的用户自定义索引，复合索引<font color='orange'>（Compound Index）</font> 

    - ##### 符合索引中列出的字段顺序具有重要意义。

  - #### 其他索引

    - ##### 地理空间索引（Geospatial Index）

    - ##### 文本索引（Text Indexs）

    - ##### 哈希索引（Hashed Indexs）





- ### 索引管理操作

  - #### <font color='red'>索引的查看</font>

    ```mysql
    db.collection.getIndexes()
    ```

    - ```js
      [
        {
          "v": 2,
          "key": {
            "_id": 1
          },
          "name": "_id_"
        }
      ]
      //系统会默认设置id为索引
      ```

    - ##### v： mongodb引擎索引版本 

    - ##### key： 系统或者用户创建的索引

    - ##### name：索引的名称，默认为字段名+_

  - #### <font color='red'>索引的创建</font>

    ```mysql
    db.collection.createIndex(keys,options)
    ```

    - ```mysql
      //创建单字段索引
      db.collection.createIndex({field:1})
      
      //创建多字段索引
      db.collection.create({field1:1,field2:-1})
      ```

    - createIndex() 接收可选参数，可选参数列表如下：

      | Parameter          | Type          | Description                                                  |
      | :----------------- | :------------ | :----------------------------------------------------------- |
      | background         | Boolean       | 建索引过程会阻塞其它数据库操作，background可指定以后台方式创建索引，即增加 "background" 可选参数。 "background" 默认值为**false**。 |
      | unique             | Boolean       | 建立的索引是否唯一。指定为true创建唯一索引。默认值为**false**. |
      | name               | string        | 索引的名称。如果未指定，MongoDB的通过连接索引的字段名和排序顺序生成一个索引名称。 |
      | dropDups           | Boolean       | **3.0+版本已废弃。**在建立唯一索引时是否删除重复记录,指定 true 创建唯一索引。默认值为 **false**. |
      | sparse             | Boolean       | 对文档中不存在的字段数据不启用索引；这个参数需要特别注意，如果设置为true的话，在索引字段中不会查询出不包含对应字段的文档.。默认值为 **false**. |
      | expireAfterSeconds | integer       | 指定一个以秒为单位的数值，完成 TTL设定，设定集合的生存时间。 |
      | v                  | index version | 索引的版本号。默认的索引版本取决于mongod创建索引时运行的版本。 |
      | weights            | document      | 索引权重值，数值在 1 到 99,999 之间，表示该索引相对于其他索引字段的得分权重。 |
      | default_language   | string        | 对于文本索引，该参数决定了停用词及词干和词器的规则的列表。 默认为英语 |
      | language_override  | string        | 对于文本索引，该参数指定了包含在文档中的字段名，语言覆盖默认的language，默认值为 language. |



- #### <font color='red'>索引的移除</font>

  ```mysql
  db.collection.dropIndex(index)
  //两种删除方式
  db.collection.dropIndex({field:1}}) //创建索引的参数
  
  db.collection.dropIndexes() //删除所有索引，_id不会被删除
  ```

  

