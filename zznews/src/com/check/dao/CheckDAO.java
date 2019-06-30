package com.check.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.util.QueryResult;
import com.util.ZqDBUtil;

public class CheckDAO {
	
	//根据状态查询新闻列表
		public QueryResult listNewsWithWhere(int startIndex,int pageSize,String where,String orderby){
			ResultSet rs=null;
			
			List<Map<String,Object>> records=null;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				String sql="select a.*,b.username from news a,user b where a.userid=b.userid"+where+orderby+" limit "+startIndex+","+pageSize;
				System.out.println("执行的SQL："+sql);
				
				rs=stmt.executeQuery(sql);
				
				records=ZqDBUtil.getHashMap(rs);
				
				//查询总记录数		
				String sql2="select a.*,b.username from news a,user b where a.userid=b.userid"+where+orderby+" limit "+startIndex+","+pageSize;
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

		
		
		//添加添加新闻审核成功信息到checkpass表
		public int addcheckpass(Map<String,Object> record){
			//添加是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
			    flag=stmt.executeUpdate("insert into checkpass(newsid,adminid,time,status) values('"+record.get("newsid")+"','"+record.get("adminid")+"','"+record.get("time")+"','"+record.get("status")+"')");

				//关闭连接
				ZqDBUtil.close(cn, stmt, null);

	            return flag;
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
		//添加添加新闻审核成功信息到checkfailed表
		public int addcheckfailed(Map<String,Object> record){
			//添加是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
			    flag=stmt.executeUpdate("insert into checkfailed(newsid,adminid,time,status,reason) values('"+record.get("newsid")+"','"+record.get("adminid")+"','"+record.get("time")+"','"+record.get("reason")+"','"+record.get("status")+"')");

				//关闭连接
				ZqDBUtil.close(cn, stmt, null);

	            return flag;
	            
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		 
		//更新新闻状态
		public int updatestatus(String status,int newsid){
			//是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				flag=stmt.executeUpdate("update news set status='"+status+"' where newsid='"+newsid+"'");
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return flag;
		}


	

		
		
		
		
		
		
}






