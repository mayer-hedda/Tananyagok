'''
A program tároljon el egy szót egy változóban,
majd írja ki egymás alá a szóban található betűket.

A program tároljon el egy szót egy változóban.
A felhasználó adjon meg egy betűt, amiről a program döntse el,
hogy előfordul-e a szóban!
Az eredményről tájékoztassa a felhasználót, és írja ki a tárolt szót is!

Fejlesszük tovább a 2.2 programot úgy, hogy a felhasználónak
többször is legyen lehetősége újabb tippet megadnia.
A bekérés addig folytatódjon,
amíg a felhasználó nem ad meg betűt, csupán egy ENTER-t üt!
Igyekezz minél felhasználóbarátabbá tenni a programot!
A programnak lehetnek egyéb hasznos funkciói,
például gyűjtheti és kiírhatja a jó és a rossz tippeket (betűket).

Fejlesszük tovább a 2.3 programot úgy,
hogy a program egy listában tároljon öt darab szót,
és abból véletlenszerűen válasszon egyet,
aminek kapcsán a felhasználó megpróbálja kitalálni a betűit.
'''
szo = 'levéltetű'

for betu in szo:
    print(betu)
print('\n')



szo = 'levéltetű'
tipp = input('Adjon meg egy betűt: ')

if tipp in szo:
    print(f'Az Ön által megadott betű megtalálható a tárolt szóban.\nA tárolt szó: {szo}')
else:
    print(f'Az Ön által megadott betű nem található meg a tárolt szóban.\nA tárolt szó: {szo}')
print('\n')



szo = 'levéltetű'
jo_tippek = []
rossz_tippek = []

while True:
    tipp = input('Adjon meg egy betűt: ')
    if tipp == '':
        print(f'A tárolt szó: {szo}')
        break
    elif tipp in szo:
        print(f'Az Ön által megadott betű megtalálható a tárolt szóban.')
        jo_tippek.append(tipp)
        print('\tEddigi jó tippek:', ', '.join(jo_tippek), '\n\tEddigi rossz tippek:', ', '.join(rossz_tippek), '\n')
    else:
        print(f'Az Ön által megadott betű nem található meg a tárolt szóban.')
        rossz_tippek.append(tipp)
        print('\tEddigi jó tippek:', ', '.join(jo_tippek), '\n\tEddigi rossz tippek:', ', '.join(rossz_tippek), '\n')

print('\n')



from random import choice

szavak = ['levéltetű', 'akasztófa', 'elemér', 'galamb']
jo_tippek = []
rossz_tippek = []
szo = choice(szavak)

while True:
    tipp = input('Adjon meg egy betűt: ')
    if tipp == '':
        print(f'A tárolt szó: {szo}')
        break
    elif tipp in szo:
        print(f'Az Ön által megadott betű megtalálható a tárolt szóban.')
        jo_tippek.append(tipp)
        print('\tEddigi jó tippek:', ', '.join(jo_tippek), '\n\tEddigi rossz tippek:', ', '.join(rossz_tippek), '\n')
    else:
        print(f'Az Ön által megadott betű nem található meg a tárolt szóban.')
        rossz_tippek.append(tipp)
        print('\tEddigi jó tippek:', ', '.join(jo_tippek), '\n\tEddigi rossz tippek:', ', '.join(rossz_tippek), '\n')