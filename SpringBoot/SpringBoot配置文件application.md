## application配置的两种方式

- ### 默认配置文件名称:application

  - ### application.properties

  - ### application.yml/.yaml

- ### <font color='red'>优先级 peoperties > yml>yaml</font>



### 内部配置加载顺序

- #### file:/config/:当前目录下的/config目录下

- #### file:/  :当前项目的根目录

- #### classpath:/config/  :classpath的/config目录

- #### classpath:/ ;classpath的根目录

