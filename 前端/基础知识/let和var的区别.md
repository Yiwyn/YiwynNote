# <font color='red'>var 和 let 的区别</font>



### <font color='cornflowerblue'>不同点</font>

- #### var属于ES5 规范，let 属于ES6 规范

  

- #### var 有预处理机制，let没有。预处理机制既是声明提前

  - ##### <font color='red'>声明提前</font>：不管变量声明在函数什么位置，所有变量声明都会提升至函数顶部。

    - ##### 如：var a = 1 则在初始化的时候 <font color='red'>var a </font>会被提升到函数顶部（只是<font color='red'>var a;</font> 被提前 a=1 不会被提前）

  - ##### <font color='red'>注意</font>

    - ##### 声明变量一定要初始化 即 var a = 1

    - ##### 即使是函数内部，声明变量也要添加 var ，否则变量会自动提升为全局变量

    

- #### var 是全局作用域，let是块级作用域

  - ```javascript
    　　<script>    
            if(true) {
                var a = 1;
            }
            console.log(a);  //a仍然可以打印
        </script>
    
    
    　　<script>
            if(true) {
                let a = 1;
            }
            console.log(a); //会报错，a只有在if{}块中才可以被打印
        </script>
    ```

    

