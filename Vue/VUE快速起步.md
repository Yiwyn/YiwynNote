## VUE快速起步





- ### 导入Vue.js 

- ### 创建VUE实例对象,设置<font color='red'>el</font>属性和<font color='red'>data</font>属性

- ### 使用<font color='red'>模板语法</font>把数据渲染到页面上





- ##### js

```js
<script type="text/javascript">
			var vue = new Vue({
				el: '#app',
				data: {
					message: "你好 小娜"
				}

			});
</script>
```



- ##### html

```html
<div id="app">
	{{message}}
</div>
```







### <font color='red'>补充</font>:

- ####  在<font color='red'>el</font>的绑定过程中 ,也可以使用类选择器  <font color='cornflowerblue'>.Classsname</font> 

- ####  默认为id选择器 <font color='cornflowerblue'>#IdName</font> 

- #### 一般开发过程中使用id选择器,因为id选择器是唯一的

- #### 不能把vue挂载到html或者body上

