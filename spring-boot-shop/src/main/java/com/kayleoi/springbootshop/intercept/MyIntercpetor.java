package com.kayleoi.springbootshop.intercept;

import com.kayleoi.springbootshop.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author kay三石
 * @date:2019/11/1
 * @component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
 * 泛指组件
 */
@Component
public class MyIntercpetor implements HandlerInterceptor {

    /**
     * 完成后的拦截
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * post请求拦截
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
//		System.out.println(logService);

        System.out.println("拦截器：" + request.getRequestURI());
        //访问记录
        //截取html访问请求
        String loguri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
        if (loguri.endsWith(".html")) {
            System.out.println("request = [" + request + "], response = [" + response + "], handler = [" + handler + "]");
        }
    // 判断当前用户是否已经登陆
//        HttpSession session = request.getSession();
//        User loginUser = (User)session.getAttribute("loginUser");
//
//        if ( loginUser == null ) {
//            String path = session.getServletContext().getContextPath();
//            response.sendRedirect(path + "/page/login.html");
//            return false;
//        } else {
//            return HandlerInterceptor.super.preHandle(request, response, handler);
//        }
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
