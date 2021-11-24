## <font color='red'>multimap数据结构</font>





- ### 作用

  - ```java
    Multimap<String,String> myMultimap = ArrayListMultimap.create();
    ```

  - #### 插入数据的时候，当插入的时候<font color='cornflowerblue'>键(key)</font>名字一致时，<font color='cornflowerblue'>value</font>会以list的形式追加multimap的值中。



- ### 示例

  ```java
          myMultimap.put("Fruits", "Bannana");
          myMultimap.put("Fruits", "Apple");
          myMultimap.put("Fruits", "Pear");
          myMultimap.put("Fruits", "Pear");
          myMultimap.put("Vegetables", "Carrot");
  ```

  ```java
  		Collection<String> fruits = myMultimap.get("Fruits");
          System.out.println(fruits); //  [Bannana, Apple, Pear, Pear]
  ```



- ### 使用

  ```java
  List<String> FruitList  = new ArrayList<String>(fruits);  //这里的 fruits 来在示例中的get到的value
  //这样可以将 Collection<T>类型的参数转换为List方便后期使用
  ```
  
  

