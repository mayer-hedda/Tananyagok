'''
A mellékelt fájl néhány ismert programozási nyelv adatát tartalmazza. Olvasd be a fájl tartalmát és tárold el
a, egy listában, melynek elemei szótárak,
b, egy kétdimenziós listában!
mind a két esetben az évszám int típusként kerüljön rögzítésre!
'''
from pprint import pp

programozasi_nyelvek = []
with open('1.1 feladat.txt', 'r', encoding='utf-8') as fajl:
    next(fajl)
    next(fajl)
    for sor in fajl:
        adat = sor.strip().split(';')
        nyelv = {
            'év': int(adat[0]),
            'programozási nyelv': adat[1],
            'első név': adat[2],
            'fejlesztő neve': adat[3]
        }
        programozasi_nyelvek.append(nyelv)

pp(programozasi_nyelvek)
print('\n\n')



programozasi_nyelvek = []
with open('1.1 feladat.txt', 'r', encoding='utf-8') as fajl:
    next(fajl)
    next(fajl)
    for sor in fajl:
        adat = sor.strip().split(';')
        adat[0] = int(adat[0])
        programozasi_nyelvek.append(adat)

pp(programozasi_nyelvek)
