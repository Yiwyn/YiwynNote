##### 在MyBatisX生成mapper文件 Oracle数据库新增数据



##### 因为oracle没有自增主键，所以使用sequence来创建自增序列。在insert中需要移除

```tex
useGeneratedKeys="true" keyProperty="id"
```

##### 若不移除上述两个属性，则新增数据会出现

```
索引中丢失in或out参数 :: [大于输入的数量的数字]
```

