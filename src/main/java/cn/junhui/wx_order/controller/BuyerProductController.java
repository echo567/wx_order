package cn.junhui.wx_order.controller;

import cn.junhui.wx_order.VO.ProductInfoVO;
import cn.junhui.wx_order.VO.ProductVO;
import cn.junhui.wx_order.VO.ResultVo;
import cn.junhui.wx_order.domain.ProductCategory;
import cn.junhui.wx_order.domain.ProductInfo;
import cn.junhui.wx_order.service.ProductCategoryService;
import cn.junhui.wx_order.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 军辉
 * 2019-04-02 17:12
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService infoService;

    @Autowired
    private ProductCategoryService categoryService;


    @GetMapping("/list")
    public ResultVo list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = infoService.findUpAll();

        //2. 查询类目（一次性查询）
        //  List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法 for each遍历
        /*for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/

        //精简方法 (java8 lambda表达式)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装

        //第一层
        ResultVo resultVo = new ResultVo(0, "成功");
        //第二层的列表
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            //第二层列表中所存的对象
            ProductVO productVO = new ProductVO(productCategory.getCategoryType(), productCategory.getCategoryName());
            //第三层对象所组成的列表
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    //第三层的对象
                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    //可以把一个对象（前）的值拷贝到另一个对象（后）中去
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    //第三层的列表添加第三层的对象
                    productInfoVOList.add(productInfoVO);
                }
            }

            //第二层的对象添加 第三层的对象列表
            productVO.setProductInfoVO(productInfoVOList);

            //第二层的对象列表添加第二层的对象
            productVOList.add(productVO);


        }

        //吧第二层的(对象列表)数据放入第一层的data中
        resultVo.setData(productVOList);

        //返回第一层
        return resultVo;
    }
}
