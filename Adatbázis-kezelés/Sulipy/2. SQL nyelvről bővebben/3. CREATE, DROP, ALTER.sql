DROP DATABASE IF EXISTS muhely;
CREATE DATABASE muhely;
USE muhely;

DROP TABLE IF EXISTS szgk;

CREATE TABLE szgk (
	id INT PRIMARY KEY AUTO_INCREMENT,
	tipus VARCHAR(20) DEFAULT 'Toyota',
	modell VARCHAR(20) NOT NULL,
	rendszam VARCHAR(15) UNIQUE,
	ajtok_szama INT CHECK (ajtok_szama < 6),
	gyartas_eve DATE
);

INSERT INTO szgk (tipus, modell, rendszam, ajtok_szama, gyartas_eve)
VALUES ('Opel', 'Corsa', 'ABC123', 4, '2002-10-04');





--- FELADATOK: ---

DROP DATABASE IF EXISTS kutyamenhely;
CREATE DATABASE kutyamenhely;
USE kutyamenhely;

DROP TABLE IF EXISTS kutyak;
CREATE TABLE kutyak (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nev VARCHAR(20) NOT NULL,
	kor INT CHECK (kor <= 30),
	nem VARCHAR(5) DEFAULT 'kan',
	megjegyzes VARCHAR(500)
);

INSERT INTO kutyak (nev, kor, nem, megjegyzes)
VALUES ('Bogyó', 2, 'szuka', 'szeret ugrálni');

INSERT INTO kutyak (nev, kor, megjegyzes)
VALUES ('Káosz', 7, 'szereti a társaságot')
