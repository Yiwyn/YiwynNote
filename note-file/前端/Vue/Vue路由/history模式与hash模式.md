## <font color='red'>hsah模式</font>



- ##### hash模式特征是路径 /#/

- ##### 兼容性强





## <font color='red'>history模式</font>



- ##### history模式的特是路径 /







## <font color='red'>如何修改router模式</font>



- ##### 在router中配置

  ```js
  const router = new VueRouter({
      mode: "history",
      routes: []
  )}    
  ```

- ##### mode的参数两个  "history " "hash"