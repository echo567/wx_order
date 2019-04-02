package cn.junhui.wx_order.Enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-04-02 11:41
 */
@Getter //只自动生成getter方法
public enum ProductStatusEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String msg;

    ProductStatusEnum() {
    }

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
