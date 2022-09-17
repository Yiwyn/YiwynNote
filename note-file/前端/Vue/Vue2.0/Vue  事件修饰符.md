### VUE中的事件修饰符

- #### <font color='red'>prevent:阻止默认事件;</font>

- #### <font color='red'>stop:阻止冒泡事件;</font>

- #### <font color='red'>once:事件只触发一次</font>

- #### capture:使用事件的捕获模式

- #### self:只有event.target是当前操作的元素才触发事件

- #### passive:事件的默认行为立即执行,无需等待事件回调执行完毕





#### 	使用案例

```html
<a href="http://www.yiwyn.top"  @click.prevent="">点击我去个人网站</a>
```

###### 这时候,默认的跳转事件就会被阻止了



#### <font color='red'>其他操作同理</font>



##### 修饰符是可以连续写的使用<font color='red'>.</font>分隔

```html
<a href="http://www.yiwyn.top"  @click.prevent.stop="">点击我去个人网站</a>
```



