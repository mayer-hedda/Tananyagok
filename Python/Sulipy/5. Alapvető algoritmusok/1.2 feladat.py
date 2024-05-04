'''
Írj egy programot, amely a felhasználótól kér be egész számokat
[-5;5] intervallumban. A bekérés akkor fejeződjön be,
amikor a felhasználó intervallumon kívüli értéket ad meg!
A program írja ki a megadott intervallumba eső számokat és az összegüket!
'''
megadott_szamok = []

while True:
    szam = int(input('Adjon meg egy számot -5 és 5 között: '))
    if szam < -5 or szam > 5:
        break
    else:
        megadott_szamok.append(szam)

osszeg = 0
for szam in megadott_szamok:
    osszeg += szam

print('Az Ön által megadott számok:', ', '.join(str(szam) for szam in megadott_szamok))
print(f'Az Ön által megadott számok összege: {osszeg}')