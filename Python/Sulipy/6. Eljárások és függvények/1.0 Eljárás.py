# -----ELJÁRÁS (ELMÉLET)-----

# Eljárás
def menut_kiir():
    '''
    A menő megjelenítése a képernyőn
    '''
    print('1. Új adat bevitele')
    print('2. Adatok módosítása / törlése')
    print('3. Kilépés a programból')

# Eljárás hívása
menut_kiir()
print('\n')


# Eljárás 2
def menu_kiir(tipus):
    '''
    A menü megjelenítése a képernyőn
    '''
    if tipus == 2:
        print('1. Új adat bevitele')
        print('2. Kilépés a programból')
    if tipus == 3:
        print('1. Új adat bevitele')
        print('2. Adatok módosítása / törlése')
        print('3. Kilépés a programból')

# Eljárás hívása
menu_kiir(2)
print('\n')





# -----ELJÁRÁS (GYAKORLAT) 1-----
# ---ELSŐ---

def koszont():
    print('Üdv a fedélzeten!')

def koszont_nevvel(nev):
    print(f'Szia {nev}, üdv a fedélzeten!')

def koszont_ket_nevvel(nev1, nev2):
    print(f'Szia {nev1} és {nev2}, üdv a fedélzeten!')

koszont()
koszont_nevvel('Ádám')
koszont_ket_nevvel('Nóra', 'Ádám')
print('\n')


# ---MÁSODIK---

def osszead(x, y):
    eredmeny = x + y
    print(f'A két szám összege: {eredmeny}')

osszead(4, 7)

osszead(4+5, 7-1)

a = 6
b = 7
osszead(a, b)
print('\n')


# ---HARMADIK---

def osszegzo(list):
    osszesen = 0
    for szam in list:
        osszesen = osszesen + szam
    print('A listában lévő számok összege: ', osszesen)


szamok = [3, 5, 19, 11, 17, 1]
osszegzo(szamok)
print('\n')





# -----VÁLTOZÓK LÁTHATÓSÁGA-----

def kiir():
    lokalis = 'alma'
    print(lokalis)
    print(globalis)

globalis = 'gyümölcs'

kiir()
print(globalis)