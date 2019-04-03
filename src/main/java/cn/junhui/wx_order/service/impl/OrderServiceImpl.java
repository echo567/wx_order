package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.domain.OrderDetail;
import cn.junhui.wx_order.domain.ProductInfo;
import cn.junhui.wx_order.dto.OrderDTO;
import cn.junhui.wx_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 军辉
 * 2019-04-03 15:44
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //1. 查询商品（数量，价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
        }
        //2. 计算总价

        //3. 写入订单数据库（orderMaster 和 orderDetail）

        //4. 扣除库存


        return null;
    }

    @Override
    public OrderDTO findByOrderId(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
