package main.java.com.cuiyq.service;


import com.cuiyq.domain.DingingTable;
import main.java.com.cuiyq.dao.DingingTableDao;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：
 */
@SuppressWarnings("all")
public class DingingTableService {
    private DingingTableDao dingingTableDao = new DingingTableDao();

    //    显示所有列表
    public List<DingingTable> list() {
        return dingingTableDao.queryMulti("select * from dingingTable", DingingTable.class, null);
    }

    //   根据Id返回一个对象
    public DingingTable getDingTableById(Integer id) {
        return dingingTableDao.querySingle("select * from dingingTable where id=?", DingingTable.class, id);
    }

    //    根据Id判断餐桌状态
    public Object getstatusById(Integer id) {
        Object o = dingingTableDao.queryScalar("select status from dingingTable where id = ?", id);
        return o;
    }

    //  设置预定，将状态改为预定状态,并预订人和预订人电话信息
    public boolean updateStatusById(Integer id, String orderName, String orderTel) {
        return dingingTableDao.update("update dingingTable set status = '已预定', orderName = ? ,orderTel = ? where id = ?", orderName, orderTel, id) > 0;
    }

    //    根据Id更新餐桌状态
    public boolean updateStatusById(Integer id, String status) {
        return dingingTableDao.update("update dingingTable set status = ? where id = ?", status, id) > 0;
    }

    //    根据id取消预定
    public boolean cancelOrderById(Integer id) {
        return dingingTableDao.update("update dingingTable set status = '空' where id = ?", id) > 0;
    }
}
