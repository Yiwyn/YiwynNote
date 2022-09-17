# <font color='red'>vuex</font>



- ### vuex 概念

  - ##### 专门在Vue中实现<font color='red'>集中式</font>状态（数据）管理的一个Vue<font color='red'>插件</font>，对vue应用中多个组件的共享状态进行集中式的管理（读/写），也是一种组件间通信的方式，且适合<font color='red'>任意</font>组件间通信。

  - ##### 官方指引[Vuex 是什么？ | Vuex (vuejs.org)](https://vuex.vuejs.org/zh/)





- ### 什么时候使用Vuex

  - #### 多个组件依赖同一个状态（数据）

  - #### 来自不同组件的行为需要变更同一状态（数据）





## <font color='red'>快速开始</font>

- #### 下载&安装

  - ```js
    //shell中下载
    npm i vuex
    
    //js中导入
    import Vuex from "vuex"
    //Vue使用插件
    Vue.use(Vuex)
    
    ```

- #### 让所有的vm、vc拥有<font color='red'>store</font>对象

  - ##### main.js

    ```js
    const vm = new Vue({
      render: h => h(App),
      store: "hello"
    }).$mount('#app')
    ```

    - ##### 这里的<font color='red'>store</font>是使用了插件之后默认的语法对象，只有store对象可以在new Vue中被保存下来

    - ##### 这里的hello仅仅为测试值

- #### 创建store对象

  - ##### 创建<font color='cornflowerblue'>src/store/index.js</font>对象

  - ##### index.js

    - ##### code

      ```js
      //创建vuex中最核心的store
      
      //引入vuex
      import Vuex from "vuex"
      
      //引入vue
      import Vue from "vue"
      //使用插件
      Vue.use(Vuex)
      
      // 准备actios 用于相应组件中的动作
      const actions = {
      }
      
      // 准备mutations 用于操作数据(state)
      const mutations = {
      }
      
      // 准备state 用于存储数据
      const state = {
      }
      
      //创建store配置并暴露
      export default new Vuex.Store({
          // actions: actions,
          // mutations: mutations,
          // state: state
          //因为参数和对象名字一致，触发简写
          actions,
          mutations,
          state
      })
      ```

- #### 在<font color='cornflowerblue'>main.js</font>中引用自己创建的store

  - ```js
    import Vue from 'vue'
    import App from './App.vue'
    import store from "./store/index"
    
    Vue.config.productionTip = false
    
    new Vue({
      render: h => h(App),
      store: store  		// 可以触发简写
    }).$mount('#app')
    
    
    ```



- ### <font color='red'>注</font>
  - #### 为什么vuex对象的导入和使用要放入<font color='cornflowerblue'>index.js</font>文件中

    - ##### 在vue脚手架中 js在执行的时候，会先把<font color='red'>import</font>部分运行，不论import语句在哪一行。这就意味着 import 导入的模块中不能出现定义当前脚本的对象。

    - ##### 在vuex中 ， index.js文件会使用<font color='cornflowerblue'>Vuex.Store()</font> 如果不在index.js中导入和使用vuex对象，那么解析到这一行的时候就会报错，所以才会把vuex的导入和使用放在index.js文件中







- #### <font color='red'>完善index.js (store) 内部逻辑</font>

  - ###### <font color='fuchsia'>此处使用计算机示例</font>

  - ##### 数据存放在state中

    - ```js
      const state = {
          sum: 0,
      }
      ```

      

  - ##### 外部调用dispatch方法发送任务和参数

    - ```js
      this.$store.dispatch("add", this.inputValue);  
      ```

    - ##### store根据vue自动变为了<font color='cornflowerblue'>$store</font>的形式 dispatch()方法将方法名和参数传入<font color='cornflowerblue'> index.js </font>的 <font color='red'>actions</font>对象中

  - ##### index.js完善

    - ```js
      const actions = {
          add(context, value) {		//此处的方法传入的两个参数 1.上下文对象（类似安卓,可以当作miniStore） 2.函数传入的参数
              context.commit("ADD", value);
          }
      }
      
      const mutations = {
          ADD(state, value) {			//此处的方法有两个输惨 1.state对象，方便操作数据 2.函数传入的参数
              state.sum += value;
          }
      }
      
      const state = {
          sum: 0,
      }
      ```

- #### 模块渲染

  - ##### 渲染的数据来自state,故使用<font color='red'> $store.state.xxx</font> 即可

    - ```vue
       <h2>当前求和为:{{$store.state.sum}}</h2>
      ```





- ### <font color='red'>注</font>

  - #### 若dispatch()的内容在actios中没有任何操作直接commit()那么可以直接在 dispatch 处使用 commit()方法进行提交。

  - #### actions中的代码可以简化掉，直接在mutation中进行数据处理即可
  
  - #### actions 中可以连续使用dispatch()传递方法，当一个方法中的操作过多时，可以使用dispatch()到actions中的另一个方法。







