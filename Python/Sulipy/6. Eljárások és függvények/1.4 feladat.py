'''
Írj egy programot, amely a felhasználótól bekér 3 szót, ezeket egy listában tárolja,
és egy eljárás segítségével meghatározza, és a képernyőre kiírja, melyik a legrövidebb szó!
'''
def legrovidebb(lista):
    legrovidebb_szo = lista[0]
    for elem in lista:
        if len(elem) < len(legrovidebb_szo):
            legrovidebb_szo = elem

    print(f'A legrövidebb szó a listában: {legrovidebb_szo}')


szavak = []

while len(szavak) != 3:
    szo = input('Adjon meg egy szót: ')
    szavak.append(szo)

legrovidebb(szavak)