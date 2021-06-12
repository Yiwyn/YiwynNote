#### 说明:在访问的时候url附加的内容直接指定相关的参数

```java
@RequestMapping("/test11/{username}")
@ResponseBody
public void test11(@PathVariable("username") String username) {
        System.out.println(username);
}
```

###### 指定注解<font color='orange'>@PathVariable</font>,占位符<font color='red'>{x}</font> 和参数x对应,在访问时相当于 ?x = "参数" 的形式

#### <font color='red'>restful</font>风格使用"url+<font color='red'>请求方式</font>" 表达以此访问目的,HTTP协议中四个表示方式的动词如下

- GET:用于获取资源
- POST:用于新建资源
- PUT:用于更新资源
- DELETE:用于删除资源



##### 例如:

- /user/1 	GET: 得到 id = 1的user
- /user         POST:新增user
- /user/1     PUT:更新 id =1 的user
- /user/1     DELETE:删除 id = 1 的user