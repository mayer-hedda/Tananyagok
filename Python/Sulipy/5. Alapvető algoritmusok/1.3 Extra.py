szam = int(input('Szám: '))

szamok = [szam for szam in range(1, szam + 1)]

fakt = 1
for szam in szamok:
    fakt *= szam

print(f'Faktoriális: {fakt}')