# -----FÜGGVÉNYEK (ELMÉLET)-----

# Függvény
def festek_kalkulator(x, y):
    '''
    Kiszámolja az adott falfelület festéséhez
    szükséges festék mennyiségét
    '''
    # t = x * y
    # l = t * 0.13
    # return l
    return x * y * 0.13

szelesseg = float(input('Add meg a fal szélességét: '))
magassag = float(input('Add meg a fal magasságát: '))

# Függvény hívása
liter = festek_kalkulator(szelesseg, magassag)

print(f'A fal festéséhez kb. {liter:.2f} liter festékre van szükség.')

# A függvény hívása lehet egy kifejezés része is
ar = festek_kalkulator(5, 2) * 700
print('\n\n')





# -----FÜGGVÉNYEK (GYAKORLAT)

# ---ELSŐ---

def szamolo(a, b, c=100):
    return (a + b) * c

print(szamolo(1, 2, 10))
print()



# ---MÁSODIK---

def max_kereso(x, *args):
    '''
    egy kötelező paraméter van, és a többi - tetszőlegesen sok -
    paraméter az 'args' nevű listában tárolódik
    '''
    maximum = x
    for szam in args:
        if szam > maximum:
            maximum = szam
    return maximum

print(max_kereso(1, 19, 11, 7, 17))
print()