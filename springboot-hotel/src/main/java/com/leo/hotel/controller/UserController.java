package com.leo.hotel.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.Http11AprProtocol;
import org.junit.runners.Parameterized.Parameters;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.config.UploadConfig;
import com.leo.hotel.domain.User;
import com.leo.hotel.service.UserService;
import com.leo.hotel.utils.JavaToJSon;
import com.leo.hotel.utils.PageBean;

/**
 * 用户
 * @author leoi555
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userService;
	@Autowired
	private PageBean pageBean;
	
	@RequestMapping("/getAll{name}")//带有参数的使用
	@Deprecated
	public List<User> getAll(@PathVariable("name")String name){
		
		return null;	
	}
	/**
	 * 前台注册
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	public Map<String, Object> registUser(User user,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (user.getUsername()!=null&& user.getPassword()!=null) {
			return userService.addUser(user);
		}else {
			map.put("code", "1");
			map.put("msg", "0");
			map.put("data", null);
		}
		return map;	
	}
	/**
	 * 前台登录
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/userlogin")
	@ResponseBody
	public Map<String, Object> loginUser(User user,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		System.out.println("输入的用户名："+user.getUsername());
		System.out.println("输入的验证码："+user.getCheckcode());
			if (user.getUsername()!=null &&user.getPassword()!=null) {
				map=userService.checkUser(user);
				User user2=(User) map.get("data");
				System.out.println("data:"+map.get("data"));
				request.getSession().setAttribute("loginUser", user2.getUsername());	
				System.out.println(1111);
				return map;
			}else {
				map.put("code", "1");
				map.put("msg", "请输入你的信息");
				map.put("data", null);
				return map;
			}
	}
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> deleteUser(@RequestParam(value="ids") String ids, HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
			map=userService.delete(ids);
		return map;
		
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @param file
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public Map<String, Object> UpdateUser(User user,@RequestParam(value="file") MultipartFile file,HttpServletRequest req,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		if (user.getUsername()!=null &&user.getPassword()!=null){
			if (file.isEmpty()){
				map.put("code", "1");
				map.put("msg", "文件为空");
				map.put("data", null);
				return map;
			}else {
				return userService.updateUser(user,file,response,req);
 			}
			
		}else {
			map.put("code", "1");
			map.put("msg", "信息不全");
			map.put("data", null);
			return map;
		}	
	}
	/**
	 * 获取分页列表
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	@ResponseBody
	public void list(@RequestParam(name="page", required=false)Integer page,@RequestParam(name="rows",required=false)Integer rows,HttpServletRequest request
			,HttpServletResponse response) {
			Map<String, Object> map=new HashMap<>();
			//设置当前页
			pageBean.setCurrentPage(page);
			//设置页大小
			pageBean.setPageSize(rows);
			System.out.println("当前页："+page);
			System.out.println("显示的行数："+rows);
			map=userService.getList(page,rows,pageBean);
			System.out.println("列表zzz："+map.get("rows"));
			JavaToJSon.ResponseToJson(response, map);
	}
	/**
	 * 添加用户
	 * @param user
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String, Object> add(User user, @RequestParam(name="file") MultipartFile file,HttpServletRequest request
			,HttpServletResponse response){
		System.out.println(file);
		Map<String, Object> map=new HashMap<>();
		if (user.getUsername()!=null &&user.getPassword()!=null) {
			if (file.isEmpty()){
				map.put("code", "1");
				map.put("msg", "文件为空");
				map.put("data", null);
				return map;
			}else {
				//获取文件的原名
				String fileName=file.getOriginalFilename();
				System.out.println(fileName);
				//转换后的文件名
				String fileNewName=UUID.randomUUID().toString()+fileName;
				String path="D:/hotel/upload/user/img/";
				File dest=new File(path+fileNewName);
				System.out.println(dest.exists());
				if (!dest.getParentFile().exists()) {
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
					String filepath=path+fileNewName;
					user.setHeadshot(filepath);
					System.out.println("filepath:"+path+fileNewName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
			return userService.addUser(user);
		}else {
			map.put("code", "1");
			map.put("msg", "信息不全");
			map.put("data", null);
			return map;
		}
		
	}
	/**
	 * 登录
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(User user,HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map=new HashMap<>();
		String code= (String) request.getAttribute("checkcode");
		String sessioncode=(String) request.getSession().getAttribute("vcode");
		System.out.println("输入的用户名："+user.getUsername());
		System.out.println("输入的验证码："+user.getCheckcode());
		if(user.getCheckcode().equals(sessioncode)) {
			if (user.getUsername()!=null &&user.getPassword()!=null) {
				map=userService.checkUser(user);
				User user2=(User) map.get("data");
				System.out.println("data:"+map.get("data"));
				request.getSession().setAttribute("loginUser", user2.getUsername());
				request.getSession().setAttribute("loginUserid", user2.getId());
			
				System.out.println(1111);
				return map;
			}else {
				map.put("code", "1");
				map.put("msg", "请输入你的信息");
				map.put("data", null);
				return map;
			}
		}else {
			map.put("code", "1");
			map.put("msg", "请输入验证码");
			map.put("data", null);
			return map;
		}
		
	}
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return 
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public void logout(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, Object> map=new HashMap<>();
		String attribute = (String) request.getSession().getAttribute("loginUser");
		System.out.println("退出的用户："+attribute);
		if (attribute!=null) {
			request.getSession().invalidate();
			map.put("code", "0");
			map.put("msg", "已退出");
			map.put("data", attribute);
			JavaToJSon.ResponseToJson(response, map);
			
		}else {
			map.put("code", "1");
			map.put("msg", "退出失败");
			map.put("data", null);
			JavaToJSon.ResponseToJson(response, map);
		}
		
	}
	
}
