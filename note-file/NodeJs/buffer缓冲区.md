## <font color='red'>Buffer（缓冲区）</font>



#### 官网API[Buffer 缓冲区 | Node.js API 文档 (nodejs.cn)](http://nodejs.cn/api/buffer.html)





- #### Buffer的结构和数组很像，操作的方法也和数组类似。

- #### 数组中不能存储二进制的文件，而buffer就是专门用来存储二进制数据

- #### 使用buffer不需要引入模块，直接使用即可

- #### 在buffer中数据都是二进制数据，但是显示时都是以16进制的形式显示

  - ##### buffer中每一个元素的范围是00-ff 0-255



## <font color='cornflowerblue'>Code</font>：

​	

```js
var str = "Hello Cortana";
var buf = Buffer.from(str);

console.log(buf.toString());
```



- ### 创建一个buffer

  - ```js
     Buffer.alloc(10); //创建大小为10的buffer
    ```

  - ##### 创建完成后buffer的大小是固定的，不能修改

  - ##### 修改buffer中元素的方式和数组是一样的

    - ```js
      var buf1  = Buffer.alloc(10);
      buf1[0] = 88;
      ```

- ### 创建一个不安全的buffer

  - ```js
    Buffer.allocUnsafe(10);  //buffer中可能含有敏感数据
    ```

  - ##### 性能好于alloc创建的buffer，但是不推荐使用。

