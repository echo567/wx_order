package cn.junhui.wx_order.controller;

import cn.junhui.wx_order.dto.OrderDTO;
import cn.junhui.wx_order.service.OrderService;
import cn.junhui.wx_order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 军辉
 * 2019-04-08 21:06
 * <p>
 * 卖家端订单
 */
@Controller
@RequestMapping("/seller/order")
public class SellOrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                             @RequestParam(value = "size", required = false, defaultValue = "4") Integer size) {

        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        System.out.println("orderDTOPage:" + orderDTOPage.getContent());
        return new ModelAndView("order/list", "orderDTOPage", orderDTOPage);



    }
}
