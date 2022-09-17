## <font color='red'>fs（文件系统）</font>



### 中文官方API [fs 文件系统 | Node.js API 文档 (nodejs.cn)](http://nodejs.cn/api/fs.html)





- #### 在node中，通过<font color='cornflowerblue'>fs模块</font>和文件将进行交互

- #### 使用fs模块，需要先进行加载

  - ```js
    const fs = require("fs");
    ```

- #### fs中所有操作可以分为 <font color='red'>同步 </font>和 <font color='red'>异步</font>





## <font color='red'>文件操作Code</font>



- ### 同步文件写入

  - ```js
    fs.openSync("./test.txt", "w");
    ```

    - #### flags 

      - ##### r 只读的

      - ##### w 可写的

  - ```js
    //取得fs对象
    const fs = require("fs");
    
    //取得文件对象（其实获取的是编号）
    var fd = fs.openSync("./test.txt", "w");
    
    //写入数据
    fs.writeSync(fd, "今天天气真不错");
    
    //关闭资源
    fs.closeSync(fd);
    ```



- ### 异步文件写入

  - ```js
    //和同步的参数类似，但是加入了回调函数，因为不是同步操作所以需要回调参数返回结果
    var fd = fs.open("./test.txt", "w", function (err, fd) {
        console.log(fd);
    });
    ```

    - #### 回调方法包含两个参数

      - ##### err 错误对象，没有错误则返回<font color='cornflowerblue'>null</font>

      - ##### fd 文件对象（获取的是编号）同上同步操作

  - ```js
    const fs = require("fs");
    
    var fd = fs.open("./test.txt", "w", function (err, fd) {
        fs.write(fd, "这个是异步方法的写入", function (err, writen, str) {
            console.log(err);
            console.log(writen);
            console.log(str);
    
            fs.close(fd, function (err) {
                console.log("文件已关闭");
            })
        });
    });
    
    ```

  - ##### 异步的函数都会有一个回调函数来执行本次操作完成之后的事件



