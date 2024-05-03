# ---- ELSŐ FELADAT ----
'''
Tételezzük fel, hogy a hét napjai hétfőtől vasárnapig be vannak számozva: 0,1,2,3,4,5,6.
Írj egy függvényt, amely megkapja egy nap számát, és visszatér annak nevével!
'''
def nap_kalkulator(szam):
    napok = ['hétfő', 'kedd', 'szerda', 'csütörtök', 'péntek', 'szombat', 'vasárnap']
    return napok[szam]


print(nap_kalkulator(2))



# ---- MÁSODIK FELADAT ----
'''
Elmész egy gyönyörű nyaralásra 
(talán börtönbe, ha nem kedveled a mókás feladatokat) 
és a 2-es számú napon (tehát szerdán) indulsz. 
137 ott alvás után térsz haza. 
Írj egy programot, amely megkérdezi, 
hogy hányas számú napon indultál és hány napig voltál távol, 
majd megmondja annak a napnak a nevét, amikor hazatérsz.
'''
def visszateres_napja(het_napja, tavollet):
    napok = ["hetfo", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"]

    tavollet = het_napja + tavollet
    nap = tavollet % 7
    print(f"Ezen a napon érkezel: {napok[nap]}")


het_napja = int(input('A hét hányadik napján indultál? '))
het_napja -= 1
tavollet = int(input('Hány napot voltál távol? '))

visszateres_napja(het_napja, tavollet)



# ---- HARMADIK FELADAT ----
'''
Írj egy függvényt, amely kap egy vizsgapontszámot és visszaadja az érdemjegyed nevét – az alábbi séma szerint:
Pont -> Jegy
>= 90 -> jeles
[80-90) -> jó
[70-80) -> közepes
[60-70) -> elégséges
< 60 -> elégtelen
A szögletes- és kerek zárójelek zárt és nyílt intervallumot jelölnek. 
A zárt intervallum tartalmazza a számot, a nyílt nem. 
Így az 59.99999 elégtelent jelent, de a 60.0 már elégséges.
Teszteld a függvényed azzal, hogy kiíratod az összes jegyet az alábbi sorozat elemei (pontszámai) esetén:
xs = [83, 75, 74.9, 70, 69.9, 65, 60, 59.9, 55, 50, 49.9, 45, 44.9, 40, 39.9, 2, 0]
'''
def osztalyzat(jegy):
    if jegy >= 90:
        print('Az érdemjegyed jeles.')
    elif 80 <= jegy < 90:
        print('Az érdemjegyed jó.')
    elif 70 <= jegy < 80:
        print('Az érdemjegyed közepes.')
    elif 60 <= jegy < 70:
        print('Az érdemjegyed elégséges.')
    else:
        print('Az érdemjegyed elégtelen.')


xs = [92, 90, 89.9, 83, 75, 74.9, 70, 69.9, 65, 60, 59.9, 55, 50, 49.9, 45, 44.9, 40, 39.9, 2, 0]

for i in xs:
    osztalyzat(i)



# ---- NEGYEDIK FELADAT ----
'''
Módosítsd a teknőcös oszlopdiagram rajzoló programot, hogy az oszlopok közti résben a toll fel legyen emelve.
'''
import turtle
xs = [48, 117, 200, 240, 160, 260, 220]


def rajzolj_oszlopot(t, magassag):
    t.left(90)
    t.forward(magassag)
    t.right(90)
    t.forward(40)
    t.right(90)
    t.forward(magassag)
    t.left(90)
    t.forward(10)


def rajzolj_oszlopot_2(t, magassag):
    if magassag >= 200:
        t.color("hotpink", "red")
    elif 100 <= magassag < 200:
        t.color("hotpink", "yellow")
    else:
        t.color("hotpink", "green")

    t.begin_fill()
    t.left(90)
    t.forward(magassag)
    t.write(" " + str(magassag))
    t.right(90)
    t.forward(40)
    t.right(90)
    t.forward(magassag)
    t.left(90)
    t.end_fill()
    t.penup()
    t.forward(10)
    t.pendown()


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Harmadik feladat")

Emil = turtle.Turtle()
Emil.pensize(3)

for m in xs:
    rajzolj_oszlopot_2(Emil, m)

ablak.mainloop()



# ---- ÖTÖDIK FELADAT ----
'''
Módosítsd a tekn˝ocös oszlopdiagram rajzoló programot, hogy a 200 és annál nagyobb érték˝u oszlopok kitöltése piros legyen, 
amelyek értéke a [100 és 200) intervallumban vannak, legyenek sárgák és a 100 alattiak zöldek.

A tekn˝ocös oszlopdiagram rajzoló programban mit gondolsz, mi történik, ha egy vagy több érték a listán negatív?
Próbáld ki! Változtasd meg a programot úgy, hogy a negatív érték˝u oszlopok felirata az oszlop alá
essen.
'''
import turtle
xs = [48, 117, 200, 240, 160, 260, 220, -23, -233]


def rajzolj_oszlopot(t, magassag):
    t.left(90)
    t.forward(magassag)
    t.right(90)
    t.forward(40)
    t.right(90)
    t.forward(magassag)
    t.left(90)
    t.forward(10)


def rajzolj_oszlopot_2(t, magassag):
    if abs(magassag) >= 200:
        t.color("hotpink", "red")
    elif 100 <= abs(magassag) < 200:
        t.color("hotpink", "yellow")
    else:
        t.color("hotpink", "green")

    t.begin_fill()
    t.left(90)
    t.forward(magassag)
    if magassag < 0:
        t.penup()
        t.forward(-20)
        t.write(" " + str(magassag))
        t.left(180)
        t.forward(-20)
        t.left(180)
        t.pendown()
    else:
        t.write(" " + str(magassag))
    t.right(90)
    t.forward(40)
    t.right(90)
    t.forward(magassag)
    t.left(90)
    t.end_fill()
    t.penup()
    t.forward(10)
    t.pendown()


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Harmadik feladat")

Emil = turtle.Turtle()
Emil.pensize(3)

for m in xs:
    rajzolj_oszlopot_2(Emil, m)

ablak.mainloop()



# ---- HATODIK FELADAT ----
'''
Írj egy atfogó függvényt, amely megkapja egy derékszögű háromszög két befogójának a hosszát és visszaadja az átfogó hosszát! 
(Segítség: az x ** 0.5 a négyzetgyököt adja vissza.)
'''
import math

def pitagorasz(a, b):
    c = math.sqrt(a ** 2 + b ** 2)
    if c % 1 == 0:
        c = int(c)
    else:
        c = round(c, 2)
    return c


befogo_1 = int(input('Adja meg a derékszögű háromszög \n\tegyik befogóját: '))
befogo_2 = int(input('\tmásik befogóját: '))

print(f'\nAz átfogó értéke: {pitagorasz(befogo_1, befogo_2)}')



# ---- HETEDIK FELADAT ----
'''
Írj egy derekszogu_e függvényt, amely megkapja egy háromszög három oldalának a hosszát és meghatározza, hogy derékszög˝u háromszögr˝ol van-e szó! Tételezzük fel, hogy a harmadik megadott oldal mindig a leghosszabb. A függvény True értékkel térjen vissza, ha a háromszög derékszög˝u, False értékkel különben!
'''
from math import sqrt


def derekszogue(a, b, c):
    if c == sqrt(a**2 + b**2):
        return True
    else:
        return False


befogo_1 = int(input('Adja meg a háromszög\n\tegyik befogóját: '))
befogo_2 = int(input('\tmásik befogóját: '))
atfogo = int(input('\tátfogóját: '))

if derekszogue(befogo_1, befogo_2, atfogo):
    print('\nEz egy derékszögű háromszög.')
else:
    print('\nEz NEM egy derékszögű háromszög.')
