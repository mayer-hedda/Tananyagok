'''
Írj egy programot, ami 4 darab három elemű [0;25]
intervallumban lévő véletlen egész számokat tartalmazó listát generál,
és ezeket a listákat egy 'tarolo' nevű listába helyezi.
A program írja ki a képernyőre a 'tarolo' nevű lista tartalmát!
'''
from random import randint

tarolo = []

while len(tarolo) != 4:
    veletlenszamok = []
    while len(veletlenszamok) != 3:
        randomszam = randint(0, 25)
        veletlenszamok.append(randomszam)
    tarolo.append(veletlenszamok)

print(tarolo)
