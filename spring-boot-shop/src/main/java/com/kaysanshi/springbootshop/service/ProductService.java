package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.ProductDTO;
import com.kaysanshi.springbootshop.dto.ProductQueryVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
public interface ProductService {
    Product add(Product product);

    Product update(Product product);

    Integer delete(Product product);

    ProductDTO<Product> getList(Integer page, Integer size, String search, String publicStatus, String newStatus, String sort, HttpServletRequest request, HttpServletResponse response);

    Product getProduct(Product product);

    BaseResult getlist(ProductQueryVO productQueryVO);
}
