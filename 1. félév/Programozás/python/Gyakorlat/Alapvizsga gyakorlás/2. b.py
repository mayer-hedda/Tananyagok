'''
Írj egy Python programot, amely a szamok.txt fájlba írja a 100 legkisebb 3-mal
osztható pozitív egész számot!
'''
szamok = []
szam = 1
while len(szamok) != 100:
    if szam % 3 == 0:
        szamok.append(szam)
    szam += 1

with open('szamok.txt', 'w', encoding='utf-8') as fajl:
    for szam in szamok:
        print(szam, file=fajl)