# -----LISTAELEMEK OLVASÁSA-----
tantargyak = ['matek', 'töri', 'biosz', 'kémia', 'info']

# ---1. MEGOLDÁS---
index = 0
for tantargy in tantargyak:
    print(index, tantargy)
    index += 1
print('\n')


# ---2. MEGOLDÁS---
for index in range(len(tantargyak)):
    print(index, tantargyak[index])
print('\n')


# ---3. MEGOLDÁS---
for index, tantargy in enumerate(tantargyak):
    print(index, tantargy)
print('\n')


'''
Nem mindegy, hogyan járod be a listát!
A fentiekben bemutatott három lehetőség közül az I. és III. számú esetben a lista bejárása úgy történik, 
hogy az egyes elemek - minden egyes cikluslépésben - egy 'honap' nevű átmeneti változóba kerülnek kimásolásra, 
és ezt használjuk fel a print utasításban. Ha módosítani szeretnéd a listaelemet 
(pl. nagybetűsre alakítani) akkor hiába tennéd ezt meg a 'honap' nevű változó esetében, 
ez az eredeti listaelemet NEM módosítaná! 
Így ez a bejárás csak az adatok olvasására alkalmas! 
'''
honapok = ['január', 'február','március', 'április', 'május', 'június']

for honap in honapok:
    honap = honap.upper()  # az eredeti listaelem NEM módosul!
    print(honap)
print()
print(honapok)
print('\n')


'''
Ha módosítani szeretnéd a listaelemeket, akkor II. számú esetet kell mintaként venned! 
Ebben az esetben ugyanis az index segítségével közvetlenül az eredeti listaelemre hivatkozunk, így akár módosíthatjuk is azt!
'''
for index in range(len(honapok)):
    honapok[index] = honapok[index].upper()  # az eredeti listaelem módosul!
print(('\n').join(honapok))
print('\n\n')



# -----RANGE()-----
for szam in range(0, 11, 2):
    print(szam)