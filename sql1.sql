Select last_name, job_id, salary 
  from employees 
    where job_id in('SA_REP', 'ST_CLERK') 
      and salary not in(2500, 3500, 7000);

Select last_name, hire_date
  from employees
    where first_name like '__a%' 
      and  to_char(hire_date, 'dd.mm.yyyy') between  '01.01.1980' and '01.01.2000'
    
Select last_name, to_char((sysdate - hire_date) / 7, '99999999') as count_week
  from employees
    where department_id = 90 order by count_week desc
    
Select last_name, nvl(to_char(commission_pct, '990.99'), 'No Commission') 
  from employees
  
Select last_name, job_id, decode(job_id, 
    'AD_PRES', 'A',
    'ST_MAN', 'B',
    'IT_PROG', 'C',
    'SA_REP', ' D',
    'ST_CLERK', 'E', '0') as grade
      from employees
      
Select last_name, job_id,
    case job_id 
      when 'AD_PRES' then 'A'
      when 'ST_MAN' then 'B'
      when 'IT_PROG' then 'C'
      when 'SA_REP' then ' D'
      when 'ST_CLERK' then 'E'
      else '0'
    end as grade
      from employees  