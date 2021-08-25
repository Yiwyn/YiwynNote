## <font color='red'>Vue的生命周期</font>





#### <font color='orange'>Vue生命周期示意图</font>  [Vue 实例 — Vue.js (vuejs.org)](https://cn.vuejs.org/v2/guide/instance.html#生命周期图示)





- #### 生命周期方法和data，methods并列

  - ```js
    		new Vue({
      			el: "#app",
      			data: {
      				opacity: 0.5
      			},
      			mounted() {
      				console.log("mounted");
      			}
      		})
    ```

    

  

## <font color='red'>code</font>

- code展示代码：

```js
			new Vue({
				el: "#app",
				data: {
					opacity: 0.5
				},
				beforeCreate() {
					// 创建之前
					console.log("beforeCreater");
				},
				created() {
					//数据检测 ，数据代理在这里完成。
					console.log("Created");
				},
				beforeMount() {
					//挂载检测之前运行。
					console.log("beforeMount");
				},
				mounted() {
					// 真实dom加载完成
					console.log("mounted");
				}
			})
```





<hr>

##### 





## <font color='red'>beforeUpdate()</font>



- #### 生成新的dom，随后新的dom和旧的dom比较，最后完成页面得渲染。完成 <font color='red'>model → view </font>的更新

- #### 此实的数据的新的，但是页面是旧的



## <font color='red'>updated()</font>



- #### 此时，数据是新的，页面也是新的。页面和数据保持同步





<hr>



## <font color='red'>beforeDestroy()</font>

- #### vm<font color='red'>即将</font>被销毁的时候调用，此时的 data，methods等都处于可用状态



## <font color='red'>destroyed()</font>

- #### vm被销毁的时候调用，使用 <font color='cornflowerblue'>this.$destroy()</font> 在vue中进行销毁





### <font color='orange'>学习记录Code</font>：

```html
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>模板</title>
		<script src="./js/vue.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>

		<div id="app">
			{{message}}
			<h2 v-bind:style="{opacity}">学习VUE</h2>
		</div>

		<script>
			new Vue({
				el: "#app",
				data: {
					opacity: 0.5,
					message: "nihao"
				},
				beforeCreate() {
					// 创建之前
					console.log("beforeCreater");
				},
				created() {
					//数据检测 ，数据代理在这里完成。
					console.log("Created");
				},
				beforeMount() {
					//挂载检测之前运行。
					console.log("beforeMount");
				},
				mounted() {
					// 真实dom加载完成
					console.log("mounted");
					setInterval(() => {
						this.opacity -= 0.01;
						if (this.opacity <= 0) {
							this.opacity = 1;
						}
					}, 16)
				},
				beforeUpdate() {
					console.log(this.message);

				},
				updated() {
					console.log(this.message);

				}

			})
		</script>
	</body>

</html>

```

