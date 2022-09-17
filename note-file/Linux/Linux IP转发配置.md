##### 配置Linux系统的ip转发功能，首先保证硬件连通，然后打开系统的转发功能

##### `less /proc/sys/net/ipv4/ip_forward`，该文件内容为0，表示禁止数据包转发，1表示允许，将其修改为1。可使用命令`echo “1” > /proc/sys/net/ipv4/ip_forward` 修改文件内容，重启网络服务或主机后失效



##### 若要其自动执行，可将命令`echo “1” > /proc/sys/net/ipv4/ip_forward` 写入脚本`/etc/rc.d/rc.local`或者 在`/etc/sysconfig/network`脚本中添加 `FORWARD_IPV4=“YES”`



##### 想要永久生效的话，编辑`/etc/sysctl.conf`文件，修改成`net.ipv4.ip_forward = 1`，然后执行`sysctl -p`可以立即生效





<a href="..\\Docker\\宿主机ipv4.md" alt="链接">Docker文件夹中重复记录相关问题🔗</a>