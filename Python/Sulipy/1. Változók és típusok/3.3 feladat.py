'''
Írj egy programot, ami bekér egy számot a felhasználótól,
és valamilyen matemataikai műveletek sorozataként generál
és kiír a felhasználónak egy szerencseszámot!
'''
bekert_szam = int(input('Adjon meg egy számot: '))

szerencseszam = ((bekert_szam * 3) + (bekert_szam**2)) / 8

print(f'Az Ön szerencseszáma: {szerencseszam:.0f}')