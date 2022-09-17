- ### 开发步骤

  - #### 导入PageHelper坐标

    - ```xml
      <dependency>
          <groupId>com.github.pagehelper</groupId>
          <artifactId>pagehelper</artifactId>
          <version>3.7.6</version>
      </dependency>
      
      <dependency>
          <groupId>com.github.jsqlparser</groupId>
          <artifactId>jsqlparser</artifactId>
          <version>1.0</version>
      </dependency>
      ```

  - #### 在mybatis核心配置文件中配置PageHelper插件

    - ```xml
      <configuration>
          <typeHandlers>
              <typeHandler handler="com.yiwyn.handle.UserHandle"/>
          </typeHandlers>
      
          //配置插件*************//
          <plugins>
              <plugin interceptor="com.github.pagehelper.PageHelper">
                  <property name="dialect" value="mysql"/> //设置语言种类 mysql
              </plugin>
          </plugins>
      	//******************//
      
          <mappers>
              <mapper resource="com/yiwyn/Mapper/UserMapper.xml"/>
          </mappers>
      
      </configuration>
      ```

  - #### 测试分页数据获取

    - ##### 只需要在Java代码中,查询语句之前设置PageHelper 参数即可

    - ```java
      package com.yiwyn.controller;
      
      import com.github.pagehelper.PageHelper;
      import com.yiwyn.dao.UserDao;
      import com.yiwyn.domain.User;
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.stereotype.Controller;
      import java.util.List;
      
      @Controller("userController")
      public class UserController {
      
          @Autowired
          UserDao userDao;
      
          public void test() {
      
              //设置分页相关参数
              PageHelper.startPage(1, 3);
      		//查询已经分页 自动添加sql中 limit 关键词
              List<User> all = userDao.findAll();
      
              for (User user : all) {
                  System.out.println(user);
              }
          }
      }
      ```





## <font color='red'>注!</font>

##### mybatis版本和PageHelper的版本一定不能相差太大,实测 3.7.6 可以使用







- ### 分页助手的分页的相关数据获取

  - ```java
    public void test() {
    
        //设置分页相关参数
        PageHelper.startPage(1, 3);
    
        List<User> all = userDao.findAll();
    
        PageInfo<User> pageInfo = new PageInfo<>(all);
    
        System.out.println(pageInfo.getPageNum()); //当前页
        System.out.println(pageInfo.getPageSize()); //每页条数
        System.out.println(pageInfo.getTotal()); //总条数
        System.out.println(pageInfo.getPages()); //总页数
        //很多***
    
    
        for (User user : all) {
            System.out.println(user);
        }
    }
    ```

  - ##### 在查询返回之后使用pageInfo对象获取查询到的对象,获取分页的相关数据

  