## <font color='red'>全局事件总线</font>



- #### 任意组件之间通信

- #### 全组件之间通信需要一个载体来做中间件

  - ##### 每个组件都能观察到该对象

  - ##### 使用Vue对象，每个项目只有一个Vue对象。

  - ##### <font color='red'>Vue.prototype</font> Vue的原型对象

- #### 例：

  - ##### <font color='red'>Vue.prototype.x = 99</font>对象

  - ##### 调用的时候只需要<font color='red'>this.x</font>就可以得到x的值，当vc中没有这个属性的时候，自动向上查找vm

  - ##### <font color='red'>Vue</font>的属性全局都可以访问到
  
- ##### 绑定事件需要使用<font color='red'>$emit $on $off</font> 方法，这就说明了原型对象扩展的对象是vm或者vc

  - ##### 达成<font color='red'>this.x.$emit()</font>  ...使用效果

- ##### 原型对象绑定vm

  - ```js
    new Vue({
        el: "#app",
        render: h => h(App),
        beforeCreate() {
            Vue.prototype.x = this;		//重点在这句
        }
    })
    ```

  - ##### 在Vue进行流程的最前给Vue原型对象添加傀儡对象

- #### <font color='red'>总结</font>

  - #### Code

    - ```js
      new Vue({
          el: "#app",
          render: h => h(App),
          beforeCreate() {
              Vue.prototype.$bus= this;
          }
      })
      ```

    - ##### 安装全局事件总线，事件之间的调动依赖<font color='cornflowerblue'>$bus</font>进行 

  - ##### Code展示

    - ##### main.js

      - ```js
        import Vue from "vue";
        import App from "./App.vue"
        
        new Vue({
            el: "#app",
            render: h => h(App),
            beforeCreate() {
                Vue.prototype.$bus = this;
            }
        })
        ```

    - ##### App.vue

      - ```vue
        <script>
            
        export default {
          methods: {
            getSchoolName(name) {
              this.msg = name;
            },
          },
          mounted() {
            this.$bus.$on("getName", this.getSchoolName);		//给$bus绑定事件,绑定的方法的this在当前对象
          },
        };
        </script>
        ```

    - ##### School.vue

      - ```vue
        <script>
            
        export default {
          methods: {
            sendSchoolName() {
              this.$bus.$emit("getName", this.name);   //触发自动事件
            },
          },
        };
        </script>
        ```

        





