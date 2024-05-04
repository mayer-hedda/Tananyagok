tartalom = []
with open('1.2 feladat.txt', 'r', encoding='utf-8') as fajl:
    next(fajl)
    tartalom = fajl.read()
tartalom = tartalom.split('\n')

szavak = []
ekezetek = [',','.','!','?','-',':']
for sor in tartalom:
    sor = sor.strip()
    for ekezet in ekezetek:
        sor = sor.replace(ekezet, '')
    sor = sor.split()
    for szo in sor:
        szavak.append(szo)

# betűk
betuk_osszesen = []
for szo in szavak:
    for betu in szo:
        betuk_osszesen.append(betu)
print(f'Összesen: {len(betuk_osszesen)} betű szerepel.')

# magánhangzók
maganhangzok = ['a', 'á', 'e', 'é', 'i', 'í', 'u', 'ú', 'ü', 'ű', 'o', 'ó', 'ö', 'ő']
talalatok = 0
for betu in betuk_osszesen:
    if betu in maganhangzok:
        talalatok += 1
print(f'Összesen: {talalatok} magánhangzó szerepel.')

# szavak
egyeni_szavak = set(szavak)
print(f'Összesen: {len(egyeni_szavak)} egyéni szó szerepel a versben.')