package com.kayleoi.springbootshop.service.impl;

import com.kayleoi.springbootshop.dao.AdminMapper;
import com.kayleoi.springbootshop.domain.Admin;
import com.kayleoi.springbootshop.service.AdminService;
import com.kayleoi.springbootshop.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/9
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setPassword(MD5Utils.md5(password));
        if (username!=null&&password!=null){
            Admin admin1=adminMapper.selectOne(admin);
            if (admin1!=null){
                return admin1;
            }else{
                return null;
            }
        }
        return null;
    }
}
