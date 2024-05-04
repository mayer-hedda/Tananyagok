'''
Készíts egy programot, amely képes tárolni:
    - a diákok nevét és osztályát,
    - a tanárok nevét és szakját / szakjait,
és ezeket meg is tudja jeleníteni a képernyőn egy összefüggő mondat formájában.

Például:
Szia, a nevem Kiss Péter, és a(z) 10.A osztályba járok.
Szia, a nevem Horváth Zita, biológia-kémia szakos tanár vagyok.
Szia, a nevem Schmidt Emil, matematika szakos tanár vagyok.

Használj objektumorientált megoldást!
    - Először gondold végig, milyen osztályokra lesz szükség?
    - Van-e lehetőség öröklődés alkalmazása révén optimálisabb kódot írni?
'''
class Iskola:
    def __init__(self, nev):
        self.nev = nev


class Tanar(Iskola):
    def __init__(self, nev, szak):
        super().__init__(nev)
        self.szak = szak

    def info(self):
        return f'Szia, a nevem {self.nev}, {"-".join(self.szak)} szakos tanár vagyok.'


class Diak(Iskola):
    def __init__(self, nev, osztaly):
        super().__init__(nev)
        self.osztaly = osztaly

    def info(self):
        return f'Szia, a nevem {self.nev}, és a(z) {self.osztaly} osztályba járok.'


adatok = []
while True:
    valasztas = input('Tanár / Diák? ')
    if valasztas == '':
        print('\n')
        break
    
    elif valasztas.lower() == 'tanár':
        nev = input('Adja meg a tanár nevét: ')
        szak = input('Adja meg a tanárnak a szakjait vesszővel elválasztva: ')
        szak = szak.split(', ')
        tanar = Tanar(nev, szak)
        adatok.append(tanar)
        print()
        
    elif valasztas.lower() == 'diák':
        nev = input('Adja meg a diák nevét: ')
        osztaly = input('Adja meg a diák osztáját: ')
        diak = Diak(nev, osztaly)
        adatok.append(diak)
        print()
        
for adat in adatok:
    print(adat.info())
