# -----BREAK-----
# A lista bejárásának megszakítása

szamok = [1,7,8,10,12,9,3]

for szam in szamok:
    if szam % 2 == 0:
        print('Megvan az első páros szám a listában:')
        print(szam)
        break             # megszakítja a lista bejárását
print('Program vége')
print('\n\n')




# -----CONTINUE-----
# A lista bejárását folytatja,
# de a ciklus belsejében a continue után lévő utasítások
# már nem hajtódnak végre a ciklus ezen fázisában.

szamok = [1,7,8,10,12,9,3]

print('Páratlan számok a listában:')
for szam in szamok:
    if szam % 2 == 0:
        continue
    print(szam)
print('Program vége')