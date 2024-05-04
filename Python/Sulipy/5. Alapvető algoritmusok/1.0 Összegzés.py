napi_eladasok = [3, 12, 3, 4, 7, 15, 1]

osszeg = 0
for eladas in napi_eladasok:
    osszeg = osszeg + eladas

print(f'Az eladások száma: {osszeg}')
print('\n\n')



print('Ez a program kiszámítja az átlagodat.')
print('Ha már nem akarsz több jegyet megadni, írj egy 0-át!')
print('------------------------------------------------')

darab = 0
osszeg = 0

erdemjegy = int(input('Add meg az első jegyet: '))
while erdemjegy != 0:
    darab += 1
    osszeg += erdemjegy
    erdemjegy = int(input('Add meg a következő jegyet: '))

if darab != 0:
    print(f'A megadott jegyek átlaga: {osszeg/darab}')
else:
    print('Nem adtál meg érdemjegyet.')