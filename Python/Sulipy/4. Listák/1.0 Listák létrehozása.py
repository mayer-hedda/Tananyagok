honapok = ['január', 'február', 'március', 'április']

print(honapok)
print((', ').join(honapok))
print()

print(len(honapok))
print()

print(honapok[1])
print(honapok[1:3])
print(honapok[:2])
print(honapok[2:])
print(honapok[-2])
print()



szo_ = 'almafa'
print(szo_[0])
print(szo_[:4])
print()



szavak = []
szo = None
while szo != '':
    szo = input('Adj meg egy szót: ')
    if szo != '':
        szavak.append(szo)

print((', ').join(szavak))