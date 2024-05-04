'''
Írj eljárást, amely paraméterül kapott számról eldönti, és a képernyőre kiírja, hogy negatív, pozitív vagy nulla-e!
'''
def negativ_pozitiv(szam):
    if szam < 0:
        print('A szám negatív.')
    elif szam > 0:
        print('A szám pozitív.')
    else:
        print('A szám nulla.')
        
negativ_pozitiv(4)
negativ_pozitiv(0)
negativ_pozitiv(-9)