## <font color='red'>@Transactional</font>



> [spring 中事务注解@Transactional与trycatch的使用_java_脚本之家 (jb51.net)](https://www.jb51.net/article/215488.htm) 

##### 

- #### @Transactional  触发条件

  - ##### 默认情况下 被注释方法需要抛出 <font color='cornflowerblue'>RunTimeException</font> 异常，SpringBoot才会触发事务回滚

    - ##### Spring默认情况下会对运行期例外(RunTimeException)进行事务回滚。这个例外是unchecked 如果遇到checked意外就不回滚。

    - ##### <font color='red'>如何改变默认规则：</font>

      * ##### 让checked例外也回滚：在整个方法前加上 <font color='red'>@Transactional(rollbackFor=Exception.class)</font>

      - ##### 让unchecked例外不回滚： <font color='red'>@Transactional(notRollbackFor=RunTimeException.class)</font>

      - ##### 不需要事务管理的(只查询的)方法：<font color='red'>@Transactional(propagation=Propagation.NOT_SUPPORTED)</font>

      - ##### 如果不添加rollbackFor等属性，Spring碰到Unchecked Exceptions都会回滚，不仅是RuntimeException，也包括Error

  - ##### Transactional需要捕捉到异常才可以进行<font color='red'>rollback</font>操作，当使用了 try catch 捕捉了之后需要将异常抛出被注解感知到才可以回滚 

    ```java
     @Transactional
        public void addMoney() throws Exception {
            //先增加余额
            accountMapper.addMoney();
            //谨慎：尽量不要在业务层捕捉异常并处理
            try {
                throw new SQLException("发生异常了..");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    //以上代码不会触发回滚，因为在处理异常时将异常捕捉了没有进行操作，推荐做法，若非业务要求，则在业务层统一抛出异常，然后控制层统一处理。
    
    @Transactional
        public void addMoney() throws Exception {
            //先增加余额
            accountMapper.addMoney();
            //推荐：在业务层将异常抛出
            throw new RuntimeException("发生异常了..");
        }
    ```

    

​	



### try catch和事务嵌套 共同影响

#### ==结论==

**结论一：**

##### 对于@Transactional可以保证RuntimeException错误的回滚，如果想保证非RuntimeException错误的回滚，需要加上rollbackFor = Exception.class 参数。

**结论二：**

##### try catch只是对异常是否可以被@Transactional 感知 到有影响。如果错误抛到切面可以感知到的地步，那就可以起作用。

**结论三：**

##### 由于REQUIRED属性，“两个事务”其实是一个事务，处理能力看报错时刻，是否添加了处理非RuntimeException的能力。