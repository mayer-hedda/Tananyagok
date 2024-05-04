# -----HALMAZ BŐVÍTÉSE/TÖRLÉSE-----

reggeli = {'vaj', 'tea', 'pirítós'}  # halmaz megadása
reggeli.add('víz')  # elem hozzáadása
reggeli.pop()  # egy nem meghatározott elem eltávolítása
reggeli.remove('tea')  # elem törlése
# reggeli.remove('körte')  # olyan elem törlése, ami nincs a listában --> hibaüzeten
reggeli.discard('körte')  # olyan elem törlése, ami nincs a listában hibaüzenet nélkül --> nem történik változás

print(reggeli)
print('\n\n')



# -----(ÜRES) HALMAZ LÉTREHOZÁSA-----

ebed = set()  # üres halmaz létrehozésa
ebed2 = ['halászlé', 'kenyér', True, True]
ebed2 = set(ebed2)  # lista halmazzá alakítása

print(type(ebed))
print(ebed)
print(ebed2)
print('\n\n')



# -----HALMAZMŰVELETEK-----

reggeli = {'víz', 'tea', 'vaj', 'pirítós'}
ebed = {'víz', 'halászlé', 'kenyér'}

print(reggeli & ebed)  # két halmaz metszete
print(reggeli | ebed)  # két halmaz uniója
print(reggeli - ebed)  # két halmaz különbsége
print(reggeli ^ ebed)  # vagy csak az egyik vagy csak a másik halmaznak az eleme
print('\n\n')



# -----LISTA HALMAZZÁ ALAKÍTÁSA-----

gyumolcskosar = ['eper', 'alma', 'szilva', 'eper']

fajta = set()
for gyumolcs in gyumolcskosar:
    fajta.add(gyumolcs)

print(fajta)


gyumolcskosar = ['eper', 'alma', 'szilva', 'eper']
fajta = set(gyumolcskosar)

print(fajta)