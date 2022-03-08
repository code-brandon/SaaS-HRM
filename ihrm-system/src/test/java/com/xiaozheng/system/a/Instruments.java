package com.xiaozheng.system.a;

/**
 * What -- 乐器接口
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.system.a
 * @ClassName: Instruments
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/1 21:49
 */
public interface Instruments {

    /**
     * 演奏
     */
    void play();

    /**
     * 调音
     */
    void sdjust();

    /**
     * 描述
     * @return
     */
    String what();
}
