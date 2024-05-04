'''
Készíts egy programot!
A gép "gondol" egy számra 1 és 5 között,
vagyis egy változóban tárolj egy ilyen számot!
Azután a program bekér egy számot a felhasználótól,
majd kiírja, hogy ez a szám egyenlő-e a gép által "gondolt" számmal,
vagy annál kisebb, illetve nagyobb.
'''
gondolt_szam = 3
bekert_szam = int(input('Adjon meg egy számot: '))

if bekert_szam == gondolt_szam:
    print('Az Ön által megadott szám megegyezik azzal a számmal, amire a program "gondolt".')
elif bekert_szam > gondolt_szam:
    print('Az Ön által megadott szám nagyobb, mint amire a program "gondolt".')
else:
    print('Az Ön által megadott szám kisebb, mint amire a program "gondolt".')