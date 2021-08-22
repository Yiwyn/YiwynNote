- ### 什么是AOP?

  - 面向切片编程
  - 通过运行期间动态代理实现

- ### 实现方式

  - ##### JDK动态代理

    - ###### 代码示例

      - ```java
        public static void main(String[] args) {
        
            //增强对象
            final Advice advice = new Advice();
        
            //目标对象
            final TargetInterface target = new TargetInterfaceImpl();
        
            //返回值 返回的就是动态生成你的代理对象.
            TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                    target.getClass().getClassLoader(), //目标对象的类加载器
                    target.getClass().getInterfaces(),  //目标对象相同的接口字节码对象数组
                    new InvocationHandler() {
                        //调用代理方法,实质上执行的都是invoke方法
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            advice.before();
                            Object invoke = method.invoke(target, args);
                            advice.after();
                            return invoke;
                        }
                    }
            );
        
            proxy.save();
        
        }
        ```

  - ##### 使用CGLIB实现的动态代理

    - ###### 导入jar包

    - ###### 代码示例

      - ```java
        public static void main(String[] args) {
        
            //增强对象
            final Advice advice = new Advice();
        
            //目标对象
            final TargetInterfaceImpl target = new TargetInterfaceImpl();
        
            //返回值 就是动态代理生成的对象 基于cglib
            //1.创建增强器
            Enhancer enhancer = new Enhancer();
            //2.设置父类
            enhancer.setSuperclass(target.getClass());
            //3.设置回调
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                    //执行前置
                    advice.before();
                    //执行目标
                    Object invoke = method.invoke(target, args);
                    //执行后置
                    advice.after();
        
                    return invoke;
                }
            });
            //4.创建代理对象
            TargetInterfaceImpl proxy = (TargetInterfaceImpl) enhancer.create();
        
            proxy.save();
        }
        ```

- ### Spring 的AOP简介

  - #### 术语

    - ###### Target(目标对象)  : 代理的目标对象

    - ###### Proxy(代理)           :一个类被AOP织入增强后,就产生一个结果的代理类.

    - ###### Joinpoint(连接点) :所谓连接点是指那些被连接的到的点.在spring中,这些点指的是方法,因为spring只支持方法类型的连接点.

    - ###### Pointcut(切入点)  : 所谓切入点是指我们要对哪些<font color='red'>Joinpoint</font>进行拦截的定义

    - ###### Advice(通知/增强): 所谓通知时指拦截到<font color='red'>**Joinpoint**</font>之后所要做的事情就是通知

    - ###### Aspect(切面)         : 是切入点和通知(引介)的结合

    - ###### Weaving(织入)    : 是指把增强应用到对应目标来创建新的代理对象的过程.spring采用动态代理织入,而AspectJ采用编译期织入和类装载织入

- ### AOP开发明确的事项

  - #### 需要编写的内容

    - ##### 编写核心业务代码(目标类的目标方法)

    - ##### 编写切面类,切面类中有通知(增强功能方法)

    - ##### 在配置文件中,配置植入关系.即将哪些通知与哪些连接点进行结合

  - #### AOP底层使用哪种代理方式

    - ##### 在spring中,框架会根据目标类是否实现了接口来决定采用哪种动态代理方法.

- ### 创建

  - #### 添加坐标

    - ```xml
      <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-context</artifactId>
          <version>5.0.5.RELEASE</version>
      </dependency>
      
      <dependency>
          <groupId>org.aspectj</groupId>
          <artifactId>aspectjweaver</artifactId>
          <version>1.8.13</version>
      </dependency>
      ```

  - #### 创建接口和目标

    - ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
             xmlns:context="http://www.springframework.org/schema/context"
             xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
      
          <!--    目标对象-->
          <bean class="com.yiwyn.aop.Target" id="target"/>
          <!--    切面对象-->
          <bean class="com.yiwyn.aop.MyAspect" id="aspect"/>
          <!--    配置织入,告诉spring框架 哪些方法(切点)需要进行增强(前置,后置)-->
          <aop:config>
              <!--        声明切片-->
              <aop:aspect ref="aspect">
                  <!--            切面:切点+通知-->
                  <aop:before method="before" pointcut="execution(public void 				   com.yiwyn.aop.Target.save())"/>
              </aop:aspect>
          </aop:config>
      
          <context:component-scan base-package="com.yiwyn"/>
      
      </beans>
      ```

    - #### 切点表达式的写法

      - ##### 表达式语法:

        - ```xml
          execution([修饰符] 返回值类型 包名.方法名(参数))
          ```

        - ###### 访问修饰符可以省略

        - ###### 返回值类型,包名,类名,方法名可以使用<font color='red'>*</font>星号 代表任意.

        - ###### 包名与类名之间一个点<font color='red'>.</font>代表当前包下的类,两个<font color='red'>..</font>表示当前包及其子包下的类

        - ###### 参数列表可以使用两个点<font color='red'>..</font>表示任意个数,任意类型的参数列表

          - ```xml
            <aop:before method="check" pointcut="execution(* com.yiwyn.aop.*.*(..))"/> //最常用写法
            ```

            表示返回值类型任意 com.yiwyn.aop 下的类及其子包下的类的任意方法(任意参数个数)的表达式

    - #### 通知的种类

      - #### around

        - ##### 定义

          ```java
          //ProceedingJoinPoint:正在执行的连接点 -- 切点
          public Object around(ProceedingJoinPoint pdj) throws Throwable {
              System.out.println("前置方法");
              Object o = pdj.proceed();
              System.out.println("后置方法");
              return o;
          }
          ```

        - ##### 使用

          - ```xml
            <aop:around method="around" pointcut="execution(* com.yiwyn.aop..*.*(..))"/>
            ```

            

