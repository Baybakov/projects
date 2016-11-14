Select manager_id, min(salary) as min_salary
   from employees
group by manager_id
  having manager_id is not null
        and min(salary) > 6000
order by min_salary desc

Select job_id,
  SUM(Decode(department_id, 20, salary)) as "Dept 20",
  SUM(Decode(department_id, 50, salary)) as "Dept 50",
  SUM(Decode(department_id, 80, salary)) as "Dept 80",
  SUM(Decode(department_id, 90, salary)) as "Dept 90",
  SUM(salary) as "Total"
  from employees
group by job_id
      
Select department_id as department, a.last_name as employee, b.last_name as colleague 
from employees a join employees b using(department_id)
where a.employee_id != b.employee_id
order by department_id

Select e1.last_name, e1.hire_date, e2.last_name, e2.hire_date
from employees e1 join employees e2 on e1.manager_id = e2.employee_id
where e1.hire_date < e2.hire_date

Select last_name, first_name
from employees
where salary > all(Select salary from employees where department_id = 60)

Select job_id, department_id
from employees
where department_id = 10
group by job_id, department_id
UNION ALL
Select job_id, department_id
from employees
where department_id = 20
group by job_id, department_id
UNION ALL
Select job_id, department_id
from employees
where department_id = 50
group by job_id, department_id

Select  e.first_name, e.last_name, e.department_id,
(Select department_name from departments d where e.department_id = d.department_id) Dept_name
from employees e
UNION
Select  e.first_name, e.last_name, d.department_id, d.department_name
from departments d left OUTER join employees e on e.department_id = d.department_id