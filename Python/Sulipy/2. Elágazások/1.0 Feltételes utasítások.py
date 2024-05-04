# -----POZITÍV VAGY NEGATÍV-----
szam = int(input('Adj meg egy egész számot: '))

if szam < 0:
    print('A megadott szám negatív.')
elif szam == 0:
    print('A megadott szám nulla.')
else:
    print('A megadott szám pozitív.')

print('A program vége')
print('\n\n')



# -----IF - ELIF - ELSE-----
import random

szam = random.randint(-5, 5)
print(szam)

if szam > 0:
    print('Pozitív')
elif szam < 0:
    print('Negatív')
else:
    print('Nulla')

print('\n\n')



# -----IF - IF - IF-----
from random import randint

szam = randint(-5, 5)
print(szam)

if szam > 0:
    print('Pozitív')
if szam % 2 == 0:
    print('Páros')
if szam == 2 or szam == 3 or szam == 5:
    print('Prímszám')