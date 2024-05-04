'''
Írj egy programot, amelyben van egy 'kerulet' nevű függvény,
amely az egyetlen kötelező paramétere mellett fogadhat több paramétert is!
Az opcionális paraméterek száma alapján döntse el milyen síkidomról van szó,
és számolja ki a kerületét (0 tetszőleges paraméter: négyzet, 1 tetszőleges paraméter:
téglalap, 2 tetszőleges paraméter: háromszőg, 3 vagy több tetszőleges paraméter: sokszög)!
A program tartalmazzon mindegyik síkidom típusra egy-egy függvényhívást!
'''
def kerulet(x, *args):
    if len(args) == 0:
        kerulet = x * 4
        return kerulet
    elif len(args) == 1:
        kerulet = x * 2 + args[0] *2
        return kerulet
    elif len(args) == 2:
        kerulet = x + args[0] + args[1]
        return kerulet
    elif len(args) > 2:
        kerulet = x + sum(args)
        return kerulet

print(f'Egy 3 egység hosszú négyzet kerülete: {kerulet(3)}\n')
print(f'Egy 2 egység magas és 5 egység széles téglalap kerülete: {kerulet(2, 5)}\n')
print(f'Egy háromszög kerülete, aminek az oldalai 3, 4 és 5 egység hosszú: {kerulet(3, 4, 5)}\n')
print(f'Egy ötszög kerülete, aminek az oldalai 4, 7, 9, 6, és 7 egység hosszúak: {kerulet(4, 7, 9, 6, 7)}')


