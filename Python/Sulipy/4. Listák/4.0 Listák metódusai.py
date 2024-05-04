gyumolcsok = ['alma', 'körte', 'eper', 'szőlő']

# FÜGGVÉNY
len(gyumolcsok)

# METÓDUS
gyumolcsok.append('banán')



# -----LISTÁK METÓDUSAI-----

nyelvek = ['Python', 'C', 'C++', 'Java', 'Python']
web = ['HTML', 'CSS', 'JavaScript']


# RENDEZÉS:
nyelvek.sort()
print(nyelvek)

nyelvek.reverse()
print(nyelvek)

print('\n\n')


# KERESÉS:
print(nyelvek.index('Python'))

if 'C#' in nyelvek:
    print(nyelvek.index('C#'))

print(nyelvek.count('Python'))

print('\n\n')


# BŐVÍTÉS:
nyelvek.append('C#')
print(nyelvek)

nyelvek.insert(1, 'Java')
print(nyelvek)

nyelvek.extend(web)
print(nyelvek)

masolat = nyelvek.copy()
print(masolat)

print('\n\n')


# TÖRLÉS:
nyelvek.pop()
print(nyelvek)

nyelvek.pop(1)
print(nyelvek)

nyelvek.remove('Python')
print(nyelvek)

del nyelvek[0]
print(nyelvek)

nyelvek.clear()
print(nyelvek)