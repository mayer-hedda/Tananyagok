'''
A mellékelt fájl néhány sorozat adásba kerülésének dátumát, a sorozat angol címét, az évadot és az epizód számát,
az epizód hosszát percben és egy jelzést tartalmaz, hogy a lista készítője megnézte-e már azt az epizódot.
Ezek az adatok egymás után külön sorokban szerepelnek.

Készíts egy programot amely beolvassa a fájlban tárolt adatokat egy szótárba.
A szótárnak egyetlen kulcs-érték párja legyen, a kulcs a 'sorozatok' tartalmú sztring,
az ehhez rendelt érték pedig egy lista. Ezen lsitának az elemei legyenek szótárak,
amelyek tartalmazzák az egyes epizódokra vonatkozó adatokat az alábbiak szerint.
A program a beolvasott, majd szótár típusba mentett adatokat írja ki egy JSON fájlba!
'''
import json

adatok =  {'sorozatok': []}
with open('3.1 feladat.txt', 'r', encoding='utf-8') as fajl:
    adat = []
    for sor in fajl:
        sor = sor.strip()
        adat.append(sor)
        if len(adat) == 5:
            sorozat = {
                'datum': adat[0],
                'sorozat': adat[1],
                'epizod': adat[2],
                'hossz': int(adat[3]),
                'latta': bool(int(adat[4]))
            }
            adatok['sorozatok'].append(sorozat)
            adat = []

for adat in adatok['sorozatok']:
    print(adat)

with open('3.1 feladat.json', 'w', encoding='utf-8') as fajl:
    json.dump(adatok, fajl, indent=4)