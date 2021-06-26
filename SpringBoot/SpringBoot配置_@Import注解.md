### <font color='orange'>@Import</font> 注解



#### <font color='orange'>@Enable*</font>底层依赖<font color='orange'>@Import</font>注解导入一些类,使用<font color='orange'>@Import</font>导入的类会被Spring加载到IOC容器中,而<font color='orange'>@Import</font>提供4种用法

- ##### 导入Bean

- ##### 导入配置类

  - ###### 导入配置类时,该配置类下的@Bean注解对象,不需要再单独使用@import导入,getbean()获取即可

- ##### 导入ImportSelector实现类.一般用于加载配置文件中的类

- ##### 导入importBeanDefinitionRegistrat



