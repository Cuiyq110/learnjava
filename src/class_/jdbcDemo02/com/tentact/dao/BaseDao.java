package class_.jdbcDemo02.com.tentact.dao;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class BaseDao {
//    获得连接

    public Connection getConnection() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;

    }

//    关闭
    public void closeAll(Connection conn, PreparedStatement pst, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
            if ( pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    查询
    public ResultSet executeQuery(String s) {

        return null;
    }
}
