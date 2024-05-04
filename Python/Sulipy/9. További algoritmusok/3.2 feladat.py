'''
Az előző lecke 1. feladatában szereplő adatokat olvassa be a program,
és tárolja el egy olyan listában, amelynek az elemei szótárak.
Ár szerint rendezve jelenítse meg az egyes árucikkek jellemzőit!
A rendezéshez használj egy arat_visszaad() nevű függvényt!

Alakítsd át az előző programot úgy, hogy a rendezéshez lambda függvényt haszáljon!
'''
def arat_visszaad(adat):
    return adat['ar']


adatok = []
with open('2.1 feladat.txt', 'r', encoding='utf-8') as fajl:
    next(fajl)
    for sor in fajl:
        sor = sor.strip().split(';')
        adat = {
            'tipus': sor[0],
            'butor': sor[1],
            'osztaly': sor[2],
            'ar': int(sor[3]),
            'raktaron': sor[4]
        }
        adatok.append(adat)

# adatok.sort(key=arat_visszaad)
# for adat in adatok:
#     print(adat)

adatok.sort(key=lambda adat: adat['ar'])
for adat in adatok:
    print(adat)