def bekeres(lista, i):
    szamlalo = 1
    for _ in range(i):
        lista.append(int(input(f'Kérem a(z) {szamlalo}. egész számot!\n')))
        szamlalo += 1

    return lista


szamok = []
bekeres(szamok, 4)
szamlalo = 0
for szam in szamok:
    if szam % 2 == 1:
        szamlalo += 1

print(f'A megadott számok közül {szamlalo} db. páratlan szám található')