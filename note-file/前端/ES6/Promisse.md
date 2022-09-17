### <font color='red'>ES6 - Promise 用户</font>



##### Promise 通常用来解决异步调用多层嵌套问题，提高代码可读性。

##### Promise构造函数的原型对象上，有then()和catch()等方法，其中then()的第一个参数接收resolve()传来的数据。

````js
function click(state) {
    let c = new Promise((resolve, reject) => {
			if(state){
	            resolve("正确执行")                
            }else{
             	reject("错误执行")   
            }
    })
    return c;
}

click().then(res=>{
    console.log(res) //输出正确执行
})
````





### <font color='red'>ES7 async/await</font>



##### async/await是基于Promise实现的

##### 可以使异步代码像同步代码一样书写

- ##### async 的返回值是Promise对象。

- ##### await 右侧的表达式一般为promise对象

- ##### <font color='red'>await必须使用在async声明的函数中，async则不一定需要包含await</font> 

```js
function click() {
    let c = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve({ message: "正确执行" })
        }, 2000);
    })
    return c;
}

async function main() {
    var a = await click();
    console.log(a);
}

main()
```

