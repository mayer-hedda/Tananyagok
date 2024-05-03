'''
Írj egy Python programot, amely bekér egy egész számot a felhasználótól és kiírja a
képernyőre, hogy osztható-e (igen/nem) a szám 3-mal vagy 5-tel!
'''
def oszthato(x):
    if x % 3 == 0 and x % 5 == 0:
        return '3-mal és 5-tel is'
    elif x % 3 == 0 and x % 5 != 0:
        return 'csak 3-mal'
    elif x % 3 != 0 and x % 5 == 0:
        return 'csak 5-tel'
    else:
        return 'sem 3-mal sem 5-tel nem'


szam = int(input('Adjon meg egy egész számot: '))
print(f'Az általad megadott szám {oszthato(szam)} osztható.')