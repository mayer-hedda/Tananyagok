'''
Adott két függvény (y=2x+3 és y=3x+1), mindkettő értelmezési tartománya az egész számok [0;10] intervallumon.
A program készítsen egy-egy halmazt a függvények értékkészleteivel,
írja ki ezeket a képernyőre, majd jelenítse meg a halmazok metszetét, unióját és különbségét!
'''
fuggveny1 = set()
for x in range(11):
    fuggveny1.add(2 * x + 3)

fuggveny2 = set()
for x in range(11):
    fuggveny2.add(3 * x + 1)

print('Az első függvény értékkészlete:', ', '.join(str(szam) for szam in fuggveny1))
print('Az második függvény értékkészlete:', ', '.join(str(szam) for szam in fuggveny2))

print('A két halmaz metszete:', ', '.join(str(szam) for szam in (fuggveny1 & fuggveny2)))
print('A két halmaz uniója:', ', '.join(str(szam) for szam in (fuggveny1 | fuggveny2)))
print('A két halmaz különbsége (ami csak az első függvényben van benne):', ', '.join(str(szam) for szam in (fuggveny1 - fuggveny2)))
print('A két halmaz különbsége (ami csak az második függvényben van benne):', ', '.join(str(szam) for szam in (fuggveny2 - fuggveny1)))