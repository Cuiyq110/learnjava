package com.cuiyq.abstract_;

public abstract class Employe {
    private String name;
    private int id;
    private double salary; //奖金

    public Employe(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Employe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //抽象方法
    public abstract void work();


}

class Manager extends Employe {

    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public Manager() {

    }

    @Override
    public void work() {
        System.out.println("经理" + getName() + "工作中。。。");
    }


}
class CommonEmployee extends Employe {
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    public CommonEmployee() {
    }

    @Override
    public void work() {
        System.out.println("普通员工：" + getName() + "正在工作中。。。");
    }
}
class Test {
    public static void main(String[] args) {
        Manager manager = new Manager("a1", 1, 4000, 200);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee("c1", 1,200);
        commonEmployee.work();
    }
}



