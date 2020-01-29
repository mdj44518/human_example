insert into goods
values('asdf', 'asd-123', 12,423,124,23,'ABC');

--최고 많이 팔린제품
select gname, sum(q1_selling+q2_selling+q3_selling+q4_selling) max1
from goods
group by gname
having gname = '선풍기';

--해당 name 들의 합이 max값과 일치?
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

--코드주면. 그 제품가진회사이름
select companycode
from goods
where gcode = 'asd-123';

select companyname
from company
where companycode = (select companycode
from goods
where gcode = 'asd-123');

--선풍기 이름의 1분기 판매량
select gname, sum(q1_selling)
from goods
where gname = '선풍기'
group by gname;

--최고매출 아이템
--아이템별 1234 분기 더해서. 그게 가장 높은놈
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
where gname ='선풍기'
group by gname);

select gname, max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods
where gname ='선풍기'
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
group by gname) and gname = '선풍기';


--가장많이 팔린상품뭐임
select max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods;
group by gname;


--가장많이 팔린 상품의 이름과 코드
select gname, gcode, q1_selling+q2_selling+q3_selling+q4_selling
from goods
where q1_selling+q2_selling+q3_selling+q4_selling = (select max(q1_selling+q2_selling+q3_selling+q4_selling)
from goods);

select gname, gcode, q1_selling, q2_selling, q3_selling, q4_selling, p1.companycode, companyname
from goods p1, company p2 where p1.companycode = p2.companycode and gcode = 'vvv-123';

--가장많이팔린 제품의 가장많이팔린모델의 그제품군이 제품군 판매량의 몇%차지하였나.
select gname, sum(q1_selling + q2_selling + q3_selling + q4_selling)
from goods
group by gname;

--그 제품들의 판매량
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
values ('선펑귀', (select 'asd-'||recodeseq.nextval from dual), 'JKL');

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
where p1.companycode = p2.companycode and gname = '에어컨'
order by ss desc;