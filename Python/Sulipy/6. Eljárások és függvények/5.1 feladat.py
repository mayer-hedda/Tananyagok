'''
Írj egy programot, amely a listában tárolt sztringeket a 2. betű alapján rendezi sorba lambda függvény segítségével.
'''
szavak = ['alma', 'körte', 'ananász', 'narancs', 'kiwi']

print(sorted(szavak, key=lambda szo: szo[1]))