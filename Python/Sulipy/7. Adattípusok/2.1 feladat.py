'''
Írj egy programot, amely a felhasználótól bekéri egy kutya nevét, életkorát, fajtáját, és azt hogy rendelkezik-e érvényes oltással veszettség ellen!
Az adatokat tárolja a program szótárban, és írja ki a képernyőre az adatszerkezetet!
'''
kutya = {}

kutya['nev'] = input('Adja meg a kutya nevét: ')
kutya['eletkor'] = int(input('Adja meg a kutya életkorát: '))
kutya['fajta'] = input('Adja meg a kutya fajtáját: ')
kutya['ervenyes_oltas'] = True if input('Adja meg, hogy a kutya rendelkezik-e érvényes oltással veszettség ellen (igen/nem): ').lower() == 'igen' else False


print(kutya)