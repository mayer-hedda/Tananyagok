'''
A program generáljon 5 egész számot [0;10] intervallumon, tárolja egy halmazban.
A felhasználónak meg kell próbálni kitalálni ezeket, olyan módon, hogy megad 5 számot, melyeket szintén halmazban tárol a gép.
A program tájékoztassa a felhasználót, a következőkről:
    hány darab számot talált el, és melyek ezek;
    hány számot nem talált el, és melyek ezek;
    mely számok kerültek rögzítésre a generálás vagy a felhasználó miatt;
    mely számok nem szerepeltek egyik halmazban sem!
'''
from random import randint

veletlen_szamok = set()
while len(veletlen_szamok) != 5:
    randomszam = randint(0, 10)
    veletlen_szamok.add(randomszam)
print(veletlen_szamok)

bekert_szamok = []
while len(bekert_szamok) != 5:
    bekeres = int(input('Adjon meg egy egész számot 0 és 10 között: '))
    bekert_szamok.append(bekeres)
bekert_szamok = set(bekert_szamok)

if len(veletlen_szamok & bekert_szamok) != 0:
    print(f'\n{len(veletlen_szamok & bekert_szamok)} számot eltalált, ezek a következők:', ', '.join(str(szam) for szam in (veletlen_szamok & bekert_szamok)))
else:
    print('Nem talált el egy számot sem!')

if len(veletlen_szamok - bekert_szamok) != 0:
    print(f'{len(veletlen_szamok - bekert_szamok)} számot nem talált el, ezek a következők:', ', '.join(str(szam) for szam in (veletlen_szamok - bekert_szamok)))
else:
    print('Nincs olyan szám, amit nem talált el.')

print('Ezek a számok kerültek rögzítésre a generálás vagy a felhasználó által:', ', '.join(str(szam) for szam in (veletlen_szamok | bekert_szamok)))

osszes_szam = [szam for szam in range(11)]
osszes_szam = set(osszes_szam)

print('A következő számok nem szerepeltek sem a generálásban, sem a felhasználó által megadott számok között:', ', '.join(str(szam) for szam in (osszes_szam - (veletlen_szamok | bekert_szamok))))
