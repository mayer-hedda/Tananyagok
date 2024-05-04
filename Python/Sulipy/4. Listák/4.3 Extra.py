'''
Hogy pontosan miben különböznek a függvények a metódusoktól,
arra majd akkor kapunk egészen pontos választ,
amikor megismerkedünk az objektumorientált programozás módszerével.
Addig is vegyük észre a formai különbségeket!
'''
nyelvek = ['Python', 'C', 'C++', 'Java']

# METÓDUS: lista.metódus_név()
nyelvek.sort()


# FÜGGVÉNY: függvény_név(lista)
len(nyelvek)



# -----LISTÁK RENDEZÉSE IDEIGLENESEN ÉS MARADANDÓAN-----
nyelvek = ['Python', 'C', 'C++', 'Java']

# sorted() FÜGGVÉNY: lista elemeinek eredeti sorrendje nem változik,
# csak rendezetten kerülnek kiírásra
print(sorted(nyelvek))
print(nyelvek)
print()


# sort() METÓDUS: lista felülírása, az elemek eredeti sorrendje megváltozik,
# rendezett lesz
nyelvek.sort()
print(nyelvek)
print('\n\n')



# -----NÉHÁNY FÜGGVÉNY-----
szamok = [1, 2, 3, 4, 5]
szavak = ['fal', 'szoba', 'kép', 'villáskulcs']

# megadja, hogy hány elemű a lista
print(len(szamok))
print(len(szavak))
print()


# csak számok esetében használható (különben hibát eredményez)
# összegzi a listában előfroduló számokat
print(sum(szamok))
print()


# a legnagyobb elemet (legnagyobb számot, leghosszabb sztringet) adja eredményül
print(max(szavak))
print(max(szamok))
print()


# a legkisebb elemet (legkisebb számot, legrövidebb sztringet) adja eredményül
print(min(szavak))
print(min(szamok))