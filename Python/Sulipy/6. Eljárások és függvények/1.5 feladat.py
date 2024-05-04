'''
A "Próbáld ki!" gombra kattintva elérhető egy program,
ami egy eljárás segítségével kirajzol a képernyőre egy 6x3-as mezőt.
Alakítsd át ezt a programot úgy, az eljárás hívásakor megadott értékpárnak megfelelően
a program az adott pozícióba 'O' helyett '+' jelet írjon ki.
A lenti példában az eljárás hivása: mezot_rajzol(0,4)

Alakítsd át az előző programot úgy, hogy a felhasználó adhassa meg a koordinátákat, ahová a program 'O' helyett '+' jelet ír.
A koordináták bekérése és a mező kirajzolása addig ismétlődjön, amíg a felhasználó negatív számot nem ad meg koordinátaként!
'''
def mezot_rajzol(x, y):
    for sor in range(3):
        for oszlop in range(6):
            if sor == x and oszlop == y:
                print('+ ', end='')
            else:
                print('O ', end='')
        print()


while True:
    sor = int(input('Adja meg a sor koordinátáját (0-2): '))
    oszlop = int(input('Adja meg az oszlop koordinátáját (0-5): '))
    if sor < 0 or oszlop < 0:
        break
    mezot_rajzol(sor, oszlop)