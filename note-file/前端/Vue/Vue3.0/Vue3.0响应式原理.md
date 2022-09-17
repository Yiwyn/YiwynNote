## <font color='red'>Vue3.0的响应式</font>



> #### vue2中存在问题
>
> - ##### 新增属性，删除属性，页面不会刷新
>
> - ##### 直接通过下标修改数组，界面不会改变

##### <font color='red'>以上问题在vue3.0中已经解决,实现归功于reactive</font>

```vue
<template>
  <div>
    {{ message }} <br />
    {{ person }} <br />
    {{ h }}
    <input type="button" value="修改第一个爱好为学习" @click="changeHobby0" />
    <input type="button" value="添加性别" @click="addInfo">
  </div>
</template>

<script>
import { toRefs, reactive } from "vue";
export default {
  props: {
    message: String,
  },

  setup(props) {
    const person = reactive({
      name: "Yiwyn",
      age: 18,
    });

    var hobby = ["抽烟", "喝酒", "烫头"];

    var h = reactive(hobby);

    function changeHobby0() {   //修改数组
      h[0] = "学习";
    }

    function addInfo() {		//添加属性
      person.gender = "男";
    }

    return {
      person,
      h,
      changeName,
      changeHobby0,
      addInfo,
    };
  },
};
</script>

```







## <font color='orange'>vue 响应原理</font>



#### <font color='red'>window.Proxy</font>

```javascript
//ES6中Proxy
var person = {
	//  .....  
}

//创建代理 需要两个参数，参数1：源对象  参数2：数据响应的回调
const p = new Proxy(person,{
    //获取值时调用
    get(target,propName){ //target:源对象 propName:get的参数名字   
        //..
        return target[propName];
    },
    //设置某个属性 或者 添加某个属性时调用 
    set(target,propName,value){  //target:源对象 propName:get的参数名字 value:设置的值
        //..
        target[propName] = value;
    },
    //删除某个属性时调用
    deleteProperty(target,propName){
        //..
        return delete target[propName];  //参数同上，但是需要返回值，成功删除则返回true 失败则false
    }
})  

//创建了代理 p ，这个时候 p和person 是映射关系， 修改了p的属性，这个时候person也会响应的被修改 
```



</br><hr></br>





#### <font color='red'>window.Reflect</font>（反射）

```javascript
let obj = {a:1,b,2}

Reflect.set(obj,"a",newValue)
Reflect.get(obj,"a")
Reflect.deleteProperty(obj,"a")
```

- #### Reflect 执行操作不会报错，他会把操作以返回值 boolean 的形式返回，在代码出现错误的时候不会因为错误操作而报错，这样可以有效的减少 try catch的使用









## <font color='red'>Vue3中响应式实现</font>



```javascript
        const person = {
            name: "Yiwyn",
            age: 18
        }

        // vue 响应式原理
        const pp = new Proxy(person, {
            get(target, propName) {
                console.log("获取target的值");
                return Reflect.get(target, propName)
            },
            set(target, propName, value) {
                console.log("设置属性的值");
                return Reflect.set(target, propName, value)
            },
            deleteProperty(target, propName) {
                console.log("删除属性");
                return Reflect.deleteProperty(target, propName)
            }
        })
```

- ##### 代理与反射对应操作