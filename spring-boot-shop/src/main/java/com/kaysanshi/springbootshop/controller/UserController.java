package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.UserQueryVO;
import com.kaysanshi.springbootshop.service.UserService;
import com.kaysanshi.springbootshop.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/11/9
 * 前台用户登录
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    /**
     * 登录接口
     * @param user
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult login(User user, HttpServletRequest request, HttpServletResponse response){
       User users=new User();
       users.setUsername(request.getParameter("username"));
       users.setPassword(request.getParameter("password"));
        if (users!=null){
           User user1= userService.login(users);
           System.out.println(user1);

             if (user1!=null){
                 //String token=baseResult.getData().toString();
                 BaseResult baseResult=BaseResult.success();
                 request.getSession().setAttribute("LoginUser",user1);
                 return baseResult;
                 //这时把tooken写入到cookie
                 //CookieUtils.setCookie(request,response,"token",token);
             }
             return BaseResult.error();

        }else{
            return BaseResult.error();
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value="/register", method= RequestMethod.POST)
    @ResponseBody
    public BaseResult register(User user) {
        user.setId(UUID.randomUUID().toString());
        BaseResult baseResult = userService.register(user);
        return baseResult;
    }

    /**
     * 用户修改信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult update(User user){
        if (user.getId()!=null){
            return BaseResult.success(userService.update(user));
        }else{
            return BaseResult.createErrorMessageResult("用户Id为null","");
        }
    }

    /**
     * 获取用户总数
     * @return
     */
    @RequestMapping("/count")
    @ResponseBody
    public BaseResult getCountUser(){
        return BaseResult.success(userService.getCountUser());
    }
    /**
     * 获取新增人数
     */
    @RequestMapping("/newUserCount")
    @ResponseBody
    public BaseResult getAddUserCount(){
        return BaseResult.success(userService.getCountNewUser(new User()));
    }

    /**
     * 获取列表
     * @param userQueryVO
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult getUserList(UserQueryVO userQueryVO) {
        return userService.getList(userQueryVO);
    }

}
