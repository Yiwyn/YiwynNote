# 拦截器(interceptor)的作用

#### 	类似于Servlet中的Filter作用,用于对处理器进行<font color='red'>预处理</font>和<font color='red'>后处理</font>

- #### 拦截器的创建

  - ##### 类实现HandlerInterceptor接口

  - ##### 重写三个方法

    - ###### preHandle 在目标方法执行之前 执行 <font color='red'>(目标方法: controller中的方法)</font>

    - ###### postHandle 在目标方法执行之后 视图返回之前 执行

    - ###### afterCompletion 在流程都完成之后执行

  - ##### 配置spring-mvc 

    - 
      
      ```xml
      <mvc:interceptors>
          <mvc:interceptor>
              <!--            对哪些资源进行拦截操作-->
              <mvc:mapping path="/**"/>
              <bean class="com.yiwyn.interceptor.MyInterceptor"/>
          </mvc:interceptor>
      </mvc:interceptors>
      ```
      
      ##### <font color='red'>MyInterceptor</font>是自定义的拦截器类,其中多个拦截器的顺序根据<font color='cornflowerblue'>interceptors</font>中的<font color='cornflowerblue'>interceptor</font>的顺序
      
    - ##### 对路访问径进行排除
    
      - ```xml
        <mvc:interceptors>
            <mvc:interceptor>
                <mvc:mapping path="/**"/>
                 <!--            排除路径-->
                <mvc:exclude-mapping path="/user/login"/>
                <bean class="com.yiwyn.interceptor.privilegeInterceptor"/>
            </mvc:interceptor>
        </mvc:interceptors>
        ```
    
        ###### <font color='red'><mvc:exclude-mapping path="/user/login"/></font>就是对路径的排除,路径来自<font color='cornflowerblue'>controller</font>的配置



#### <font color='orange'>例</font>	

```java
package com.yiwyn.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("yiwyn:执行方法" + "preHandle");
        return true; //返回值代表是否可以通过
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("yiwyn:执行方法" + "postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("yiwyn:执行方法" + "afterCompletion");
    }
}
```

