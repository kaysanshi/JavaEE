package com.kaysanshi.springbootshop.dao;

import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.ProductQueryDTO;
import com.kaysanshi.springbootshop.dto.ProductQueryVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProductMapper extends Mapper<Product> {
    
    List<Product> getProductListBySearch(ProductQueryDTO productQueryDTO);

    Integer countBySearch(ProductQueryDTO productQueryDTO);

    List<Product> query(ProductQueryVO productQueryVO);

    int querySum(ProductQueryVO productQueryVO);
}