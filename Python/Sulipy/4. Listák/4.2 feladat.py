'''
A program generáljon 10 darab véletlenszámot [1;3] intervallumon,
ezeket tárolja egy listában, a lista tartalmát írja ki a képernyőre!
A felhasználónak legyen lehetősége megadni egy számot [1;3] intervallumon,
és a program törölje ennek a számnak valamennyi előfordulását a listából,
majd írja ki a módosított listát a képernyőre!
'''
from random import randint

veletlen_szamok = []

while len(veletlen_szamok) != 10:
    randomszam = randint(1, 3)
    veletlen_szamok.append(randomszam)

print(', '.join(str(szam) for szam in veletlen_szamok))

torlendo = int(input('Adjon meg egy számot 1 és 3 között, amit törölni kíván a listából: '))

veletlen_szamok.pop(torlendo)
print(', '.join(str(szam) for szam in veletlen_szamok))