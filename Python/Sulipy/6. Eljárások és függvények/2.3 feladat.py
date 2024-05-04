'''
Írj egy programot, amely tartalmaz egy 'harommal_oszthatok' nevű függvényt,
amely a paraméterként átvett listában megvizsgálja,
hogy hány darab hárommal osztható szám van, és ezzel az értékkel tér vissza!
A program tartalmazza a függvény hívását is!

Alakítsd át az előző programot úgy,
hogy a felhasználó által megadott számokat tárolja el a program egy listában,
és ezt értékelje ki a függvény!
(Az adatbeolvasás addig tartson, míg a felhasználó negatív számot nem ad meg!)
'''
def harommal_oszthatok(lista):
    darab = 0
    for elem in lista:
        if elem % 3 == 0:
            darab += 1
    return darab

szamok = []
while True:
    szam = int(input('Adjon meg egy számot: '))
    if szam < 0:
        break
    else:
        szamok.append(szam)

print(f'A listában {harommal_oszthatok(szamok)} db 3-mal osztható szám található.')