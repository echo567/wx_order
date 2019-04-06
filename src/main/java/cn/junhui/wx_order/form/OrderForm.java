package cn.junhui.wx_order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 军辉
 * 2019-04-05 20:04
 * Form下的类都是用来表单传输的
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "手机号不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "openid不能为空")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
