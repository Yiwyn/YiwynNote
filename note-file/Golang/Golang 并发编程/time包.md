## <font color='red'>Golang并发编程Timer包</font>





##### Timer顾名思义-计时器，可以实现一些定时操作，内部也是通过channel来实现







##### Code:

```go
func main() {

	timer := time.NewTimer(time.Second * 2)
	fmt.Printf("%v\n", time.Now()) 
	output := <-timer.C //C=channel  执行到此在未达到的时间之前会阻塞
	fmt.Printf("%v\n", output)
}
```

```go
func main() {
    //直接使用After 可以进行
	<-time.After(2 * time.Second)
	fmt.Printf("%v\n", "等待两秒输出")
}
```



### 扩展

```go
//自定义任务定时器
func newTimer(d time.Duration, action func()) *time.Timer {
	timer := time.NewTimer(d)
	go func() {
		<-timer.C
		action()
	}()
	return timer
}

func main() {

	timer := newTimer(10*time.Second, func() {
		fmt.Println("Hello I am Cortana")
	})

	defer timer.Stop()

	fmt.Println("执行完成")

	time.Sleep(20 * time.Second)
}
```

