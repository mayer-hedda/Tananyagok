adatok = []
with open('3.0 Szótár a gyakorlatban.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        adatok.append(sor.strip())

diakok = []

for adat in adatok:
    diak_adatok = adat.split()
    diak = {
        'vezeteknev': diak_adatok[0],
        'keresztnev': diak_adatok[1],
        'eletkor': int(diak_adatok[2]),
        'osztaly': diak_adatok[3],
        'kollegista': bool(int(diak_adatok[4]))
        }
    diakok.append(diak)


print(diakok)

'''
1. feladat
10.A osztályos tanulók neveinek kiírása
'''
print('\n-------------> 1. feladat <-------------')
print('10.A osztályos diákok: ')
for diak in diakok:
    if diak['osztaly'] == '10.A':
        print(f'{diak["vezeteknev"]} {diak["keresztnev"]} ')



'''
2. feladat
10.B osztályos tanulók kigyűjtése listába 
'''
print('\n-------------> 2. feladat <-------------')
print('10.B osztályos diákok listában')
osztaly_10B = [diak for diak in diakok if diak['osztaly'] == '10.B']
print(osztaly_10B)



'''
3. feladat
diákok életkotának átlga 
'''
print('\n-------------> 3. feladat <-------------')
osszeg = 0
for diak in diakok:
    osszeg += diak['eletkor']
atlag = osszeg / len(diakok)
print(f'A diákok átlag életkora: {atlag:.2f}')



'''
4. feladat
(egyik) legidősebb diák nevének és korának kiírása
'''
print('\n-------------> 4. feladat <-------------')
max_index = 0
max_kor = diakok[0]['eletkor']
for index, diak in enumerate(diakok):
    if diak['eletkor'] > max_kor:
        max_kor = diak['eletkor']
        max_index = index
print(f'A legidősebb diák \n\tkora: {max_kor} év\n\tneve: {diakok[max_index]["vezeteknev"]} {diakok[max_index]["keresztnev"]}')