package class_.jdbcDemo03.com.cuiyq.dao;

import class_.jdbcDemo03.com.cuiyq.pojo.Book;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public interface BookDao {

//    获取所有图书
    List<Book> getAllBook();

    /**
     * 分页的方法
     * @param pageIndex 当前是第几页
     * @param pageSize 每页显示几条
     * @return 当前也显示的图书集合
     */
    Book getBookById(int pageIndex,int pageSize);

//    获取某个类别下的图书集合
    List<Book> getBookByType(int typeI);

    //按照主键查询
    Book getBookById(String bookNo);

//    按照图书名字 模糊查询
    List<Book> getBookByName(String bookName);

//    添加
    int addBook(Book book);
//    删除
    int deleteBook(String bookNo);
//    修改
    int updateBook(Book book);
}
