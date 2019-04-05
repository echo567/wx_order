package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.Enums.OrderStatusEnum;
import cn.junhui.wx_order.Enums.PayStatusEnum;
import cn.junhui.wx_order.Enums.ResultStatusEnum;
import cn.junhui.wx_order.domain.OrderDetail;
import cn.junhui.wx_order.domain.OrderMaster;
import cn.junhui.wx_order.domain.ProductInfo;
import cn.junhui.wx_order.dto.CartDTO;
import cn.junhui.wx_order.dto.OrderDTO;
import cn.junhui.wx_order.exception.SellException;
import cn.junhui.wx_order.repository.OrderDetailRepository;
import cn.junhui.wx_order.repository.OrderMasterRepository;
import cn.junhui.wx_order.service.OrderService;
import cn.junhui.wx_order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import javax.xml.ws.Action;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 军辉
 * 2019-04-04 21:27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

//        List<CartDTO> cartDTOList = new ArrayList<>();

        //1. 查询商品（数量, 价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultStatusEnum.PRODUCT_NOT_EXIST);
            }

            //2. 计算订单总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);

//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }


        //3. 写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4. 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productInfoService.decreaseStock(cartDTOList);

        System.out.println("扣库存完成");

        return orderDTO;
    }

    @Override
    public OrderDTO findByOrderId(String orderId) {

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            throw new SellException(ResultStatusEnum.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultStatusEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
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
