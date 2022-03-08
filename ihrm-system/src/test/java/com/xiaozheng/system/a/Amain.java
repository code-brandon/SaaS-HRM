package com.xiaozheng.system.a;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.system.a
 * @ClassName: Amain
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/1 21:56
 */
public class Amain {
    public static void main(String[] args) {
        /**
         * 钢琴
         */
        Instruments instruments = new Piano();
        System.out.println("instruments.what() = " + instruments.what());
        /**
         * 小提琴
         */
        instruments = new Fiddle();
        System.out.println("instruments.what() = " + instruments.what());
    }
}
