package cn.junhui.wx_order.service;

import cn.junhui.wx_order.domain.OrderDetail;
import cn.junhui.wx_order.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 军辉
 * 2019-04-03 15:31
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);


    //查询单个订单
    OrderDTO findByOrderId(String orderId);

    //查询订单类表
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);
}
