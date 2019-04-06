package cn.junhui.wx_order.service.impl;

import ch.qos.logback.classic.Logger;
import cn.junhui.wx_order.Enums.ResultStatusEnum;
import cn.junhui.wx_order.dto.OrderDTO;
import cn.junhui.wx_order.exception.SellException;
import cn.junhui.wx_order.service.BuyerService;
import cn.junhui.wx_order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 军辉
 * 2019-04-06 9:11
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;


    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断当前订单是否输入本用户
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致,openid={},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultStatusEnum.order_owner_error);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到该订单,orderId={}", orderId);
            throw new SellException(ResultStatusEnum.PRODUCT_NOT_EXIST);
        }
        //判断当前订单是否输入本用户
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致,openid={},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultStatusEnum.order_owner_error);
        }
        return orderService.cancel(orderDTO);
    }
}
