### BeanMap 使用





> ##### 当获取到的参数为map，需要转换为实体类的时候，抑或是相反的情况。
>
> ##### 当时，相关转换的时候的对象的字段名和Map的键名必须要一致才可以进行相互转换



##### code：

```java
// 将Map转换为Bean 
	public MyBean GiteeUnit BuilderFromMap(Map param) {
        MyBean bean = new MyBean();
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(param);
        return bean;
    }


// 将Bean转换为Map
	public void BuilderFromMap(MyBean bean) {
        BeanMap beanMap = BeanMap.create(bean);
		//beanMap 则为bean对象映射出来的map对象
    }
```

