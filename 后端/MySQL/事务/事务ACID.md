### <font color='red'>事务的四个特性</font>



- #### 原子性（Atomcity）

  - ##### 原子性是指事务是一个不可分割的工作的单位，要么全部提交，要么全部失败回滚。

- #### 一致性（consistency）

  - ##### 一致性是指事务执行前后，数据从一个==合法性状态==变化到另外一个==合法性状态==。

  - ##### 合法性状态：满足==约定的约束==的状态就是合法性的状态。满足这个状态则数据是一致性的，若不满足这个状态，数据就是不一致的。

- #### 隔离性（isolation）

  - ##### 事务的隔离性是指一个事务的执行==不能被其他事务干扰==，即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能相互干扰。

- #### 持久性（durability）

  - ##### 持久性是指一个事务一旦提交，它对数据库中数据的修改是==永久性的==，接下来的其他操作和数据库故障不应该对其具有任何影响。

  - ##### 持久性是通过==事务日志==来保证的。日志包括了==重做日志==和==回滚日志==。当我们通过事务对数据进行修改的时候，首先会将数据库的变化信息记录到==重做日志==中，然后再对数据库中对应的行进行修改。这样的好处是，即使数据库系统崩溃，数据库重启后也能找到没有更新到数据库系统中的重做日志，重新执行，从而使数据具有持久性。





