package class_.jdbcDemo03.com.cuiyq.service;

import class_.jdbcDemo03.com.cuiyq.pojo.User;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public interface UserService {

    List<User> getAllUser();
    User getUserByUname(String name);
    User getUser(String uname,String upwd);

    int insert(User user);
    int editUser(User user);
    int deleteUser(int id);
    int login(String uname,String upwd);
}
