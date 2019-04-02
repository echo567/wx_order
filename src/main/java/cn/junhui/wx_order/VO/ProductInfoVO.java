package cn.junhui.wx_order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 军辉
 * 2019-04-02 17:44
 * <p>
 * 返回给前台的商品详情对象
 * 之所以不用domain下的ProductInfo,是因为尽量不要返回过多的字段，前端需要哪些字段就返回哪些字段，安全。
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productionDescription;

    @JsonProperty("icon")
    private String productionIcon;

    public ProductInfoVO() {
    }

    public ProductInfoVO(String productId, String productName, BigDecimal productPrice, String productionDescription, String productionIcon) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productionDescription = productionDescription;
        this.productionIcon = productionIcon;
    }
}
