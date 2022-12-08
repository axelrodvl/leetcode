# https://leetcode.com/problems/customers-who-never-order/

# Write your MySQL query statement below
select name AS Customers
from customers
         left join orders on customers.id = orders.customerId
where customerId IS NULL

# Write your MySQL query statement below
select name AS Customers
from customers
where id not in (select customerId
                 from orders)