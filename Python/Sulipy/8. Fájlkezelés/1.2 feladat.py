'''
A mellékelt fájl Rainer Maria Rilke: A párduc című versét tartalmazza Szabó Lőrinc fordításában (forrás: Magyar Elektronikus Könyvtár).
Az általad írt program olvassa be a fájl tartalmát a read() metódussal, és adja meg a válaszokat az alábbi kérdésekre:
- hány betűt tartalmaz a vers,
- hány magánhangzót tartalmaz a vers,
- hány szó fordul elő a versben?
'''
tartalom = []
with open('1.2 feladat.txt', 'r', encoding='utf-8') as fajl:
    next(fajl)
    tartalom.append(fajl.read())

# -----BETŰK SZÁMA-----
osszes_betu = []
irasjelek = ['.', ' ', ':', '-', '\n', ',', '']
for sor in tartalom:
    for betu in sor:
        if betu not in irasjelek:
            osszes_betu.append(betu)
print(f'Összesen {len(osszes_betu)} betűt tartalmaz a vers.')



# -----MAGÁNHANGZÓK SZÁMA-----
osszes_maganhangzo = 0
maganhangzok = ['a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű']
for sor in tartalom:
    for betu in sor:
        if betu in maganhangzok:
            osszes_maganhangzo += 1
print(f'Összesen {osszes_maganhangzo} magánhangzót tartalmaz a vers.')



# -----SZAVAK ELŐFORDULÁSA-----
eredeti_szavak = []
szavak = set()
for sor in tartalom:
    sor = sor.split()
    for szo in sor:
        if szo[-1] in irasjelek:
            szo = szo.strip(szo[-1])
            eredeti_szavak.append(szo)
        else:
            eredeti_szavak.append(szo)

for szo in eredeti_szavak:
    if szo not in irasjelek:
        szavak.add(szo)
print(f'Összesen {len(szavak)} szó fordul elő a versben.')