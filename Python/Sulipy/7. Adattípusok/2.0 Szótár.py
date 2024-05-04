# -----SZÓTÁR ELMÉLET-----

diak = {
    'vezeteknev': 'Kiss',
    'keresztnev': 'Péter',
    'osztaly': '10.A',
    'eletkor': 17,
    'kollegista': True,
    'info_fakt': False,
    'matek_jegyek': [5, 4, 4, 3, 5, 5]
}

raktar = {
    114589: 'Dominó polc',
    264875: 'Student íróasztal',
    364879: 'Kényelem01 fotel',
    568974: 'Family étkezőasztal 6 fős'
}





# -----SZÓTÁR GYAKORLAT-----

# Üres szótár létrehozása
raktar2 = {}
print(raktar2)
print('\n')



# Szótár létrehozása adatokkal
diak2 = {
    'vezeteknev': 'Kiss',
    'keresztnev': 'Péter',
    'eletkor': 17,
    'menza': True
}

print(diak['eletkor'])
print(diak2.get('eletkor'))
print()

# print(diak2['szakkor']) | HIBAÜZENET
print(diak2.get('szakkor', 'nincs adat'))
print('szakkor' in diak2)
print()

diak['szakkor'] = True
print(diak2)
print()

diak2['eletkor'] = 20
print(diak2)
print()

del diak2['vezeteknev']
print(diak2)
print('\n')



diak3 = {
    'vezeteknev': 'Kiss',
    'keresztnev': 'Péter',
    'eletkor': 17,
    'menza': True,
    'matek_jegyek': [5, 4, 4, 3, 5, 5]
}

for kulcs in diak3:
    print(kulcs, diak3[kulcs])
print()

print(diak3.values())
print()

for ertek in diak3.values():
    print(ertek)
print()

print(diak3.items())
print()

for kulcs, ertek in diak3.items():
    print(kulcs, ertek)