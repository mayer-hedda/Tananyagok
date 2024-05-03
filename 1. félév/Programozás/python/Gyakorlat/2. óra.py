import turtle

# ---- FÜGGVÉNYEK ----

# ---- Első példa ----
def negyzet_rajzolas(t, h):
    # Egy h oldalhosszú négyzet rajzoltatása a t teknőccel
    for i in range(4):
        t.forward(h)
        t.left(90)

ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Emil találkozik egy függvénnyel")

Emil = turtle.Turtle()
negyzet_rajzolas(Emil, 50)  # egy négyzet rajzolása a függvény meghívásával

ablak.mainloop()



# ---- Második példa ----
def tobbszinu_negyzet_rajzolas(t, h):
    # Egy h oldalhosszúságú, többszínű négyzet rajzoltatása a t teknőccel
    for i in ["red", "purple", "hotpink", "blue"]:
        t.color(i)
        t.forward(h)
        t.left(90)

ablak = turtle.Screen()
ablak.bgcolor("lightgreen")

Emil = turtle.Turtle()
Emil.pensize(3)

meret = 20
for i in range(15):
    tobbszinu_negyzet_rajzolas(Emil, meret)
    meret += 10
    Emil.forward(10)
    Emil.right(18)

ablak.mainloop()



# ---- Harmadik példa ----
def teglalap_rajzolas(t, sz, m):
    # Egy sz szélességű, m  magasságú téglalap rajzoltatása a t teknőccel
    for i in range(2):
        t.forward(sz)
        t.left(90)
        t.forward(m)
        t.left(90)

def negyzet_rajzolas(tk, h):
    teglalap_rajzolas(tk, h, h)



# ---- BEÉPÍTETT FÜGGVÉNYEK ----

abs(5)  # 5
abs(-5)  # 5

pow(2, 3)  # 8
pow(7, 4)  # 2401

max(7, 11)  # 11
max(4, 1, 17, 2, 12)  # 17
max(3 * 11, 5**3, 512 - 9, 1024**0)  # 503



# ---- VISSZATÉRÉSI ÉRTÉKKEL RENDELKEZŐ FÜGGVÉNYEK (PRODUKTÍV FÜGGVÉNY) ----

def kamatos_kamat(c, r, m, t):
    # A futamidő végén kapott érték számítása c befektetett összegre 3 a kamatos kamat képletének megfelelően.
    fv = c * (1 + r/m)**(m * t)
    return fv

befektetett_osszeg = float(input("Mekkora összeget kíván befektetni? "))
vegosszeg = kamatos_kamat(befektetett_osszeg, 0.08, 12, 5)
print("A futamidő végén Önnek ennyi pénze lesz: ", vegosszeg)



def ablak_keszites(szin, ablaknev):
    # Egy ablak elkészítése, és a háttérszín, valamint az ablaknév beállítása.
    # Visszatérérsi érték az új ablak.
    a = turtle.Screen()
    a.bgcolor(szin)
    a.title(ablaknev)
    return a

def teknoc_keszites(szin, tm):
    # Létrehoz egy teknőcöt, és beállítja az általa használt toll színét és méretét.
    # Visszatérési érték: az új teknőc.
    t = turtle.Turtle()
    t.color(szin)
    t.pensize(tm)
    return t

ablak = ablak_keszites("lightgreen", "Emil és Sanyi táncol.")
Emil = teknoc_keszites("hotpink", 5)
Sanyi = teknoc_keszites("black", 1)
David = teknoc_keszites("yellow", 2)