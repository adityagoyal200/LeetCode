SELECT d.name AS department, e.name AS employee, e.salary  
FROM Employee e  
JOIN Department d ON e.DepartmentId = d.Id  
WHERE e.salary = (  
    SELECT MAX(salary)  
    FROM Employee  
    WHERE DepartmentId = e.DepartmentId  
);

