'''
Készíts egy programot, ami a rendszámokban előforduló karkatereket helyettesíti
'|' jellel a betűket,
'*' jellel a számokat
az alábbiaknak megfelelően:
    rendszamok = ['ABC123', 'ABCD777', 'WN25L']
    atalakitva = ['|||***', '||||***', '||**|']

Alakítsd át a fenti programot úgy, hogy a leképezés map() fügvénnyel történjen!
'''
rendszamok = ['ABC123', 'ABCD777', 'WN25L']
atvaltott_rendszamok = []

for rendszam in rendszamok:
    rendszam = [karakter for karakter in rendszam]
    for index, karakter in enumerate(rendszam):
        if karakter.isalpha() == True:
            rendszam[index] = '|'
        else:
            rendszam[index] = '*'

    atvaltott = ''
    for karakter in rendszam:
        atvaltott += karakter

    atvaltott_rendszamok.append(str(atvaltott))

print(atvaltott_rendszamok)





def alvato(lista):
    lista = [karakter for karakter in lista]
    for index, karakter in enumerate(lista):
        if karakter.isalpha() == True:
            lista[index] = '|'
        else:
            lista[index] = '*'

    atvaltott = ''
    for karakter in lista:
        atvaltott += karakter

    return str(atvaltott)


rendszamok = ['ABC123', 'ABCD777', 'WN25L']
atvaltott_rendszamok = []

print(list(map(alvato, rendszamok)))