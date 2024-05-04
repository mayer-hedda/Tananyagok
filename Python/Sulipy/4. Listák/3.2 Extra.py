sztring = 'aLmafA'

# Az első betűt nagybetűvé alakítja,
# de csak a kiírás erejéig, maga a sztring nem változik,
# hiszen a sztringek elemei nem változtathatóak meg!
print(sztring.capitalize(), '\n')


# Csupa nagybetűssé alakítja a sztringet
print(sztring.upper(), '\n')


# Csupa kisbetűssé alakítja a sztringet
print(sztring.lower(), '\n')


# Megszámolja, hányszor fordul elő a megadott karakter
print(sztring.count('a'), '\n')


# Megadja, hányadik indexű helyen fordul elő először a megadott karakter
print(sztring.find('a'), '\n')


#  True-val tér vissza, ha a sztring minden eleme kisbetű
print(sztring.islower(), '\n')


# True-val tér vissza, ha a sztring minden eleme nagybetű
print(sztring.isupper())