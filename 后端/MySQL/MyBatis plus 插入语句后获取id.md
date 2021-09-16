### Mybatis-plus中的<font color='red'>baseMapper</font>基类包含的insert方法



- #### 在默认情况下，insert方法在完成数据插入之后，实体的<font color='red'>自增</font>主键是不会自动赋值的，这个时候需要到相应的Mapper文件中 重写<font color='red'>insert</font>方法。

- #### 同时在<font color='cornflowerblue'>Mapper.xml</font>文件中添加 相应的sql语句。才能获取到。



- #### Code

  - ##### Mapper.java

    ```java
    @Component
    public interface ArcticleMapper extends BaseMapper<Arcticle> {
        int insert(Arcticle arcticle);
    }
    ```

    

  - ##### Mapper.xml

    ```xml
      <insert id="insert" useGeneratedKeys="true" keyColumn="id" keyProperty="id"
                parameterType="top.yiwyn.domain.Arcticle">
            insert into arcticle(id, title, content, imgurl)
            values (null,
                    #{title},
                    #{content},
                    #{imgurl})
        </insert>
    ```

    

