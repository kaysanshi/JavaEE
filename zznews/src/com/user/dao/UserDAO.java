package com.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.util.ZqDBUtil;

public class UserDAO {

	//验证用户是否存在
	public Map<String,Object> validateUser(String username,String password){
		       
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			String sql="select * from user where username='"+username+"' and password='"+password+"'";
			
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
	
	//更新会员表某些字段值
	public int update(Map<String,Object> record){
		//是否成功
		int flag=-1;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			
			String sql="update user set ";
			
			if(record.get("password")!=null && !record.get("password").equals("")){
				sql+="password='"+record.get("password")+"',";
			}
			
			if(record.get("sex")!=null && !record.get("sex").equals("")){
				sql+="sex='"+record.get("sex")+"',";
			}
			
			if(record.get("phone")!=null && !record.get("phone").equals("")){
				sql+="phone='"+record.get("phone")+"',";
			}
			
			if(record.get("question")!=null && !record.get("question").equals("")){
				sql+="question='"+record.get("question")+"',";
			}
			
			if(record.get("answer")!=null && !record.get("answer").equals("")){
				sql+="answer='"+record.get("answer")+"',";
			}
			
			if(record.get("lasttime")!=null && !record.get("lasttime").equals("")){
				sql+="lasttime='"+record.get("lasttime")+"',";
			}

			//去掉最后一个多余逗号，对字符串的每一次操作，都会产生一个新的字符串
			sql=sql.substring(0,sql.lastIndexOf(","));
			System.out.println("拼成的SQL："+sql);

			sql+="where userid='"+record.get("userid")+"'";

			flag=stmt.executeUpdate(sql);
			
			//关闭连接
			ZqDBUtil.close(cn, stmt, null);
			
            return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	//根据用户名查询用户
	public Map<String,Object> getByusername(String username){
		
		
		ResultSet rs=null;
		List<Map<String,Object>> records=null;
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			rs=stmt.executeQuery("select * from user where username='"+username+"'");
			records=ZqDBUtil.getHashMap(rs);					
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
			if(records.size()>0){
				return records.get(0);
			}else{
				return null;
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	//添加会员
	public int add(Map<String,Object> record){
		//添加是否成功
		int flag=-1;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			flag=stmt.executeUpdate("insert into user(username,password,sex,phone,question,answer,lasttime) values('"+record.get("username")+"','"+record.get("password")+"','"+record.get("sex")+"','"+record.get("phone")+"','"+record.get("question")+"','"+record.get("answer")+"','"+record.get("lasttime")+"')");
			
			//关闭连接
			ZqDBUtil.close(cn, stmt, null);
			
            return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	//验证答案是否正确
	public Map<String,Object> validateAnswer(String username,String question,String answer){
		
		
		ResultSet rs=null;
		List<Map<String,Object>> records=null;
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			rs=stmt.executeQuery("select * from user where username='"+username+"' and question='"+question+"' and answer='"+answer+"'");
			records=ZqDBUtil.getHashMap(rs);					
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
            return records.get(0);
            
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	

	//查询单条
	public Map<String,Object> get(int userid){
		ResultSet rs=null;
		List<Map<String,Object>> records=null;
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			rs=stmt.executeQuery("select * from user where userid='"+userid+"'");
			records=ZqDBUtil.getHashMap(rs);					
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
            return records.get(0);
            
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}	
	
	
}
