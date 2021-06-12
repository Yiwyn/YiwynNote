# if

​	

#### <font color='orange'>if 的作用:  当不能确定where的条件的时候,需要动态改变where 这时候可以用if判断字段的状态,满足则自动添加</font>



```xml
<select id="findByCondition" parameterType="com.yiwyn.domain.User" resultType="com.yiwyn.domain.User">
    select *
    from user
    where 1 = 1
    <if test="id!=0">
        and id = #{id}
    </if>
    <if test="username!=null">
        and username = #{username}
    </if>
    <if test="password">
        and password = #{password}
    </if>
</select>
```

#####   可以发现,使用方法和jstl中类似, if标签中test为判断条件

#### <font color='red'>注</font> 

#####  mybatis中定义了where  所以不需要我们自己写where 1=1 ,如下所示where标签包含即可

```xml
<where>
        <if test="id!=0">
            and id = #{id}
        </if>
        <if test="username!=null">
            and username = #{username}
        </if>
        <if test="password">
            and password = #{password}
        </if>
</where>
```



# foreach

#### <font color='orange'>foreach的作用:  当我们传入了同一个字段的很多参数 例如 id=1 or id=2 or id=3 这种</font>

```xml
<select id="findByIds" parameterType="list" resultType="com.yiwyn.domain.User">
    select *
    from user
    <where>
        <foreach collection="list" open="id in (" close=")" item="id" separator=",">
            #{id}
        </foreach>
    </where>
</select>
```

##### <font color='red'>分析</font>

###### 	

|    参数    |                      作用                      |
| :--------: | :--------------------------------------------: |
| collection |                  遍历对象类型                  |
|    open    |             开启时的内容(开头内容)             |
|   close    |            关闭时候的内容(结尾内容)            |
|    item    | 遍历传入集合的对象 类似jstl中foreach - var参数 |
| separator  |              分隔符,分割item对象               |





# 片段的抽取

#### mapper.xml文件中存在大量相同的sql代码,可以抽取出来使用

##### 抽取

```xml
<sql id="selectUser">
    select *
    from user
</sql>
```

##### 引用

```xml
<select id="findAll" resultType="com.yiwyn.domain.User">
    <include refid="selectUser"/>
</select>
```



###### 抽取使用<font color='red'>sql</font>标签 引用使用<font color='red'>include</font>标签