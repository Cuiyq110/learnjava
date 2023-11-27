use hsp_db02;
-- 显示没有上级的雇员的情况
select *
from emp
where mgr is null;

desc emp;

-- 增强 group by 的使用, 分组函数
select COUNT(*), job
from emp
group by job;

-- 显示管理者的总人数
select count(distinct mgr)
from emp;

-- 显示雇员工资的最大差值
select MAX(sal) - MIN(sal)
from emp;

-- 统计各个部门的平均工资，并且是大于1000，并且按照平均工资从高到低排序
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) > 1000
order by avg(sal) DESC
limit 0,2;


select *
from emp,
     dept;

select *
from emp,
     dept
where emp.deptno = emp.deptno;


-- ?显示各个员工的姓名，工资，及其工资的级别
select ename,sal,grade
from emp,
     salgrade
where sal between losal and hisal;

-- 显示雇员名，雇员工资及所在部门的名字，并按部门排序 （降序）
select ename,sal,dname,emp.deptno
from emp,dept
where emp.deptno = dept.deptno
order by emp.deptno desc ;

-- 显示公司员工名字和他的上级的名字
SELECT worker.ename as '员工名字', boss.ename as '上级名字'
from emp worker, emp boss
where worker.mgr = boss.empno;

-- 如何显示与SMITH同一部门的所有员工
select *
from emp
 where deptno = (select deptno from emp where ename = 'SMITH');

-- 课堂练习:如何查询和部门10的工作相同的雇员的
-- 名字、岗位、工资、部门号,但是不含10号部门自己的雇员.

select distinct job
from emp
where deptno = 10;

select ename,job,sal,deptno
from emp
where emp.job in (
    select distinct job
    from emp
    where deptno = 10
    ) and deptno != 10;


use hsp_db02;








