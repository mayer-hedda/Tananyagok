# -----TUPLE-----
'''
A listához hasonlóan sorba rendezetten tartalmazza az elemeket, amelyek így index-szel rendelkeznek.
Lényeges különbség azonban, hogy ezek állandó adatszerkezetek, azaz a benne tárolt érték, azok száma, sorrendje nem változtatható meg.
Az elemek itt is vesszővel vannak elválasztva egymástól, de nem [ ], hanem ( ) jelek között.
'''

kepernyo_meret = (1920, 1080)



# -----SET(HALMAZ)-----
'''
A halmaz egy nem rendezett adatszerkezet. 
Az elemek nem rendelkeznek sorszámmal (index-szel). 
Egy elem csak egyszer szerepelhet benne { } jelek között. 
'''

buszjaratok = {'1', '12', '12E'}



# -----DICTIONARY(SZÓTÁR)-----
'''
Ezen gyűjtemény kulcs-érték (key-value) párokba rendezetten tárolja az adatokat. 
Az értékekre az egyedi kulcs alapján lehet hivatkozni. 
'''

hallgato = {
    'nev': 'Tamara',
    'kor': 25,
    'varos': 'Sopron'
}