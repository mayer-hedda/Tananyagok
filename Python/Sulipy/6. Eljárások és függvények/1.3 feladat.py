'''
Írj eljárást, amely paraméterül kapott 2 számot összehasonlít,
és a képernyőre kiírja, melyik a nagyobb szám! Kezeld azt az esetet is, ha a két szám egyenlő!
'''
def osszehasonlitas(szam1, szam2):
    if szam1 > szam2:
        print(f'Az első szám, ami {szam1} nagyobb, mint a második, ami {szam2}.')
    elif szam2 > szam1:
        print(f'A második szám, ami {szam2} nagyobb, mint az első, ami {szam1}.')
    else:
        print('A két szám egyenlő.')

osszehasonlitas(1, 9)
osszehasonlitas(7, 2)
osszehasonlitas(4, 4)