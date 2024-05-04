from random import randint

'''
-----1. MEGOLDÁS-----


kor_01 = {
    'kozeppont': (2, 5),
    'sugar': 5
}

def terulet(kor):
    return kor['sugar'] * pow(3.14, 2)  # pow(ezt a számot, erre a hatványra emeli) -> ebben az esetben 3.14 ** 2


def kerulet(kor):
    return kor['sugar'] * 2 * 3.14


print(f'A kör területe: {terulet(kor_01)} egység.')
'''



class Kor:
    def __init__(self, sugar, kozeppont=(0, 0)):
        self.sugar = sugar
        self.kozeppont = kozeppont


    def terulet(self):
        return self.sugar * pow(3.14, 2)

    def kerulet(self):
        return self.sugar * 3.14 * 2

# kor01 = Kor(5)
# print(kor01.kozeppont)
# # print(type(kor01))
# # print(isinstance(kor01, Kor))       # megmondja, hogy a megadott objektum a megadott osztályhoz tartozik-e
#
# kor02 = Kor(10, (1, 1))
# print(kor02.kozeppont)

korok = []
for _ in range(5):
    kor = Kor(randint(1, 10))
    korok.append(kor)

for kor in korok:
    print(kor.sugar, kor.kerulet())

print(korok[1].sugar)