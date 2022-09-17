## <font color='red'>Golang并发编程 select</font>





- #### select 是一个控制结构，类似于==switch==语言，用于处理异步IO操作，select会监听case语句的中的channel的读写操作，当case中channel读写操作为阻塞状态（可以读写）时，会触发相应动作

  > - ##### select 中case 必须是一个channel操作。
  >
  > - ##### select 中的default 子句总是可运行的

- #### 如果多个case都可以运行，select会随机公平的选择一个执行，其他的不执行

- #### 若没有可以运行的case语句，且有default语句，那么就会执行default的动作

- #### 如果没有运行的case语句，则没有没有default语句，select将会阻塞，直接某个case通信可以运行





#### Code

```go
var intchan = make(chan int)
var strchan = make(chan string)

func main() {

   go func() {
      intchan <- 2
      strchan <- "Hello"
      close(intchan)
      close(strchan)
   }()

   runtime.Gosched()

   select {
   case r := <-intchan:
      fmt.Printf("%v", r)
   case r := <-strchan:
      fmt.Printf("%v", r)
   default:
      fmt.Println("default")
   }
}
```