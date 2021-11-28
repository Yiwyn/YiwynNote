## <font color='red'>Stream API</font>



#### 为什么使用Stream

- #### 当我们对<font color='red'>集合</font>中的数据进行操作的时候，除了必须的添加，删除，获取外，最典型的问题就是遍历集合

- #### 使用stream可以使我们的代码对于集合的操作更加<font color='orange'>高效</font><font color='cornflowerblue'>整洁</font>

  ```java
  list.stream()
  ```

  



> #### <font color='cornflowerblue'>::（双冒号）</font> 使用
>
> - ##### 用作lambda表达式中，相当于对参数执行某个方法
>
> - ##### 格式 类名::方法名
>
> - ##### <font color='red'>例如</font> 
>
>   ```java
>   list.forEach(p->System.out.println(p));  //传统写法
>   list.forEach(System.out::println);		 //使用了 :: 的写法，上下都会对list进行遍历输出
>   ```



#### <font color='cornflowerblue'>stream</font>方法状态

![img](https://upload-images.jianshu.io/upload_images/20137031-76a6d9a3548eb882.png?imageMogr2/auto-orient/strip|imageView2/2/w/797/format/webp)





## <font color='red'>filter</font>



