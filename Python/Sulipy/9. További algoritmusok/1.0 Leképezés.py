# -----TÍPÚS ÁTALAKÍTÁS-----

sebessegek = ['12.3', '31.7', '28.4', '9.0']

# for-ciklus
atvaltott = []
for sebesseg in sebessegek:
    atvaltott.append(float(sebesseg))
print(f'{atvaltott = }')

# listaértelmezés
atvaltott = [float(sebesseg) for sebesseg in sebessegek]
print(f'{atvaltott = }')

# map(fgv, tarolo)
atvaltott = list(map(float, sebessegek))
print(f'{atvaltott = }')
print('\n\n')



# -----BETŰ VÁLTÓ-----

# lower(), upper(), capitalize(), swapcase()
eredmeny = 'ALMA'.lower()                   # kisbetűssé alakítja az egész szót
print(eredmeny)

eredmeny = 'ALMA'.upper()                   # nagybetűssé alakítja az egész szót
print(eredmeny)

eredmeny = 'ALMA'.capitalize()              # az első betűt alakítja nagybetűvé, a többit kicsivé
print(eredmeny)

eredmeny = 'AlMa'.swapcase()                # a kisbetűket naggyá, a nagybetűket kicsivé alakítja
print(eredmeny)

# isupper(), islower(), isalpha(), isdecimal()
eredmeny = 'AlMa'.isupper()                # True: ha minden eleme nagybetű
print(eredmeny)

eredmeny = 'AlMa'.islower()                # True: ha minden eleme kisbetű
print(eredmeny)

eredmeny = 'alma1'.isalpha()                # True: ha minden eleme az abc betűiből áll
print(eredmeny)

eredmeny = '321'.isdecimal()                # True: ha minden eleme szám
print(eredmeny)
print('\n')



def atvalto(szo):
    return szo.lower()


gyumolcsok = ['ALMA', 'KÖRTE', 'EPER', 'BANÁN']

# map()
atvaltott = list(map(atvalto, gyumolcsok))
print(f'{atvaltott = }')

# for-ciklus
atvaltott = []
for gyumolcs in gyumolcsok:
    atvaltott.append(gyumolcs.lower())
print(f'{atvaltott = }')

# listaértelmezés
atvaltott = [gyumolcs.lower() for gyumolcs in gyumolcsok]
print(f'{atvaltott = }')