## typeAliases

### 	自定义别名

- #### 		在mapper文件中经常出现xx.xx.xx内容的参数,可以直接使用简化字符代替

- ####         例如 com.yiwyn.dao.userDao ---> user

  - ##### 	在mapper中使用user ,在sqlmapconfig.xml中配置typealiases文件

  - ```xml
    <typeAliases>
        <typeAlias type="com.yiwyn.dao.UserDao" alias="user"/>
    </typeAliases>
    ```

    

