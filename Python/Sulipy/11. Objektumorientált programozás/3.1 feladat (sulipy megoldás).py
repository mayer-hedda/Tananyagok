class Szemely:
    def __init__(self, nev):
        self.nev = nev

    def bemutatkozik(self):
        print(f'Szia, a nevem {self.nev}, ', end='')


class Diak(Szemely):
    def __init__(self, nev, osztaly):
        super().__init__(nev)
        self.osztaly = osztaly

    def bemutatkozik(self):
        super().bemutatkozik()
        print(f'és a(z) {self.osztaly} osztályba járok.')


class Tanar(Szemely):
    def __init__(self, nev, szakok):
        super().__init__(nev)
        self.szakok = szakok

    def bemutatkozik(self):
        super().bemutatkozik()
        print('-'.join(self.szakok), 'szakos tanár vagyok.')

        
diak01 = Diak('Kiss Péter', '10.A')
tanar01 = Tanar('Horváth Zita', ['biológia', 'kémia'])
tanar02 = Tanar('Schmidt Emil', ['matematika'])

diak01.bemutatkozik()
tanar01.bemutatkozik()
tanar02.bemutatkozik()
