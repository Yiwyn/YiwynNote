axios简化操作
ES6之后推出的新的代码规范，目的简化现有的axios ajax代码，提高用户的开发效率

async-await关键字
async - await是简化axios的一种全新的使用方式

async作为一个关键字放在函数前边,任何一个async函数都会隐式返回一个promise;
await 关键字只能在使用async定义的函数中使用,await后面可以直接跟一个Promise实例对象,await 函数不能单独使用
async - await 是axios为了简化then()的一种全新的语法. 语法如此。且该用法只能用到Ajax请求中.

操作方法
axios的简化操作的写法：
使用关键字修饰axios方法，将axios的查询方法以后端编程的思维将其编写出来

                async function findAll2(){undefined
                //解构赋值操作
                //async表示函数 await表示获只取数据请求
                let promise = await axios.get("/findAll")
                console.log(promise)
            }

测试
光说不练假把式，我们使用5个测试来具体描述简化操作。

测试0：
 删去了两个关键字，结果无法获取到数据，说明这两个关键字是简化操作的核心之一

             // 定义函数0
            function findAll0(){
                //解构赋值操作
                let promise = axios.get("/findAll")
                console.log(promise)
            }


 测试1和测试2
从结果可以看到，方法1和方法2唯一区别就是方法2获取的数据更加准确

            // 定义函数1
    		async function findAll1(){
    			//解构赋值操作
    			let promise = axios.get("/findAll")
    			console.log(promise)
    		}
    		// 定义函数2
    		async function findAll2(){
    			//解构赋值操作
    			//async表示函数 await表示获只取数据请求
    			let promise = await axios.get("/findAll")
    			console.log(promise)
    		}


 方法3（推荐使用）
方法3可以非常精确的取到数据，它将Promise对象继续拆分，只获取数据result和执行代码的返回结果status（200，执行成功）

            //定义函数3
    		//async - await是简化axios的一种全新的使用方式
    		async function findAll3(){
    			//解构赋值操作
    			//let {data:数据变量名称,status:返回查询结果} =
    			//	await axios.axios方法 (URL)
    			let {data:result,status:status} = await axios.get("/findAll")
    			console.log(result)
    			console.log(status)
    		}


方法4
只查询数据，只要数据结果，不要其他

//定义函数4
			async function findAll4(){
				//解构赋值操作
				//let {data:数据变量名称} //查询结果不需要，可以不写
				let {data:result} = await axios.get("/findAll")
				console.log(result)
			}
 实际情况注意要点：
 实际情况下，有时我们需要进行弹窗提示或者遍历显示数据。此时推荐使用方法3

        let {data:result,status:status} = await axios.get("/findAll")

 如果使用let promise = axios.get("/findAll")，那么你获取的数据，可能会造成数据无法成功显示，造成以下错误

数据无法成功显示弹窗：



数据无法获取：



 具体html代码文件展示：
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>简化操作</title>
		<script src="js/axios.js"></script>
	</head>
	<body>
		<h1>
			简化操作
		</h1>
		<script>
			//定义请求的前缀
			axios.defaults.baseURL = "http://localhost:8090/axios"

			//axios查询调用
			/*axios.get("/findAll").then(
				promise => {
					console.log(promise.data)
				}
			)*/
	        // 定义函数0
			function findAll0(){
				//解构赋值操作
				let promise = axios.get("/findAll")
				console.log(promise)
			}
			// 定义函数1
			async function findAll1(){
				//解构赋值操作
				let promise = axios.get("/findAll")
				console.log(promise)
			}
			// 定义函数2
			async function findAll2(){
				//解构赋值操作
				//async表示函数 await表示获只取数据请求
				let promise = await axios.get("/findAll")
				console.log(promise)
			}
			//定义函数3
			//async - await是简化axios的一种全新的使用方式
			//1.async作为一个关键字放在函数前边,任何一个async函数都会隐式返回一个promise;
			//await 关键字只能在使用async定义的函数中使用,await后面可以直接跟一个Promise实例对象（data）,await 函数不能单独使用;
			async function findAll3(){
				//解构赋值操作
				//let {data:数据变量名称,status:返回查询结果} =
				//	await axios.axios方法 (URL)
				let {data:result,status:status} = await axios.get("/findAll")
				console.log(result)
				console.log(status)
			}
			//定义函数4
			async function findAll4(){
				//解构赋值操作
				//let {data:数据变量名称} //查询结果不需要，可以不写
				let {data:result} = await axios.get("/findAll")
				console.log(result)
				console.log(status)
			}
			//调用函数
			findAll1()
			findAll2()
			findAll3()
			findAll4()
			
		</script>
	</body>
