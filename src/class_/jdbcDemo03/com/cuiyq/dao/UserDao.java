package class_.jdbcDemo03.com.cuiyq.dao;

import class_.jdbcDemo03.com.cuiyq.pojo.User;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public interface UserDao {

    List <User> getAllUser();
    User getUserByUname(String name);
    User getUser(String uname,String upwd);

    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);

}
