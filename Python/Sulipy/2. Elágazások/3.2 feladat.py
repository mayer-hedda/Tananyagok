'''
A program a pénzfeldobást modellezi.
Kérdezze meg a felhasználótól a választását (fej vagy írás),
majd adjon tájékoztatást, hogy eltalálta-e!
'''
from random import randint

veletlen_szam = randint(0, 1)

tipp = input('Fej vagy írás: \n\tTe: ')

if tipp == 'fej':
    tipp = 0
elif tipp == 'írás':
    tipp = 1

if tipp == veletlen_szam:
    print('Gratulálok, eltalálta!')
else:
    print('Sajnos nem találta el.')