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





​	



