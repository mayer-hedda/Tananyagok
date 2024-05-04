'''
A mellékelt fájl néhány ismert programozási nyelv adatát tartalmazza. Olvasd be a fájl tartalmát,
és másold át azt egy fájlba úgy, hogy abba már csak a nyelv és az évszám kerüljön!
'''
with open('2.1 feladat.txt', 'r', encoding='utf-8') as fajl:
    with open('2.1 feladat másolat.txt', 'w', encoding='utf-8') as masolat:
        next(fajl)
        for sor in fajl:
            sor = sor.split(';')
            masolat.write(f'{sor[0]};{sor[1]}\n')