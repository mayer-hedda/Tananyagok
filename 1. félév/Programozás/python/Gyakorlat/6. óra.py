# ---- ADATCSOPORTOSÍTÁS ----

szuletesi_ev = ("Paris Hilton", 1981)
print(szuletesi_ev)



julia = ("Julia", "Roberts", 1967, "Kettős játék", 2009, "színésznő", "Atlanta, Georgia")
print(julia)

print(julia[2])  # 1967

# julia[0] = "X"  # TypeError: 'tuple' object does not support item assignment

julia = julia[:3] + ("Pénzes cápa", 2016) + julia[5:]
print(julia)

(k_nev, v_nev, szul_ev, film, film_ev, foglalkozas, szul_hely) = julia



b = ("Tibi", 19, "PTI") # becsomagolás
(nev, kor, szak) = b # kicsomagolás

print(nev)  # Tibi
print(kor)  # 19
print(szak)  # PTI



import math

def f(r):
    # Visszatér a (kerület, terület) értékekkel egy r sugarú kör esetén """
    k = 2 * math.pi * r
    t = math.pi * r * r
    return (k, t)



# ---- EGYMÁSBA ÁGYAZÁSOK ----

hallgatok = [
    ("Jani", ["Informatika", "Fizika"]),
    ("Kata", ["Matematika", "Informatika", "Statisztika"]),
    ("Peti", ["Informatika", "Könyvelés", "Közgazdaságtan", "Menedzsment"]),
    ("Andi", ["Információs rendszerek", "Könyvelés", "Közgazdaságtan", "Vállalkozási jog"]),
    ("Linda", ["Szociológia", "Közgazdaságtan", "Jogi ismeretek", "Statisztika", "Zene"])
]


julia_more_info = (
    ("Julia", "Roberts"),
    (1967, "október", 8),
    "színésznő",
    ("Atlanta", "Georgia"),
    [
        ("Sztárom a párom", 1999),
        ("Micsoda nő", 1990),
        ("Ízek, imák, szerelmek", 2010),
        ("Erin Brockovich", 2000),
        ("Álljon meg a nászmenet", 1997),
        ("Egy veszedelmes elme vallomásai", 2002),
        ("Oceans Twelve", 2004)
    ]
)



# ---- ESEMÉNYVEZÉRELT PROGRAMOZÁS ----

# --- 1. példa ---
import turtle

turtle.setup(400, 500)  # Az ablak méretének beállítása
ablak = turtle.Screen()  # Ablak létrehozása
ablak.title('Az ablak címe.')  # Ablaknév módosítása
ablak.bgcolor('lightgreen')  # Háttér színének beállítása
Emil = turtle.Turtle()  # Teknőc elkészítése

# A következő függvények az eseménykezelőink
def ek1():
    Emil.forward(30)
def ek2():
    Emil.left(45)
def ek3():
    Emil.right(45)
def ek4():
    ablak.bye()  # A teknőc ablak bezárása


# Ezek a sorok rendelik össze a billentyű leütéseseményeket
# az általuk definiált eseménykezelő függvényekkel
ablak.onkey(ek1, 'Up')
ablak.onkey(ek2, 'Left')
ablak.onkey(ek3, 'Right')
ablak.onkey(ek4, 'q')

# Most megkérjük az ablakot, hogy kezdje el figyelni az eseményeket
# Ha bármelyik általunk figyelt billentyűt lenyomja valaki, akkor
# a hozzá tartozó eseménykezelő meghívásra kerül.
ablak.listen()
ablak.mainloop()


# --- 2. példa ---
import turtle

turtle.setup(400, 500)
ablak = turtle.Screen()
ablak.title('Ablakon belüli kattintások kezelése')
ablak.bgcolor('lightgreen')

Emil = turtle.Turtle()
Emil.color('purple')
Emil.pensize(3)
Emil.shape('circle')

def ek1_2(x, y):
    ablak.title(f'Kattintás koordinátái: {x}, {y}')
    Emil.goto(x, y)
    ablak.onclick(ek1_2)  # Összerendeljük a kattintás eseményt az eseménykezelővel

ablak.mainloop()


# --- 3. példa ---
import turtle

turtle.setup(400, 500)  # Az ablak méretének beállítása
ablak = turtle.Screen()  # Az ablak referenciájának lekérése
ablak.title('Kattintások kezelése')  # Az ablaknév módosítása
ablak.bgcolor('lightgreen')  # Háttér színének beállítása

Emil = turtle.Turtle()  # Teknőcök készítése
Emil.color('purple')
Sanyi = turtle.Turtle()
Sanyi.color('blue')
Sanyi.forward(100)  # Teknőcök szétválasztása

def Emil_esemenykezeloje(x, y):
    ablak.title(f'Emil kattintásának koordinátái: {x}, {y}')
    Emil.left(42)
    Emil.forward(30)

def Sanyi_esemenykezeloje(x, y):
    ablak.title(f'Sanyi kattintásának koordinátái: {x}, {y}')
    Sanyi.right(84)
    Sanyi.forward(50)

Emil.onclick(Emil_esemenykezeloje)
Sanyi.onclick(Sanyi_esemenykezeloje)

ablak.mainloop()


# --- 4. példa ---
import turtle

turtle.setup(400, 500)
ablak = turtle.Screen()
ablak.title('Időzítő használata')
ablak.bgcolor('lightgreen')

Esmil = turtle.Turtle()
Emil.color('purple')
Emil.pensize(3)

def ek1():
    Emil.forward(100)
    Emil.left(56)
    ablak.ontimer(ek1, 60)

ablak.ontimer(ek1, 2000)
ablak.mainloop()


# --- 5. példa ---
import turtle  # Eszti közlekedési lámpává válik.

turtle.setup(400,500)
ablak = turtle.Screen()
ablak.title("Eszti közlekedési lámpává válik.")
ablak.bgcolor("lightgreen")
Eszti = turtle.Turtle()

def doboz_rajzolas():
    """ Egy csinos doboz rajzolása a közlekedési lámpa számára """
    Eszti.pensize(3)
    Eszti.color("black", "darkgrey")
    Eszti.begin_fill()
    Eszti.forward(80)
    Eszti.left(90)
    Eszti.forward(200)
    Eszti.circle(40, 180)
    Eszti.forward(200)
    Eszti.left(90)
    Eszti.end_fill()

doboz_rajzolas()

Eszti.penup()

# Eszti pozícionálása oda, ahol a zöld lámpának kell lennie
Eszti.forward(40)
Eszti.left(90)
Eszti.forward(50)

# Esztit egy nagy zöld körré alakítjuk át
Eszti.shape("circle")
Eszti.shapesize(3)
Eszti.fillcolor("green")

# A közlekedési lámpa egyfajta állapotautomata, három állapottal:
# zölddel, sárgával és pirossal. Az állapotokat rendre
# 0, 1, 2 számokkal írjuk le.
# Az állapotváltásnál Eszti helyzetét és színét változtatjuk meg.

# Ez a változó hordozza az aktuális állapotot
allapot_sorszam = 0


def allapot_automata_esemenykezeloje():
    global allapot_sorszam
    if allapot_sorszam == 0: # Átmenet a 0. állapotból az 1. állapotba
        Eszti.forward(70)
        Eszti.fillcolor("orange")
        allapot_sorszam = 1
    elif allapot_sorszam == 1: # Átmenet az 1. állapotból a 2. állapotba
        Eszti.forward(70)
        Eszti.fillcolor("red")
        allapot_sorszam = 2
    else: # Átmenet a 2. állapotból az 0. állapotba
        Eszti.back(140)
        Eszti.fillcolor("green")
        allapot_sorszam = 0

# Az eseménykezelőt a space billentyűhöz kötjük
ablak.onkey(allapot_automata_esemenykezeloje, "space")

ablak.listen() # Események figyelése
ablak.mainloop()