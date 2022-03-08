package com.xiaozheng.system.a;

/**
 * What -- 吉他
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.system.a
 * @ClassName: Piano
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/1 21:51
 */
public class Guitar implements Instruments{
    /**
     * 演奏
     */
    @Override
    public void play() {
        System.out.println("吉他演奏");
    }

    /**
     * 调音
     */
    @Override
    public void sdjust() {
        System.out.println("吉他调音");
    }

    /**
     * 描述
     *
     * @return
     */
    @Override
    public String what() {
        return "我是吉他";
    }
}
