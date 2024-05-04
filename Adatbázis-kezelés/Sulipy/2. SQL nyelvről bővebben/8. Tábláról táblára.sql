USE top2000;

SELECT dalok.cim, eloadok.nev
FROM dalok, eloadok
WHERE dalok.eloadoid = eloadok.eloadoid AND eloadok.nev = 'Queen';
