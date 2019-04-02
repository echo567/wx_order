package cn.junhui.wx_order.VO;

import lombok.Data;

/**
 * 军辉
 * 2019-04-02 17:15
 * VO:View Object
 */
@Data
public class ResultVo<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResultVo() {
    }

    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
