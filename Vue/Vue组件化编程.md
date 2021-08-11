## <font color='red'>组件</font>



- #### 好处：

  - ##### 复用代码

  - ##### 简化项目编码

  - ##### 提高运行效率







## <font color='red'>定义组件</font>



- #### 非单文件组件

  - ##### 一个文件中包含n个组件

  - #### 创建非单文件组件

    - ##### <font color='fuchsia'>创建组件</font>

      - ```js
        			const school = Vue.extend({
          				template: `
          				<div>
          				学校名称：{{name}} <br>
          				学校地址：{{address}} <br>
          				</div>
          				`,
          				data() {
          					return {
          						name: "xuexiao",
          						address: "diqiu"
          					}
          				}
          			})
        ```

      - ##### 此处不需要用el，因为组件需要复用，不能指定挂载节点。同时<font color='red'>data</font>必须为函数式，复用的情况下使用对象式会导致多处引用指向同一个对象，某一处修改则全部修改。函数式则是返回一个新的对象。

      - ##### 同时，<font color='red'>template</font>中可以换行的符号为<font color='cornflowerblue'>ESC键</font>下的<font color='red'>`</font>符号。

    - ##### <font color='fuchsia'>注册组件（局部注册）</font>

      - ```js
        			new Vue({
          				el: "#app",
          				components: {
          					school: school,  //key值为注册的变量名，value值为创建的中转值
                            xxxx:xxxx
          				}
          			})
        ```

      - ##### 只有注册之后的组件才可以使用。<font color='red'>当名称一样的时候需要写一个</font>

    - ##### <font color='fuchsia'>组件组件（全局注册）</font>

      - ```js
        Vue.component("school",school);
        ```

      - ##### <font color='red'>局部注册使用的更多</font>

    - ##### <font color='fuchsia'>使用组件</font>

      - ```html
        		<div id="app">
          			<school></school>
          		</div>
        ```

      - ##### 直接使用组件的标签

- #### 单文件组件

  - ##### 一个文件中之包含一个组件
  
    - ##### .vue文件中只有三个标签
  
      - ##### <font color='orange'>template、scripts、style</font> 
  
    - ##### school.vue
  
      - ```vue
        <template>
        	<div id="demo">
        		学校名字：{{name}} <br>
        		学校地址：{{address}}
        	</div>
        </template>
        
        <script>
        	const school = Vue.extend({
        		data() {
        			return {
        				name: "aaa",
        				address: "bbb"
        			}
        		}
        	})
        	// 外界导入使用import，所以vue文件需要
        	export default school
        </script>
        
        <style>
        	#demo {
        		background-color: antiquewhite;
        	}
        </style>
        ```
  
      - ##### 根据前面的知识，我们知道，模板的创建可以简写。
  
      - ```vue
        <script>
        	export default {
        		data() {
        			return {
        				name: "aaa",
        				address: "bbb"
        			}
        		}
        	}
        </script>
        ```
  
    - ##### 创建<font color='cornflowerblue'>App.vue</font>文件
  
      - ##### 同一配置使用Vue组件，在vm之下，方便管理
  
      - ```vue
        <template>
        	<div>
        		<school></school>
        	</div>
        </template>
        
        <script>
        	import school from './school.vue'
        	export default {
        		name: "App",
        		components: {
        			school
        		}
        	}
        </script>
        
        <style>
        </style>
        ```
  
      - ##### 统合使用vue组件
  
    - ##### 创建<font color='cornflowerblue'>js</font>文件，创建vm对象
  
      - ```js
        import App from "./App.vue";
        
        new Vue({
        	el: "#app",
        	components: {
        		App
        	}
        })
        ```
  
    - ##### 创建<font color='cornflowerblue'>html</font>文件并使用
  
      - ```html
        <html>
        	<head>
        		<meta charset="utf-8">
        		<title></title>
        	</head>
        	<body>
        		<div id="app">
        			<App></App>
        		</div>
        		<script src="../js/vue.js"></script>
        		<script src="./main.js" type="text/javascript" charset="utf-8"></script>
        	</body>
        </html>
        
        ```
  
    - #### <font color='red'>以上代码须在脚手架中使用，若不在则main.js报错导致页面空白</font> 







<hr>



## <font color='red'>VueComponent</font>

- #### 组件的本质是一个名为<font color='cornflowerblue'>VueComponent</font>的构造函数，且不是认为定义的，是Vue.extend生成的。

- #### 我们只需要写<xxx/> 、<xxx></xxx> ，Vue解析时会帮我们创建组件的实例对象，即Vue帮我们执行的：

  #### <font color='fuchsia'>new VueComponent(options)</font>

- #### 每次调用Vue.extend，返回的都是一个全新的VueComponent

- #### <font color='orange'>关于This的指向问题</font> 

  - ##### 组件配置中：

    - ##### data函数、methods函数、watch中的函数、computed中函数 他们的this 均为【VueComponent实例对象】

  - ##### new Vue(options)：

    - ##### data函数、methods函数、watch中的函数、computed中函数 他们的this 均为【Vue实例对象】









<hr>



## <font color='red'>组件的几个注意点</font>



- ### 关于组件名：

  - #### 一个单词组成

    - ##### 首字母大写 School

    - ##### 首字母小写 school

  - #### 多个单词组成

    - ##### kebab-case命名 my-school

    - ##### CamelCase命名 MySchool(需要Vue脚手架支持)

  - #### <font color='red'>备注</font>

    - ##### 可以使用name配置指定组件在<font color='red'>开发者工具</font>中显示的名字

      - ```js
        			const student = Vue.extend({
          				name:`stu`,
          				....
          				})
        ```

      - ##### 常见于一些第第三方组件库





- ### 关于简写

  - ```js
    const school = Vue.extend(options)  -->  const school = options
    ```

    





- ### 关于字符模板

  - #### 在<font color='red'>ES6</font>中引入了模板字符串

    - ```js
      `` //ESC键下的反撇号
      ```

    - ##### 在最简单的情况下，它和普通字符串符号 " ' 一样，不同的是：

      - ##### 支持多行书写

      - ##### 可以使用模板占位符 <font color='cornflowerblue'>${value}</font>

    - ##### 更多知识点可见<font color='red'>ES6</font> 





- ### 组件的嵌套

  - ##### ShowCode

    - ```js
      			const school = Vue.extend({
      				template: `
      				<div>
      				学校名称：{{name}} <br>
      				学校地址：{{address}} <br>
      				</div>
      				`,
      				data() {
      					return {
      						name: "xuexiao",
      						address: "diqiu"
      					}
      				}
      			})
      			const student = Vue.extend({
      				name:`stu`,
      				template: `
      				<div>
      				姓名：{{name}} <br>
      				学号：{{num}} <br>
      				<school></school>					//这里使用嵌套
      				</div>
      				`,
      				data() {
      					return {
      						name: "yiwyn",
      						num: "0001"
      					}
      				},
      				comments:{
      					school
      				}
      			})
      ```

      