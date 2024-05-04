'''
Készíts egy programot, ami a felhasználó által megadott intervallumon állít elő szintén
a felhszanáló által megadott darab véletlen egész számot!
Ezeket a program írja ki a képernyőre emelkedő és csökkenő sorrendben!
'''
from random import randint

intervallum_kezd = int(input('Adja meg az intervallum\n\tkezdőértékét: '))
intervallum_veg = int(input('\tvégértékét: '))
darab = int(input('\tdarabszámát: '))

veletlen_szamok = []
while len(veletlen_szamok) != darab:
    randomszam = randint(intervallum_kezd, intervallum_veg)
    veletlen_szamok.append(randomszam)

veletlen_szamok.sort()
print(f'{veletlen_szamok = }')

veletlen_szamok.sort(reverse=True)
print(f'{veletlen_szamok = }')