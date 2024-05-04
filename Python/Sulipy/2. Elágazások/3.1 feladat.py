'''
Készíts egy rövid programot, amely 1 és 3 között generál véletlenszámot,
majd összehasonlítja ezt a felhasználó által megadott,
szintén ebbe a tartományba eső számmal!
Az összehasonlítás eredményéről tájékoztassa a felhasználót!
'''
from random import randint

veletlen_szam = randint(1, 3)
bekert_szam = int(input('Adjon meg egy egész számot 1 és 3 között: '))

if bekert_szam != veletlen_szam:
    print('Az Ön által megadott szám nem egyezik meg a program által generált számmal.')
else:
    print('Az Ön által megadott szám megegyezik a program által generált számmal.')