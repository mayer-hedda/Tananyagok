baratok = []
with open('baratok.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adat = sor.strip().split(';')
        barat = {
            'nev': adat[0],
            'magassag': int(adat[1])
        }
        baratok.append(barat)

print(f'{len(baratok)} ember adatai szerepelnek a listában.')


osszes_magassag = 0
for barat in baratok:
    osszes_magassag += barat['magassag']

atlag = osszes_magassag / len(baratok)
if atlag % 1 == 0:
    atlag = int(atlag)

print(f'A listában szereplő emberek átlag magassága: {atlag}cm.')


legmagasabb = baratok[0]
for barat in baratok:
    if barat['magassag'] > legmagasabb['magassag']:
        legmagasabb = barat

print(f'A legmagasabb ember a listában: {legmagasabb["nev"]}.')


leghosszabb_keresztnev = baratok[0]
for barat in baratok:
    if len(barat['nev']) > len(leghosszabb_keresztnev['nev']):
        leghosszabb_keresztnev = barat

print(f'A leghosszabb keresztnevű ember a listában: {leghosszabb_keresztnev["nev"]}.')