package main.java.com.cuiyq.service;


import com.cuiyq.domain.Employee;
import main.java.com.cuiyq.dao.EmployeeDao;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDao();

    //    根据id返回employee对象
    public Employee getEmployeeById(String empId) {
        return employeeDao.querySingle("select * from employee where empId = ?", Employee.class, empId);
    }

//    根据id,password返回employee对象
    public Employee getEmployeeByIdAndPwd(String empId, String password) {
        return employeeDao.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, password);
    }
}
