package com.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.util.QueryResult;
import com.util.ZqDBUtil;

public class NewsDAO {
	
	
	//添加新闻
		public int add(Map<String,Object> record){
			//添加是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				flag=stmt.executeUpdate("insert into news(title,categoryid,userid,picture,addtime,content,status) values('"+record.get("title")+"','"+record.get("categoryid")+"','"+record.get("userid")+"','"+record.get("picture")+"','"+record.get("addtime")+"','"+record.get("content")+"','"+record.get("status")+"')");
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return flag;
		}
		
		
		//查询所有新闻
		public QueryResult list(int startIndex,int pageSize){
			ResultSet rs=null;
			
			List<Map<String,Object>> records=null;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				String sql="select a.newsid,a.title title,a.picture,a.addtime,a.status,a.userid,a.categoryid,b.name categoryname from news a,category b where a.categoryid=b.categoryid order by addtime asc limit "+startIndex+","+pageSize;
				
				rs=stmt.executeQuery(sql);
				System.out.println("执行的SQL："+sql);
				
				records=ZqDBUtil.getHashMap(rs);
					
				//查询总记录数		
				String sql2="select count(*) from news a,category b where a.categoryid=b.categoryid";
				rs=stmt.executeQuery(sql2);
				
				//记录总数
				int totalCount=0;
				//移动指针，指向第一条
				if(rs.next()){
					//获取第一列数据
					totalCount=rs.getInt(1);
					
				}
				System.out.println("记录总数为："+totalCount);
				
				//将数据和记录数送给QueryResult			
				QueryResult qr=new QueryResult();
				qr.setRecords(records);
				qr.setTotalCount(totalCount);
						
				//关闭连接
				ZqDBUtil.close(cn, stmt, rs);
				
				return qr;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return null;
		}



//删除新闻
	public int del(int newsid){
		//删除是否成功
		int flag=-1;
		
  	try {
          //获得连接
  		Connection cn=ZqDBUtil.getConn();
          //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			flag=stmt.executeUpdate("delete from news where newsid='"+newsid+"'");
			
			//关闭连接
			ZqDBUtil.close(cn, stmt, null);
			
          return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	
	//查询单条产品
		public Map<String,Object> get(int newsid){
			
			
			ResultSet rs=null;
			List<Map<String,Object>> records=null;
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				rs=stmt.executeQuery("select * from news where newsid='"+newsid+"'");
				records=ZqDBUtil.getHashMap(rs);					
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return records.get(0);
	            
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
	
	//修改新闻
	public int update(Map<String,Object> record){
		//是否成功
		int flag=-1;
		
		try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			flag=stmt.executeUpdate("update news set title='"+record.get("title")+"',categoryid='"+record.get("categoryid")+"',userid='"+record.get("userid")+"',picture='"+record.get("picture")+"',addtime='"+record.get("addtime")+"',content='"+record.get("content")+"' where newsid='"+record.get("newsid")+"'");
			
			//关闭连接
			ZqDBUtil.close(cn, stmt, null);
			
            return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	//查询所有产品（带动态排序）
	public QueryResult listWithOrderby(int startIndex,int pageSize,String where,String orderby){
		ResultSet rs=null;
		
		List<Map<String,Object>> records=null;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			String sql="select a.newsid,a. title,a.picture,a.addtime,a.categoryid,a.userid ,a.status, b.name from news a,category b where a.categoryid=b.categoryid"+where+orderby+" limit "+startIndex+","+pageSize;
			System.out.println("执行的SQL："+sql);
			
			rs=stmt.executeQuery(sql);
			
			
			records=ZqDBUtil.getHashMap(rs);
			
			
			//查询总记录数		
			String sql2="select count(*) from news a,category b where a.categoryid=b.categoryid"+where;
			rs=stmt.executeQuery(sql2);
			
			//记录总数
			int totalCount=0;
			//移动指针，指向第一条
			if(rs.next()){
				//获取第一列数据
				totalCount=rs.getInt(1);
				
			}
			System.out.println("记录总数为："+totalCount);
			
			//将数据和记录数送给QueryResult			
			QueryResult qr=new QueryResult();
			qr.setRecords(records);
			qr.setTotalCount(totalCount);
					
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
			return qr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
			

	//查询新闻的评论
	public QueryResult listCommentsWithOrderby(int startIndex,int pageSize,String where,String orderby){
		ResultSet rs=null;
		
		List<Map<String,Object>> records=null;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）		
			String sql="select a.*,b.title newstitle from comment a,news b where a.newsid=b.newsid"+where+orderby+" limit "+startIndex+","+pageSize;
			System.out.println("执行的SQL："+sql);
			
			rs=stmt.executeQuery(sql);
			records=ZqDBUtil.getHashMap(rs);
			//查询总记录数		
			String sql2="select count(*) from comment a,news b where a.newsid=b.newsid"+where;
			rs=stmt.executeQuery(sql2);
			
			//记录总数
			int totalCount=0;
			//移动指针，指向第一条
			if(rs.next()){
				//获取第一列数据
				totalCount=rs.getInt(1);
				
			}
			System.out.println("记录总数为："+totalCount);
			
			//将数据和记录数送给QueryResult			
			QueryResult qr=new QueryResult();
			qr.setRecords(records);
			qr.setTotalCount(totalCount);
					
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
			return qr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//搜索新闻查询
	public QueryResult searchWithWhere(int startIndex,int pageSize,String where,String orderby){
		ResultSet rs=null;
		
		List<Map<String,Object>> records=null;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
						
			String sql="select a.newsid,a.categoryid,a.title,a.picture,b.name categoryname from news a,category b";
			   
			
		    sql+=" where a.categoryid=b.categoryid"+where+orderby+" limit "+startIndex+","+pageSize;
			
			
			System.out.println("执行的SQL："+sql);
						
			rs=stmt.executeQuery(sql);
			
			
			records=ZqDBUtil.getHashMap(rs);
			
			System.out.println("-----------");
			
			//查询总记录数					
			String sql2="select count(*) from news a,category b";
			   			    
			sql2+=" where a.categoryid=b.categoryid"+where;
			
			
			rs=stmt.executeQuery(sql2);
			
			//记录总数
			int totalCount=0;
			//移动指针，指向第一条
			if(rs.next()){
				//获取第一列数据
				totalCount=rs.getInt(1);
				
			}
			System.out.println("记录总数为："+totalCount);
			
			//将数据和记录数送给QueryResult			
			QueryResult qr=new QueryResult();
			qr.setRecords(records);
			qr.setTotalCount(totalCount);
					
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
			return qr;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}	
	
	
	 
	
}






