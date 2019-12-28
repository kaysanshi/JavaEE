package com.kaysanshi.springbootshop.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/12/2
 */
public class Myutils {
    /**
     * 商品id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }
    public static void main(String[] args) {
        System.out.println(Myutils.genItemId());
    }
}
