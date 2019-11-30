package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.service.CartService;
import com.kaysanshi.springbootshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
@RequestMapping("/cart")
@RestController
public class CartContoller {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;
    /**
     * 清空购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/clear",method = RequestMethod.POST)
    public BaseResult clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        return BaseResult.success();
    }

    /**
     * 添加购物车
     * @param request
     * @param product
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult addProductToCart(HttpServletRequest request, Product product, HttpServletResponse response) throws ServletException, IOException {
        cartService.addProductToCart(request,product,response);
        return BaseResult.success();
    }
}
