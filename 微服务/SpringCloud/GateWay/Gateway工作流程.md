## <font color='red'>Gateway工作流程</font>



- ### 三大核心概念

  - #### <font color='red'>Route</font>(路由)：路由是构建网关的基本模块，他由<font color='orange'>ID</font>，<font color='orange'>目标URI</font>，一系列的<font color='orange'>断言和过滤器</font>组成，如断言为true则匹配该路由

  - #### Predicate(断言)：参考的