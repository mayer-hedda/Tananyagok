'''
Írj egy programot, amely egy ötbetűs főneveket tartalamzó listából véletelenszerűen választ egyet,
amit a játékosnak egy-egy betű megadásával kell kitalálnia!
A főprogramot a main() függvény tartalmazza, és ezen kívűl legyen még minimum 2 - részfeladatokat megvalósító - függvény!
A program az alábbiak szerint műdködjön:


    Találd ki, melyik ötbetűs főnévre gondoltam!
    Adj meg egy betűt! a
    Találat!
    Jelenlegi állás: ____a
    Rossz tippek:
    ------------------------------------------

    Adj meg egy betűt! é
    Sajnos nem talált!
    Jelenlegi állás: ____a
    Rossz tippek: é
    ------------------------------------------

    Adj meg egy betűt! b
    Találat!
    Jelenlegi állás: __b_a
    Rossz tippek: é
    ------------------------------------------

    Adj meg egy betűt! t
    Találat!
    Jelenlegi állás: t_bla
    Rossz tippek: é, k
    ------------------------------------------

    Adj meg egy betűt! á
    Találat!
    Jelenlegi állás: tábla
    Rossz tippek: é, k
    ------------------------------------------

    Gratulálok! Kitaláltad 7 próbálkozásból!


'''
from random import choice

def alaphelyzet():
    szo = ['_', '_', '_', '_', '_']
    return szo


def bekeres():
    return input('Adj meg egy betűt! ')


def vonal():
    print('------------------------------------------\n')


def main():
    szavak = ['aktív', 'bánya', 'cölöp', 'egres', 'fazon', 'gépel', 'hárít', 'ikrek', 'tábla', 'zabál']
    kitalalando = choice(szavak)
    print(kitalalando)
    szo = list(alaphelyzet())
    rossz_tippek = []
    probalkozas = 0

    print('Találd ki melyik ötbetűs főnévre gondoltam!')
    while True:
        betu = bekeres()
        if betu in kitalalando:
            indexe = []
            for index, elem in enumerate(kitalalando):
                if elem == betu:
                    indexe.append(index)
            print('Találat!')
            for elem in indexe:
                szo[elem] = betu
            print('Jelenlegi állás:', ''.join(szo))
            print(f'Rossz tippek:', ', '.join(rossz_tippek))
            vonal()
            probalkozas += 1
        else:
            rossz_tippek.append(betu)
            print('Sajnos nem talált!')
            print('Jelenlegi állás:', ''.join(szo))
            print(f'Rossz tippek:', ', '.join(rossz_tippek))
            vonal()
            probalkozas += 1
        if '_' not in szo:
            print(f'Gratulálok! Kitaláltad {probalkozas} próbálkozásból.')


main()