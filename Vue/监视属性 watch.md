## 监视属性的变化

#### 新属性<font color='red'>watch</font> 

#### 和<font color='cornflowerblue'>data</font>,<font color='cornflowerblue'>el</font>并列,和<font color='red'>computed</font>类似.

#### 观察对象以对象的形式写书,使用<font color='cornflowerblue'>handler()</font>函数就行观察 



### 示例:

```javascript
watch: {
	isHot: {
		handler(newValue, oldValue) {
				console.log(newValue, oldValue);
				}
			}
		}
```

#### <font color='cornflowerblue'>handler</font>拥有两个参数<font color='cornflowerblue'>newValue </font>和 <font color='cornflowerblue'>oldValue</font> 







### <font color='red'>其他参数</font>

##### <font color='cornflowerblue'>immediate</font>: boolean  // 可以让handler()方法初始化的时候调用一下



##### 同时<font color='red'>方法</font>也可以被观察 (methods中)







<hr>





# <font color='red'>深度监视</font>

##### 检测属性中包含的信息,例如数组中的某个数据,监视<font color='fuchsia'>多级数据</font>中所有属性的变化,添加属性<font color='cornflowerblue'>deep</font> 

```javascript
watch: {
		numbers: {
			deep:true,
			handler(newValue, oldValue) {
				console.log(newValue, oldValue);
				}
			}
		}
```

