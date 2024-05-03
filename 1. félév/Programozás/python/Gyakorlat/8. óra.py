# ----- OSZTÁLYOK ÉS OBJEKTUMOK -----

# --- 1. példa ---
class Pont:
    """A Pont osztály (x, y) koordinátáinak reprezentálására és manipulálására. """

    def __init__(self, x = 0, y = 0):
        """ Egy új, origóban álló pont létrehozása. """
        self.x = x
        self.y = y

    def origotol_mert_tavolsag(self):
        """ Az origótól mért távolság számítása. """
        return ((self.x ** 2) + (self.y ** 2)) ** 0.5

    def sztringge_alakitas(self):
        return "({0}, {1})".format(self.x, self.y)

    def __str__(self):  # A metódus átnevezése az egyetlen feladatunk
        return "({0}, {1})".format(self.x, self.y)

    def sulypont_szamitas(self, masik_pont):
        """ A súlypontom a másik ponttal. """
        mx = (self.x + masik_pont.x) / 2
        my = (self.y + masik_pont.y) / 2
        return Pont(mx, my)


p = Pont() # A Pont osztály egy objektumának létrehozása (példányosítás)
q = Pont() # Egy második Pont objektum készítése

# Minden Pont objektum saját x és y attribútumokkal rendelkezik
print(p.x, p.y, q.x, q.y)

p.x = 3
p.y = 4

print(p.y) # 4-et ír ki
x = p.x
print(x) # 3-at ír ki

print("(x={0}, y={1})".format(p.x, p.y))
origotol_mert_tavolsag_negyzete = p.x * p.x + p.y * p.y

p = Pont(4, 2)
q = Pont(6, 3)
r = Pont() # r az origót (0, 0) reprezentálja
print(p.x, q.y, r.x)


#tesztek
p = Pont(3, 4)
print(p.x)
print(p.y)
print(p.origotol_mert_tavolsag())

q = Pont(5, 12)
print(q.x)
print(q.y)
print(q.origotol_mert_tavolsag())

r = Pont()
print(r.x)
print(r.y)
print(r.origotol_mert_tavolsag())


def pont_kiiras(pt):
    print("({0}, {1})".format(pt.x, pt.y))

p = Pont(3, 4)
print(p.sztringge_alakitas())


#teszt
p = Pont(3, 4)
# Az str(p) kifejezés kiértékelésénél a Python az általunk írt
# __str__ metódust hívja meg.
print(str(p))
print(p)


def sulypont_szamitas(p1, p2):
    """ Visszatér a p1 és p2 pontok súlypontjával. """
    mx = (p1.x + p2.x)/2
    my = (p1.y + p2.y)/2
    return Pont(mx, my)

#teszt
p = Pont(3, 4)
q = Pont(5, 12)
r = sulypont_szamitas(p, q)
print(r)


#Példa a metódus felhasználása:
p = Pont(3, 4) # Az adott pont objektum
q = Pont(5, 12) # Egy másik pont objektum
r = p.sulypont_szamitas(q) # A súlypont számítása
print(r) # és megjelenítése





# --- 2. példa ---
class Teglalap:
    """ Egy osztály a téglalapok előállításához. """

    def __init__(self, poz, sz, m):
        """ Inicializálja a téglalapot a poz pozícióra
        sz szélességgel m magassággal. """
        self.csucs = poz
        self.szelesseg = sz
        self.magassag = m

    def __str__(self):
        return "({0}, {1}, {2})".format(self.csucs, self.szelesseg, self.magassag)

    def noveles(self, delta_szelesseg, delta_magassag):
        """ Növeli (vagy csökkenti) ezt az objektumot a delta értékekkel. """
        self.szelesseg += delta_szelesseg
        self.magassag += delta_magassag

    def mozgatas(self, dx, dy):
        """ Elmozdítja ezt az objektumot a delta értékekkel. """
        self.csucs.x += dx
        self.csucs.y += dy


teglalap = Teglalap(Pont(0, 0), 100, 200)
bomba = Teglalap(Pont(100, 80), 5, 10) # A videojátékomban.
print("teglalap: ", teglalap)
print("bomba: ", bomba)


r = Teglalap(Pont(10,5), 100, 50)
print(r)

r.noveles(25, -10)
print(r)

r.mozgatas(-10, 10)
print(r)


p1 = Pont(3, 4)
p2 = Pont(3, 4)
print(p1 is p2) # a kimenet False
p3 = p1
print(p1 is p3) # a kimenet True


def azonos_koordinatak(p1, p2):
    return (p1.x == p2.x) and (p1.y == p2.y)


p1 = Pont(3, 4)
p2 = Pont(3, 4)
egy_pont = azonos_koordinatak(p1, p2)
print(egy_pont)