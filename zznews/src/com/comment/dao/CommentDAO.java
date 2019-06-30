package com.comment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.util.QueryResult;
import com.util.ZqDBUtil;

//新闻评论DAO
public class CommentDAO {
	//添加评论
	public int add(Map<String,Object> record){
		//添加是否成功
		int flag=-1;
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			flag=stmt.executeUpdate("insert into comment(title,content,addtime,newsid,userid) values('"+record.get("title")+"','"+record.get("content")+"','"+record.get("addtime")+"','"+record.get("newsid")+"','"+record.get("userid")+"')");
			
			//关闭连接
			ZqDBUtil.close(cn, stmt, null);
			
            return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	
	//查询某一产品的所有评论
	public List<Map<String,Object>> getCommentsByProductid(int newsid){
		ResultSet rs=null;
		
		List<Map<String,Object>> records=null;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			String sql="select a.title,a.content,a.addtime,b.username from comment a,user b where a.userid=b.userid and a.newsid='"+newsid+"'";
			
			rs=stmt.executeQuery(sql);
			System.out.println("执行的SQL："+sql);
			
			records=ZqDBUtil.getHashMap(rs);
		
			//关闭连接
			ZqDBUtil.close(cn, stmt, rs);
			
			return records;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//删除
	public int del(int commentid){
		//删除是否成功
		int flag=-1;
		
    	try {
            //获得连接
    		Connection cn=ZqDBUtil.getConn();
            //发送SQL语句
			Statement stmt=cn.createStatement();
			//下面这么写会存在SQL注入问题（不安全）
			flag=stmt.executeUpdate("delete from comment where commentid='"+commentid+"'");
			
			//关闭连接
			ZqDBUtil.close(cn, stmt, null);
			
            return flag;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
}
