package com.category.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.util.QueryResult;
import com.util.ZqDBUtil;


public class CategoryDAO {
	
	//添加分类
		public int add(Map<String,Object> record){
			//添加是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				flag=stmt.executeUpdate("insert into category(name,sort) values('"+record.get("name")+"','"+record.get("sort")+"')");
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			return flag;
		}
		
		//分类列表
		public QueryResult list(int startIndex,int pageSize){
			ResultSet rs1=null;
			
			List<Map<String,Object>> records=null;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				String sql="select * from category order by sort asc limit "+startIndex+","+pageSize;
				
				rs1=stmt.executeQuery(sql);
				System.out.println("执行的SQL："+sql);
				
				records=ZqDBUtil.getHashMap(rs1);
				
				
				//查询总记录数		
				String sql2="select count(*) from category ";
				rs1=stmt.executeQuery(sql2);
				
				//记录总数
				int totalCount=0;
				//移动指针，指向第一条
				if(rs1.next()){
					//获取第一列数据
					totalCount=rs1.getInt(1);
					
				}
				System.out.println("记录总数为："+totalCount);
				
				//将数据和记录数送给QueryResult			
				QueryResult qr=new QueryResult();
				qr.setRecords(records);
				qr.setTotalCount(totalCount);
						
				//关闭连接
				ZqDBUtil.close(cn, stmt, rs1);
				
				return qr;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return null;
		}
		
		
		//查询所有分类
		public List<Map<String,Object>> list(){
			ResultSet rs=null;
			
			List<Map<String,Object>> records=null;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				rs=stmt.executeQuery("select * from category order by sort asc");
				
				records=ZqDBUtil.getHashMap(rs);
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, rs);
				
				return records;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return records;
		}
		
		
		//查询单个分类
		public Map<String,Object> get(int categoryid){
			
			
			ResultSet rs=null;
			List<Map<String,Object>> records=null;
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				rs=stmt.executeQuery("select * from category where categoryid='"+categoryid+"'");
				records=ZqDBUtil.getHashMap(rs);					
				//关闭连接
				ZqDBUtil.close(cn, stmt, rs);
				
	            return records.get(0);
	            
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
		
		
		//删除分类
		public int del(int categoryid){
			//删除是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				flag=stmt.executeUpdate("delete from category where categoryid='"+categoryid+"'");
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return flag;
		}
		
		//修改分类
		public int update(Map<String,Object> record){
			//是否成功
			int flag=-1;
			
	    	try {
	            //获得连接
	    		Connection cn=ZqDBUtil.getConn();
	            //发送SQL语句
				Statement stmt=cn.createStatement();
				//下面这么写会存在SQL注入问题（不安全）
				flag=stmt.executeUpdate("update category set name='"+record.get("name")+"',sort='"+record.get("sort")+"' where categoryid='"+record.get("categoryid")+"'");
				
				//关闭连接
				ZqDBUtil.close(cn, stmt, null);
				
	            return flag;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return flag;
		}
	}
