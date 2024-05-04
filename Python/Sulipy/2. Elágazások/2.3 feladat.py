'''
Készíts egy programot,
amely a felhasználó által megadott egész számról eldönti, hogy:
    csak 3-mal osztható,
    csak 4-gyel osztható,
    3-mal és 4-gyel is osztható,
    sem 3-mal, sem 4-gyel nem osztható!
'''
bekert_szam = int(input('Adjon meg egy egész számot: '))

if bekert_szam % 3 == 0 and bekert_szam % 4 != 0:
    print('A megadott szám csak 3-mal osztható.')
elif bekert_szam % 3 != 0 and bekert_szam % 4 == 0:
    print('A megadott szám csak 4-gyel osztható.')
elif bekert_szam % 3 == 0 and bekert_szam % 4 == 0:
    print('A megadott szám 3-mal és 4-gyel is osztható.')
else:
    print('A megadott szám sem 3-mal, sem 4-gyel nem osztható.')