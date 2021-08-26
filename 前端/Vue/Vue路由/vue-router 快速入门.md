## <font color='red'>路由作用</font>



- #### vue的一个插件库，专门用来实现SPA应用



- #### SPA的理解

  - ##### 单页web应用（single page web application ,SPA）

  - ##### 整个应用只有一个页面

  - ##### 点击页面中的导航链接不会刷新页面，只会做网页的<font color='red'>局部刷新</font>

  - ##### 数据通过ajax请求获取









## <font color='red'>路由的理解</font>



- ##### 一个路由就是一组映射关系（key-value）

- ##### key为路径，value可能是function 或 component





- ### 路由分类

  - ##### 后端路由

    - ##### value为function ，用于相应客户端的请求

    - ##### 服务器接收到请求时，根据<font color='red'>请求路径</font>找到匹配的函数来处理请求，返回相应数据

    - ##### 本质就是传统的后端

  - ##### 前端路由

    - ##### value时component，用于展示内容

    - ##### 当浏览器的路径改变时，对应的组件就会展示







## <font color='red'>路由快速开始</font>



- #### 安装导入vue-router

  - ```shell
    npm i vue-router
    ```

- #### vue-router配置

  - ```js
    import Vue from 'vue'
    import App from './App.vue'
    
    //引用vue-router
    import VueRouter from "vue-router"
    
    // 引用路由器
    import router from './router/index';
    
    Vue.config.productionTip = false
    
    Vue.use(VueRouter)
    
    new Vue({
      render: h => h(App),
      router: router			//router文件需要单独文件创建
    }).$mount('#app')
    
    ```

  - ##### 这里和vuex是很相似的

- #### router文件创建

  - ##### 一般情况下放在目录 <font color='cornflowerblue'>src/router/index</font>中

    ```js
    // 该文件用来创建整个应用的路由器
    
    import VueRouter from 'vue-router';
    
    // 引入组件
    import About from '../components/About.vue';
    import Home from '../components/Home.vue';
    
    //创建并暴露一个路由器
    export default new VueRouter({
        routes: [
            {
                path: "/about",
                component: About
            },
            {
                path: "/home",
                component: Home
            }
    
        ]
    })
    ```

- #### 使用

  - ##### 在router文件中，使用键值对的形式对组件进行了绑定。

  - ##### 在html文件中，使用router的方式进行跳转 <font color='cornflowerblue'>router-link </font>标签<font color='fuchsia'>to</font>属性

    ```html
    		  <!-- 原始页面中使用a标签进行跳转 -->
              <!-- <a class="list-group-item active" href="./about.html">About</a>
              <a class="list-group-item" href="./home.html">Home</a> -->
    
    
              <!-- 使用路由实现页面的更新 -->
              <router-link class="list-group-item" active-class="active" to="/about"
                >About</router-link
              >
              <router-link class="list-group-item" active-class="active" to="/home"
                >Home</router-link
              >
    ```

  - ##### 使用<font color='fuchsia'>active-class</font>属性可以让点击的标签高亮显示（bootstrap）

  - ##### 在<font color='cornflowerblue'>router-link</font>中 添加属性 <font color='red'>replace</font> 则浏览器不会保存行为记录，不能前进和后退

  - ##### 点击了标签<font color='cornflowerblue'>router-link</font>，会在<font color='cornflowerblue'>router-view</font>中渲染出相应的组件
  
    ```html
     <router-view> </router-view>
    ```
  
  





## <font color='red'>注意点</font>



- ##### 一般情况下我们把<font color='red'>路由组件</font>单独放在<font color='cornflowerblue'>src/pages</font>文件夹下，一般组件放在<font color='cornflowerblue'>src/components</font>文件夹下

- ##### 使用rotuer切换时消失的组件会被销毁
