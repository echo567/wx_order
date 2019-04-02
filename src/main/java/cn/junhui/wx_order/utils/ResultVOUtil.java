package cn.junhui.wx_order.utils;

import cn.junhui.wx_order.Enums.ResultStatusEnum;
import cn.junhui.wx_order.VO.ResultVo;

/**
 * 军辉
 * 2019-04-02 21:12
 */
public class ResultVOUtil {

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getMsg());
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo(code, msg);
        return resultVo;
    }
}
