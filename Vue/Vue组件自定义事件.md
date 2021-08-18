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

