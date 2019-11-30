package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.Admin;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/9 后台登录
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult login(HttpServletRequest request, HttpServletResponse response) {
       Admin user= adminService.login(request, response);
        if (user != null) {
            System.out.println(BaseResult.success(adminService.login(request, response)));
            request.getSession().setAttribute("user",user);
            return BaseResult.success(adminService.login(request, response));
        } else {
            return BaseResult.error(adminService.login(request, response));
        }
    }

    /**
     *修改
     * @param response
     * @param request
     * @param admin
     * @return
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ResponseBody
    public BaseResult update(HttpServletResponse response, HttpServletRequest request, Admin admin){
        if (adminService.upload(request,response,admin)!=null){
            return BaseResult.success(adminService.upload(request,response,admin));
        }else{
            return BaseResult.error(adminService.upload(request,response,admin));
        }

    }

    /**
     * 退出
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public BaseResult logout(HttpServletRequest request, HttpServletResponse response){
        Admin user= (Admin) request.getSession().getAttribute("user");
        if (user!=null){
            request.getSession().invalidate(); //销毁session
            return BaseResult.success(null);
        }else{
            return BaseResult.error("退出失败");
        }
    }
}
