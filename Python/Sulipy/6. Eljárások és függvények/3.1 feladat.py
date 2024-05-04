'''
Írj egy programot, amely generál egy véletlenszámot [1; 10] intervallumon, és a játékosnak ezt kell kitalálnia.
A próbálkozások száma nincs megkötve, de a program számolja a tippelési alkalmakat.

A program tartalmazzon:
    egy kitalalando nevű változót, ebben kerüljön tárolásra a generált véltelenszám,
    egy tipp nevű változót, ez tárolja az éppen aktuális tippet,
    egy main nevű függvényt, amely tartalmazza a főprogramot,
    egy eltalalta nevű függvényt, amelynek
        - 2 paramétere van, a játékos éppen aktuális tippje és az kitalálandó szám,
        - visszatérési értéke True vagy False, attól függően, hogy a paraméterként átvett értékek megegyeznek-e egymással vagy nem,
    egy tipp_bekero nevű függvényt, amelynek
        - nincs paramétere,
        - bekéri a felhasználó tippjét, és azzal tér vissza.
'''
from random import randint

def tipp_bekero():
    tipp = int(input('Tippelj! '))
    return tipp


def eltalalta(tipp, kitalalando):
    if tipp == kitalalando:
        return True
    else:
        return False


def main():
    kitalalando = randint(1, 10)
    probalkozas = 0
    print('Gondoltam egy számra 1 és 10 között! Próbáld meg kitalálni!')
    while True:
        tipp = tipp_bekero()
        if eltalalta(tipp, kitalalando) == True:
            probalkozas += 1
            print(f'Gratulálok eltaláltad {probalkozas} próbálkozásból.')
            break
        else:
            probalkozas += 1
            print(f'Nem találtad el. Ez volt a {probalkozas} próbálkozásod.')


main()