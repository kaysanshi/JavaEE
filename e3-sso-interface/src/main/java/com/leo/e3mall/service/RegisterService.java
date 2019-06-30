package com.leo.e3mall.service;

import com.leo.e3mall.pojo.User;
import com.leo.e3mall.utils.E3Result;
public interface RegisterService {

	E3Result checkData(String param, int type);
	E3Result register(User user);
}
