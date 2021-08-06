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






# <font color='red'>Vue监控数组数据变化的原理</font>



- #### Vue中<font color='cornflowerblue'>数组</font>中得数据不会生成<font color='red'>get</font>、<font color='red'>set</font>方法，所以直接通过下标修改数据是不可行的<font color='orange'>（arr[index]=value）</font>，这样修改页面渲染不会生效，因为页面渲染依靠的是get、set方法，要修改数据中参数的方法 使用js原生的数组操作的方法，例如 push 添加、pop移除最后一位，可以直接渲染到页面上。 







