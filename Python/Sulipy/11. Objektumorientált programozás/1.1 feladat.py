'''
Készíts egy programot, amelyben van egy Negyzet nevű osztály. Attribútuma legyen az oldal hossza.
Rendelkezzen továbbá a kerület és terület számításra is egy-egy metódussal!

Módosítsd az előző programot úgy, hogy a metódus ne a kerület- illetve a területértékkel térjen vissza,
hanem maga gondoskodjon ezen értékek kiírásáról egy egész mondatos formában.

Az 1.1 feladatban meghatározottak szerint készíts egy programot,
amely a felhasználótól egymás után bekér négyzetek oldalhosszát egészen addíg,
amíg a felhasználó 0 értéket nem ad meg!
Ezen adat alapján a program hozzon létre negyzet objektumokat, melyeket egy listában tárol!
A program írja ki a megadott négyzetek oldalhosszát, kerületét és területét!
'''
class Negyzet:
    def __init__(self, oldal):
        self.oldal = oldal

    def kerulet(self):
        return self.oldal * 4

    def terulet(self):
        return self.oldal ** 2

    def info(self):
        print(f'A megadott oldalú négyzet: \n\tkerülete: {self.kerulet()} egység\n\tterülete: {self.terulet()} egység')


oldalak = []
while True:
    oldal = int(input('Adja meg a négyzet oldalát: '))
    if oldal == 0:
        print()
        break
    else:
        oldalak.append(oldal)

for oldal in oldalak:
    negyzet = Negyzet(oldal)
    print(f'Az oldal hossza: {oldal} egység\n\tkerülete: {negyzet.kerulet()} egység\n\tterülete: {negyzet.terulet()} egység\n')