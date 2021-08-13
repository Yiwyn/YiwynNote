## <font color='red'>引入js文件</font>



- #### 使用<font color='cornflowerblue'>require</font>方法

- #### <font color='cornflowerblue'>require()</font> 方法中参数需要填入相对路径，一定是<font color='fuchsia'>./</font>或者<font color='fuchsia'>../</font>开头的路径

  - ```js
    require("./module01.js")
    ```

  - ##### 引入该js文件就会自动执行

- #### 每一个js文件可以当作一个闭包的域，这时候如果需要提供参数，需要使用<font color='cornflowerblue'>exports</font> 关键字。使用了<font color='cornflowerblue'>exports</font> 关键字的变量会被暴露出来被调用位置接收。

  - ```js
    //执行文件
    var m01 = require("./module01.js");
    console.log(m01.x);
    ```

  - ```js
    //模板文件
    console.log("这个是模板1");
    exports.x = 1;
    ```

- #### 简化写发，同时暴露出多个参数

  - ```js
    //模板文件
    console.log("这个是模板1");
    module.exports = {
        name: "yiwyn",
        age: 18,
        showName: function () {
            return this.name;
        }
    }
    ```

  - ```js
    //执行文件
    var m01 = require("./module01.js");
    console.log(m01.showName());
    ```

    

