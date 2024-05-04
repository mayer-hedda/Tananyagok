'''
Írj egy programot, amely létrehoz egy 'tarolo' nevű listát, amelynek a három listaeleme egy-egy három elemű lista!
Ezen beágyazott listák elemei legyenek sztring formátumban: 'O '.
A program járja be a listákat, és jelenítse meg a bennük tárolt értékeket úgy, hogy azok egy 3x3-as rácsot adjanak ki.
A rács képernyőn való megjelenítéséről egy eljárás gondoskodjon!

Egészítsd ki úgy a programot, hogy a felhasználó megadhasson egy koordinátát (a bal felső rácspont koordinátája (0;0),
a jobb alsó pedig (2;2)), és ekkor a program rajzolja ki úgy a 3x3-as rácsot, hogy a megadott koordinátán 'O ' helyett, '+ ' legyen!

Alakítsd át úgy a programot, hogy a koordinátapárok bekérése addig folytatódjon,
míg a felhasználó intervallumon kívüli értéket nem ad meg! A program minden bekérés után rajzolja ki a rácsot úgy,
hogy megjeleníti a már korábban megadott koordináták esetében is a '+' jelet!
'''
def tablazat(lista):
    for elem in lista:
        print(''.join(elem))


tarolo = []
while len(tarolo) != 3:
    haromelemu_lista = []
    while len(haromelemu_lista) != 3:
        haromelemu_lista.append('O ')
    tarolo.append(haromelemu_lista)


def koordinata(lista, x, y):
    if sor == x and oszlop == y:
        del lista[x][y]
        lista[x].insert(y, '+ ')

    tablazat(lista)

while True:
    sor = int(input('Adja meg a sor koordinátáját (0-2): '))
    oszlop = int(input('Adja meg az oszlop koordinátáját (0-2): '))
    if sor < 0 or sor > 2 or oszlop < 0 or oszlop > 2:
        break
    else:
        print(koordinata(tarolo, sor, oszlop))