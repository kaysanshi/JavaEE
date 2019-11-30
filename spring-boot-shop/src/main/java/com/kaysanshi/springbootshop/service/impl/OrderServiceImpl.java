package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.OrderMapper;
import com.kaysanshi.springbootshop.dao.OrderitemMapper;
import com.kaysanshi.springbootshop.domain.Order;
import com.kaysanshi.springbootshop.domain.Orderitem;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderitemMapper orderItemMapper;

    @Override
    public Order addOder(User user, Order order, Product product) {
        if (orderMapper.insert(order) > 0) {
            List <Orderitem> orderitems = order.getOrderItems();
            for (Orderitem orderItem : orderitems) {
                orderItemMapper.insert(orderItem);
            }
            return orderMapper.selectOne(order);
        } else {
            return null;

        }
    }
}
