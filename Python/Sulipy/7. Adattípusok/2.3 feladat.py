'''
Írj egy programot, amely szótárban tárol adatokat (legalább egy int, str, és bool típusút). A program a írja ki a képernyőre az adatszerkezet!
A felhasználónak legyen lehetősége ezt az adatszerkezetet egy kulcs-érték párral bővítenie. A program végül írja ki a képernyőre a frissített adatszerkezetet!

Módosítsd úgy a programot, hogy a felhasználónak többször is legyen lehetősége bővíteni az adatszerkezetet!
'''
adatok = {
    'kedvenc szám': 4,
    'kedvenc tantárgy': 'matek',
    'matek szakkör': True
}

print(adatok)

while True:
    menu = input('Adja meg a választott menüpont sorszámát!\n\t1. Adatszerkezet bővítése\n\t2. Kilépés a programból\nVálasz: ').strip('.')
    if menu == '1':
        print('Adja meg az hozzáadni kívánt adat:')
        kulcs = input('\tCímét: ')
        ertek = input('\tÉrtékét: ')
        if ertek == 'True' or ertek == 'False':
            ertek = bool(ertek)
        elif int(ertek) % 1 == 0:
            ertek = int(ertek)
        elif float(ertek) % 0.0000001 == 0:
            ertek = float(ertek)
        adatok[kulcs] = ertek

    elif menu == '2':
        break

print(adatok)