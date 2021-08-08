## profile

#### 	作用: 进行动态配置切换



- ## profile配置方式

  - #### 多profile文件方式

    - ```properties
      spring.profiles.active = (application-)name
      ```

    - #### <font color='red'>例</font>

      - ![image-20210615121606774](F:\学习笔记\YiwynNote\SpringBoot\images\image-20210615121606774.png)

      - ```properties
        spring.profiles.active=dev
        ```

      - ##### 快速切换到dev模式

  - #### yml多文档方式

    - ##### yml文件中可以配置多个参数文件,使用<font color='red'> --- </font>来分割

    - ```yaml
      ---
      server:
        port: 8081
        
      spring:
        config:
          activate:
            on-profile: dev
      ---
      server:
        port: 8082
        
      spring:
        config:
          activate:
            on-profile: pro
      
      ---
      server:
        port: 8083
      
      spring:
        config:
          activate:
            on-profile: test
      
      ---
      
      spring:
        profiles:
          active: dev
      ```

    - ##### 如上所示,---分割的区域自定义别名,最后激活active

- ## profile激活方式

  - #### 配置文件

  - #### 虚拟级参数

    - ![image-20210615123235153](C:\Users\55971\AppData\Roaming\Typora\typora-user-images\image-20210615123235153.png)
  
    - ##### VM options: -D+(yml文件最后激活部分)
  
  - #### 命令行参数
  
    - ![image-20210615124014066](C:\Users\55971\AppData\Roaming\Typora\typora-user-images\image-20210615124014066.png)
  
    - ##### --+(yml文件最后激活部分)