USE Northwind;  -- Kiválasztom az egyik adatbázist
DESCRIBE products;  -- Kiválasztom annak az egyik tábláját

SELECT MIN(list_price) AS Legolcsóbb FROM products;  -- Kiíratom a legkisebb értékét a list_price oszlopnak Legolcsóbb néven
SELECT * FROM products ORDER BY list_price;  -- Leellenőrzöm egy másik metódus segítségével, hogy helyes eredményt kaptam-e

SELECT MAX(list_price) AS Legdrágább FROM products;  -- Kiíratom a legnagyobb értékét a list_price oszlopnak Legdrágább néven
SELECT * FROM products ORDER BY list_products DESC;  -- Leellenőrzöm, hogy helyes értéket kaptam-e

SELECT COUNT(id) FROM products;  -- Megszámlálja, hogy mennyi olyan elem van a megadott oszlopban, aminek az értéke nem NULL
SELECT * FROM products;  -- Ezzel leellenőrzöm, hogy megfelelő értéket kaptam-e

SELECT COUNT(description) FROM products;
SELECT * FROM products WHERE description IS NOT NULL;

SELECT COUNT(id) FROM products WHERE list_price = 1.2;
SELECT * FROM products ORDER BY list_price;

SELECT SUM(list_price) FROM products WHERE id < 4;  -- Összegezzük a megadott oszlop elemeit, ha azok megfelelnek a feltételnek
SELECT * FROM products WHERE id < 4;  -- Leellenőzizzük

SELECT AVG(list_price) FROM products WHERE id < 4;  -- Kiszámítjuk az adott oszlopban szereplő elemek átlagát, amik megfelelnek a feltételnek
SELECT * FROM products WHERE id < 4;  -- Ellenőrizzük





--- FELADATOK: ---

USE northwind;

SELECT AVG(standard_cost) AS Átlag FROM products;
SELECT AVG(standard_cost) AS Átlag_2 FROM products WHERE list_price < 30;
SELECT AVG(standard_cost) AS Átlag_3 FROM products WHERE category = "Sauces";

SELECT SUM(standard_cost) AS Összesen FROM products;
SELECT SUM(standard_cost) AS Összesen_2 FROM products WHERE list_price BETWEEN 20 AND 50;
SELECT SUM(standard_cost) AS Összesen_3 FROM products WHERE NOT category <> "Sauces";

SELECT COUNT(id) AS Számláló FROM employees WHERE city = "Seattle";
SELECT COUNT(id) AS Számláló_2 FROM employees WHERE job_title = "Sales Representative";
SELECT COUNT(id) AS Számláló_3 FROM employees WHERE first_name LIKE 'A%';

SELECT MIN(standard_cost) AS Legkisebb FROM products;
SELECT MAX(standard_cost) AS Legnagyobb FROM products;
SELECT MIN(standard_cost) AS Legkisebb_2 FROM products WHERE list_price >= 30;
SELECT MAX(standard_cost) AS Legnagyobb_2 FROM products WHERE product_code LIKE '%CO%';
SELECT * FROM products WHERE product_code LIKE '%CO%' ORDER BY standard_cost;
