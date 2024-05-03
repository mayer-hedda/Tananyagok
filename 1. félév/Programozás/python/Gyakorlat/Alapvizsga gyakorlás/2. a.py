'''
Írj egy Python programot, amely megmondja előfordul-e (igen/nem) a Pécs szó a
temp.txt fájlban!
'''
szavak = []
with open('temp.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        szavak.append(sor.strip())

for szo in szavak:
    if szo == 'Pécs':
        print('A fájl tartalmazza a Pécs szót.')
    else:
        print('A fájl nem tartalmazza a Pécs szót.')