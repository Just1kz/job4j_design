select *
from uni_students.public.students;

select
        name,
        course,
        speciality
from uni_students.public.students;

select *
from uni_students.public.students
where course = 2;

select *
from uni_students.public.students
where course != 2;

select *
from uni_students.public.students
where course > 2;

select *
from uni_students.public.students
where name is null;

select *
from uni_students.public.students
where name is not null;

select *
from uni_students.public.students
where enroll_date > '01.09.2020';

select *
from uni_students.public.students
where enroll_date = '01.09.2020';

--.. LIKE “%abc” – строка должна кончаться с “abc”
--.. LIKE “abc%” – строка должна начинаться с “abc”
--.. LIKE “%abc%” – строка должна содержать “abc”
select *
from uni_students.public.students
where name like 'D%';

select *
from uni_students.public.students
where name like 'D%' and course > 2;

select *
from uni_students.public.students
where name like 'D%' or course > 2;

select current_date;

select current_date > '10.09.2020';

select current_date + interval '1 month'; -- прибавление какой-то единицы времени (day, week, month, year, hour)

--Упорядочивание выборки ORDER BY -> ASC – ascending (по возрастанию), DESC – descending (по убыванию)
select *
from uni_students.public.students
order by speciality asc;

select *
from uni_students.public.students
order by speciality desc;

--Выборка уникальных элементов SELECT DISTINCT.
-- Если нам нужно получить только уникальные элементы, то нужно указать distinct после select.
select distinct course
from uni_students.public.students;

--Выборка определенного числа элементов LIMIT
--Данный метод работает аналогично методу limit() в стримах. Оставляет указанное ему число строк.
select *
from uni_students.public.students
limit 5;