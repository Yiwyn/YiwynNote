## <font color='red'>setup函数的两个参数</font>



- ##### props

- ##### context





## props



#### setup函数的第一个参数==props==，props是响应式的，当传入新的props时，它将被更新。

##### 	因为props是响应式的，不能使用ES6来解构它，会消除prop的响应式

##### 如果需要解构prop，可以在setup函数中使用toRefs函数来完成此操作

```javascript
<script>
import { toRefs } from "vue";
export default {
  props: {
    message: String,
  },

  setup(props) {
    const { message } = toRefs(props);
    console.log(message.value);
  }
</script>
```

##### 如果传入的prop是可选的prop，则传入的==props==中可能没有某个属性，这种情况下，toRefs将不会为这个属性创建一个ref，需要使用<font color='red'>toRef</font>代替他

```javascript
<script>
import { toRef, reactive } from "vue";
export default {
  props: {
    message: String,
  },

  setup(props) {
    const message = toRef(props, "message");
    console.log(message.value);
  }
</script>
```







## content



#### 上下文对象

- #### attr：值为对象，包含：组件外部传递进来，但没有在props配置中声明的属性，相当于 ==this.$attrs==

- #### slots：收到插槽内容，相当于 ==this.$slots== 

- #### emit：分发自定义事件的函数，相当于 ==this.$emit== 



#### context是一个普通的javascript对象，暴露了其他可能在<font color='red'>setup</font>中有的值，它不是响应式的，可以使用ES6语法解构





- #### emit使用

  ```vue
  //父组件
  <template>
    <SetupContext @hello="showHello" />
  </template>
  
  //....
  
  
  //子组件
  <template>
    <div>
      Context test
      <button @click="test">点击showHello方法</button>
    </div>
  </template>
  
  <script>
  export default {
    emits: ["hello"],
    setup(props, context) {
      function test() {
          //执行自定义事件Hello方法
        context.emit("hello", "yiwyn");
      }
      return {
        test,
      };
    },
  };
  </script>
  ```









- #### slot使用

  ```vue
  
  <template>
    <setup-context> 这是插槽内容 </setup-context>
  </template>
  d
  
  //子组件
  <template>
    <div>
      <slot></slot>
    </div>
  </template>
  ```

  - ##### 具名插槽

    ```vue
    //父组件
    <template>
      <setup-context @hello="showHello">
        <template v-slot:slot1> 插槽1内容 </template>
        <template v-slot:slot2> 插槽2内容 </template>
      </setup-context>
    </template>
    
    
    //子组件
    <template>
      <div>
        <slot name="slot1"> </slot>
        <slot name="slot2"></slot>
      </div>
    </template>
    ```

    

