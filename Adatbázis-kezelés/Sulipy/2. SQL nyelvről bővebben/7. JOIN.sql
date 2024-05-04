DROP DATABASE IF EXISTS sport;
CREATE DATABASE sport;
USE sport;

CREATE TABLE ujsagirok (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nev VARCHAR(20),
	sportag VARCHAR(20),
);

INSERT INTO ujsagirok(nev, sportag) VALUES ('Norbert', 'NBA');
INSERT INTO ujsagirok(nev, sportag) VALUES ('Flóra', 'Forma-1');
INSERT INTO ujsagirok(nev, sportag) VALUES ('Balázs', 'BMX');
INSERT INTO ujsagirok(nev, sportag) VALUES ('Gábor', 'Gokart');

CREATE TABLE sportolok (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nev VARCHAR(20),
	sportag VARCHAR(20)
);

INSERT INTO sportolok (nev, sportag) VALUES ('Nóra', 'NBA');
INSERT INTO sportolok (nev, sportag) VALUES ('Ferenc', 'Forma-1');
INSERT INTO sportolok (nev, sportag) VALUES ('Fáta', 'Forma-1');
INSERT INTO sportolok (nev, sportag) VALUES ('Bea', 'BMX');
INSERT INTO sportolok (nev, sportag) VALUES ('Tibor', 'Triatlon');



--- INNER JOIN ---
SELECT ujsagirok.nev AS újságító, sportolok.nev AS sportoló, ujsagirok.sportag
FROM ujsagirok
INNER JOIN sportolok
ON ujsagirok.sportag = sportolok.sportag;

--- LEFT JOIN ---
SELECT ujsagirok.nev AS újságíró, sportolok.nev AS sportoló, ujsagirok.sportag
FROM ujsagirok
LEFT JOIN sportolok
ON ujsagirok.sportag = sportolok.sportag;

--- RIGHT JOIN ---
SELECT ujsagirok.nev AS újságíró, sportolok.nev AS sportoló, ujsagirok.sportag
FROM ujsagirok
RIGHT JOIN sportolok
ON ujsagirok.sportag = sportolok.sportag;





DROP DATABASE IF EXISTS iskola;
CREATE DATABASE iskola;
USE iskola;

CREATE TABLE class_10 (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40)
);

INSERT INTO class_10 (name) VALUES ('Horváth Péter');
INSERT INTO class_10 (name) VALUES ('Kiss Zalán');
INSERT INTO class_10 (name) VALUES ('Németh Virág');
INSERT INTO class_10 (name) VALUES ('Szabó Nóra');

CREATE TABLE class_11 (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40)
);

INSERT INTO class_11 (name) VALUES ('Mester Luca');
INSERT INTO class_11 (name) VALUES ('Fuchs Réka');
INSERT INTO class_11 (name) VALUES ('Tóth Ádám');

CREATE TABLE students (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40),
	city VARCHAR(20)
);

INSERT INTO students (name, city) VALUES ('Horváth Péter', 'Szeged');
INSERT INTO students (name, city) VALUES ('Kis Zalán', 'Szeged');
INSERT INTO students (name, city) VALUES ('Némath Virág', 'Szeged');
INSERT INTO students (name, city) VALUES ('Szabó Nóra', 'Szeged');
INSERT INTO students (name, city) VALUES ('Mester Luca', 'Pécs');
INSERT INTO students (name, city) VALUES ('Fuchs Réka', 'Pécs');
INSERT INTO students (name, city) VALUES ('Tóth Ádám', 'Pécs');



--- CROSS JOIN ---
SELECT class_10.name, class_11.name
FROM class_10
CROSS JOIN class_11;

--- SELF JOIN ---
SELECT A.name AS player_A, B.name AS player_B, A.city
FROM students A, students B
WHERE A.id <> B.id AND A.city = B.city
ORDER BY A.city;
