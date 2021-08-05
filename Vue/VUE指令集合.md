# <font color='red'>按钮添加对象属性</font>

- #### html

  - ```html
    		<div id="app">
    			{{person.id}} <br>
    			{{person.name}} <br>
    			{{person.age}} <br>
    			{{person.gender}} <br>
    			<button type="button" @click.once="addSet()">添加性别</button>
    		</div>
    ```

- #### js

  - ```javascript
    		<script>
    			new Vue({
    				el: "#app",
    				data: {
    					person: {
    						id: 1,
    						name: "yiwyn",
    						age: 18
    					}
    				},
    				methods: {
    					addSet() {
    						Vue.set(this.person,"gender","男");
    					}
    				}
    			})
    		</script>
    ```



<hr>



#### <font color='red'>对象添加属性使用</font>  <font color='cornflowerblue'>Vue.set(obj,attr,value)</font>   

- ##### 使用这个方法可以让Vue为添加的<font color='fuchsia'>attr</font>属性自动生成setter 和 getter 使得前端页面可渲染。



<hr>











