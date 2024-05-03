'''
Írj egy Python programot, amely bekér három számot a felhasználótól és kiírja a
képernyőre a legkisebb értéket ezek közül!
'''
legkisebb = []
for i in range(3):
    szam = int(input(f'Adja meg a(z) {i + 1}. számot: '))
    legkisebb.append(szam)

print(f'A megadott számok közül a legkisebb a {min(legkisebb)}.')