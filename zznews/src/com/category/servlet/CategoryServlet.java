package com.category.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.category.dao.CategoryDAO;
import com.util.QueryResult;

public class CategoryServlet extends HttpServlet {

	
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
		
				if(action.equals("add")){
					add(request,response);	
				}else if(action.equals("list")){ //分类列表
					list(request,response);
				}else if(action.equals("del")){ //分类删除
					del(request,response);
				}else if(action.equals("edit")){ //进入修改页面
					edit(request,response);
				}else if(action.equals("update")){//修改
					update(request,response);
				}
		
	}
	
	//添加分类
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1、获取数据
		String name=request.getParameter("name");
		String sort=request.getParameter("sort");
		
		//2、组装数据
		Map<String,Object> record=new HashMap<String,Object>();
		record.put("name", name);
		record.put("sort", sort);
		
		//3、调用DAO
		CategoryDAO categoryDAO=new CategoryDAO();
		int flag=categoryDAO.add(record);
		String message="";
		if(flag>0){
			message="<script>alert('操作成功');</script>";
		}else{
			message="<script>alert('操作失败');</script>";
		}
		
		//把信息放入页面
		request.setAttribute("message", message);

		//4、跳转页面		
		request.getRequestDispatcher("/category/addCategory.jsp").forward(request, response);

}
	
	//产品列表
		public void list(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	         
			//当前要看哪一页
			String currentPage=request.getParameter("currentPage");
			//如果没有输入页数，那就看第一页
			if(currentPage==null || currentPage.equals("")){
				currentPage="1";
			}
			
			//页大小
			int pageSize=10;
			
			//计算从哪一条开始看		
			int startIndex=(Integer.parseInt(currentPage)-1)*pageSize;
			
			//调用DAO
			CategoryDAO categoryDAO=new CategoryDAO();
			//查询出所有的产品
			QueryResult qr=categoryDAO.list(startIndex,pageSize);
			
			// 记录总数
			int totalCount=qr.getTotalCount();
			
			
			//总页数
			int totalPage=0;
			int temp=totalCount%pageSize;
			//刚好整除
			if(temp==0){
				totalPage=totalCount/pageSize;
			}else{//不能整除
				totalPage=totalCount/pageSize+1;
			}
					
			
			//把信息放入页面
			request.setAttribute("records", qr.getRecords());
			
			//把记录总数放入页面
			request.setAttribute("totalCount", totalCount);
			
			//把记当前页放入页面
			request.setAttribute("currentPage", currentPage);
			
			//把总页数放入页面
			request.setAttribute("totalPage", totalPage);

	        //跳转页面		
			request.getRequestDispatcher("/category/listCategory.jsp").forward(request, response);
			
	    }
		
		//分类删除
		public void del(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//删除产品的ID
			String categoryid=request.getParameter("categoryid");
			
			//调用DAO
			CategoryDAO categoryDAO=new CategoryDAO();
			int flag=categoryDAO.del(Integer.parseInt(categoryid));
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='categoryServlet?action=list';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='categoryServlet?action=list';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

			request.getRequestDispatcher("message.jsp").forward(request, response);

			
	    }
		
		
		//进入修改页面
		public void edit(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//产品的ID
			String categoryid=request.getParameter("categoryid");
			//调用DAO
			CategoryDAO categoryDAO=new CategoryDAO();
			Map<String,Object> record=categoryDAO.get(Integer.parseInt(categoryid));

			//把信息放入页面
			request.setAttribute("record", record);
			//跳转页面		
			request.getRequestDispatcher("/category/editCategory.jsp").forward(request, response);
			
	    }
		
		//保存修改
		public void update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//1、获取数据
			String name=request.getParameter("name");
			String sort=request.getParameter("sort");
			
			
			String categoryid=request.getParameter("categoryid");
			
			//2、组装数据
			Map<String,Object> record=new HashMap<String,Object>();
			
			
			record.put("name", name);
			record.put("sort", sort);
			record.put("categoryid", categoryid);
			
			//3、调用DAO
			CategoryDAO categoryDAO=new CategoryDAO();
			int flag=categoryDAO.update(record);
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='categoryServlet?action=list';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='categoryServlet?action=list';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
			
	    }	

	}
