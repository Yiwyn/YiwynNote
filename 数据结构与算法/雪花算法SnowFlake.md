## <font color='red'>雪花算法（SnowFlake）</font>



> #### [分布式唯一Id之"雪花算法"_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1q3411k7Nc)





##### 雪花算法 使用long类型  long类型 int64 可以操作64个bit位



##### 结构

![img](%E9%9B%AA%E8%8A%B1%E7%AE%97%E6%B3%95SnowFlake.assets/13382703-b64e38457ddd13e2.jpg)



- ##### 1bit 第一位是符号位 1标识负数 0表示正数。生成id一般用正数，所以最高位固定为0

- ##### 41bit 表是时间戳，用来记录时间，毫秒级，41bit 可以支持从0到 2^41-1 个数值。

  - ##### 转换成为年为 （2^41 - 1）/（1000*60*60*24*365） = 69年

- ##### 10 bit 工作机器id ，可以拆分为5bit机房id 5bit机器id 

- ##### 12 bit 序列号 序列号从0开始，在一毫秒一个机器可以承载2^12 -1 个ID序列号





##### 雪花算法 生成id 需要使用位操作  <<  |  ~  



##### -1 的二进制位为111111111……



- ##### 生成id  =  时间戳 << 22位 | 工作机器id << 12位 | 序列号





#### code

```java
package com.yiwyn.util;

/**
 * @author Yiwyn
 * @create 2021/12/26 0:32
 */
public class SnowFlakeUtil {


    /**
     * 组成部分
     */
    //最高符号位 最高位为0 生成id为正数

    //时间戳

    //workid
    private long wordId;
    //序列号
    private long sequence = 0L;


    /**
     * 占用字节
     */
    //时间戳 41bit
    private final long timestampBit = 41L;
    //workid 10bit 可以拆分为两个5bit 机房id和机器id
    private final long workIdBit = 10L;
    //序列id 12bit
    private final long sequenceBit = 12L;


    /**
     * 位移的位数
     */

    //workId 左移12位 即是 序列id的位数
    private final long wordIdShift = sequenceBit;

    //时间id需要左移 sequenceId bit长度+ workId bit长度
    private final long timestampShift = sequenceBit + workIdBit;


    /**
     * 聚合信息
     */
    //支持最大的workId 10位 1023 --> 2^10 -1
    private final long maxWorkId = -1 ^ (-1 << workIdBit);

    //支持最大的序列id
    private final long maxSequence = ~(-1 << sequenceBit);

    //上一次生成的时间
    private long lastTimestamp = -1L;


    public SnowFlakeUtil(long wordId) {
        if (wordId < 0 || wordId > maxWorkId) {
            throw new IllegalArgumentException("wordId 错误");
        }
        this.wordId = wordId;
    }

    /**
     * 获取当前时间线戳
     *
     * @return
     */
    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public synchronized long getSnowId() {
        long currenTimestamp = getCurrentTime();
        if (currenTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) {
                currenTimestamp = getNextMillis();
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = currenTimestamp;

        /**
         * 返回唯一id
         */
        return (currenTimestamp << timestampShift) |
                (wordId << wordIdShift) |
                (sequence);
    }

    private long getNextMillis() {
        long currentTimestamp = getCurrentTime();
        while (currentTimestamp <= lastTimestamp) {
            currentTimestamp = getCurrentTime();
        }
        return currentTimestamp;
    }


}

```



