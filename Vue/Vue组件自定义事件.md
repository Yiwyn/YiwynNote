## <font color='red'>自定义事件</font>



#### 组件之间传递数据，子组件向父组件发送数据。

- ##### 方法一

  - ##### 传递方法对象，把在子组件调用父组件的传递过来的方法通过参数传递数据

    - ```vue
      //使用处
       <school :getSchoolName="getSchoolName" />
      
      //school 内部
       <button @click="sendSchoolName">发送学校姓名</button>
      
      //方法定义
       props: ["getSchoolName"],
        methods: {
          sendSchoolName() {
            alert("发送成功");
            this.getSchoolName(this.name);
          },
        },
      ```

    - ##### 这里使用<font color='red'>props</font>进行函数对象的传递。

- ##### 方法二

  - ##### 自定义事件的方法

    - ```vue
      //使用处
      <school v-on:yiwyn="getSchoolName" />
          
      //school内部
      <button @click="sendSchoolName">发送学校姓名</button>
      
      //方法定义
      methods: {
          sendSchoolName() {
            alert("发送成功");
            this.$emit("yiwyn", this.name);
          },
        },
      ```

    - ##### 使用<font color='red'>$emit</font>方法调用指令并且传入参数。

    - ##### <font color='red'>v-on:xxx</font>可以缩写为 <font color='red'>@xxx</font> 
  
- ##### 方法三

  - ##### 使用<font color='red'>ref</font>配合<font color='red'>$on</font>绑定自定义命令事件
  
    - ```vue
      //模板
      <school ref="school" />
      
      //school内部
       学校名字：{{ name }}
      <button @click="sendSchoolName">发送学校姓名</button>
      
      //自定义方法指定 in  App.vue
      mounted() {
        this.$refs.school.$on("yiwyn", this.getSchoolName);  //给yiwyn自定义指令绑定方法
      },
      
      //方法定义
      methods: {
          sendSchoolName() {
          this.$emit("yiwyn", this.name);
      }
      ```
  
  - ##### 这种方法可以选择延迟调用绑定自定义事件







## <font color='red'>总结</font>



- #### 主要差距在于在子组件处的调用方式。

- #### 父组件中的方法定义都是一样的

- #### 子组件处的调用方式主要取决于父组件的传递方式

  - ##### 使用prop传递 

  - ##### 使用v-on:[自定义指令] ="xxx"    在子组件处使用<font color='red'>$emit()</font>激活

  - ##### 使用<font color='red'>ref</font>配合<font color='red'>$on</font>绑定自定义指令   在子组件处使用<font color='red'>$emit()</font>激活









<hr>









## <font color='red'>解绑自定义事件</font>



- #### 解绑一个自定义事件

  - ```js
     this.$off("yiwyn");
    ```

- #### 解绑多个事件

  - ```js
    this.$off(["yiwyn","xxx"]);
    ```

  - ##### 多个事件名写在一个数组里面 

- #### 解绑所有的事件

  - ```
     this.$off();
    ```

    



