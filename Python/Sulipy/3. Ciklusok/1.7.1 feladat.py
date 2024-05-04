import  turtle

szog = int(input('Adja meg, hogy hány oldalú sokszöget rajzoljon ki a program: '))
fok = 360 / szog

lepes = 1
while lepes <= szog:
    turtle.forward(200)
    turtle.right(fok)
    lepes += 1
