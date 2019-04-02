package cn.junhui.wx_order.service;

import cn.junhui.wx_order.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 军辉
 * 2019-04-02 11:16
 */
public interface ProductInfoService {

    ProductInfo findById(String productId);

    /*
    (用户)查询所有上架的商品
     */
    List<ProductInfo> findUpAll();

    /*
    (管理员)查询所有商品
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存


}
