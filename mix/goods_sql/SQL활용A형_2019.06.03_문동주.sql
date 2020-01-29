--문동주

-- 1 번 -----------------------------------------------------------------------------------
-- 이름 A로 시작하는 사람의 사번, 이름, 직급 출력
select empno, ename, job
from emp
where ename like 'A%';


--X
select empno, ename, job
from emp
where substr(ename, 1, 1) = 'A';
--X
select empno, ename, job
from emp
where instr(ename, 'A') = 1;

-- 2 번 -----------------------------------------------------------------------------------
-- 각 부서에서 최고 높은 급여 받는사람이 3000이상 받는다면 그 부서의 부서번호, 최고급여, 최소급여 출력
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 3000;

-- 3 번 -----------------------------------------------------------------------------------
-- 테이블 생성
CREATE TABLE EMP_TABLE (
    "EMP_NO" NUMBER(5,0) NOT NULL PRIMARY KEY,
    "EMP_NAME" VARCHAR2(30 BYTE) NOT NULL,
    "SALARY" NUMBER(8,2),
    "ADDRESS" VARCHAR2(50 BYTE)
);

-- 4 번 -----------------------------------------------------------------------------------
-- 생성한 테이블에 데이터 추가
insert into emp_table
values (11111, '홍길동', 5555.12, '서울시 종로구 123');

insert into emp_table
(emp_no, salary, emp_name, address)
values (22222, 5432.99, '김하나', '수원시 권선구 88');

-- 5 번 -----------------------------------------------------------------------------------
-- 부서별로 최고 급여를 받는 사원의 사번, 이름, 급여, 부서번호 출력(서브쿼리이용)
select empno, ename, sal, deptno
from emp
where (deptno, sal) in(select deptno, max(sal)
                       from emp
                       group by deptno);
                       

--X
select empno, ename, sal, deptno
from emp t1
where sal >= all(select sal
                 from emp t2
                 where t1.deptno = t2.deptno);          
            

-- 6 번 -----------------------------------------------------------------------------------
-- 달라스에서 근무하는 사원의 이름, 부서번호 출력
select ename, emp.deptno
from emp, dept
where emp.deptno = dept.deptno
  and loc = 'DALLAS';


--X
select ename, deptno
from emp
where deptno = (select deptno
                from dept
                where loc = 'DALLAS');
--X
select distinct ename, deptno
from emp t1
where exists (select deptno
              from dept t2
              where loc = 'DALLAS'
                and t1.deptno = t2.deptno);

-- 7 번 -----------------------------------------------------------------------------------
-- EMP,DEPT 공통컬럼으로 조인 LOC -> '근무지' 로 바꿔출력, EMPNO 오름차순 정렬로 출력
select empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc as 근무지
from emp inner join dept
using (deptno)
order by empno asc;

-- 8 번 -----------------------------------------------------------------------------------
-- emp테이블 job 종류 몇개인지 출력
select count(distinct(job))
FROM emp;


--X
select max(rownum)
from (select job
      from emp
      group by job);