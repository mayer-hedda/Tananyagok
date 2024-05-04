SELECT * FROM Customers;  -- A Customers nevű tábla összes elemének megjelenítése
SELECT CustomerName FROM Customers;  -- A CustomerName nevű oszlop adatainak megjelenítése a Customers táblán belül
SELECT CustomerName, Address FROM Customers;  -- A CustomerName és az Address nev

SELECT City FROM Customers;  -- A City nevű oszlop adatainak megjelenítése a Customers táblán belül
SELECT DISTINCT City FROM Customers;  -- A City nevű oszlop adatainak ismétlés nélküli megjelenítése a Customers táblán belül

SELECT * FROM Customers WHERE Country = 'Mexico';  -- Minden olyan elem megjelenítés a Customers táblán belül, aminek a Country oszlopának az eleme megegyezik 'Mexico'-val
SELECT * FROM Customers WHERE CustomerID = 1;  -- Minden olyan elem megjelenítése a Customers táblán belül, aminek a CustomerID oszlopának az eleme megegyezik 1-gyel

-- Több sorban is írhatunk:
SELECT *
FROM Customers
WHERE ChustomerID = 1;


SELECT * FROM Products WHERE Price = 18;  -- A Products nevű tábla összes elemének megjelenítése, ha a Price oszlop eleme egyenlő 0-val
SELECT * FROM Products WHERE Price > 30;  -- A Products nevű tábla összes elemének megjelenítése, ha a Price oszlop eleme nagyobb, mint 30
SELECT * FROM Products WHERE Price >= 30;  -- A Products nevű tábla összes elemének megjelenítée, ha a Price oszlop eleme nagyobb vagy egyenlő, mint 30
SELECT * FROM Products WHERE Price <> 18;  -- A Products nevű tábla összes elemének megjelenítése, ha a Price oszlop elem nem egyenlő 18-cal
SELECT * FROM Products WHERE Price BETWEEN 50 AND 60;  -- A Products nevű tábla összes elemének megjelenítése, ha a Price oszlop eleme 50 és 60 közé esik (zárt intervallumon)
SELECT * FROM Customers WHERE City LIKE 's%';  -- A Customers nevű tábla összes elemének megjelenítése, ha a City oszlop eleme 's' betűvel kezdődik
SELECT * FROM Customers WHERE City IN ('Paris', 'London')  -- A Customers nevű tábla összes elemének megjelenítése, ha a City oszlop eleme 'Paris' vagy 'London'





--- FELADATOK ---: 

SELECT * FROM Categories;
SELECT CategoryName FROM Categories;
SELECT CategoryName, Description FROM Categories;

SELECT ProductName, Unit, Price FROM Products;
SELECT ProductName, Price FROM Products WHERE Price < 20;
SELECT ProductName, Price FROM Products BETWEEN 20 AND 30;
SELECT ProductName, Price FROM Products WHERE Price <> 10;
SELECT ProductName FROM Products LIKE 'T%';
SELECT ProductName FROM Products LIKE 'Louisiana%';

SELECT DISTINCT City FROM Suppliers;