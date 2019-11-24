package com.kayleoi.springbootshop.controller;

import com.kayleoi.springbootshop.domain.Admin;
import com.kayleoi.springbootshop.dto.BaseResult;
import com.kayleoi.springbootshop.service.AdminService;
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

        if (adminService.login(request, response) != null) {
            return BaseResult.success(adminService.login(request, response));
        } else {
            return BaseResult.error(adminService.login(request, response));
        }
    }
}
