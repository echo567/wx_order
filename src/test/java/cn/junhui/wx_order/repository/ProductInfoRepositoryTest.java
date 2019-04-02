package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.ProductInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-04-02 11:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository infoRepository;

    @Test
    public void saveTest() {
        ProductInfo info1 = new ProductInfo("1", "测试名称1", new BigDecimal(12.3), 103, 0,2);
        ProductInfo info2 = new ProductInfo("2", "测试名称2", new BigDecimal(112.3), 1053, 1,5);
        infoRepository.save(info1);
        infoRepository.save(info2);
    }

    @Test
    public void findByProductStatus() {
        System.out.println(infoRepository.findByProductStatus(0).size());
    }
}