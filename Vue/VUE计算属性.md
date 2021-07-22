#### 使用vue对输入内容进行处理并且进行输出的时候,vue官方建议我们使用方法的形式进行处理而不是在<font color='fuchsia'>{{}}</font>中进行处理.





##### 在Vue中 <font color='fuchsia'>{{}} </font> 中一般使用<font color='cornflowerblue'>data</font>数据,使用其他数据例如<font color='cornflowerblue'>function</font>即使返回值为string类型,依然会显示方法的定义字段.

##### 想要使用{{}}获取方法的返回值

- ##### 使用容器来包裹{{}}对象 例如

- ```html
  <div> {{func()}}</div>
  <span> {{func()}}</span>
  ```

- ##### 这样则可以正常渲染方法的返回值

