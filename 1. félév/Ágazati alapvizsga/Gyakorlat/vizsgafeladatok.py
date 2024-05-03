# ----- 1. feladat -----
szamok = []

for i in range(3):
    szam = int(input(f'Adja meg a(z) {i + 1}. számot: '))
    szamok.append(szam)

szamok.sort()

if szamok[0] + szamok[1] == szamok[2]:
    print(f'Van ilyen lehetőség, mivel {szamok[0]} + {szamok[1]} = {szamok[2]}.')
else:
    print('Nincs ilyen lehetőség.')



# ----- 2. feladat -----
f = open('szamok.txt', 'w', encoding='utf-8')

szamok = []

szamlalo = 1
while len(szamok) != 100:
    if szamlalo % 3 == 0 or szamlalo % 5 == 0:
        szamok.append(szamlalo)
        f.write(f'{szamlalo}\n')
        if szamlalo % 3 == 0 and szamlalo % 5 == 0:
            print(szamlalo)
    szamlalo += 1

f.close()
    


# ----- 3. feladat -----
class Burkolo:
    def __init__(self, szelesseg = 0, hossz = 0, alapterulet = 0):
        self.szelesseg = szelesseg
        self.hossz = hossz
        self.alapterulet = alapterulet

    def szamitas(self):
        lap_terulet = self.hossz * self.szelesseg
        kell = self.alapterulet / lap_terulet

        if kell % 1 == 0:
            return int(kell)
        else:
            return int(kell) + 1


lap_szelesseg = int(input('Adja meg a burkolólap szélességét méterben: '))
lap_hossz = int(input('Adja meg a lap hosszúságát méterben: '))
burkolando_alapterulet = int(input('Adja meg a burkolandó helyiség alapterületét négyzetméterben: '))

a = Burkolo(lap_szelesseg, lap_hossz, burkolando_alapterulet)
eredmeny = a.szamitas()

print(f'A burkolónak {eredmeny} lapra van szüksége a munkához.')
