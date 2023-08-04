#### t在java开发中，遇到需要数据长度校验的问题时；



#### 例：

##### 	在oracle数据库中，若某字段（msg）为varchar2(9) ， 同时数据库的编码为GBK(一个汉字两个字节)，则改字段最多可存4个汉字；

#### [注]如果使用的是类似MySQL的数据库，汉字和字母都是占用1位则不需要考虑这个问题



##### 在实际开发中，若直接使用 string.length()来获取字符串长度是不可行的，若传递参数都为汉字且大于4个，则保存数据库会保存；

##### 也就意味着在开发中，在java程序员对字符串长度限制应该做到以下两点：

- #####  确定使用的数据库的编码，确定汉字占用的位数

- ##### Java程序不能直接使用string.length()

  ```java
          String abc = "abc";
          System.out.println(abc.getBytes("GBK").length); //output 3 
  
          String hello = "你好";
          System.out.println(hello.getBytes("GBK").length); //output 4 
  ```

  