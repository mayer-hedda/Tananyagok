# -----VÁLTOZÓK-----
szoveg = 'Ez egy hosszú szöveg'
szam = 17
PI = 3.14

print(szoveg)
print(szam)
print(PI)
print('\n\n')



# -----ADATTÍPUSOK-----
szoveg = 'alma'
szam = 17
tizedes_tort = 3.14
oszthatoe = True

print(type(szoveg))
print(type(szam))
print(type(tizedes_tort))
print(type(oszthatoe))
print('\n\n')



# -----VÁLTOZÓ FELÜLÍRÁSA-----
szoveg = 'alma'
print(type(szoveg))

szoveg = 17
print(type(szoveg))



# -----TÍPUSÁTALAKÍTÁS-----
    # szoveg -> szam
szam1 = int('17')
print(type(szam))

szam2 = int('abc')
# print(type(szam)) | ValueError: invalid literal for int() with base 10: 'abc'


    # szoveg -> tizedes_tort
tizedes_tort = float('17.8')
print(type(tizedes_tort))


    # szam -> szoveg
szoveg = str(17)
print(type(szoveg))