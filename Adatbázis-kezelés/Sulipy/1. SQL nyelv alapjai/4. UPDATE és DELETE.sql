UPDATE Customers  -- A Customers táblán hajtom végre a változtatást
SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'  -- A megadott oszlop a megadott értéket fogja felvenni
WHERE CustomerID = 1;  -- Ha az itt megadott oszlop eleme megegyezik az itt megadott értékkel

UPDATE Customers
SET ContactName = 'Juan';  -- Ha nem adok meg WHERE záradékot, akkor az összes sorban megváltoztatom a megadott oszlop elemét a megadott értékre


DELETE FROM Customers  -- A megadott táblából törlöm
WHERE CustomerName = 'Alfreds Futterkiste';  -- Az itt megadott oszlop elemét, ha az megegyezik a megadott értékkel

DELETE FROM Customers;  -- Ha nem adok meg WHERE záradékot, akkor a táblának minden sorát törölni fogja, így egy üres tábla fog maradni
