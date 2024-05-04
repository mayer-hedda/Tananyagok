# -----KERESZT-----
sor = 1
while sor <= 7:
    oszlop = 1
    while oszlop <= 7:
        if oszlop == 4 or sor == 4:
            print('+ ', end='')
        else:
            print('. ', end='')
        # print(f'({sor};{oszlop})', end='\t')
        oszlop += 1
    print()
    sor += 1
print('\n\n')



# -----ÁTLÓ-----
sor = 1
while sor <= 7:
    oszlop = 1
    while oszlop <= 7:
        if sor + oszlop == 8:
            print('O ', end='')
        else:
            print('. ', end='')
        # print(f'({sor + oszlop:2})', end='\t')
        # print(f'({sor};{oszlop})', end='\t')
        oszlop += 1
    print()
    sor += 1
print('\n\n')



# -----DERÉKSZÖGŰ HÁROMSZÖG-----
sor = 1
while sor <= 7:
    oszlop = 1
    while oszlop <= 7:
        if sor + oszlop >= 8:
            print('O ', end='')
        else:
            print('  ', end='')
        # print(f'({sor + oszlop:2})', end='\t')
        oszlop += 1
    print()
    sor += 1