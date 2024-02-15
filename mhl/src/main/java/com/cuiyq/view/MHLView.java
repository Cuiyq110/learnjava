

import com.cuiyq.domain.Bill;
import com.cuiyq.domain.DingingTable;
import com.cuiyq.domain.Menu;
import com.cuiyq.domain.MultiTableBean;


import com.cuiyq.utils.Utility;
import main.java.com.cuiyq.service.BillService;
import main.java.com.cuiyq.service.DingingTableService;
import main.java.com.cuiyq.service.EmployeeService;
import main.java.com.cuiyq.service.MenuService;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：mhl主页面
 */
@SuppressWarnings("all")
public class MHLView {

    private Boolean loop = true; //控制是否退出菜单
    private String key = "";//接收用户选择

    private EmployeeService employeeService = new EmployeeService();
    private DingingTableService dingingTableService = new DingingTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

//    结账
    public void payBill(){
        System.out.println("==================结账================");
        System.out.print("请输入要结账的餐桌编号(-1退出):");
        int dingTableId = Utility.readInt();
        if (dingTableId == -1) {
            System.out.println("已退出~");
            return;
        }

//      判断该餐桌是否未结账
        if (!billService.hasPayBillByTableId(dingTableId)) {
            System.out.println("该桌没有未结账的账单~");
            return;
        }

//      餐桌号不存在就退出去
        if (dingingTableService.getDingTableById(dingTableId) == null) {
            System.out.println("该桌号不存在~");
            return;
        }
        System.out.print("结账的方式(现金/支付宝/微信) 回车退出:");
        String payWay = Utility.readString(20,"");
        if ("".equals(payWay)) {
            System.out.println("已退出~");
            return;
        }
        System.out.print("确认是否结账(Y/N):");
        char key = Utility.readConfirmSelection();
        if (key == 'N') {
            System.out.println("取消结账~");
            return;
        }
//        进行结账操作
        if (billService.payBill(dingTableId,payWay)) {
            System.out.println("结账成功~");
        } else {
            System.out.println("结账失败~");
        }

    }

//    取消预定
    public void cancelOrder(){

        System.out.println("==================取消预定================");
        System.out.print("请输入要取消的桌号(-1取消)：");
        int dingTableId = Utility.readInt();

        if (dingTableId == -1) {
            System.out.println("已取消~");
            return;
        }
//        如果餐桌号不存在就退出去
         if (dingingTableService.getDingTableById(dingTableId) == null) {
             System.out.println("该桌号不存在~");
             return;
         }

        DingingTable dingingTable = dingingTableService.getDingTableById(dingTableId);
//        如果是已预定就改为空
        if (!("已预定".equals(dingingTable.getStatus()))) {
            System.out.println("该桌号不是已预定状态~");
            return;
        }

        if (dingingTableService.cancelOrderById(dingTableId)) {
            System.out.println("取消成功~");
        } else {
            System.out.println("取消失败");
        }
    }

    //    查看账单
    public void billList() {
//        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t状态");
//        List<Bill> list = billService.list();
//        for (Bill bill : list) {
//            System.out.println(bill);
//        }

        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t状态\t\t菜品名\t\t价格");
        List<MultiTableBean> multiTableBeans = billService.listMulti();
        for (MultiTableBean multiTableBean : multiTableBeans) {
            System.out.println(multiTableBean);
        }

    }

    //    点餐
    public void orderMenu() {
        System.out.println("==================点餐服务================");
        System.out.print("请选择要点餐的餐桌编号(-1退出):");
        int dingTableId = Utility.readInt();
        if (dingTableId == -1) {
            System.out.println("已退出~");
            return;
        }
//        如果餐桌号不存在就退出
        DingingTable dingTableById = dingingTableService.getDingTableById(dingTableId);
        if (dingTableById == null) {
            System.out.println("该餐桌不存在~");
            return;
        }

        System.out.print("请选择要菜品编号(-1退出):");
        int menuId = Utility.readInt();
        if (menuId == -1) {
            System.out.println("已退出~");
            return;
        }
        Menu menuById = menuService.getMenuById(menuId);
        if (menuById == null) {
            System.out.println("该菜品不存在~");
            return;
        }

        System.out.print("请输入菜品数量(-1退出):");
        int menuNum = Utility.readInt();
        if (menuNum == -1) {
            System.out.println("已退出~");
            return;
        }

        /*点餐需要生成对应的账单，更改餐桌状态*/
        if (billService.orderMenu(menuId, menuNum, dingTableId)) {
            System.out.println("点餐成功~");
        } else {
            System.out.println("点餐失败~");
        }
    }

    //    显示所有菜品
    public void listMenu() {
        System.out.println("菜品编号\t\t 菜品名\t\t 类别\t\t 价格");
        List<Menu> list = menuService.list();
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }

    //    预定餐桌
    public void oderDingTable() {
        boolean loop = true; //控制预定
        int DingTableId = 0;
        while (loop) {
            System.out.println("==============预定餐桌==========");
            System.out.print("请选择要预定餐桌的编号(-1退出):");
            DingTableId = Utility.readInt(3);
            if (DingTableId == -1) {
                System.out.println("已退出~");
                return;
            }

            /**
             * 判断餐桌状态，如果餐桌号不存在无法预定
             * 如果餐桌号存在，判断是否已经预定或就餐中，如果已经预定或就餐中，也无法进行预定操作
             *
             */
//            获取餐桌对象
            DingingTable dingingTable = dingingTableService.getDingTableById(DingTableId);
            //判断餐桌号是否存在并且是否处于空状态
            if (dingingTable != null && "空".equals(dingingTable.getStatus())) { //不等于空就跳出去
//                找到空餐桌，准备接受用户确认
                break;
            } else if (dingingTable == null) {
                System.out.println("餐桌号不存在");
            } else {
                System.out.println("餐桌已预订或就餐中");
            }

        }

        //        输入n/N退出
        System.out.print("确认是否预定(Y/N):");
        char key = Utility.readConfirmSelection();
        if (key == 'N') {
            System.out.println("已退出~");
            return;
        }

//        这时候真的可以预定，输入信息完成预定
        System.out.print("请输入预定人的名字:");
        String orderName = Utility.readString(50);
        System.out.print("请输入预订人电话:");
//        进行预定
        String orderTel = Utility.readString(50);
        if (dingingTableService.updateStatusById(DingTableId, orderName, orderTel)) {
            System.out.println("预定成功");
        } else {
            System.out.println("预定失败");
        }
        ;

    }

    //    显示菜单
    public void list() {
        System.out.println("===============满汉楼===============");
        System.out.println("餐桌编号\t\t餐桌状态");
        List<DingingTable> list = dingingTableService.list();
        for (DingingTable dingingTable : list) {
            System.out.println(dingingTable.getId() + "\t\t\t\t" + dingingTable.getStatus());
        }
        System.out.println("============显示完毕============");
    }

    //    主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("===============满汉楼===============");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入员工号:");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密码:");
                    String password = Utility.readString(50);

//                    数据库验证
                    if (employeeService.getEmployeeById(empId) == null) {
                        System.out.println("员工号不存在！");
                        break;
                    }
                    if (employeeService.getEmployeeByIdAndPwd(empId, password) == null) { //验证密码
                        System.out.println("密码错误");
                        break;
                    }

//                    if (!(empId.equals("1") && password.equals("1"))) {
//                        System.out.println("登录失败！");
//                        break;
//                    }

                    System.out.println("登录成功！");

                    while (loop) {
                        //                  二级菜单
                        System.out.println();
                        System.out.println("===========满汉楼二级菜单=========");
                        System.out.println("\t\t 1 显示餐桌状态");
                        System.out.println("\t\t 2 预定餐桌");
                        System.out.println("\t\t 3 显示所有菜品");
                        System.out.println("\t\t 4 点餐服务");
                        System.out.println("\t\t 5 查看账单");
                        System.out.println("\t\t 6 结账");
                        System.out.println("\t\t 7 取消预定");
                        System.out.println("\t\t 9 退出满汉楼");
                        System.out.print("请输入你的选择:");
                        key = Utility.readString(1);
                        switch (key) {
                            case "1":
                                System.out.println("\t\t 1 显示餐桌状态");
                                list();
                                break;
                            case "2":
                                System.out.println("\t\t 2 预定餐桌");
                                oderDingTable();
                                break;
                            case "3":
                                System.out.println("\t\t 3 显示所有菜品");
                                listMenu();
                                break;
                            case "4":
                                System.out.println("\t\t 4 点餐服务");
                                orderMenu();
                                break;
                            case "5":
                                System.out.println("\t\t 5 查看账单");
                                billList();
                                break;
                            case "6":
                                System.out.println("\t\t 6 结账");
                                payBill();
                                break;
                            case "7":
                                System.out.println("\t\t 7 取消预定");
                                cancelOrder();
                                break;
                            case "9":
                                System.out.println("您已退出满汉楼~");
                                loop = false;
                                break;
                            default:
                                System.out.println("输入错误，请重新输入！");
                                break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("退出满汉楼系统~");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }
}



