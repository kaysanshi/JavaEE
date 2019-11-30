package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.Order;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.domain.User;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
public interface OrderService {
    Order addOder(User user, Order order, Product product);
}
