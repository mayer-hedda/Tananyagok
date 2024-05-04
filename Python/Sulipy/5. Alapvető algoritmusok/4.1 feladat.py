'''
Készíts egy programot, amely a felhasználótól számokat kér be mindaddig, amíg az csupán ENTER-t nem üt!
A számokat tárolja el a program egy listában!
Az adatbekérés befejezte után írja ki a program a lista elemeit, a legkisebb és a legnagyobb számot!

Alakítsd át úgy az előbbi programot, hogy az 'X' vagy 'x' megadása eredményezze az adatbekérés végét!

Alakítsd át úgy az előbbi programot, hogy a legkisebb és legnagyobb páros számot határozza meg!
'''
szamok = []

while True:
    szam = input('Adjon meg egy számot: ')
    if szam == 'X' or szam == 'x':
        break
    else:
        szam = int(szam)
        szamok.append(szam)

minimum = max(szamok)
maximum = min(szamok)
for szam in szamok:
    if szam < minimum and szam % 2 == 0:
        minimum = szam
    if szam > maximum and szam % 2 == 0:
        maximum = szam

if minimum % 2 == 0:
    print(f'A megadott számok közül a legkisebb: {minimum}')
if minimum % 2 == 0:
    print(f'A megadott számok közül a legnagyobb: {maximum}')
if minimum % 2 != 0 and maximum % 2 != 0:
    print('A megadott számok között nincsen páros.')