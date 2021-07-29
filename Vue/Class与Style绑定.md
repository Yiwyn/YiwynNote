- #### 使用<font color='cornflowerblue'>v-bind:class</font> (可缩写<font color='cornflowerblue'>:class</font>)绑定class,

- #### 只需要在方法中修改即可

- ```html
  	<div class="box" :class="style1" (v-bind:class="style1")>
          
      <script type="text/javascript">
  			new Vue({
  				 ...,
  				methods:{
                  	func(){
                  		this.style1 = xxxx;
              		}
              	}                
  			})
  	</script>
  ```

- ##### <font color='cornflowerblue'>:class</font> 可以使用<font color='red'>数组</font>赋值,则class 包含数组中所有的样式,并且可以随着数组的变化而变化





- #### 绑定style

- #### 使用<font color='cornflowerblue'>v-style</font> (可缩写<font color='cornflowerblue'>:style</font>)绑定class

- #### style也是键值对的形式

- #### 案例

  - ##### html代码

  - ```html
    	<div id="app">
    			<div class="box" :style="styleObj">  //:style 设置了数据绑定
    				<span>你好 我叫小娜</span>
    			</div>
    		</div>
    ```

  - ##### javaScripts

  - ```javascript
    <script>
    			new Vue({
    				el: "#app",
    				data: {
    					styleObj: {
    						backgroundColor: "red"		//这里是主要展示代码
    					}
    				}
    			})
    </script>
    ```

    

