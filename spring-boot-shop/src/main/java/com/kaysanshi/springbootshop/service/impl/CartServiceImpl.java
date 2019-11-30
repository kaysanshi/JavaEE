package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.Cart;
import com.kaysanshi.springbootshop.dto.CartItem;
import com.kaysanshi.springbootshop.service.CartService;
import com.kaysanshi.springbootshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ProductService productService;

    @Override
    public void addProductToCart(HttpServletRequest request, Product product, HttpServletResponse response) {

        HttpSession session = request.getSession();

        //获得该商品的购买数量
        int buyNum = Integer.parseInt(request.getParameter("buyNum"));

        //获得product对象
        Product products = productService.getProduct(product);
        //计算小计
        double subtotal = products.getShopPrice() * buyNum;
        //封装CartItem
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setBuyNum(buyNum);
        item.setSubtotal(subtotal);

        //获得购物车---判断是否在session中已经存在购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        //将购物项放到车中---key是pid
        //先判断购物车中是否已将包含此购物项了 ----- 判断key是否已经存在
        //如果购物车中已经存在该商品----将现在买的数量与原有的数量进行相加操作
        Map <String, CartItem> cartItems = cart.getCartItems();

        double newsubtotal = 0.0;

        if (cartItems.containsKey(product.getId())) {
            //取出原有商品的数量
            CartItem cartItem = cartItems.get(product.getId());
            int oldBuyNum = cartItem.getBuyNum();
            oldBuyNum += buyNum;
            cartItem.setBuyNum(oldBuyNum);
            cart.setCartItems(cartItems);
            //修改小计
            //原来该商品的小计
            double oldsubtotal = cartItem.getSubtotal();
            //新买的商品的小计
            newsubtotal = buyNum * product.getShopPrice();
            cartItem.setSubtotal(oldsubtotal + newsubtotal);

        } else {
            //如果车中没有该商品
            cart.getCartItems().put(product.getId(), item);
            newsubtotal = buyNum * product.getShopPrice();
        }

        //计算总计
        double total = cart.getTotal() + newsubtotal;
        cart.setTotal(total);


        //再次访问session
        session.setAttribute("cart", cart);
    }
}
