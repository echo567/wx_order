package cn.junhui.wx_order.service.impl;

import cn.junhui.wx_order.Enums.ProductStatusEnum;
import cn.junhui.wx_order.Enums.ResultStatusEnum;
import cn.junhui.wx_order.domain.ProductInfo;
import cn.junhui.wx_order.dto.CartDTO;
import cn.junhui.wx_order.exception.SellException;
import cn.junhui.wx_order.repository.ProductInfoRepository;
import cn.junhui.wx_order.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = infoRepository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultStatusEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            infoRepository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = infoRepository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultStatusEnum.PRODUCT_NOT_EXIST);
            }

            /*
            会出现 超卖 现象
             */
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultStatusEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            infoRepository.save(productInfo);
        }
    }
}
