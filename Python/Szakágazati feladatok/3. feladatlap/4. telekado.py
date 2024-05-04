class Telek:
    def __init__(self, azonosito, utcanev, hazszam, adosav, alapterulet):
        self.azonosito = azonosito
        self.utcanev = utcanev
        self.hazszam = hazszam
        self.adosav = adosav
        self.alapterulet = alapterulet

    def info(self):
        return f'{self.azonosito}, {self.utcanev}, {self.hazszam}, {self.adosav}, {self.alapterulet}'


telkek = []
with open('utca.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adat = sor.strip().split()
        telek = Telek(
            int(adat[0]),
            adat[1],
            adat[2],
            adat[3],
            int(adat[4])
        )
        telkek.append(telek)

for telek in telkek:
    print(telek.info())

print('2. feladat')
print(f'Az állományban {len(telkek)} telek szerepel')

print('3. feladat')
bekert_azonosito = int(input('Adj meg egy azonosítót: '))
szerepel = None
for telek in telkek:
    if telek.azonosito == bekert_azonosito:
        szerepel = telek
if szerepel != None:
    print(f'{szerepel.utcanev} utca {szerepel.hazszam}')
else:
    print('Nem szerepel az adatállományban.')

print('4. feladat')
savok = [telek for telek in set(telek.adosav for telek in telkek)]
savok.sort()
for sav in savok:
    szamlalo = 0
    for telek in telkek:
        if telek.adosav == sav:
            szamlalo += 1
    print(f'{sav} sávba {szamlalo} telek esik.')

print('5. feladat')
with open('telekado.txt', 'w', encoding='utf-8') as fajl:
    for telek in telkek:
        fizetendo = 0
        if savok[0] == telek.adosav:
            fizetendo = telek.alapterulet * 800
        elif savok[1] == telek.adosav:
            fizetendo = telek.alapterulet * 600
        else:
            fizetendo = telek.alapterulet * 400
        print(f'{telek.azonosito} azonosítójú telek után fizetendő adó {fizetendo} FT.')
        print(f'{telek.azonosito} azonosítójú telek után fizetendő adó {fizetendo} FT.', file=fajl)