

## <font color='red'>Zookeeper -- Watcher 事件监听</font>



- #### zookeeper 允许用户在指定节点上注册一些<font color='cornflowerblue'>Watcher</font>，并且在一些特定事件触发的时候，Zookeeper 服务端会将事件通知到感兴趣的客户端上，该机制是Zookeeper 实现分布式协调服务的重要特性。

- #### zookeeper 中引入Watcher 机制来实现发布/订阅功能，能够让多个订阅者同时监听一个对象，当一个对象自身状态变化时，会通知所有订阅者。

- #### <font color='cornflowerblue'>Curator</font> 引入了<font color='red'>Cache</font> 来实现对Zookeeper 服务端事件的简体。

  - ##### NodeCache：只是监听某一个特定的节点

  - ##### PathChildrenCache：监控一个ZNode的子节点

  - ##### TreeCache：可以监控整个树上的所有节点，类似PathChildrenCache和NodeCache的组合







## <font color='red'>API 操作</font> 



- #### NodeCache

  - ```java
     	@Test
        public void testNodeCache() throws Exception {
            //创建NodeCache对象
            NodeCache nodeCache = new NodeCache(client, "/app1");
            //注册监听
            nodeCache.getListenable().addListener(new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    System.out.println("节点变化了");
                    //获取当前数据
                    nodeCache.getCurrentData();
                }
            });
            //开启监听
            nodeCache.start(true);
        }
    ```



<hr>

- #### PathChildrenCache

  - ```java
     PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app1", true);
    
            pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                    System.out.println("发生了变化");
                }
            });
            pathChildrenCache.start();
    ```

  - ##### <font color='cornflowerblue'>PathChildrenCacheEvent pathChildrenCacheEvent</font> 该对象包含了修改的事件信息。

  - ##### 自身变化监听不到



<hr>

- #### TreeCache

  - ```java
      TreeCache treeCache = new TreeCache(client, "/app1");
    
            treeCache.getListenable().addListener(new TreeCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                    System.out.println(treeCacheEvent.getData().toString());
                }
            });
    
            treeCache.start();
    ```





<hr>



## <font color='red'>总结</font>

- ##### 几种事件监听的方式都是一样的。

- ##### 创建对象绑定客户端 --->  绑定监听事件 ---> start开始监听。