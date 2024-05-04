from pprint import pp, PrettyPrinter, pformat

adatok = {
    'diakok': [
        {
            'nev': 'Kiss Péter',
            'e-mail': ['kiss@suli.hu', 'petike@otthoni.hu'],
            'cím': {
                'varos': 'Sopron',
                'kozterulet': 'Fő utca',
                'hazszam': 7
            },
            'kollegista': True
        },
        {
            'nev': 'Nagy Zoé',
            'e-mail': None,
            'cím': {
                'varos': 'Sopron',
                'kozterulet': 'Petőfi tér',
                'hazszam': 3
            },
            'kollegista': False
        }
    ]
}

pp(adatok, depth=4, indent=3, sort_dicts=False, width=5)


pp1 = PrettyPrinter(depth=2)
pp2 = PrettyPrinter(depth=4)
pp1.pprint(adatok)
pp2.pprint(adatok)



szoveg = pformat(adatok['diakok'], sort_dicts=False)
eltavolitando_karakterek = ['{', '}', '[', ']', "'"]
for karakter in eltavolitando_karakterek:
    szoveg = szoveg.replace(karakter, '')

print(szoveg)