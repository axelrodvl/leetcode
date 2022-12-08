# https://leetcode.com/problems/sales-person/

# Write your MySQL query statement below
select name
from salesperson
where name not in (select s.name
                   from orders o
                            join company c on c.com_id = o.com_id
                            join salesperson s on o.sales_id = s.sales_id
                   where c.name = 'RED')