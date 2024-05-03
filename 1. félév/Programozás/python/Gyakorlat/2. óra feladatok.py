import turtle

# ---- ELSŐ FELADAT ----
'''
Készíts egy void függvényt, mely egy négyzetet rajzol. 
Használd fel egy olyan program elkészítéséhez, mely az alábbi ábrát hozza létre. 
Minden egyes négyzet legyen 20 egység. 
(Segítség: mire a program véget ér, a teknőc már elmozdul arról a helyről, ahová az utolsó négyzetet rajzolta.)
'''

def feladat_1(teknos):
    for i in range(4):
        teknos.forward(20)
        teknos.left(90)
    teknos.penup()
    teknos.forward(40)
    teknos.pendown()


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Első feladat")

Emil = turtle.Turtle()
Emil.color("hotpink")
Emil.pensize(3)

for i in range(5):
    feladat_1(Emil)

ablak.mainloop()



# ---- MÁSODIK FELADAT ----
'''
Írj egy programot, mely az alábbi ábrának megfelelő alakzatot rajzolja ki. 
A legbelső négyzet minden oldala 20 egység hosszú. 
A többi négyzet oldalhosszúsága minden esetben 20 egységgel nagyobb, mint az általa tartalmazott legnagyobb négyzet oldalhosszúsága.
'''

def feladat_2(teknos, meret):
    for i in range(4):
        teknos.forward(meret)
        teknos.left(90)
    teknos.penup()
    teknos.right(90)
    teknos.forward(10)
    teknos.right(90)
    teknos.forward(10)
    teknos.right(180)
    teknos.pendown()


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Második feladat")

Emil = turtle.Turtle()
Emil.color("hotpink")
Emil.pensize(3)

meret = 20
for i in range(5):
    feladat_2(Emil, meret)
    meret += 20

ablak.mainloop()



# ---- HARMADIK FELADAT ----
'''
Írj egy sokszog_rajzolas(t, n, sz) fejlécű void függvényt, mely a teknőccel egy szabályos sokszöget rajzoltat. 
Ha majd meghívod a sokszog_rajzolas(Eszti, 8, 50) utasítással, akkor az alábbihoz hasonló ábrát kell kapnod:
'''

def feladat_3(teknos, szog, meret):
    for i in range(szog):
        teknos.forward(meret)
        teknos.left(360/szog)


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Harmadik feladat")

Emil = turtle.Turtle()
Emil.color("hotpink")
Emil.pensize(3)

feladat_3(Emil, 8, 50)

ablak.mainloop()



# ---- NEGYEDIK FELADAT ----
'''
Rajzold meg ezt a gyönyörű ábrát:
'''

def feladat_4(teknos):
    for i in range(4):
        teknos.forward(100)
        teknos.left(90)
    teknos.left(18)


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Negyedik feladat")

Emil = turtle.Turtle()
Emil.color("blue")
Emil.pensize(3)
Emil.speed("fast")

for i in range(20):
    feladat_4(Emil)

ablak.mainloop()



# ---- ÖTÖDIK FELADAT ----
'''
Készíts egy szabalyos_haromszog_rajzolas(t, sz) fejlécű void függvényt, 
mely az előző feladatban szereplő poligon_rajzolas függvényt meghívva egy szabályos háromszöget rajzoltat a teknőccel.
'''

def feladat_3(teknos, szog, meret):
    for i in range(szog):
        teknos.forward(meret)
        teknos.left(360/szog)


def feladat_5(teknos, szar):
    feladat_3(teknos, 3, szar)


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Ötödik feladat")

Emil = turtle.Turtle()
Emil.color("hotpink")
Emil.pensize(3)

feladat_5(Emil, 50)

ablak.mainloop()



# ---- HATODIK FELADAT ----
'''
Készíts egy osszeg(n) fejlécű produktív függvényt , amely összegzi az 1 és n közé eső egész számokat, a határokat is beleértve. 
Például osszeg(10) hívás esetében az 1+2+3. . . +10 eredményét, vagyis 55-öt kell visszaadni a függvénynek.
'''

def feladat_6(n):
    szam = 0
    for i in range(n + 1):
        szam += i

    return szam


print(feladat_6(10))



# ---- HETEDIK FELADAT ----
'''
Írj egy kor_terulet(r) fejlécű produktív függvényt, amely egy r sugarú kör területét adja vissza.
'''
from math import pi


def feladat_7(r):
    terulet = r**2 * pi

    return terulet


sugar = int(input('Adja meg a kör sugarát cm-ben: '))

terulet = feladat_7(sugar)
print(f'A {sugar} cm sugarú kör területe: {terulet:.2f}.')



# ---- NYOLCADIK FELADAT ----
'''
Készíts egy void függvényt, mely egy olyan csillagot rajzol ki, melynek minden oldala pontosan 100 egység hosszúságú. 
(Segítség: 144 fokkal kell elforgatni a teknőcöt minden csúcsban.)
'''


def feladat_8(teknos):
    teknos.left(73)
    for i in range(5):
        teknos.forward(100)
        teknos.right(144)


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Nyolcadik feladat")

Emil = turtle.Turtle()
Emil.color("hotpink")
Emil.pensize(3)

feladat_8(Emil)

ablak.mainloop()



# ---- KILENCEDIK FELADAT ----
'''
Bővítsd ki az előző feladatot programmá. Rajzolj öt csillagot, de minden egyes csillag rajzolása közt emeled fel a tollat, 
haladj előre 650 egységet és fordulj jobbra 144 fokkal, majd rakd le a tollat. Valami ilyesmit kell kapnod:
'''

def feladat_9(teknos):
    teknos.left(73)
    for i in range(5):
        teknos.forward(100)
        teknos.right(144)


ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Nyolcadik feladat")

Emil = turtle.Turtle()
Emil.color("hotpink")
Emil.pensize(3)

Emil.penup()
Emil.right(180)
Emil.forward(650)
Emil.right(180)
Emil.pendown()


for i in range(5):
    feladat_9(Emil)
    Emil.right(73)
    Emil.penup()
    Emil.forward(650)
    Emil.right(144)
    Emil.pendown()

ablak.mainloop()
