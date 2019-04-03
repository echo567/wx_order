package cn.junhui.wx_order.Enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-04-03 8:26
 * 订单支付状态
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String msg;

    PayStatusEnum() {
    }

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
