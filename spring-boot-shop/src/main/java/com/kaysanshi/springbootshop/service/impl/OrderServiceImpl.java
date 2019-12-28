package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.OrderMapper;
import com.kaysanshi.springbootshop.dao.OrderitemMapper;
import com.kaysanshi.springbootshop.dao.ProductMapper;
import com.kaysanshi.springbootshop.dao.UserMapper;
import com.kaysanshi.springbootshop.domain.*;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.OrderQueryVO;
import com.kaysanshi.springbootshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductMapper productMapper;

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

    @Override
    public Integer getCount(Order order) {
        return orderMapper.selectCount(order);
    }

    @Override
    public BaseResult getlist(OrderQueryVO orderQueryVO) {
        Map<String, Object> res = new HashMap<>();
        orderQueryVO.setStart((orderQueryVO.getPage() - 1) * orderQueryVO.getLimit());
        List<Order> list = orderMapper.query(orderQueryVO);
        if (list !=null){
            for (int i=0;i<list.size();i++){
                Orderitem orderitem=new Orderitem();
                orderitem.setOrderid(list.get(i).getId());
                List <Orderitem> orderitemList = orderItemMapper.select(orderitem);
                for (int j=0;j<orderitemList.size();j++){
                    if (orderitemList.get(j).getProductid()!=null || (orderitemList.get(j).getProductid()!="")){
                        Product producttem=new Product();
                        producttem.setId(orderitemList.get(j).getProductid());
                        Product product=productMapper.selectOne(producttem);
                        orderitemList.get(j).setProduct(product);
                    }

                }
                list.get(i).setOrderItems(orderitemList);
                User user=new User();
                user.setId(list.get(i).getUserid());
                User user1= userMapper.selectOne(user);
                list.get(i).setUser(user1);
            }

        }
        int sum = orderMapper.querySum(orderQueryVO);
        res.put("code","0");
        res.put("data", list);
        res.put("count", sum);
        //System.out.println(res);
        return BaseResult.createResult(res.get("code").toString(),"操作成功",res.get("data"),res.get("count").toString());


    }

    @Override
    public BaseResult getOrder(Order order) {
        Order list = orderMapper.selectOne(order);
        if (list !=null){
            Orderitem orderitem=new Orderitem();
            orderitem.setOrderid(list.getId());
            List <Orderitem> orderitemList = orderItemMapper.select(orderitem);
            for (int j=0;j<orderitemList.size();j++) {
                if (orderitemList.get(j).getProductid() != null || (orderitemList.get(j).getProductid() != "")) {
                    Product producttem = new Product();
                    producttem.setId(orderitemList.get(j).getProductid());
                    Product product = productMapper.selectOne(producttem);
                    orderitemList.get(j).setProduct(product);
                }

            }
            list.setOrderItems(orderitemList);
            User user=new User();
            user.setId(list.getUserid());
            User user1= userMapper.selectOne(user);
            list.setUser(user1);
            return  BaseResult.success(list);
        }
        return null;
    }
}
