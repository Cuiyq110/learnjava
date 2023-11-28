package class_.jdbcDemo03.com.cuiyq.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




@SuppressWarnings("all")
public class BaseDao {
	
	private static final String  url = "jdbc:mysql://120.55.125.187:3306/java2301";
	private static final String user = "root";
	private static final String password = "Cyq20020107.";
	private static final String driver = "com.mysql.jdbc.Driver";
	
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
	
	public ResultSet executeQuery(String sql,Object...obj) {
		//获得连接
		Connection conn = this.getConnection();
		PreparedStatement pst=null;
		ResultSet rs = null;
		try {
			 pst = conn.prepareStatement(sql);
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

	public int executeUpdate(String sql,Object...obj) {
		//获得连接
		Connection conn = this.getConnection();
		PreparedStatement pst = null;
		int num=-1;
		try {
			pst = conn.prepareStatement(sql);
			if(obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i+1, obj[i]);
				}
			}
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			this.closeAll(conn, pst, null);
		}
		return num;
		
	}

	@Test
	public void ff() {
		Connection conn=null;
		PreparedStatement pst=null;
		try {
//			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			String sql="insert into subject(subjectName,classhour,point) values(?,?,?)";
			pst =conn.prepareStatement(sql);
			pst.setString(1, "测试的科目");
			pst.setInt(2, 20);
			pst.setDouble(3, 3.5);
			//执行sql
			int num=pst.executeUpdate();
			if(num>0) {
				System.out.println("新增成功");
			}
		}catch (Exception e) {
			e.printStackTrace();


			e.printStackTrace();

		}finally {
			try {
				if(pst != null)
					pst.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
