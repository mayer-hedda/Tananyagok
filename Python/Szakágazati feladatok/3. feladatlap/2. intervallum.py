from random import randint

veletlen_szamok = set()
while len(veletlen_szamok) != 10:
    randomszam = randint(-50, 50)
    veletlen_szamok.add(randomszam)

veletlen_szamok = list(veletlen_szamok)
print(veletlen_szamok)

legkisebb_paros = max(veletlen_szamok)
legnagyobb_paratlan = min(veletlen_szamok)
for szam in veletlen_szamok:
    if szam < legkisebb_paros and szam % 2 == 0:
        legkisebb_paros = szam
    if szam > legnagyobb_paratlan and szam % 2 != 0:
        legnagyobb_paratlan = szam

if legkisebb_paros % 2 == 0:
    print(f'A legkisebb páros szám: {legkisebb_paros}')
else:
    print(f'Nincsen páros szám a listában.')

if legnagyobb_paratlan % 2 != 0:
    print(f'A legnagyobb páratlan szám: {legnagyobb_paratlan}')
else:
    print('Nincsen páratlan szám a listában.')

novekvo_szamok = veletlen_szamok.copy()
novekvo_szamok.sort()
print(novekvo_szamok)