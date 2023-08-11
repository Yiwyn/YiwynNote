- 在终端中输入 **hostname** 得到本地访问地址
- 编辑hosts文件
```shell
sudo vim /etc/hosts
```
- 编辑如下，在localhost后最佳本地访问地址
```text
127.0.0.1       localhost YiwyndeMac-Pro.local

255.255.255.255 broadcasthost

::1             localhost YiwyndeMac-Pro.local
```
- 重启idea 即可立即生效