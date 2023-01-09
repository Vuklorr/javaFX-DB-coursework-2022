INSERT INTO Type (name) VALUES ('Удостоверение личности');
INSERT INTO Type (name) VALUES ('Удостоверение об образовании');
INSERT INTO Type (name) VALUES ('Справка');
INSERT INTO Type (name) VALUES ('Карта');
INSERT INTO Type (name) VALUES ('Билет');
INSERT INTO Type (name) VALUES ('Удостоверение о присуждении учетной степени');
INSERT INTO Type (name) VALUES ('Удостоверение о военной службе');

INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Москва', 'Московский', 'Московская', '5А', 5);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Рязань', 'Рязанский', 'Рязанская', '15В', 25);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Москва', 'Московский', 'Московская', '5А', 31);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Уфа', 'Новый', 'Новая', '31', 18);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('США', 'Калифорния', 'Калифорнийский', 'Голливудский бульвар', '123', 123);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Великобритания', 'Лондон', 'Великобританский', 'Стрэнд', '54', 45);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Канада', 'Оттава', 'Канадский', 'Бут-стрит', '13А', 13);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Москва', 'Московский', 'Московская', '5А', 1);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Уфа', 'Уфинский', 'Уфинская', '1А', 12);
INSERT INTO Address (country, city, region, street, house, flat) VALUES ('Россия', 'Санкт-Петербург', 'Ленинградский', 'Ленинградская', '13', 3);


INSERT INTO Work_activity (name_company, name_work, salary) VALUES ('Газпром','Дворник', 15000),
                                                                   ('Альфа-банк', 'Разработчик', 760000),
                                                                   ('Барс','Аналитик', 50000),
                                                                   ('Самокат','Доставщик', 45000),
                                                                   ('Грузовичок','Водитель', 67000),
                                                                   ('МОШ','Преподаватель', 88000),
                                                                   ('МВД','Полицейский', 33000),
                                                                   ('МОБ','Врач', 76000),
                                                                   ('Яндекс','Уборщик', 7600),
                                                                   ('МПЧ','Пожарный', 51000);

INSERT INTO Work_activity_personal(id_personal_data, id_work, date_of_hiring, date_of_dismissal) VALUES (1,1,'2002-01-01', '2003-01-01'),
                                                                                                        (2,2,'2011-09-17', '2014-09-17'),
                                                                                                        (3,3, '2005-05-12', '2006-05-12'),
                                                                                                        (4,4, '2008-03-11', '2008-05-11'),
                                                                                                        (5,5, '2011-09-17', '2014-09-17'),
                                                                                                        (6,6, '2014-02-01', '2015-02-01'),
                                                                                                        (7, 7, '2020-10-10', '2022-10-10'),
                                                                                                        (8, 8, '2021-08-07', '2021-12-07'),
                                                                                                        (9, 9, '2021-08-07', '2021-12-07'),
                                                                                                        (10, 10, '2005-05-12', '2006-05-12');

INSERT INTO Personal_data (id_address, name, patronymic, surname, phone_number) VALUES (1, 'Валерий', 'Валерьевич','Валеров', '+7(123)123-12-23'),
                                                                                       (2, 'Владимир', 'Владимирович','Владимиров', '+7(321)322-22-33'),
                                                                                       (3, 'Сергей', 'Сергеевич','Коровин', '+7(111)111-11-11'),
                                                                                       (4, 'Андрей', 'Андреевич','Андреев', '+7(343)434-34-43'),
                                                                                       (5, 'Сергей', 'Сергеевич','Сергеев', '+7(252)525-25-25'),
                                                                                       (6, 'Светлана', 'Валерьевна','Земляникина', '+7(787)878-78-78'),
                                                                                       (7, 'Юлия', 'Сергеевна','Снегирева', '+7(989)898-98-98'),
                                                                                       (8, 'Илона', 'Сергеевна','Илонова', '+7(989)898-33-21'),
                                                                                       (9, 'Рекс', 'Рексович','Рексо', '+7(555)122-98-98'),
                                                                                       (10, 'Август', 'Робертович','Снов', '+7(989)111-22-12');
INSERT INTO Document (id_type, id_personal_data, start_date, END_DATE) VALUES (7,1,'2023-02-02', '2024-02-10'),
                                                                              (7,2,'2023-02-02', '2024-02-10'),
                                                                              (7,3,'2021-10-10', '2022-10-15'),
                                                                              (1,1,'2016-11-11', '2030-08-10'),
                                                                              (1,5,'2022-06-06', '2045-06-06'),
                                                                              (2,6,'2023-01-01', '2027-05-15'),
                                                                              (3,7,'2022-05-05', '2022-10-05'),
                                                                              (1,1,'2020-01-23', '2023-01-01'),
                                                                              (3,7,'2020-05-05', '2022-10-05'),
                                                                              (2,7,'2022-05-05', '2023-10-05');

INSERT INTO Type_of_relationship (name) VALUES ('Сын'),
                                               ('Дочь'),
                                               ('Отец'),
                                               ('Мать'),
                                               ('Внук'),
                                               ('Внучка'),
                                               ('Бабушка'),
                                               ('Дедушка'),
                                               ('Крестный'),
                                               ('Племянник');

INSERT INTO FAMILY_RELATIONS (id_first_person, id_second_person, id_type_of_relationship) VALUES (1,2,1),
                                                                                                 (3,6,2),
                                                                                                 (9,10,3);