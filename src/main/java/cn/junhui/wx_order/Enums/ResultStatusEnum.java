package cn.junhui.wx_order.Enums;

import lombok.Data;
import lombok.Getter;

/**
 * 军辉
 * 2019-04-02 21:13
 * <p>
 * 返回前台的数据状态
 */
@Getter
public enum ResultStatusEnum {

    SUCCESS(0, "成功"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),//ctrl shift u 吧选中的字符变成大写
    PRODUCT_STOCK_ERROR(11, "商品库存不正确（数量不足）"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在");


    private Integer code;

    private String msg;

    ResultStatusEnum() {
    }

    ResultStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
