package cn.junhui.wx_order.Enums;

import lombok.Data;
import lombok.Getter;

/**
 * 军辉
 * 2019-04-02 21:13
 *
 * 返回前台的数据状态
 */
@Getter
public enum ResultStatusEnum {

    SUCCESS(0, "成功"),;


    private Integer code;

    private String msg;

    ResultStatusEnum() {
    }

    ResultStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
