## <font color='red'>setup</font>



- #### vue中一个的配置项，值为一个函数

- #### setup是所有<font color='red'>Composition API</font> 的“表演的舞台”

- #### 组件中所用到的：数据、方法等，均要配置在setup中

- #### setup函数的两种返回值：

  - ##### 若返回一个对象，则对象中的属性、方法，在模板中可以直接使用。

  - ###### 若返回一个渲染函数，则可以自定义渲染内容。

- ##### Code

  ```vue
  <template>
    姓名：{{ name }}
    <button @click="sayHello">点击我 Hello</button>
  </template>
  
  <script>
  export default {
    name: "App",
    setup() {
      //字段
      let name = "yiwyn";
  
      //方法
      function sayHello() {
        alert(name + "说 Hello");
      }
      return {
        name,
        sayHello,
      };
    },
  };
  </script>
  ```

  - ##### vue3向下兼容。vue2时期的写法依然可行，但是不建议混用。当2和3冲突时，以3中的数据为主





- #### 这个时候直接修改<font color='red'>setup</font>中的值时无法做到响应式修改的，需要对要进行修改的数据进行处理 

  - ##### 使用<font color='red'>ref</font>函数对对象进行处理

    ```vue
    <template>
      姓名：{{ name }} <br />
      年龄:{{ info.age }} <br />
      爱好:{{ info.hobby }}
      <button @click="sayHello">点击我 Hello</button>
      <button @click="changeName">点击我 修改</button>
    </template>
    
    <script>
    import { ref } from "vue";
    
    export default {
      name: "App",
      setup() {
        //字段
        let name = ref("yiwyn");
        let info = ref({
          age: 18,
          hobby: "code",
        });
        //方法
        function sayHello() {
          alert(name.value + "说 Hello");
        }
    
        function changeName() {
          name.value = "cortana";
          info.value.age = 17;
        }
        return {
          info,
          name,
          sayHello,
          changeName,
        };
      },
    };
    </script>
    ```

  - ##### 包裹了ref的对象，在模板中会自动解析，直接输入对象名就可以获取值。

    - ##### ref 对基本类型处理依靠的是 Object.defineProperty()的<font color='cornflowerblue'>get</font>和<font color='cornflowerblue'>set</font>方法。

    - ##### ref对对象类型的数据，内部使用了<font color='red'>vue3.0</font>的一个函数---<font color='red'>reactive</font>函数





</br><hr></br>







## <font color='red'>reactive</font>



- 

