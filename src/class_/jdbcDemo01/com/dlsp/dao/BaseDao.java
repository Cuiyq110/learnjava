package com.dlsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("all")
public class BaseDao {

	String url = "jdbc:mysql://120.55.125.187:3306/java2301?seUnicode=truue&characterEncoding=utf-8";
	private String user = "root";
	private String password = "Cyq20020107.";
	private String driver = "com.mysql.jdbc.Driver";
	
	//连接数据库
	public Connection getConnection() {
		Connection conn = null;
		//加载驱动
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭数据库的操作
	public void closeAll(Connection conn,PreparedStatement pst,ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 通用的查询操作
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet query(String sql,Object...obj) {
		//获得连接
		Connection conn = this.getConnection();
		ResultSet rs = null;
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			if(obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i+1, obj[i]);
				}
			}
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 增删改的
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int update(String sql,Object...obj) {
		//获得连接
		Connection conn = this.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			if(obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i+1, obj[i]);
				}
			}
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			this.closeAll(conn, pst, null);
		}
		
		
	}


}
