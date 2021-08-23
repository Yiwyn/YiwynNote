## <font color='red'>Vue默认插槽</font>



- #### 使用组件标签的时候我们使用<font color='red'>双标签</font> 在标签中定义需要插入的内容

- #### 在组件中使用 <font color='cornflowerblue'>slot</font> 标签来接受插入的内容



### Code

- #### 组件

  - ```vue
    <template>
      <div>
        <h1>这个是组件的内容</h1>
    
        <slot>这个是默认插槽的内容</slot>		//知识点
      </div>
    </template>
    ```

- #### App.js

  - ```vue
    <template>
      <div id="app">
        <HelloWorld msg="Welcome to Your Vue.js App">
            <h2>这个是插入的内容</h2>		//置于中间的内容将来会插入到slot标签中
        </HelloWorld>
      </div>
    </template>
    ```







<hr>





## <font color='red'>具名插槽</font>



- #### <font color='red'>slot</font>标签指定<font color='cornflowerblue'>name</font>属性



### Code

- #### 组件

  - ```vue
    <template>
      <div>
        <h1>这个是组件的内容</h1>
        <slot name="top"> 这个是顶部插槽</slot>
        <slot name="middle"> 这个是中间部分的插槽</slot>
        <slot name="bottom">这个是最下面的插槽</slot>
      </div>
    </template>
    ```

- #### App.vue

  - ```vue
    <template>
      <div id="app">
        <HelloWorld msg="Welcome to Your Vue.js App">
          <h2 slot="top">这个是顶部的</h2>
          <h2 slot="middle">这个是中间的</h2>
          <h2 slot="bottom">这个是底部的</h2>
        </HelloWorld>
      </div>
    </template>
    ```

- ##### 依赖slot的name属性定义位置





#### 

- ### <font color='red'>使用场景</font> 

  - #### 组件的大体相同但是局部不同，可以使用slot来传入不同的部分

  - #### 在使用同一个组件的同时，定制化特殊的内容

  - #### 使用name具体插槽同一个slot标签不会覆盖，会同时存在多个





