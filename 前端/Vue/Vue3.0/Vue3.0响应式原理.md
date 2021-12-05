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





#### <font color='red'>window.Reflect</font>

```
l
```

​	