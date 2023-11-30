package class_.jdbcDemo03.com.cuiyq.view;

import class_.jdbcDemo03.com.cuiyq.service.UserService;
import class_.jdbcDemo03.com.cuiyq.service.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
@SuppressWarnings("all")
public class LoginPage {
    //    页面 只能调用Service
    private UserService userService = new UserServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("这是用户管理页面");
    }
    public void denglu() {
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String uname = scanner.next();
            System.out.println("请输入密码");
            String upwd = scanner.next();
            int num = userService.login(uname, upwd);
            if (num == 1) {
                System.out.println("登录成功");
                this.menu();
                break;
            }
            if (num == 0) {
                System.out.println("用户名不存在,你还有"+ (2-i) + "次机会");
            }
            if (num == 2) {
                System.out.println("密码错误,你还有" + (2 - i) + "次机会");
            }
            if (i == 2) {
                System.out.println("三次输入密码错误,请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage().denglu();
    }
}
