## <font color='red'>SQL执行流程</font>





##### 执行流程图![image-20220312170317484](MySQL%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B.assets/image-20220312170317484.png)



## 查询流程：



- #### <font color='red'>查询缓存</font>：Server 如果在查询缓存中发现了这条SQL语句，就会直接讲结果返回给客户端；如果没有，就进入到解析器阶段。（查询缓存效率不高，mysql8.0之后抛弃了这个功能）

  - ##### 大多数情况下查询缓存命中率太低（空格，注释，大小写均会影响缓存命中）

  - ##### 5.x版本开启方法

    - ##### query_cache_type=0时表示关闭，1时表示打开，2表示只要select 中明确指定SQL_CACHE才缓存。

  <img src="MySQL%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B.assets/image-20220312171553053.png" alt="image-20220312171553053" style="zoom:67%;" />





- #### <font color='red'>解析器</font>：在解析器中对sql语句进行语法分析、语义检测

  

  <img src="MySQL%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B.assets/image-20220312173718088.png" alt="image-20220312173718088" style="zoom:67%;" />

  

  - ##### 分析器先做<font color='orange'>词法分析</font>，输入的多个字符换和空格组成一条SQL语句，MYSQL需要识别里面的字符串分别是什么，代表什么。

  - ##### 接着做<font color='orange'>语法分析</font>。根据词法分析的结果，语法分析器（比如：Bison）会根据语法规则，判断输入的这个sql语句是否满足sql语法

  - ##### 如果sql语句是正确的，则会生成语法树





- #### <font color='red'>优化器</font>：在优化器中确定SQL语句的执行路径，比如是根据 <font color='orange'>全表检索</font>，还是<font color='orange'>索引检索</font> 

  - ##### 经过解析器，mysql知道了要做什么，开始执行之前，还要经过优化器的处理。一条查询可以有很多种执行方式，最后都返回相同的结果。优化器的作用就是找到这其中最好的执行计划。





- #### <font color='red'>执行器</font>：

  - ##### 到了这一步，还没有真正的去读真实的表，仅仅是产生了一个执行计划，于是进入了<font color='orange'>执行器阶段</font> 

    <img src="MySQL%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B.assets/image-20220312182149795.png" alt="image-20220312182149795" style="zoom:67%;" />

  - ##### 执行的时候将调用<font color='orange'>执行引擎api</font> 例如 MyISAM、InnoDB 等 







## 总结



##### SQL语句在MySQL中的流程是：SQL语句 -> 查询缓存 -> 解析器 -> 优化器 -> 执行器