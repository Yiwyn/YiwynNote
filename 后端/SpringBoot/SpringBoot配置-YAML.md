## YAML

- ### yaml是以数据为核心,比传统的xml方式更为简洁

- #### 扩展名可以是yaml 或 yml.

- #### yaml书写格式

  - ```yaml
    server:
      port: 8082
      adress: 127.0.0.1
    ```

    ##### <font color='cornflowerblue'>缩进的形式代表父标签和子标签,数据前需要添加空格分隔</font>

- #### 基本语法

  - ##### 大小写敏感

  - ##### 数据值前必须有空格,作为分隔符

  - ##### 使用缩进代表层级关系

  - ##### 缩进时不能使用tab,只能使用空格<font color='red'>(各系统tab对应的空格数可能不同,导致层次混乱)</font>

  - ##### 注释符#

- #### 数据格式

  - ##### 对象(map):键值对的集合

    - ```yaml
      server:
        port: 8081
      #行内写法
      server: {port: 8081}
      ```

      

  - ##### 数组:一组按次序排列的值

    - ```yaml
      adress:
        - beijing
        - shanghai
      #  行内写法
      adress: [beijing,shanghai]
      ```

  - ##### 纯量:单个的,不可再分的值

    - ```yaml
      msg1: 'hello \n world' #单引忽略转义字符
      msg1: "hello \n world" #双引识别转义字符
      ```

  - ##### 参数引用

    - ```yaml
      name: lisi
      
      person:
       name: ${name} #引用上方定义的name值
      ```

      

    

