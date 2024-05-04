'''
Írj egy programot, ami addig kér be egész pozitív számokat, amíg a felhasználó negtív számot nem ír!
A megadott számokat tárolja a program egy listában,
és ezt adja át paraméterként egy függvények, amely a lista legkisebb elemével tér vissza.
A program írja ki, hogy melyik volt a megadott legkisebb szám!
'''
def legkisebb(lista):
    legkisebb = lista[0]
    for elem in lista:
        if elem < legkisebb:
            legkisebb = elem
    return  legkisebb

szamok = []

while True:
    szam = int(input('Adjon meg egy számot: '))
    if szam < 0:
        break
    else:
        szamok.append(szam)

print(f'A megadott számok közül a legkisebb: {legkisebb(szamok)}')