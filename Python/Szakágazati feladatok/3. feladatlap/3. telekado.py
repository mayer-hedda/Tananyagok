# -----1. FELADAT-----

telkek = []
with open('utca.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adat = sor.strip().split()
        telek = {
            'azonosito': int(adat[0]),
            'utcanev': adat[1],
            'hazszam': adat[2],
            'adosav': adat[3],
            'alapterulet': int(adat[4])
        }
        telkek.append(telek)
for telek in telkek:
    print(telek)


# -----2. FELADAT-----

print('2. feladat')
print(f'Az állományban {len(telkek)} telek szerepel')


# -----3. FELADAT-----

print('3. feladat')
azonosito = int(input('Adj meg egy azonosítót: '))
talalat = None
for telek in telkek:
    if azonosito == telek['azonosito']:
        talalat = telek
if talalat != None:
    print(f'{talalat["utcanev"]} utca {talalat["hazszam"]}')
else:
    print('Nem szerepel az adatállományban.')


# -----4. FELADAT-----

print('4. feladat')
A = 0
B = 0
C = 0
for telek in telkek:
    if telek['adosav'] == 'A':
        A += 1
    elif telek['adosav'] == 'B':
        B += 1
    else:
        C += 1
print(f'A sávba {A} telek esik.')
print(f'B sávba {B} telek esik.')
print(f'C sávba {C} telek esik.')


# -----5. FELADAT-----

print('5. feladat')
with open('telekado.txt', 'w', encoding='utf-8') as fajl:
    for telek in telkek:
        if telek['adosav'] == 'A':
            fizetendo = telek['alapterulet'] * 800
            fajl.write(f'{telek["azonosito"]} azonosítójú telek után fizetendő adó {fizetendo} Ft\n')
        elif telek['adosav'] == 'B':
            fizetendo = telek['alapterulet'] * 600
            fajl.write(f'{telek["azonosito"]} azonosítójú telek után fizetendő adó {fizetendo} Ft\n')
        else:
            fizetendo = telek['alapterulet'] * 400
            fajl.write(f'{telek["azonosito"]} azonosítójú telek után fizetendő adó {fizetendo} Ft\n')