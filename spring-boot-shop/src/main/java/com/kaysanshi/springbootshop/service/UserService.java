package com.kaysanshi.springbootshop.service;

import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.UserQueryVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
public interface UserService {
    User getCurrentUser(HttpServletRequest request, HttpServletResponse response);

    User login(User user);

    BaseResult register(User user);

    User update(User user);

    Integer getCountUser();

    Integer getCountNewUser(User user);

    BaseResult getList(UserQueryVO userQueryVO);
}
