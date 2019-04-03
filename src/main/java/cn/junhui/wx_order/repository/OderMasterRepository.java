package cn.junhui.wx_order.repository;

import cn.junhui.wx_order.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 军辉
 * 2019-04-03 8:43
 */
public interface OderMasterRepository extends JpaRepository<OrderMaster, String> {

    //按照 某人的微信id查询其所有订单并分页
    Page<OrderMaster> findByBuyerOpenId(String buyerOpenid, Pageable pageable);
}
