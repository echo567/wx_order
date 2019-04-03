package cn.junhui.wx_order.Enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-04-03 8:23
 * 订单状态
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISH(1, "已完成"),
    CANCEL(2, "已取消");

    private Integer code;

    private String msg;

    OrderStatusEnum() {
    }

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
