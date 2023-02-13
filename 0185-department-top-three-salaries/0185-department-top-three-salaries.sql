# Write your MySQL query statement below
#SELECT departmentId, salary from (SELECT departmentId, salary from employee order by salary desc) as A where departmentId = 1 limit 3;

#SELECT salary, departmentId FROM (SELECT salary, departmentId, ROW_NUMBER() OVER (PARTITION BY departmentId ORDER BY salary DESC) as row_num FROM employee) as ee WHERE row_num <= 3;
SELECT 
    dep.name AS 'Department',
    emp.name AS 'Employee',
    emp.salary AS 'Salary'
FROM
    Employee emp 
        JOIN
    Department dep ON emp.departmentId = dep.id
WHERE ( SELECT
            COUNT(DISTINCT(emp2.salary))
          FROM
            Employee emp2
          WHERE
            emp2.salary > emp.salary
                    AND
            emp2.DepartmentId = emp.DepartmentId        
      ) < 3
;