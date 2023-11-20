package class_.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Cuiyq
 * @version 1.0
 * describe: 数据库连接
 */
public class TestConnection {
    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        String url = "jdbc:mysql://120.55.125.187:3306/java2301?charcterEncoding=UTF-8";
        String user = "root";
        String pwd = "Cyq20020107.";

//        连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("连接对象" + conn);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
