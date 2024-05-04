'''
A mellékelt ZIP állományban találsz egy forrásfájlt (autok_lista.txt), amely tartalmazza egy autószerelő műhelyben lévő autók adatait.
Az adatok sorrendben a következők: rendszám, márka, típus, életkor, 0 = még nincs megjavítva 1 = megjavított, javítás költsége.
A muhely.py nevű fájlban lévő program pedig beolvassa ezeket az adatokat és eltárolja egy szótárakat tartalmazó listában.

Folytatsd a muhely.py programot az alábbiak szerint!
    1. A program írja ki a képernyőre a legöregebb autó rendszámát, márkáját, típusát és korát! (Csak egy ilyen van!)
    2. A program írja ki a képernyőre a már megjavított autók rendszámát!
    3. A program számolja ki, és írja ki a képernyőre az egy autóra eső átlagos szervízköltséget!
    4. A program kérjen be egy rendszámot, vizsgálja meg és tájékoztassa a felhasználót, hogy az adott rendszámú autó a műhelyben van-e.
    5. A program kérjen be egy betűt, vizsgálja meg és tájékoztassa a felhasználót, hogy van-e a műhelyben olyan autó,
       amelynek a márkája vagy a típusa tartalmazza az adott betűt! A kis- és nagybetűket ne különböztesse meg a program!
'''
adatok = []
with open('3.2 feladat.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adatok.append(sor.strip())

autok = []
for adat in adatok:
    auto_adatai = adat.split()
    auto = {
        'rendszám': auto_adatai[0],
        'márka': auto_adatai[1],
        'típus': auto_adatai[2],
        'életkor': int(auto_adatai[3]),
        'javítva': bool(int(auto_adatai[4])),
        'javítás költsége': int(auto_adatai[5])
    }
    autok.append(auto)

for auto in autok:
    print(auto)

'''
------------- 1. feladat -------------
A legöregebb autó: JTZ-774, Ford Fiesta, 25 éves.
'''
print('\n------------- 1. feladat -------------')

legoregebb = autok[0]
for auto in autok:
    if auto['életkor'] > legoregebb['életkor']:
        legoregebb = auto

print(f'A legöregebb autó: {legoregebb["rendszám"]}, {legoregebb["márka"]} {legoregebb["típus"]}, {legoregebb["életkor"]} éves.')



'''
------------- 2. feladat -------------
A már megjavított autók rendszáma:
TRU-234
OPO-223
ETW-231
SSA-772
GGT-434
'''
print('\n------------- 2. feladat -------------')

print('A már javított autók rendszáma: ')
for auto in autok:
    if auto['javítva'] == True:
        print(auto['rendszám'])



'''
------------- 3. feladat -------------
Az egy autóra jutó átlagos javítási költség: 55425 Ft.
'''
print('\n------------- 3. feladat -------------')

osszesen = 0
for auto in autok:
    osszesen += auto['javítás költsége']

atlag = osszesen / len(autok)

print(f'Az egy autóra jutó átlagos javítási költség: {atlag:.0f} Ft.')




'''
------------- 4. feladat -------------
Adjon meg egy rendszámot (pl. ABC-123)!  SSA-772
A megadott rendszámú autó a műhelyben van.
'''
print('\n------------- 4. feladat -------------')

bekert_rendszam = input('Adjon meg egy rendszámot (pl. ABC-123)!  ')

rendszamok = []
for auto in autok:
    rendszamok.append(auto['rendszám'])

if bekert_rendszam in rendszamok:
    print('A megadott rendszámú autó a műhelyben van.')
else:
    print('A megadott rendszámú autó nincs a műhelyben.')




'''
------------- 5. feladat -------------
Adjon meg egy betűt!    X
A megadott betű az alábbi autók márka- vagy típusmegnevezésében fordul elő:
Ford C-Max
'''
print('\n------------- 5. feladat -------------')

betu = input('Adjon meg egy betűt!    ')

elofordulas = []
for auto in autok:
    if betu.lower() in (auto['márka']).lower() or betu.lower() in (auto['típus']).lower():
        elofordulas.append(f'{auto["márka"]} {auto["típus"]}')

if len(elofordulas) > 0:
    print('A megadott betű az alábbi autók márka- vagy típusmegnevezésében fordul elő:')
    print('\n'.join(elofordulas))
else:
    print('A megadott betű az alábbi autók márka- vagy típusmegnevezésében nem fordul elő:')