szamok = [2, 4, -9, 0, -3, 7]

# sorted() függvény
rendezett = sorted(szamok, reverse=True)
print(f'{szamok = }')
print(f'{rendezett = }')
print()

# .sort() metódus
szamok.sort(reverse=True)
print(f'{szamok = }')
print('\n\n')



gyumolcsok = ['banán', 'eper', 'alma', 'dinnye']
gyumolcsok.sort()
print(f'{gyumolcsok = }')
print()

diakok = ['Zalán', 'Álmos', 'Éva', 'Hanna', 'Botond', 'Aladár', 'Tamara', 'Donát', 'Ödön']
diakok.sort()
print(f'{diakok = }')
print('\n\n')



def eletkor(kutya):
    return kutya[1]
kutyak = [
    ['Léda', 6, 35],
    ['Artúr', 2, 40],
    ['Kán', 10, 11],
    ['Zete', 6, 39]
]
kutyak.sort(key=eletkor, reverse=True)
print(f'{kutyak = }')
print()

kutyak.sort(key=lambda kutya: kutya[1])
print(f'{kutyak = }')
print('\n\n')



kutyak2 = [
    {'nev': 'Léda', 'kor': 6, 'tomeg': 35},
    {'nev': 'Artúr', 'kor': 2, 'tomeg': 40},
    {'nev': 'Kán', 'kor': 10, 'tomeg': 11},
    {'nev': 'Zete', 'kor': 6, 'tomeg': 39}
]
kutyak2.sort(key=lambda kutya: kutya['kor'])
print(f'{kutyak2 = }')