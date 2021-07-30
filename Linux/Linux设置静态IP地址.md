#### 自己创建多个虚拟机,保持多个虚拟机之间互联联通,这时候网络选项要选择<font color='red'>桥接模式</font> 

- #### 分配到一个ip地址,使用<font color='cornflowerblue'>dhclient</font> 命令 

- #### 修改网卡配置文件/etc/sysconfig/network-scripts/ifcfg-ens33

- #### Linux查询ip地址: <font color='red'>ifconfig</font>

- ```shell
  TYPE=Ethernet
  PROXY_METHOD=none
  BROWSER_ONLY=no
  BOOTPROTO=static 	//设置boot属性为static 静态属性
  DEFROUTE=yes
  IPV4_FAILURE_FATAL=no
  IPV6INIT=yes
  IPV6_AUTOCONF=yes
  IPV6_DEFROUTE=yes
  IPV6_FAILURE_FATAL=no
  IPV6_ADDR_GEN_MODE=stable-privacy
  NAME=ens33
  UUID=45c8e442-31af-44f9-97a9-eaf51ccc1ab5
  DEVICE=ens33
  ONBOOT=yes			//修改为yes
  IPADDR=192.168.3.99(放入ifconfig查到的ip地址)
  NETMASK=255.255.255.0  //添加子网掩码
  GATEWAY=192.168.3.1		//添加网关
  DNS1=119.29.29.29		//添加DNS服务,这里使用的是腾讯的
  ```

  

