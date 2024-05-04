'''
Készíts egy programot, amely objektumorientált módon tartja nyilván kutyák adatait (név, életkor, nem)!
A nevét a felhasználó adja meg, az életkorát és a nemét véletlenszerűen határozza meg a program!
Befejezésként a program a képernyőre írja ki a megadott kutyák adatait!
'''
from random import randint, choice

class Kutya:
    def __init__(self, nev, eletkor, nem):
        self.nev = nev
        self.eletkor = eletkor
        self.nem = nem

    # def eletkor(self):
    #     return randint(1, 20)
    #
    # def nem(self):
    #     nemek = ['lány', 'fiú']
    #     return choice(nemek)


nevek = []
while True:
    bekert_nev = input('Adja meg a kutya nevét: ')
    if bekert_nev == '':
        print()
        break
    else:
        nevek.append(bekert_nev)

for nev in nevek:
    kutya = Kutya(nev, randint(1, 20), choice(['lány', 'fiú']))
    print(f'A kutya neve: {nev}\n\téletkora: {kutya.eletkor}\n\tneme: {kutya.nem}\n')


