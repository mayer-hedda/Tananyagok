'''
Írj egy programot, amely a felhasználótól bekér egy RGB színkód három összetvőjét!
A program állapítsa meg és írja ki a képernyőre, hogy az adott szín tartalmaz-e zöld komponenst,
illetve melyik komponensből van a legtöbb, és melyikből a legkevesebb!
'''
RGB = []
R = int(input('Adja meg a szín piros összetevőjének a számát: '))
G = int(input('Adja meg a szín zöld összetevőjének a számát: '))
B = int(input('Adja meg a szín kék összetevőjének a számát: '))

RGB.append(R)
RGB.append(G)
RGB.append(B)

RGB = tuple(RGB)

if RGB[1] != 0:
    print('\nA megadott szín tartalmaz zöld komponenst.')
else:
    print('\nA megadott szín nem tartalmaz zöld komponenst.')

if RGB[0] > RGB[1] and RGB[0] > RGB[2]:
    print('A piros komponensből van a legtöbb.')
elif RGB[1] > RGB[0] and RGB[1] > RGB[2]:
    print('A zöld komponensből van a legtöbb.')
else:
    print('A kék komponensből van a legtöbb.')

if RGB[0] < RGB[1] and RGB[0] < RGB[2]:
    print('A piros komponensből van a legkevesebb.')
elif RGB[1] < RGB[0] and RGB[1] < RGB[2]:
    print('A zöld komponensből van a legkevesebb.')
else:
    print('A kék komponensből van a legkevesebb.')