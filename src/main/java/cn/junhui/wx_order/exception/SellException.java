package cn.junhui.wx_order.exception;

import cn.junhui.wx_order.Enums.ResultStatusEnum;

/**
 * 军辉
 * 2019-04-03 21:01
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultStatusEnum resultStatusEnum) {
        super(resultStatusEnum.getMsg());

        this.code = resultStatusEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
