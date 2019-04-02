package cn.junhui.wx_order.service;

import cn.junhui.wx_order.domain.ProductCategory;

import java.util.List;

/**
 * 军辉
 * 2019-04-02 10:40
 */
public interface ProductCategoryService {

    ProductCategory findByCategoryId(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
