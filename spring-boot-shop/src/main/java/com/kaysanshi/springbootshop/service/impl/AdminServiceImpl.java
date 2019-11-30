package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.AdminUserMapper;
import com.kaysanshi.springbootshop.domain.Admin;
import com.kaysanshi.springbootshop.service.AdminService;
import com.kaysanshi.springbootshop.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
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
    AdminUserMapper adminUserMapper;

    @Override
    public Admin login(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setPassword(MD5Utils.md5(password));
        if (username!=null&&password!=null){
            Admin admin1= adminUserMapper.selectOne(admin);
            if (admin1!=null){
                return admin1;
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public Admin upload(HttpServletRequest request, HttpServletResponse response, Admin admin) {

        if(adminUserMapper.updateByPrimaryKey(admin)>0){
            return adminUserMapper.selectByPrimaryKey(admin);
        }else{
            return null;
        }
    }
}
