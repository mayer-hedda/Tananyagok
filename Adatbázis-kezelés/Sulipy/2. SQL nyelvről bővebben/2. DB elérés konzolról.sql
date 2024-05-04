mysql -u root -p  -- Így lépek be cmd-ben az adatbázisok közé

SHOW DATABASES;  -- Ezzel listázom az adatbázisokat

SHOW TABLES;  -- Ezzel listázom a kiválasztott adatbázisnak a tábláit

DESCRIBE Customers;  -- Ezzel írom ki a megadott táblának a tulajdonágait

SELECT * FROM Customers LIMIT 5;  -- Ezzel megjelenítem a tábla első 5 elemét

USE Northwind;  -- Ezzel lépek be egy adatbázisba





--- FELADATOK: ---

mysql -u root -p
SHOW DATABASES;
USE Northwind;
SHOW TABLES;
DESCRIBE Customers;
SELECT * FROM Customers;
SELECT * FROM Customers LIMIT 10;