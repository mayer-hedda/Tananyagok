# -----ELDÖNTÉS-----
'''
Az ELDÖNTÉS esetében azt vizsgáljuk,
hogy szerepel-e egy bizonyos tulajdonságú elem az adatsorban (itt a listában).
A program azt vizsgálja, hogy van-e hárommal osztható szám a listában.

A listát bejárhattuk volna egy for ciklus segítségével is természetesen,
de felesleges végighaladnunk az összes elemen. A fenti program amint megtatálja az első olyan elemet,
amely megfelel a feltételeknek, befejezi a lista átvizsgálását.
Hiszen ha már találtunk egy ilyen elemet, megvan a válasz.
'''

szamok = [2, 5, 4, 8, 9, 11, 10, 12]

talalat = False
index = 0
while index < len(szamok) and not talalat:
    if szamok[index] % 3 == 0:
        talalat = True
    index += 1

if talalat:
    print('Van a listában hárommal osztható szám.')
else:
    print('Nincs a listában hárommal osztható szám.')



# -----KERESÉS-----
'''
Az KERESÉS esetében azt vizsgáljuk, 
hogy szerepel-e egy bizonyos tulajdonságú elem az adatsorban (itt a listában),
és ha igen, hányadik helyen.
A program azt vizsgálja, hogy szerepel-e hárommal osztható szám a listában, és ha igen, hányadik helyen.

Gondold végig! Miért kell találat esetén az index meghatározásánál, 
az 'index' nevű változó értékéből egyet levonnunk ahhoz, hogy helyes eredményt kapjunk? 
'''

szamok = [2, 5, 4, 8, 9, 11, 10, 12]

talalat = False
index = 0
while index < len(szamok) and not talalat:
    if szamok[index] % 3 == 0:
        talalat = True
    index += 1

if talalat:
    print(f'Van a listában hárommal osztható szám, az indexe: {index-1}')
else:
    print('Nincs a listában hárommal osztható szám.')



# -----KIVÁLASZTÁS-----
'''
A KIVÁLASZTÁS esetében azt tudjuk, hogy szerepel (legalább) egy bizonyos tulajdonságú elem 
az adatsorban (itt a listában), és ennek az elemnek az indexére vagyunk kíváncsiak.
A program azt vizsgálja, hogy hányadik indexű helyen áll a hárommal osztható szám a listában. 
Az első ilyen elem előfordulása érdekel bennünket.

Ez az algoritmus csak akkor használható, ha biztosak lehetünk benne, 
hogy szerepel legalább egy darab megadott tulajdonságú elem a listában, különben túlindexelési hibát kapunk. 
'''

szamok = [2, 5, 4, 8, 9, 11, 10, 12]

talalat = False
index = 0
while not talalat:
    if szamok[index] % 3 == 0:
        talalat = True
    index += 1

print(f'A hárommal osztható szám indexe: {index-1}')
