programozok = []

with open('programozok.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adat = sor.strip().split(';')
        programozo = {
            'nev': adat[0],
            'jovedelem': int(adat[1].strip('$')),
            'szuletesi_ev': int(adat[2]),
            'szekhely': adat[3]
        }
        programozok.append(programozo)

# for programozo in programozok:
#     print(programozo)

# -----ÖSSZEGZÉS-----

def osszes_elem(lista):
    szamlalo = 0
    for elem in lista:
        szamlalo += 1
    return szamlalo


print(f'A listában {osszes_elem(programozok)} programozó szerepel.\n')



# -----ÁTLAG ÉLETKOR-----

def atlag_eletkor(lista):
    ossz_eletkor = 0
    for elem in lista:
        ossz_eletkor += 2022 - elem['szuletesi_ev']
    atlag = ossz_eletkor / len(lista)
    return atlag


print(f'A programozók átlag életkora: {atlag_eletkor(programozok):.2f} év.\n')



# -----ORSZÁG BEKÉRÉS-----

def kereses(lista, kulcs, orszag):
    talalatok = []
    for elem in lista:
        if elem[kulcs].lower() == orszag.lower():
            talalatok.append(elem)
    return talalatok


bekert_orszag = input('Adjon meg egy országot: ')
orszag_programozoi = kereses(programozok, 'szekhely', bekert_orszag)

if len(orszag_programozoi) > 0:
    print(f'Találatok:')
    for programozo in orszag_programozoi:
        print(f'\nNév: {programozo["nev"]}\n'
              f'Jövedelme: ${programozo["jovedelem"]}')
else:
    print('Nincs ilyen országban programozó!')

