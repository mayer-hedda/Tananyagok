# ----- MODULOK -----

# --- RANDOM ---
# --- 1. példa ---
import random

# Létrehoz egy fekete doboz objektumot, amely véletlen számokat generál
rng = random.Random()

kocka_dobas = rng.randrange(1, 7)  # Vissza ad egy egész éréket, az 1, 2, 3, 4, 5, 6 számok egyikét
kesleltetes_masodpercben = rng.random() * 5.0


# --- 2. példa ---
r_paratlan = rng.randrange(1, 100, 2)


# --- 3. példa ---
kartyak = list(range(52))  # Egész számokat generál [0 .. 51] között, amely egy kártyacsomagot szimbolizál.
rng.shuffle(kartyak)  # Véletlenszerűen összekeveri a kártyákat.



# --- TIME ---
import time

def sajat_szum(xs):
    szum = 0
    for v in xs:
        szum += v
        return szum

sz = 10000000  # Legyen 10 millió eleme a listának
testadat = range(sz)

t0 = time.clock()
sajat_eredmeny = sajat_szum(testadat)
t1 = time.clock()
print("saját_eredmény = {0} (eltelt ido = {1:.4f} másodperc)".format(sajat_eredmeny, t1-t0))

t2 = time.clock()
gepi_eredmeny = sum(testadat)
t3 = time.clock()
print("gépi_eredmény = {0} (eltelt idő = {1:.4f} másodperc)".format(gepi_eredmeny, t3-t2))



# --- MATH ---
import math
print(math.pi)  # A pi konstans
print(math.e)  # A természetes logaritmus alap, Euler konstans
print(math.sqrt(2.0))  # A négyzetgyök függvény
print(math.radians(90))  # 90 fok konvertálása radiánra
print(math.sin(math.radians(90)))  # A sin(90)fok
print(math.asin(1.0) * 2)  # Az arcsin(1.0) kétszerese, megadja a pi-t



# --- SAJÁT MODULOK ---
# resztorles.py
def torol(poz, sor):
    return sor[:poz] + sor[poz+1:]

# import resztorles
# s = "Egy asztalt!"
# resztorles.torol(7, s)    --> 'Egy aszalt!'





# ----- NÉVTEREK -----

def f():
    n = 7
    print("n kiírása az f-ben:", n)

def g():
    n = 42
    print("n kiírása a g-ben:", n)

n = 11
print("n kiírása az f hívása előtt:", n)
f()
print("n kiírása az f hívása után:", n)
g()
print("n kiírása a g hívása után:", n)





# ----- ATTRIBÚTUMOK ÉS PONT OPERÁTOR -----

# Modul1.py
kerdes = "Mi a jelentése az Életnek, a Világegyetemnek 	és a Mindenségnek?"
valasz = 42

# Modul2.py
kerdes = "Mi a küldetésed?"
valasz = "Keresni a Szent Grált!"

# import Modul1
# import Modul2
#
# print(Modul1.kerdes)
# print(Modul2.kerdes)
# print(Modul1.valasz)
# print(Modul2.valasz)





# ----- IMPORT UTASÍTÁS HÁROM VÁLTOZATA -----

# --- 1. példa ---
import math
x = math.sqrt(10)


# --- 2. példa ---
from math import cos, sin, sqrt
y = sqrt(10)


# --- 3. példa ---
from math import *  # Importáljuk az összes azonosítót a math-ból és hozzáadjuk az aktuális névtérhez.
z = sqrt(10)  # Használjuk minősítés nélkül


# --- plusz ---
import math as m
print(m.pi)





# ----- FÁJLOK -----

# --- 1. példa ---
sajat_fajl = open("elso.txt", "w")
sajat_fajl.write("Az első Python fájlom!\n")
sajat_fajl.write("----------------------\n")
sajat_fajl.write("Helló, világ!\n")
sajat_fajl.close()

uj_kezelo = open("elso.txt", "r") # Nyisd meg a fájlt
while True:
    sor = uj_kezelo.readline() # Próbáld beolvasni a következő sort
    if len(sor) == 0: # Ha nincs több sor
        break # Hagyd el a ciklust
    # Most dolgozd fel az éppen aktuálisan beolvasott sort
    print(sor, end="")

uj_kezelo.close() # Zárd be a fájlt


# --- 2. példa ---
f = open("baratok.txt", "r")
xs = f.readlines()
f.close()

xs.sort()

g = open("rendezett.txt", "w")
for v in xs:
    g.write(v)
g.close()


# --- 3. példa ---
f = open("szoveg.txt")
tartalom = f.read()
f.close()

szavak = tartalom.split()
print("A fájl szavainak száma: {0}.".format(len(szavak)))


# --- 4. példa ---
f = open("szoveg.zip", "rb")
g = open("masolat.zip", "wb")

while True:
    buf = f.read(1024)
    if len(buf) == 0:
        break
    g.write(buf)

f.close()
g.close()





# ----- KÖNYVTÁRAK -----

fajl = open("/usr/share/dict/szavak", "r")
lista = fajl.readlines()
print(lista[:5])
# ['\n', 'egy\n', 'kettő\n', 'három\n', 'négy\n']





# ----- INTERNETRŐL VALÓ LETÖLTÉS -----

import urllib.request

url = "http://www.ict.ru.ac.za/Resources/cspw/thinkcspy3/thinkcspy3.pdf"
cel_fajlnev = "thinkcspy3.pdf"

urllib.request.urlretrieve(url, cel_fajlnev)
