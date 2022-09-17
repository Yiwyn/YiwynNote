- ### 作用：

  - #### 减化$router.xxx的写法





- ### <font color='red'>使用方法一</font>

  - ##### router配置中哪里需要传入参数在哪里配置<font color='cornflowerblue'>props</font>

    ```js
     {
         name: "detail",
         path: "detail/:id/:title",
         component: Detail,
         //props的第一种写法，值位对象，该对象中所有的key-value都会以props的形式传给Detail组件
         props: {key:value}
     }
    ```

  - ##### 在使用的地方和模块直接传递参数一样

    - ##### 在<font color='cornflowerblue'>new Vue()</font>中使用 <font color='fuchsia'>props</font>来接收

    - ##### <font color='red'>使用同方法二的使用</font> 

  - ##### <font color='orange'>不推荐使用，因为参数时死的不灵活</font> 





- ### <font color='red'>使用方法二</font>

  - ##### router配置中哪里需要传入参数在哪里配置<font color='cornflowerblue'>props</font>

    ```js
     {
         name: "detail",
         path: "detail/:id/:title",
         component: Detail,
         //props的第二种写法，若布尔值为真，则params参数都会以props的形式传给Detail组件
         props: true
     }
    ```

  - #### 使用

    - ```vue
      <template>
        <div>
          <ul>
            <li>消息编号:{{ id }}</li>
            <li>消息标题:{{ title }}</li>
          </ul>
        </div>
      </template>
      
      <script>
      export default {
        name: "Detail",
        props: ["id", "title"],
      };
      </script>
      ```







- ### <font color='red'>使用方法三</font>

  - ##### router配置中哪里需要传入参数在哪里配置<font color='cornflowerblue'>props</font> 

    ```js
     {
         name: "detail",
         path: "detail/:id/:title",
         component: Detail,
         //props的第三种写法，值为函数,通过返回值可以将query参数返回，使得query参数可以以props的形式传给组件
         props($route) {
             return {
                 id: $route.query.id,
                 title: $route.query.title
             }
         }
     }
    ```

  - ##### 使用同上<font color='cornflowerblue'>方法二</font>





<hr>





## <font color='red'>总结</font>



- ##### 以上三种写法的目的是方便组件中获取传递来的参数，同时三种写法不会干扰到目标组件的书写，因为目标组件无论如何都是<font color='fuchsia'>props</font>的形式接收参数。