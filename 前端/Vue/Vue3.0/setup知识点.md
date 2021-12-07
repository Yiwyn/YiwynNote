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

