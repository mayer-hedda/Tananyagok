while True:
    szam = int(input('Adjon megy egy tetszőleges hosszúságot cm-ben: '))
    if szam < 1000 or szam > 10000:
        print('Intervallumon kívüli számot adott meg!')
    else:
        break

szam = str(szam)
if len(szam) == 5:
    print(f'A megadott hossz {szam} {szam[0]}{szam[1]} km-nek, {szam[2]} m-nek, {szam[3]} dm-nek és {szam[4]} cm-nek felel meg')
else:
    print(f'A megadott hossz {szam} {szam[0]} km-nek, {szam[1]} m-nek, {szam[2]} dm-nek és {szam[3]} cm-nek felel meg')