package com.kaysanshi.institute.mapper;

import com.kaysanshi.institute.bean.User;

public interface UserMapper {

	User login(User user);

	int updatepwd(User requser);

}
