## <font color='red'>InnoDB数据存储结构</font>





### 数据库的存储结构：页

##### 索引结构给我提供了高效的索引方式，不过索引信息以及数据记录都是保存在文件上的，确切说是存储在页结构中。另一方面，索引是存储引擎中实现的，在MySQL服务器上==存储引起==负责对表中数据的读取和写入工作。不同存储引擎中==存放的格式==一般是不同的。

##### 由于==InnoDB==是MySQL的默认存储引擎，所以只要研究InnoDB存储引擎的数据存储结构。



- #### 磁盘与内存交互基本单位：页

  - ##### InnoDB将数据划分为若干个页，InnoDB中页的大小默认为16KB

  - ##### 以==页==作为磁盘和内存之间交互的==基本单位==，也就是说一次最少从磁盘中读取16KB的内容到内存中，一次最少把内存中的16KB内容刷新到磁盘中。也就是说，<font color='red'>在数据库中，不论读一行或读多行，都将对其所在页进行加载。即，数据库管理存储内容的基本单位是页（Page），数据库I/O操作的最小单位是页。</font>一个页中可以存储多行记录

- #### 页结构概述

  - ##### 页可以<font color='red'>不在物理结构上相连</font>，只要通过双向链表相关联即可。每个数据页中的记录会按照主键值从小到大的顺序组成一个<font color='red'>单向链表</font>，每个数据页都会为存储在它里面的数据生成一个<font color='red'>页目录</font>，在通过主键查找某条记录的时候可以在页目录中使用二分法快速定位到对应的操，然后再遍历该槽对应分组中记录即可快速找到指定的记录





- #### 页的内部结构

  - ##### 常见的页有：数据页(保存B+树节点)、系统页、Undo页、事务数据页等

  - ##### 数据页的大小为==16KB==，划分为七个部分

    - | 名称               | 占用大小 | 说明                                 |
      | ------------------ | -------- | ------------------------------------ |
      | File Header        | 38字节   | 文件头，描述页的信息                 |
      | Page Header        | 56字节   | 页头，页的状态信息                   |
      | Infimum + Supermum | 26字节   | 最大和最小记录，这是两个虚拟的行记录 |
      | User Records       | 不确定   | 用户记录，存储行记录内容             |
      | Free Space         | 不确定   | 空闲记录，页中还没有被使用的空间     |
      | Page Directory     | 不确定   | 页目录，存储用户记录的相对位置       |
      | Fiile Trailer      | 8字节    | 文件尾，校验页是否完整               |

  - #### File Header 文件头部 和 File Trailer 文件尾部

    - ##### <font color='red'>File Header</font>包含：Type【页的类型】、上一页下一页数据、LSN最后修改时对应日志序列位置（校验完整性）
    
    - ##### 文件头和文件尾会有一个校验和，当开始操作的数据的时候，文件头的校验和被修改；当完成操作的时候，文件尾的校验和变化为和文件头的数据一致，这样确保数据操作正常完成。
    
  - #### Free Space 、User Records 、Infimum + Supermum





