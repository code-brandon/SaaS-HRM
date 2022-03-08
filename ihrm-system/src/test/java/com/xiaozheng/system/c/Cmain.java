package com.xiaozheng.system.c;

import com.xiaozheng.system.a.Fiddle;
import com.xiaozheng.system.a.Instruments;
import com.xiaozheng.system.a.Piano;

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
public class Cmain {
    public static void main(String[] args) {
        Books books = new Books();
        books.setName("小齐");
        books.setPrice(5.0f);
        books.setNumber(6); // 30

        Books books1 = new Books();
        books1.setName("小张");
        books1.setPrice(3.0f);
        books1.setNumber(6); // 18

        // this.getPrice() - obj1.getPrice()
        int to = books1.compareTo(books);
        System.out.println("to = " + to); // 18 - 30 = -12
    }
}
