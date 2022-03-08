package com.xiaozheng.system.c;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * What -- 书籍
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.system.c
 * @ClassName: Books
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/1 22:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books implements Comparable{

    private String name;

    private Float price;

    private int number;

    public Float getPrice() {
        return price * number;
    }

    /**
     * 比较方法
     * obj 比 this 小 返回正值，大 返回负值
     * @param obj
     * @return
     */
    @Override
    public int compareTo(Object obj) {
        // 类型转换  由Object 到 Books
        Books obj1 = (Books) obj;
        System.out.println(this.name + "-" + obj1.name);

        return (int) (this.getPrice() - obj1.getPrice());
    }
}
