package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.domain.OrderDetail;
import cn.junhui.wx_order.dto.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-04-03 22:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO("军辉", "1830366", "河南新乡", "微信id");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("443");
        orderDetail1.setProductQuantity(2);
        orderDetailList.add(orderDetail1);

        OrderDetail orderDetail2 = new OrderDetail("1", 2);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println("创建订单：" + result);
    }

    @Test
    public void findByOrderId() {
        OrderDTO orderDTO = orderService.findByOrderId("1554431034733419206");
        System.out.println(orderDTO);
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }


}