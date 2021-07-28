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