package com.xiaozheng.system.c;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * What -- 商品
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
public class Commodity implements Comparable{

    /**
     * 浏览量
     */
    private int pageviews;

    /**
     * 价格
     */
    private Float price;

    /**
     * 购买量
     */
    private int purchaseAmount;

    /**
     * 热度
     */
    private Float heat;

    /**
     * 计算热度
     * @return
     */
    public Float getHeat() {
        return price * (pageviews + 10 * purchaseAmount);
    }

    @Override
    public int compareTo(Object obj) {
        Commodity obj1 = (Commodity) obj;
        return (int) (getHeat() - obj1.getHeat());
    }
}
