'''
A program számolja össze, hogy hány darab 'A' vagy 'a' betűvel kezdődő szó van az adott listában
(amely a 'Próbáld ki!' gombra kattintva elérhető)!
A képernyőre írja is ki a feltételnek megfelelő szavakat!

A program számolja össze, hogy hány darab 'E' vagy 'e' betűt tartalmazó szó van az adott listában
(amely a 'Próbáld ki!' gombra kattintva elérhető)!
A képernyőre írja is ki a feltételnek megfelelő szavakat!
'''
szavak = ['alma', 'barack', 'Attila', 'kávé', 'szekrény', 'asztal']

print('A listában lévő "a" vagy "A" betűvel kezdődő szavak: ')

darab = 0
for szo in szavak:
    if szo[0] == 'a' or szo[0] == 'A':
        print('\t', szo)
        darab += 1

print(f'A listában lévő "a" vagy "A" betűvel kezdődő szavak száma: {darab}')
print('A listában lévő szavak:', ', '.join(szavak))
print('\n\n')





szavak = ['Elemér', 'Emma', 'ajtó', 'róka', 'egér']

print('A listában lévő "e" vagy "E" betűvel kezdődő szavak: ')

darab = 0
for szo in szavak:
    if szo[0] == 'e' or szo[0] == 'E':
        print('\t', szo)
        darab += 1

print(f'A listában lévő "e" vagy "E" betűvel kezdődő szavak száma: {darab}')
print('A listában lévő szavak:', ', '.join(szavak))