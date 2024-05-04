'''
Írj egy programot, amely a felhasználó által meghatározott alkalommal írja ki a bekért szöveget!
'''
bekert_szoveg = input('Adjon meg egy szöveget: ')
hanyszor = int(input('Adja meg, hogy az ön által megadott szöveg hányszor jelenjen meg a kijelzőn: '))

szamlalo = 1
while szamlalo <= hanyszor:
    print(bekert_szoveg)
    szamlalo += 1