# 基于注解的AOP开发

- ## 快速入门

  - ### 创建目标接口和目标类(内部有切点)

  - ### 创建切面类(内部有增强方法)

  - ### 将目标类和切面类的对象创建权交给spring

  - ### 在切面类中使用注解配置织入关系

  - ### 在配置文件中开启组件扫描和AOP的自动代理

  - ### 测试






## 代码示例

- ### 	首先配置xml文件

  - 

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:aop="http://www.springframework.org/schema/aop"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
    
        <context:component-scan base-package="com.yiwyn.anno"/> //扫描
        <aop:aspectj-autoproxy/> //自动配置AOP
    
    </beans>
    ```

    

    ### 切片类

    ```java
    @Component("myAspect")
    @Aspect
    public class MyAspect {
    
        @Before("execution(* com.yiwyn.anno.*.*(..))")
        public void before() {
            System.out.println("前置增强");
        }
    
    }
    ```

    #### 流程简化,仅仅需要在切面类中配置织入注解关系即可

    ###### <font color='red'>@before</font> 参数与xml配置相同

    

    ### 注解通知种类

    ##### <font color='orange'>@通知注解("切点表达式")</font>

    

    #### 切点表达式抽取

    ```java
    @Component("myAspect")
    @Aspect
    public class MyAspect {
    
        @Before("pointcut()")
        public void before() {
            System.out.println("前置增强");
        }
    
    
        @Pointcut("execution(* com.yiwyn.anno.*.*(..))")
        public void pointcut() {
        }
    }
    ```
    
    ##### <font color='red'>注</font>:pointcut()方法仅仅作为<font color='orange'>@Pointcut</font>注解的载体.
    
    
    
    
    
    
    
    

