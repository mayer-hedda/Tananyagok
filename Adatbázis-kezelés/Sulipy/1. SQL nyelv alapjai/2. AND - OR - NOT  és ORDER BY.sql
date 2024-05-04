SELECT * FROM Customers
WHERE PostalCose LIKE '%3';  -- A Customers nevű tábla minden elem, amennyiben a PostalCode oszlop elemének az utolsó karaktere 3



SELECT * FROM Customers
WHERE Country = 'Germay' AND City = 'Berlin';  -- A customers nevű tábla minden eleme, amennyiben a Country megegyezik 'Germany'-val és a City megegyezik 'Berlin'-nel

SELECT * FROM Customers
WHERE City = 'Berlin' OR City = 'Stuttgart';  -- Ha a City vagy 'Berlin' vagy 'Stuttgart'

SELECT * FROM Customers
WHERE NOT Country = 'Germany';  -- Ha a Country nem 'Germany'

SELECT * FROM Customers
WHERE Country = 'Germany' AND (City = 'Berlin' OR City = 'Suttgart');  -- Ha a Country 'Germany' és a város vagy 'Berlin' vagy 'Stuttgart'



SELECT * FROM Customers
ORDER BY Country;  -- Minden elem a Country szerint sorbarendezve (ABC sorrend) 

SELECT * FROM Customers
ORDER BY Country DESC;  -- Minden elem a Country szerint fordított sorrendbe helyezve (ABC sorrend) 

SELECT * FROM Customers
ORDER BY Country, CustomerName;  -- Minden elem a Country szerint sorbarendezve azon belül a CustomerName szerint sorbarendezve

SELECT * FROM Customers
ORDER BY Country ASC, CustomerName DESC;  -- Minden elem a Country szerint sorbarendezve, azon belül a CustomerName szerint fordított sorrendbe rendezve





--- FELADATOK ---:

SELECT SupplierName, Country FROM Suppliers 
WHERE Country = 'USA' or Country = 'UK';

SELECT SupplierName, City FROM Suppliers 
WHERE Country = 'USA' AND (City = 'Boston' OR City = 'New Orleans');

SELECT SupplierName, Country FROM Suppliers 
WHERE Country = 'Japan' OR Country = 'Canada';


SELECT ProductName, Price FROM Products
ORDER BY Price;

SELECT ProductName, Price FROM Products
ORDER BY Price DESC;

SELECT ProductName, Unit FROM Products
ORDER BY ProductName, Unit DESC;