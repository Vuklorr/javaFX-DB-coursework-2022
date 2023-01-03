--1
SELECT *
FROM Work_activity;

--2
SELECT t.name, COUNT(d.id_type)
FROM Document d
         INNER JOIN Type t ON d.id_type = t.id
WHERE d.id_personal_data = 1
GROUP BY d.id_type;

--3
SELECT pd.name, pd.patronymic, pd.surname, a.flat
FROM Personal_data pd
         INNER JOIN Address A on A.id = pd.id_address
WHERE a.country = 'Россия' AND
        a.city = 'Москва' AND
        a.region = 'Московский' AND
        a.street = 'Московская' AND
        a.house = '5А';

--4
SELECT pd.name, pd.patronymic, pd.surname
FROM Personal_data pd
         INNER JOIN Document d ON d.id_personal_data = pd.id
WHERE d.id_type = 7 AND d.start_date > CURRENT_DATE;

--5
SELECT pd.surname, pd.phone_number, r.phone_number
FROM Personal_data pd
         INNER JOIN Relative r on pd.id_relative = r.id
WHERE pd.id = 1;

--6
SELECT pd.name, pd.patronymic, pd.surname, pd.phone_number,
       wa.name_work, wa.hours_worked,
       a.country, a.city, a.region, a.street, a.house, a.flat
FROM Personal_data pd
         INNER JOIN Address A on A.id = pd.id_address
         INNER JOIN Work_activity wa on pd.id_work = wa.id
WHERE pd.id = 1;

--7
SELECT pd.name, pd.patronymic, pd.surname,
       wa.name_work, wa.salary, wa.hours_worked, wa.date_of_hiring, wa.date_of_dismissal
FROM Personal_data pd
         INNER JOIN Work_activity wa on pd.id_work = wa.id
WHERE pd.id = 1;

--8
SELECT r.name, r.patronymic, r.surname, r.phone_number
FROM Relative r
         INNER JOIN Personal_data Pd on r.id = Pd.id_relative
WHERE pd.id = 1;

--9
SELECT pd.name, pd.patronymic, pd.surname,
       a.country, a.city, a.region, a.street, a.house, a.flat
FROM Personal_data pd
         INNER JOIN Address A on A.id = pd.id_address
WHERE pd.id = 1;

--10
SELECT pd.name, pd.patronymic, pd.surname
FROM Personal_data pd
         INNER JOIN Document d ON d.id_personal_data = pd.id
         INNER JOIN Type t ON d.id_type = t.id
WHERE pd.phone_number = '+7(123)123-12-23' AND
        pd.name = 'Валерий' AND
        pd.patronymic = 'Валерьевич' AND
        pd.surname = 'Валеров' AND
        t.name = 'Удостоверение о военной службе';
