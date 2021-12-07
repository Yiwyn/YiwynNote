## <font color='red'>reactive与ref</font>



- #### 定义数据对比

  - ##### ref：<font color='red'>基本数据类型</font>

  - ##### reactive：<font color='red'>对象（数组）类型数据</font>

  - ##### <font color='orange'>备注</font>：ref也可以用来定义<font color='red'>对象类型数据</font>，它内部会通过==reactive==转为<font color='cornflowerblue'>代理</font>对象
  
- #### 原理

  - ##### ref通过 ==Object.defineProperty()==的get和set方法实现响应式（数据劫持）

  - ##### reactive 通过使用==Proxy==来实现响应式（数据劫持），并通过<font color='red'>Reflect</font>操作<font color='orange'>源对象</font>内部的数据

- #### 使用

  - ##### ref定义的数据，使用的时候需要 .==value==来获取值 ，在模板文件中不需要使用

  - ##### reactive定义的数据：操作数据与读取数据，不需要使用==.value==

    