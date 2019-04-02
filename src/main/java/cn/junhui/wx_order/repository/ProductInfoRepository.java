package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 军辉
 * 2019-04-02 11:15
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    // 查询商家商品
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
