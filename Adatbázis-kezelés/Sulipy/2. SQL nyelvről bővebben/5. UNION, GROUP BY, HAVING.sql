SELECT City FROM Customers  -- Kiválasztom az egyik táblának az oszlopát/oszlopait
UNION  -- Amiket össze szeretnék fésülni ismétlés nélkül
SELECT City FROM Suppliers  -- Az itt kiválasztott tábla oszlopával/oszlopaival
ORDER BY City;  -- Illetve a City oszlop szerint sorbarendezem (ABC) 

SELECT City FROM Customers
UNION ALL  -- Itt ismétléssel fésülön össze a táblákat (egy elem többször is szerepelhet)
SELECT City FROM Suppliers
ORDER BY City;



SELECT City, Country FROM Customers  -- Kiválasztom az oszlopokat
WHERE Country = 'Germany'  -- Amik megfelelnek ennek a feltételnek
UNION  -- Ismétlés nélkül összefédülöm őket
SELECT City, Country FROM Suppliers  -- Az itt kiválasztott oszlopokkal
WHERE Country = 'Germany'  -- Amik megfelelnek ennek a feltételnek
ORDER BY City;  -- Végül a megadott oszlop szerint sorbarendezem

SELECT City, Country FROM Customers
WHERE Country = 'Germany'
UNION ALL  -- Itt ismétléssel fésülöm össze a táblákat
SELECT City, Country FROM Suppliers
WHERE Country = 'Germany'
ORDER BY City;



SELECT 'Customer' AS Type, ContactName, City, Country  -- Egy új oszlopot is létrehozok ideiglenesen, aminek a Type nevet adtam és ha az adatot ebből a listából szedi ki, akkor a 'Customer' felirat fog megjelenni
FROM Customers
UNION
SELECT 'Supplier', ContactName, City, Country  -- Ebben az esetben pedig a 'Supplier' felirat (itt már nem kötelező kiírni az 'AS Type' kifejezést)
FROM Suppliers;



SELECT COUNT(id), job_title  -- 2 oszlopot jelenítek meg 
FROM Customers  -- Az itt megadott táblából
GROUP BY job_title;  -- És az itt megadott oszlopon belüli elemek szerint fogja csoportosítani

SELECT COUNT(id), job_title
FROM Customers
GROUP BY job_title
ORDER BY COUNT(id) DESC;  -- Itt pedig még sorba is rendezi a megszámlált elemek alapján



SELECT COUNT(id), job_title
FROM Customers
GROUP BY job_title
HAVING COUNT(id) > 5;  --Itt kiegészítjük egy feltétellel az előbbieket

SELECT COUNT(id), job_title
FROM Customers
GROUP BY job_title
HAVING COUNT(id) > 5
ORDER BY COUNT(id) DESC;  -- Itt pedig még egy rendezési sorrendet is hozzáadunk





--- FELADATOK: ---

USE northwind;
SELECT ship_state_province
FROM orders
UNION
SELECT state_province
FROM customers;

USE northwind;
SELECT ship_state_province
FROM orders
UNION ALL
SELECT state_province
FROM customers;



USE northwind;
SELECT COUNT(id), category
FROM products
GROUP BY category;



USE northwind;
SELECT COUNT(id), ship_city
FROM orders
GROUP BY ship_city;



USE northwind;
SELECT COUNT(id), city
FROM customers
GROUP BY city
HAVING COUNT(id) >= 3;