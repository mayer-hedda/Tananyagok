cesar = 'Jöttem, ' + 'láttam, ' + 'győztem'
print(cesar)
print()

print('ja' + 'j'*7)
print()

print(str(7.23), str(8) + 'kg')
print()

r = 10
PI = 3.14
print(f'A kör kerülete: {2 * r * PI:.2f}')
print('\n\n')


# --------------------------------------------------------------


lista = [1, 2, 3, 4, 5, 6, 7]
sztring = 'Jöttem, láttam, győztem!'

print(lista[1:4])
print(sztring[1:4])
print()

print(lista[:4])    # legelső elemtől a megadott elem előtti elemig
print(sztring[1:])  # a megadott elemtől az utolsó elemig
print()

print(lista[-1])
print(sztring[-1])
print()

print(len(lista))
print(len(sztring))
print()

for elem in lista:
    print(elem)

szamlalo = 0
for karakter in sztring:
    if karakter == 'a' or karakter == 'á':
        szamlalo += 1
print(f'"a" és "á" betűk összesen a szövegben: {szamlalo}')
print()

if 10 not in lista:
    print('Találat!')
else:
    print('Nincs találat!')
print()

if 'J' in sztring:
    print('Találat!')
print()


lista[0] = 17
print(lista)
print()


# --------------------------------------------------------------



sztring = 'Jöttem, lÁttam, győZtem!'

# FÜGGVÉNY
len(sztring)

# METÓDUS
print(sztring.lower())

sztring.lower()
print(sztring)

print(sztring.upper())

print(sztring.count('t'))

print(sztring.isupper())