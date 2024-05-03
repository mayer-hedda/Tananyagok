# ---- STRINGEK ----

# --- Első példa ---
string = 'Hello World!'

up = string.upper()
print(up)

low = string.lower()
print(low)


# --- Második példa ---
gyumolcs = 'banán'
print(gyumolcs[1])

lista = list(enumerate(gyumolcs))
print(lista)  # [(0, 'b'), (1, 'a'), (2, 'n'), (3, 'á'), (4, 'n')]

hossz = len(gyumolcs)
print(hossz)

print(gyumolcs[-1])  # utolsó karakter


# --- Harmadik példa ---
i = 0
while i < len(gyumolcs):
    karakter = gyumolcs[i]
    print(karakter)
    i += 1

for c in gyumolcs:
    print(c)


# --- Negyedik példa ---
elotag = 'Törp'
utotagok_listaja = ["erős", "költő", "morgó", "öltő", "papa", "picur", "szakáll"]

for utotag in utotagok_listaja:
    print(elotag + utotag)


# --- Ötödik példa ---
s = "A Karib-tenger kalózai"

print(s[0:1])  # A
print(s[2:14])  # Karib-tenger
print(s[15:22])  # kalózai


baratok = ["Misi","Petra","Botond","Jani","Csilla","Peti","Norbi"]

print(baratok[2:4])  # ['Botond', 'Jani']


# --- Hatodik példa ---
szo = input(f'Adjon meg egy gyümölcsöt: ')

if szo == "banán":
    print("Nem, nincs banánunk!")


if szo < "banán":
    print("A szavad, a(z) " + szo + ", a banán elé jön.")
elif szo > "banán":
    print("A szavad, a(z) " + szo + ", a banán után jön.")
else:
    print("Nem, nincs banánunk!")


# --- Hetedik példa ---
import sys

def teszt(sikeres_teszt):
    # Egy teszt eredményének megjelenítése
    sorszam = sys._getframe(1).f_lineno  # a hívó sorának száma
    if sikeres_teszt:
        msg = 'A(z) {0}. sorban álló teszt sikeres.'.format(sorszam)
    else:
        msg = 'A(z) {0}. sorban álló teszt SIKERTELEN.'.format(sorszam)
    print(msg)

def kereses(szoveg, k):
    # Megkeresi a k karaktert a szövegben (szoveg) és visszatér annak indexével.
	# A visszatérési érték -1, ha a k karakter nem szerepel a szövegben.
    i = 0
    while i < len(szoveg):
        if szoveg[i] == k:
            return i
        i += 1
    return -1

teszt(kereses("Informatika", "o") == 3)
teszt(kereses("Informatika", "I") == 0)
teszt(kereses("Informatika", "a") == 6)
teszt(kereses("Informatika", "x") == -1)
