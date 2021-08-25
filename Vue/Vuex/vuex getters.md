## <font color='red'>getters</font>



- #### 这里的getter 就是属性中的get的集合

- #### <font color='red'>getters</font>对象同样定义在<font color='cornflowerblue'>store</font>对象中，与actives、mutation、state平行。

- #### getters中可以加工state中的数据



#### Code

- ##### getters中的对象类似computed中的对象直接写为方法的形式，参数为state

  ```js
  // 准备getters 将state中的数据进行加工
  const getters = {
      testSum(state) {
          return state.sum * 10;
      }
  }
  ```

- ##### 因为作为一个全新的配置项需要在创建的时候添加

  ```js
  
  export default new Vuex.Store({
      // actions: actions,
      // mutations: mutations,
      // state: state
      //因为参数和对象名字一致，触发简写
      actions,
      mutations,
      state,
      getters   //getters配置项
  })
  
  ```

  

