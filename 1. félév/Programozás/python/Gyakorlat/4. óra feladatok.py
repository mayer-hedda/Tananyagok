# ---- ELSŐ FELADAT ----
'''
Írj egy függvényt, ami megszámolja hány páratlan szám van egy listában!
'''
def paratlanok(lista):
    szamlalo = 0
    for elem in lista:
        if elem % 2 == 1:
            szamlalo += 1
    return szamlalo



# ---- MÁSODIK FELADAT ----
'''
Add össze az összes páros számot a listában!
'''
def osszegzo_paros(lista):
    # return sum(lista)

    osszeg = 0
    for elem in lista:
        if elem % 2 == 0:
            osszeg += elem
    return osszeg



# ---- HARMADIK FELADAT ----
'''
Összegezd az összes negatív számot a listában!
'''
def osszegzo_negativ(lista):
    osszeg = 0
    for elem in lista:
        if elem < 0:
            osszeg += elem
    return osszeg



# ---- NEGYEDIK FELADAT ----
'''
Számold meg hány darab 5 betűs szó van egy listában!
'''
def otbetus_szavak(lista):
    szamlalo = 0
    for elem in lista:
        if len(elem) == 5:
            szamlalo += 1
    return szamlalo



# ---- ÖTÖDIK FELADAT ----
'''
Összegezd egy lista első páros száma előtti számokat! (Írd meg az egységtesztedet! Mi van, ha nincs egyáltalán páros szám?)
'''
def osszegzo_paros_szamig(lista):
    osszeg = 0
    for elem in lista:
        if elem % 2 == 0:
            break
        osszeg += elem
    return osszeg



# ---- HATODIK FELADAT ----
'''
Számold meg, hány szó szerepel egy listában az első „nem” szóig (beleértve magát a „nem” szót is! (Írd meg itt is az egységtesztedet! Mi van, ha a „nem” szó egyszer sem jelenik meg a listában?)
'''
def szo_szamlalo(lista):
    szamlalo = 0
    for elem in lista:
        if elem == 'nem':
            szamlalo += 1
            break
        szamlalo += 1
    return szamlalo
