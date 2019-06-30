package com.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.util.ZqDBUtil;

//管理员DAO
public class AdminDAO {
	
	//验证用户是否存在
	public Map<String,Object> validate(String adminname,String password){
		       	
  	try {
          //获得连接
  		Connection cn=ZqDBUtil.getConn();
          //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			String sql="select * from admin where adminname='"+adminname+"' and password='"+password+"'";
			
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("执行的SQL："+sql);
			
			List<Map<String,Object>> records=ZqDBUtil.getHashMap(rs);
										
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
			return records.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	//更新admin表某些字段值
		public int update(Map<String,Object> record){
			//是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				
				String sql="update admin set ";
				
				if(record.get("password")!=null && !record.get("password").equals("")){
					sql+="password='"+record.get("password")+"',";
				}

				//去掉最后一个多余逗号，对字符串的每一次操作，都会产生一个新的字符串
				sql=sql.substring(0,sql.lastIndexOf(","));
				System.out.println("拼成的SQL："+sql);

				sql+="where adminid='"+record.get("adminid")+"'";
				flag=stmt.executeUpdate(sql);
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}
		
		
		
		
		
		
		
		
		
		
}
