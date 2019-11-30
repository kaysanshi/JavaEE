package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
public interface UserService {
    User getCurrentUser(HttpServletRequest request, HttpServletResponse response);
}
