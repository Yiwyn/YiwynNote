## SQLite使用流程

- ##### 继承SQLiteOpenHelper类自定义数据库类

  - ```java
      public class DBHelper extends SQLiteOpenHelper{   }
    ```

- ##### 创建构造函数,重写方法

  - ```java
    //带有全部参数的构造函数，此构造函数是必须需要的。Eclipse和Android Studio均有自动填充功能
    public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
    }
    ```

  - ```java
     @Override
       public void onCreate(SQLiteDatabase db) {
           //创建数据库sql语句
           String sql = "create table user(name varchar(20))";
           //执行sql语句
           db.execSQL(sql);
       }
       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       }0
    ```

- ##### CURD操作

  - ##### 创建DBHelper对象

  - ```java
    BHelper dbHelper = new DBHelper(MainActivity.this, "info.db",null,1);
    
    SQLiteDatabase db = dbHelper.getWritableDatabase(); //写对象
    ```

  - ##### 增

    - ```java
       db.insert();
      //示例
       
      //实例化常量值   
      ContentValues cValue = new ContentValues();   
      //添加key  
      cValue.put("key",value);      
      //调用insert()方法插入数据   
      db.insert("table_name",null,cValue);   
      ```

  - ##### 删

    - ```java
        db.delete();
      ```

  - ##### 改

    - ```java
        db.update();
      ```

  - ##### 查

    - ```
        db.query();
        
        //查询结果为Corsor类
      ```

      

  