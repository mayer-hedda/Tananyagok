'''
Készíts egy programot,
amely a felhasználó által megadott szót
csupa nagybetűs formában írja ki a képernyőre!
A megoldáshoz használd a sztringek upper() metódusát!
A használatáról itt tájékozódhatsz.

Készíts egy programot,
amely listaelemek leképezésével megvalósítja a következő funkciót:
egy szavakat tartalmazó lista elemeiből generál egy másik listát,
amelyben az eredeti szavak csupa nagybetűs formában szerepelnek!
A program írja ki az eredeti és a generált listát is a képernyőre!

Az előbbi programot módosítsd úgy,
hogy csak a 3 betűnél hosszabb szavak kerülnek átalakítva a másik listába!

Készíts egy programot,
amely sztringeket tartalmazó listaelemek leképezését valósítja meg.
A leképezéshez a sztringek metódusait ezen az oldalon
bemutató listából válassz egyet!
A program írja ki az eredeti és a generált listát is a képernyőre!
'''
szo = input('Adjon meg egy szót: ')

print(szo.upper())
print('\n\n')



szavak = ['autó', 'bicska', 'fa', 'szék', 'szekér', 'monitor']
nagybetus_szavak = [szo.upper() for szo in szavak if len(szo) > 3]

print(', '.join(szavak))
print(', '.join(nagybetus_szavak))
print('\n\n')



gyumolcsok = ['alma', 'körte', 'banán', 'mandarin', 'dinnye', 'narancs', 'barack']
masolat = [gyumolcs.replace('körte', 'kajszi') for gyumolcs in gyumolcsok]

print(gyumolcsok)
print(masolat)