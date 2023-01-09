CREATE TABLE File (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    path VARCHAR(255),
    size INT
);

CREATE TABLE Tag (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE File_Tag (
    id_file INT,
    id_tag INT,
    PRIMARY KEY (id_file, id_tag),
    FOREIGN KEY (id_file) REFERENCES File(id),
    FOREIGN KEY (id_tag) REFERENCES Tag(id)
);

CREATE TABLE Client (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    patronymic VARCHAR(255),
    surname VARCHAR(255)
);

CREATE TABLE Type_Of_Operation (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE History_Of_Operations (
    id INT PRIMARY KEY,
    id_type_of_operation INT,
    id_client INT,
    id_file INT,
    date_of_operation DATE,
    FOREIGN KEY (id_type_of_operation) REFERENCES Type_Of_Operation(id),
    FOREIGN KEY (id_client) REFERENCES Client(id),
    FOREIGN KEY (id_file) REFERENCES File(id)
);

CREATE TABLE Privilege (
    id INT PRIMARY KEY,
    id_client INT,
    id_file INT,
    FOREIGN KEY (id_client) REFERENCES Client(id),
    FOREIGN KEY (id_file) REFERENCES File(id)
);

CREATE TABLE Privilege_Of_Operation (
    id_privilege INT,
    id_type_of_operation INT,
    PRIMARY KEY (id_privilege, id_type_of_operation),
    FOREIGN KEY (id_privilege) REFERENCES Privilege(id),
    FOREIGN KEY (id_type_of_operation) REFERENCES Type_Of_Operation(id)
);