use tmp;

-- 执行5s
select *
from emp
where empno = 100034;

select count(*)
from emp;

-- 创建索引
CREATE INDEX empno_index on emp(empno);

-- 执行1s
select *
from emp
where empno = 8000000;

drop index empno_index on emp;

