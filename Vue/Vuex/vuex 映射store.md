## <font color='red'>vuex映射</font>



- ### 作用
  - ##### 我们想要使用store中的数据的时候需要不断重复的书写 <font color='cornflowerblue'>$store.state</font> 或者 <font color='cornflowerblue'>$store.getters</font> 这个时候使用映射可以省去繁琐的写发







## <font color='red'>mapState、mapGetters使用过程</font>



- ##### 导入mapState（mapGetters）

  ```js
  import { mapState } from "vuex";
  ```

  

- ##### 在<font color='red'>computed</font>对象中 配置<font color='cornflowerblue'>mapState</font>对象

  ```js
   computed: {
      ...mapState({ sum: "sum" }),   //key：缩写的变量名字  value：store里面state中的属性
    },
  ```

  

- ##### 使用

  ```js
   <h2>当前求和为:{{ sum }}</h2>	
  ```

  - ##### 在computed定义之后在使用时可以直接使用key 





## <font color='red'>mapMutations、mapActions使用过程</font>



- ##### 导入省略

- ##### 在methods对象中配置mapMutations(mapActions类似)对象

  ```js
    methods: {
      .....
      ...mapMutations({ add: "ADD" }),  //ADD 方法在mutations中
      ...mapActions({ add: "add" })     //add 方法在actions中
    },
  ```

- ##### 借助mapMutations生成对应的方法，方法中会调用commit去联系mutations（对象写法）

- ##### 借助mapActions生成对应的方法，方法中会调用dispatch去联系actions（对象写法）

  - ###### 使用commit提交到mutations

  - ###### 使用dispatch发送到actios

- ##### 使用

  - ##### 因为使用了映射的方式，函数参数的传递需要在调用处使用，否则默认传入参数<font color='cornflowerblue'>event</font> 

    ```vue
     <button @click="add(Value)">+</button>
    ```

    







- ### vuex可以导入四个map方法

  - #### 映射mapXxxx对象的书写方式有两种 

    - ##### 对象写法 <font color='red'>如上</font>

    - ##### 数组写法

      ```js
       ...mapActions(["add"]) 
      ```

      - ##### 当映射名和实际定义命名一致的收，可以写在数组中