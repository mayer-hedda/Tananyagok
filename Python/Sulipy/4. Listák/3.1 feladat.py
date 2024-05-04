'''
Készíts egy programot, amely a felhasználó által megadott mondatról a mondatvégi jel alapján eldönti milyen fajtájú!
(kijelentő, kérdő, felkiáltó / felszólító / óhatjtó)

Az előbbi programot módosítsd úgy, hogy újabb és újabb mondatot kérjen be a program
ak egy ENTER-t nem üt), majd ál(amig a felhasználó cslapítsa meg, és írja ki mineden egyes alkalommal a mondat fajtáját!
'''

while True:
    mondat = input('Adjon meg egy mondatot: ')
    if mondat == '':
        print('A program kilép!')
        break
    elif mondat[-1] == '.':
        print('Ez egy kijelentő mondat.')
    elif mondat[-1] == '?':
        print('Ez egy kérdő mondat.')
    elif mondat[-1] == '!':
        print('Ez egy felkiáltó/felszólító/óhajtó mondat.')
    else:
        print('Nem adott meg mondatvégi írásjelet.')