### Mapper接口开发需要遵循的规范

- #### 	Mapper. xml 文件中namespace与mapper接口的全限定名相同

- ####     Mapper接口方法名和Mapper.xml中定义的每个statement的id相同.

- ####     ParameterType的类型相同.

- ####     ResultType 的类型相同



### 使用方法

##### 		

```xml
<mapper namespace="com.yiwyn.dao.UserDao">
    <select id="findAll" resultType="user">
        select *
        from user
    </select>
</mapper>
```

###### 其中namespace和必须与接口的全限定名一致.



#### 使用

```java
InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
SqlSession sqlSession = sqlSessionFactory.openSession();
UserDao mapper = sqlSession.getMapper(UserDao.class);
List<User> all = mapper.findAll();
for (User user : all) {
    System.out.println(user);
}
```

###### 其中 使用的时候直接使用<font color='red'>sqlSession.getMapper(UserDao.class);</font> 即可获取接口代理对象.