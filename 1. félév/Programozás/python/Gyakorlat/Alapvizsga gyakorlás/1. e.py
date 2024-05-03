'''
Írj egy Python programot, amely bekér három számot a felhasználótól és kiírja a
képernyőre, hogy a számok közül bármelyik kettőnek az összege egyenlő-e a
harmadik számmal!
'''
szamok = []
for i in range(3):
    szam = int(input(f'Adja meg a(z) {i + 1}. számot: '))
    szamok.append(szam)

feltetel = szamok[0] + szamok[1] == szamok[2] or szamok[0] + szamok[2] == szamok[1] or szamok[2] + szamok[1] == szamok[0]
if feltetel:
    print('A három szám közül valamelyik kettőnek az összege egyenlő a harmadikkal.')
else:
    print('A három szám közül egyik kettőnek az összege sem egyenlő a harmadikkal.')