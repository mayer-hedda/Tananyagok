szamok = [3, 7, 1, 5, 19, 11, 41, 13, 17, 59, 47, 23, 43, 31, 37, 29, 53]
szamok.sort()

keresendo = 37
szam = szamok[0]

fele = int(len(szamok)/2 if len(szamok)/2 % 1 == 0 else len(szamok)/2 - 0.5)
print(fele)

lepes = 0
while szam != keresendo:
    print(f'{lepes+1}. lépés: ')
    szam = szamok[fele]

    print(f'Jelenlegi szám: {szam}')
    print(f'Keresendő: {keresendo}')
    print(f'Talált: {"Igen" if keresendo == szam else "Nem"}')
    print(f'Számok: {szamok}\n')

    if szam > keresendo:
        szamok = szamok[:fele-1]
    else:
        szamok = szamok[fele+1:]

    fele = int(len(szamok)/2 if len(szamok)/2 % 1 == 0 else len(szamok)/2 - 0.5)

    lepes += 1