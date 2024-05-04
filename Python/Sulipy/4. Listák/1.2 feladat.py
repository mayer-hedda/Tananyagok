'''
Készíts egy programot, amely a felhasználótól kis "a" betűvel kezdődő neveket kér be és ezeket tárolja.
Ha a felhasználó nem "a" betűvel kezdődő szót ad meg, akkor azt hagyja figyelmen kívül és ne tárolja.
A bekérés egészen addig folytatódjon, amíg a felhasználó ENTER-t nem üt (nem ad meg újabb nevet a bekérésnél)!
A program a bekért neveket írja ki a képernyőre!
A program tájékoztatássa a felhasználót a működéséről, és az elvárt adatokról!

Alakítsd át úgy az előző porgramot, hogy az ne csak kis, hanem a nagy "A" betűvel kezdődő szavakat is elfogadja.
'''
# -----ELSŐ MEGOLDÁS-----
nevek = []
nev = None

while nev != '':
    nev = input('Adjon meg kis vagy nagy "a" betűvel kezdődő neveket: ')
    if nev != '':
        if nev[0] == 'a' or nev[0] == 'A':
            nevek.append(nev)

print('Az Ön által megadott nevek: ', (', ').join(nevek))
print('\n\n')



# -----MÁSODIK MEGOLDÁS-----
nevek = []
while True:
    nev = input('Adjon meg egy nevet, ami "a" betűvel kezdődik: ')
    if nev == '':
        break
    elif nev[0] == 'a' or nev[0] == 'A':
        nevek.append(nev)

print('Az Ön által megadott never: ', (', ').join(nevek))