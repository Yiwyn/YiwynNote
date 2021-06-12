- #### 创建Mapper.xml文件

  - ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper
            PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
    <mapper namespace="com.yiwyn.dao.UserDao">
    
        <select id="findAll" resultType="com.yiwyn.domain.User">
            select *
            from user
        </select>
    
    </mapper>
    ```

- #### 创建sqlMapConfig.xml文件

  - ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
            PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-config.dtd">
    
    <configuration>
      
        <mappers>
            <mapper resource="com/yiwyn/Mapper/UserMapper.xml"/>
        </mappers>
    
    </configuration>
    ```

  - #### sqlMapConfig.xml文件映射Mapper.xml文件

- #### 配置Spring的applicationContext.xml文件

  - ##### 导包 mybatis-spring mybatis spring-context

  - ##### 配置dataSource 依旧使用druid

  - ##### 配置sqlSessionFactoryBean bean对象 并设置参数dataSource 和 configLocation

    - ```xml
      <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sessionFactory">
          <property name="dataSource" ref="dataSource"/>
          <property name="configLocation" value="classpath:sqlMapperConfig.xml(mybatis配置路径)"/>
      </bean>
      ```

  - ##### 配置MapperScannerConfigurer bean对象 并设置参数 basePackage 和 sqlSessionFactroyBeanName (<font color='red'>上面</font>)

    - ```xnl
      <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer" id="scannerConfigurer">
          <property name="basePackage" value="com.yiwyn.dao"/>
          <property name="sqlSessionFactoryBeanName" value="sessionFactory"/>
      </bean>
      ```

- #### 代码接口添加注解Mapper

  - ```xml
    @Mapper
    public interface UserDao {
        List<User> findAll();
    }
    ```











- ### 扩展

  - #### 添加事务

    - ```xml
      <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="transactionManager">
          <property name="dataSource" ref="dataSource"/>
      </bean>
      
      <tx:annotation-driven transaction-manager="transactionManager"/>
      ```





# <font color='red'>注!</font>

#### mapper文件中namespace和接口全限定名一定相同

