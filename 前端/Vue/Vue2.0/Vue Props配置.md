# <font color='red'>props</font>



### 作用

- #### vue模板封装完成之后，数据需要是动态的，这个时候可以在使用的时候传入参数，渲染组件的时候加载参数



### 使用实例

- ### code
  - ```vue
    //定义处
    <template>
      <div>学校名字：{{ name }}</div>
    </template>
    
    <script>
    export default {
      props: ["name"],
    };
    </script>
    
    ```

  - ##### 只需要在props属性中配置相关的字符串数组外部使用时传入即可。

- #### 如果传入的数字，则在使用的时候前面添加<font color='red'>v-bind: </font> 或者  <font color='red'>:</font>（简写）

  - ##### 使用了v-bind的属性会把“”中的内容作为js来处理

- #### 也可以在定义传入参数的类型

  - ```js
    <script>
    export default {
      props: {
        name: String, //类型
        required:true   //必须的 
        default: "xx"    // 默认值
      },
    };
    </script>
    ```

- #### props的优先级更高

- #### props传递的参数是<font color='red'>不能修改</font>的

