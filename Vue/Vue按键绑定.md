## Vue中按键绑定



### <font color='red'>回车事件</font>

- ##### 当输入内容之后我们需要监听回车之类的按钮,这个时候我们有多种选择.

- ###### 原生:

  - html

    ```html
    <input type="text" placeholder="按下回车提醒输入" v-on:keyup="keyup">
    ```

  - js

    ```javascript
    keyup(e) {
        if(e.keycode==13)
    	console.log(e.target.value);
    }
    ```

- ###### Vue:

  - html

    ```html
    <input type="text" placeholder="按下回车提醒输入" v-on:keyup.enter="keyup">
    ```

  - js

    ```
    keyup(e) {
    	console.log(e.target.value);
    	console.log(e);
    }
    ```







<hr>



#### <font color='red'>常用按键别名</font>

###### 	回车 ==> enter

###### 	删除 ==> delete

###### 	退出 ==> esc

###### 	空格 ==> space

###### 	换行 ==> tab

###### 	上 ==> up

###### 	下 ==> down

###### 	左 ==> left

###### 	右 ==> right





#### vue绑定的方法添加了<font color='cornflowerblue'>按键的事件修饰符</font> ,按下相对的<font color='cornflowerblue'>按钮</font>执行该方法



### <font color='red'>注</font> 这里的常用按键<font color='fuchsia'>别名</font> 

##### 真是后缀是 event.key 所对应的键名

#### 对应到的key值

- ###### 若连续单词则变形  CapsLock ==> caps-lock  (全部变小写,单词间隔添加<font color='cornflowerblue'>**-**</font>)

- ###### <font color='red'>五个特殊的按键</font>

  - ###### tab  必须配合keydown使用   <font color='cornflowerblue'>@keydown.tab</font> 

  - ##### 配合keyup使用:按下修饰键的同时,按下其他键,事件才可以触发

  - ##### 配合keydown:直接按下直接使用

    - ###### ctrl 

    - ###### alt 

    - ###### shift 

    - ###### meta(windows键) 

  - ###### 例如<font color='red'>@keydown.ctrl</font> 





