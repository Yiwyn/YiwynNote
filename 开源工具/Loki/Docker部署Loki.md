#### Loki日志框架快速开始



- ##### 新建docker-compose.yml文件

  ```yaml
  networks:
    loki:
  
  services:
    loki:
      image: grafana/loki:1.5.0
      ports:
        - "3100:3100"
      command: -config.file=/etc/loki/local-config.yaml
      networks:
        - loki
  
    promtail:
      image: grafana/promtail:1.5.0
      volumes:
        - /usr/local/logs/[自己服务的日志文件位置]:/var/log/
      command: -config.file=/etc/promtail/docker-config.yaml
      networks:
        - loki
  
    grafana:
      image: grafana/grafana:latest
      ports:
        - "3000:3000"
      networks:
        - loki
  ```

  ```properties
  grafana  面板
  promtail：映射路径
  loki 日志库log
  ```

  

- ##### docker-compose up -d 启动loki相关的容器

- ##### 首次登录 <font color='cornflowerblue'>服务器ip:3000</font>，初始默认账号/密码  admin/admin

- ##### 选择数据源![image-20221026221315595](http://file.lifepoem.fun/note/image-20221026221315595.png)

- ##### ![image-20221026221516617](http://file.lifepoem.fun/note/image-20221026221516617.png)<font color='red'>标红为位置一定要明确宿主机器ip，端口3100</font>



- ![image-20221026222347306](http://file.lifepoem.fun/note/image-20221026222347306.png)

