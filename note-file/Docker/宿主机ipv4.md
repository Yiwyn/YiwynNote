> #### 当在docker中启动了项目，同时也关闭了防火墙的时候，外部访问依旧不通，这个时候可能就是ipv4没有配置



```shell
sudo  sysctl net.ipv4.ip_forward
#查看ipv4路由状态，1代表启动 0代表未启动

sudo vi /etc/sysctl.conf
#添加或者修改 net.ipv4.ip_forward=1

sudo systemctl restart network
#重启网络服务
。。。。
#重复第一步查看状态是否为开启状态
```

