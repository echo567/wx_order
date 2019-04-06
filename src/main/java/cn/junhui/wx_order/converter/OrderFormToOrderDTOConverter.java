package cn.junhui.wx_order.converter;

import cn.junhui.wx_order.Enums.ResultStatusEnum;
import cn.junhui.wx_order.domain.OrderDetail;
import cn.junhui.wx_order.dto.OrderDTO;
import cn.junhui.wx_order.exception.SellException;
import cn.junhui.wx_order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 军辉
 * 2019-04-05 20:13
 */
@Slf4j
public class OrderFormToOrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        //使用gson 吧json的字符串转换为list
        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误，String = {}", orderForm.getItems());
            throw new SellException(ResultStatusEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;

    }
}
