def van_ilyen_keresztnevu(keresztnev, index):
    nevek = osztaly[index:]

    talalat = []
    i = index + 1
    for nev in nevek:
        if nev['keresztnev'] == keresztnev:
            talalat.append([i, nev['vezeteknev'], nev['keresztnev']])
        i += 1

    if len(talalat) == 0:
        return -1
    else:
        return talalat


osztaly = []
with open('nevek.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        sor = sor.strip().split()
        vezeteknev = sor[0]
        keresztnev = sor[1]
        diak = {
            'vezeteknev': vezeteknev,
            'keresztnev': keresztnev
        }
        osztaly.append(diak)

talalat = van_ilyen_keresztnevu('Vivien', 2)
if talalat == -1:
    print('Nincs egyező keresztnév.')
else:
    print(f'Az osztályban {talalat[0][1]} {talalat[0][2]}\n  és {talalat[1][1]} {talalat[1][2]}\n  keresztneve megegyezik, sorszámuk: {talalat[0][0]} és {talalat[1][0]}')
