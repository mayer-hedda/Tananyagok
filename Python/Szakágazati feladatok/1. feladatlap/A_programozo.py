programozok = []

with open('programozok.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adat = sor.strip().split(';')
        programozo = {
            'nev': adat[0],
            'jovedelem': int(adat[1].strip('$')),
            'szuletesi_ev': int(adat[2]),
            'szekhely': adat[3]
        }
        programozok.append(programozo)

for programozo in programozok:
    print(programozo)