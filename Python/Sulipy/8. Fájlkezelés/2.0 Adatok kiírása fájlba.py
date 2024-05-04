# -----MEGNYITÁSI MÓDOK-----
# r: olvasás
# w: írás, fájlt hoz létre; ha léztezik ilyen nevű fájl már, felülírja az eredetit
# x: írás, fájlt hoz létre; ha léztezik ilyen nevű fájl már, hibát ad
# a: a létező fájl végére hozzáfűz, ha még nem létezik ilyen nevű, akkor létrehozza
# a+: hozzáfűzést és olvasást is lehetővé tesz

# with open('2.0 Adatok kiírása fájlba.txt', 'r', encoding='utf-8') as fajl, \
#         open('2.0 Adatok kiírása fájlba masolat.txt', 'w', encoding='utf-8') as masolat:

with open('2.0 Adatok kiírása fájlba.txt', 'r', encoding='utf-8') as fajl:
    # print('Ez kerül mentésre!!!', file=fajl)  # mindig a fájl végére ír
    # fajl.seek(0)
    # print(fajl.readline())
    # print(fajl.tell())
    # print('Ez kerül mentésre!!!', file=fajl, flush=True)  # általában utoljára végzi a program ezt a sort, de a flush=True miatt most az input előtt
    # input('> ')
    # fajl.write('a')  # stringet ír a fájlba
    # fajl.write('b')
    # fajl.writelines(['alma\n', 'körte\n'])  # lista elemeit írja a fájlba
    # fajl.flush()  # ez a sor ugyanazt eredményezi, mint a flush=True
    with open('2.0 Adatok kiírása fájlba masolat.txt', 'w', encoding='utf-8') as masolat:  # létrehozok egy másolatot, ahova átmásolom az eredeti fájl tartalmát
        for sor in fajl:
            print(sor.strip(), file=masolat)



# -----BINÁRIS FÁJL BEOLVASÁSA-----

with open('2.0 Adatok kiírása fájlba.jpg', 'rb') as eredeti:
    with open('2.0 Adatok kiírása fájlba másolat.jpg', 'wb') as masolat:
        darab_meret = 4096
        darab = eredeti.read(darab_meret)

        while len(darab) > 0:
            masolat.write(darab)
            darab = eredeti.read(darab_meret)