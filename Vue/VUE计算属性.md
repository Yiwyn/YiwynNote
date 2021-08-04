

#### 使用vue对输入内容进行处理并且进行输出的时候,vue官方建议我们使用方法的形式进行处理而不是在<font color='fuchsia'>{{}}</font>中进行处理.





##### 在Vue中 <font color='fuchsia'>{{}} </font> 中一般使用<font color='cornflowerblue'>data</font>数据,使用其他数据例如<font color='cornflowerblue'>function</font>即使返回值为string类型,依然会显示方法的定义字段.

##### 想要使用{{}}获取方法的返回值

- ##### {{}}中一定使用方法的形式来书写

- ```html
  {{message()}}
  <div> {{message()}}</div>
  ```

- ##### 这样传入的内容是方法的<font color='red'>返回值</font>而不是一个<font color='cornflowerblue'>事件</font> 





## <font color='red'>计算属性</font>(computed)

#### 	对于vue来说,data中数据就是属性.

#### 	计算属性的定义,和data一样,只不过vue定义中在<font color='red'>computed</font>中

- ##### 计算属性需要写成对象的形式,因为可能需要进行复杂操作

- ##### 计算属性对象中包含<font color='red'>getter</font>,可以<font color='cornflowerblue'>return</font>自己需要的内容

- ##### <font color='red'>计算属性的getter自带由缓存机制,多个计算属性出现时,只会调用一次getter方法</font> 

  - ##### <font color='cornflowerblue'>get</font>调用的时机

    - ##### 初次读取计算属性的时候

    - ##### 所依赖的数据发生了改变的时候

- ##### 计算属性也包含了<font color='red'>setter</font>,可以设置自己



#### <font color='cornflowerblue'>代码示例</font>

```js
const vm = new Vue({
				el: "#app",
				data() {
					return {
						message1: "",
						message2: ""
					}
				},
				computed: {
					message: {
						get() {											//get方法
							return this.message1 + " " + this.message2;
						},
						set(value) {									//set方法
							const arr = value.split('-');
							this.message1 = arr[0];
							this.message2 = arr[1];
						}
					}
				}

			})
```















## <font color='red'>计算属性--简写</font>

#### 	只有确定了只读不改才能使用简写

```js
computed: {
		message: function(){
		return this.message1 + this.message2;
			}
	}
```

- ##### 简写默认function为<font color='cornflowerblue'>get</font>方法 



