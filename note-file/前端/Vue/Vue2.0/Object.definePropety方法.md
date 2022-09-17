#### 该方法给<font color='red'>对象</font>定义属性



```javascript
<script type="text/javascript">
			let person = {
				name: " 张三",
				gender: "男"
			}
			Object.defineProperty(person,'age',{
				value:18
			})
			console.log(person)
</script>
```

###### 对<font color='red'>对象</font>进行修改

#### 被修改后的对象,新添加的属性默认是不会被遍历到的,

###### 可以在定义方法的参数中进行设置<font color='cornflowerblue'> enumerable: true</font> 控制属性是否可以被枚举(遍历)

```javascript
  Object.defineProperty(person, "age", {
      value: 19,
      enumerable: true
})
```





#### 同时,使用<font color='cornflowerblue'>defineProperty()</font>方法注入的属性是<font color='red'>不可以</font>进行修改的

###### 添加参数 <font color='cornflowerblue'>writable: true</font> 可以使数据可以进行写操作

```javascript
Object.defineProperty(person, "age", {
			value: 19,  
			enumerable: true,  
			writable: true
})
```





#### 属性是否可以被删除

- ##### 	在JavaScript中对象的属性是可以删除的,使用delete 方法

  - ###### 在控制台中

  - ```javascript
    delete person.name //正常的属性
    true
    
    delete person.age  //添加的属性
    false
    ```

- ###### 添加参数 <font color='cornflowerblue'>configurable: true</font> 可以使属性可配置(可删除)

  - ```javascript
    Object.defineProperty(person, "age", {
    			value: 19,
    			enumerable: true,
    			writable: true,
    			configurable: true
    		})
    ```





### <font color='red'>基本配置项目总结</font> 

- #### 使用<font color='cornflowerblue'>defineProperty()</font>添加的属性,可以在添加的时候做出限制,基本的如下

- ```javascript
  	Object.defineProperty(person, "age", {
  			value: 19,   			//属性的值
  			enumerable: true,		//属性是否可以被遍历
  			writable: true,			//属性是否可写
  			configurable: true		//属性是否可以删除
  		})
  ```













​	



