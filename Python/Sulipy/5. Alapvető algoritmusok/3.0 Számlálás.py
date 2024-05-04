szamok = [12, 5, 4, 8, 9, 11, 10, 12, 6]

darab = 0
for szam in szamok:
    if szam % 3 == 0:
        darab += 1

print(f'A 3-mal osztható számok száma: {darab}')
print('\n')



szavak = ['Elemér', 'tó', 'ajtó', 'róka', 'egér', 'Aladár', 'pingvin']

darab = 0
for szo in szavak:
    if len(szo) > 4:
        darab += 1

print(f'A listában lévő 4-nél több betűből álló szavak száma: {darab}')