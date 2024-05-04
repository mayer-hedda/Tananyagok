'''
Írj egy programot, amely tartalmaz egy 'paros_e' nevű függvényt,
amely True értékkel tér vissza, ha a paraméterként átvett listaelemek (egész számok) között van páros,
ellenkező esetben a visszatérési érték False!
A program tartalmazza a függvény hívását is!
'''
def paros_e(lista):
    paros = []
    for elem in lista:
        if elem % 2 == 0:
            paros.append(elem)
    if len(paros) == 0:
        return False
    else:
        return True

szamok = [1, 2, 3, 5, 7, 9, 11]

if paros_e(szamok) == True:
    print('A lista elemei között van páros szám.')
else:
    print('A lista elemei között nincs páros szám.')