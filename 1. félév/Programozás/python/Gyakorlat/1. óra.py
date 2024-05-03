# ---- VÁLTOZÓK ----

uzenet = "Mi újság?"  # string
n = 17  # integer
pi = 3.14159  # float


int(3.14)  # típúskonverziós függvény
int(3.9999)  # nem kerekít, csak a meglévő egészet adja vissza (itt: 3)
int(3.0)  # 3
int(-3.9999)  # az eredmény a 0-hoz esik közelebb (itt: -3)
int(600 / 60)  # 10
int("2345")  # stringet alakít egész számmá
int(17)  # akkor is működik, ha a szám eredetileg is egész

float(17)  # 17.0
float("123.45")  # 123.45

str(17)  # "17"
str(123.45)  # "123.45"



# ---- ERROROK ----

# uzenet - 1  # TypeError: unsupported operand type(s) for -: 'str' and 'int'
# "Szia" / 123  # TypeError: unsupported operand type(s) for /: 'str' and 'int'
# uzenet * "Szia"  # TypeError: can't multiply sequence by non-int of type 'str'
# "15" + 2  # TypeError: can only concatenate str (not "int") to str



# ---- STRINGEK ----

izesites = "lekváros"
pekaru = " bukta"
print(izesites + pekaru)  # "lekváros bukta"



# ---- ADATBEKÉRÉS ----

# bemenet = input("Mekkora a kör sugara? ")
# sugar = float(bemenet)
sugar = float(input("Mekkora  akör sugara? "))
terulet = 3.14159 * sugar**2

print("A terület", terulet)
# print("A terület", 3.14159 * sugar**2)
# print("A terület", 3.14159 * float(input("Mekkora  akör sugara? "))**2)



# ---- MATEMATIKAI MŰVELETEK ----

e = 7 // 3  # egész osztás (eredmény: 2)
m = 7 % 3  # mradékos osztás (eredmény: 1)


osszes_masodperc = int(input("Összesen hány másodperc? "))
orak = osszes_masodperc // 3600
megmaradt_masodpercek = osszes_masodperc % 3600
percek = megmaradt_masodpercek // 60
megmaradt_masodpercek_a_vegen = megmaradt_masodpercek % 60

print("Órák", orak, " Percek", percek, " Másodpercek =", megmaradt_masodpercek_a_vegen)



# ---- FOR CIKLUS ----

for b in ["Misi", "Petra", "Botond", "Jani", "Csilla", "Peti", "Norbi"]:
    meghivas = "Szia, " + b + "! Kérlek gyere el a bulimba szombaton!"
    print(meghivas)