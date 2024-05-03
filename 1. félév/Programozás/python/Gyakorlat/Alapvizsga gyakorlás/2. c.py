'''
Írj egy Python programot, amely a temp.txt szöveges fájl minden második szavát
(szóközzel elválasztott részsztringjét) a képernyőre írja!
'''
szavak = []
with open('temp.txt', 'r', encoding='utf-8') as fajl:
    for sor in fajl:
        szavak.append(sor.strip())

for i, szo in enumerate(szavak):
    if i % 2 == 1:
        print(szo)