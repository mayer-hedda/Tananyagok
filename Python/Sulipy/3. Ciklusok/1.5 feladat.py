'''
Írj egy programot, amely a felhasználótól páros számot kér be.
Amennyiben a megadott szám páratlan, újra és újra megtörténik az adatbekérés mindaddig,
amíg végül páros számot nem ad meg a felhasználó.
'''
paros_szam = int(input('Adjon meg egy páros számot: '))

while True:
    if paros_szam % 2 == 0:
        break
    else:
        paros_szam = int(input('Ez nem egy páros szám! Adjon meg egy páros számot: '))
