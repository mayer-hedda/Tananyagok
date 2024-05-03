# ---- VISSZATÉRÉSI ÉRTÉK ----

# --- Első példa ---
def terulet(sugar):
    b = 3.14159 * sugar**2
    return b


# --- Második példa ---
def abszolut_ertek(x):
    if x < 0:
        return -x
    else:
        return x

def abszolut_ertek_2(x):
    if x < 0:
        return -x
    return x

def rossz_abszolut_ertek(x):
    # amennyiben nincs más visszaadott érték, akkor minden Python függvény None-val tér vissza.
    if x < 0:
        return -x
    elif x > 0:
        return x


# --- Harmadik példa ---
def ketbetus_szo_keresese(szolista):
    for szo in szolista:
        if len(szo) == 2:
            return szo
    return ''

print(ketbetus_szo_keresese(['ez', 'egy', 'halott', 'papagáj']))
print(ketbetus_szo_keresese(['szeretem', 'a', 'sajtot']))


# --- Negyedik példa ---
def tavolsag(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    negyzetosszeg = dx**2 + dy**2
    eredmeny = negyzetosszeg**0.5
    return eredmeny

print(tavolsag(1, 2, 4, 6))



# --- Egységteszt ---
import sys

def teszt(sikeres_teszt):
    # Egy teszt eredményének megjelenítése
    sorszam = sys._getframe(1).f_lineno  # a hívó sorának száma
    if sikeres_teszt:
        msg = 'A(z) {0}. sorban álló teszt sikeres.'.format(sorszam)
    else:
        msg = 'A(z) {0}. sorban álló teszt SIKERTELEN.'.format(sorszam)
    print(msg)

def tesztkeszlet():
    # Az ehhez a modulhoz (fájlhoz) tratozó tesztkészlet futtatása
    teszt(abszolut_ertek(17) == 17)
    teszt(abszolut_ertek(-17) == 17)
    teszt(abszolut_ertek(0) == 0)
    teszt(abszolut_ertek(3.14) == 3.14)
    teszt(abszolut_ertek(-3.14) == 3.14)

tesztkeszlet()



# ---- FOR CIKLUS ----

# --- Első példa ---
for b in ['Misi', 'Petra', 'Botond', 'Jani', 'Csilla', 'Peti', 'Norbi']:
    meghivas = 'Szia, ' + b + '! Kérlek gyere el a bulimba szombaton!'
    print(meghivas)


# --- Második példa ---
def sajat_osszeg(xs):
    # Az xs listaelemeinek összegzése és az eredmény visszaadása
    futo_osszeg = 0
    for x in xs:
        futo_osszeg += x
    return futo_osszeg

teszt(sajat_osszeg([1, 2, 3, 4]) == 10)
teszt(sajat_osszeg([1.25, 2.5, 1.75]) == 5.5)
teszt(sajat_osszeg([1, -2, 3]) == 2)
teszt(sajat_osszeg([ ]) == 0)
teszt(sajat_osszeg(range(11)) == 55)



# --- WHILE UTASÍTÁS ----

# --- Első példa ---
def osszeg_eddig(n):
    # Számsorozat összege 1 + 2 + 3 + ... + n
    ro = 0
    e = 1
    while e <= n:
        ro += e
        e += 1
    return ro

teszt(osszeg_eddig(4) == 10)
teszt(osszeg_eddig(1000) == 500500)


# --- Második példa ---
def sor3np1(n):
    # Kiírja a 3n + 1 sorozatot n-től amíg el nem éri az 1-et
    while n != 1:
        print(n, end=", ")
        if n % 2 == 0:
            n = n // 2
        else:
            n = n * 3 + 1
    print(n, end=".\n")


# --- Harmadik példa ---
def szamjegy_szam(n):
    szamlalo = 0
    while n != 0:
        szamlalo += 1
        n = n // 10
    return szamlalo

print(szamjegy_szam(710))  # 3


# --- Negyedik példa ---
for x in range(13):
    print(x, '\t', 2**x)



# ---- BREAK UTASÍTÁS ----

# --- Első példa ---
for i in [12, 16, 17, 24, 29]:
    if i % 2 == 1:  # Ha a szám páratlan...
        break  # ... azonnal hagyd el a ciklust
    print(i)
print('Kész.')


# --- Második példa ---
osszeg = 0
while True:
    bemenet = input('Add meg a köetkező számot! (Hagyd üresen a befejezéshez)')
    if bemenet == '':
        break
    osszeg += int(bemenet)
print('Az általad megadott számok összege: ', osszeg)


# --- Harmadik példa ---
import random

vel = random.Random()
szam = vel.randrange(1, 1000)

tippszam = 0
uzenet = ''

while True:
    tipp = int(input(uzenet + '\nTaláld ki az 1 és 1000 közötti számot, amire gondoltam: '))
    tippszam += 1
    if tipp > szam:
        uzenet += str(tipp) + 'túl nagy!\n'
    elif tipp < szam:
        uzenet += str(tipp) + 'túl kicsi!\n'
    else:
        break

input('\n\nNagyszerű, kitaláltad {0} tipp segítségével!\n\n'.format(tippszam))



# ---- CONTINUE UTASÍTÁS ----

for i in [12, 16, 17, 24, 28, 30]:
    if i % 2 == 1:  # Ha a szám páratlan...
        continue  # ...ne dolgozd fel!
print('Kész!')



# ---- ÉRTÉKPÁR ---

szuletesi_ev = ('Paris Hilton', 1981)

celebek = [("Brad Pitt", 1963), ("Jack Nicholson", 1937), ("Justin Bieber", 1994)]
print(celebek)
print(len(celebek))

for (nev, ev) in celebek:
    if ev < 1980:
        print(nev)



# ---- BEÁGYAZOTT CIKLUS BEÁGYAZOTT ADATOKHOZ ----

hallgatok = [
    ("Jani", ["Informatika", "Fizika"]),
    ("Kata", ["Matematika", "Informatika", "Statisztika"]),
    ("Peti", ["Informatika", "Könyvelés", "Közgazdaságtan", "Menedzsment"]),
    ("Andi", ["Információs rendszerek", "Könyvelés", "Közgazdaságtan", "Vállalkozási jog"]),
    ("Linda", ["Szociológia", "Közgazdaságtan", "Jogi ismeretek", "Statisztika", "Zene"])
]

for (nev, targyak) in hallgatok:
    print(nev, ' felvett ', len(targyak), ' kurzust.')


szamlalo = 0
for (nev, targyak) in hallgatok:
    for t in targyak:
        if t == 'Informatika':
            szamlalo += 1

print(f'Az informatikát felvett hallgatók száma: {szamlalo}')
