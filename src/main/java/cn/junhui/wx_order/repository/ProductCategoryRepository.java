package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 军辉
 * 2019-04-01 20:30
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /*
    通过类目类型查找商品
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
