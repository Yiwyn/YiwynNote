## <font color='red'>使用redisson的线程锁工具</font>







```java
@Autowired
private RedissonClient redissonClient;
```



<hr>



- ### 示例

  ```java
   RLock lock = null;
  
   try{
  	.....
       String lockKey = "Key";
             lock = redissonClient.getLock(lockKey);
  
       boolean res = lock.tryLock(1000, 1000, TimeUnit.MILLISECONDS);
       if (!res) {
       	return xxxx;
       }
   }catch(Exception e){
       ...
   }finally{
       if(lock!=null){
           lock.unlock();
       }
   }
  
  ```



<hr>



- ### 方法解析

  ```java
  redissonClient.getLock(lockKey);  //获取锁
  
  boolean res = lock.tryLock(1000, 1000, TimeUnit.MILLISECONDS);
  //用redissonClient获取到的锁 尝试锁 尝试时间param1 ， 锁住之后锁定时间param2，时间单位param3
  
   	/**
       * @param waitTime  等待时间
       * @param leaseTime 锁有效时间
       * @param unit      时间单位 小时、分、秒、毫秒等
       * @解析
  	 */
      boolean tryLock(long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException;
  
  ```

  