package cn.junhui.wx_order.utils;

import java.util.Random;

/**
 * 军辉
 * 2019-04-03 21:20
 */
public class KeyUtil {

    /*
    生成唯一主键
    当前时间毫米 + 随机数
    防止在多线程下生成的重复值，所以要添加 synchronized 关键字
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
