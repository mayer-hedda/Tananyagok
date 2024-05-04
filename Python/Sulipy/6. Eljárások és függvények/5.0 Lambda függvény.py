# -----MAGASABB RENDŰ FÜGGVÉNYEK-----
# pl.: sorted(), min(), max()
# sort()

# ---ELSŐ---
szamok = [7, 2, 12, -9]

print(sorted(szamok, key=abs, reverse=True))
print('\n')



# ---MÁSODIK---
def b_oldal(teglalap):
    return teglalap[1]

teglalapok = [[1, 9], [2, 3], [5, 7]]

print(max(teglalapok, key=b_oldal))
print(max(teglalapok, key=lambda teglalap: teglalap[1]))
print(min(teglalapok, key=lambda tl: tl[0] * tl[1]))
print('\n')

# ---LAMBDA FÜGGVÉNY---
# névtelen, kis függvény
# tetszőleges számú argumentum
# egyetlen egy kifejezés visszatérési értékkel


print(min(teglalapok, key=lambda tl: (tl[0] + tl[1]) * 2))
print()

tl_kerulet = lambda tl: (tl[0] + tl[1]) * 2
print(min(teglalapok, key=tl_kerulet))
print()


koszont = lambda vezeteknev, keresztnev: f'Szia {vezeteknev} {keresztnev}!'
print(koszont('Kis', 'Péter'))
print('\n')



# ---HARMADIK---
ertekek = ['1', '2', '3', '4']

int_szamok = list(map(int, ertekek))
print(int_szamok)
print()


allatok = ['kutya', 'macska', 'egér']

print(list(map(lambda allat: allat.upper(), allatok)))
print([allat.upper() for allat in allatok])
print()


szamok2 = [1, 2, 3, 4, 5]
print(list(filter(lambda szam: szam % 2 != 0, szamok2)))
print([szam for szam in szamok2 if szam % 2 != 0])