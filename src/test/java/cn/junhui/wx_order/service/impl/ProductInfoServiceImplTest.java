package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.Enums.ProductStatusEnum;
import cn.junhui.wx_order.domain.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;
import java.util.List;

/**
 * 军辉
 * 2019-04-02 11:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl infoService;


    @Test
    public void save() {
        ProductInfo info = new ProductInfo("5", "测试4", new BigDecimal(10.69), 23, ProductStatusEnum.UP.getCode(), 2);
        infoService.save(info);
    }

    @Test
    public void findById() {
        System.out.println(infoService.findById("1").getProductName());
    }

    @Test
    public void findUpAll() {

        List<ProductInfo> productInfoList = infoService.findUpAll();
        System.out.println(productInfoList.size());
    }

    @Test
    public void findAll() {
        Pageable pageable = PageRequest.of(1, 5);
        Page<ProductInfo> productInfoPage = infoService.findAll(pageable);
        System.out.println(productInfoPage.getTotalElements());
        //  Assert.assertNotEquals(0, infoService.findAll());
    }


}