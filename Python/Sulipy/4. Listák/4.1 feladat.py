'''
A program tároljon egy listában színeket. Kérjen be a felhasználótól egy színt,
és állapítsa meg, hogy a megadott szín már szerepel-e az adott listában.
A vizsgálat eredményéről tájékoztassa a program a felhasználót,
és írja ki egymás mellé vesszővel elválasztva a lista által tartalmazott színeket!

Alakítsuk át az előbbi programot úgy, hogy a program arról adjon tájékoztatást,
hogy pontosan hányszor szerepel a felhasználó által megadott szín a listában!

Egészítsük ki az előbbi programot úgy, hogy a kiértékelést követően
a felhasználó által megadott szín kerüljön felvételre a listába,
és csak ezután történjen meg a lista tartalmának kiírása!
'''

paletta = ['kék', 'piros', 'fehér', 'fekete', 'zöld', 'sárga', 'barna', 'piros', 'fehér', 'szürke']

bekert_szin = input('Adjon meg egy színt: ')

if bekert_szin in paletta:
    print(f'Az Ön által megadott szín {paletta.count(bekert_szin)}x szerepel az eredeti palettában.')
else:
    print('Az Ön által megadott szín nem szerepel az eredeti palettában.')

paletta.append(bekert_szin)
print(', '.join(paletta))