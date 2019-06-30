package com.news.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.category.dao.CategoryDAO;
import com.check.dao.CheckDAO;
import com.comment.dao.CommentDAO;
import com.news.dao.NewsDAO;
import com.util.BaseCalculate;
import com.util.QueryResult;

public class NewsServlet extends HttpServlet {

	
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
		
		//发布新闻
		if(action.equals("publish")){
		    publish(request,response);	
		}else if(action.equals("publishUI")){//进入发布页面
			publishUI(request,response);
		}else if(action.equals("list")){ //新闻列表显示
			list(request,response);
		}else if(action.equals("del")){ //新闻删除
			del(request,response);
		}else if(action.equals("edit")){ //进入修改页面
			edit(request,response);
		}else if(action.equals("update")){//修改
			update(request,response);
		}else if(action.equals("upload")){ //上传新闻封面
			upload(request,response);
		}else if(action.equals("newsDetail")){   //查看新闻详情
			newsDetail(request,response);
		}else if(action.equals("querynews")){   //审核员查看新闻
			querynews(request,response);
		}else if(action.equals("updatestatusandtojsp")){   //进入新闻审核通过页面或未通过页面
			updatestatusandtojsp(request,response);
		}else if(action.equals("checkpassjsp")){   //进入新闻审核通过信息界面
			checkpassjsp(request,response);
		}else if(action.equals("checkpass")){   //保存新闻审核通过信息
			checkpass(request,response);
		}else if(action.equals("checkfailedjsp")){   //进入新闻审核未通过信息界面
			checkfailedjsp(request,response);
		}else if(action.equals("checkfailed")){   //保存新闻审核未通过信息
			checkfailed(request,response);
		}else if(action.equals("afternewssearch")){   //保存新闻审核未通过信息
			afternewssearch(request,response);
		}else if(action.equals("displayNews")){ //前台新闻展示列表
			displayNews(request,response);
		}else if(action.equals("showDetail")){ //显示新闻详细信息
			showDetail(request,response);
		}else if(action.equals("addcomment")){   //对新闻进行评论
			addcomment(request,response);
		}else if(action.equals("mycomment")){//用户查看自己的评论
			mycomment(request,response);
		}else if(action.equals("delComment")){//删除评论
			delComment(request,response);
		}else if(action.equals("search")){//新闻搜索
			search(request,response);
		}
		
	}

	
	
	//发布新闻
		public void publish(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//1、获取数据
			String title=request.getParameter("title");
			String categoryid=request.getParameter("categoryid");
			String userid=request.getParameter("userid");
			String picture=request.getParameter("picture");
			String addtime=request.getParameter("addtime");
			String content=request.getParameter("content");
			//状态
			String status="待审核";
			
			//2、组装数据
			Map<String,Object> record=new HashMap<String,Object>();
			record.put("title", title);
			record.put("categoryid", categoryid);
			record.put("userid", userid);
			record.put("picture", picture);
			record.put("addtime", addtime);
			record.put("content", content);
			record.put("status", status);
			
			//3、调用DAO
			NewsDAO newsDAO=new NewsDAO();
			int flag=newsDAO.add(record);
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='newsServlet?action=list';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='newsServlet?action=publishUI';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

	        //4、跳转页面		
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
	    }
		
		
		//进入发布新闻页面
		public void publishUI(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			
			//调用DAO
			CategoryDAO categoryDAO=new CategoryDAO();
			List<Map<String,Object>> records=categoryDAO.list();

			//把信息放入页面
			request.setAttribute("records", records);

	        //跳转页面		
			request.getRequestDispatcher("news/addNews.jsp").forward(request, response);
			
	    }
		
		
		//新闻列表显示
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
			NewsDAO newsDAO=new NewsDAO();
			//查询出所有的产品
			QueryResult qr=newsDAO.list(startIndex,pageSize);
			
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
			request.getRequestDispatcher("news/listnews.jsp").forward(request, response);
			
	    }
		
		
		//新闻删除
		public void del(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//删除产品的ID
			String newsid=request.getParameter("newsid");
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			int flag=newsDAO.del(Integer.parseInt(newsid));
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='newsServlet?action=list';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='newsServlet?action=list';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

			request.getRequestDispatcher("message.jsp").forward(request, response);

			
	    }
		
		
		//进入修改页面
		public void edit(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//新闻的ID
			String newsid=request.getParameter("newsid");
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			Map<String,Object> record=newsDAO.get(Integer.parseInt(newsid));

			//把信息放入页面
			request.setAttribute("record", record);
			
			
			//调用DAO,查询分类
			CategoryDAO categoryDAO=new CategoryDAO();
			List<Map<String,Object>> records=categoryDAO.list();

			//把信息放入页面
			request.setAttribute("records", records);
			

	        //跳转页面		
			request.getRequestDispatcher("news/editNews.jsp").forward(request, response);
			
	    }
		
		//保存修改
		public void update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//1、获取数据
			String title=request.getParameter("title");
			String categoryid=request.getParameter("categoryid");
			String userid=request.getParameter("userid");
			String picture=request.getParameter("picture");
			String addtime=request.getParameter("addtime");
			String content=request.getParameter("content");
	
			String newsid=request.getParameter("newsid");
			
			//2、组装数据
			Map<String,Object> record=new HashMap<String,Object>();
			record.put("title", title);
			record.put("categoryid", categoryid);
			record.put("userid", userid);
			record.put("picture", picture);
			record.put("addtime", addtime);
			record.put("content", content);
			
			record.put("newsid", newsid);
			
			
			//3、调用DAO
			NewsDAO newsDAO=new NewsDAO();
			int flag=newsDAO.update(record);
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='newsServlet?action=list';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='newsServlet?action=list';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
	    }
		
		
		//上传新闻封面
		public void upload(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			try {
				String curDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
						
				//临时文件的上传目录(获取到网站的根目录的绝对路径)
				String tempFileUploadDir2=this.getServletConfig().getServletContext().getRealPath("/")+"temp/"+curDate+"/";
				//文件的上传目录
				String fileUploadDir2=this.getServletConfig().getServletContext().getRealPath("/")+"file/"+curDate+"/";
						
				File tempFileUploadDir=new File(tempFileUploadDir2);
				File fileUploadDir=new File(fileUploadDir2);
				//如果临时目录不存在，则创建
				if(!tempFileUploadDir.exists()){
					tempFileUploadDir.mkdirs();
				}
				//如果上传目录不存在，则创建
				if(!fileUploadDir.exists()){
					fileUploadDir.mkdirs();
				}
						
						
				// 创建一个文件磁盘条目工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// 设置工厂的一些属性
				factory.setSizeThreshold(9999999);
				factory.setRepository(tempFileUploadDir);

				// 创建一个文件上传处理器
				ServletFileUpload upload = new ServletFileUpload(factory);

				//设置上传文件的最大值，比如，我们想限制文件大小不能超2M
				upload.setSizeMax(2048000);

				// 获取所有的上传数据（文件和表单字段）
				List items = upload.parseRequest(request);
				System.out.println("items size:"+items.size());
						
				//提示信息
				String message="";
						
				//将items转成迭代器
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
				//某一个表单数据
				 FileItem item = (FileItem) iter.next();
			                
				//如果不是表单数据（是文件数据）
				if(!item.isFormField()) {
				    //如果是IE6,这里得到的是要上传的文件的绝对路径，如d:\abc.txt
					//如果是IE8,这里得到的是要上传的文件的名字，如：abc.txt
					String filename=item.getName(); 
					System.out.println("filename:"+filename);
						       
					//取文件的后缀
				    String suffix=filename.substring(filename.lastIndexOf("."));
				    System.out.println("取出的文件后缀为："+suffix);
						       
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
					//新生成的文件名
					String newfilename=sdf.format(new Date())+suffix;
						       
				    //上传后文件绝对位置，如d:\file\20111110142556456.txt
				    String newposition=fileUploadDir2+newfilename;
					//将文件写入磁盘
					item.write(new File(newposition));
						       
					message="上传成功";
				    //把提示信息放入页面
				    request.setAttribute("message", message);
						       
					//上传后文件的相对路径
					String filepath="file/"+curDate+"/"+newfilename;
					//把上传后的文件相对路径放入页面
					request.setAttribute("filepath", filepath);
						       
					//跳转页面
					request.getRequestDispatcher("news/upload.jsp").forward(request, response);

						    } 
						}
	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
		
		
		//查看新闻详情
		public void newsDetail(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			//新闻的ID
			String newsid=request.getParameter("newsid");
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			Map<String,Object> record=newsDAO.get(Integer.parseInt(newsid));
			//把信息放入页面
			request.setAttribute("record", record);

			 //跳转页面		
			request.getRequestDispatcher("news/newsDetail.jsp").forward(request, response);
		}
		
		
		//管理人员查询新闻信息
		public void querynews(HttpServletRequest request, HttpServletResponse response)
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
			
			//条件
			String where=" ";
			
			//获取状态码
			String statuscode=request.getParameter("statuscode");		
			//如果提交了状态码
			if(statuscode!=null && !statuscode.equals("")){
				//状态
				String status="";
				if(statuscode.equals("0")){
					status="待审核";
					where=" and status='"+status+"' ";
				}else if(statuscode.equals("1")){
					status="审核通过";
					where=" and status='"+status+"' ";
				}else if(statuscode.equals("2")){
					status="审核未通过";
					where=" and status='"+status+"' ";
				}else{
					where=" ";
		            statuscode="";
				}
		
			}
			
			//排序
			String orderby="order by addtime asc";
			
			
			//调用DAO
			CheckDAO checkDAO=new CheckDAO();
			//查询出所有的产品
			QueryResult qr=checkDAO.listNewsWithWhere(startIndex, pageSize, where, orderby);
			
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
			//把状态码放入页面
			request.setAttribute("statuscode", statuscode);
			

	        //跳转页面		
			request.getRequestDispatcher("check/checkNews.jsp").forward(request, response);
			
		}
		
		//更新状态并进入新闻审核通过页面或未通过页面
		public void updatestatusandtojsp(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
			HttpSession session=request.getSession();
			Map<String,Object> admin=(Map<String,Object>)session.getAttribute("admin");
			
			CheckDAO checkDAO=new CheckDAO();
			
			//获取新闻编号
			int newsid=Integer.parseInt(request.getParameter("newsid"));

			String status="";
			//获取状态码
			String dowhat=request.getParameter("dowhat");

			//提示信息
			String message="";
			if(dowhat.equals("pass")){
			   status="审核通过";	
			   message="<script>alert('审核通过');window.location.href='newsServlet?action=checkpassjsp&newsid="+newsid+"';</script>";
			}else if(dowhat.equals("failed")){
			   status="审核未通过";
			   message="<script>alert('审核未通过');window.location.href='newsServlet?action=checkfailedjsp&newsid="+newsid+"';</script>";
			}else if(dowhat.equals("wait")){
				status="待审核";	
		}
			//执行更新方法
			checkDAO.updatestatus(status, newsid);
			
			//把信息放入页面
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("message.jsp").forward(request, response);
		
		}

		
		//进入新闻审核通过页面
		public void checkpassjsp(HttpServletRequest request, HttpServletResponse response)
		
		throws ServletException, IOException {

			//获取新闻编号
			String newsid=request.getParameter("newsid");
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			Map<String,Object> record=newsDAO.get(Integer.parseInt(newsid));
			//把信息放入页面
			request.setAttribute("record", record);
			
			//获取管理员信息
		    HttpSession session=request.getSession();
			Map<String,Object> admin=(Map<String,Object>)session.getAttribute("admin");
			
			//把信息放入页面
			request.setAttribute("records", admin);
			
			//跳转页面		
			request.getRequestDispatcher("check/checkpass.jsp").forward(request, response);
		}

		
		//保存新闻审核通过信息
		public void checkpass(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
			//1、获取数据
			String newsid=request.getParameter("newsid");
			String adminid=request.getParameter("adminid");
			//String time=request.getParameter("time");
			String status=request.getParameter("status");
			
			//2、组装数据
			Map<String,Object> record=new HashMap<String,Object>();
			record.put("newsid", newsid);
			record.put("adminid", adminid);
			record.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			record.put("status",status);

			
            //3、调用DAO
            CheckDAO checkDAO=new CheckDAO();
			int flag=checkDAO.addcheckpass(record);
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='newsServlet?action=querynews&statuscode=1';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='newsServlet?action=querynews&statuscode=0';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

	        //4、跳转页面		
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
		}
		

		//进入新闻审核未通过页面
		public void checkfailedjsp(HttpServletRequest request, HttpServletResponse response)
		
		throws ServletException, IOException {

			//获取新闻编号
			String newsid=request.getParameter("newsid");
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			Map<String,Object> record=newsDAO.get(Integer.parseInt(newsid));
			//把信息放入页面
			request.setAttribute("record", record);
			
			//获取管理员信息
		    HttpSession session=request.getSession();
			Map<String,Object> admin=(Map<String,Object>)session.getAttribute("admin");
			
			//把信息放入页面
			request.setAttribute("records", admin);
			
			//跳转页面		
			request.getRequestDispatcher("check/checkfailed.jsp").forward(request, response);
		}

		
		//保存新闻审核未通过信息
		public void checkfailed(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
			//1、获取数据
			String newsid=request.getParameter("newsid");
			String reason=request.getParameter("reason");
			String adminid=request.getParameter("adminid");
			String status=request.getParameter("status");
			System.out.println("648965181665498465894"+newsid+reason+adminid+status);
			//2、组装数据
			Map<String,Object> record=new HashMap<String,Object>();
			record.put("newsid", newsid);
			record.put("adminid", adminid);
			record.put("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			record.put("status",status);
			record.put("reason",reason);

			
            //3、调用DAO
            CheckDAO checkDAO=new CheckDAO();
			int flag=checkDAO.addcheckfailed(record);
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='newsServlet?action=querynews&statuscode=1';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='newsServlet?action=querynews&statuscode=0';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

	        //4、跳转页面		
			request.getRequestDispatcher("message.jsp").forward(request, response);
			
		}		
		
	
		
		//前台产品搜索列表
		public void afternewssearch(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	        
			//关键词
			String keyword=request.getParameter("keyword");
			System.out.println("496549846498dgaerger"+keyword);
			//分类ID
			String categoryid=request.getParameter("categoryid");
					
			//当前要看哪一页
			String currentPage=request.getParameter("currentPage");
			//如果没有输入页数，那就看第一页
			if(currentPage==null || currentPage.equals("")){
				currentPage="1";
			}
			
		    //过滤条件(where)
			String where=" ";
			
			if(keyword!=null && !keyword.equals("")){
				where+=" and a.title like '%"+keyword+"%'";
			}
			
			if(categoryid!=null && !categoryid.equals("")&& !categoryid.equals("0")){
				where+=" and a.categoryid="+categoryid;
			}
			
			
			String categoryname="搜索结果";
			
			//把当前分类的名字放入页面
			request.setAttribute("categoryname", categoryname);
			
			
			//排序方式（一开始给个默认值：按时间降序）
			String orderby=" order by a.addtime asc";			
					
			
			//页大小
			int pageSize=4;
			
			//计算从哪一条开始看		
			int startIndex=(Integer.parseInt(currentPage)-1)*pageSize;
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			//查询出所有的产品
			QueryResult qr=newsDAO.searchWithWhere(startIndex, pageSize, where, orderby);
			
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
			
			//把categoryid放入页面
			request.setAttribute("categoryid", categoryid);
			
			
			request.setAttribute("keyword", keyword);
	        //跳转页面		
			request.getRequestDispatcher("searchlist.jsp").forward(request, response);
			
	    }	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * 前台默认的获取
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		//前台新闻展示列表
		public void displayNews(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	        
			//分类的ID
			String categoryid=request.getParameter("categoryid");
					
			//当前要看哪一页
			String currentPage=request.getParameter("currentPage");
			//如果没有输入页数，那就看第一页
			if(currentPage==null || currentPage.equals("")){
				currentPage="1";
			}
			
			//过滤条件(where)
			String where=" ";
			
			String categoryname="全部新闻";
			
			if(categoryid!=null && !categoryid.equals("")){
				where=" and a.categoryid='"+categoryid+"' ";
				
				CategoryDAO categoryDAO=new CategoryDAO();
				Map<String,Object> temp=categoryDAO.get(Integer.parseInt(categoryid));
				categoryname=temp.get("name").toString();
			}
			
			//把当前分类的名字放入页面
			request.setAttribute("categoryname", categoryname);
			
			
			//排序方式（一开始给个默认值：按时间降序）
			String orderby="order by addtime asc";
					
			//按谁排序
			String orderfield=request.getParameter("orderfield");
			//如何排序
			String ordervalue=request.getParameter("ordervalue");
			
			if(orderfield!=null && !orderfield.equals("") && ordervalue!=null && !ordervalue.equals("")){
				orderby="order by "+orderfield+" "+ordervalue;
			}
					
			
			//页大小
			int pageSize=4;
			
			//计算从哪一条开始看		
			int startIndex=(Integer.parseInt(currentPage)-1)*pageSize;
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			//查询出所有的产品
			QueryResult qr=newsDAO.listWithOrderby(startIndex,pageSize,where,orderby);
			
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
			
			//把排序的值放入页面
			request.setAttribute("orderfield", orderfield);
			request.setAttribute("ordervalue", ordervalue);
			
			//把categoryid放入页面
			request.setAttribute("categoryid", categoryid);

	        //跳转页面		
			//转发的前台的首页
			request.getRequestDispatcher("/front/index.jsp").forward(request, response);
			
	    }
		
		
		/**
		 * 前台的获取
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		//显示某一产品的详细信息
		public void showDetail(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//获取产品的ID
			String newsid=request.getParameter("newsid");
							
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			//获取该ID的产品信息
			Map<String,Object> record=newsDAO.get(Integer.parseInt(newsid));

			//把信息放入页面
			request.setAttribute("record", record);	

	        //跳转页面		
			request.getRequestDispatcher("/front/newsdetail.jsp").forward(request, response);
			
	    }
		
		
		//对商品进行评论
		public void addcomment(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//1、获取数据
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			//产品ID
			String newsid=request.getParameter("newsid");
			
			HttpSession session=request.getSession();
			Map<String,Object> user=(Map<String,Object>)session.getAttribute("user");
			
			System.out.println("56489498496849"+title+content+newsid);
			
			//2、组装数据
			Map<String,Object> record=new HashMap<String,Object>();
			record.put("title", title);
			record.put("content", content);
			record.put("addtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			record.put("newsid", newsid);
			record.put("userid", user.get("userid"));

			
			//3、调用DAO
			CommentDAO commentDAO=new CommentDAO();
			int flag=commentDAO.add(record);
			String message="";
			if(flag>0){
				message="<script>alert('评论成功');window.location.href='newsServlet?action=showDetail&newsid="+newsid+"';</script>";
			}else{
				message="<script>alert('评论失败');window.location.href='newsServlet?action=showDetail&newsid="+newsid+"';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

	        //4、跳转页面		
			request.getRequestDispatcher("message.jsp").forward(request, response);

			
	    }		
		
		
		//会员查看自己的评论
		public void mycomment(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	        
			
			HttpSession session=request.getSession();
			Map<String,Object> user=(Map<String,Object>)session.getAttribute("user");
			
			//会员的ID
			String userid=user.get("userid").toString();
					
			//当前要看哪一页
			String currentPage=request.getParameter("currentPage");
			//如果没有输入页数，那就看第一页
			if(currentPage==null || currentPage.equals("")){
				currentPage="1";
			}
			
			//过滤条件(where)
			String where=" and a.userid='"+userid+"' ";
				
			//排序方式（一开始给个默认值：按时间降序）
			String orderby="order by a.addtime asc";

			//页大小
			int pageSize=2;
			
			//计算从哪一条开始看		
			int startIndex=(Integer.parseInt(currentPage)-1)*pageSize;
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			//查询出所有的产品
			QueryResult qr=newsDAO.listCommentsWithOrderby(startIndex,pageSize,where,orderby);
			
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
			//把页大小放入页面
			request.setAttribute("pageSize", pageSize);
			

	        //跳转页面		
			request.getRequestDispatcher("myComments.jsp").forward(request, response);
			
	    }		
		
		
		//评论删除
		public void delComment(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	           
			//删除讨论的ID
			String commentid=request.getParameter("commentid");
			
			//调用DAO
			CommentDAO commentDAO=new CommentDAO();
			int flag=commentDAO.del(Integer.parseInt(commentid));
			String message="";
			if(flag>0){
				message="<script>alert('操作成功');window.location.href='newsServlet?action=mycomment';</script>";
			}else{
				message="<script>alert('操作失败');window.location.href='newsServlet?action=mycomment';</script>";
			}
			//把信息放入页面
			request.setAttribute("message", message);

			request.getRequestDispatcher("message.jsp").forward(request, response);

			
	    }
		/***
		 * 前台首页的界面
		 * @param request
		 * @param response
		 * @throws ServletException
		 * @throws IOException
		 */
		
		//前台产品搜索列表
		public void search(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	        
			//关键词
			String keyword=request.getParameter("keyword");
			
			//分类ID
			//String categoryid=request.getParameter("categoryid");
					
			//当前要看哪一页
			String currentPage=request.getParameter("currentPage");
			//如果没有输入页数，那就看第一页
			if(currentPage==null || currentPage.equals("")){
				currentPage="1";
			}
			
		    //过滤条件(where)
			String where=" ";
			
			if(keyword!=null && !keyword.equals("")){
				where+=" and a.title like '%"+keyword+"%'";
			}
			
//			if(categoryid!=null && !categoryid.equals("")&& !categoryid.equals("0")){
//				where+=" and a.categoryid="+categoryid;
//			}
			
			
			String categoryname="搜索结果";
			
			//把当前分类的名字放入页面
			request.setAttribute("categoryname", categoryname);
			
			
			//排序方式（一开始给个默认值：按时间降序）
			String orderby=" order by a.addtime asc";			
					
			
			//页大小
			int pageSize=4;
			
			//计算从哪一条开始看		
			int startIndex=(Integer.parseInt(currentPage)-1)*pageSize;
			
			//调用DAO
			NewsDAO newsDAO=new NewsDAO();
			//查询出所有的产品
			QueryResult qr=newsDAO.searchWithWhere(startIndex, pageSize, where, orderby);
			
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
			
			//把categoryid放入页面
//			request.setAttribute("categoryid", categoryid);
			
			
			request.setAttribute("keyword", keyword);
	        //跳转页面		
			request.getRequestDispatcher("/front/index.jsp").forward(request, response);
			
	    }
		
		

}
