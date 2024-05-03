import turtle  # lehetővé teszi a teknőc használatát

# ---- Első példa ----
ablak = turtle.Screen()  # hozz létre egy játszóteret a teknőcnek
Emil = turtle.Turtle()  # hozz létre egy teknőcöt Emil néven

Emil.forward(50)  # Emil menjen 50 egységet előre
Emil.left(90)  # Emil forduljon 90 fokot
Emil.forward(30)  # rajzold meg a téglalap másik oldalát

ablak.mainloop()  # várj amíg a felhasználó bezárja az ablakot



# ---- Második példa ----
ablak = turtle.Screen()
ablak.bgcolor("lightgreen")  # állítsd be az ablak háttérszínét
ablak.title("Hello, Emil!")  # állítsd be az ablak címét
Emil = turtle.Turtle()
Emil.color("blue")  # mondd meg Emilnek, hogy változtasson színt
Emil.pensize(3)  # mondd meg Emilnek, hogy változtassa meg a toll vastagságát

Emil.forward(50)
Emil.left(120)
Emil.forward(50)

ablak.mainloop()



# ---- Harmadik példa ----
for i in [0, 1, 2, 3]:
    Emil.forward(50)
    Emil.left(90)

for i in range(4):
    Emil.forward(50)
    Emil.left(90)

for sz in ["yellow", "red", "purple", "blue"]:
    Emil.color(sz)
    Emil.forward(50)
    Emil.left(90)



# ---- Negyedik példa ----
Emil.penup()  # Emil felemeli a ceruzát
Emil.forward(50)  # most úgy meg előre, hogy nem húz vonalat
Emil.pendown()  # Emil leteszi a ceruzát
Emil.shape("turtle")  # Emil alakját lehet változtatni (arrow, blank, circle, classic, square, triangle, turtle)



# ---- Ötödik példa ----
ablak = turtle.Screen()
ablak.bgcolor("lightgreen")
Emil = turtle.Turtle()
Emil.shape("turtle")
Emil.color("blue")
Emil.penup()

meret = 20
for i in range(30):
    Emil.stamp()  # hagyj egy lenyomatot a vásznon
    meret = meret + 3
    Emil.forward(meret)
    Emil.right(24)

ablak.mainloop()