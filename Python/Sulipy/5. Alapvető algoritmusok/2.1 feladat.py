'''
Írj egy programot, amely 5 darab véletlenszámot generál [1;7] intervallumon,
és ezeket eltárolja egy listában. Kérjen be a felhasználótól egy számot,
és vizsgálja meg, hogy ez előfordul-e a listában!
Az eredményről tájékoztassa a felhasználót,
és írja ki a lista elemeit a képernyőre!
'''
from random import randint

veletlen_szamok = []

while len(veletlen_szamok) != 5:
    randomszam = randint(1, 7)
    veletlen_szamok.append(randomszam)

bekert_szam = int(input('Adjon meg egy számot 1 és 7 között: '))

if bekert_szam in veletlen_szamok:
    print('Az Ön által megadott szám szerepel a listában.\nA lista tartalma: ', ', '.join(str(szam) for szam in veletlen_szamok))
else:
    print('Az Ön által megadott szám nem szerepel a listában.\nA lista tartalma: ', ', '.join(str(szam) for szam in veletlen_szamok))