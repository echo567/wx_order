package cn.junhui.wx_order.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 军辉
 * 2019-04-03 8:35
 * 订单详情表
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    private String openID;

    private String productId;

    private String productName;

    //单价(必须从数据库获取，而不是从前台传过来)
    private BigDecimal productPrice;

    //产品数量
    private Integer productQuantity;

    //产品小图链接
    private String productIcon;

    private Date createTime;

    private Date updateTime;

    public OrderDetail() {
    }
}
