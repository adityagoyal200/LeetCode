# Write your MySQL query statement below
SELECT DISTINCT t1.id, 
       CASE 
           WHEN t1.p_id IS NULL THEN 'Root'
           WHEN t2.p_id IS NOT NULL THEN 'Inner'
           ELSE 'Leaf'
       END AS Type
FROM tree t1
LEFT JOIN tree t2 ON t1.id = t2.p_id;
