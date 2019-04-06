package cn.junhui.wx_order.service;

import cn.junhui.wx_order.dto.OrderDTO;

/**
 * 军辉
 * 2019-04-06 9:09
 */
public interface BuyerService {

    //查询一个订单
    public OrderDTO findOrderOne(String openid, String orderId);

    //取消一个订单
    public OrderDTO cancelOrder(String openid, String orderId);

}
