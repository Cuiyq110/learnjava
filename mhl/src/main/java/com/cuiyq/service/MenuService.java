package main.java.com.cuiyq.service;


import com.cuiyq.domain.Menu;
import main.java.com.cuiyq.dao.MenuDao;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：完成对menu表的各种操作(通过调用MenuDAO)
 */
@SuppressWarnings("all")
public class MenuService {

    //    定义MenuDao属性
    private MenuDao menuDao = new MenuDao();

    //    显示所有菜品
    public List<Menu> list() {
        return menuDao.queryMulti("select * from menu", Menu.class);
    }

//    根据id返回菜品对象
    public Menu getMenuById(Integer id) {
        return menuDao.querySingle("select * from menu where id=?", Menu.class, id);
    }
}
