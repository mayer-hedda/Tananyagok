'''
Készíts egy programot,
amely [1;10] intervallumon generál 5 darab véletlen egész számot,
és ezeket tárolja el egy listában! A program adja össze a lista elemeit,
írja ki a képernyőre az összegüket és a lista elemeit!

Módosítsd úgy a fenti programot,
hogy a program csak a páros számokat adja össze!
'''
from random import randint

veletlen_szamok = []

while len(veletlen_szamok) != 5:
    randomszam = randint(1, 10)
    veletlen_szamok.append(randomszam)

osszeg = 0
for szamok in veletlen_szamok:
    osszeg += szamok

print(f'A lista elemeinek az összege: {osszeg}')
print('A lista elemei: ', ', '.join(str(szam) for szam in veletlen_szamok))
