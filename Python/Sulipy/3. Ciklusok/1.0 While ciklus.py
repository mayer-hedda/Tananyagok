# -----SZÁMOK 1-10-IG-----
szam = 1

while szam <= 10:
    print(szam)
    szam += 1

print('\n\n')



# -----SZÖVEG BIZONYOS MENNYISÉGBEN-----
szamlalo = 1

while szamlalo <=5:
    print('Programozni jó!')
    szamlalo += 1

print('\n\n')



# -----WHILE TRUE-----
folytatja = True

while folytatja:
    print('Vidd ki a szemetet!')
    valasz = input('Mondjam még egyszer: (i/n)\n\tVálasz: ')

    if valasz == 'n':
        folytatja = False

print('A program vége!')
print('\n\n')



# -----ADATBEKÉRÉS 1-----
szam = int(input('Adj meg egy egész számot 5 és 10 között: '))

# while szam < 5 or 10 < szam:
while not 5 <= szam <= 10:
    szam = int(input('Helytelen érték! Adj meg egy egész számot 5 és 10 között: '))

print('Rendben!')
print('\n\n')



# -----ADATBEKÉRÉS 2-----
szo = None
# print(type(szo))

while szo != '':
    szo = input('Adj meg szavakat! Ha kilépnél, a szó helyett csak egy ENTER-t üss!\n\tSzó: ')

print('Program vége!')
