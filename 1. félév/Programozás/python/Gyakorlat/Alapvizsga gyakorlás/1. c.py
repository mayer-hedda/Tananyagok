'''
Írj egy Python programot, amely bekér egy dolgozat pontszámot (x) a felhasználótól
és kiír egy érdemjegyet az alábbiak szerint! 1: x<=x<=x<=x= 5.
'''
def erdemjegy(x):
    if x <= 25:
        return 1
    elif 25 < x <= 40:
        return 2
    elif 40 < x <= 60:
        return 3
    elif 60 < x <= 80:
        return 4
    elif 80 < x <= 100:
        return 5
pontszam = int(input('Adja meg a dolgozatának a pontszámát (0-100): '))

print(f'A pontszámod alapján {erdemjegy(pontszam)} az érdemjegyed.')