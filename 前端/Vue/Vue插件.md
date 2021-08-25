# <font color='red'>vue 插件</font>





- #### 插件的本质是对象<font color='red'>{}</font>

- #### 对象之中必须包含 <font color='red'>install</font>

- ####  创建插件

  - ##### plugins.js

  - ```js
    //插件的基本格式
    const obj = {
        install() {
            alert("调用了插件");
        }
    }
    
    export default obj;
    ```

- #### 引入插件并应用

  - ```js
    import plugins from "./plugins"
    
    Vue.use(plugins);
    ```





## <font color='red'>插件的作用</font>

- #### 定义自定义全局指令 directive

- #### 定义过滤器 filter

- #### 定义混入 mixin



##### 插件中包含定义的内容，这样只需要在需要的地方来引入并使用插件即可

