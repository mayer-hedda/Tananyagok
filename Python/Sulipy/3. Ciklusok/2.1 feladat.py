'''
Készíts egy programot, amely a felhasználótól bekér egy páros számot,
majd ennek megfelelően rajzol ki a képernyőre egy pocak szerű alakzatot az alábbiak szerint!
  O
  O O
  O O O
  O O O O
  O O O O
  O O O
  O O
  O
'''
bekert_sor = int(input('Adj meg egy páros számot: '))
fele = bekert_sor / 2

darab = 1
sor = 1
while sor <= fele:
    oszlop = 1
    while oszlop <= darab:
        print('O ', end='')
        oszlop += 1
    print()
    darab += 1
    sor += 1

while sor <= bekert_sor:
    darab -= 1
    oszlop = 1
    while oszlop <= darab:
        print('O ', end='')
        oszlop += 1
    print()
    sor += 1