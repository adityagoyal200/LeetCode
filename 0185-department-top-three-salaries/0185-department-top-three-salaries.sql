SELECT d.name AS department,
e1.name AS employee,
e1.salary AS Salary
FROM Employee e1  
JOIN Department d ON e1.DepartmentId = d.Id  
WHERE (  
    SELECT COUNT(DISTINCT e2.Salary)  
    FROM Employee e2  
    WHERE e2.DepartmentId = e1.DepartmentId AND e2.Salary > e1.Salary  
) < 3;
