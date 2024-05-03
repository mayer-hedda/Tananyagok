'''
Írj egy Python programot, amely bekér három számot a felhasználótól és kiírja a
képernyőre a legnagyobb értéket ezek közül!
'''
legnagyobb = []
for i in range(3):
    szam = int(input(f'Adja meg a(z) {i + 1}. számot: '))
    legnagyobb.append(szam)

print(f'A megadott számok közül a legkisebb a {max(legnagyobb)}.')