package com.chinasoft.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
	private String username="root";
	private String password="123456";
	Connection conn=null;
	public PreparedStatement getConnect(String sql) throws Exception{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,username,password);
		PreparedStatement ps=conn.prepareStatement(sql);
		return ps;
	}
	
	public void closed(ResultSet rs,PreparedStatement ps) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
