DROP DATABASE IF EXISTS shop;
CREATE DATABASE shop;
USE shop;

CREATE TABLE customers (
	customer_id INT,
	name VARCHAR(40),
	PRIMARY KEY (customer_id)
);

CREATE TABLE orders (
	order_id INT,
	order_date DATE,
	customer_id INT,
	PRIMARY KEY (order_id),
	CONSTRAINT FK_customer_order FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

INSERT INTO customers (customer_id, name) VALUES (1, 'Kis Peter');
INSERT INTO customers (customer_id, name) VALUES (2, 'Nagy Anita');
INSERT INTO customers (customer_id, name) VALUES (77, 'Szego Pal');
INSERT INTO customers (customer_id, name) VALUES (101, 'Horvath Tamas');
INSERT INTO customers (customer_id, name) VALUES (102, 'Szabo Nora');

INSERT INTO orders (order_id, order_date, customer_id) VALUES (1000, '2022-01-05', 1);
INSERT INTO orders (order_id, order_date, customer_id) VALUES (1001, '2022-01-07', 2);
INSERT INTO orders (order_id, order_date, customer_id) VALUES (1002, '2022-02-03', 77);
INSERT INTO orders (order_id, order_date, customer_id) VALUES (1003, '2022-01-09', 77);



DROP TABLE customers;  -- Hibaüzenetet ad, mert egy másik tábla hivatkozik erre a táblára
DELETE FROM customers WHERE customer_id = 1;  -- Így törlünk egy feltételnek megfelelő elemet, de ezzel is hibaüzenetet kapunk

ALTER TABLE orders  -- Kiválasztom, hogy melyik táblának szeretném módosítani a tulajdonságait
DROP CONSTRAINT FK_customer_order;  -- Majd kiválasztom a tulajdonságot (itt: eltávolítjuk a kapcsolatot a két tábla között)

ALTER TABLE orders  -- Kiválasztom a táblát, aminek a tulajdonságait módosítani szeretném
ADD CONSTRAINT FK_customer_order FOREIGN KEY (customer_id) REFERENCES customers (customer_id);  -- Majd az ADD záradékkal hozzáadom a tulajdonságot (itt: a kapcsolatot a két tábla között)





--- FELADATOK: ---

DROP DATABASE IF EXISTS muhely;
CREATE DATABASE muhely;
USE muhely;
  
DROP TABLE IF EXISTS szgk;
CREATE TABLE szgk(
	szgk_id INT PRIMARY KEY AUTO_INCREMENT, 
    tipus VARCHAR(20) DEFAULT 'Toyota', 
    modell VARCHAR(20) NOT NULL, 
    rendszam VARCHAR(15) UNIQUE, 
    ajtok_szama INT CHECK (ajtok_szama < 6),
    gyartas_eve DATE
);

DROP TABLE IF EXISTS tulajdonosok;
CREATE TABLE tulajdonosok (
	tulaj_id INT PRIMARY KEY,
	vezeteknev VARCHAR(20),
	keresztnev VARCHAR(20),
	szgk_id INT,
	CONSTRAINT FK_szgk_tulaj FOREIGN KEY (szgk_id) REFERENCES szgk (szgk_id)
);
  
INSERT INTO szgk (tipus, modell, rendszam, ajtok_szama, gyartas_eve)
VALUES('Opel', 'Corsa C', 'AAA123', 4, '2002-10-03');
INSERT INTO szgk (tipus, modell, rendszam, ajtok_szama, gyartas_eve)
VALUES('Toyota', 'Corsa F', 'ABC123', 5, '2002-10-05'); 
INSERT INTO szgk (tipus, modell, rendszam, ajtok_szama, gyartas_eve)
VALUES('Renault', 'Corsa G', 'ABA123', 3, '2002-10-06'); 
INSERT INTO szgk (tipus, modell, rendszam, ajtok_szama, gyartas_eve)
VALUES('Lada', 'Corsa K', 'AAB123', 4, '2002-10-07'); 

INSERT INTO tulajdonosok (tulaj_id, vezeteknev, keresztnev, szgk_id)
VALUES (4, 'Pap', 'Gergely', 3);
INSERT INTO tulajdonosok (tulaj_id, vezeteknev, keresztnev, szgk_id)
VALUES (7, 'Mayer', 'Hedda', 2);
INSERT INTO tulajdonosok (tulaj_id, vezeteknev, keresztnev, szgk_id)
VALUES (11, 'Papp', 'Tamás', 4);



DROP DATABASE IF EXISTS kutyamenhely;
CREATE DATABASE kutyamenhely;
USE kutyamenhely;

DROP TABLE IF EXISTS kutyák;
CREATE TABLE kutyák (
	kutya_id INT PRIMARY KEY AUTO_INCREMENT,
	nev VARCHAR(20) NOT NULL,
	kor INT CHECK (kor <= 30),
	nem VARCHAR(5) DEFAULT 'kan',
	megjegyzes VARCHAR(500)
);

DROP TABLE IF EXISTS gazdák;
CREATE TABLE gazdák (
	gazda_id INT PRIMARY KEY,
	nev VARCHAR(30),
	kor INT,
	kutya_id INT,
	CONSTRAINT FK_kutya_gazda FOREIGN KEY (kutya_id) REFERENCES kutyák (kutya_id)
);

INSERT INTO kutyák (nev, kor, nem, megjegyzes)
VALUES ('Bogyó', 2, 'szuka', 'szeret futkározni');
INSERT INTO kutyák (nev, kor, megjegyzes)
VALUES ('Káosz', 7, 'imádja a társaságot');
INSERT INTO kutyák (nev, kor, megjegyzes)
VALUES ('Artúr', 2, 'örömpisi');
INSERT INTO kutyák (nev, megjegyzes)
VALUES ('Álmos', 'nem mozog sokat');

INSERT INTO gazdák (gazda_id, nev, kor, kutya_id)
VALUES (2, 'Pap Gergely', 18, 2);
INSERT INTO gazdák (gazda_id, nev, kor, kutya_id)
VALUES (7, 'Mayer Mihály', 53, 3);
INSERT INTO gazdák (gazda_id, nev, kor, kutya_id)
VALUES (14, 'Mayer Hedda', 19, 1);