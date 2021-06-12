# BaseTypeHanle

#### 当查询数据库的时候有些时候查询到的类型并不是我们需要的,这个时候就需要我么自己自定义类型转换了.

- #### 编写java代码

#### 使用接口<font color='red'>BaseTypeHandler<Type></font>

```java
public class DateTypeHandle extends BaseTypeHandler<Date> {


    //将java类型转换成数据库需要的类型 这里date ---> long
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long time = parameter.getTime();
        ps.setLong(i, time);
    }

    //将数据库中的类型转换成为java类型
    //ResultSet 查询到的结果集
    //下同
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
```

#### 

- #### 配置文件

###### 在sqlMapConfig中配置

```xml
<typeHandlers>
    <typeHandler handler="com.yiwyn.handle.DateTypeHandle"/>
</typeHandlers>
```

