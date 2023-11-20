package class_.jdbcdemo;

import java.sql.*;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class QueryDemo {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null; //发送sql对象
        ResultSet rs = null;//结果集对象
        String url = "jdbc:mysql://120.55.125.187:3306/java2301?charcterEncoding=UTF-8";
        String user = "root";
        String pwd = "Cyq20020107.";

//        连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("连接对象" + conn);
            System.out.println("连接成功");
            String sql = "select nationNo,nationName FROM nation";
            pst = conn.prepareStatement(sql);

//            执行sql语句
            System.out.println("执行sql语句");
            rs = pst.executeQuery();
            System.out.println("执行成功");
//            处理结果集
            if (rs != null) {
                System.out.println("编号  名称");
                while (rs.next()) {
                    System.out.println(rs.getInt("nationNo") + "    " + rs.getString("nationName"));
                }
            }

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
