'''
Készíts egy programot, amely a felhasználótól szavakat kér be, amíg az csupán ENTER-t nem üt!
A szavakat tárolja el a program egy listában!
Az adatbekérés befejezte után írja ki a program a lista elemeit, a legrövidebb és a leghosszabb szót!
'''
szavak = []

while True:
    szo = input('Adjon meg egy szót: ')
    if szo == '':
        break
    else:
        szavak.append(szo)

legrovidebb = szavak[0]
leghosszabb = szavak[0]
for szo in szavak:
    if len(szo) < len(legrovidebb):
        legrovidebb = szo
    if len(szo) > len(leghosszabb):
        leghosszabb = szo

print('A lista elemei:', ', '.join(szavak))
print(f'Az megadott szavak kövül a legrövidebb: {legrovidebb}')
print(f'Az megadott szavak kövül a leghosszabb: {leghosszabb}')