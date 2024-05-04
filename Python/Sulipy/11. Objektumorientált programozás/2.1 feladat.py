'''
Hozz létre egy Diak nevű osztályt. Attribútumai: név, osztály, születési év.
Az egyik metódusa állíptsa meg az aktuális év és a születési év alapján a diák életkorát,
a másik metódusa pedig adjon vissza egy f-sztringet, amelyben mondatszerűen szerepelnek a diák adatai:
Szia, Kiss Péter vagyok, a 10.A osztályba járok, 16 éves vagyok.

Fejleszd tovább az előző programot úgy, hogy az osztálynak legyen osztályattribútuma, osztály- és statikus metódusa!

Fejleszd tovább az előző programot úgy, hogy az hozzon létre öt Diak-objektumot.
A nevet egy-egy vezeték és keresztneveket tartalmazó listából állítsa össze véletlenszerűen,
az osztályt és a születési évet pedig szintén véletlenszerűen generálja!
A Diak-objektumokat egy listában tárolja! A program a listát bejárva írja ki a diákadatokat a képernyőre!
'''
from datetime import datetime
from random import randint, choice


class Diak:
    felnott_diakok = 0
    gyerek_diakok = 0

    def __init__(self, nev, osztaly, szuletesi_ev):
        self.nev = nev
        self.osztaly = osztaly
        self.szuletesi_ev =szuletesi_ev

    def eletkor(self):
        kor = datetime.now().year - self.szuletesi_ev
        if kor > 18:
            type(self).felnott_diakok += 1
        else:
            type(self).gyerek_diakok += 1
        return kor

    def adatok(self):
        return f'Szia, {self.nev} vagyok, a {self.osztaly} osztályba járok, {Diak.eletkor(self)} éves vagyok.'

    @classmethod
    def osszes_diak(cls):
        return cls.gyerek_diakok + cls.felnott_diakok

    @staticmethod
    def info():
        return 'A Zipernowsky a legjobb gimi!\nTelefonszáma: ...'


vezeteknevek = ['Kiss', 'Pap', 'Nagy', 'Mészáros', 'Mayer']
keresztnevek = ['Péter', 'Anna', 'Gergely', 'Gergő', 'Hanna', 'Zoé']

diakok = []
while len(diakok) != 5:
    diak = Diak(f'{choice(vezeteknevek)} {choice(keresztnevek)}', choice(['9.A', '9.B', '10.A', '10.B', '11.A', '11.B', '12.A', '12.B']), randint(2004, 2008))
    diakok.append(diak)

for diak in diakok:
    print(f'{Diak.adatok(diak)}\n')