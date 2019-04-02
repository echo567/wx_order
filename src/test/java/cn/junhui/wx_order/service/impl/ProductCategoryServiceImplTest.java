package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.domain.ProductCategory;
import cn.junhui.wx_order.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-04-02 10:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl categoryService;

    @Test
    public void findOneByCategoryId() {
        ProductCategory productCategory = categoryService.findByCategoryId(1);
        //期望的值，跟查询的值
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
        //  System.out.println(categoryService.findOneByCategoryId(2));
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findByCategoryTypeIn() {
    }

    @Test
    public void save() {
    }
}