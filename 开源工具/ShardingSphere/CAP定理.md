### <font color='red'>CAP理论</font>



##### CAP理论（CAP theorem）又被称为布鲁尔定理。对于分布式系统架构来说CAP是必要掌握的理论。



##### 在一个<font color='red'>分布式系统</font>中，当设计到读写操作时，只能保证一致性（Consistence）、可用性（Availability）、分区容错性（Partition Tolerance）三者中的两者，另外一个必须被牺牲。

- ##### 一致性（Consistence）：对某个指定的客户端来说，读操作保证能够返回最新的写操作结果。

- ##### 可用性（Availability）: 非故障的节点在合理的时间内返回合理的相应。（不是错误和超时的响应）

- ##### 分区容错性（Partition Tolerance）：当出现网络分区后，系统能够继续“履行职责”

  - ##### 分区：网络中断、丢包、拥堵等情况。



##### <font color='red'>CAP特点</font>

- ##### 在系统设计中，有的数据必须选择CP架构、有的数据必须选择AP架构，分布式系统理论上不可能选择CA架构

- ##### CAP理论中的<font color='orange'>C在实践中是不可能完美实现</font>的，在数据复制的过程中，节点之间的数据并不一致（强一致性），当应用可以采用适合的方式达到最终一致性。

  - ##### 基本可用（Basically Available）：分布式系统在出现故障时，允许损失部分可用性，即保证核心可用。

  - ##### 软状态（Soft State）：允许系统存在中间状态，而该中间状态不会影响系统整体可用性，这里的中间状态就是CAP理论中的数据不一致。

  - ##### <font color='orange'>最终一致性（Eventual Consistency），系统中的所有数据副本在经过一定时间后，最终能达成一定的状态。</font>

