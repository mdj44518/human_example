--������

-- 1 �� -----------------------------------------------------------------------------------
-- �̸� A�� �����ϴ� ����� ���, �̸�, ���� ���
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

-- 2 �� -----------------------------------------------------------------------------------
-- �� �μ����� �ְ� ���� �޿� �޴»���� 3000�̻� �޴´ٸ� �� �μ��� �μ���ȣ, �ְ�޿�, �ּұ޿� ���
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal) >= 3000;

-- 3 �� -----------------------------------------------------------------------------------
-- ���̺� ����
CREATE TABLE EMP_TABLE (
    "EMP_NO" NUMBER(5,0) NOT NULL PRIMARY KEY,
    "EMP_NAME" VARCHAR2(30 BYTE) NOT NULL,
    "SALARY" NUMBER(8,2),
    "ADDRESS" VARCHAR2(50 BYTE)
);

-- 4 �� -----------------------------------------------------------------------------------
-- ������ ���̺� ������ �߰�
insert into emp_table
values (11111, 'ȫ�浿', 5555.12, '����� ���α� 123');

insert into emp_table
(emp_no, salary, emp_name, address)
values (22222, 5432.99, '���ϳ�', '������ �Ǽ��� 88');

-- 5 �� -----------------------------------------------------------------------------------
-- �μ����� �ְ� �޿��� �޴� ����� ���, �̸�, �޿�, �μ���ȣ ���(���������̿�)
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
            

-- 6 �� -----------------------------------------------------------------------------------
-- �޶󽺿��� �ٹ��ϴ� ����� �̸�, �μ���ȣ ���
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

-- 7 �� -----------------------------------------------------------------------------------
-- EMP,DEPT �����÷����� ���� LOC -> '�ٹ���' �� �ٲ����, EMPNO �������� ���ķ� ���
select empno, ename, job, mgr, hiredate, sal, comm, deptno, dname, loc as �ٹ���
from emp inner join dept
using (deptno)
order by empno asc;

-- 8 �� -----------------------------------------------------------------------------------
-- emp���̺� job ���� ����� ���
select count(distinct(job))
FROM emp;


--X
select max(rownum)
from (select job
      from emp
      group by job);