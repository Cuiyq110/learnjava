//package class_.jdbcDemo02.com.tentact.dao;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.junit.Test;
//
//
///**
// * @author Cuiyq
// * @version 1.0
// * describe:
// */
//public class BaseDao {
//
//
////    获得连接
//
//    public Connection getConnection() throws Exception{
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("src\\mysql.properties"));
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        String driver = properties.getProperty("driver");
//        String url = properties.getProperty("url");
//        Class.forName(driver);
//        Connection connection = DriverManager.getConnection(url, user, password);
//        return connection;
//
//    }
//
////    关闭
//    public void closeAll(Connection conn, PreparedStatement pst, ResultSet rs)
//    {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//            if ( pst != null) {
//                pst.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 通用的查询操作
//     * @param sql
//     * @param obj
//     * @return
//     */
//
//    public ResultSet executeQuery(String sql,Object...obj) throws Exception {
//        //获得连接
//        Connection conn = this.getConnection();
//        PreparedStatement pst=null;
//        ResultSet rs = null;
//        try {
//            pst = conn.prepareStatement(sql);
//            if(obj != null) {
//                for (int i = 0; i < obj.length; i++) {
//                    pst.setObject(i+1, obj[i]);
//                }
//            }
//            rs = pst.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    /**
//     * 增删改的
//     * @param sql
//     * @param obj
//     * @return
//     */
//
//    public int executeUpdate(String sql,Object...obj) throws Exception {
//        //获得连接
//        Connection conn = this.getConnection();
//        PreparedStatement pst = null;
//        int num=-1;
//        try {
//            pst = conn.prepareStatement(sql);
//            if(obj != null) {
//                for (int i = 0; i < obj.length; i++) {
//                    pst.setObject(i+1, obj[i]);
//                }
//            }
//            num = pst.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        } finally {
//            this.closeAll(conn, pst, null);
//        }
//        return num;
//
//    }
//    @Test
//    public void ff() throws IOException {
//        Connection conn=null;
//
//        Properties pst = new Properties();
//        pst.load(new FileInputStream("src\\mysql.properties"));
//        String user = pst.getProperty("user");
//        String password = pst.getProperty("password");
//        String driver = properties.getProperty("driver");
//        String url = properties.getProperty("url");
//
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, user, password);
//            String sql="insert into subject(subjectName,classHour,point) values(?,?,?)";
//            pst =conn.prepareStatement(sql);
//            pst.setString(1, "测试的科目");
//            pst.setInt(2, 20);
//            pst.setDouble(3, 3.5);
//            //执行sql
//            int num=pst.executeUpdate();
//            if(num>0) {
//                System.out.println("新增成功");
//            }
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SQLException e) {
//            e.printStackTrace();
//
//        }finally {
//            try {
//                if(pst != null)
//                    pst.close();
//                if(conn != null)
//                    conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    @Test
//    public void ff1() {
//        Connection conn=null;
//        PreparedStatement pst=null;
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, user, password);
//            String sql="update subject set subjectName=?,classHour=?,point=? where subjectNo=?";
//            pst=conn.prepareStatement(sql);
//            pst.setString(1, "新科目名称");
//            pst.setInt(2, 30);
//            pst.setDouble(3,4);
//            pst.setInt(4, 10);
//            //执行sql
//            int num=pst.executeUpdate();
//            if(num>0) {
//                System.out.println("操作成功");
//            }
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SQLException e) {
//            e.printStackTrace();
//
//        }finally {
//            try {
//                if(pst != null)
//                    pst.close();
//                if(conn != null)
//                    conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    @Test
//    public void ff2() {
//        Connection conn=null;
//        PreparedStatement pst=null;
//        try {
//
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, user, password);
//            String sql="delete from subject where subjectNo=?";
//            pst=conn.prepareStatement(sql);
//            pst.setInt(1, 10);
//            //执行sql
//            int num=pst.executeUpdate();
//            if(num>0) {
//                System.out.println("操作成功");
//            }
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (SQLException e) {
//            e.printStackTrace();
//
//        }finally {
//            try {
//                if(pst != null)
//                    pst.close();
//                if(conn != null)
//                    conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
