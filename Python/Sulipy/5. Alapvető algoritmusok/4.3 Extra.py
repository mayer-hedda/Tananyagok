# Pythonban létezik a min() és max() beépített függvény,
# amely a paraméterként megadott értékek közül a legkisebb, ill. legnagyobb értékkel tér vissza.
# Paraméterként fogadhat összetett adattípust, pl. listát is.

print(max(17, 95, -2, 0, 34, 19))
print(min(17, 95, -2, 0, 34, 19))
print()


szamok = [17, 95, -2, 0, 34, 19]

print(max(szamok))
print(min(szamok))
print('\n')





# Ha sztringeket adunk meg, akkor az ABC sorrend számít,
# tehát a max() esetében az ABC sorrendben legutoljára szereplő sztringgel tér vissza.

print(max('szilva', 'eper', 'barack', 'banán'))
print()


szavak = ['szilva', 'eper', 'banán', 'barack', 'ananász', 'zsurló', 'alma']

print(min(szavak))
print(max(szavak))