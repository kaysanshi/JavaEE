package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.Order;
import com.kaysanshi.springbootshop.domain.Orderitem;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.Cart;
import com.kaysanshi.springbootshop.dto.CartItem;
import com.kaysanshi.springbootshop.service.OrderService;
import com.kaysanshi.springbootshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
@RestController
@RequestMapping("/order")
public class OrderContoller {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    /***
     * 提交订单
     * @param order
     * @param product
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public BaseResult addOrder(Order order, Product product,HttpServletRequest request, HttpServletResponse response){
        User user=userService.getCurrentUser(request,response);

        if (user!=null){
            order.setId(UUID.randomUUID().toString());
            order.setOrdertime(new Date());
            //获得session中的购物车
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            double total = cart.getTotal();
            order.setTotal(total);
            //订单支付状态 1代表已付款 0代表未付款
            order.setState(0);
            //该订单属于哪个用户
            order.setUser(user);
            order.setUserid(user.getId());
            //9、该订单中有多少订单项List<OrderItem> orderItems = new ArrayList<OrderItem>();
            //获得购物车中的购物项的集合map
            Map<String, CartItem> cartItems = cart.getCartItems();
            for(Map.Entry<String, CartItem> entry : cartItems.entrySet()){
                //取出每一个购物项
                CartItem cartItem = entry.getValue();
                //创建新的订单项
                Orderitem orderItem = new Orderitem();
                //1)private String itemid;//订单项的id
                orderItem.setItemid(UUID.randomUUID().toString());
                //2)private int count;//订单项内商品的购买数量
                orderItem.setCount(cartItem.getBuyNum());
                //3)private double subtotal;//订单项小计
                orderItem.setSubtotal(cartItem.getSubtotal());
                //4)private Product product;//订单项内部的商品
                orderItem.setProduct(cartItem.getProduct());
                //5)private Order order;//该订单项属于哪个订单
                orderItem.setOrder(order);
                //将该订单项添加到订单的订单项集合中
                order.getOrderItems().add(orderItem);
            }
            return BaseResult.success(orderService.addOder(user,order,product));
        }else{
            return BaseResult.createResult("用户不存在",(Object) null);
        }
    }

}
