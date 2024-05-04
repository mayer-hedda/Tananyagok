'''
A program generáljon 10 darab véletlenszámot [0;50] intervallumon, de csak a 4-gyel oszthatóakat rögzítse egy listában.
A végén jelenítse meg a listát a képernyőn, és írja ki azt is, hány elemből áll a lista.
'''
from random import randint
veletlen_szamok = []

while len(veletlen_szamok) != 10:
    randomszam = randint(0, 50)
    veletlen_szamok.append(randomszam)

neggyel_oszthato_szamok = []
for szam in veletlen_szamok:
    if szam % 4 == 0:
        neggyel_oszthato_szamok.append(szam)

print(f'A lista elemei: {neggyel_oszthato_szamok}\nA lista {len(neggyel_oszthato_szamok)} elemből áll.')