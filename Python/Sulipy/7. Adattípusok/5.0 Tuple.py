# -----TUPLE LÉTREHOZÁSA-----

pelda_tuple = (0, 5)
print(pelda_tuple, end='\t')
print(type(pelda_tuple))
print()

pelda_tuple2 = 2, 4
print(pelda_tuple2, end='\t')
print(type(pelda_tuple2))
print('\n')



# -----TUPLE KICSOMAGOLÁSA-----

x, y = pelda_tuple
print(f'x = {x} {type(x)}')
print(f'y = {y} {type(y)}')
print('\n')



# -----TUPLE TULAJDONSÁGAI-----

pelda_tuple3 = (1, 3.2, True, 'alma')
print(pelda_tuple3, end='\t')
print(type(pelda_tuple3))
print()

print(pelda_tuple3[2])
print('\n')

# pelda_tuple3[2] = False | TypeError: 'tuple' object does not support item assignment



# -----GYAKORLATI ALKALMAZÁS-----

KEK = (0, 0, 255)
FHD = (1920, 1080)
HD = (1280, 720)



# -----EDDIG HASZNÁLT TUPLE-----

lista = ['Debrecen', 'Sopron', 'Pécs']

for index, elem in enumerate(lista):
    print(index, elem)
print()

for index, elem in enumerate(lista):
    print(index, end='\t')
    print(type(index))
print()

for x in enumerate(lista):
    print(x, end='\t')
    print(type(x))