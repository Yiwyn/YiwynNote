- #### 前文中 -- <font color='red'>Hytrix服务降级</font> 中@<font color='orange'>FeignClient </font>添加参数<font color='cornflowerblue'>fallback</font>可以回调该接口实现类，实现类中实现的方法则是Hystrix服务降级时的回调函数，但是有些时候我们需要得到调用错误的返回信息，这个时候就要是要参数<font color='cornflowerblue'>FallbackFactory</font>





- #### Code

  - ##### service层代码

    ```java
    @Component
    @FeignClient(value = "STUDENT-SERVICE", fallbackFactory = SchoolHystrixService.class)
    public interface SchoolService {
        
        .....
    }	
    ```

  - ##### FallbackFactory实现

    ```java
    @Component
    public class SchoolHystrixService implements FallbackFactory<SchoolService> {
    
        @Override
        public SchoolService create(Throwable throwable) {
            return new SchoolService() {          //这里实现sevice层的方法，同时可以打印throwable的message
                @Override
               ....
            };
        }
    }
    ```

    

  