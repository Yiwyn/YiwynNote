#### 当我们注入的属性需要更多的需求时,这个时候<font color='cornflowerblue'>defineProperty()</font>方法给我们提供了更多的选择



- #### 要求注入的参数动态变化

  - ##### <font color='cornflowerblue'>get</font>方法来<font color='fuchsia'>return</font>参数

  - ```javascript
    var age = 18;
    Object.defineProperty(person, "age", {
    	get: function () {
    		return age;
    	}
    })
    ```

  - ###### 这样新添加的属性的值就和属性绑定起来

  - ##### 与之对应的还存在<font color='cornflowerblue'>set</font>属性

  - ```javascript
    Object.defineProperty(person, "age", {
    		//get属性
    		get: function () {  
    			return age;
    		},
        	//set属性,简化写法,在set中也可以简化写法
    		set(value) {
    			sout("修改了参数为:" + value);
    		}
    })
    ```

    

  

