package class_.jdbcDemo03.com.cuiyq.dao.impl;

import class_.jdbcDemo03.com.cuiyq.dao.BookTypeDao;
import class_.jdbcDemo03.com.cuiyq.pojo.BookType;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class BookTypeImpl implements BookTypeDao {

    @Override
    public List<BookType> getAllBookTypes() {
        return null;
    }

    @Override
    public BookType getBookTypeById(int typeId) {
        return null;
    }

    @Override
    public List<BookType> getBookTypesByPage(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public BookType getBookTypeByName(String typeName) {
        return null;
    }

    @Override
    public int addBookType(BookType bookType) {
        return 0;
    }

    @Override
    public int delBookType(int typeId) {
        return 0;
    }

    @Override
    public int updateBookType(BookType bookType) {
        return 0;
    }
}
