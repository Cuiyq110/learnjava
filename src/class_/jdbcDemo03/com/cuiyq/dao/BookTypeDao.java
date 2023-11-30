package class_.jdbcDemo03.com.cuiyq.dao;

import class_.jdbcDemo03.com.cuiyq.pojo.BookType;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public interface BookTypeDao {
    //获取所有的图书类别
    List<BookType> getAllTypes();

//    根据类别编号，获取类别对象
    BookType getBookTypeById(int typeId);

    //    获取分页的集合
    List<BookType> getBookTypesByPage(int pageIndex,int pageSize);
//    根据类别名称 获取类别对象
    BookType getBookTypeByName(String typeName);

//    添加图书类别
    int addBookType(BookType bookType);
//    删除图书类别
    int delBookType(int typeId);

    /**
     *  类别编号 是 图书表的外键
     *  删除类别的时候  考虑到图书表中有没有当前类别存在，
     *  [SQL]delete from bookType where typeID = 1;
     [Err] 1451 - Cannot delete or update a parent row:
     a foreign key constraint fails (`java2301`.`book`, CONSTRAINT `book_ibfk_1` FOREIGN KEY (`typeId`)
     REFERENCES `booktype` (`typeId`));

     从数据库的角度 先删除图书表中 typeId = 1 这样的数据
     从 java 的角度 ：查询 当前类别是否有图书存在？
     List<BookType> getBooksByTypeId(int typeId);

     在删除之前先调用 该方法 得到 集合 List<BookType>，判断  集合.size() > 0 成立吗？
     两种情况  集合.size() 大于 > 0 先删除 图书 在删除类别
     集合.size() = 0 直接删除类别即可
     *
     */

//    修改图书类别
    int updateBookType(BookType bookType);
}
