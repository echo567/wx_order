package cn.junhui.wx_order.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 军辉
 * 2019-04-02 17:44
 */
@Data
public class ProductVO {

    //返回前台时的名称
    @JsonProperty("name")
    private String productName;

    @JsonProperty("type")
    private Integer productType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVO;

    public ProductVO() {
    }


    public ProductVO(Integer productType, String productName) {
        this.productName = productName;
        this.productType = productType;
    }

    public ProductVO(Integer productType, String productName, List<ProductInfoVO> productInfoVO) {
        this.productName = productName;
        this.productType = productType;
        this.productInfoVO = productInfoVO;
    }
}
