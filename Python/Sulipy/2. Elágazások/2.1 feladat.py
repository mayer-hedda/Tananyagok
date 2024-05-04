'''
Készíts egy programot, amely a felhasználótól bekér egy egész számot,
majd megvizsgálja, hogy a megadott szám
    pozitív páros vagy
    negatív páratlan.
Az eredményről tájékoztatja a felhasználót.
'''
bekert_szam = int(input('Adj meg egy egész számot: '))

if bekert_szam > 0 and bekert_szam % 2 == 0:
    print('Ez a szám pozitív és páros.')
elif bekert_szam < 0 and bekert_szam % 2 != 0:
    print('Ez a szám negatív és páratlan.')