package class_.jdbcDemo03.com.cuiyq.test;

import class_.jdbcDemo03.com.cuiyq.dao.impl.UserDaoImpl;
import class_.jdbcDemo03.com.cuiyq.pojo.User;
import org.junit.Test;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class Test01 {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> allUser = userDao.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }

    }

    @Test
    public void test2() {
        UserDaoImpl userDao = new UserDaoImpl();
        User admin = userDao.getUserByUname("admin");
        System.out.println(admin);

    }
}
