package com.leo.hotel.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mapper.Mapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.config.UploadConfig;
import com.leo.hotel.domain.User;
import com.leo.hotel.mapper.UserMapper;
import com.leo.hotel.service.UserService;
import com.leo.hotel.utils.MD5Utils;
import com.leo.hotel.utils.PageBean;
/**
 * 
 * @author leoi555
 *
 */
@Transactional
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UploadConfig uploadConfig;
	@Override
	public Map<String, Object> addUser(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		user.setPassword(MD5Utils.md5(user.getPassword()));
		if (userMapper.add(user) > 0) {
			res.put("code", "0");
			res.put("msg", "添加成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "添加失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> checkUser(User user) {
		
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		String password=MD5Utils.md5(user.getPassword());
		user.setPassword(password);
		System.out.println(userMapper);
		User user2 = userMapper.checkUser(user);
		System.out.println(user2);
		if (user2!=null) {
			res.put("code", "0");
			res.put("msg", "添加成功");
			res.put("data", user2);
		} else {
			res.put("code", "1");
			res.put("msg", "添加失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		//设置开始当前页
		pageBean.setCurrentPage((page-1)*rows);
		//设置每页页大小
		pageBean.setPageSize(rows);
		//查询总的记录数
		int totalCount=userMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		//
		List<User> listdata=userMapper.getPageQueryList(pageBean);
		pageBean.setRows(listdata);
		System.out.println("数据"+listdata);
		Map<String, Object> map=new HashMap<>();
		if (!listdata.isEmpty()) {
			map.put("total", pageBean.getTotal());
			map.put("rows", pageBean.getRows());
			return map;
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
			return map;
		}
	}

	@Override
	public Map<String, Object> updateUser(User user, MultipartFile file, HttpServletResponse response,
			HttpServletRequest req) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		//获取文件的原名
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		//转换后的文件名
		String fileNewName=UUID.randomUUID().toString()+fileName;
		File dest=new File(uploadConfig.getPimgPath()+fileNewName);
		System.out.println(dest.exists());
		if (!dest.getParentFile().exists()){
			dest.getParentFile().mkdirs();
			try {
				dest.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			file.transferTo(dest);
			String filepath=uploadConfig.getPimgPath()+fileNewName;
			//为了能够请求到所以要这样书写
			user.setHeadshot("/imgs/"+fileNewName);
			System.out.println("头像："+user.getHeadshot());
			System.out.println("filepath:"+uploadConfig.getPimgPath()+fileNewName);
			//
			user.setPassword(MD5Utils.md5(user.getPassword()));
			if (userMapper.updateUser(user)> 0){
				map.put("code", "0");
				map.put("msg", "修改成功");
				map.put("data", null);
				System.out.println(map.get("msg"));
				return map;
			} else {
				map.put("code", "1");
				map.put("msg", "修改失败");
				map.put("data", null);
				System.out.println("aaaa");
				System.out.println(map.get("msg"));
				return map;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> delete(String ids) {
		// TODO Auto-generated method stub
		Map<String , Object> map=new HashMap<>();
		if (Strings.isNotBlank(ids)) {
			String[] userids=ids.split(",");
			int i=0;
			//循环执行delete 语句
			for(String id:userids) {
				i=userMapper.deleteBatch(id);
			}
			if (i>0) {
				map.put("code", '0');
				map.put("message", "删除成功");
				map.put("data", null);
			}else {
				map.put("code", '1');
				map.put("message", "删除失败");
				map.put("data", null);
			}
 		}
		return map;
	}

	
}
