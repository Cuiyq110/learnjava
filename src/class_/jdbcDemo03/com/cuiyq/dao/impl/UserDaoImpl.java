package class_.jdbcDemo03.com.cuiyq.dao.impl;

import class_.day17.demo03.Passenger;
import class_.jdbcDemo03.com.cuiyq.dao.BaseDao;
import class_.jdbcDemo03.com.cuiyq.dao.UserDao;
import class_.jdbcDemo03.com.cuiyq.pojo.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class UserDaoImpl extends BaseDao implements UserDao {
    public static void main(String[] args) {
        new UserDaoImpl().getAllUser();
    }
    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<User>();
        String sql = "select id,uname,upwd from user";
        ResultSet resultSet = super.executeQuery(sql, null);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    User user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                    list.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                super.closeAll(null, null, resultSet);
            }
        }
        return list;
    }

    @Override
    public User getUserByUname(String name) {
        User user = null;
        String sql = "select id,uname,upwd from user where uname = ?";
        Object[]  obj = {name};

        ResultSet resultSet = super.executeQuery(sql, obj);

        if (resultSet != null) {
            try {
                if (resultSet.next()) {
                 user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                super.closeAll(null,null,resultSet);
            }
        }
        return user;
     }

    @Override
    public User getUser(String uname, String upwd) {
        User user = null;
        String sql = "select id,uname,upwd from user where uname = ? and upwd = ?";
        Object[]  obj = {uname,upwd};
        ResultSet resultSet = super.executeQuery(sql, obj);
        if (resultSet != null) {
            try {
                user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                super.closeAll(null,null,resultSet);
            }
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(uname,upwd) values(?,?)";
        Object object[] = {user.getUname(),user.getUpwd()};
        return super.executeUpdate(sql,object);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set uname = ? where id = ?";
        Object object[] = {user.getUpwd()};
        return super.executeUpdate(sql,object);
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id = ?";
        return super.executeUpdate(sql,id);
    }
}
