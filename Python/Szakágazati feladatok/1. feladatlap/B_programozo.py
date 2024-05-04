class Programozo:
    def __init__(self, nev, jovedelem, szuletesi_ev, szekhely):
        self.nev = nev
        self.jovedelem = jovedelem
        self.szuletesi_ev = szuletesi_ev
        self.szekhely = szekhely

    def info(self):
        return f'Név: {self.nev}\n' \
               f'Jövedelem: {self.jovedelem}\n' \
               f'Születési év: {self.szuletesi_ev}\n' \
               f'Székhely: {self.szekhely}\n'


programozok = []

with open('programozok.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adat = sor.strip().split(';')
        programozo = Programozo(
            adat[0],
            int(adat[1].strip('$')),
            int(adat[2]),
            adat[3]
        )
        programozok.append(programozo)

for programozo in programozok:
    print(programozo.info())