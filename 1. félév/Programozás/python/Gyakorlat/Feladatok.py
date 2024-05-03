def konverter(szoveg, tipus):
    if tipus == "int":
        while True:
            szam = input(szoveg)

            try:
                szam = int(szam)
                return szam
            except ValueError:
                print('Nem számot adtál meg!')
    elif tipus == "float":
        while True:
            szam = input(szoveg)

            try:
                szam = float(szam)
                return szam
            except ValueError:
                print('Nem számot adtál meg!')


def feladat_1():
    '''
    Egy sebességmérő műszer regisztrálja minden mellette elhaladó jármű sebességét km/h-ban.
    Az egyik irányba haladó járművek sebességét pozitív, a másik irányba (szembe) haladókét negatív értékként tárolja a műszer.
    Készítsen programot, amely lehetővé teszi, hogy a műszer által regisztrált adatokat billentyűzeten keresztül számítógépre vigyük!
    A sebességadatokat (max. 100 db) a seb nevű tömbben tároljuk. Az adatok megadásának végét a 0 értékkel jelöljük.
    A program az adatsor végére tárolja el ezt a „0” értéket is!
    Az adatok eltárolása után a program határozza meg, hogy milyen átlagsebességgel haladtak a járművek az egyik, illetve a másik irányba!
    A meghatározott eredményt (illetve eredményeket) írja ki a képernyőre!
    '''
    seb = []

    while True:
        adat = konverter("Adja meg a sebességet: ", "float")
        seb.append(adat)

        if adat == 0 or len(seb) == 100:
            # seb.append(adat)
            break


    egyik_irany = []
    masik_irany = []

    for adat in seb:
        if adat < 0:
            egyik_irany.append(abs(adat))
        elif adat > 0:
            masik_irany.append(adat)

    egyik_atlag = sum(egyik_irany) / len(egyik_irany)
    masik_atlag = sum(masik_irany) / len(masik_irany)


    print(f'Az egyik irányba haladó autók átlagsebessége: {egyik_atlag:.2f}\nA másik irányba haladó autók átlagsebessége: {masik_atlag:.2f}')



def feladat_2():
    '''
    Sík felületek (pl. fürdőszobák, konyhák stb. padlózatának) burkolását Géza mester a felület nagyságánál 20%-kal több felületet lefedő burkolólap felhasználásával vállalja.
    Készítsen programot, mely billentyűzetről beolvassa egy helyiség alapterületét, valamint a választott (téglalap alakú) burkolólap szélességét és hosszúságát,
    majd megadja, hogy hány darab burkolólapra van szüksége Géza mesternek a munka elvégzéséhez! A szükséges darabszámot a program írja ki a képernyőre!

    Megjegyzés: A program feltételezze, hogy a szélességek és hosszúságok megadásánál azonos mértékegységet, a métert használjuk!
    Terület megadásánál pedig feltételezzük, hogy az négyzetméterben lett megadva.
    Egy téglalap alakú terület felszínét a hosszúság x szélesség képlettel számítsa ki a program!
    Egy adott területnél 20%-kal nagyobb felületű terület mértékét a program oly módon határozza meg, hogy az eredeti terület értéket 1,2-vel megszorozza!
    A területek kiszámításánál, az egész típusnál nagyobb számítási pontosságot lehetővé tévő típust használjon a program!
    A konkrét lefedést nem kell modelleznie, csak az anyagszükségletet kell kiszámítani!
    '''
    print("Adjon meg pár adatot a burkolandó helyiségről (ügyeljen arra, hogy azonos mértékegységet használjon az összes adatnál): \n")

    alapterulet = konverter("Adja meg a helyiség alapterületét: ", "int")
    burkololap_szelessege = konverter("Adja meg a burkolólap szélességét: ", "int")
    burkololap_hosszusaga = konverter("Adja meg a burkolólap hosszúságát: ", "int")

    szamitas = (alapterulet * 1.2) / (burkololap_szelessege * burkololap_hosszusaga)

    if szamitas % 1 == 0:
        print(f'Géza mesternek {szamitas} db járólapra lesz szüksége a munkához.')
    else:
        print(f'Géza mesternek {int(szamitas) + 1} db járólapra lesz szüksége a munkához.')


def feladat_3():
    from random import choice, randint
    '''
    Készítsen programot, amely letárolja a felhasználó által begépelt szavakat egy fájlba.
    Az adatbevitel után véletlenszerűen válasszon ki szavakat és írja ki a képernyőre.
    (A program a korábban letárolt adatok alapján újabb adatbevitel nélkül is generáljon szókapcsolatokat)
    '''
    szavak = []

    with open("szavak.txt", "w", encoding="utf-8") as file:

        while True:
            szo = input("Adja meg az eltárolni kívánt szót: ")
            szavak.append(szo)
            if szo == "":
                break


def feladat_4():
    '''
    Egy héten keresztül minden nap délben megmértük a hőmérsékletet az udvaron.
    Készítsen programot, ami a mért értékeket beolvassa (hétfőtől kezdve vasárnapig bezárólag) és tárolja egy tömbben!
    '''
    meresek = []

    napok = ["hétfőn", "keddn", "szerdán", "csütörtökön", "pénteken", "szombaton", "vasárnap"]
    for nap in napok:
        meres = konverter(f'Adja meg a {nap} mért hőmérsékletet: ', "float")
        meresek.append(meres)

    # a. Rajzoltassa ki a 'teknős'-sel az értékeket oszlopdiagramon és írja rá az adott értéket.

    # b. Számolja ki az átlaghőmérsékletet és írassa ki a képernyőre.
    atlaghomerseklet = sum(meresek) / len(meresek)
    print(f'Az adatok alapján az átlaghőmérséklet {atlaghomerseklet} fok.')

    # c. Válassza ki a legmagasabb és legalacsonyabb hőmérsékletet, majd írassa ki a képernyőre mely napokon voltak.
    legmagasabb = min(meresek)
    legmagasabb_index = 0
    legalacsonyabb = max(meresek)
    legalacsonyabb_index = 0
    for index, meres in enumerate(meresek):
        if meres > legmagasabb:
            legmagasabb = meres
            legmagasabb_index = index
        elif meres < legalacsonyabb:
            legalacsonyabb = meres
            legalacsonyabb_index = index

    print(f'{napok[legalacsonyabb_index]} volt a legalacsonyabb a hőmérséklet ({legalacsonyabb} fok).')
    print(f'{napok[legmagasabb_index]} volt a legmagasabb a hőmérséklet ({legmagasabb} fok).')


def maradek_ellenor(maradek, szotar, index, string):
    if maradek // (szotar[list(szotar.keys())[index]] - szotar[list(szotar.keys())[index + 1]]) == 1:
        string += list(szotar.keys())[index + 1]
        string += list(szotar.keys())[index]
    elif maradek // (szotar[list(szotar.keys())[index]] - szotar[list(szotar.keys())[index + 2]]) == 1:
        string += list(szotar.keys())[index + 2]
        string += list(szotar.keys())[index]
    return string


def feladat_5():
    '''
    Készítsen programot, amely bekér egy számot és átalakítja Római számmá!

    Római számjegyek
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1000
    Az adott számjegy előjele akkor negatív, ha az utána következő számjegy nála nagyobb.
    Az utolsó számjegyérték mindenképpen pozitív.
    '''
    while True:
        szam = konverter("Adjon meg egy egész számot: ", "int")
        if szam > 3999:
            print("Ezt a számot nem lehet római számmá alakítani!")
        else:
            break
    romai_szamok = {
        "M": 1000,
        "D": 500,
        "C": 100,
        "L": 50,
        "X": 10,
        "V": 5,
        "I": 1
    }
    romai_szam = ""

    ezer, maradek = divmod(szam, romai_szamok["M"])
    romai_szam += list(romai_szamok.keys())[0] * ezer
    maradek_ellenor(maradek, romai_szamok, 0, romai_szam)

    otszaz, maradek = divmod(maradek, romai_szamok["D"])
    romai_szam += list(romai_szamok.keys())[1] * otszaz
    maradek_ellenor(maradek, romai_szamok, 1, romai_szam)

    szaz, maradek = divmod(maradek, romai_szamok["C"])
    romai_szam += list(romai_szamok.keys())[2] * szaz
    maradek_ellenor(maradek, romai_szamok, 2, romai_szam)

    otven, maradek = divmod(maradek, romai_szamok["L"])
    romai_szam += list(romai_szamok.keys())[3] * otven
    maradek_ellenor(maradek, romai_szamok, 3, romai_szam)

    tiz, maradek = divmod(maradek, romai_szamok["X"])
    romai_szam += list(romai_szamok.keys())[4] * tiz
    maradek_ellenor(maradek, romai_szamok, 4, romai_szam)

    ot, maradek = divmod(maradek, romai_szamok["V"])
    romai_szam += list(romai_szamok.keys())[5] * ot
    maradek_ellenor(maradek, romai_szamok, 5, romai_szam)

    romai_szam += list(romai_szamok.keys())[6] * maradek

    print(romai_szam)



# feladat_1()
# feladat_2()
# feladat_3()
# feladat_4()
feladat_5()