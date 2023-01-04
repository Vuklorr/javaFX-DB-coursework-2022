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

INSERT INTO Work_activity (name_work, salary, hours_worked, date_of_hiring, date_of_dismissal) VALUES ('Дворник', 15000, 1500, '2002-01-01', '2003-01-01'),
                                                                                                      ('Аналитик', 50000, 2000, '2005-05-12', '2006-05-12'),
                                                                                                      ('Доставщик', 45000, 300, '2008-03-11', '2008-05-11'),
                                                                                                      ('Водитель', 67000, 8700, '2011-09-17', '2014-09-17'),
                                                                                                      ('Преподаватель', 88000, 1000, '2014-02-01', '2015-02-01'),
                                                                                                      ('Полицейский', 33000, 3650, '2020-10-10', '2022-10-10'),
                                                                                                      ('Врач', 76000, 720, '2021-08-07', '2021-12-07');

INSERT INTO Relative (name, patronymic, surname, phone_number) VALUES ('Иван', 'Иванович', 'Иванов', '+7(999)999-99-99'),
                                                                      ('Семен', 'Семенович', 'Семенов', '+7(888)888-88-88'),
                                                                      ('Дмитрий', 'Дмитриевич', 'Дмитров', '+7(777)777-77-77'),
                                                                      ('Ян', 'Янович', 'Янов', '+7(666)666-66-66'),
                                                                      ('Мария', 'Ивановна', 'Воробьева', '+7(555)555-55-55'),
                                                                      ('Ольга', 'Олеговная', 'Олего', '+7(444)444-44-44'),
                                                                      ('Ирина', 'Сергеевна', 'Жевко', '+7(333)333-33-33');

INSERT INTO Personal_data (id_address, id_relative, id_work, name, patronymic, surname, phone_number) VALUES (1,1,1, 'Валерий', 'Валерьевич','Валеров', '+7(123)123-12-23'),
                                                                                                             (2,2,2, 'Владимир', 'Владимирович','Владимиров', '+7(321)322-22-33'),
                                                                                                             (3,3,3, 'Сергей', 'Сергеевич','Коровин', '+7(111)111-11-11'),
                                                                                                             (4,4,4, 'Андрей', 'Андреевич','Андреев', '+7(343)434-34-43'),
                                                                                                             (5,5,5, 'Сергей', 'Сергеевич','Сергеев', '+7(252)525-25-25'),
                                                                                                             (6,6,6, 'Светлана', 'Валерьевна','Земляникина', '+7(787)878-78-78'),
                                                                                                             (7,7,7, 'Юлия', 'Сергеевна','Снегирева', '+7(989)898-98-98');

INSERT INTO Document (id_type, id_personal_data, start_date, end_date) VALUES (7,1,'2023-02-02', '2024-02-10'),
                                                                              (7,2,'2023-02-02', '2024-02-10'),
                                                                              (7,3,'2021-10-10', '2022-10-15'),
                                                                              (1,4,'2016-11-11', '2030-08-10'),
                                                                              (1,5,'2022-06-06', '2045-06-06'),
                                                                              (2,6,'2023-01-01', '2027-05-15'),
                                                                              (3,7,'2022-05-05', '2022-10-05');