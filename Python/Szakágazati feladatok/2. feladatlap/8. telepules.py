with open('telepules.txt', 'w', encoding='utf-8') as fajl:
    bekert_adatok = []
    szamlalo1 = 1
    while len(bekert_adatok) != 5:
        telepules = input(f'Adja meg a(z) {szamlalo1}. település nevét: ')
        lakosok = int(input('Adja meg a település lakosainak számát: '))
        print()
        adat = {
            'telepules': telepules,
            'lakosok': lakosok
        }
        bekert_adatok.append(adat)
        szamlalo1 += 1
    szamlalo2 = 1
    for adat in bekert_adatok:
        fajl.write(f'{szamlalo2}. település:')
        fajl.write(f'\n\tNév: {adat["telepules"]}\n\tLakosok száma: {adat["lakosok"]}\n\n')
