'''
Készíts egy programot, amely egymásba ágyazott ciklusok segítségével rajzolja ki egy 7 x 7-es mezőben az alábbi alakzatot!
    O . . . . . O
    . O . . . O .
    . . O . O . .
    . . . O . . .
    . . O . O . .
    . O . . . O .
    O . . . . . O
'''
sor = 1
while sor <= 7:
    oszlop = 1
    while oszlop <= 7:
        if sor == oszlop or sor + oszlop == 8:
            print('O ', end='')
        else:
            print('. ', end='')
        oszlop += 1
    print()
    sor += 1