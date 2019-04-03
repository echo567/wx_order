package cn.junhui.wx_order.domain;

import cn.junhui.wx_order.Enums.OrderStatusEnum;
import cn.junhui.wx_order.Enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 军辉
 * 2019-04-03 8:13
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate//类中有updateTime字段，才需要这个注解，否则数据库不会自动更新。
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家 微信的openID
    private String buyerOpenId;

    //订单 总金额
    private BigDecimal orderAmount;

    //订单状态  默认为0，为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态 默认为0，未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;


    public OrderMaster() {
    }
}
