package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.ProductCategory;
import org.hibernate.validator.constraints.EAN;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-04-01 20:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void find() {

        System.out.println(productCategoryRepository.findAll().size());
    }

    @Test
    @Transactional  //仅显示测试结果成功与否，不存数据进入数据库
    public void addTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试name");
        productCategory.setCategoryType(56);
        productCategoryRepository.save(productCategory);

    }

    @Test
    public void updateTest() {
                                                                    /*低版本使用的是findOne()
                                                                    * 高版本使用的是findById().get()*/
        ProductCategory productCategory = productCategoryRepository.findById(2).get();

        productCategory.setCategoryName("7897987");
        productCategoryRepository.save(productCategory);

    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());//断言：（实际的）result.size()的值 不期望为 0；
    }

}