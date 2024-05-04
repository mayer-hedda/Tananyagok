INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)  -- A Customers táblában megadom a következő oszlop neveket (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('WebDev', 'Péter Nagy', 'Fő u. 12.', 'Veszprém', '8200', 'Hungary');  -- És a megadott értékeket állítom be hozzájuk és így megadok egy új sort a táblába (utolsó sorba teszi be)

INSERT INTO Customers (CustomerName, City, Country)  -- A Customers táblában megadom az oszlop neveket
VALUES ('WebDev', 'Veszprém', 'Hungary'); -- És a hozzájuk tartozó értéket (Amelyik oszlopnak nem adok értéket, az NULL értéket vesz fel)





--- FELADATOK: ---

INSERT INTO Categories (CategoryName, Description)
VALUES ('tejtermékek', 'tej, sajt, tejföl');

INSERT INTO Categories (CategoryName)
VALUES ('saláták');

SELECT * FROM Categories WHERE Description IS NULL;