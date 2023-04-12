##### [同一个方法中，Mybatis多次请求数据库，是否要创建多个SqlSession会话？_一个请求是否成为一个sqlsession_Abstracted的博客-CSDN博客](https://blog.csdn.net/qq_16159433/article/details/121128555)



##### 在使用了事务的方法中，Mybatis会使用一个sqlSession，这就意味着在该事务中多次执行同一个sql语句得到的结果会是相同的。

##### 这样做可以提高事务的速度，但同样伴随一些<font color='red'>问题</font>例如

代码中需要生成不同的id，若是在事务中，并且循环生成多个，则会导致生成多个重复的id，导致程序出错。这个使用应<font color='red'>禁用缓存并且清洗缓存</font>（Mybatis实现）

```xml
mybatis 实现
<select id="xxxx" useCache="false" flushCache="true">
    xxxxx
</select>
```



##### 