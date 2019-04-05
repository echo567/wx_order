package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-04-04 21:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository masterRepository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster("1231", "name1", "121345789", "新乡", "1231212", new BigDecimal(12.3));
        System.out.println(orderMaster);
        masterRepository.save(orderMaster);
    }
}