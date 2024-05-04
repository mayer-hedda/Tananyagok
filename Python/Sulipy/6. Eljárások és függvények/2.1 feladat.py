'''
Írj egy programot, amely tartalmaz egy 'osszegzo' nevű függvényt,
ami a paraméterként átvett listaelemeket (egész számokat) összeadja és az összegükkel tér vissza!
A program tartalmazza a függvény hívását is!
'''
def osszegzo(lista):
    osszeg = 0
    for elem in lista:
        osszeg += elem
    return osszeg

szamok = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print(f'A lista elemeinek az összege: {osszegzo(szamok)}')