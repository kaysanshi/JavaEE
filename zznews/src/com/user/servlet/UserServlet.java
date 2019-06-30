package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDAO;
import com.util.MD5;

public class UserServlet extends HttpServlet {

	
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
		
		if(action.equals("login")){//会员登录
			login(request,response);	
		}else if(action.equals("logout")){ //会员注销
			logout(request,response);
		}else if(action.equals("register")){ //会员注册
			register(request,response);
		}else if(action.equals("toInputAnswer")){ //进入输入答案页面
			toInputAnswer(request,response);
		}else if(action.equals("answer")){ //重置密码
			answer(request,response);
		}else if(action.equals("edit")){ //进入修改会员信息页面
			edit(request,response);
		}else if(action.equals("update")){ //修改会员信息
		    update(request,response);
		}else if(action.equals("updatepwd")){ //修改会员密码
			updatepwd(request,response);
		}else if(action.equals("validateUsername")){ //用于响应AJAX验证用户的提交（用于验证用户名）
			validateUsername(request,response);
		}
	}
	
	
	//用户登录
	public void login(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("asfuw9yegf89aey89awyg89we"+username+password);
		//用户提交的验证码
		String checkcode=request.getParameter("checkcode");
		String message="";
		
		HttpSession session=request.getSession();
		//服务器保存的验证码
		String realcheckcode=session.getAttribute("checkcode").toString();
		//验证码正确
		if(checkcode.equals(realcheckcode)){
				UserDAO userDAO=new UserDAO();
				Map<String,Object> user=userDAO.validateUser(username, MD5.md5(password));
				
				if(user!=null){
					//更新上一次的登录时间
					Map<String,Object> record=new HashMap<String,Object>();
					record.put("lasttime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));	
					record.put("userid", user.get("userid"));
					userDAO.update(record);
					//把该用户信息放入Session	
					session.setAttribute("user", user);
					message="<script>alert('登录成功');window.location.href='newsServlet?action=displayNews';</script>";
				}else{
					message="<script>alert('登录失败');window.location.href='newsServlet?action=displayNews';</script>";
				}		
			
		}else{		
			message="<script>alert('验证码错误');window.location.href='newsServlet?action=displayNews';</script>";		
		}
		
		//把信息放入页面
		request.setAttribute("message", message);

        //跳转页面		
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}


	//用户注销
	public void logout(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		String message="<script>alert('注销成功');window.location.href='newsServlet?action=displayNews';</script>";
		//把信息放入页面
		request.setAttribute("message", message);

        //跳转页面		
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	
	
	//用户注册
	public void register(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
           
		//1、获取数据
		String username=request.getParameter("username");
		String password1=request.getParameter("password1");	
		String password2=request.getParameter("password2");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		
		//2、组装数据
		Map<String,Object> record=new HashMap<String,Object>();
		record.put("username", username);
		record.put("password", MD5.md5(password1));
		record.put("sex", sex);
		record.put("phone", phone);
		record.put("question", question);
		record.put("answer", answer);
		record.put("lasttime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
     
		
		String message="";
		
		//标志变量
		boolean isSuccess=false;
		if(password1!=null && !password1.equals("") && password2!=null && !password2.equals("") && answer!=null && !answer.equals("")){
				//判断两次的密码是否一致
				if(password1.equals(password2)){

					    //判断该用户名是否已经存在
					    UserDAO userDAO=new UserDAO();
					    Map<String,Object> user=userDAO.getByusername(username);
					    //说明可以注册
					    if(user==null){
			
								//3、调用DAO				
								int flag=userDAO.add(record);
								
								if(flag>0){					
									message="<script>alert('注册成功');window.location.href='newsServlet?action=displayNews';</script>";
								}else{
									message="<script>alert('注册失败');</script>";
								}
					    }else{
					    	message="<script>alert('该用户已经存在');</script>";
					    }

				}else{
					message="<script>alert('两次密码不一致');</script>";
				}
			
		}else{
			message="<script>alert('请正确填写信息');</script>";
		}

		//把信息放入页面
		request.setAttribute("message", message);

		if(isSuccess){
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			//把用户填写的信息放入页面
			request.setAttribute("record", record);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

		
    }
	
	
	//进入输入答案页面
	public void toInputAnswer(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//接收用户名
		String username=request.getParameter("username");
		
		//查询数据库
		UserDAO userDAO=new UserDAO();
		Map<String,Object> record=userDAO.getByusername(username);

		//说明你要找回密码的账号不存在
		if(record==null){
			String message="<script>alert('该用户不存在');window.location.href='newsServlet?action=displayNews';</script>";
			//把信息放入页面
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);	
		}else{
			request.setAttribute("record", record);
	        //跳转页面		
			request.getRequestDispatcher("inputAnswer.jsp").forward(request, response);				
			
		}
	}
	
	
	//重置密码
	public void answer(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//接收用户名
		String username=request.getParameter("username");
		//问题
		String question=request.getParameter("question");
		//答案
		String answer=request.getParameter("answer");
		
		//查询数据库
		UserDAO userDAO=new UserDAO();
		Map<String,Object> record=userDAO.validateAnswer(username, question, answer);

		String message="";
		//说明验证信息通过
		if(record!=null){
				//重置密码为000000
				Map<String,Object> user=new HashMap<String,Object>();
				user.put("password", MD5.md5("000000"));
				user.put("userid", record.get("userid"));
				int isSuccess=userDAO.update(user);
				if(isSuccess>0){
					 message="<script>alert('恭喜你，你的密码已经被重围为000000，请及时登录修改！');window.location.href='newsServlet?action=displayNews';</script>";		
				}else{
					message="<script>alert('重置失败，请联系管理员！');window.location.href='newsServlet?action=displayNews';</script>";		
				}

		}else{
			    message="<script>alert('你输入的答案不正确');window.location.href='newsServlet?action=displayNews';</script>";				
		}
		
		//把信息放入页面
		request.setAttribute("message", message);
		request.getRequestDispatcher("message.jsp").forward(request, response);	
	}
	
	
	
	//进入修改会员信息页面
	public void edit(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
        
		HttpSession session=request.getSession();
		Map<String,Object> user=(Map<String,Object>)session.getAttribute("user");
		
		//获取会员账号
		String username=user.get("username").toString();
		//调用DAO
		UserDAO userDAO=new UserDAO();
		Map<String,Object> record=userDAO.getByusername(username);

		//把信息放入页面
		request.setAttribute("record", record);
		
        //跳转页面		
		request.getRequestDispatcher("edituser.jsp").forward(request, response);
		
    }
	
	//修改会员信息
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
           
		//1、获取数据
			  
		HttpSession session=request.getSession();
		Map<String,Object> user=(Map<String,Object>)session.getAttribute("user");
		
		String userid=user.get("userid").toString();
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");

		//2、组装数据
		Map<String,Object> record=new HashMap<String,Object>();
		record.put("sex", sex);
		record.put("phone", phone);
		record.put("question", question);
		record.put("answer", answer);
		
		record.put("userid", userid);
		
		//3、调用DAO
		UserDAO userDAO=new UserDAO();
		int flag=userDAO.update(record);
		String message="";
		if(flag>0){
			message="<script>alert('修改成功');window.location.href='userServlet?action=edit';</script>";
		}else{
			message="<script>alert('修改失败');window.location.href='userServlet?action=edit';</script>";
		}
		//把信息放入页面
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("message.jsp").forward(request, response);
		
		
    }
	
	
	
	//修改会员密码
	public void updatepwd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
           
		//1、获取数据
			  
		HttpSession session=request.getSession();
		Map<String,Object> user=(Map<String,Object>)session.getAttribute("user");
		
		String userid=user.get("userid").toString();
		
		String username=user.get("username").toString();
		
		String oldpwd=request.getParameter("oldpwd");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String message="";
		
		if(password1.equals(password2)){
				//判断原始密码是否正确
				UserDAO userDAO=new UserDAO();
		        //说明密码正确
				if(userDAO.validateUser(username, MD5.md5(oldpwd))!=null){
	
						//2、组装数据
						Map<String,Object> record=new HashMap<String,Object>();
						record.put("password",  MD5.md5(password1));
						record.put("userid", userid);
						
						//3、调用DAO
						
						int flag=userDAO.update(record);
						
						if(flag>0){
							message="<script>alert('修改成功');window.location.href='/front/index.jsp';</script>";
						}else{
							message="<script>alert('修改失败');window.location.href='editpwd.jsp';</script>";
						}
					
				}else{
					message="<script>alert('原始密码不正确');window.location.href='editpwd.jsp';</script>";
				}
			
		}else{
			
			message="<script>alert('两次密码不一致');window.location.href='editpwd.jsp';</script>";
		}
		//把信息放入页面
		request.setAttribute("message", message);
		request.getRequestDispatcher("message.jsp").forward(request, response);
    }
	
	
	//验证用户名
	public void validateUsername(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String username=request.getParameter("username");
		
		System.out.println("AJAX提交的用户名为："+username);
		
		//调用DAO
		UserDAO userDAO=new UserDAO();
		Map<String,Object> user=userDAO.getByusername(username);
		
		PrintWriter out=response.getWriter();
		//该用户不存在,可以注册
		if(user==null){
			System.out.println("没有找到用户名");
			out.print("1");
		}else{//该用户名已经存在，不可以注册
			System.out.println("找到用户名");
			out.print("2");
		}
		
		
	}

}