INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (1, 'Иван', 'Иванович', 'Иванов');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (2, 'Алена', 'Ивановна', 'Одуванчикова');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (3, 'Сергей', 'Сергеевич', 'Рубчиков');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (4, 'Алина', 'Владимировна', 'Романова');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (5, 'Егор', 'Валентинович', 'Чернышевкий');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (6, 'Яна', 'Семеновна', 'Гоич');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (7, 'Эдуард', 'Яннович', 'Грозный');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (8, 'Ирина', 'Евгеньевна', 'Дудолина');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (9, 'Николаевич', 'Николай', 'Новик');
INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (10, 'Алла', 'Ивановна', 'Сергеева');

INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (1, 'pom.xml', 'home/Desktop', 4);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (2, 'model.img', 'home/project/coursework', 17);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (3, 'case.img', 'home/Telegram', 82);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (4, '.gitignore', 'home/vuklorr/Downloads', 1);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (5, 'file.iml', 'home', 3);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (6, 'photo.png', 'home/Desktop/Holidays', 11);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (7, 'README.md', 'home/Project/Java', 7);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (8, '1.txt', 'home/Desktop', 4);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (9, 'fix.txt', 'home', 5);
INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (10, 'english.docx', 'home/Desktop/Homework', 15);

INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (1, 'Учеба');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (2, 'Лекция');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (3, 'Java');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (4, 'Фото');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (5, 'Заметка');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (6, 'Важно');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (7, 'Документ');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (8, 'Работа');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (9, 'Музыка');
INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (10, 'Прочее');

INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (1, 10);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (2, 1);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (2, 6);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (2, 7);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (3, 6);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (4, 8);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (7, 1);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (7, 3);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (7, 5);
INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (8, 10);

INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (1, 'Создать');
INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (2, 'Удалить');
INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (3, 'Редактировать');
INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (4, 'Отправить');
INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (5, 'Восстановить');
INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (6, 'Открыть');
INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (7, 'Скачать');

INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (1, 1, 1);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (2, 1, 2);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (3, 1, 3);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (4, 2, 4);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (5, 2, 2);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (6, 2, 1);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (7, 3, 4);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (8, 4, 2);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (9, 5, 1);
INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (10, 6, 6);

INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (1, 1);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (1, 2);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (1, 3);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (2, 1);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (3, 2);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (4, 3);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (4, 5);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (5, 4);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (6, 6);
INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (7, 7);

INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (1, 1, 1, 1, '2022-01-20');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (2, 7, 1, 1, '2021-01-09');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (3, 2, 2, 2, '2022-04-08');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (4, 1, 2, 3, '2023-01-09');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (5, 3, 1, 2, '2023-01-02');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (6, 2, 2, 4, '2023-01-06');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (7, 4, 4, 5, '2023-01-01');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (8, 6, 5, 6, '2022-01-30');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (9, 7, 6, 7, '2021-08-19');
INSERT INTO PUBLIC.HISTORY_OF_OPERATIONS (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (10, 7, 7, 8, '2023-01-06');
