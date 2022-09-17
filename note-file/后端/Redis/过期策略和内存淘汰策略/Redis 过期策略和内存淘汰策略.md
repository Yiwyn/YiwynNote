### <font color='red'>Redis 过期策略和内存淘汰策略</font>



- #### 过期删除策略类型

  - ##### <font color='red'>定点删除</font>

    ###### 在设置某个key的过期时间的同时。我们创建一个定时器，让定时器在该时间到来的时候，立即对其进行删除操作

    - ##### 优点：定时删除内存是最友好的，能够保证内存中的key一旦过期就能立即从内存中删除

    - ##### 缺点：对CPU不友好，在过期键比较多的时候，删除过期键会占用一部分CPU时间，对服务器的响应时间和吞吐量造成影响

    

  - ##### <font color='red'>惰性删除</font>

    ###### 设置该key过期时间后，我们不需要去管它，当需要该key的时候，我们再检测其是否过期，若过期，则删除该key，反之则返回该key

    - ##### 优点：对CPU友好，我们只会在使用该键的时候进行检查，对于很多用不到的key不用浪费时间进行定期检查。

    - ##### 缺点：对内存不友好，如果一个key已经到期，但是一直没有再使用，那么该键就会一直存在内存中，如果数据库中由很多这种使用不到的过期键，那么这些键将会永远不被删除，内存永远不会释放，从而造成内存泄漏。

    

  - ##### <font color='red'>定时删除</font>

    ###### 每隔一段时间，我们就对一些key进行检查，删除里面过期的key

    - ##### 优点：可以通过限制删除操作执行的时长和频率来减少操作对CPU的影响。另外定期删除，也能有效的释放过期键占用的内存。

    - ##### 缺点：难以确定删除操作执行的时间和频率。如果执行的太频繁，定期策略变得和定时策略一样，对CPU不友好，如果执行的太少，那又和惰性是你出一样，过期键过多占用内存不会及时得到解放。另外，再获取某个键的时候，如果某个键的时间已经过了，还没有执行定时删除，那么就会返回这个键的值，这个是非常严重的业务错误。

    

    

    

- #### Redis 使用的过期删除策略

  ###### 通过三种过期删除策略。Redis使用的过期策略为：惰性删除、定期删除两种策略组合

  - ##### Redis的惰性删除策略由==db.c/expireIfNeeded==函数实现，所有键读写命令执行之前都会调用==expireIfNeeded==函数对其进行检查，如果过期，则删除该键，然后该键不存在的操作；未过期则不操作，继续执行原有的操作。

  - ##### Redis的定期删除策略由==redis.c/activeExprieCycle==函数实现，函数以一定的频率执行，每次运行时，都从一定数量的数据库中取出一定数据的随机键进行检查，并删除其中的过期键。

  - ##### <font color='orange'>注</font>：Redis的定期删除策略并不是一次运行近检查所有的库，所有的键，而是随机检查一定数量的键。

  - ```conf
    redis.conf 中hz选项可以调整定期删除的频率
    ...
    # The range is tetween 1 and 500, however a value over 100 is usually not
    # a good idea. Most users should use the default of 10 and raise this up to
    # 100 only in environments where very low latency is requiried.
    hz 10
    ...
    ```

  

- #### Redis 过期删除策略的问题

  ###### 虽然Redis采用了惰性删除和定期删除两种策略，但对于一些永远使用不到的键，并且经过多次删除也没有被选中的到并删除，那么这些键会一直驻留在内存中，所以，这个时候就需要采用redis的内存淘汰策略来解决问题。







- #### <font color='red'>Redis内存淘汰机制</font>

  - ##### 设置redis最大内存

  - ##### 内存淘汰策略

    ###### 当使用的内存大于最大内存时，就会触发Redis主动淘汰内存方式：

    - ##### ==volatile-lru==：利用LRU算法移除设置过过期时间的key（LRU,最近使用Least Recently Used）

    - ##### ==allkeys-lru==：利用LRU算法移除任何key（和上一个相比，删除的key包括设置过期时间和不设置过期时间的），通常使用这中方式

    - ##### ==volatile-random==：移除设置过过期时间的随机key

    - ##### ==allkeys-random==：无差别随机移除

    - ##### ==volatile-ttl==：移除即将过期的key（minor TTL）

    - ##### ==noeviction==：不移除任何key，只是返回一个写错误，默认选项，一般不选用。

  - ##### 在redis.conf 配置文件中，可以设置==maxmemory-policy==来设置内存淘汰方式：

    ```conf
    # Note: with any of the above policies, Redis will return an error on write
    #       operations, when there are no suitable keys for eviction.
    #
    #       At the date of writing these commands are: set setnx setex append
    #       incr decr rpush lpush rpushx lpushx linsert lset rpoplpush sadd
    #       sinter sinterstore sunion sunionstore sdiff sdiffstore zadd zincrby
    #       zunionstore zinterstore hset hsetnx hmset hincrby incrby decrby
    #       getset mset msetnx exec sort
    #
    # The default is:
    #
    maxmemory-policy noeviction
    ```

    
