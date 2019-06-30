package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.AdminDAO;
import com.util.MD5;

public class AdminServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//把所有的请求都转交给doPost
		doPost(request,response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//转码
		request.setCharacterEncoding("UTF-8");
				
		//action表示用来区别到底是什么操作
		String action=request.getParameter("action");
					
		if(action.equals("login")){//管理员登录
			login(request,response);	
		}else if(action.equals("logout")){ //管理员注销
			logout(request,response);
		}else if(action.equals("updatepwd")){ //管理员注销
			updatepwd(request,response);
		}
				
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String adminname=request.getParameter("adminname");
		String password=request.getParameter("password");
		
		AdminDAO adminDAO=new AdminDAO();
		Map<String,Object> admin=adminDAO.validate(adminname, password);
		String message="";
		if(admin!=null){
			//把该管理员信息放入Session
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);	
			message="<script>window.location.href='admin/adminIndex.jsp';</script>";
		
		}else{
			message="<script>alert('用户名或密码错误');window.location.href='admin/adminlogin.jsp';</script>";
		}
		
		//把信息放入页面
		request.setAttribute("message", message);
		
		//跳转页面		
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	
	
	//管理员注销
		public void logout(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			HttpSession session=request.getSession();
			session.invalidate();
		
			String message="<script>alert('注销成功');window.location.href='admin/adminlogin.jsp';</script>";
			//把信息放入页面
			request.setAttribute("message", message);
			
			//跳转页面		
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		
		
		//修改管理员密码
		public void updatepwd(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			//1、获取数据  
			HttpSession session=request.getSession();
			Map<String,Object> admin=(Map<String,Object>)session.getAttribute("admin");
			
			String adminid=admin.get("adminid").toString();
			
			String adminname=admin.get("adminname").toString();
			
			String oldpwd=request.getParameter("oldpwd");
			String password1=request.getParameter("password1");
			String password2=request.getParameter("password2");
			
			String message="";
			if(password1.equals(password2)){
					//判断原始密码是否正确
					AdminDAO adminDAO=new AdminDAO();
			        //说明密码正确
					if(adminDAO.validate(adminname, oldpwd)!=null){
							//2、组装数据
							Map<String,Object> record=new HashMap<String,Object>();
							record.put("password",  password1);
							record.put("adminid", adminid);
							//3、调用DAO
							int flag=adminDAO.update(record);
							if(flag>0){
								message="<script>alert('修改成功');window.location.href='admin/editpwd.jsp';</script>";
							}else{
								message="<script>alert('修改失败');window.location.href='admin/editpwd.jsp';</script>";
							}
						
					}else{
						message="<script>alert('原始密码不正确');window.location.href='admin/editpwd.jsp';</script>";
					}
				
			}else{
				
				message="<script>alert('两次密码不一致');window.location.href='admin/editpwd.jsp';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
			
	    }
	

}
