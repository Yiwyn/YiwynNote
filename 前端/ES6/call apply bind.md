### <font color='red'>call，apply</font>



##### 方法可以指定方法的执行上下文（this）,通过call、apply、bind可以指定函数内部的this的指向。



```js
var newContainer = {
    name: 'nc name'
}

function hello(a, b) {
    console.log(this, a, b)
}

hello.apply(newContainer, [1, 2])
hello.call(newContainer, 1, 2)
```

- ##### call和apply在使用中基本相似，仅仅方法的入参的传递方式不同

  ```typescript
  apply(this: Function, thisArg: any, argArray?: any): any;
  //可以发现apply的参数传递是数组来传递的
  
  call(this: Function, thisArg: any, ...argArray: any[]): any;
  //call中参数的传递使用的逗号分隔参数的形式
  ```



#### <font color='red'>bind</font>

##### bind() 方法创建一个新的函数，在 bind() 被调用时，这个新函数的 this 被指定为 bind() 的第一个参数，而其余参数将作为新函数的参数，供调用时使用 (mdn)

##### 不同的就是返回值了，bind调用后返回一个原函数的拷贝，并拥有指定的 this 值和初始参数。说白了，就是返回了一个新的函数，这个函数中才被绑定了你指定的this和参数，call和apply调用就执行了，<font color='red'>bind需要手动调用返回的函数才行</font>

```js
function hello(a, b) {
    console.log(this, a, b)
}

var newContainer = {
    name: "nc name"
}

let resultFun = hello.bind(newContainer, 1, 2)

resultFun()
```

> ##### bind只能绑定一次，不能再给bind返回的函数再执行bind，结果始终是以第一次绑定为准
