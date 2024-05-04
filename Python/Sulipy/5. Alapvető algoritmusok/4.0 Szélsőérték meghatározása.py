szamok = [12, 5, 4, 8, 9, 5, -2, 11, 10, 12, 6]

minimum = szamok[0]
maximum = szamok[0]
for szam in szamok:
    if szam < minimum:
        min = szam
    if szam > maximum:
        max = szam

print(f'A lista legkisebb eleme: {minimum}')
print(f'A lista legnagyobb eleme: {maximum}')



szavak = ['Elemér', 'tó', 'ajtó', 'róka', 'egér', 'Aladár', 'pingvin']

legrovidebb = szavak[0]
leghosszabb = szavak[0]
for szo in szavak:
    if len(szo) < len(legrovidebb):
        legrovidebb = szo
    if len(szo) > len(leghosszabb):
        leghosszabb = szo

print(f'A lista legrövidebb szava: {legrovidebb}')
print(f'A lista leghosszabb szava: {leghosszabb}')