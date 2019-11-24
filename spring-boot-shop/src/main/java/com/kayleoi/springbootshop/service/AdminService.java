package com.kayleoi.springbootshop.service;

import com.kayleoi.springbootshop.domain.Admin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/9
 */
public interface AdminService {
    Admin login(HttpServletRequest request, HttpServletResponse response);
}
