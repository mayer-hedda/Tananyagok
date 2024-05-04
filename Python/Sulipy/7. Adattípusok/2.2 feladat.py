'''
Írj egy programot, amely szótárban tárolja egy macska nevét, korát.
A felhasználónak legyen lehetősége megváltoztatni az egyik tárolt adatot.
A program írja ki a felhasználó választása alapján az egyik adatot, kérdezze meg,
mire módosítsa, végül írja ki a képernyőre a frissített adatszerkezetet!
'''
macska = {
    'nev': 'Maci',
    'kor': 3
}

print(f'Írja be annak az adatnak a sorszámát, amelyiket módosítani szeretné!\n\t1. Név: {macska["nev"]}\n\t2. Kor: {macska["kor"]}')
valtoztatas = input('Válasz: ').strip('.')

if valtoztatas == '1':
    macska['nev'] = input('Módosított név: ')
elif valtoztatas == '2':
    macska['kor'] = int(input('Módosított kor: '))

print(macska)