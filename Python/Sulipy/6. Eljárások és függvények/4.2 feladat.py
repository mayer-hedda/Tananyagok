'''
Írj egy programot, amely a main() függvényben egy lista formájában eltárolja az 'a', 'b' és 'c' betűket!
Egy másik függvény kérjen be a felhasználótól három betűt, és ezzel írja felül a main() függvényben létrehozott lista tartalmát.
A bekérés és felülírás mindaddig folytatódjon, amíg a felhasználó három azonos betűt nem ad meg!
'''
def bekeres():
    lista = []
    while len(lista) != 3:
        betu = input('Adjon meg egy betűt: ')
        lista.append(betu)
    return lista


def main():
    betuk = ['a', 'b', 'c']
    while True:
        bekert_betuk = bekeres()
        if bekert_betuk[0] == bekert_betuk[1] and bekert_betuk[0] == bekert_betuk[2]:
            break
        else:
            betuk = bekert_betuk
            print(betuk)


main()