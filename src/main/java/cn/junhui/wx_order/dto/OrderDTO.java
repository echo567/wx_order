package cn.junhui.wx_order.dto;

import cn.junhui.wx_order.Enums.OrderStatusEnum;
import cn.junhui.wx_order.Enums.PayStatusEnum;
import cn.junhui.wx_order.domain.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 军辉
 * 2019-04-03 15:35
 * dto:Data Transfer Object 数据传输对象,在各个层传输数据的时候使用的
 */
@Data
public class OrderDTO {


    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家 微信的openID
    private String buyerOpenId;

    //订单 总金额
    private BigDecimal orderAmount;

    //订单状态  默认为0，为新下单
    private Integer orderStatus;

    //支付状态 默认为0，未支付
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    List<OrderDetail> orderDetailList;

}
