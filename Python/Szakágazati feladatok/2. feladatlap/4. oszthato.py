szamok = []
while len(szamok) != 2:
    szam = int(input(f'Adja meg a(z) {len(szamok) + 1}. számot: '))
    if szam == 0:
        print('Nem adhat meg nullát.\n')
    else:
        szamok.append(szam)

legnagyobb = max(szamok)
legkisebb = min(szamok)
if legnagyobb == legkisebb:
    print('A két szám egyenlő.')
else:
    hanyszor, maradek = divmod(legnagyobb, legkisebb)
    if maradek > 0:
        print(f'{hanyszor}x van meg a nagyobb szám a kisebb számban és {maradek} a maradék.')
    else:
        print(f'{hanyszor}x van meg a nagyobb szám a kisebb számban maradék nélkül.')