package com.xiaozheng.system.a;

/**
 * What -- 小提琴
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.system.a
 * @ClassName: Piano
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/1 21:51
 */
public class Fiddle implements Instruments{
    /**
     * 演奏
     */
    @Override
    public void play() {
        System.out.println("小提琴演奏");
    }

    /**
     * 调音
     */
    @Override
    public void sdjust() {
        System.out.println("小提琴调音");
    }

    /**
     * 描述
     *
     * @return
     */
    @Override
    public String what() {
        return "我是小提琴";
    }
}
