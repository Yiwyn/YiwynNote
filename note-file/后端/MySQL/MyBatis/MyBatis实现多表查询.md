- ## <font color='red'>案例1</font>

  - #### 在sql中 两个表相互独立，使用第三个表来联系连个表的关系。

    - ##### sql查询如下

      ```sql
      SELECT *
      from arcticle , arcticle_tag
      WHERE arcticle.id = arcticle_tag.arcticle_id and arcticle_tag.tag_id = ? 
      ```

    - ##### 这样可以根据id查询到想要的结果

  - ##### 在<font color='cornflowerblue'>mybatis</font>中

    - ##### mapper文件如下

      ```xml
      <select id="selectPage" resultMap="arcticle">
              select *
              from arcticle
          </select>
      
          <resultMap id="arcticle" type="top.yiwyn.domain.Arcticle">
              <id column="id" property="id"/>
              <result column="title" property="title"/>
              <result column="imgurl" property="imgurl"/>
              <result column="create_date" property="createDate"/>
              <result column="modify_date" property="modifyDate"/>
      
              <collection property="tagList" ofType="top.yiwyn.domain.Tag" column="id"
                          select="top.yiwyn.mapper.ArcticleMapper.selectAllTagById">
              </collection>
          </resultMap>
      ```

    - ##### ArcticleMapper文件如下

      ```xml
         <select id="selectAllTagById" resultType="top.yiwyn.domain.Tag" parameterType="int">
              select *
              from tag,
                   arcticle_tag
              where arcticle_tag.arcticle_id = #{id}
                and tag.id = arcticle_tag.tag_id
          </select>
      ```

      

    - ##### 因为两个表<font color='red'>相互独立</font>，所以查询结果需要使用<font color='cornflowerblue'>resultMap</font> 。

    - ##### 这个时候可以分为两种情况 

      - ##### 只是用两个表查询 如上 ，在处理另一个表的数据时，使用联系表中的主键，使用相关方法获取。本质上也是三个表，只是将操作分开

        - ##### <font color='cornflowerblue'>collection</font>标签中，column 属性的值 为 select属性使用函数的参数
      
      - ##### 使用三个表查询  两个and符号 ，获取所有的列名，这样在resultMap的<font color='cornflowerblue'>collection</font>中直接写对应关系，不需要使用column和select调用其他的mapper函数
      
      
    
  - #### 问题的本质为如何使用mybatis完善查询类的信息。

