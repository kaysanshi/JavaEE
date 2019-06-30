package com.leo.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 数据库连接
 * @author leoi555
 *
 */
public class LoginAction extends ActionSupport {
	
	private String user;
	private String password;
	private String name;
	@Override
	public String execute() throws Exception {
		
		// TODO Auto-generated method stub
		String url="jdbc:mysql//localhost/struts";
		String  ret = "error";
	    Connection conn = null;
	    
	    try {
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(url, "root", "123");
	    String sql = "SELECT name FROM login WHERE";
        sql+=" user = ? AND password = ?";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	           name = rs.getString(1);
	           ret = "success";
	        }
	    } catch (Exception e) {
	        ret = "error";
	    } finally {
	        if (conn != null) {
	           try {
	              conn.close();
	           } catch (Exception e) {
	           }
	        }
     }
		return ret;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
