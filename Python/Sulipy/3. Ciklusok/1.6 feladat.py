'''
Írj egy programot, amely [1;12] intervallumon állít elő 20 darab véletlenszámot!
A képernyőre kizárólag csak a 3-mal oszthatóakat írja ki,
és a végén informálja a felhasználót arról is, hány darab ilyen szám volt.
'''
from random import randint

szamlalo = 1
while szamlalo <= 20:
    veletlen_szam = randint(1, 12)
    if veletlen_szam % 3 == 0:
        print(veletlen_szam)
    szamlalo += 1