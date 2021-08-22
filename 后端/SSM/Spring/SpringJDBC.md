# Spring jdbcTemplate 基本使用



- #### 导入spring-jdbc 和spring-tx坐标

- #### 创建数据库表和实体

- #### 创建JdbcTemplate对象

  - ```java
    JdbcTemplate jdbc = new JdbcTemplate(DataSource)
    ```

- #### 执行数据库操作

  - ##### 更新操作

    - ###### update(sql,params)

  - ###### 查询操作

    - ###### query(sql,mapper,params)

    - ###### queryForObject(sql,mapper,params)



### <font color='red'>注</font>

#### <font color='orange'>queryForObject(sql,mapper,params)</font> 可以根据返回类型自定义返回的参数.例如单个对象,整数

