'''
Thonny fejlesztői környezetben készíts egy rövid programot, amely
    kommentként tartalmazza a program funkciójának leírását,
    konstansként tárolja PI értékét,
    egy másik változóban tárolja egy kör sugarának nagyságát (cm-ben megadva),
    kiszámolja és a képernyőre kiírja a kör kerületét és területét!

[Megjegyzés] A szorzás jele: *
'''
# Ez a program egy adott sugarú körnek a kerületét és területét számítja ki.
from math import pi

PI = pi
sugar = 7

kerulet = 2 * sugar * PI
terulet = sugar**2 * PI

print(f'Egy {sugar} cm sugarú körnek a: \n\tkerülete: {kerulet:.2f} cm \n\tterülete: {round(terulet, 2)} cm2')
