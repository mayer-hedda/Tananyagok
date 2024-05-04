'''
Készíts egy programot, amely egymásba ágyazott ciklusok segítségével rajzolja ki egy 7 x 7-es mezőben az alábbi alakzatot!
    O . . . .
    . O . . .
    . . O . .
    . . . O .
    . . . . O
'''
sor = 1
while sor <= 5:
    oszlop = 1
    while oszlop <= 5:
        if sor == oszlop:
            print('O ', end='')
        else:
            print('. ', end='')
        oszlop += 1
    print()
    sor += 1
