--1
SELECT wa.name_company, wa.name_work, wa.salary, DATEDIFF(hour, wap.date_of_hiring, wap.date_of_dismissal) AS "Отработанные часы"
FROM Work_activity wa
INNER JOIN Work_activity_personal wap ON wap.id_work = wa.id
WHERE wap.id_personal_data = 1;

--2
SELECT t.name, COUNT(d.id_type)
FROM Document d
         INNER JOIN Type t ON d.id_type = t.id
WHERE d.id_personal_data = 1
GROUP BY d.id_type;

--3
SELECT pd.id, pd.name, pd.patronymic, pd.surname
FROM Personal_data pd
         INNER JOIN Address A on A.id = pd.id_address
WHERE a.country = 'Россия' AND
        a.city = 'Москва' AND
        a.region = 'Московский' AND
        a.street = 'Московская' AND
        a.house = '5А';

--4
SELECT pd.name, pd.patronymic, pd.surname, d.start_date
FROM Personal_data pd
         INNER JOIN Document d ON d.id_personal_data = pd.id
WHERE d.id_type = 7 AND
        d.start_date > CURRENT_DATE AND
        d.start_date < DATEADD(year, 1 ,CURRENT_DATE);

--5
SELECT pd1.surname, pd1.phone_number,pd2.surname, pd2.phone_number
FROM FAMILY_RELATIONS fr
         INNER JOIN PERSONAL_DATA pd1 ON pd1.id = fr.id_first_person
         INNER JOIN PERSONAL_DATA pd2 ON pd2.id = fr.id_second_person
WHERE pd1.id = 1;

--6
--Разбить на 2 запроса, чтобы сделать нормально анкету
SELECT pd.name, pd.patronymic, pd.surname, pd.phone_number,
       wa.name_company, wa.name_work, DATEDIFF(hour, wap.date_of_hiring, wap.date_of_dismissal) AS "Отработанные часы",
       a.country, a.city, a.region, a.street, a.house, a.flat
FROM Personal_data pd
         INNER JOIN Address A on A.id = pd.id_address
         INNER JOIN Work_activity_personal  wap on pd.id = wap.id_personal_data
         INNER JOIN Work_activity  wa on wa.id = wap.id_work
WHERE pd.id = 1;

--7
--Разбить на 2 запроса, чтобы сделать нормально трудовую книжку
SELECT pd.name, pd.patronymic, pd.surname,
       wa.name_company, wa.name_work, DATEDIFF(hour, wap.date_of_hiring, wap.date_of_dismissal) AS "Отработанные часы"
FROM Personal_data pd
         INNER JOIN Work_activity_personal  wap on pd.id = wap.id_personal_data
         INNER JOIN Work_activity  wa on wa.id = wap.id_work
WHERE pd.id = 1;

--8
SELECT pd2.name, pd2.patronymic, pd2.surname, pd2.phone_number,
       a.country, a.city, a.region, a.street, a.house, a.flat
FROM FAMILY_RELATIONS fr
         INNER JOIN PERSONAL_DATA pd1 ON pd1.id = fr.id_first_person
         INNER JOIN PERSONAL_DATA pd2 ON pd2.id = fr.id_second_person
         INNER JOIN Address a on a.id = pd2.id_address
WHERE pd1.id = 1;

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