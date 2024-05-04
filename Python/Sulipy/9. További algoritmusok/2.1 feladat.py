'''
Az alábbi sorokat másold be egy .txt kiterjesztésű fájlba!
    Készíts egy programot, amely ezen forrásfájlban szereplő adatokat beolvassa és eltárolja!
    A program válogassa ki egy külön listába, a raktáron lévő bútorokat, majd jelenítse meg a lista tartalmát!
'''
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

raktaron = [adat for adat in adatok if adat['raktaron'] == 'igen']
for butor in raktaron:
    print(butor)