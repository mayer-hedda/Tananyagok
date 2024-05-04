# -----VIZSGÁLAT INT TÍPUSSAL-----

def fgv_1(x):
    x += 1


szam = 300
print(f'Függvényhívás előtt: {szam = }')
fgv_1(szam)
print(f'Függvényhívás után: {szam = }\n')


def fgv_1(x):
    x += 1
    return x


szam = 300
print(f'Függvényhívás előtt: {szam = }')
szam = fgv_1(szam)
print(f'Függvényhívás után: {szam = }\n\n')





# -----VIZSGÁLAT LIST TÍPUSSAL-----

def fgv_2(x):
    x[0] += 17


szamok = [1, 2, 3, 4]
print(f'Függvényhívás előtt: {szamok = }')
fgv_2(szamok)
print(f'Függvényhívás után: {szamok = }\n\n')





# -----OBJEKTUMOK-----

szam_1 = 350
szam_2 = 500
szamok = [3, 2, 1]

print(f'{szam_1 = } | {type(szam_1)} | {id(szam_1)}')
print(f'{szam_2 = } | {type(szam_2)} | {id(szam_2)}')
print(f'{szamok = } | {type(szamok)} | {id(szamok)}')

print(szam_1.__abs__())
szamok.sort()
print(szamok)
print('\n\n')



szam_1 = 350
szam_2 = 500

print(f'{szam_1 = } | {type(szam_1)} | {id(szam_1)}')
print(f'{szam_2 = } | {type(szam_2)} | {id(szam_2)}\n')

szam_2 = szam_1

print(f'{szam_1 = } | {type(szam_1)} | {id(szam_1)}')
print(f'{szam_2 = } | {type(szam_2)} | {id(szam_2)}\n\n')



# INTEGER, FLOAT, BOOL
a = 1234567
b = 1234567

print(id(a))
print(id(b))
print()

# LIST, DICT, SET
c = [1, 2, 3]
d = [1, 2, 3]

print(id(c))
print(id(d))
print()

# TUPLE
e = (1, 2, 3)
f = (1, 2, 3)

print(id(e))
print(id(f))
print()

# STRING
g = 'szo'
h = 'szo'

print(id(g))
print(id(h))
print('\n')





# -----

def teglalapot_novel(a, b):
    a *= 2
    b *= 2
    return a, b


a_oldal = 3
b_oldal = 9

a_oldal, b_oldal = teglalapot_novel(a_oldal, b_oldal)
print(a_oldal, b_oldal)
print()

visszateresi_ertek = teglalapot_novel(a_oldal, b_oldal)
print(visszateresi_ertek)
print(type(visszateresi_ertek))