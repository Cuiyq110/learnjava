package class_.jdbcDemo03.com.cuiyq.service.impl;

import class_.jdbcDemo03.com.cuiyq.dao.UserDao;
import class_.jdbcDemo03.com.cuiyq.dao.impl.UserDaoImpl;
import class_.jdbcDemo03.com.cuiyq.pojo.User;
import class_.jdbcDemo03.com.cuiyq.service.UserService;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class UserServiceImpl  implements UserService {
    private UserDao dao = new UserDaoImpl();

    public UserServiceImpl(UserDao dao) {

    }

    public UserServiceImpl() {
        dao = new UserDaoImpl();
    }
    @Override
    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    @Override
    public User getUserByUname(String name) {
        return dao.getUserByUname(name);
    }

    @Override
    public User getUser(String uname, String upwd) {
        return dao.getUser(uname,upwd);
    }

    @Override
    public int insert(User user) {
        return dao.addUser(user);
    }

    @Override
    public int editUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return dao.deleteUser(id);
    }

    @Override
    public int login(String uname, String upwd) {
//        登录成功 1 用户名不存在-1 密码错误-2
        User user= dao.getUserByUname(uname);
        if (user == null) {
            return 0;
        }
        if (user.getUpwd().equals(upwd)) {
            return 1;
        } else {
            return 2;
        }
    }

}
