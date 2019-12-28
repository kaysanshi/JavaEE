package com.kaysanshi.springbootshop.service.impl;

import com.kaysanshi.springbootshop.dao.UserMapper;
import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.UserQueryVO;
import com.kaysanshi.springbootshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author kay三石
 * @date:2019/11/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        User user=(User)request.getSession().getAttribute("LoginUser");
        System.out.println(user.getId());
        if (user!=null){
            User currentUser=userMapper.selectOne(user);
            if (currentUser!=null){
                System.out.println(currentUser.getId());
                return currentUser;
            }else{
                return null;
            }
        }else{
            return null;
        }

    }

    @Override
    public User login(User user) {
        if (user.getUsername()!=null&&user.getPassword()!=null){
            return userMapper.selectOne(user);
        }else{
            return null;
        }
    }

    @Override
    public BaseResult register(User user) {
        if (user!=null){
             if(userMapper.insert(user)>0){
                return BaseResult.success();
             }else{
                 return BaseResult.createErrorMessageResult(user,"保存出错");
             }
        }else{
            return BaseResult.createErrorMessageResult("用户为空",null);
        }

    }

    @Override
    public User update(User user) {
        if (user!=null){
            if(userMapper.updateByPrimaryKey(user)>0){
                return userMapper.selectOne(user);
            }else{
                return null;
            }
        }else{
            return null;
        }

    }

    @Override
    public Integer getCountUser() {
        User user=new User();
        return userMapper.selectCount(user);
    }

    @Override
    public Integer getCountNewUser(User user) {
        Example example=new Example(user.getClass());
        Example.Criteria criteria=example.createCriteria();
        criteria.andLessThanOrEqualTo("createTime",new Date());
        return userMapper.selectCountByExample(example);
    }

    @Override
    public BaseResult getList(UserQueryVO userQueryVO) {
        Map<String, Object> res = new HashMap<>();
        userQueryVO.setStart((userQueryVO.getPage() - 1) * userQueryVO.getLimit());
        List<User> list = userMapper.query(userQueryVO);

        int sum = userMapper.querySum(userQueryVO);
        res.put("code","0");
        res.put("data", list);
        res.put("count", sum);
        //System.out.println(res);
        return BaseResult.createResult(res.get("code").toString(),"操作成功",res.get("data"),res.get("count").toString());


    }
}
