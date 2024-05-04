kezdeti = [11, 19, 7, -5]
eredmeny = [szam * 2 for szam in kezdeti if szam > 0]

print(eredmeny)
print('\n')



eredeti = [10, 19, 7, 12, 6]
negyzet = [szam ** 2 for szam in eredeti if szam % 2 == 0]

print(negyzet)
print()


paros = [szam for szam in eredeti if szam % 2 == 0]
print(paros)