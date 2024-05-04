'''
Írj egy programot, amely a fenti listából kiszűri az 'l' betűt tartalmazó szavakat kétféleképpen:
filter() + lambda függvény és list comprehension segítségével is!
'''
szavak = ['alma', 'ló', 'padló', 'citrom', 'kávé', 'nyugalom']

print(list(filter(lambda szo: 'l' in szo, szavak)))
print([szo for szo in szavak if 'l' in szo])