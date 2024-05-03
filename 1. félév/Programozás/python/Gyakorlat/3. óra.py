# ---- TÍPÚSOK ----

print(type(True))  # bool
print(type(False))  # bool

print(type('alma'))  # str
print(type('123'))  # str

print(type(123))  # int
print(type(12.3))  # float



# ---- FELTÉTELES UTASÍTÁSOK ----

print(5 == 3 + 2)  # Egyenlő-e az 5 3+2-vel?  (True)
print(5 == 6)  # False

j = 'hel'
print(j + 'ló' == 'helló')  # True



# ---- ÖSSZEHASONLÍTÓ OPERÁTOROK ----

x = 1
y = 2

print(x == y)  # True értéket ad, ha ... x egyenlő y-nal
print(x != y)  # x nem egyenlő y-nal
print(x > y)  # x nagyobb, mint y
print(x < y)  # x kisebb, mint y
print(x >= y)  # x nagyobb vagy egyenlő, mint y
print(x <= y)  # x kisebb egyenlő, mint y


kor = 18
eleg_idos_a_jogsihoz = kor >= 17
print(eleg_idos_a_jogsihoz)  # True
print(type(eleg_idos_a_jogsihoz))  # bool



# ---- LOGIKAI OPERÁTOROK ----

n = 6

# AND
print(n % 2 == 0 and n % 3 == 0)  # akkor ad True értéket, ha mindkét feltétel igaz
'''
False + False --> False
False + True --> False
True + False --> False
True + True --> True


x and False == False
False and x == False
y and x == x and y
x and True == x
True and x == x
x and x == x
'''

# OR
print(n % 2 == 0 or n % 2 == 0)  # akkor ad True értéket, ha legalább az egyik feltétel igaz
'''
False + False --> False
False + True --> True
True + False --> True
True + True --> True


x or False == x
False or x == x
y or x == x or y
x or True == True
True or x == True
x or x == x
'''

# NOT
print(not(n % 2 == 0))  # akkor ad True értéket, ha nem igaz a feltétel
'''
False --> True
True --> False


not (not x) == x
'''



# ---- ELÁGAZÁSOK ----

if x % 2 == 0:
    print(x, " páros szám.")
    print("Tudtad, hogy a 2 aze egyetlen páros prímszám?")
else:
    print(x, " páratlan szám.")
    print("Tudtad, hogy két páratlan számot összeszorozva " + "az eredmény mindig páratlan?")


'''
if BOOLEAN_KIFEJEZÉS:
    UTASÍTÁS_1  # végrehajtódik, ha a feltétel kiértékelése igaz értéket ad
else:
    UTASÍTÁS_2  # végrehajtódik, ha a feltétel kiértékelése hamis értéket ad
    
    
if x < y:
    UTASÍTÁSOK_A
elif x > y:
    UTASÍTÁSOK_B
else:
    UTASÍTÁSOK_C
    
    
if valasztas == 'a':
    fuggveny_egy()
elif valasztas == 'b':
    fuggveny_ketto()
elif valasztas == 'c':
    fuggveny_harom()
else:
    print("Érvénytelen válasz.")
    
    
if x < y:
    UTASÍTÁSOK_A
else:
    if x > y:
        UTASÍTÁSOK_B
    else:
        UTASÍTÁSOK_C
'''



# ---- FÜGGVÉNYBE HELYEZETT ELÁGAZÁS ----

def ird_ki_a_negyzetgyokot(x):
    if x < 0:
        print("Pozitív szám vagy 0 kell.")
        return
    eredmeny = x**0.5
    print(x, " negyzetgyoke ", eredmeny)



# ---- TEKNŐC OSZLOPDIAGRAM RAJZOLÁS ----

import turtle

# --- Első pélsa ---
def rajzolj_oszlopot(t, magassag):
    # A t teknőc oszlopot rajzol a megfelelő magassággal
    t.left(90)
    t.forward(magassag)  # megrajzolja az oszlop bal oldalát
    t.right(90)
    t.forward(40)  # az oszlop szélessége a tetején
    t.right(90)
    t.forward(magassag)  # megrajzolja az oszlop jobb oldalát
    t.left(90)
    t.forward(10)  # hagy egy kis rést minden oszlop után

ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Oszloprajzolás 1")

Emil = turtle.Turtle()
Emil.shape("turtle")
Emil.color("blue")
Emil.pensize(3)

xs = [48, 117, 200, 240, 160, 260, 220]
for m in xs:
    rajzolj_oszlopot(Emil, m)


# --- Második példa ---
def masodik_rajzolj_oszlopot(t, magassag):
    # A teknőc oszlopot rajzol a megfelelő magassággal
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
    t.forward(10)

ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
ablak.title("Oszloprajzolás 2")

Emil = turtle.Turtle()
Emil.shape("turtle")
Emil.color("blue", "red")  # az első szín a körvonal, a második szín az oszlopdiagramm kitöltésének a színe
Emil.pensize(3)

xs = [48, 117, 200, 240, 160, 260, 220]
for m in xs:
    masodik_rajzolj_oszlopot(Emil, m)

ablak.mainloop()
