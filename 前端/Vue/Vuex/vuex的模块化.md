## <font color='red'>vuex模块化</font>





- #### 模块化问题分析

  - ##### 因为store几乎是固定语法，使用的常量总是 actions、state、mutations、getters几个，当实现多个功能的时候，每个对象中的参数会很难维护，着就意味着要进行模块化编程。









## <font color='red'>实践</font>



- ### store.js(index.js) Code

  ```js
  import Vuex from "vuex"
  import Vue from "vue"
  Vue.use(Vuex)
  
  //calcOption完整的配置项
  const calcOptions = {
      namespaced: true,							//重要的配置项
      actions: {
          add(context, value) {
              context.commit("ADD", value);
          },
          subtract(context, value) {
              context.commit("SUBTRACT", value);
          }
      },
      mutations: {
          ADD(state, value) {
              console.log("BEIDAIOYONG");
              state.sum += value;
          },
          SUBTRACT(state, value) {
              state.sum -= value;
          }
      },
      getters: {
          testSum(state) {
              return state.sum * 10;
          }
      },
      state: {
          sum: 0,
      }
  }
  
  export default new Vuex.Store({
      modules: {
          calcOptions,  //配置中声明模块对象
      }
  })
  
  ```

  - ##### 配置项中 <font color='red'>namespaced</font> ：是否开启命名，这个参数关系到使用的时候，在映射中的使用。







- ### 使用 vc模块 Code

  ```vue
  <template>
    <dir>
      <h2>当前求和为:{{ sum }}</h2>
      <h2>当前求和*10为:{{ testSum }}</h2>
  
      <select v-model.number="inputValue">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
      </select>
      <button @click="add(inputValue)">+</button>
      <button @click="subtract(inputValue)">-</button>
    </dir>
  </template>
  
  <script>
  import { mapState, mapActions, mapGetters } from "vuex";
  
  export default {
    data() {
      return {
        inputValue: 1,
      };
    },
    computed: {
      ...mapState("calcOptions", ["sum"]),							 //命名开启则可以使用这种语法，否则不能识别命名空间
      ...mapGetters("calcOptions", ["testSum"]),
    },
    methods: {
      ...mapActions("calcOptions", ["add", "subtract"]),
    },
  };
  </script>
  
  ```

  

- ##### 使用映射时，根据第一个参数选择解析对应store的配置。但是需要在该配置项中打开 <font color='red'>namespaced:true</font>  





<hr>





## <font color='red'>分文件的写法</font>



- #### 我们的store文件创建目录为 <font color='cornflowerblue'>src/store/xxx</font>,这就意味着我们可以给每项创建一个文件，每个文件中只需要暴露出 配置对象。

- #### <font color='cornflowerblue'>index.js</font>脚本中导入相关对象统一进行调度



#### Code：

- #### <font color='red'>calcOption.js</font>

  ```js
  export default {
      namespaced: true,
      actions: {
          add(context, value) {
              context.commit("ADD", value);
          },
          subtract(context, value) {
              context.commit("SUBTRACT", value);
          }
      },
      mutations: {
          ADD(state, value) {
              console.log("BEIDAIOYONG");
              state.sum += value;
          },
          SUBTRACT(state, value) {
              state.sum -= value;
          }
      },
      getters: {
          testSum(state) {
              return state.sum * 10;
          }
      },
      state: {
          sum: 0,
      }
  }
  ```

- #### <font color='red'>index.js</font>

  ```js
  import Vuex from "vuex"
  import Vue from "vue"
  Vue.use(Vuex)
  
  
  import calcOptions from "./calcOptions"
  
  export default new Vuex.Store({
      modules: {
          calcOptions,  
      }
  })
  ```

  