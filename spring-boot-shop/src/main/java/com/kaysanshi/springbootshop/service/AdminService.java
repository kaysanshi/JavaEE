package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/9
 */
public interface AdminService {
    Admin login(HttpServletRequest request, HttpServletResponse response);

    Admin upload(HttpServletRequest request, HttpServletResponse response, Admin admin);
}
