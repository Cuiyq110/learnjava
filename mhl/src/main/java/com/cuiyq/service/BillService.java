package main.java.com.cuiyq.service;

import com.cuiyq.domain.Bill;
import com.cuiyq.domain.MultiTableBean;
import main.java.com.cuiyq.dao.BillDao;
import main.java.com.cuiyq.dao.MultiTableDao;


import java.util.List;
import java.util.UUID;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：处理和账单相关的业务逻辑
 */
@SuppressWarnings("all")
public class BillService {
    private BillDao billDao = new BillDao();
    private MenuService menuService = new MenuService();
    private DingingTableService dingingTableService = new DingingTableService();
//    多表联查
    private MultiTableDao multiTableDao = new MultiTableDao();

    //    查看根据id查看是否有未结账的账单,如果有返回true
    public boolean hasPayBillByTableId(int dingingTableId) {
        Bill bill = billDao.querySingle("select * from bill where dingingTableId = ? and state = '未结账' limit 0, 1", Bill.class, dingingTableId);
        return bill != null;
    }

    //    结账方法
    public boolean payBill(int dingingTableId,String payWay) {
        //  将bill表中state字段更新为已结账
        int update = billDao.update("update bill set state = ? where dingingTableId = ?", payWay, dingingTableId);
//        如果小于0就退出去
        if (update < 0) {
            return false;
        }

//        将dingdingTable表中的就餐中改为空,如果是假的就退出
         if (!(dingingTableService.updateStatusById(dingingTableId, "空"))) {
             return false;
         }

         return true;
    }


    //    生成账单
    public boolean orderMenu(int menuId, int nums, int dingingTableId) {

//        生成一个账单号UUID
        String uuid = UUID.randomUUID().toString();

        int update = billDao.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", uuid, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, dingingTableId);
        if (update < 0) {
            return false;
        }

        //    更新餐桌状态
        return dingingTableService.updateStatusById(dingingTableId, "就餐中");
    }

    //    显示所有账单
    public List<Bill> list() {
        List<Bill> bills = billDao.queryMulti("select * from bill", Bill.class);
        return bills;
    }

//    多表联查显示账单
    public List<MultiTableBean> listMulti() {
        List<MultiTableBean> multiTableBeans = multiTableDao.queryMulti("select bill.*,menu.name,menu.price from bill,menu where menuId = menu.id", MultiTableBean.class);
        return multiTableBeans;
    }
}
