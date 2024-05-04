import os

if os.path.exists('1.0 Fájl tartalmának beolvasása.txt'):
    forrasfajl = open('1.0 Fájl tartalmának beolvasása.txt')



fajl = open('1.0 Fájl tartalmának beolvasása.txt')

fajl.close()



with open('1.0 Fájl tartalmának beolvasása.txt', 'r', encoding='utf-8') as forrfajl:
    # print(forrfajl.name, forrfajl.mode)       # kiírom a fájl nevét, és "módját" (pl "r", mint read)
    # print()

    # print(forrfajl.tell())                    # ellenőrzöm, hogy hol tart a "mutató"
    # print(forrfajl.readline())                # beolvasom a soron következő sort a fájlból (most az 1. sor)
    # forrfajl.seek(0)                          # visszaküldöm a "mutatót" egy bizonyos állásba

    # print(forrfajl.tell())
    # print(forrfajl.readline())
    # print(forrfajl.tell())

    # print(forrfajl.readlines())               # az összes sort beolvassa a fájlból és egy listába teszi őket
    # print(forrfajl.read())                    # az összes sor beolvasása a fájlból, egymás alatt jeleníti meg őket
    next(forrfajl)                              # kihagy egy sort
    for sor in forrfajl:                        # bejárjuk a fájlt egy for ciklus segítségével
        print(sor.strip())
print('\n')



autok = []
with open('1.0 Fájl tartalmának beolvasása.csv', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adatok = sor.strip().split(',')
        auto = {
            'rendszám': adatok[0],
            'típus': adatok[1],
            'kor': int(adatok[2])
        }
        autok.append(auto)

print(f'Autók = {autok}')