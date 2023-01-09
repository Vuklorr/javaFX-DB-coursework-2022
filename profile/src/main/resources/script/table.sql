create table PUBLIC.ADDRESS
(
    ID INTEGER auto_increment,
    COUNTRY CHARACTER VARYING(255),
    CITY CHARACTER VARYING(255),
    REGION CHARACTER VARYING(255),
    STREET CHARACTER VARYING(255),
    HOUSE CHARACTER VARYING(255),
    FLAT INTEGER,
    primary key (ID)
);

create table PUBLIC.DOCUMENT
(
    ID INTEGER auto_increment,
    ID_TYPE INTEGER,
    ID_PERSONAL_DATA INTEGER,
    START_DATE DATE,
    END_DATE DATE,
    primary key (ID)
);

create table PUBLIC.TYPE
(
    ID INTEGER auto_increment,
    NAME CHARACTER VARYING(255),
    primary key (ID)
);

CREATE TABLE Personal_data (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               id_address INT,
                               name VARCHAR(255),
                               patronymic VARCHAR(255),
                               surname VARCHAR(255),
                               phone_number VARCHAR(255),
                               FOREIGN KEY (id_address) REFERENCES Address(id)
);

CREATE TABLE Type_of_relationship (
                                      id INT PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR(255)
);

CREATE TABLE Family_relations (
                                  id_first_person INT,
                                  id_second_person INT,
                                  id_type_of_relationship INT,
                                  PRIMARY KEY (id_first_person, id_second_person),
                                  FOREIGN KEY (id_type_of_relationship) REFERENCES Type_of_relationship(id)
);

CREATE TABLE Work_activity (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               name_company VARCHAR(255),
                               name_work VARCHAR(255),
                               salary INT
);

CREATE TABLE Work_activity_personal(
                                       id_personal_data INT,
                                       id_work INT,
                                       date_of_hiring DATE,
                                       date_of_dismissal DATE,
                                       PRIMARY KEY(id_personal_data, id_work)
);
