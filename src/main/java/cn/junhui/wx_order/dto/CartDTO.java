package cn.junhui.wx_order.dto;

import lombok.Data;

/**
 * 军辉
 * 2019-04-03 21:48
 * 前台传回来的购物车
 */
@Data
public class CartDTO {

    /*
    商品id
     */
    private String productId;

    /*
    商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
