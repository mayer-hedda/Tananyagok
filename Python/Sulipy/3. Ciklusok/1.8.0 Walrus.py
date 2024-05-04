# -----ELSŐ MEGOLDÁS-----
#
# from random import randint
#
# szam = randint(1, 10)
# print(f'{szam = }')
#
# tipp = int(input('Tipp: '))
# while tipp != szam:
#     print('Sajnos nem!')
#     tipp = int(input('\nTipp: '))
#
# print('Kitaláltad!')



# -----MÁSODIK MEGOLDÁS / WALRUS OPERÁTOR-----
from random import randint

szam = randint(1, 10)
print(f'{szam = }')

while tipp := int(input('\nTipp: ')) != szam:
    print('Sajnos nem!')

print('Kitaláltad!')