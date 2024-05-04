'''
Készíts egy programot, amely a felhasználótól keresztneveket kér be egészen addig,
amíg az ENTER-t nem üt (nem ad meg újabb nevet a bekérésnél)!
A program a bekért neveket írja ki a képernyőre!

Fejleszd tovább úgy az előző programot, hogy a 3. név megadása után tájékoztassa a program a felhasználót,
hogy már nincs lehetősége újabb adat bevitelére, írja ki az addig megadott neveket, és lépjen ki.
'''
# -----1. FELADAT-----
keresztnevek = []
keresztnev = None

while keresztnev != '':
    keresztnev = input('Adjon meg egy keresztnevet: ')
    if keresztnev != '':
        keresztnevek.append(keresztnev)

print('Az Ön által megadott keresztnevek: ', (', ').join(keresztnevek))
print('\n\n')



# -----2. FELADAT-----
keresztnevek = []
keresztnev = None

while keresztnev != '':
    if len(keresztnevek) != 3:
        keresztnev = input('Adjon meg egy keresztnevet: ')
    if keresztnev != '':
        keresztnevek.append(keresztnev)
    if len(keresztnevek) == 3:
        print('Nincs lehetősége több keresztnév megadására!')
        break

print('Az Ön által megadott keresztnevek: ', (', ').join(keresztnevek))