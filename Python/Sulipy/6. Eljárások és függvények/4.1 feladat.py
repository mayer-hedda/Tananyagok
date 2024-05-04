'''
Írj egy programot, amely a main() függvényben generál egy véletlenszámot [1; 10] intervallumon és eltárolja azt egy változóban.
Egy másik függvény kérjen be a felhasználótól egy számot, és ezzel írja felül a main() függvényben létrehozott változó értékét.
A bekérés és felülírás mindaddig folytatódjon, amíg a felhasználó 0-t nem ad meg!
'''
from random import randint

def bekeres():
    szam = int(input('Adjon meg egy számot: '))
    return szam


def main():
    randomszam = randint(1, 10)
    while True:
        szam = bekeres()
        if szam == 0:
            break
        else:
            randomszam = szam

    print(randomszam)


main()