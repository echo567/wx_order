package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.Enums.ProductStatusEnum;
import cn.junhui.wx_order.domain.ProductInfo;
import cn.junhui.wx_order.repository.ProductInfoRepository;
import cn.junhui.wx_order.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 军辉
 * 2019-04-02 11:16
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository infoRepository;


    @Override
    public ProductInfo findById(String productId) {
        return infoRepository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return infoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return infoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return infoRepository.save(productInfo);
    }
}
