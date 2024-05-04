'''
Írj egy programot, amelyben könyvek adatait (szerző, cím) tudja rögzíteni a felhasználó.
A könyvek adatainak tárolására használjon a program szótárakat, amelyek egy lista elemei legyenek!
Az adatbekérés addig folytatódjon, amíg a felhasználó a szerző megadásakor nem gépel be adatot, csupán ENTER-t üt!
A program ekkor listázza ki a már bevitt adatokat, és fejezze be a működését!
'''
konyvek = []

while True:
    kulcs = input('Adja meg a könyv szerzőjét: ')
    ertek = input('Adja meg a könyv címét: ')

    if kulcs == '' or ertek == '':
        break
    else:
        konyv = {}
        konyv['szerző'] = kulcs
        konyv['cím'] = ertek
        konyvek.append(konyv)

print('Könyvek: ')
for konyv in konyvek:
    print(f"\t{konyv['szerző']} - {konyv['cím']}")