'''
Készíts egy programot, amely [1; 40] intervallumon kiírja a 3-mal osztható számokat!
'''
harommal_oszthato_szamok = []

for szam in range(1, 41):
    if szam % 3 == 0:
        harommal_oszthato_szamok.append(szam)

print(', '.join(str(szam) for szam in harommal_oszthato_szamok))