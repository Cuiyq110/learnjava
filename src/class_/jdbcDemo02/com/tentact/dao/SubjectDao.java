package class_.jdbcDemo02.com.tentact.dao;

import class_.jdbcDemo02.com.tentact.pojo.Subject;

import java.util.List;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public interface SubjectDao {
    //查询所有
    List<Subject> getAllSubjects();

    //按照主键查询
    Subject getSubjectBySubjectNo(int subjectNo);

    //新增
    int addSubject(Subject subject);

    //修改
    int updateSubject(Subject subject);

    //删除
    int delSubject(int subjectNo);

}
