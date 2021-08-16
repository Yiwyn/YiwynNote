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


- #### <font color='red'>Vue监控数组数据变化的原理</font>



- #### Vue中<font color='cornflowerblue'>数组</font>中得数据不会生成<font color='red'>get</font>、<font color='red'>set</font>方法，所以直接通过下标修改数据是不可行的<font color='orange'>（arr[index]=value）</font>，这样修改页面渲染不会生效，因为页面渲染依靠的是get、set方法，要修改数据中参数的方法 使用js原生的数组操作的方法，例如 push 添加、pop移除最后一位，可以直接渲染到页面上。 

- ### <font color='red'>直接修改</font>

- #### Vue 将被侦听的数组的变更方法进行了包裹，所以它们也将会触发视图更新。这些被包裹过的方法包括：

  - `push()`
  - `pop()`
  - `shift()`
  - `unshift()`
  - `splice()`
  - `sort()`
  - `reverse()`

  你可以打开控制台，然后对前面例子的 `items` 数组尝试调用变更方法。比如 `example1.items.push({ message: 'Baz' })`

- ### <font color='red'>替换数组</font>

- #### 使用数组方法的返回值替换当前数组

  - ##### <font color='red'>filter </font>过滤器，遍历每个元素进行自定义判断。

    - ```js
      this.hobbies.filter((v) => {
      	return v.length > 1;
      })
      ```

      

  - ##### <font color='red'>concat</font>  合并函数

    - ```js
      this.hobbies.concat(["A", "B"]);
      ```

      

  - ##### <font color='red'>slice</font> 切片

    - ```js
      this.hobbies.slice(start,end);		 //对数组进行切割 start开始坐标 end结束坐标
      ```






<hr>




# <font color='red'>表单数据收集</font>



- #### <font color='red'>v-model</font>

- ```html
  			<form action="" method="post">
    				<label for="username">账号：</label>
    				<input type="text" name="username" v-model="username" /> <br>
    				<label for="password">密码：</label>
    				<input type="password" name="password" v-model="password" />
    				<br>
    				男：<input type="radio" value="男" v-model="gender" /> <br>
    				女：<input type="radio" value="女" v-model="gender" />
    			</form>
  ```

- ##### v-model：属性自动绑定<font color='cornflowerblue'>value</font>属性

- #### 提交表单数据

    - ##### 可以在form标签中添加<font color='orange'>@submit</font> 
    
- ```html
    		<div id="app">
        			<form @submit="show()">
        				<label for="username">账号：</label>
        				<input type="text" name="username" v-model:value="personInfo.username" /> <br>
        				<label for="password">密码：</label>
        				<input type="password" name="password" v-model="personInfo.password" />
        				<br>
        				男：<input type="radio" value="男" v-model="personInfo.gender" /> <br>
        				女：<input type="radio" value="女" v-model="personInfo.gender" />
        				确认：<input type="checkbox" name="输入" v-model="personInfo.isOk"/>
        				<br> <input type="submit" value="提交" />
        			</form>
        		</div>


    		<script>
    			new Vue({
    				el: "#app",
    				data: {
    					personInfo: {
    						username: "",
    						password: "",
    						gender: "",
    						isOk:""
    					}
    				},
    				methods: {
    					show() {
    						alert(JSON.stringify(this.personInfo));
    					}
    				}
    			})
    		</script>
    ```



- ##### <font color='cornflowerblue'>javaScripts</font>中<font color='red'>JSON.stringify(param)</font>可以对象转换为json数据并返回。





<hr>



# <font color='red'>v-cloak</font>



- #### 该指令没有值，Vue创建实例完毕并接管容器后，会删掉<font color='red'>v-cloak</font>属性

- #### 使用css属性配合v-cloak可以解决网速慢引起的页面显示<font color='red'>{{xxx}}</font>的问题

- #### css

  - ```css
    		<style>
      			[v-cloak]{
      				display: none;
      			}
      		</style>
    ```

- #### html

  - ```html
    		<div id="app">
      			<span v-cloak> {{message}}</span>
      		</div>
    ```





<hr>




# <font color='red'>v-once</font>



- #### 该指令没有参数

- #### 添加了该指令的数据，会保持初始化的值。不会随着数据的改变而变化

- ```html
  	<div id="app">
  		<span v-once> {{message}}</span>
  	</div>
  ```

- #### 这样，message的数据无论发生什么变化，渲染显示的内容一直会是初始化，不会变化





<hr>




# <font color='red'>v-pre</font>



- #### 该指令可以跳过其所在节点的编译过程

- #### 跳过没有使用相关语法的节点，会加快编译

- ```html
  		<div id="app">
    			<span v-pre> {{message}}</span>
    		</div>
  ```









# <font color='red'>ref</font>



- #### 在传统的js里面我们查找元素使用的是<font color='red'>document</font>对象下的方法，在vue中使用这种代码不方便，我们通常使用<font color='orange'>ref</font>代替id

- #### code

  - ```html
     <h1 ref="msg" v-text="msg"></h1>
    ```

  - ##### 在vue中获取

  - ```js
    this.$refs.msg
    ```

  - ##### <font color='red'>$refs</font>中会包含所有的含有<font color='red'>ref</font>属性的元素

- #### 可以使用<font color='cornflowerblue'>ref</font>获取组件实例对象



