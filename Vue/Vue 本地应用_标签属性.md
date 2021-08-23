### <font color='red'>v-text</font>

###### 设置标签的文本值(textContent)

- ```html
  	<div v-text="spanText"> </div>
  ```

  

- ```js
  data: {	
  	spanText:"SpanText"
  	}
  ```

- ##### 整体替换使用标签,在标签中使用了<font color='red'>v-text</font>之后,标签中的内容将不会渲染, 拼接内容可以使用<font color='red'>{{}}</font>的形式,



<hr>



### <font color='red'>v-html</font>

###### 设置文本内容是和<font color='red'>v-text</font>一样的

###### 设置标签内的<font color='red'>innerHTML</font>

- ```html
  <div v-html="vhtml"> </div>
  ```

- ```js
  vhtml: "<h1>你好小娜</h1>"
  ```





<hr>







### <font color='red'>v-on</font>

###### 为元素绑定事件

###### 格式:

```html
<input type="button" value="事件绑定" v-on:"方法" />
```



##### 实例:

```html
<input type="button" value="绑定按钮"  v-on:click="click()"/>
```

```js
methods: {
		click:function(){
		alert("点击");
	}
}
```



##### 更简单的写法  

###### v-on:functionName -->@functionName

###### 可以使用@跟监听名字的形式直接添加方法

```html
<input type="button" value="绑定按钮" @click="click()" />
```



##### 使用函数修改渲染的数据

```js
change: function() {
		this.message = "hello Cortana"
}
```

###### <font color='red'>el</font>内绑定过的数据可以使用<font color='red'>this.</font>的形式获取并修改





##### <font color='red'>v-on</font>绑定的方法,默认传参数event,包含点击<font color='cornflowerblue'>按钮等的信息</font> ,如果需要自己传入参数,只需要 <font color='cornflowerblue'>v-on:click="func(paramete,$event)"</font> 这个时候第一(多)个值为我们传入的参数,而<font color='cornflowerblue'>$event</font>是固定语句,作为占位符提供给方法使用.在<font color='fuchsia'>methods</font> 中定义时,写入对应参数即可





<hr>



##### 

### <font color='red'>数据绑定</font>

- #### 数据绑定的核心是<font color='red'>view</font>和<font color='red'>model</font> ,重心在数据的传输上.

- #### <font color='red'>v-bind</font>单向数据绑定

  - ###### 使用该标签可以使<font color='fuchsia'>model</font>层的数据流向<font color='fuchsia'>view</font>层,但是view层的数据不会流向model层,所以<font color='fuchsia'>单向</font>

  - ###### v-bind:attr 可以缩写为:attr

- #### <font color='red'>v-model</font>双向数据绑定(该标签只能在<font color='cornflowerblue'>表单类(输入类)</font>标签中使用)

  - ###### 在下拉菜单<font color='cornflowerblue'>select</font>（不一定非在）中使用时候，v-model.number 可以将收集到的数据强制转换为数字

  - ###### 使用该标签可以使<font color='fuchsia'>model</font>层和<font color='fuchsia'>view</font>层的数据相互流通

  - ###### v-model绑定的是输入标签的属性 例如:value

  
  
  ```html
  <div id="app">
  			单向数据绑定: <input type="text" v-bind:value="data1" /> <br>
  			双向数据绑定: <input type="text" v-model:value="data1" /> <br>
  			//这个时候第一个input的值会随着第二个input的值改变,而第一个改变第二个不会改变
      		//第二个修改了model中的值,所以引起了第一个值的修改.
  		</div>
  
  		<script type="text/javascript">
  			new Vue({
  				el: "#app",
  				data: {
  					data1: "数据",
  				}
  			})
  		</script>
  ```

  
  
  





​	



