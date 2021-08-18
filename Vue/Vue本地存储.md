# <font color='red'>localStorage</font>



#### 使用localStorage可以保存数据到本地，刷新网页也不会丢失数据



#### code

- ##### 保存数据

  ```js
   localStorage.setItem("key",value);
  ```

  

- ##### 读取数据

  ```js
  localStorage.getItem("todolist")
  ```



- ##### 配合使用<font color='red'>JSON</font>类来处理对象的保存。

  - ##### JSON.parse()               json转对象

  - ##### JSON.stringify(）       对象转json







- #### 读取小技巧

  - ##### 开始读取为null的时候可以使用逻辑语法进行赋值

  - ```js
    var obj  = JSON.parse(localStorage.getItem("todolist")) || []		//json转换空对象，并保证obj对象还是一个数组
    ```

    





