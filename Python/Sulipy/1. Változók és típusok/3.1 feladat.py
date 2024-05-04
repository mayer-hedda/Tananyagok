'''
Thonny fejlesztői környezetben készíts egy rövid programot,
amely a felhasználótól bekéri a kör sugarát,
és ennek alapján kiszámolja a kör kerületét és területét!
'''
from math import pi

sugar = int(input('Adja meg a kör sugarát: '))

kerulet = 2 * sugar * pi
terulet = sugar**2 * pi

print(f'A {sugar} cm sugarú körnek a: \n\tkerülete: {kerulet:.2f} cm \n\tterülete: {terulet:.2f} cm2')