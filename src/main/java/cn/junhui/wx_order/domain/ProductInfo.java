package cn.junhui.wx_order.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 军辉
 * 2019-04-02 11:01
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id//主键，但不自增
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    //库存量
    private Integer productStock;

    private String productDescription;

    //商品小图链接
    private String productIcon;

    //商品状态 0正常 1下架
    private Integer productStatus;

    //商品类目编号
    private Integer categoryType;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
