'''
Készíts egy programot, amely [1;10] intervallumon generál 5 darab véletlen egész számot és ezeket tárolja el egy listában!
A program számolja össze, és képernyőre írja ki a listában tárolt páros számok számát, valamint a lista elemeit!
'''
from random import randint

veletlen_szamok = []

while len(veletlen_szamok) != 5:
    randomszam = randint(1, 10)
    veletlen_szamok.append(randomszam)

darab = 0
for szam in veletlen_szamok:
    if szam % 2 == 0:
        darab += 1

print(f'A listában tárolt páros számok száma: {darab}')
print('A lista elemei:', ', '.join(str(szam) for szam in veletlen_szamok))