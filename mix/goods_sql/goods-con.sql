insert into goods
values('asdf', 'asd-123', 12,423,124,23,'ABC');

--�ְ� ���� �ȸ���ǰ
select gname, sum(q1_selling+q2_selling+q3_selling+q4_selling) max1
from goods
group by gname
having gname = '��ǳ��';

--�ش� name ���� ���� max���� ��ġ?
select gname, sum()

select gname, sum(q1_selling+q2_selling+q3_selling+q4_selling) godsum
from goods
where gname 



select sum(q1_selling), sum(q2_selling), sum(q3_selling), sum(q4_selling)
from goods;

select max(q1_selling + q2_selling+ q3_selling+ q4_selling)
from goods;

select q1_selling +q2_selling+q3_selling+q4_selling
from goods
where companycode = 'ABC';

--�ڵ��ָ�. �� ��ǰ����ȸ���̸�
select companycode
from goods
where gcode = 'asd-123';

select companyname
from company
where companycode = (select companycode
from goods
where gcode = 'asd-123');

--��ǳ�� �̸��� 1�б� �Ǹŷ�
select gname, sum(q1_selling)
from goods
where gname = '��ǳ��'
group by gname;

--�ְ���� ������
--�����ۺ� 1234 �б� ���ؼ�. �װ� ���� ������
select gname, sum(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname;

select gname
from goods--(select gname, sum(q1_selling+q2_selling+q3_selling+q4_selling) from goods group by gname)
where max(sum(q1_selling+q2_selling+q3_selling+q4_selling)) in sum(q1_selling+q2_selling+q3_selling+q4_selling)
group by gname;



select gname, gcode, q1_selling+q2_selling+q3_selling+q4_selling
from goods
where (gname, q1_selling+q2_selling+q3_selling+q4_selling) = (select gname, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
where gname ='��ǳ��'
group by gname);

select gname, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
where gname ='��ǳ��'
group by gname;


select gname, q1_selling+q2_selling+q3_selling+q4_selling
from goods
where (gname, q1_selling+q2_selling+q3_selling+q4_selling) in 
(
select gname, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname
);

select sum(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
where gname = 'aasd';

select gname
from goods
where 18693 = in(select sum(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname);

select sum(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname;

select p1.gname, sum(p1.q1_selling+p1.q2_selling+p1.q3_selling+p1.q4_selling) ooo
from goods p1, (select gname, sum(q1_selling+q2_selling+q3_selling+q4_selling) ss
from goods
group by gname) p2
where max(p2) = max(select sum(p1.q1_selling+p1.q2_selling+p1.q3_selling+p1.q4_selling)
from goods
group by gname);
group by gname;

select gname, gcode, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname;


select gname, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname;

select gname, gcode, q1_selling+q2_selling+q3_selling+q4_selling
from goods
where (gname, q1_selling+q2_selling+q3_selling+q4_selling) = (select gname, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
group by gname) and gname = '��ǳ��';


--���帹�� �ȸ���ǰ����
select max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods;
group by gname;


--���帹�� �ȸ� ��ǰ�� �̸��� �ڵ�
select gname, gcode, q1_selling+q2_selling+q3_selling+q4_selling
from goods
where q1_selling+q2_selling+q3_selling+q4_selling = (select max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods);

select gname, gcode, q1_selling, q2_selling, q3_selling, q4_selling, p1.companycode, companyname
from goods p1, company p2 where p1.companycode = p2.companycode and gcode = 'vvv-123';

--���帹���ȸ� ��ǰ�� ���帹���ȸ����� ����ǰ���� ��ǰ�� �Ǹŷ��� ��%�����Ͽ���.
select gname, sum(q1_selling + q2_selling + q3_selling + q4_selling)
from goods
group by gname;

--�� ��ǰ���� �Ǹŷ�
select gname, gcode, (q1_selling + q2_selling + q3_selling + q4_selling) ss , companyname
from goods p1, company p2
where p1.companycode = p2.companycode and gname = 'aasd'
order by ss desc;

CREATE TABLE GOODS01
AS
SELECT * FROM GOODS WHERE 1=0;

SELECT COUNT(GNAME)
FROM GOODS;

DROP TABLE GOODS;

select rfcodeseq.nextval from dual;

insert into goods
(gname, gcode, companycode)
values ('�����', (select 'asd-'||recodeseq.nextval from dual), 'JKL');

select gname, sum(q1_selling + q2_selling + q3_selling + q4_selling)
from goods
group by gname;

select max(q1_selling + q2_selling + q3_selling + q4_selling)
fr;















select gname, sum(q1_selling + q2_selling + q3_selling + q4_selling) 
from goods
group by gname;


select gname, gcode, (q1_selling + q2_selling + q3_selling + q4_selling) ss , companyname
from goods p1, company p2
where p1.companycode = p2.companycode and gname = '������'
order by ss desc;