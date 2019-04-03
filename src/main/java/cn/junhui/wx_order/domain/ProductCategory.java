package cn.junhui.wx_order.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 军辉
 * 2019-04-01 20:24
 * 类目
 */
@Entity
//@DynamicUpdate  //动态修改 update_time,如果类中没有 updateTime字段，
// 则不需要@DynamicUpdate，数据库即会自动更新
@Data   //无需再写 setter和getter toString方法
public class ProductCategory {

    /*
    类目id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    /*
    类目编号
     */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
