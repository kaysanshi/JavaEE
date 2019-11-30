package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.UserMapper;
import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        User user=(User)request.getSession().getAttribute("LoginUser");
        if (user!=null){
            User currentUser=userMapper.selectOne(user);
            if (currentUser!=null){
                return currentUser;
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}
