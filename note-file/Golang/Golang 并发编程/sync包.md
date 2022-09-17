## <font color='red'>Golang并发编程sync包</font>





- #### sync.Mutex 

  - ##### 创建互斥锁

  - ##### 具体使用类似java ReenterLock









- #### 原子变量

  - ##### <font color='orange'>sync/atomic</font> 包下包含了对不同类型的变量修改的原子操作方法

  - ##### Code

    ```go
    var i int32
    
    func addatom() {
    	atomic.AddInt32(&i, 1)
    }
    
    func subatom() {
    	atomic.AddInt32(&i, -1)
    }
    
    func main() {
    	for i := 0; i < 100; i++ {
    		addatom()
    		subatom()
    	}
        time.Sleep(1 * time.Second) //需要等待协程操作完毕
    	fmt.Printf("%v", i)
    }
    ```

    

