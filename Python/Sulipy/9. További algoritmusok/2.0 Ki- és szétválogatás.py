from pprint import pp

# for-ciklus
szamok = [-1, 9, 2, 17, -8, 0]

negativak = []
pozitivak = []
for szam in szamok:
    if szam < 0:
        negativak.append(szam)
    elif szam > 0:
        pozitivak.append(szam)
print(f'{negativak=}\t{pozitivak=}')

# listaértelmezés
negativak = [szam for szam in szamok if szam < 0]
pozitivak = [szam for szam in szamok if szam > 0]
print(f'{negativak=}\t{pozitivak=}')

# txt megnyitása
diakok = []
with open('2.0 Ki- és szétválogatás.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        sor = sor.split()
        diak = {
            'nev': sor[0],
            'szul_hely': sor[1],
            'kor': int(sor[2])
        }
        diakok.append(diak)
pp(diakok, sort_dicts=False)
print()

nagykoruak = []
kiskoruak = []
for diak in diakok:
    if diak['kor'] <= 18:
        nagykoruak.append(diak)
    else:
        kiskoruak.append(diak)
pp(nagykoruak, sort_dicts=False)
print()
pp(nagykoruak, sort_dicts=False)