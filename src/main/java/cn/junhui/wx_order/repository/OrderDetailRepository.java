package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 军辉
 * 2019-04-03 8:42
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    //通过 订单id查询 订单详情
    List<OrderDetail> findByOrderId(String orderId);
}
