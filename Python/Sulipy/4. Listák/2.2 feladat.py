'''
Az adott lista (amely a 'Próbáld ki!' gombra kattintva elérhető) elemei közül a program kiírja a "t" és "T" betűkkel kezdődőeket!

Az előző programot alakítsd át úgy, hogy a feltételeknek megfelelő szavak kerüljenek rögzítésre egy másik listában is,
és ez utóbbi listát írja ki a program a képernyőre!
'''
szavak = ['ajtó', 'tojás', 'Ottó', 'Tamás', 'tép', 'Tesla', 'alma', 'python']
t_szavak = []

for szo in szavak:
    if szo[0] == 't' or szo[0] == 'T':
        # print(szo)
        t_szavak.append(szo)

print(('\n').join(t_szavak))