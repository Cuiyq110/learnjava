package class_.jdbcDemo03.com.cuiyq.dao.impl;

import class_.jdbcDemo03.com.cuiyq.dao.BaseDao;
import class_.jdbcDemo03.com.cuiyq.dao.BookDao;
import class_.jdbcDemo03.com.cuiyq.pojo.Book;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public List<Book> getAllBook() {
        return null;
    }

    @Override
    public Book getBookById(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public List<Book> getBookByType(int typeI) {
        return null;
    }

    @Override
    public Book getBookById(String bookNo) {
        return null;
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        return null;
    }

    @Override
    public int addBook(Book book) {
        return 0;
    }

    @Override
    public int deleteBook(String bookNo) {
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }
}
